package me.frankelydiaz.simpleparser;

/**
 * Created by frankelydiaz on 7/13/15.
 */
public abstract class Parser<E,T> {
    public abstract T parse(E element);
}
