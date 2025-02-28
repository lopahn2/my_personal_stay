package com.spring.mypersonalstay.exception;

public class ScoreSearchNotException extends Exception {
	public ScoreSearchNotException() {
		this("This is ScoreSearchNotException...");
	}
	public ScoreSearchNotException(String message) {
		super(message);
	}
}
