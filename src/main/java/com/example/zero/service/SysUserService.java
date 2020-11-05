package com.example.zero.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.zero.mapper.SysUserMapper;
import com.example.zero.model.FbSysUser;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
@CacheConfig(cacheNames = "fb_sys_user")
public class SysUserService {

    @Resource
    private SysUserMapper userMapper;


    @Cacheable(key = "'user::' + #page + '::' + #size")
    public Object listAll(int page, int size) {

        Page pageObj = new Page(page, size);
        return userMapper.selectPage(pageObj, null);
    }

    @CacheEvict(allEntries = true)
    public int insert(FbSysUser user) {
        return userMapper.insert(user);
    }

    @CacheEvict(allEntries = true)
    public int remove(Integer userId) {
        return userMapper.deleteById(userId);
    }

    @CacheEvict(allEntries = true)
    public int update(FbSysUser user) {
        return userMapper.updateById(user);
    }
}
