package com.entity.view;

import com.entity.LuntanxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 论坛信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-05-17 21:12:24
 */
@TableName("luntanxinxi")
public class LuntanxinxiView  extends LuntanxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LuntanxinxiView(){
	}
 
 	public LuntanxinxiView(LuntanxinxiEntity luntanxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, luntanxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
