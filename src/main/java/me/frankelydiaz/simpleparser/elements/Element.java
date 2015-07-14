package me.frankelydiaz.simpleparser.elements;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by frankelydiaz on 7/13/15.
 */
public class Element {

    private Map<Object, Object> attributes;

    protected Element() {
        this.attributes = new HashMap<Object, Object>();
    }

    public static Element fromArray(Object[] attributes, String[] attributeNames) {
        Element element = new Element();

        for (int i = 0; i < attributes.length; i++) {
            element.setAttribute(attributeNames[i], attributes[i]);
        }

        return element;
    }

    public void setAttribute(Object name, Object value) {
        attributes.put(name,value);
    }

    public Object getAttribute(Object name) {
        return attributes.get(name);
    }
}
