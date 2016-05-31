package webb.se.spring.contact.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import webb.se.hibernate.dao.AbstractDao;
import webb.se.spring.contact.model.Contact;
import webb.se.spring.contact.model.ContactList;
import webb.se.spring.contact.model.ContactName;

@Repository("icontactDao")
public class ContactDaoImpl extends AbstractDao<Integer, Contact> implements IContactDao {

	@Override
	public Contact findById(int id) {
		Contact contact = null;
		try{
		 contact = getByKey(id);
			
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
		try{
			if(contact != null){
				// Hibernate.initialize(contact.getAdress());
				// Hibernate.initialize(contact.getPhone());
				// Hibernate.initialize(contact.getEmail());
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return contact;
	}

	@Override
	public void saveContact(Contact contact) {
		persist(contact);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> findAllContacts() {
		Criteria criteria = createEntityCriteria();
		return (List<Contact>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Contact> findAllContactsName() {
		Criteria criteria = createEntityCriteria();
		criteria.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
				.add(Projections.property("firstName"), "firstName"))
				.setResultTransformer(Transformers.aliasToBean(ContactName.class));
		
		return (List<Contact>)criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Contact> findAllContactsList() {
		Criteria criteria = createEntityCriteria();
		criteria.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
				.add(Projections.property("adress"), "adress").add(Projections.property("firstName"), "firstName")
				.add(Projections.property("lastName"), "lastName"))
				.setResultTransformer(Transformers.aliasToBean(ContactList.class));

		return (List<Contact>) criteria.list();
	}
}
