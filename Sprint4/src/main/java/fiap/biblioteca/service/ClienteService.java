package fiap.biblioteca.service;

import fiap.biblioteca.models.Cliente;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;


public class ClienteService {

    private static final  int Numero_CNH = 11;
    private static final int Numero_CPF = 11;

    private  static final int Numero_Rg = 7;
      public Response validarCliente(Cliente cliente){
          LocalDate dataPresente = LocalDate.now();

          if (cliente.getDt_data_nascimento() != null && cliente.getDt_data_nascimento().isAfter(dataPresente)){
              return Response.status(Response.Status.BAD_REQUEST).entity("Essa data foi invalida, por favor digite uma data de nascimento valida").build();
          }

          if(cliente.getNr_cnh() != null && cliente.getNr_cnh().length() > 11) {
              return Response.status(Response.Status.BAD_REQUEST).entity("O número da CNH não pode ter mais de " + 11 + " caracteres.").build();
          }

          if(cliente.getNr_cpf() != null && cliente.getNr_cpf().length() > Numero_CPF){
              return Response.status(Response.Status.BAD_REQUEST).entity("O número do CPF não pode ter mais de " + 11 + " caracteres.").build();
          }
          if(cliente.getNr_rg() != null && cliente.getNr_rg().length() > Numero_Rg){
              return Response.status(Response.Status.BAD_REQUEST).entity("O número do RG não pode ter mais de " + 7 + " caracteres.").build();
          }
          return Response.status(Response.Status.OK).entity("Cliente cadastrado com sucesso !!!").build();

      }




}
