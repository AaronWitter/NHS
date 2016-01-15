package com.nhs.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Created by Aaron.Witter on 13/01/16.
 */
@Entity
@Table(name = "name_alias2")
@NamedQueries({
    @NamedQuery(
        name = "com.example.helloworld.core.Person.findAll",
        query = "SELECT p FROM name_alias2 p"
    )
})
public class Person {
  @Id
  @Column(name = "Person_UID", nullable = false)
  private long id;

  @Column(name = "Forename1", nullable = false)
  private String firstname;

  @Column(name = "Surname", nullable = false)
  private String surname;

  @Column(name = "Date_of_Birth", nullable = false)
  private String dateofbirth;

  public Person() {
  }

  public Person(long id, String firstname, String surname, String dateofbirth) {
    this.id = id;
    this.firstname = firstname;
    this.surname = surname;
    this.dateofbirth = dateofbirth;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setFirstName(String firstname) {
    this.firstname = firstname;
  }

  public String getFirstname(){
    return firstname;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getDateofbirth() {
    return dateofbirth;
  }

  public void setDateofbirth(String dateofbirth) {
    this.dateofbirth = dateofbirth;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Person)) {
      return false;
    }

    final Person that = (Person) o;

    return Objects.equals(this.id, that.id) &&
        Objects.equals(this.firstname, that.firstname) &&
        Objects.equals(this.surname, that.surname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, surname);
  }
}
