/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.util.Iterator;

public class DirectedEulerianCycle {
    private Stack<Integer> cycle = null;

    public DirectedEulerianCycle(Digraph G) {
        if (G.E() == 0) return;

        for (int v = 0; v < G.V(); v++) {
            if (G.outdegree(v) != G.indegree(v))
                return;
        }
        Iterator<Integer>[] adj = (Iterator<Integer>[]) new Iterator[G.V()];
        for (int v = 0; v < G.V(); v++) {
            adj[v] = G.adj(v).iterator();
        }

        int s = nonIsolatedVertex(G);
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(s);
        cycle = new Stack<Integer>();
        while (!stack.isEmpty()) {
            int v = stack.pop();
            while (adj[v].hasNext()) {
                stack.push(v);
                v = adj[v].next();
            }
            cycle.push(v);
        }
        if (cycle.size() != G.E() + 1)
            cycle = null;

        assert certifySolution(G);
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    public boolean hasEulerianCycle() {
        return cycle != null;
    }

    private static int nonIsolatedVertex(Digraph G) {
        for (int v = 0; v < G.V(); v++) {
            if (G.outdegree(v) > 0)
                return v;
        }
        return -1;
    }


    // The code below is solely for testing correctness of the date type.


    private static boolean statisfiesNecessaryAndSufficientConditions(Digraph G) {
        if (G.E() == 0) return false;

        for (int v = 0; v < G.V(); v++) {
            if (G.outdegree(v) != G.indegree(v))
                return false;
        }

        Graph H = new Graph(G.V());
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                H.addEdge(v, w);
            }
        }

        int s = nonIsolatedVertex(G);
        BreadthFirstPaths bfs = new BreadthFirstPaths(H, s);
        for (int v = 0; v < G.V(); v++) {
            if (H.degree(v) > 0 && !bfs.hasPathTo(v))
                return false;
        }
        return true;
    }

    private boolean certifySolution(Digraph G) {
        if (hasEulerianCycle() == (cycle() == null)) return false;

        if (hasEulerianCycle() != statisfiesNecessaryAndSufficientConditions(G)) return false;

        if (cycle == null) return true;

        if (cycle.size() != G.E() + 1) return false;

        return true;
    }

    private static void unitTest(Digraph G, String description) {
        StdOut.println(description);
        StdOut.println("--------------------------");
        StdOut.print(G);

        DirectedEulerianCycle euler = new DirectedEulerianCycle(G);

        StdOut.print("Eulerian cycle");
        if (euler.hasEulerianCycle()) {
            for (int v : euler.cycle()) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
        else {
            StdOut.println("none");
        }
        StdOut.println();
    }


    public static void main(String[] args) {

    }
}
