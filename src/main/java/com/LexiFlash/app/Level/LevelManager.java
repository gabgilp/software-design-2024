package com.LexiFlash.app.Level;

import com.LexiFlash.app.Card.Card;
import com.LexiFlash.app.Deck.Deck;
import com.LexiFlash.app.Game.GameManager;
import com.LexiFlash.app.Game.GameUI;
import com.LexiFlash.app.Game.Helper;
import com.LexiFlash.app.Interfaces.Editable;

public class LevelManager implements Editable<Level> {

    @Override
    public void edit(Level level) {
        System.out.println("Editing level... " + level.label);
        //Options to edit properties of the level
        String[] options = {"Name: " + level.name, "Label: " + level.label, "From Language: " + level.fromLanguage, "To Language: " + level.toLanguage, "Deck", "Remove"};

        Integer option = GameUI.menu(options, "Choose a property to edit: ");

        switch (option) {
            case 1:
                System.out.println("Enter the new name: ");
                level.name = System.console().readLine();
                break;
            case 2:
                System.out.println("Enter the new label: ");
                level.label = System.console().readLine();
                break;
            case 3:
                System.out.println("Enter the new from language: ");
                level.fromLanguage = System.console().readLine();
                break;
            case 4:
                System.out.println("Enter the new to language: ");
                level.toLanguage = System.console().readLine();
                break;
            case 5:
                level.deck.edit();
                break;
            case 6:
                GameManager.removeLevel(level);
            default:
                break;
        }

        GameManager.saveLevel(level);

    }

    @Override
    public Level create() {

        GameUI.clearConsole();

        System.out.println("Creating a new level...");
        System.out.print("Name: ");
        String name = System.console().readLine();
        System.out.print("Label: ");
        String label = System.console().readLine();
        System.out.print("From Language: ");
        String fromLanguage = System.console().readLine();
        System.out.print("To Language: ");
        String toLanguage = System.console().readLine();
        String id = java.util.UUID.randomUUID().toString();

        return new Level(id, name, label, fromLanguage, toLanguage, new Deck(new Card[0]), false);
    }
    
}
