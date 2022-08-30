package fr.sciam.kata.tree;

import java.util.Arrays;
import java.util.List;

public class Tree {

    public static final Node ROOT =
        new Node("Je",
            new Node("suis"),
            new Node("un",
                new Node("en"),
                new Node("largeur")
            ),
            new Node("arbre")
        );

    public static Node getRoot() {
        return ROOT;
    }

    public record Node(String value, Node ... children) {

        public List<Node> getChildren() {
            return Arrays.asList(children);
        }

        public String getValue() {
            return value;
        }
    }

}
