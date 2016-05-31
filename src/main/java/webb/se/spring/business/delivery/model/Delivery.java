package webb.se.spring.business.delivery.model;

import java.util.Set;

import org.joda.time.LocalDate;

import webb.se.spring.business.Responsibility.model.Responsibility;
import webb.se.spring.business.opportunity.model.Opportunity;
import webb.se.spring.business.utils.offer.model.Offer;
import webb.se.spring.contact.model.Contact;

public class Delivery {
	private String deliveryDescription;
	private String deliveryNbr;
	private String backgroundPorpouse;
	private String offerDescription;
	private String otherInformation;
	private LocalDate createDay;
	private int earnings;
	private int pipelineLevel;
	private int totalStatus;
	private Set<Offer> offer;
	private Opportunity oppotunity;
	private Responsibility responsibility;
	private Contact deliveryContact;

}
