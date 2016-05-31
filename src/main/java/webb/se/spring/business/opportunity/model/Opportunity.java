package webb.se.spring.business.opportunity.model;

import java.util.Set;

import org.joda.time.LocalDate;

import webb.se.spring.business.Responsibility.model.Responsibility;
import webb.se.spring.business.utils.offer.model.Offer;
import webb.se.spring.company.model.Document;
import webb.se.spring.contact.model.Contact;
import webb.se.spring.meeting.model.Meeting;

public class Opportunity {
	private int pipelineLevel;
	private String desription;
	private int earning;
	private String probability;
	private String porpoise;
	private String offerContent; // offert
	private String otherDescription;
	private Offer offer;
	private LocalDate businessDecisionDate;
	private Contact contact;
	private Responsibility responsibility;
	private Set<Meeting> meeting;
	private Set<Document> document;

}
