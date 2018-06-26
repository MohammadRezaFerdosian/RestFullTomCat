package service;

import model.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("service")
public class Service {

    private static Map<Integer, Person> Persons=new HashMap<Integer, Person>();
    static {
        for (int i=0;i<=10;i++)
        {
            model.Person person=new Person();
            person.setId(i);
            person.setName("i am mohammad "+i);
            person.setAge(new Random().nextInt(30) + 1);
            Persons.put(i,person);
        }

        }
        @GET
        @Path("/getSinglePersonXml/{id}")
        @Produces(MediaType.APPLICATION_XML)
    public Person getSinglePersonXml(@PathParam("id") int id)
    {
        return Persons.get(id);
    }

    @GET
    @Path("/getSinglePersonJSON/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getSinglePersonJSON(@PathParam("id") int id)
    {
        return Persons.get(id);
    }

    @GET
    @Path("/getListPersonXml")
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> getListsPersonsXml()
    {
        return new ArrayList<Person>(Persons.values());
    }

    @GET
    @Path("/getListPersonJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getListPersonJSON()
    {
        return new ArrayList<Person>(Persons.values());
    }

}
