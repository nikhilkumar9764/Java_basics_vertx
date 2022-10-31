package com.example.eventbus;

public class Pong {
  int id;
  public Pong(int i) {
    this.id = i;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Pong{" +
      "id=" + id +
      '}';
  }
}
