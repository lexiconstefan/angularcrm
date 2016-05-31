package webb.se.spring.activity.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import webb.se.spring.activity.model.Activity;
import webb.se.spring.activity.service.IActivityService;

@Controller
@RequestMapping("/crm/activity")
public class ActivityController {

	final static Logger logger = Logger.getLogger(ActivityController.class);

	@Autowired
	IActivityService activityservice;

	@ResponseBody
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public ResponseEntity<Activity> saveActivity(Activity activity) {
		System.out.println("HHHHHHHHHHEEEEEEEEELLLLLLLOOOO" + activity);
		logger.debug("activity= " + activity);
		activityservice.saveActivity(activity);
		return new ResponseEntity<Activity>(activity, HttpStatus.OK);
	}

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public ResponseEntity<List<Activity>> findListActivitysFromSQL(@RequestParam String startdate,
			@RequestParam String enddate) {
		
		List<Activity> list = null;
		list = activityservice
				.findAllActivitysFromSQL(
						"SELECT * FROM activity WHERE activity_date BETWEEN '" + startdate + "' AND '" + enddate + "'");
		
		return new ResponseEntity<List<Activity>>(list,HttpStatus.OK);
	}
}
