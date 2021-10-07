package com.suarez.testmoby.model.enums;

public enum Tipo {

    DNI("DNI"),
    LC("LC"),
    LE("LE");

    private final String string;

    Tipo(final String string)
    {
        this.string = string;
    }

    public String obtener()
    {
        return string;
    }

}
