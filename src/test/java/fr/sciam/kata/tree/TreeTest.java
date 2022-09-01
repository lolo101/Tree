package fr.sciam.kata.tree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.StringJoiner;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

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

    @Test
    void should_not_break_with_deep_tree() {
        var testCase = createDeepTree();
        String text = testCase.root.toText();
        assertEquals(testCase.expected, text);
    }

    private TestCase createDeepTree(){
        int i = 300_000;
        var expectedBuilder = new StringBuilder();
        Tree.Node firstNode = new Tree.Node(Integer.toString(i));
        expectedBuilder.append(i);
        do {
            i--;
            expectedBuilder.insert(0, " ");
            expectedBuilder.insert(0, Integer.toString(i));
            firstNode = new Tree.Node(Integer.toString(i), firstNode);
        } while (i >= 1);
        return new TestCase(firstNode, expectedBuilder.toString());
    }

    record TestCase(Tree.Node root, String expected) { }

}