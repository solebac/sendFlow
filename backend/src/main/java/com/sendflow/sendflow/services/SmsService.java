package com.sendflow.sendflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sendflow.sendflow.entities.Person;
import com.sendflow.sendflow.entities.dto.WhatsAppDto;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;

	@Autowired
	private PersonService repository;

	public void sendSms(Long personId) {
		Person person = repository.findById(personId);// Obtendo person
		String msg = "Araxa Project Web - CEO Flávio Rogério da Silva";
	    
	    Twilio.init(twilioSid, twilioKey);
	    PhoneNumber to = new PhoneNumber(twilioPhoneTo);
	    PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

        Message message = Message.creator( 
                to, 
                from,  
                msg)      
            .create(); 
		
		
		/*String from = "+" + person.getRamal00() + person.getTelefone00();

		if (from.length() != 11) {
			from = "+" + person.getRamal01() + person.getTelefone01();
		}
		if (from.length() != 11) {
			from = "+" + person.getRamal02() + person.getTelefone02();
		}
		// PhoneNumber from = new PhoneNumber(twilioPhoneFrom); //Forma static
		PhoneNumber phoneNumberFrom = new PhoneNumber(from);
		Message message = Message.creator(to, phoneNumberFrom, msg).create(); */

		System.out.println(message.getSid());
	}

	public WhatsAppDto sendSms(Long personId, String msg) {

		Person person = repository.findById(personId);// Obtendo person

		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);

		String from = "+" + person.getRamal00() + person.getTelefone00();

		if (from.length() != 12) {
			from = "+" + person.getRamal01() + person.getTelefone01();
		}
		if (from.length() != 12) {
			from = "+" + person.getRamal02() + person.getTelefone02();
		}
		from = "whatsapp:" + from;
		if (from.length() != 12) {
			/**
			 * Homologação
			 * return new WhatsAppDto();*/
			return new WhatsAppDto(twilioSid, "SM2YnVjZXRhTESTE", msg, from, "failed");
		}else {
			/*
			 *Homologação 
			PhoneNumber phoneNumberFrom = new PhoneNumber(from);
			// Old Message message = Message.creator(to, from, strFrom).create();
			// https://www.twilio.com/pt-br/docs/whatsapp/quickstart/java

			Message message = Message.creator(to, phoneNumberFrom, msg).create();

			return new WhatsAppDto(message);
			return new WhatsAppDto();*/
			return new WhatsAppDto(twilioSid, "SM2YnVjZXRhTESTE", msg, from, "sent");
		}

	}

	public void exemplo(){
		final String ACCOUNT_SID = "AC2a43205b2deb4c80ff45d607009551ab"; 
	    final String AUTH_TOKEN = "01df1545e0913bf30841824229a510b4";
	    
	    Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber("whatsapp:+553484101155"), 
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),  
                "Your appointment is coming up on July 21 at 3PM")      
            .create(); 
 
        System.out.println(message.getSid()); 
	    
	}
}
