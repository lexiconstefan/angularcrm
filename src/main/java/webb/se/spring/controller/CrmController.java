package webb.se.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/crm")
public class CrmController {
	
	@RequestMapping(value = "calender",method = RequestMethod.GET)
    public String getCalenderPage() {
        return "template/calender/calender";
    }
	@RequestMapping(value = "contact/list",method = RequestMethod.GET)
    public String getContactListPage() {
        return "template/contact/contact_list";
    }
	@RequestMapping(value = "contact",method = RequestMethod.GET)
    public String getContactPage() {
        return "template/contact/contact_new";
    }
	@RequestMapping(value = "contact/redigera",method = RequestMethod.GET)
    public String getContactEditPage() {
        return "template/contact/contact_redigera";
    }
}
