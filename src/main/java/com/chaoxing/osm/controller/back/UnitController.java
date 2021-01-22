package com.chaoxing.osm.controller.back;

import com.chaoxing.osm.bean.po.user.Unit;
import com.chaoxing.osm.bean.vo.PageVO;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.security.UserLoginToken;
import com.chaoxing.osm.service.user.IunitService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UnitController
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-19 9:09
 */
@Api(tags = "UnitController|单位管理模块")
@RequestMapping("/api/back/unit/")
@RestController
public class UnitController {
   @Autowired
   private IunitService unitService;


   @ApiOperation("单位分页")
   @UserLoginToken
   @GetMapping("listByPage")
   public PageVO list(@RequestParam(value = "pageSize",defaultValue = "5")int pageSize, @RequestParam(value = "pageNumber",defaultValue = "1")int pageNumber){

      Page page = PageHelper.startPage(pageNumber,pageSize);
      //recommend 100是banner 推荐200
      List<Unit> list =  unitService.selectAll().getData();
      if(list !=null){
         Long total = page.getTotal();
         PageVO p =new PageVO();
         p.setTotal(total);
         p.setRows(list);
         return p;
      }
      return null;
   }



   @ApiOperation("新增单位")
   @UserLoginToken
   @PostMapping("addUnit")
   public ServerResponse<String> addUnit(Unit unit){
      return unitService.addUnit(unit);
   }

   @ApiOperation("删除单位")
   @UserLoginToken
   @GetMapping("delUnit")
   public ServerResponse<String> delUnit(@Validated @NotNull(message="单位id不能为空")@RequestParam("id") Integer id){
      return unitService.deleteUnitById(id);
   }

   @ApiOperation("修改单位")
   @UserLoginToken
   @PostMapping("updateUnit")
   public ServerResponse<String> updateUnit(Unit unit){
      return unitService.updateUnit(unit);
   }

   @ApiOperation("根据uuid查询")
   @UserLoginToken
   @GetMapping("selectByUUID")
   public ServerResponse<Unit> selectByUUID(@Validated @NotNull(message = "uuid不能为空")@RequestParam("uuid")String uuid){
      return unitService.selectByUUID(uuid);
   }


   @ApiOperation("获取所有单位")
   @UserLoginToken
   @GetMapping("apps")
   public ServerResponse<Map<String,String>> apps(){
      return unitService.allApps();
   }


}
