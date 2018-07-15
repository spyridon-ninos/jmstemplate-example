package com.ninos.model;

import java.util.Comparator;
import java.util.Objects;

public final class Message implements Comparable<Message> {
	private String from;
	private String to;
	private String body;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	/*
	 * the methods below (compareTo, equals and hashCode) don't play
	 * any role in the current implementation, but I consider it a good
	 * practice to include them in every DTO
	 */
	@Override
	public int compareTo(Message other) {
		return Comparator
				.<Message, Integer>comparing(otherMessage -> from.compareTo(otherMessage.from))
				.thenComparing(otherMessage -> to.compareTo(otherMessage.to))
				.thenComparing(otherMessage -> body.compareTo(otherMessage.body))
				.compare(this, other);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Message)) {
			return false;
		}
		Message message = (Message) o;
		return Objects.equals(from, message.from) &&
				Objects.equals(to, message.to) &&
				Objects.equals(body, message.body);
	}

	@Override
	public int hashCode() {
		return Objects.hash(from, to, body);
	}

	@Override
	public String toString() {
		return "Message{" +
				"from='" + from + '\'' +
				", to='" + to + '\'' +
				", body='" + body + '\'' +
				'}';
	}
}
