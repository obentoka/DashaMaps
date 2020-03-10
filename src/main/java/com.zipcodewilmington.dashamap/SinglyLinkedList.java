package com.zipcodewilmington.dashamap;

public class SinglyLinkedList<K, V> {

    private Node<K, V>  head;
    private Node<K, V> tail;
    private Integer size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public Boolean add(Node<K, V> newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
        } else if (head != null) {
            tail.setNextNode(newNode);
            tail = newNode;
            size++;
        }
        return true;
    }

    public Boolean remove(Integer valueToRemove) {
        Node<K, V>  iterateNode = head;
        while (iterateNode.getNext() != null){
            if(iterateNode.getValue().equals(valueToRemove) && iterateNode.equals(head)){
                head = iterateNode.getNext();
                iterateNode.setNextNode(null);
                return true;
            }else if(iterateNode.getNext().getValue().equals(valueToRemove)){
                iterateNode.setNextNode(iterateNode.getNext().getNext());
                iterateNode.getNext().setNextNode(null);
                return true;
            }
            iterateNode = iterateNode.getNext();
        }
        return false;
    }

    public Boolean contains(Integer valueToCheck) {
        Node<K, V>  iterateNode = head;
        while (iterateNode.getNext() != null){
            if(iterateNode.getValue().equals(valueToCheck))
                return true;
        }
        return false;
    }

    public Boolean contains(String valueToCheck) {
        Node<K, V>  iterateNode = head;
        while (iterateNode.getNext() != null){
            if(iterateNode.getKey().equals(valueToCheck))
                return true;
        }
        return false;
    }

    public V find(V valueToFind) {
        Node<K, V>  iterateNode = head;
        while (iterateNode.getNext() != null){
            if(iterateNode.getValue().equals(valueToFind))
                break;
        }
        return iterateNode.getValue();
    }

    public Integer size() {
        return size;
    }

    public Node<K, V>  get(Integer index) {
        Node<K, V> iterateNode = head;
        if (index >= 0 && index <= size) {
            for (int i = 0; i < index; i++) {
                iterateNode = iterateNode.getNext();
            }
        }else {
            throw new IndexOutOfBoundsException();
        }
        return iterateNode;
    }

    public SinglyLinkedList copy() {
        SinglyLinkedList newCopy = new SinglyLinkedList();
        Node iterateNode = head;
        while (iterateNode.getNext() != null){
            newCopy.add(iterateNode);
            iterateNode = iterateNode.getNext();
        }
        return newCopy;
    }

    public SinglyLinkedList slice(Integer startIndex, Integer endIndex) {
        SinglyLinkedList retList = new SinglyLinkedList();
        Node startNode = head;
        if (startIndex >= 0 && endIndex < size && startIndex < endIndex) {
            for (int i = 0; i < size; i++, startNode = startNode.getNext()) {
                if (i >= startIndex)
                    retList.add(startNode);
            }
        } else
            throw new IndexOutOfBoundsException();
        return retList;
    }

    public SinglyLinkedList reverse() {
        SinglyLinkedList retList = new SinglyLinkedList();
        for (int i = size - 1; i >= 0; i--) {
            Node startNode = head;
            for (int j = 0; j <= i; j++) {
                if (j == i)
                    retList.add(startNode);
                startNode = startNode.getNext();
            }
        }
        return retList;
    }

    public static class Node<T,U> implements Comparable<Node<T,U> > {

        private Node<T, U> next;
        private T key;
        private U value;

        public Node() {
            next = null;
            key = null;
            value = null;
        }

        public void setNextNode(Node<T,U>  nextNode) {
            next = nextNode;
        }

        public Node<T,U>  getNext() {
            if (next != null)
                return next;
            else
                return null;
        }

        public void setValue(U newValue) {
            value = newValue;
        }

        public U getValue() {
            return value;
        }

        public int compareTo(Node<T,U> o) {
            return value.toString().compareTo(o.getValue().toString());
        }

        public T getKey() {
            return key;
        }

        public void setKey(T key) {
            this.key = key;
        }
    }
}
