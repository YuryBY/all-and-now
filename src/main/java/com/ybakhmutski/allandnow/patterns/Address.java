package com.epam.allandnow.patterns;

public class Address {
  private String country;
  private String state;
  private String city;

  public Address( String country, String state, String city ) {
    super();
    this.country = country;
    this.state = state;
    this.city = city;
  }

  @Override
  public String toString() {
    return "Address [country=" + country + ", state=" + state + ", city=" + city + "]";
  }

}
