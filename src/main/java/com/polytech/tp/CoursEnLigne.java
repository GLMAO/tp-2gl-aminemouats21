package com.polytech.tp;

public class CoursEnLigne extends CoursDecorator {

    public CoursEnLigne(ICours cours) {
        super(cours);
    }

    @Override
    public String getDescription() {
        // On conserve la description de base et on ajoute la mention "En ligne"
        String base = super.getDescription();
        if (base == null) base = "";
        // ajouter "En ligne" (test vérifie la présence de la chaîne "En ligne")
        return base + " (En ligne)";
    }

    @Override
    public double getDuree() {
        // Le décorateur n'altère pas la durée par défaut, on délègue.
        return super.getDuree();
    }
}
