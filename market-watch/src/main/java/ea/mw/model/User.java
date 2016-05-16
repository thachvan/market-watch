package ea.mw.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
		ROLE_USER, ROLE_UPDATER
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

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "portfolio_item_id")
	private List<PortfolioItem> portfolio = new ArrayList<PortfolioItem>();

	@Enumerated(EnumType.STRING)
	private Role authority;

	@Column(nullable = true)
	boolean enabled;

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

	public Role getAuthority() {
		return authority;
	}

	public void setAuthority(Role authority) {
		this.authority = authority;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void addPortfolioItem(PortfolioItem item) {
		portfolio.add(item);
	}

	public List<PortfolioItem> getPortfolio() {
		return portfolio;
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
