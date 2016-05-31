package webb.se.spring.contact.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "CONTACT")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// @NotNull
	// @DateTimeFormat(pattern="dd/MM/yyyy")
	// @Column(name = "CREATIONDATE", nullable = false)
	// @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	// private LocalDate creationDate;

	@NotEmpty
	@Size(max = 50)
	@Column(name = "FIRSTNAME", nullable = false)
	private String firstName;

	@NotEmpty
	@Size(max = 50)
	@Column(name = "LASTNAME", nullable = false)
	private String lastName;

	// @ManyToMany(fetch = FetchType.LAZY)
	// @JoinTable(name = "CONTACT_EMAIL", joinColumns = { @JoinColumn(name =
	// "CONTACT_ID") }, inverseJoinColumns = {
	// @JoinColumn(name = "EMAIL_ID") })
	// private Set<Email> email = new HashSet<Email>();

	@Size(max = 50)
	@Column(name = "TITLE", nullable = true)
	private String title;

	@Column(name = "COMMENTS", nullable = true)
	private String comments;

	// @Size(max = 10)
	// @Column(name = "status", nullable = false)
	// private int status;

	@OneToOne(cascade = CascadeType.ALL)
	private Adress adress;

	// @ManyToMany(fetch = FetchType.LAZY)
	// @JoinTable(name = "Contact_PHONE", joinColumns = { @JoinColumn(name =
	// "CONTACT_ID") }, inverseJoinColumns = {
	// @JoinColumn(name = "PHONE_ID") })
	// private Set<Phone> phone = new HashSet<Phone>();
	// private Set<Interest> interest;
	// private Set<Subscription> subscription;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// public Set<Email> getEmail() {
	// return email;
	// }
	//
	// public void setEmail(Set<Email> email) {
	// this.email = email;
	// }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// public LocalDate getCreationDate() {
	// return creationDate;
	// }
	//
	// public void setCreationDate(LocalDate creationDate) {
	// this.creationDate = creationDate;
	// }

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	// public int getStatus() {
	// return status;
	// }
	//
	// public void setStatus(int status) {
	// this.status = status;
	// }

	//
	public Adress getAdress() {
		return adress;
	}

	//
	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	// public Set<Phone> getPhone() {
	// return phone;
	// }
	//
	// public void setPhone(Set<Phone> phone) {
	// this.phone = phone;
	// }
	//
	// public Set<Interest> getInterest() {
	// return interest;
	// }
	//
	// public void setInterest(Set<Interest> interest) {
	// this.interest = interest;
	// }
	//
	// public Set<Subscription> getSubscription() {
	// return subscription;
	// }
	//
	// public void setSubscription(Set<Subscription> subscription) {
	// this.subscription = subscription;
	// }
	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName

				+ ", title=" + title + ", comments=" + comments + ", adress=" + adress + "]";
	}
}
