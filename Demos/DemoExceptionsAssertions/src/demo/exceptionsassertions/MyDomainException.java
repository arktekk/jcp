package demo.exceptionsassertions;

import java.util.Date;

public class MyDomainException extends Exception {

	private Date timestamp = new Date();
	int severity = 0;

	public MyDomainException(String message) {
		super(message);
	}

	public MyDomainException(String message, int severity) {
		super(message);
		this.severity = severity;
	}

	public MyDomainException(String message, Throwable cause, int severity) {
		super(message, cause);
		this.severity = severity;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public int getSeverity() {
		return severity;
	}
}
