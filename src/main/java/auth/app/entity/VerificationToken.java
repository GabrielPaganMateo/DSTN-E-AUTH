package auth.app.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class VerificationToken {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;
	private boolean isVerified;
	private LocalDateTime issuedDate;
	private LocalDateTime expirationDate;
	private LocalDateTime confirmedDate;
	private UUID token;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "end_user_id")
	EndUser endUser;

}
