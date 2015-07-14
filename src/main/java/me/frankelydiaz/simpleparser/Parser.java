package me.frankelydiaz.simpleparser;

import me.frankelydiaz.simpleparser.elements.ElementConverter;

/**
 * Created by frankelydiaz on 7/13/15.
 */
public abstract class Parser<T,E> {
    public abstract T parse(E value);
}
