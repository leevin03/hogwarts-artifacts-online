package edu.tcu.cs.hogwartsartifactsonline.wizard;

public class WizardNotFoundException extends RuntimeException{
    public WizardNotFoundException(int id) {
        super("Could not find wizard with Id "+ id);
    }
}
