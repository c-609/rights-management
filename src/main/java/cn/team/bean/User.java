package cn.team.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.team.common.constant.CommonConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

@Data
public class User implements UserDetails{
    private long id;
    private String username;
    private String password;
    private int status;

    private List<Role> roles;
    private List<Menu> menus;
    private List<Dept> depts;

    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (roles.size() == 0 && roles == null) {
            return null;
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        menus.stream().forEach(node -> {
            if (!StringUtils.isEmpty(node.getComponent())) {
                authorities.add(new SimpleGrantedAuthority(node.getComponent()));
            }
        });
        return authorities;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    // 用户是否锁定
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return (status == CommonConstants.STATUS_LOCK) ? false : true;
    }
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    // 用户是否启用
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

}
