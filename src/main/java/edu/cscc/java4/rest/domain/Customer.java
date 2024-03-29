package edu.cscc.java4.rest.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private long id;
  private String firstName;
  private String lastName;
  private String emailAddress;


  public Customer () { }


  public Customer (long id, String firstName, String lastName, String emailAddress) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
  }


  public long getId () {
    return id;
  }


  public void setId (long id) {
    this.id = id;
  }


  public String getFirstName () {
    return firstName;
  }


  public void setFirstName (String firstName) {
    this.firstName = firstName;
  }


  public String getLastName () {
    return lastName;
  }


  public void setLastName (String lastName) {
    this.lastName = lastName;
  }


  public String getEmailAddress () { return emailAddress; }


  public void setEmailAddress (String emailAddress) { this.emailAddress = emailAddress; }


}
