package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LuntanxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LuntanxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LuntanxinxiView;


/**
 * 论坛信息
 *
 * @author 
 * @email 
 * @date 2021-05-17 21:12:24
 */
public interface LuntanxinxiService extends IService<LuntanxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LuntanxinxiVO> selectListVO(Wrapper<LuntanxinxiEntity> wrapper);
   	
   	LuntanxinxiVO selectVO(@Param("ew") Wrapper<LuntanxinxiEntity> wrapper);
   	
   	List<LuntanxinxiView> selectListView(Wrapper<LuntanxinxiEntity> wrapper);
   	
   	LuntanxinxiView selectView(@Param("ew") Wrapper<LuntanxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LuntanxinxiEntity> wrapper);
   	
}

