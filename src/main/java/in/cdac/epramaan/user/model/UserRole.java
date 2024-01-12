package in.cdac.epramaan.user.model;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.security.core.GrantedAuthority;

import com.google.common.base.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_roles")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRole implements Serializable, GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_role_id", columnDefinition = "serial")
	private Integer userRoleId;

	@Column(name = "ucms_id")
	private int ucmsId;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id")
	private Role role;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "update_by")
	private String updateBy;

	@Column(name = "update_timestamp")
	private Timestamp updateTimestamp;

	public UserRole(Role role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
		//log.debug("searching for :"+this);
		if (this == o)
			return true;
		if (o == null)
			return false;

		if (o instanceof UserRole) {
			final UserRole other = (UserRole) o;
			//log.debug("comparing with :"+other);
			return Objects.equal(getRole().getRoleId(), other.getRole().getRoleId())
					&& Objects.equal(getUcmsId(), other.getUcmsId())
					&& Objects.equal(getIsActive(), other.getIsActive());
		}

		if (o instanceof Role) {
			final Role other = (Role) o;
			return Objects.equal(getRole().getRoleId(), other.getRoleId());
		}
		return false;
	}

	@Override
	public int hashCode() {
			/*Since, UserRole is constantly compared with Role and essentially Admin Role represents the Role itself
			 * returning hascode of only Role Id*/
		if(Boolean.TRUE.equals(this.isActive)){
			int hash = Objects.hashCode(getRole().getRoleId());
			//log.debug("Calculating hashcode based on Role id. Effective hash: " + hash);
			return hash;
		}
		else{
			int hash = Objects.hashCode(getRole().getRoleId(),this.isActive);
			//log.debug("Calculating hashcode based on Role id and isActive. Effective hash: " + hash);
			return hash;
		}
	}

	@Override
	public String getAuthority() {
		return getRole().getRolename();
	}

}
