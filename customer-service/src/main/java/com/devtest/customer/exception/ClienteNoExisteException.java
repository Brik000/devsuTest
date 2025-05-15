package com.devtest.customer.exception;

public class ClienteNoExisteException extends RuntimeException {
  public ClienteNoExisteException(String message) {
    super(message);
  }
}
