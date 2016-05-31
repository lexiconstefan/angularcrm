package webb.se.spring.activity.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import webb.se.hibernate.dao.AbstractDao;
import webb.se.spring.activity.model.Activity;

@Repository("iactivityDao")
public class ActivityDaoImpl extends AbstractDao<Integer, Activity> implements IActivityDao {

	@Override
	public Activity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveActivity(Activity activity) {
		persist(activity);
	}

	@Override
	public List<Activity> findAllActivitys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> findAllActivitysFromSQL(String sql) {
		// TODO Auto-generated method stub
		return getBySql(Activity.class, sql);
	}

}
