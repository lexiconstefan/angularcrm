package webb.se.spring.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webb.se.spring.contact.dao.IContactDao;
import webb.se.spring.contact.model.Adress;
import webb.se.spring.contact.model.Contact;

@Service("icontactService")
@Transactional
public class ContactServiceImpl implements IContactService {

	@Autowired
	private IContactDao dao;

	@Override
	public void saveContact(Contact contact) {
		dao.saveContact(contact);
	}

	@Override
	public List<Contact> findAllContacts() {
		return dao.findAllContacts();
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate
	 * update explicitly. Just fetch the entity from db and update it with
	 * proper values within transaction. It will be updated in db once
	 * transaction ends.
	 */
	public void updateContact(Contact contact) {


		Contact entity = dao.findById(contact.getId());
		// if (entity != null) {
			System.out.println("UUUUUUUUUUPPPPPPPPPDDDDDDDATE");
		entity.setFirstName(contact.getFirstName());
		entity.setLastName(contact.getLastName());
		entity.setTitle(contact.getTitle());
		entity.setComments(contact.getComments());
		// update adress
		Adress adressContact = contact.getAdress();
		Adress adressEntity = entity.getAdress();
		if (adressEntity == null && adressContact != null) {

		} else if (adressEntity != null && adressContact != null) {
			adressEntity.setCountry(adressContact.getCountry());
			adressEntity.setCounty(adressContact.getCounty());
			adressEntity.setMunicipality(adressContact.getMunicipality());
			adressEntity.setAdress(adressContact.getAdress());
			adressEntity.setZip(adressContact.getZip());
		}

		// }
	}
	public Contact findContactById(Integer id){
		
		return dao.findById(id);
	}

	@Override
	public List<Contact> findAllContactsName() {
		return dao.findAllContactsName();
	}

	@Override
	public List<Contact> findAllContactsList() {
		return dao.findAllContactsList();
	}

}
