package webb.se.spring.contact.service;

import java.util.List;

import webb.se.spring.contact.model.Phone;

public interface IPhoneService {
	
	Phone getByID(int id);

	List<Phone> findAllPhones();
}
