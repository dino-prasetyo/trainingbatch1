package id.co.klaten.security.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;

@Entity
@Table(name="M_USER")
@Data              
@AllArgsConstructor
@NoArgsConstructor 
public class UserEntity implements UserDetails, Serializable
{


  @Id
  @Column(name="USER_ID", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer userId;

  @Column(name="USER_NAME")
  private String userName;

  @Column(name="PASSWORD")
  private String password;
  
  public Collection<? extends GrantedAuthority> getAuthorities()
  {
    RoleEntity role_Entity_user = new RoleEntity(1, "ROLE_USER");
    LinkedHashSet<GrantedAuthority> grantedAuthorities = new LinkedHashSet<GrantedAuthority>();
    grantedAuthorities.add(role_Entity_user);
    return grantedAuthorities;
  }
  
  public String getUsername()
  {
    return this.userName;
  }
  
  public boolean isAccountNonExpired()
  {
    return true;
  }
  
  public boolean isAccountNonLocked()
  {
    return true;
  }
  
  public boolean isCredentialsNonExpired()
  {
    return true;
  }
  
  public boolean isEnabled()
  {
    return true;
  }
}
