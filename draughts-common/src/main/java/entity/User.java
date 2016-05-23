/**
 * 
 */
package entity;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
/**
 * @author Tatyana_Gladchenko
 *         <p>
 *         User transfer object. Represents User table in database
 *         </p>
 */
public class User implements Serializable {

	private static final long serialVersionUID = 2468931214011712576L;
	private Long id;
	
	@NotNull
	@Size(min=3, max=20, message="{user.message.firstname}")
	private String firstName;
	
	@Size(min=3, max=30, message="{user.message.middlename}")
	private String middleName;
	
	@NotNull
	@Size(min=3, max=30, message="{user.message.lastname}")
	private String lastName;
	
	@NotNull
	@Pattern(regexp="^[a-zA-Z0-9]+$",
			message="${user.message.login}")
	private String login;
	
	@NotNull
	@Size(min=6, message="{user.message.password}")
	private String password;
	
	@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
			message="{user.message.email}")
	private String email;
	
	@NotNull
	private Date birthday;
	
	private Long roleId;

	public User() {
	}

	public User(Long id, String firstName, String middleName, String lastName, String login, String password,
			String email, Date birthday, Long roleId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.email = email;
		this.birthday = birthday;
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "User {id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", login=" + login + ", password=" + password + ", email=" + email + ", birthday=" + birthday
				+ ", roleId=" + roleId + "}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + (int) (roleId ^ (roleId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (roleId != other.roleId)
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}
