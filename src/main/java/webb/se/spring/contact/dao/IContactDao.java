package webb.se.spring.contact.dao;

import java.util.List;

import webb.se.spring.contact.model.Contact;

public interface IContactDao {
	
	Contact findById(int id);

	void saveContact(Contact contact);

	List<Contact> findAllContacts();
	
	List<Contact> findAllContactsName();

	List<Contact> findAllContactsList();
}
