package com.ldoc.lati.apirest.bean;

import java.util.UUID;

public class ResponseBean {

	public boolean successful;
	public String trace = generateType4UUID().toString();
	public String status;
	public String message;
	public Object payload;

	public ResponseBean(boolean successful, String status, String message, Object payload) {
		super();
		this.successful = successful;
		this.status = status;
		this.message = message;
		this.payload = payload;
	}

	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	public String getTrace() {
		return trace;
	}

	public void setTrace(String trace) {
		this.trace = trace;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	public static UUID generateType4UUID() {
		UUID uuid = UUID.randomUUID();
		return uuid;
	}

	@Override
	public String toString() {
		return "ResponseBean [successful=" + successful + ", status=" + status + ", message=" + message + ", payload="
				+ payload + "]";
	}

}
