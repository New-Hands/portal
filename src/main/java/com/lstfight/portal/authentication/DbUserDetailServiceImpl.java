package com.lstfight.portal.authentication;

import com.lstfight.portal.dao.SysUserDao;
import com.lstfight.portal.dao.SysUserRoleDao;
import com.lstfight.portal.entity.SysUserEntity;
import com.lstfight.portal.entity.SysUserRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据库认证支持
 *
 * @author 李尚庭
 * @date 2018/8/6 0006 10:20
 */
public class DbUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    SysUserDao sysUserDao;

    @Autowired
    SysUserRoleDao sysUserRoleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        SysUserEntity userEntity = sysUserDao.findFirstByUserName(username);
        if (null == userEntity) {
            return null;
        }
        System.out.println(userEntity.toString());
        List<SysUserRoleEntity> roleEntities = sysUserRoleDao.findAllByUserName(username);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (SysUserRoleEntity roleEntity : roleEntities) {
            String authority = roleEntity.getRoleName();
            grantedAuthorities.add((GrantedAuthority) () -> authority);
        }
        //在这里初始化用户信息
        return new User(userEntity.getUserName(), encoder.encode(userEntity.getUserPasswd()), grantedAuthorities);
    }

}
