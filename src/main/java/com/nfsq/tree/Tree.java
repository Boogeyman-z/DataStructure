package com.nfsq.tree;

/**
 * 二叉树的具体方法
 */
public class Tree {

    private Node root;

    /**
     * 查找节点
     * @param key
     * @return
     */
    public Node find(int key){
        Node current = this.root;
        while (current != null){
            //查左树
            if(current.data>key){
                current = current.leftChild;
            //查右树
            }else if(current.data<key){
                current = current.rightChild;
            //直接返回
            }else{
                return current;
            }
        }
        return null;
    }

    /**
     * 新增节点
     * @param key
     * @return
     */
    public boolean insert(int key){
        Node node = new Node(key);
        if(root == null){
            root = node;
            return true;
        }else{
            Node current = this.root;
            Node parentNode = null;
            while (current != null){
                parentNode = current;
                if(current.data > key){
                    current = parentNode.leftChild;
                    if(current == null){
                        parentNode.leftChild = node;
                        return true;
                    }
                }else{
                    current = parentNode.rightChild;
                    if(current == null){
                        parentNode.rightChild = node;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //中序遍历
    public void infixOrder(Node current){
        if(current != null){
            infixOrder(current.leftChild);
            System.out.print(current.data + " ");
            infixOrder(current.rightChild);
        }
    }

    //前序遍历
    public void preOrder(Node current){
        if(current != null){
            System.out.print(current.data + " ");
            preOrder(current.leftChild);
            preOrder(current.rightChild);
        }
    }

    //后序遍历
    public void postOrder(Node current) {
        if (current != null) {
            postOrder(current.leftChild);
            postOrder(current.rightChild);
            System.out.print(current.data + " ");
        }
    }

    //返回最大值
    public Node findMax(){
        Node current = this.root;
        Node maxNode = current;
        while (current != null) {
            maxNode = current;
            current = current.rightChild;
        }
        return maxNode;
    }

    //返回最小值
    public Node findMin(){
        Node current = this.root;
        Node minNode = current;
        while (current != null) {
            minNode = current;
            current = current.leftChild;
        }
        return minNode;
    }



    /**
     * 删除节点
     */
    public boolean delete(int key){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;
        //查找删除值，查找不到直接返回false
        while (current.data != key) {
            parent = current;
            if(current.data > key){
                isLeftChild = true;
                current = current.leftChild;
            }else{
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }

        if(current.rightChild == null && current.leftChild == null){
            if(current == root){
                root = null;
            }else if(isLeftChild){
                parent.leftChild = null;
            }else{
                parent.rightChild = null;
            }
        }else if(current.rightChild != null && current.leftChild == null){
            if (current == root) {
                root = current.rightChild;
            }else if(isLeftChild){
                parent.leftChild = current.rightChild;
            }else{
                parent.rightChild = current.rightChild;
            }
        }else{
            if(current == root){
                root = current.leftChild;
            }else if(isLeftChild){
                parent.leftChild = current.leftChild;
            }else{
                parent.rightChild = current.leftChild;
            }
        }
        return true;
    }








}
