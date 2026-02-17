package binary_trees.medium;

import java.util.*;

public class Tree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;

            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void preorder(Node root) { // TC = O(n)
        if (root == null) {
            // System.out.print("-1"+" ");
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root) { // TC = O(n)
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void postorder(Node root) { // TC = O(n)
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder1(Node root) { // TC = O(n)

        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            Node currNode = q.remove();
            System.out.print(currNode.data + " ");

            if (currNode.left != null) {
                q.add(currNode.left);
            }

            if (currNode.right != null) {
                q.add(currNode.right);
            }
        }
    }

    public static void levelOrder2(Node root) { // TC = O(n)

        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");

                if (currNode.left != null) {
                    q.add(currNode.left);
                }

                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static void levelOrder(Node root) { // TC = O(n)
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {

            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {

                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }

                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Root : " + root.data);

        System.out.println("===== Preorder ====");
        preorder(root);
        System.out.println();

        System.out.println("===== Inorder =====");
        inorder(root);
        System.out.println();

        System.out.println("===== Postorder =====");
        postorder(root);
        System.out.println();

        System.out.println("===== LevelOrder1 =====");
        levelOrder1(root);
        System.out.println();

        System.out.println("===== LevelOrder2 =====");
        levelOrder2(root);
    }
}



/*
 * 🔹 1. What this code is doing (big picture) :=====>
 * You are building a Binary Tree from a preorder sequence
 * -1 means null node
 * Preorder order = Root → Left → Right
 * Your input:
 * int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
 * 
 * 🔹 2. Node class (Tree structure) :=====>
 * static class Node {
 * int data;
 * Node left;
 * Node right;
 * 
 * Each node has:
 * data → value
 * left → left child
 * right → right child
 * 
 * Constructor:==>
 * Node(int data) {
 * this.data = data;
 * this.left = null;
 * this.right = null;
 * }
 * 
 * 🔹 3. Why idx is static and global :=====>
 * static int idx = -1;
 * 
 * idx tracks current position in array
 * Static because: :=====>
 * Recursive calls must share the same index
 * If it was local, recursion would break
 * 
 * 🔹 4. buildTree() logic (core part) :=====>
 * public static Node buildTree(int nodes[]) {
 * idx++;
 * 
 * Every recursive call:
 * Moves to the next element in preorder array
 * 
 * 🔸 Base Case (Stopping condition) :=====>
 * if (nodes[idx] == -1) {
 * return null;
 * }
 * 
 * Meaning: :=====>
 * -1 ⇒ no node here
 * Return null
 * This becomes a leaf child
 * 
 * 🔸 Create current node :=====>
 * Node newNode = new Node(nodes[idx]);
 * 
 * Create a node with current value
 * This value is treated as root of current subtree
 * 
 * 🔸 Build left subtree (IMPORTANT) :=====>
 * newNode.left = buildTree(nodes);
 * 
 * Recursively build left child
 * Consumes array elements in preorder
 * 
 * 🔸 Build right subtree :=====>
 * newNode.right = buildTree(nodes);
 * 
 * After left subtree completes
 * Build right child
 * 
 * 🔸 Return node :=====>
 * return newNode;
 * 
 * Returns fully constructed subtree
 * 
 * 🔹 5. Step-by-step execution (VERY IMPORTANT) :=====>
 * Let’s trace your array:
 * Index: 0 1 2 3 4 5 6 7 8 9 10 11 12
 * Nodes: [1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1]
 * 
 * ▶ Step 1 :===>
 * idx = 0
 * Value = 1
 * Create root = 1
 * 
 * ▶ Step 2 (left of 1) :===>
 * idx = 1
 * Value = 2
 * Create node 2
 * 
 * ▶ Step 3 (left of 2) :===>
 * idx = 2
 * Value = 4
 * Create node 4
 * 
 * ▶ Step 4 (left of 4) :===>
 * idx = 3
 * Value = -1 → return null
 * 
 * ▶ Step 5 (right of 4) :===>
 * idx = 4
 * Value = -1 → return null
 * ➡ Node 4 is a leaf
 * 
 * ▶ Step 6 (right of 2) :===>
 * idx = 5
 * Value = 5
 * Create node 5
 * 
 * ▶ Step 7 (left of 5) :===>
 * idx = 6
 * -1 → null
 * 
 * ▶ Step 8 (right of 5) :===>
 * idx = 7
 * -1 → null
 * 
 * ➡ Node 5 is leaf
 * ➡ Node 2 completed
 * 
 * ▶ Step 9 (right of 1) :===>
 * idx = 8
 * Value = 3
 * Create node 3
 * 
 * ▶ Step 10 (left of 3) :===>
 * idx = 9
 * -1 → null
 * 
 * ▶ Step 11 (right of 3) :===>
 * idx = 10
 * Value = 6
 * Create node 6
 * 
 * ▶ Step 12 (left of 6) :===>
 * idx = 11
 * -1 → null
 * 
 * ▶ Step 13 (right of 6) :===>
 * idx = 12
 * -1 → null
 * 
 * 🔹 6. Final Tree Structure
 * 1
 * / \
 * 2 3
 * / \ \
 * 4 5 6
 * 
 * 🔹 7. Why System.out.println(root.data);
 * System.out.println(root.data);
 * 
 * Prints root value :===>
 * Output: 1
 * 
 * 🔹 8. One-line summary :===>
 * 👉 This code builds a binary tree from preorder traversal using -1 as null
 * marker and recursion.
 * 
 * =============================
 * 
 * 🔹 Why does root become 1?
 * Because of this order:
 * idx starts at -1
 * First call → idx++ → idx = 0
 * nodes[0] = 1
 * So the first node created is 1
 * This becomes the root of the tree
 * 
 * Node root = tree.buildTree(nodes);
 * So:==>
 * root points to the node with data = 1
 * 
 * Think of it like this (real-life example)
 * Node box = new Node(1);
 * return box;
 * 
 * You returned the box, not the number.
 * System.out.println(box.data);
 * That prints what’s inside the box → 1
 * 
 * ===========================
 * 
 * 🔹 Step-by-step example (real execution) :===>
 * Using your array:
 * { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 }
 * 
 * ▶ First call (root) :===>
 * idx = 0
 * newNode = 1
 * 
 * Now Java reaches:
 * newNode.left = buildTree(nodes);
 * 
 * ⏸️ Java pauses current function
 * ➡️ Goes to build left subtree of 1
 * 
 * ▶ Second call (left of 1) :===>
 * idx = 1
 * newNode = 2
 * Again:
 * newNode.left = buildTree(nodes);
 * 
 * ⏸️ Pause
 * ➡️ Build left subtree of 2
 * 
 * ▶ Third call (left of 2) :===>
 * idx = 2
 * newNode = 4
 * Again:
 * newNode.left = buildTree(nodes);
 * 
 * ⏸️ Pause
 * ➡️ Build left subtree of 4
 * 
 * ▶ Fourth call (left of 4) :===>
 * idx = 3
 * Value = -1
 * return null;
 * 
 * ⬅️ Function returns null
 * So now:
 * 4.left = null;
 * 
 * ▶ Right of 4
 * newNode.right = buildTree(nodes);
 * idx = 4
 * -1 → return null
 * So:
 * 4.right = null;
 * 
 * Node 4 is complete → return node 4
 * 
 * ▶ Back to node 2
 * Returned value = Node(4)
 * So:
 * 2.left = Node(4)
 * 
 * Now build right of 2:
 * idx = 5
 * newNode = 5
 * Left → -1
 * Right → -1
 * Return Node(5)
 * So:
 * 2.right = Node(5)
 * 
 * Return node 2
 * 
 * ▶ Back to node 1
 * Returned value = Node(2)
 * 
 * So:
 * 1.left = Node(2)
 * Then right subtree builds similarly.
 * 
 * 🔹 Key mental model (VERY IMPORTANT)
 * Think of recursion like this:
 * “Build child first, then attach it to parent.”
 * 
 * Each call:
 * Creates a node
 * Fully builds its left subtree
 * Fully builds its right subtree
 * Returns itself to its parent
 * 
 * 🔹 Why assignment works
 * Because:=>
 * buildTree(nodes) → returns Node
 * 
 * And:=>
 * newNode.left → expects Node
 * 
 * Perfect match ✔️
 * 
 * 🔹 One-line summary
 * 👉 newNode.left = buildTree(nodes);
 * means “recursively create the left subtree and connect it here.”
 * 
 * 
 * // ===============================
 * 🔁 Important Point :=====>
 * buildTree() recursion me 3 steps follow karta hai:=>
 * 1. Node banao
 * 2. Left call karo
 * 3. Right call karo
 * 
 * Aur idx global variable hai jo har call me aage badhta hai.
 * 
 * 🚀 Ab Main Part — 4 ke left me kya hua?
 * Step by step dekho:
 * 👉 1 bana
 * idx = 0
 * 
 * 👉 2 bana
 * idx = 1
 * 
 * 👉 4 bana
 * idx = 2
 * 
 * Ab 4 ke liye:=>
 * newNode.left = buildTree(nodes);
 * 
 * 🔹 4 ka LEFT
 * idx = 3
 * 
 * nodes[3] = -1
 * 
 * Iska matlab:
 * if (nodes[idx] == -1) {
 * return null;
 * }
 * 
 * Toh function null return karta hai
 * 👉 Matlab 4 ka left = null
 * 
 * ❓ Ab important sawal:==>
 * "Return null hone ke baad 4 ke right ko kaise call laga?"
 * 
 * Dhyaan do 👇
 * Jab left call khatam hoti hai, tab control wapas 4 wale function me aata hai.
 * Ye line ab execute hoti hai:=>
 * newNode.right = buildTree(nodes);
 * 
 * 🔹 4 ka RIGHT
 * idx = 4
 * nodes[4] = -1
 * Phir se:=>
 * return null;
 * 
 * 👉 Matlab 4 ka right = null
 * 
 * 🔁 Ab kya hua?
 * 4 ke left aur right dono ho gaye.
 * Toh 4 ka kaam complete.
 * Ab function return karta hai:=>
 * 
 * return newNode; // 4 return ho gaya
 * 
 * Control wapas jata hai node 2 ke paas.
 * 
 * 🧠 Ab samjho 2 par kaise gaya?
 * 
 * Yaad karo:=>
 * newNode.left = buildTree(nodes);
 * 
 * Ye line 2 ke liye call hui thi.
 * Aur wo call 4 bana raha tha.
 * Ab 4 complete ho gaya.
 * Toh 2 ke liye:=>
 * 2 ka left = 4
 * 
 * Ab 2 ka right call lagega.
 * 
 * ===============================
 * 
 * 🌳 Sabse pehle samjho: -1 ka matlab kya hai? :====>
 * Tumhare array me:
 * { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 }
 * 
 * Yaha -1 ka meaning hai:
 * ❌ Yaha koi node exist nahi karta
 * 
 * Matlab:
 * Ye empty child hai
 * Ye leaf ka end hai
 * 
 * 💡 Ek Line Me Final Answer :=====>
 * -1 ka matlab hai "node exist nahi karta"
 * Aur Java me non-existing node ko represent karte hain → null se
 * 
 * Isliye return null karte hain.
 * 
 * ==============================
 * Preorder Traversal :=====>
 * 
 * public static void preorder(Node root) {
 * if (root == null) {
 * return;
 * }
 * 
 * System.out.print(root.data + " ");
 * preorder(root.left);
 * preorder(root.right);
 * }
 * 
 * 🌳 Example Tree :==>
 * Let’s take this tree:
 * 
 * 1
 * / \
 * 2 3
 * / \
 * 4 5
 * 
 * Now we call :==>
 * 
 * preorder(root); // root = 1
 * 🔥 Important Rule
 * Preorder =
 * 👉 Root → Left → Right
 * 
 * So every time:
 * Print node
 * Go left
 * Go right
 * 
 * 🧠 Step-by-Step Working (Call Stack Visualization)
 * ✅ Step 1 :==>
 * Call: preorder(1)
 * 
 * root ≠ null
 * Print 1
 * Output: 1
 * 
 * Now go left: :==>
 * preorder(2)
 * 
 * ✅ Step 2 :==>
 * Call: preorder(2)
 * 
 * Print 2
 * Output: 1 2
 * 
 * Go left: :==>
 * preorder(4)
 * 
 * ✅ Step 3 :==>
 * Call: preorder(4)
 * 
 * Print 4
 * Output: 1 2 4
 * 
 * Go left: :==>
 * preorder(null)
 * 
 * ✅ Step 4 :==>
 * Call: preorder(null)
 * 
 * root == null
 * return
 * 
 * Now go right of 4: :==>
 * preorder(null)
 * Again return.
 * 
 * Now node 4 is completely finished ✅
 * We go back to node 2.
 * 
 * ✅ Step 5 :==>
 * Now at node 2, left is done.
 * 
 * Go right: :==>
 * preorder(5)
 * 
 * ✅ Step 6 :==>
 * Call: preorder(5)
 * 
 * Print 5
 * Output: 1 2 4 5
 * 
 * Go left → null → return
 * Go right → null → return
 * 
 * Node 5 finished ✅
 * Node 2 finished ✅
 * 
 * Now go back to node 1.
 * 
 * ✅ Step 7 :==>
 * At node 1, left subtree finished.
 * 
 * Now go right: :==>
 * preorder(3)
 * 
 * ✅ Step 8 :==>
 * Call: preorder(3)
 * 
 * Print 3
 * Output: 1 2 4 5 3
 * 
 * Left → null
 * Right → null
 * 
 * Node 3 finished ✅
 * 
 * 🎯 Final Output :====>
 * 1 2 4 5 3
 * 
 * =======================================
 * Level Order Traversal :=======>
 * 
 * public static void levelOrder1(Node root) { // TC = O(n)
 * if (root == null) {
 * return;
 * }
 * 
 * Queue<Node> q = new LinkedList<>();
 * q.add(root);
 * 
 * while (!q.isEmpty()) {
 * 
 * Node currNode = q.remove();
 * System.out.print(currNode.data + " ");
 * 
 * if (currNode.left != null) {
 * q.add(currNode.left);
 * }
 * 
 * if (currNode.right != null) {
 * q.add(currNode.right);
 * }
 * }
 * }
 * 
 * ✅ Why We Store Node Instead of Data :========>
 * When we do:==>
 * Node currNode = q.remove();
 * 
 * We now have:==>
 * currNode.data
 * currNode.left
 * currNode.right
 * 
 * So we can: :========>
 * if (currNode.left != null)
 * q.add(currNode.left);
 * 
 * 
 * This is only possible because we stored the full Node.
 * 
 * 🔍 Simple Analogy :========>
 * Think of Node like a box 📦
 * Inside the box:==>
 * value
 * left address
 * right address
 * 
 * If you only store value (number),
 * you lose the addresses.
 * 
 * But if you store the box (Node),
 * you can open it and access everything.
 * 
 * 🎯 Visual Understanding
 * When queue contains: :===>
 * [2]
 * 
 * Actually it contains:=>
 * Node object of 2
 * 
 * Inside that object:==>
 * data = 2
 * left = 4
 * right = 5
 * 
 * So after removing:==>
 * Node currNode = q.remove();
 * 
 * We can do:==>
 * currNode.left → 4
 * currNode.right → 5
 * 
 * 💡 Important Concept :========>
 * Queue is storing references (memory addresses) of Node objects.
 * Not just primitive values.
 * 
 * 🔥 If We Stored Only Data (Wrong Way)
 * 
 * Imagine:
 * Queue<Integer> q = new LinkedList<>();
 * 
 * Then:=>
 * q.add(root.data);
 * 
 * Now queue has only numbers.
 * After removing 2:
 * 
 * How will you find its left child?
 * So traversal will break.
 * 
 * 🚀 Final Clear Answer :========>
 * We store Node in queue because:==>
 * ✔ We need access to left child
 * ✔ We need access to right child
 * ✔ Data alone is not enough
 * 
 * That’s the core logic.
 * 
 */
