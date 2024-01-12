package in.cdac.epramaan.user.model;

import java.io.Serializable;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;

import com.google.common.base.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

 
@Entity
@Table(name = "roles")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable, GrantedAuthority  {
 
    private static final long serialVersionUID = 6874667425302308430L;
    static Logger logger = LoggerFactory.getLogger(Role.class);
 
    @Id
    @Column(name = "role_id", length = 30)
    private String roleId;
    
    @NotNull(message = "{error.roles.role.null}")
    @NotEmpty(message = "{error.roles.role.empty}")
    @Size(max = 50, message = "{error.roles.role.max}")
    @Column(name = "role", length = 30)
    private String rolename;    
       
    //@OneToMany(cascade = CascadeType.ALL)  
    @OneToMany(fetch = FetchType.EAGER)  
    @JoinColumn(name = "role_id")
    private Set<UserRole> userRoles;
     
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permissions",
        joinColumns        = { @JoinColumn(name = "role_id") },
        inverseJoinColumns = { @JoinColumn(name = "permission_id", referencedColumnName = "perm_id") }
    )    
    private Set<Permission> permissions;

	public Role(String id) {
		super();
		this.roleId = id;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
 
        if (o instanceof Role) {
            final Role other = (Role) o;
            return Objects.equal(getRoleId(), other.getRoleId());
		}
        

        if (o instanceof UserRole) {
        	
            final UserRole other = (UserRole) o;
            return Objects.equal(getRoleId(), other.getRole().getRoleId());
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hash =Objects.hashCode(getRoleId()); 
		
		return hash;
	}
 
    @Override
    public String getAuthority() {
        return getRolename();
    }

}