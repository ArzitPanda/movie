package com.arz.movie.exceptions;

public class EntityPresentException extends  RuntimeException{

    public EntityPresentException(String entityName) {
        super(entityName+" already present");
    }
}
