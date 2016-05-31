package webb.se.spring.activity.service;

import java.util.List;

import webb.se.spring.activity.model.Activity;

public interface IActivityService {

	void saveActivity(Activity activity);

	List<Activity> findAllActivitys();

	Activity findById(int id);

	List<Activity> findAllActivitysFromSQL(String sql);
}
