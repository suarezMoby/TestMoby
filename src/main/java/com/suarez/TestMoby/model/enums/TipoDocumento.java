package com.suarez.TestMoby.model.enums;

import javax.persistence.Entity;


public enum TipoDocumento {

    DNI("DNI"),
    LE("LE"),
    LC("LC");

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
