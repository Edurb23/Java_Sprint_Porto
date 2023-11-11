package fiap.biblioteca.service;

import fiap.biblioteca.models.Email;
import jakarta.ws.rs.core.Response;

public class EmailService {


    public boolean emailValido(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    String emailExemplo = "email@email.com";
    public Response validarEmail(Email email){
        String dadosEmail = email.getDs_email();
        if (!emailValido(dadosEmail)){
            return Response.status(Response.Status.BAD_REQUEST).entity("Formato de e-mail inválido, tente usar com esse exemplo :" + " " + emailExemplo ).build();
        }
        return  Response.ok().build();
    }


}