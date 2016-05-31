package webb.se.spring.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webb.se.spring.contact.dao.IPhoneDao;
import webb.se.spring.contact.model.Phone;

@Service("iphoneService")
@Transactional
public class PhoneServiceImpl implements IPhoneService{

	@Autowired
	private IPhoneDao dao;
	
	@Override
	public Phone getByID(int id) {
		// TODO Auto-generated method stub
		return dao.findByID(id);
	}

	@Override
	public List<Phone> findAllPhones() {
		// TODO Auto-generated method stub
		return dao.findAllPhones();
	}

}
