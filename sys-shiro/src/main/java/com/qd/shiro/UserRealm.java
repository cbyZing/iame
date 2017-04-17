package com.qd.shiro;

import com.qd.entity.SysMenuEntity;
import com.qd.entity.SysUserEntity;
import com.qd.service.SysMenuService;
import com.qd.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by chenlongbo on 2017/4/16.
 */
public class UserRealm extends AuthorizingRealm {
   @Autowired
   private SysUserService sysUserService;
   @Autowired
   private SysMenuService sysMenuService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//
//
//        SysUserEntity user = (SysUserEntity)principals.getPrimaryPrincipal();
//        Long userId = user.getUserId();
//
//        List<String> permsList = null;
//
//        //系统管理员，拥有最高权限
//        if(userId == 1){
//            List<SysMenuEntity> menuList = sysMenuService.queryList(new HashMap<String, Object>());
//            permsList = new ArrayList<>(menuList.size());
//            for(SysMenuEntity menu : menuList){
//                permsList.add(menu.getPerms());
//            }
//        }else{
//            permsList = sysUserService.queryAllPerms(userId);
//        }
//
//        //用户权限列表
//        Set<String> permsSet = new HashSet<String>();
//        for(String perms : permsList){
//            if(StringUtils.isBlank(perms)){
//                continue;
//            }
//            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
//        }
//
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.setStringPermissions(permsSet);
//        return info;
        return null;
    }

    /**
     * 认证(登录时调用)
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = String.valueOf(token.getPrincipal());
        String password = new String((char[])token.getCredentials());
        //查询用户信息
        SysUserEntity user = sysUserService.queryByUsername(username);
        if(user == null){
            throw new UnknownAccountException("账号或密码不正确");
        }
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }
        if (user.getStatus() == 0){
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,password,getName());

        return info;
    }
}
