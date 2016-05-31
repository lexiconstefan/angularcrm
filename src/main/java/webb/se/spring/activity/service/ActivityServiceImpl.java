package webb.se.spring.activity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webb.se.spring.activity.dao.IActivityDao;
import webb.se.spring.activity.model.Activity;

@Service("iactivityService")
@Transactional
public class ActivityServiceImpl implements IActivityService {

	@Autowired
	private IActivityDao dao;
	
	@Override
	public void saveActivity(Activity activity) {
		dao.saveActivity(activity);
	}

	@Override
	public List<Activity> findAllActivitys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Activity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> findAllActivitysFromSQL(String sql) {
		// TODO Auto-generated method stub
		return dao.findAllActivitysFromSQL(sql);
	}

}
