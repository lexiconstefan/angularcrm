package webb.se.spring.contact.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import webb.se.hibernate.dao.AbstractDao;
import webb.se.spring.contact.model.Phone;

@Repository("iphonetDao")
public class PhoneDaoImpl extends AbstractDao<Integer, Phone> implements IPhoneDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Phone> findAllPhones() {
		Criteria crit = createEntityCriteria();
		return (List<Phone>) crit.list();
	}

	@Override
	public Phone findByID(int id) {
		return getByKey(id);
	}

}
