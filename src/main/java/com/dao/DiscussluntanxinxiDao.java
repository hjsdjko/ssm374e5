package com.dao;

import com.entity.DiscussluntanxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussluntanxinxiVO;
import com.entity.view.DiscussluntanxinxiView;


/**
 * 论坛信息评论表
 * 
 * @author 
 * @email 
 * @date 2021-05-17 21:12:24
 */
public interface DiscussluntanxinxiDao extends BaseMapper<DiscussluntanxinxiEntity> {
	
	List<DiscussluntanxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussluntanxinxiEntity> wrapper);
	
	DiscussluntanxinxiVO selectVO(@Param("ew") Wrapper<DiscussluntanxinxiEntity> wrapper);
	
	List<DiscussluntanxinxiView> selectListView(@Param("ew") Wrapper<DiscussluntanxinxiEntity> wrapper);

	List<DiscussluntanxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussluntanxinxiEntity> wrapper);
	
	DiscussluntanxinxiView selectView(@Param("ew") Wrapper<DiscussluntanxinxiEntity> wrapper);
	
}
