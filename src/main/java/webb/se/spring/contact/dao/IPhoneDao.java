package webb.se.spring.contact.dao;

import java.util.List;

import webb.se.spring.contact.model.Phone;

public interface IPhoneDao {
	
	List<Phone> findAllPhones();

	Phone findByID(int id);
}
