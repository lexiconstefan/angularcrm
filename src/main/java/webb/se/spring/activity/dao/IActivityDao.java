package webb.se.spring.activity.dao;

import java.util.List;

import webb.se.spring.activity.model.Activity;

public interface IActivityDao {

	Activity findById(int id);

	void saveActivity(Activity activity);

	List<Activity> findAllActivitys();

	List<Activity> findAllActivitysFromSQL(String sql);
}
