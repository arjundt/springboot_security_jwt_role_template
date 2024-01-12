package in.cdac.epramaan.master.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="m_admin_account_status")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountStatusMaster extends MasterData {
	
	@Id
	@NotNull(message = "{error.status.code.null}")
    @NotEmpty(message = "{error.status.code.empty}")
	@Column(name="status_code")
	@GeneratedValue
	private String statusCode;
	
	/** The stateName. */
	@NotNull(message = "{error.status.name.null}")
    @NotEmpty(message = "{error.status.name.empty}")
	@Column(name="status")
	private String status;
	
	/** The update by. */
	@NotNull(message = "{error.status.updateBy.null}")
    @NotEmpty(message = "{error.status.updateBy.empty}")
	@Column(name="update_by")
	private String updateBy;
	
	/** The update timestamp. */
	@NotNull(message = "{error.status.updateTimestamp.null}")
	@Column(name="update_timestamp")
	private Timestamp updateTimestamp;

	@Override
	public String getUniqueId() {
		return statusCode;
	}

}
