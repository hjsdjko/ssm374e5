package com.dao;

import com.entity.LuntanxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LuntanxinxiVO;
import com.entity.view.LuntanxinxiView;


/**
 * 论坛信息
 * 
 * @author 
 * @email 
 * @date 2021-05-17 21:12:24
 */
public interface LuntanxinxiDao extends BaseMapper<LuntanxinxiEntity> {
	
	List<LuntanxinxiVO> selectListVO(@Param("ew") Wrapper<LuntanxinxiEntity> wrapper);
	
	LuntanxinxiVO selectVO(@Param("ew") Wrapper<LuntanxinxiEntity> wrapper);
	
	List<LuntanxinxiView> selectListView(@Param("ew") Wrapper<LuntanxinxiEntity> wrapper);

	List<LuntanxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<LuntanxinxiEntity> wrapper);
	
	LuntanxinxiView selectView(@Param("ew") Wrapper<LuntanxinxiEntity> wrapper);
	
}
