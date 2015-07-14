package me.frankelydiaz.simpleparser;

/**
 * Created by frankelydiaz on 7/13/15.
 */
public enum Separator {
    PIPE("\\|"),
    COMMA(","), SPACE(" ");

    private final String expression;

    Separator(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }
}
