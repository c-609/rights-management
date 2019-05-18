package cn.team.common.security.component;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;

/**
 * @PreAuthorize("@pms.hasPermission('ROLE_admin')") 使用该注解给权限
 * create by yifeng
 */
@Component("pms")
public class PermissionService {

    /**
     * 判断是否有权限
     * @param permission
     * @return
     */
    public boolean hasPermission(String permission) {
        if (StringUtils.isEmpty(permission)) {
            return false;
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return false;
        }
        Collection<? extends GrantedAuthority> authorities =authentication.getAuthorities();
        return authorities.stream()
            .map(GrantedAuthority :: getAuthority)
            .filter(StringUtils::hasText)
            .anyMatch(x -> PatternMatchUtils.simpleMatch(permission, x));
    }
}
