package com.example.eventbus;

public class Ping {

  private String message;
  private boolean is_enabled;

  public Ping(String message, boolean is_enabled) {
    this.message = message;
    this.is_enabled = is_enabled;
  }

  public String getMessage() {
    return message;
  }

  public boolean isIs_enabled() {
    return is_enabled;
  }

  @Override
  public String toString() {
    return "Ping{" +
      "message='" + message + '\'' +
      ", is_enabled=" + is_enabled +
      '}';
  }
}

