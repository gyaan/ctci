import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by lenskart on 04/03/2017.
 */

/**
 * Graph node
 */
class GraphNode {
    int data;
    LinkedList<GraphNode> adjacentNodes;

    GraphNode(int value) {
        this.data = value;
        this.adjacentNodes = new LinkedList<>();
    }
}

public class MyGraph {

    GraphNode root;
    HashSet<GraphNode> hashSetForDFS;
    HashSet<GraphNode> hashSetForBFS;

    /**
     * @param root for the graph
     */
    MyGraph(GraphNode root) {
        this.root = root;
        this.hashSetForDFS = new HashSet();
        this.hashSetForBFS = new HashSet();
    }

    /**
     * function to call DFS algo function
     */
    public void DFS() {
        this.DFSAlgorithm(this.root);
    }

    /**
     * recursive method for DFS
     *
     * @param n
     */
    private void DFSAlgorithm(GraphNode n) {
        if (n == null)
            return;

        //if node already visited
        if(this.hashSetForDFS.contains(n))
            return;

        //print the node value
        System.out.println(n.data);

        //mark visited
        this.hashSetForDFS.add(n);

        //check for all adjacent node
        n.adjacentNodes.forEach(this::DFSAlgorithm);
    }

    /**
     * function to call BFS algo
     */
    public void BFS() {
        this.BFSAlgorithm(this.root);
    }

    /**
     * BFS method for the graph
     *
     * @param root
     */
    private void BFSAlgorithm(GraphNode root) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            GraphNode temp = queue.pop();

            //node already visited
            if(this.hashSetForBFS.contains(temp))
                continue;

            //print the data
            System.out.println(temp.data);

            //mark visited
            this.hashSetForBFS.add(temp);

            //push adjacent to queue
            temp.adjacentNodes.forEach(queue::push);
        }
    }

    public static void main(String[] args) {

        GraphNode node = new GraphNode(3);
        GraphNode node1 = new GraphNode(4);
        node.adjacentNodes.add(node1);
        GraphNode node2 = new GraphNode(5);
        node.adjacentNodes.add(node2);
        GraphNode node3 = new GraphNode(6);
        node.adjacentNodes.add(node3);
        GraphNode node4 = new GraphNode(7);
        node.adjacentNodes.add(node4);
        GraphNode node5 = new GraphNode(8);
        node.adjacentNodes.add(node5);

        node2.adjacentNodes.add(node4);
        node2.adjacentNodes.add(node5);


        MyGraph myGraph = new MyGraph(node);
        System.out.println("DFS!");
        myGraph.DFS();
        System.out.println("BFS!");
        myGraph.BFS();

    }

}
