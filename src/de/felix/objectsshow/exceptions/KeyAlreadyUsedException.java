package de.felix.objectsshow.exceptions;

public class KeyAlreadyUsedException extends Exception {
    public KeyAlreadyUsedException(int key) {
        super("Key " + key + " is already in use!");
    }
}
