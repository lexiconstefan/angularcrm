package webb.se.spring.contact.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="PHONE")
public class Phone {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(max=50)
    @Column(name = "NUMBER", nullable = false)
	private String number;
	
	@Size(max=20)
    @Column(name = "TYPE", nullable = false)
	private String type;
	
//	@ManyToMany(mappedBy="phone",fetch = FetchType.EAGER)
//	private Set<Contact> contact = new HashSet<Contact>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

//	public Set<Contact> getContact() {
//		return contact;
//	}
//
//	public void setContact(Set<Contact> contact) {
//		this.contact = contact;
//	}

}
