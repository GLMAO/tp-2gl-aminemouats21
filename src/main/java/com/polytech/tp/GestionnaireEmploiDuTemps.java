package com.polytech.tp;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestionnaire d'emploi du temps qui implémente Subject.
 * Les observateurs reçoivent un String message lorsqu'un changement est déclaré.
 */
public class GestionnaireEmploiDuTemps implements Subject {
    private List<ICours> listeCours = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public void ajouterCours(ICours cours) {
        this.listeCours.add(cours);
        System.out.println("Nouveau cours ajouté : " + cours.getDescription());
        // Notifier les observateurs si nécessaire (optionnel)
        notifyObservers("Nouveau cours ajouté : " + cours.getDescription());
    }

    public void modifierCours(ICours cours, String message) {
        // Logique de modification éventuelle...
        System.out.println("Cours modifié : " + message);
        notifyObservers(message);
    }

    /**
     * Méthode utilisée par les tests : lorsqu'on veut simuler un changement/évènement.
     */
    public void setChangement(String message) {
        // propager le message vers tous les observateurs
        notifyObservers(message);
    }

    // --- Subject interface ---
    @Override
    public void attach(Observer o) {
        if (o == null) return;
        if (!observers.contains(o)) observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer o : new ArrayList<>(observers)) {
            if (o != null) o.update(message);
        }
    }
}
