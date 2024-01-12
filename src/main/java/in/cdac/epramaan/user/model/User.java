package in.cdac.epramaan.user.model;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.google.common.base.Objects;

import in.cdac.epramaan.master.model.UserAccountStatusMaster;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {

	private static final long serialVersionUID = 6311364761937265306L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ucms_id", columnDefinition = "serial")
	private Integer ucmsId;

	@NotNull(message = "{error.field.required}")
	@NotEmpty(message = "{error.field.required}")
	@Size(max = 50, message = "{error.user.username.max}")
	@Column(name = "user_name", length = 100)
	private String username;

	@NotNull(message = "{error.field.required}")
	@NotEmpty(message = "{error.field.required}")
	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "verified_email")
	private String verifiedEmail;

	@Column(name = "email_otp_transaction")
	private String emailOtpTransaction;

	@Column(name = "email_verification_timestamp")
	private Timestamp emailVerificationTimestamp;

	@Size(max = 10)
	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "verified_mobile_number")
	private String verifiedMobileNumber;
	
	@Column(name = "mobile_otp_transaction")
	private String mobileOtpTransaction;

	@Column(name = "mobile_verification_timestamp")
	private Timestamp mobileVerificationTimestamp;

	@Size(max = 90, message = "{error.user.password.max}")
	@Column(name = "password", length = 90)
	private String password;

	@Transient
	private String confirmPassword;
	
	@Transient
	private String oldPassword;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_status_code", referencedColumnName = "status_code")
	private UserAccountStatusMaster userAccountStatusMaster;

	/** The update timestamp. */
	@Column(name = "registration_timestamp")
	private Timestamp registrationTimestamp;

	/** The update by. */
	@Column(name = "update_by")
	private String updateBy;

	/** The update timestamp. */
	@Column(name = "update_timestamp")
	private Timestamp updateTimestamp;

	@Transient
	private boolean enabled;

	@OneToMany(mappedBy = "ucmsId", fetch = FetchType.EAGER)
	@Cascade(value={CascadeType.ALL})
	private Set<UserRole> userRoles;

	public boolean getEnabled() {
		if (!this.userAccountStatusMaster.getStatusCode().equals("D")) {
			this.enabled = true;
		} else {
			this.enabled = false;
		}

		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		if (!this.userAccountStatusMaster.getStatusCode().equals("D")) {
			this.enabled = true;
		} else {
			this.enabled = false;
		}
	}
	
	public Set<UserRole> getActiveAdminRoles() {
		 Set<UserRole> activeAdminRoles = new HashSet<UserRole>();
		for(UserRole role: userRoles){
			if(role.getIsActive()){
				activeAdminRoles.add(role);
			}
		}
		return activeAdminRoles;
		
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;

		if (o instanceof User) {
			final User other = (User) o;
			return Objects.equal(getUsername(), other.getUsername());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getUsername());
	}

	@Transient
	public Set<Permission> getPermissions() {
		Set<Permission> perms = new HashSet<Permission>();
		for (UserRole adminRolesTemp : userRoles) {
			perms.addAll(adminRolesTemp.getRole().getPermissions());
		}
		return perms;
	}

	@Override
	@Transient
	public Collection<GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.addAll(getActiveAdminRoles());
		authorities.addAll(getPermissions());
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// return true = account is valid / not expired
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// return true = account is not locked
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// return true = password is valid / not expired
		return true;
	}

	@Override
	public boolean isEnabled() {
		boolean accountEnabled;
		if (!this.userAccountStatusMaster.getStatusCode().equals("D")) {
			accountEnabled = true;
		} else {
			accountEnabled = false;
		}
		return accountEnabled;
	}

}