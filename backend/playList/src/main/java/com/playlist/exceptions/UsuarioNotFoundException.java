package com.playlist.exceptions;

public class UsuarioNotFoundException extends Exception{

    public UsuarioNotFoundException(){
        super("El usuario con ese Username no existe en la base de datos, vuelva a intentar");
    }
    
    public UsuarioNotFoundException(String mensaje){
        super(mensaje);
    }
	
}
