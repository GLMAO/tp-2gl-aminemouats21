package com.polytech.tp;

/**
 * Décorateur abstrait pour ICours : délègue par défaut aux méthodes du cours décoré.
 */
public abstract class CoursDecorator implements ICours {
    protected ICours coursDecorated;

    public CoursDecorator(ICours cours) {
        this.coursDecorated = cours;
    }

    @Override
    public String getDescription() {
        return coursDecorated.getDescription();
    }

    @Override
    public double getDuree() {
        return coursDecorated.getDuree();
    }
}
