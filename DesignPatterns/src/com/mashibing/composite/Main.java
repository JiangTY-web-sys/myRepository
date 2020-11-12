package src.com.mashibing.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @description :组合模式(树状结构)
 * @author：jty
 * @date: 2020-11-12
 * @sine: 0.0.1
 */
abstract class Node{
    public abstract void p();
}

class LeafNode extends Node {
    String content;

    public LeafNode(String content) {
        this.content = content;
    }

    @Override
    public void p() {
        System.out.println(content);
    }
}

class BranchNode extends Node {
    List<Node> nodes = new ArrayList<>();

    String name;

    public BranchNode(String name) {
        this.name = name;
    }

    @Override
    public void p() {
        System.out.println(name);
    }

    public void add (Node n) {
        nodes.add(n);
    }
}

public class Main {
    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        BranchNode chapter1 = new BranchNode("chapter1");
        BranchNode chapter2 = new BranchNode("chapter2");
        Node r1 = new LeafNode("r1");
        Node c11 = new LeafNode("c11");
        Node c12 = new LeafNode("c12");
        BranchNode b12 = new BranchNode("section2");
        Node c211 = new LeafNode("c211");
        Node c212 = new LeafNode("c212");

        root.add(chapter1);
        root.add(chapter2);
        root.add(r1);
        chapter1.add(c11);
        chapter1.add(c12);
        chapter2.add(b12);
        b12.add(c211);
        b12.add(c212);

        tree(root, 0);
    }

    //递归函数
    static void tree(Node n, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }
        n.p();
        if (n instanceof BranchNode) {
            for (Node b : ((BranchNode) n).nodes) {
                tree(b, depth +1);
            }
        }
    }
}
