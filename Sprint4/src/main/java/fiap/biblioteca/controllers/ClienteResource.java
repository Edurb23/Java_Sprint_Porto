package fiap.biblioteca.controllers;

import fiap.biblioteca.models.Cliente;
import fiap.biblioteca.models.repositores.ClienteRepositories;
import fiap.biblioteca.service.ClienteService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.List;

@Path("/cliente")
public class ClienteResource {

   private ClienteRepositories repositories = new ClienteRepositories();
   private ClienteService clienteService = new ClienteService();
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<Cliente> getCliente() throws SQLException{
      return repositories.findAll();
   }

   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   public Response addCliente(Cliente cliente) throws SQLException{
      Response service = clienteService.validarCliente(cliente);

      if (service.getStatus() != Response.Status.OK.getStatusCode()){
         return service;
      }
      repositories.add(cliente);
      return Response.ok().build();
   }

   @GET
   @Path("{id}")
   @Produces(MediaType.APPLICATION_JSON)
   public Cliente getClientePorID(@PathParam("id") int id) throws SQLException{
      return  repositories.find(id).orElse(null);
   }

   @PUT
   @Path("{id}")
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Response updateCliente(@PathParam("id") int id, Cliente cliente) throws SQLException{
      if(repositories.find(id).isPresent()){
         cliente.setId_cliente(id);
         repositories.update(cliente);
         var clienteAtualizado = repositories.find(id);
         return Response.status(Response.Status.OK).entity(clienteAtualizado).build();
      }
      return Response.status(Response.Status.NOT_FOUND).entity(cliente).build();
   }

   @DELETE
   @Path("{id}")
   public void deleteCliente(@PathParam("id") int id) throws SQLException{
      if (repositories.find(id).isPresent())
         repositories.delete(id);
   }


}
