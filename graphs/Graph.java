package graphs;

import java.util.*;

public class Graph {
    static class Edge {
        int src; // soure
        int dest;// destination
        int wt; // weight

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        int totalVertex = 5;
        // int arr[] = new int [totalVertex];

        @SuppressWarnings("unchecked") // for remove warning

        ArrayList<Edge>[] graph = new ArrayList[totalVertex];
        // We are storing Edge in ArrayList so data type of ArrayList is Edge.

        // null -> empty arraylist

        for (int i = 0; i < totalVertex; i++) {
            graph[i] = new ArrayList<>();
        }

        // vertex - 0
        graph[0].add(new Edge(0, 1, 5));

        // vertex - 1
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // vertex- 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        // vertex - 3
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // vertex - 4
        graph[4].add(new Edge(4, 2, 2));

        System.out.println("Vetex 2 neighbors(source ----(weight)----> destination :");

        // for (int i = 0; i < graph[2].size(); i++) {
        // Edge e = graph[2].get(i); // src,dest,wt
        // System.out.println(e.src + "---" + "(" + e.wt + ")" + "---" + "->" + e.dest);
        // }

        for (Edge e : graph[2]) {
            System.out.println(e.src + "---" + "(" + e.wt + ")" + "---" + "->" + e.dest);
        }
    }
}

