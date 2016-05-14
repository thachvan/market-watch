package ea.mw.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User {
	public enum Role {
		USER, UPDATER
	};

	@Id
	@GeneratedValue
	private int id;

	@NotEmpty
	private String name;

	@Column(unique = true)
	@NotEmpty
	private String username;

	@NotEmpty
	private String password;

	@OneToMany
	@JoinColumn(name = "portfolio_item_id")
	private List<PortfolioItem> portfolio;

	@Enumerated(EnumType.STRING)
	private Role role;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("name='").append(name).append("', username='")
				.append(username).append("', password='").append(password)
				.append("'");
		
		return sb.toString();
	}
}
