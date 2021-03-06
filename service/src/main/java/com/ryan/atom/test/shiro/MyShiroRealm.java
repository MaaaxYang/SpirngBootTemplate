package com.ryan.atom.test.shiro;

import com.ryan.atom.model.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.*;

/**
 * Created by Administrator on 2017/12/21.
 */
public class MyShiroRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限认证方法：MyShiroRealm.doGetAuthenticationInfo()");
        SysUser token = (SysUser) SecurityUtils.getSubject().getPrincipal();
        String userId = token.getId();
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        //根据用户ID查询角色（role），放入到Authorization里。
        /**
         *  Map<String, Object> map = new HashMap<String, Object>();
            map.put("user_id", userId);
            List<SysRole> roleList = sysRoleService.selectByMap(map);
            Set<String> roleSet = new HashSet<String>();
            for(SysRole role : roleList){
                roleSet.add(role.getType());
            }
         */
        //实际开发，当前登录用户的角色和权限信息是从数据库来获取的，我这里写死是为了方便测试
        Set<String> roleSet = new HashSet<String>();
        roleSet.add("100002");
        info.setRoles(roleSet);
        //根据用户ID查询权限（permission），放入到Authorization里。
        /**
         *  List<SysPermission> permissionList = sysPermissionService.selectByMap(map);
            Set<String> permissionSet = new HashSet<String>();
            for(SysPermission Permission : permissionList){
                permissionSet.add(Permission.getName());
            }
         */
        Set<String> permissionSet = new HashSet<String>();
        permissionSet.add("权限添加");
        info.setStringPermissions(permissionSet);
        return info;

        //return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        System.out.println("身份认证方法：MyShiroRealm.doGetAuthenticationInfo()");

        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("nickname", token.getUsername());
        map.put("pswd", token.getPassword());
        SysUser user = null;
        user = new SysUser();
        user.setCreateNameId("ryan");
        user.setPswd("123456");
        user.setId("1");
        user.setNickname("MaxxxYang");
        user.setStatus("ok");
        // 从数据库获取对应用户名密码的用户
        List<SysUser> userList = new ArrayList<SysUser>(); //sysUserService.selectByMap(map);
        if(userList.size()!=0){
            user = userList.get(0);
        }
        if (null == user) {
            throw new AccountException("帐号或密码不正确！");
        }else if(user.getStatus().equals("ban")){
            /**
             * 如果用户的status为禁用。那么就抛出<code>DisabledAccountException</code>
             */
            throw new DisabledAccountException("帐号已经禁止登录！");
        }else{
            //更新登录时间 last login time
            user.setLastLoginTime(new Date());
            //sysUserService.updateById(user);
        }
        return new SimpleAuthenticationInfo(user, user.getPswd(), getName());

        //return null;
    }
}
