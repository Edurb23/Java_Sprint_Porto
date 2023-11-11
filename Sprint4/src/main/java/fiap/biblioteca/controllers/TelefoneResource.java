package fiap.biblioteca.controllers;



import fiap.biblioteca.models.Telefone;
import fiap.biblioteca.models.repositores.TelefoneRepositories;
import fiap.biblioteca.service.TelefoneService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.List;

@Path("/cliente/telefone")
public class TelefoneResource {

    private TelefoneRepositories repositories = new TelefoneRepositories();

    private TelefoneService telefoneService = new TelefoneService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Telefone> getTelefone() throws SQLException {
        return repositories.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response  addTelefone(Telefone telefone) throws SQLException{
        Response service = telefoneService.validarTelfone(telefone);
        if(service.getStatus() != Response.Status.OK.getStatusCode()){
            return service;
        }
        repositories.add(telefone);
        return Response.ok().build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Telefone getTelefoneporID(@PathParam("id") int id) throws SQLException{
        return repositories.find(id).orElse(null);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateTelefone(@PathParam("id") int id, Telefone telefone)throws SQLException{
        if (repositories.find(id).isPresent()){
            telefone.setId_telfone(id);
            repositories.update(telefone);
            var telefoneAtualizado = repositories.find(id);
            return Response.status(Response.Status.OK).entity(telefoneAtualizado).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity(telefone).build();
    }

    @DELETE
    @Path("{id}")
    public void deleteTelefone(@PathParam("id") int id) throws SQLException{
        if (repositories.find(id).isPresent())
            repositories.delete(id);
    }
}
