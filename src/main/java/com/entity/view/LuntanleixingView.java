package com.entity.view;

import com.entity.LuntanleixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 论坛类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-05-17 21:12:24
 */
@TableName("luntanleixing")
public class LuntanleixingView  extends LuntanleixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LuntanleixingView(){
	}
 
 	public LuntanleixingView(LuntanleixingEntity luntanleixingEntity){
 	try {
			BeanUtils.copyProperties(this, luntanleixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
