package com.cy.service;

import com.cy.dao.RoleRepository;
import com.cy.entity.RoleEntity;
import com.cy.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RedisUtils.redisList redisList;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public List<RoleEntity> findAllRoles() {

        List list = new ArrayList();
        if(redisUtils.hasKey("roleList")){
            System.out.println("从redis缓存中获取的数据");
            list = redisList.get("roleList",0,-1);
        }else{
            list = roleRepository.findAll();
            System.out.println("从数据库获取数据");
            System.out.println("将数据存到redis中");
            redisList.set("roleList",list);
            System.out.println("存入成功");
        }
        return list;
    }
}
