package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussluntanxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussluntanxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussluntanxinxiView;


/**
 * 论坛信息评论表
 *
 * @author 
 * @email 
 * @date 2021-05-17 21:12:24
 */
public interface DiscussluntanxinxiService extends IService<DiscussluntanxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussluntanxinxiVO> selectListVO(Wrapper<DiscussluntanxinxiEntity> wrapper);
   	
   	DiscussluntanxinxiVO selectVO(@Param("ew") Wrapper<DiscussluntanxinxiEntity> wrapper);
   	
   	List<DiscussluntanxinxiView> selectListView(Wrapper<DiscussluntanxinxiEntity> wrapper);
   	
   	DiscussluntanxinxiView selectView(@Param("ew") Wrapper<DiscussluntanxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussluntanxinxiEntity> wrapper);
   	
}

