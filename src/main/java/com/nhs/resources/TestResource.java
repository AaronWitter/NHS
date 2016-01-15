package com.nhs.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Aaron.Witter on 11/01/16.
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {
  @GET
  public String get() {
    return "Welcome to the NHS Web Portal! Useful application to follow!";
  }
}
