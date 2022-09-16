package id.co.klaten.security.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class RoleEntity implements GrantedAuthority
{
    private int roleId;
    private String roleName;
    
    public RoleEntity(int roleId, String roleName)
    {
        this.roleId = roleId;
        this.roleName = roleName;
    }
    
    public String getAuthority()
    {
        return roleName;
    }
}
