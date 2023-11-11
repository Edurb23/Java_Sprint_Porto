package fiap.biblioteca.controllers;



import fiap.biblioteca.models.Email;
import fiap.biblioteca.models.repositores.EmailRepositories;
import fiap.biblioteca.service.EmailService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.List;

@Path("/cliente/email")
public class EmailResource {
    private EmailRepositories repositories = new EmailRepositories();

    private EmailService emailService = new EmailService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Email> getEmail() throws SQLException {
        return repositories.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEmail(Email email) throws SQLException{
        Response service = emailService.validarEmail(email);

        if (service.getStatus() != Response.Status.OK.getStatusCode()){
            return service;
        }

        repositories.add(email);
        return Response.ok().build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Email getEmailPorID(@PathParam("id") int id) throws SQLException{
        return  repositories.find(id).orElse(null);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEmail(@PathParam("id") int id, Email email) throws SQLException{
        if(repositories.find(id).isPresent()){
            email.setId_email(id);
            repositories.update(email);
            var emailEditado = repositories.find(id);
            return  Response.status(Response.Status.OK).entity(email).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity(email).build();
    }
    @DELETE
    @Path("{id}")
    public void deleteEmail(@PathParam("id") int id) throws SQLException{
        if (repositories.find(id).isPresent())
            repositories.delete(id);
    }

}
