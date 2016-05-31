package webb.se.spring.contact.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import utils.gson.GsonUtils;
import webb.se.spring.contact.model.Adress;
import webb.se.spring.contact.model.Contact;
import webb.se.spring.contact.model.ContactConfig;
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
		Contact contact = service.findContactById(id);

		return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	}

	/*
	 * This method will be called on submission, handling POST request for
	 * saving contact in database. It also validates the user input
	 */
	@ResponseBody
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public Contact saveContact(@Valid Contact contact) {
		System.out.println(contact.getId());
		System.out.println(contact.getFirstName());
		System.out.println(contact.getComments());
		System.out.println(contact.getLastName());
		Adress a = new Adress();
		a.setAdress("Granstigen 4");
		a.setCountry("se");
		a.setCounty("skåne");
		a.setMunicipality("bromölla");
		a.setZip("29538");
		contact.setAdress(a);
		service.saveContact(contact);
		return contact;
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public ResponseEntity<Contact> updateContact(ContactConfig config) {

		System.out.println("updateContact request=" + config.getRequest());
		String se = "Måla båten blö";
		System.out.println(se);
		Contact contact = GsonUtils.fromJsonToObj(config.getRequest(), Contact.class);
		System.out.println("updateContact contact= " + contact);
		System.out.println("updateContact adress= " + contact.getAdress());
		service.updateContact(contact);
		System.out.println("End");
		return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	}

	@RequestMapping(value = { "/edita" }, method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public ResponseEntity<Contact> updateContacta(Contact contact) {

		System.out.println("updateContact request=" + contact);
		String se = "Måla båten blö";
		System.out.println(se);
		// Contact contact = GsonUtils.fromJsonToObj(config.getRequest(),
		// Contact.class);
		System.out.println("updateContact contact= " + contact);
		System.out.println("updateContact adress= " + contact.getAdress());
		service.updateContact(contact);
		System.out.println("End");
		return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	}

	public List<Phone> initializeProfiles() {
		return phoneservice.findAllPhones();
	}
}
