import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphSearch {

    /**
     * Implementation of the Breadth first search and depth first search
     * 
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Node node1 = new Node(1, 1);
        Node node2 = new Node(2, 2);
        Node node3 = new Node(3, 3);
        Node node4 = new Node(4, 4);
        Node node5 = new Node(5, 5);
        Node node6 = new Node(6, 6);
        Node node7 = new Node(7, 7);
        Node node8 = new Node(8, 8);
        List<Node> list1 = new ArrayList<Node>();
        list1.add(node2);
        list1.add(node3);
        list1.add(node4);
        List<Node> list2 = new ArrayList<Node>();
        list2.add(node1);
        list2.add(node5);
        list2.add(node6);
        List<Node> list3 = new ArrayList<Node>();
        list3.add(node3);
        list3.add(node7);
        list3.add(node1);
        list3.add(node2);
        list3.add(node5);
        list3.add(node8);
        AdjListNode listNode = new AdjListNode(node1, list1);
        AdjListNode listNode1 = new AdjListNode(node2, list2);
        AdjListNode listNode2 = new AdjListNode(node3, list3);
        List<AdjListNode> vertices = new ArrayList<AdjListNode>();
        vertices.add(listNode);
        vertices.add(listNode1);
        vertices.add(listNode2);

        // bfs(2, vertices);
        dfs(2, vertices);

    }

    public static void bfs(int index, List<AdjListNode> vertices) {

        if (index < 0)
            return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.addAll(vertices.get(index).getNeighbours());
        System.out.println(vertices.get(index).getVertex().data);
        vertices.get(index).getVertex().visited = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (!node.visited) {
                System.out.println(node.data);
                node.visited = true;
                for (AdjListNode vertex : vertices) {
                    if (vertex.getVertex().nodeId == node.nodeId) {
                        queue.addAll(vertex.getNeighbours());
                    }
                }
            }

        }

    }

    public static void dfs(int index, List<AdjListNode> vertices) {
        if (index < 0)
            return;
        Stack<Node> stack = new Stack<Node>();
        stack.addAll(vertices.get(index).getNeighbours());
        System.out.println(vertices.get(index).getVertex().data);
        vertices.get(index).getVertex().visited = true;
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (!node.visited) {
                System.out.println(node.data);
                node.visited = true;
                for (AdjListNode vertex : vertices) {
                    if (vertex.getVertex().nodeId == node.nodeId) {
                        stack.addAll(vertex.getNeighbours());
                    }
                }
            }

        }

    }
}

class Node {

    public Node(int nodeId, int data) {
        this.nodeId = nodeId;
        this.data = data;
    }

    public Node() {
    }

    int nodeId;
    int data;
    boolean visited = false;
}

class AdjListNode {

    private Node vertex;
    private List<Node> neighbours;

    public AdjListNode(Node vertex, List<Node> neighbours) {
        this.vertex = vertex;
        this.neighbours = neighbours;
    }

    public Node getVertex() {
        return vertex;
    }

    public void setVertex(Node vertex) {
        this.vertex = vertex;
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Node> neighbours) {
        this.neighbours = neighbours;
    }

}
