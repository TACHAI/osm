package com.chaoxing.osm.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.chaoxing.osm.bean.po.user.User;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * token下发
 * @ClassName TokenUtil
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-01-09
 */
@Service("TokenService")
public class TokenUtil {

    public  String  getToken(User user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 10*60* 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().withAudience(user.getId()+"").withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }


    public static String getTokenUserId(){
        String token = getRequest().getHeader("token"); // 从http请求头中取出token
        String userId = JWT.decode(token).getAudience().get(0);
        return userId;
    }

    /**
     * 获取request
     * @return
     */
    public static HttpServletRequest getRequest(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return  requestAttributes == null?null: requestAttributes.getRequest();
    }
}
