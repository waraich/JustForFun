import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Implementation of the Breadth first search and depth first search
 * @author singhg01
 *
 * @param <E>
 */
public class GraphNode<E> {

    private E data;
    private boolean visited;
    private List<GraphNode<E>> neighbours;

    public GraphNode(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<GraphNode<E>> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<GraphNode<E>> neighbours) {
        this.neighbours = neighbours;
    }

    public void bfs() {

        Queue<GraphNode<E>> queue = new LinkedList<GraphNode<E>>();
        if (this.neighbours != null)
            queue.addAll(this.neighbours);
        System.out.println(this.data);
        this.visited = true;
        while (!queue.isEmpty()) {
            GraphNode<E> node = queue.poll();
            if (!node.visited) {
                System.out.println(node.data);
                node.visited = true;
                if (node.getNeighbours() != null)
                    queue.addAll(node.getNeighbours());

            }
        }

    }

    public void dfs() {
        Stack<GraphNode<E>> stack = new Stack<GraphNode<E>>();
        if (this.neighbours != null)
            stack.addAll(this.neighbours);
        System.out.println(this.data);
        this.visited = true;
        while (!stack.isEmpty()) {
            GraphNode<E> node = stack.pop();
            if (!node.visited) {
                System.out.println(node.data);
                node.visited = true;
                if (node.getNeighbours() != null)
                    stack.addAll(node.getNeighbours());

            }
        }

    }
    
    public void topologicalSort(){
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        GraphNode<Integer> node1 = new GraphNode<Integer>(1);
        GraphNode<Integer> node2 = new GraphNode<Integer>(2);
        GraphNode<Integer> node3 = new GraphNode<Integer>(3);
        GraphNode<Integer> node4 = new GraphNode<Integer>(4);
        GraphNode<Integer> node5 = new GraphNode<Integer>(5);
        GraphNode<Integer> node6 = new GraphNode<Integer>(6);
        GraphNode<Integer> node7 = new GraphNode<Integer>(7);
        GraphNode<Integer> node8 = new GraphNode<Integer>(8);

        List<GraphNode<Integer>> list1 = new ArrayList<GraphNode<Integer>>();
        list1.add(node2);
        list1.add(node3);
        list1.add(node4);
        node1.setNeighbours(list1);
        List<GraphNode<Integer>> list2 = new ArrayList<GraphNode<Integer>>();
        list2.add(node1);
        list2.add(node5);
        list2.add(node6);
        node2.setNeighbours(list2);
        List<GraphNode<Integer>> list3 = new ArrayList<GraphNode<Integer>>();
        list3.add(node3);
        list3.add(node7);
        list3.add(node1);
        list3.add(node2);
        list3.add(node5);
        list3.add(node8);
        node3.setNeighbours(list3);

        node3.dfs();

    }

}
