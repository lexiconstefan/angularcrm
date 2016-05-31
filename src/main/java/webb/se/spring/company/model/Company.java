package webb.se.spring.company.model;

import java.util.Set;

import webb.se.spring.contact.model.Adress;
import webb.se.spring.contact.model.Contact;
import webb.se.spring.contact.model.Phone;

public class Company {
	private String companyName;
	private String organisationNbr;
	private String companyNumber;
	private String comments;
	private int cfar;
	private int industry;
	private String homepage;
	private Set<Adress> adress;
	private Coordinates coordinates;
	private Set<Document> document;
	private Set<Contact> contact;
	private Set<Phone> phone;

}
