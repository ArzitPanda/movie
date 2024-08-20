package com.arz.movie.exceptions;

public class EntityNotFound extends  RuntimeException{
    public EntityNotFound(String entityName) {
        super(entityName+" not present ");
    }
}
