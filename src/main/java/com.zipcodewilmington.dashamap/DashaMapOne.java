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
            nodeArray[i] = new SinglyLinkedList();
            SinglyLinkedList.Node alpha = new SinglyLinkedList.Node();
            alpha.setKey(""+ (char)('a' + i));
            alpha.setValue(null);
            nodeArray[i].add(alpha);
        }
    }

    public void readFile() throws FileNotFoundException {
        Scanner fr = new Scanner(file);
        while (fr.hasNextLine()){
            String word = fr.next();
            Integer num = fr.nextInt();
            set(word, num);
            if(fr.hasNextLine())
                fr.nextLine();
        }
    }

    public void appendTo(Integer index, SinglyLinkedList.Node newNode){
        nodeArray[index].add(newNode);
    }

    @Override
    public void set(String key, Integer value) {
        Character firstChar = key.charAt(0);
        Integer letter = firstChar.charValue() % 97;
        SinglyLinkedList.Node newNode = new SinglyLinkedList.Node();
        newNode.setKey(key);
        newNode.setValue(value);
        appendTo(letter, newNode);
    }

    @Override
    public Boolean delete(String key) {
        return null;
    }

    @Override
    public Integer get(String key) {
        Character firstChar = key.charAt(0);
        Integer letter = firstChar.charValue() - 97;
        SinglyLinkedList.Node foundNode = findIn(nodeArray[letter], key);
        return foundNode.getValue();
    }

    public SinglyLinkedList.Node findIn(SinglyLinkedList list, String key){
        SinglyLinkedList.Node current = list.get(0);
        while (current != null){
            if(current.getKey().equals(key))
                break;
            if(current.getNext() != null)
                current = current.getNext();
        }
        return current;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public long size() {
        Integer sum = 0;
        for (int i = 0; i < nodeArray.length; i++) {
            sum += nodeArray[i].size();
        }
        return sum;
    }

    @Override
    public boolean bucketSize(String key) {
        return false;
    }
}
