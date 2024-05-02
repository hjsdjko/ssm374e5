package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.LuntanleixingDao;
import com.entity.LuntanleixingEntity;
import com.service.LuntanleixingService;
import com.entity.vo.LuntanleixingVO;
import com.entity.view.LuntanleixingView;

@Service("luntanleixingService")
public class LuntanleixingServiceImpl extends ServiceImpl<LuntanleixingDao, LuntanleixingEntity> implements LuntanleixingService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LuntanleixingEntity> page = this.selectPage(
                new Query<LuntanleixingEntity>(params).getPage(),
                new EntityWrapper<LuntanleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LuntanleixingEntity> wrapper) {
		  Page<LuntanleixingView> page =new Query<LuntanleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LuntanleixingVO> selectListVO(Wrapper<LuntanleixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LuntanleixingVO selectVO(Wrapper<LuntanleixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LuntanleixingView> selectListView(Wrapper<LuntanleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LuntanleixingView selectView(Wrapper<LuntanleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
