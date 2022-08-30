package fr.sciam.kata.tree;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
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

        public String toText() {
            List<Node> nodes = stackChildren(List.of(this), 0);
            return nodes.stream()
                .map(Node::getValue)
                .collect(joining(" "));
        }

        private static List<Node> stackChildren(List<Node> nodes, int currentNodeIndex) {
            if (currentNodeIndex < nodes.size()) {
                Node currentNode = nodes.get(currentNodeIndex);
                return stackChildren(concat(nodes, currentNode.getChildren()), currentNodeIndex + 1);
            }
            return nodes;
        }

        private static List<Node> concat(List<Node> nodes, List<Node> children) {
            List<Node> newNodes = new ArrayList<>(nodes);
            newNodes.addAll(children);
            return newNodes;
        }

        public List<Node> getChildren() {
            return Arrays.asList(children);
        }

        public String getValue() {
            return value;
        }
    }

}
