package com.epam.allandnow.patterns;

public class AdreessBuilder {
  private String country;
  private String state;
  private String city;

  public AdreessBuilder country( String country ) {
    this.country = country;
    return this;
  }

  public AdreessBuilder state( String state ) {
    this.state = state;
    return this;
  }

  public AdreessBuilder city( String city ) {
    this.city = city;
    return this;
  }

  public Address build() {
    if ( country == null || state == null || city == null ) {
      throw new IllegalArgumentException( "Object cann't built: arguments list is not full " );
    }
    return new Address( country, state, city );

  }
}
