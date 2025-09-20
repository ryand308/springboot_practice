package com.example.demo.exception;

public class RoomException extends RuntimeException{

	public RoomAlreadyExistsException(String msg) {
		super(msg);
	}
}