/**
 * 🔷 1. What is this program doing? ===>
 * This program is creating a Graph using Adjacency List and then printing
 * neighbors of vertex 2.
 * 
 * 🔷 2. Understanding the Edge class ===>
 * static class Edge {
 * int src;
 * int dest;
 * int wt;
 * }
 * 
 * 👉 Each object of Edge represents a connection (edge) in the graph.
 * Example: ===>
 * new Edge(2, 3, 1)
 * 
 * Means: ===>
 * Source = 2
 * Destination = 3
 * Weight = 1
 * 
 * 👉 So basically: ===>
 * 2 ----(1)----> 3
 * 
 * 🔷 3. Graph Representation ===>
 * ArrayList<Edge>[] graph = new ArrayList[totalVertex];
 * 
 * 👉 This is an array of ArrayLists
 * 
 * So structure looks like: ===>
 * graph[0] → list of edges from vertex 0
 * graph[1] → list of edges from vertex 1
 * graph[2] → list of edges from vertex 2
 * ...
 * 
 * 🔷 4. Initialization ===>
 * for (int i = 0; i < totalVertex; i++) {
 * graph[i] = new ArrayList<>();
 * }
 * 
 * 👉 Important: ===>
 * Initially all values are null, so we create empty lists.
 * 
 * Now: ===>
 * graph[0] = []
 * graph[1] = []
 * graph[2] = []
 * graph[3] = []
 * graph[4] = []
 * 
 * 🔷 Why are all values null initially? ===>
 *
 * When you write: ===>
 * ArrayList<Edge>[] graph = new ArrayList[totalVertex];
 * 
 * 👉 You are creating an array of references, not actual ArrayLists.
 * 
 * 🔥 What actually happens in memory?
 * Suppose: ===>
 * int totalVertex = 5;
 * 
 * Then: ===>
 * ArrayList<Edge>[] graph = new ArrayList[5];
 * 
 * 👉 Memory looks like this: ===>
 * 
 * Index ==> Value
 * 0 ==> null
 * 1 ==> null
 * 2 ==> null
 * 3 ==> null
 * 4 ==> null
 * 
 * 🔷 Why null?
 * Because: ===>
 * 👉 In Java, arrays of objects store references
 * 👉 And default value of any object reference = null
 * 
 * So: ===>
 * graph[i] = null
 * 
 * means: ===>
 * “No ArrayList is created yet at this index”
 * 
 * 🔷 Important Difference ⚠️ ===>
 * ❌ This does NOT create ArrayLists:
 * new ArrayList[5];
 * 
 * 👉 It only creates space for 5 references.
 * 
 * ✅ This creates actual ArrayLists:
 * for (int i = 0; i < totalVertex; i++) {
 * graph[i] = new ArrayList<>();
 * }
 * 
 * Now memory becomes :===>
 * Index ==> Value
 * 0 ==> []
 * 1 ==> []
 * 2 ==> []
 * 3 ==> []
 * 4 ==> []
 * 
 * 🔥 What happens if you don’t initialize?
 * 
 * If you do this :===>
 * graph[0].add(new Edge(0, 1, 5));
 * 
 * 👉 You’ll get:
 * NullPointerException ❌
 * 
 * Because: :===>
 * graph[0] = null
 * 
 * And you're trying :===>
 * null.add(...)
 * 
 * 🔷 Simple Analogy 🧠
 * 
 * Think of it like: ===>
 * graph = row of empty boxes
 * Initially → boxes are empty (null)
 * Then you put ArrayList inside each box
 * 
 * 🔷 One-line Summary ⭐ :===>
 * 👉 new ArrayList[5] creates only the container (array)
 * 👉 NOT the actual ArrayList objects inside it
 * 
 * 🔥 Interview Tip :====>
 * If interviewer asks :
 * 👉 “Why do we initialize each index?”
 * You say:=>
 * Because array stores references, and each index is null by default. We must
 * explicitly create ArrayList objects to store edges.
 * 
 * 
 * 🔷 5. Adding Edges :====>
 * Now edges are added:
 * 
 * Vertex 0 ==>
 * graph[0].add(new Edge(0, 1, 5));
 * 
 * 👉 0 → 1
 * 
 * Vertex 1 ==>
 * graph[1].add(new Edge(1, 0, 5));
 * graph[1].add(new Edge(1, 2, 1));
 * graph[1].add(new Edge(1, 3, 3));
 * 
 * graph[1] → ArrayList
 * ========== │
 * ========== ├── [0] → Edge(1,0,5)
 * ========== ├── [1] → Edge(1,2,1)
 * ========== └── [2] → Edge(1,3,3)
 * 
 * 👉 1 → 0, 2, 3(destinatinos)
 * 
 * Vertex 2 ==>
 * graph[2].add(new Edge(2, 1, 1));
 * graph[2].add(new Edge(2, 3, 1));
 * graph[2].add(new Edge(2, 4, 2));
 * 
 * 👉 2 → 1, 3, 4
 * 
 * Vertex 3 ==>
 * graph[3].add(new Edge(3, 1, 3));
 * graph[3].add(new Edge(3, 2, 1));
 * 
 * 👉 3 → 1, 2
 * 
 * Vertex 4 ==>
 * graph[4].add(new Edge(4, 2, 2));
 * 
 * 👉 4 → 2
 * 
 * 
 * 🔷 6. Graph Visualization :====>
 * This graph looks like:
 * 
 * 0 ---- 1 ---- 3
 * | /
 * | /  
 * 2 ---- 4
 * 
 * 🔷 7. Printing Neighbors of Vertex 2 :====>
 * for (int i = 0; i < graph[2].size(); i++) {
 * Edge e = graph[2].get(i);
 * System.out.println(e.src + " -> " + e.dest);
 * }
 * 
 * 👉 graph[2] contains:
 * (2 → 1)
 * (2 → 3)
 * (2 → 4)
 * 
 * Output:
 * 2 -> 1
 * 2 -> 3
 * 2 -> 4
 * 
 * 🔷 8. Important Concept (Interview Point ⭐) :====>
 * 👉 This is called Adjacency List Representation
 * 
 * Why we use it? ==>
 * 1.Saves space.
 * 2.Efficient for sparse graphs.
 * 
 * 🔷 9. Key Takeaways :====>
 * 
 * ✔ Graph is stored as: ==>
 * Array of ArrayList
 * 
 * ✔ Each index = vertex
 * ✔ Each list = neighbors of that vertex
 * 
 * ✔ Edge class stores:
 * 1.source
 * 2.destination
 * 3.weight
 * 
 * 🔥 10. Real Understanding (Most Important) :====>
 * When you write:==>
 * 
 * graph[2]
 * 
 * 👉 You are asking :==>
 * “Tell me all nodes connected to vertex 2”
 * 
 * ==============================================
 * 
 * 🔷 Your line:====>
 * ArrayList<Edge>[] graph = new ArrayList[totalVertex];
 * 
 * 🔴 Why warning comes?
 * 👉 Because of Generics + Array mismatch in Java.
 * 
 * Java gives warning like:====>
 * 
 * Type safety: Unchecked conversion from ArrayList[] to ArrayList<Edge>[]
 * 🔥 Root Reason (Important Concept) ====>
 * 1. Arrays are type-safe ==>
 * Arrays know their type at runtime.
 * 
 * Example:==>
 * String[] arr = new String[5];
 * 
 * 2. Generics are NOT fully available at runtime
 * This is called:==>
 * 👉 Type Erasure
 * 
 * Meaning:==>
 * ArrayList<Edge>
 * 
 * becomes:==>
 * ArrayList
 * at runtime.
 * 
 * ⚠️ Problem happens here ==>
 * new ArrayList[totalVertex]
 * 
 * 👉 This creates:==>
 * ArrayList[]
 * 
 * But you are assigning it to:==>
 * ArrayList<Edge>[]
 * 
 * 👉 Java says:==>
 * “I cannot guarantee type safety here” ❌
 * 
 * 🔷 Why Java doesn’t allow this properly?
 * Because it can break type safety:
 * 
 * Object[] arr = new ArrayList[5];
 * arr[0] = new ArrayList<String>(); // allowed
 * arr[1] = new ArrayList<Integer>(); // also allowed ❌
 * 
 * Now confusion:==>
 * ArrayList<Edge>[] graph
 * 
 * 👉 But actual data may contain String or Integer
 * 👉 That’s dangerous → so Java warns ⚠️
 * 
 * 🔷 How to fix it? ====>
 * ✅ Method 1 (Most common)
 * ArrayList<Edge>[] graph = new ArrayList[totalVertex];
 * 
 * 👉 Keep it like this and ignore warning
 * 👉 This is standard in graph questions (even in interviews)
 * 
 * ✅ Method 2 (Suppress warning)
 * @SuppressWarnings("unchecked")
 * ArrayList<Edge>[] graph = new ArrayList[totalVertex];
 * 
 * ✅ Method 3 (Better, no warning)
 * Use List instead of array
 * ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
 * 
 * Then:==>
 * for (int i = 0; i < totalVertex; i++) {
 * graph.add(new ArrayList<>());
 * }
 * 
 * 👉 This is 100% safe and modern approach ✅
 * 
 * 🔥 Which one should YOU use?
 * Since you're learning DSA:
 * 
 * 👉 Use this:
 * ArrayList<Edge>[] graph
 * 
 * ✔ Easy
 * ✔ Common in interviews
 * ✔ Used in most tutorials
 * 
 * 🔥 One-line summary ⭐ ====>
 * 👉 Warning comes because:
 * Java cannot guarantee type safety when creating generic arrays due to type
 * erasure.
 * 
 */