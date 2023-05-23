package com.sendflow.sendflow.entities.dto;

import java.io.Serializable;

import com.twilio.rest.api.v2010.account.Message;

public class WhatsAppDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String account_sid;
	private String api_version;
	private String body;
	private String date_created;
	private String date_sent;
	private String date_updated;
	private String direction;
	private String error_code;
	private String error_message;
	private String from; // ": "whatsapp:+14155238886",
	private String messaging_service_sid;
	private String num_media;
	private String num_segments;
	private String price;
	private String price_unit;
	private String sid;
	private String status;

	public WhatsAppDto(String account_sid, String api_version, String body, String date_created, String date_sent,
			String date_updated, String direction, String error_code, String error_message, String from,
			String messaging_service_sid, String num_media, String num_segments, String price, String price_unit,
			String sid, String status) {
		super();
		this.account_sid = account_sid;
		this.api_version = api_version;
		this.body = body;
		this.date_created = date_created;
		this.date_sent = date_sent;
		this.date_updated = date_updated;
		this.direction = direction;
		this.error_code = error_code;
		this.error_message = error_message;
		this.from = from;
		this.messaging_service_sid = messaging_service_sid;
		this.num_media = num_media;
		this.num_segments = num_segments;
		this.price = price;
		this.price_unit = price_unit;
		this.sid = sid;
		this.status = status;
	}
	
	public WhatsAppDto(Message message) {
		account_sid = message.getAccountSid();
		api_version = message.getApiVersion();
		body = message.getBody();
		date_created = message.getDateCreated().toString();
		date_sent = message.getDateSent().toString();
		date_updated = message.getDateUpdated().toString();
		direction = message.getDirection().toString();
		error_code = message.getErrorCode().toString();
		error_message = message.getErrorMessage();
		from = message.getFrom().toString();
		messaging_service_sid = message.getMessagingServiceSid();
		num_media = message.getNumMedia();
		num_segments = message.getNumSegments();
		price = message.getPrice();
		price_unit = message.getPriceUnit().toString();
		sid = message.getSid();
		status = message.getStatus().toString();
	}
	

	public WhatsAppDto(String account_sid, String sid, String body, String from, String status) {
		//Testes
		this.account_sid = account_sid;
		this.body = body;
		this.from = from;
		this.status = status;
		this.sid = sid;
	}

	public WhatsAppDto() {
		super();
	}

	public String getAccount_sid() {
		return account_sid;
	}

	public void setAccount_sid(String account_sid) {
		this.account_sid = account_sid;
	}

	public String getApi_version() {
		return api_version;
	}

	public void setApi_version(String api_version) {
		this.api_version = api_version;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDate_created() {
		return date_created;
	}

	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}

	public String getDate_sent() {
		return date_sent;
	}

	public void setDate_sent(String date_sent) {
		this.date_sent = date_sent;
	}

	public String getDate_updated() {
		return date_updated;
	}

	public void setDate_updated(String date_updated) {
		this.date_updated = date_updated;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getMessaging_service_sid() {
		return messaging_service_sid;
	}

	public void setMessaging_service_sid(String messaging_service_sid) {
		this.messaging_service_sid = messaging_service_sid;
	}

	public String getNum_media() {
		return num_media;
	}

	public void setNum_media(String num_media) {
		this.num_media = num_media;
	}

	public String getNum_segments() {
		return num_segments;
	}

	public void setNum_segments(String num_segments) {
		this.num_segments = num_segments;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPrice_unit() {
		return price_unit;
	}

	public void setPrice_unit(String price_unit) {
		this.price_unit = price_unit;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
