package com.nhs.resources;

import com.nhs.db.PersonDAO;
import com.nhs.model.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Aaron.Witter on 13/01/16.
 */
@Path("/people/{personId}")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

  private final PersonDAO peopleDAO;

  public PersonResource(PersonDAO peopleDAO) {
    this.peopleDAO = peopleDAO;
  }

  @GET
  public Response getPerson(@PathParam("personId") int personId) {
    Person person = peopleDAO.findNameById(personId);
    return Response.ok(person).build();
  }
}