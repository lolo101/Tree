package fr.sciam.kata.tree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TreeTest {
    @Test
    void should_return_node_value() {
        Tree.Node root = new Tree.Node("Coucou");
        String text = root.toText();
        assertEquals("Coucou", text);
    }

    @Test
    void should_return_children_values() {
        Tree.Node root = new Tree.Node("Coucou",
            new Tree.Node("le"),
            new Tree.Node("monde"));
        String text = root.toText();
        assertEquals("Coucou le monde", text);
    }

    @Test
    void should_return_grand_children_values() {
        Tree.Node root = new Tree.Node("Coucou",
            new Tree.Node("le",
                new Tree.Node("Ca"),
                new Tree.Node("roule?")),
            new Tree.Node("monde"));

        String text = root.toText();
        assertEquals("Coucou le monde Ca roule?", text);
    }

    @Test
    void should_return_tree_text() {
        String text = Tree.getRoot().toText();
        assertEquals("Je suis un arbre en largeur", text);
    }
}