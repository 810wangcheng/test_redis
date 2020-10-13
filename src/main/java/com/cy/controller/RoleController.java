package com.cy.controller;

import com.cy.entity.RoleEntity;
import com.cy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/test")
    @ResponseBody
    public List<RoleEntity> testRedis() {

        return roleService.findAllRoles();

    }
}
