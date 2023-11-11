package fiap.biblioteca.service;

import fiap.biblioteca.models.Telefone;
import jakarta.ws.rs.core.Response;

public class TelefoneService {


    public Response validarTelfone(Telefone telefone){
        String numeroTelefone = Long.toString(telefone.getNr_telefone());

        if(numeroTelefone != null && numeroTelefone.length() > 11){
            return Response.status(Response.Status.BAD_REQUEST).entity("O número de telefone não pode ter mais de " +11 + " caracteres.").build();
        }
        return Response.status(Response.Status.OK).entity("Cliente cadastrado com sucesso !!!").build();
    }
}
