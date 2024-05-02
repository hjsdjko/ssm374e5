package com.dao;

import com.entity.LuntanleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LuntanleixingVO;
import com.entity.view.LuntanleixingView;


/**
 * 论坛类型
 * 
 * @author 
 * @email 
 * @date 2021-05-17 21:12:24
 */
public interface LuntanleixingDao extends BaseMapper<LuntanleixingEntity> {
	
	List<LuntanleixingVO> selectListVO(@Param("ew") Wrapper<LuntanleixingEntity> wrapper);
	
	LuntanleixingVO selectVO(@Param("ew") Wrapper<LuntanleixingEntity> wrapper);
	
	List<LuntanleixingView> selectListView(@Param("ew") Wrapper<LuntanleixingEntity> wrapper);

	List<LuntanleixingView> selectListView(Pagination page,@Param("ew") Wrapper<LuntanleixingEntity> wrapper);
	
	LuntanleixingView selectView(@Param("ew") Wrapper<LuntanleixingEntity> wrapper);
	
}
