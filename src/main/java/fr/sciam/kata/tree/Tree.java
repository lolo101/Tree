package fr.sciam.kata.tree;

import java.util.*;

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

        public String toText() {
            List<String> values = new LinkedList<>();
            Queue<Node> nodes = new LinkedList<>();
            nodes.add(this);
            while (!nodes.isEmpty()) {
                Node currentNode = nodes.remove();
                nodes.addAll(currentNode.getChildren());
                values.add(currentNode.getValue());
            }
            return String.join(" ", values);
        }

        public List<Node> getChildren() {
            return Arrays.asList(children);
        }

        public String getValue() {
            return value;
        }
    }

}
