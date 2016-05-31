package webb.se.spring.contact.service;

import java.util.List;

import webb.se.spring.contact.model.Contact;

public interface IContactService {

	void saveContact(Contact contact);

	List<Contact> findAllContacts();

	List<Contact> findAllContactsName();

	List<Contact> findAllContactsList();

	void updateContact(Contact contact);

	Contact findContactById(Integer id);
}
