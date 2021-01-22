package com.chaoxing.osm.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.chaoxing.osm.bean.po.user.Unit;
import com.chaoxing.osm.bean.po.user.User;
import com.chaoxing.osm.common.BadRequestException;
import com.chaoxing.osm.service.user.IunitService;
import com.chaoxing.osm.service.user.IuserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @ClassName AuthenticationInterceptor
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-14 9:51
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    private IuserService userService;
    @Autowired
    private IunitService iunitService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object){
        String token = httpServletRequest.getHeader("Authorization");
        // 如果不是映射到方法直接通过
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method =handlerMethod.getMethod();
        // todo 研究一下
        //检查是否有passtoken注释，有则跳过认证
        if(method.isAnnotationPresent(PassToken.class)){
            PassToken passToken = method.getAnnotation(PassToken.class);
            if(passToken.required()){
                return true;
            }
        }
        // 获取token中的user  id
        String userId = null;
        // 检查有么有需要用户权限的注解
        if(method.isAnnotationPresent(UserLoginToken.class)){
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if(userLoginToken.required()){
                // 执行认证
                if(token == null){
                    throw new BadRequestException("无token,请重新登录");
                }

                try {
                    userId = JWT.decode(token).getAudience().get(0);
                }catch (JWTDecodeException j){
                    throw new RuntimeException("401");
                }

                User user = userService.selectById(Integer.parseInt(userId)).getData();
                if(user==null){
                    throw new BadRequestException("用户不存在，请重新登录");
                }
                // 验证token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                try {
                    jwtVerifier.verify(token);
                }catch (JWTVerificationException e){
                    throw new RuntimeException("401");
                }
                return true;
            }
        }

        //检查有没有添加权限
        if(method.isAnnotationPresent(AddPermission.class)){
            userId = JWT.decode(token).getAudience().get(0);
            if(userId == null){
                throw new BadRequestException("无token,请重新登录");
            }
            User user = userService.selectById(Integer.parseInt(userId)).getData();
            if(user==null){
                throw new BadRequestException("用户不存在，请重新登录");
            }

            AddPermission addPermission = method.getAnnotation(AddPermission.class);
            String permission =addPermission.value();
            if(StringUtils.isNotBlank(permission)){
                Unit unit =iunitService.selectByUUID(user.getUnitUuid()).getData();
                if(unit != null){
                    String apps = unit.getUnitApp();
                    if(apps.indexOf(permission)>0){
                        return true;
                    }else {
                        throw new BadRequestException("没有权限操作此方法");
                    }
                }
            }{
                throw new BadRequestException("没有权限操作此方法");
            }

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e)throws Exception {

    }
}
