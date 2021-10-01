package com.suarez.TestMoby.model;

public enum Tipo {

    DNI("DNI"),
    LC("LC"),
    LE("LE");

    private final String string;

    TipoDocumento(final String string)
    {
        this.string = string;
    }

    public String obtener()
    {
        return string;
    }

}
