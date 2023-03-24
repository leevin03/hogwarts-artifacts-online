package edu.tcu.cs.hogwartsartifactsonline.system.exception;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(String objectName, Object id){
        super("Could not find " + objectName + " with Id " +id);
    }
}
