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


import com.dao.DiscussluntanxinxiDao;
import com.entity.DiscussluntanxinxiEntity;
import com.service.DiscussluntanxinxiService;
import com.entity.vo.DiscussluntanxinxiVO;
import com.entity.view.DiscussluntanxinxiView;

@Service("discussluntanxinxiService")
public class DiscussluntanxinxiServiceImpl extends ServiceImpl<DiscussluntanxinxiDao, DiscussluntanxinxiEntity> implements DiscussluntanxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussluntanxinxiEntity> page = this.selectPage(
                new Query<DiscussluntanxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussluntanxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussluntanxinxiEntity> wrapper) {
		  Page<DiscussluntanxinxiView> page =new Query<DiscussluntanxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussluntanxinxiVO> selectListVO(Wrapper<DiscussluntanxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussluntanxinxiVO selectVO(Wrapper<DiscussluntanxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussluntanxinxiView> selectListView(Wrapper<DiscussluntanxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussluntanxinxiView selectView(Wrapper<DiscussluntanxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
