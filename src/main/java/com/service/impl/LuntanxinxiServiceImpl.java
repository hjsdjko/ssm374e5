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


import com.dao.LuntanxinxiDao;
import com.entity.LuntanxinxiEntity;
import com.service.LuntanxinxiService;
import com.entity.vo.LuntanxinxiVO;
import com.entity.view.LuntanxinxiView;

@Service("luntanxinxiService")
public class LuntanxinxiServiceImpl extends ServiceImpl<LuntanxinxiDao, LuntanxinxiEntity> implements LuntanxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LuntanxinxiEntity> page = this.selectPage(
                new Query<LuntanxinxiEntity>(params).getPage(),
                new EntityWrapper<LuntanxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LuntanxinxiEntity> wrapper) {
		  Page<LuntanxinxiView> page =new Query<LuntanxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LuntanxinxiVO> selectListVO(Wrapper<LuntanxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LuntanxinxiVO selectVO(Wrapper<LuntanxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LuntanxinxiView> selectListView(Wrapper<LuntanxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LuntanxinxiView selectView(Wrapper<LuntanxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
