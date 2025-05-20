package com.example.galaxiexplorer.Model;

public enum Type {
    GAZ("Gazeuse"),
    ROCHE("Tellurique"),
    EAU("Océanique"),
    Feu("Volcanique"),
    GLACEE("Glacée"),
    DESERT("Désertique"),
    ARTIFI("Artificielle");

    private final String label;

    Type(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
