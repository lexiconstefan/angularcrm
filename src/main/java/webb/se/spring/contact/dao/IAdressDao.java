package webb.se.spring.contact.dao;

import webb.se.spring.contact.model.Adress;

public interface IAdressDao {

	Adress findById(int id);
}
