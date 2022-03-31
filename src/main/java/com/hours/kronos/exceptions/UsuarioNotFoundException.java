package com.hours.kronos.exceptions;

import lombok.NoArgsConstructor;


public class UsuarioNotFoundException extends Exception{

    public UsuarioNotFoundException(String msg){
        super(msg);
    }
}
