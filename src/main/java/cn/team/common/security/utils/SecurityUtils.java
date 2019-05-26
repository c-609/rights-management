package cn.team.common.security.utils;

import cn.team.bean.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 安全工具类
 *
 * create by yifeng
 */
public class SecurityUtils {

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public User getUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if(principal instanceof  User) {
            return (User) principal;
        }
        return null;
    }

    public User getUser() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        return getUser(authentication);
    }

    //TODO 获取角色
//    public List<Integer> getRoles() {
//        Authentication authentication = getAuthentication();
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//
//        List<Integer> roleIds = new ArrayList<>();
//        authorities.stream()
//            .forEach(granted -> {
//                String id = StringUtils.re
//            });
//    }

}
