package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LuntanleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LuntanleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LuntanleixingView;


/**
 * 论坛类型
 *
 * @author 
 * @email 
 * @date 2021-05-17 21:12:24
 */
public interface LuntanleixingService extends IService<LuntanleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LuntanleixingVO> selectListVO(Wrapper<LuntanleixingEntity> wrapper);
   	
   	LuntanleixingVO selectVO(@Param("ew") Wrapper<LuntanleixingEntity> wrapper);
   	
   	List<LuntanleixingView> selectListView(Wrapper<LuntanleixingEntity> wrapper);
   	
   	LuntanleixingView selectView(@Param("ew") Wrapper<LuntanleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LuntanleixingEntity> wrapper);
   	
}

