package com.zipcodewilmington.dashamap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DashaMapOne implements HashMapX {

    public SinglyLinkedList[] nodeArray;
    File file;

    public DashaMapOne(){
        file = new File("/Users/vle/Documents/Projects/Week5/DashaMaps 3.4/DashaMaps/word-list.txt");
        nodeArray = new SinglyLinkedList[26];
        for (int i = 0; i < 26; i++) {
            Node alpha = new Node();
            alpha.setKey(""+ (char)('a' + i));
            alpha.setValue(null);
            nodeArray[i] = alpha;
        }
    }

    public void readFile() throws FileNotFoundException {
        Scanner fr = new Scanner(file);
        while (fr.hasNext()){
            String word = fr.next();
            Integer num = fr.nextInt();
            set(word, num);
            if(fr.hasNextLine())
                fr.nextLine();
        }
    }

    public void appendTo(Integer index, Node newNode){
        nodeArray[index].setNext(newNode);
    }

    @Override
    public void set(String key, Integer value) {
        Character firstChar = key.charAt(0);
        Integer letter = firstChar.charValue() - 97;
        Node newNode = new Node(key, value);
        appendTo(letter, newNode);
    }

    @Override
    public String delete(String key) {
        return null;
    }

    @Override
    public Integer get(String key) {
        Character firstChar = key.charAt(0);
        Integer letter = firstChar.charValue() - 97;
        while (nodeArray[letter].getNext() != null){
            if(nodeArray[letter].getKey().equals(key))
                return nodeArray[letter].getValue();
            nodeArray[letter] = nodeArray[letter].getNext();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public long size() {
        return 0;
    }

    @Override
    public boolean bucketSize(String key) {
        return false;
    }
}
