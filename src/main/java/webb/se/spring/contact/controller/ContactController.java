package webb.se.spring.contact.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import webb.se.spring.contact.model.Contact;
import webb.se.spring.contact.model.Phone;
import webb.se.spring.contact.service.IContactService;
import webb.se.spring.contact.service.IPhoneService;

@Controller
@RequestMapping("/crm/contacts")
public class ContactController {

	final static Logger logger = Logger.getLogger(ContactController.class);

	@Autowired
	IContactService service;
	@Autowired
	IPhoneService phoneservice;

	/*
	 * This method will list all existing employees.
	 */
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public ResponseEntity<List<Contact>> listContacts() {

		if (logger.isTraceEnabled()) {
			logger.trace("Begin");
		}
		try {

			List<Contact> contact = service.findAllContactsList();
			logger.debug("logg={}");
			return new ResponseEntity<List<Contact>>(contact, HttpStatus.OK);
		} finally {
			if (logger.isTraceEnabled()) {
				logger.trace("End");
			}
		}

	}

	@RequestMapping(value = { "/namelist" }, method = RequestMethod.GET)
	public ResponseEntity<List<Contact>> listContactNames() {

		if (logger.isTraceEnabled()) {
			logger.trace("Begin");
		}
		try {

			List<Contact> contact = service.findAllContactsName();
			logger.debug("logg={}");
			return new ResponseEntity<List<Contact>>(contact, HttpStatus.OK);
		} finally {
			if (logger.isTraceEnabled()) {
				logger.trace("End");
			}
		}

	}
	@RequestMapping(value = { "/redigera/{id}" }, method = RequestMethod.GET)
	public ResponseEntity<Contact> findSpecificComputer(@PathVariable("id") Integer id) {
		logger.debug(id);
		Contact contact = service.findContactById(3);

		return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	}

	/*
	 * This method will be called on submission, handling POST request for
	 * saving contact in database. It also validates the user input
	 */
	@ResponseBody
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public Contact saveContact(@RequestBody Contact contact) {

		service.saveContact(contact);
		return contact;
	}

	// @RequestMapping(value = { "/edit" }, method = RequestMethod.POST,
	// consumes = {
	// MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	// public ResponseEntity<Contact> updateContact(ContactConfig config) {
	// Contact contact = new Contact();
	//
	// return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	// }

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.PUT)
	public ResponseEntity<Contact> updateContacta(@PathVariable("id") int id, @RequestBody Contact contact) {
		service.updateContact(contact);
		System.out.println("End");
		return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	}

	public List<Phone> initializeProfiles() {
		return phoneservice.findAllPhones();
	}
}
