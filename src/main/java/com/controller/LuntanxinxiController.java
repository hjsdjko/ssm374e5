package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.LuntanxinxiEntity;
import com.entity.view.LuntanxinxiView;

import com.service.LuntanxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 论坛信息
 * 后端接口
 * @author 
 * @email 
 * @date 2021-05-17 21:12:24
 */
@RestController
@RequestMapping("/luntanxinxi")
public class LuntanxinxiController {
    @Autowired
    private LuntanxinxiService luntanxinxiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LuntanxinxiEntity luntanxinxi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			luntanxinxi.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LuntanxinxiEntity> ew = new EntityWrapper<LuntanxinxiEntity>();
		PageUtils page = luntanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, luntanxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LuntanxinxiEntity luntanxinxi, 
		HttpServletRequest request){
        EntityWrapper<LuntanxinxiEntity> ew = new EntityWrapper<LuntanxinxiEntity>();
		PageUtils page = luntanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, luntanxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LuntanxinxiEntity luntanxinxi){
       	EntityWrapper<LuntanxinxiEntity> ew = new EntityWrapper<LuntanxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( luntanxinxi, "luntanxinxi")); 
        return R.ok().put("data", luntanxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LuntanxinxiEntity luntanxinxi){
        EntityWrapper< LuntanxinxiEntity> ew = new EntityWrapper< LuntanxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( luntanxinxi, "luntanxinxi")); 
		LuntanxinxiView luntanxinxiView =  luntanxinxiService.selectView(ew);
		return R.ok("查询论坛信息成功").put("data", luntanxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LuntanxinxiEntity luntanxinxi = luntanxinxiService.selectById(id);
        return R.ok().put("data", luntanxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LuntanxinxiEntity luntanxinxi = luntanxinxiService.selectById(id);
        return R.ok().put("data", luntanxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        LuntanxinxiEntity luntanxinxi = luntanxinxiService.selectById(id);
        if(type.equals("1")) {
        	luntanxinxi.setThumbsupnum(luntanxinxi.getThumbsupnum()+1);
        } else {
        	luntanxinxi.setCrazilynum(luntanxinxi.getCrazilynum()+1);
        }
        luntanxinxiService.updateById(luntanxinxi);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LuntanxinxiEntity luntanxinxi, HttpServletRequest request){
    	luntanxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(luntanxinxi);

        luntanxinxiService.insert(luntanxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LuntanxinxiEntity luntanxinxi, HttpServletRequest request){
    	luntanxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(luntanxinxi);

        luntanxinxiService.insert(luntanxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody LuntanxinxiEntity luntanxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(luntanxinxi);
        luntanxinxiService.updateById(luntanxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        luntanxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<LuntanxinxiEntity> wrapper = new EntityWrapper<LuntanxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = luntanxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
