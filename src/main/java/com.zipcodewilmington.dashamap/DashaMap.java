package com.zipcodewilmington.dashamap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class DashaMap implements HashMapX{

    public SinglyLinkedList[] linkListArray;

    public void initializeArrayOfLinkedList(SinglyLinkedList[] list){
        for (int i = 0; i < 26; i++) {
            list[i] = new SinglyLinkedList();
            SinglyLinkedList.Node alpha = new SinglyLinkedList.Node();
            alpha.setKey(""+ (char)('a' + i));
            alpha.setValue(null);
            list[i].add(alpha);
        }
    }

    public void readFile(File fileToRead) throws FileNotFoundException {
        Scanner fr = new Scanner(fileToRead);
        while (fr.hasNextLine()){
            String word = fr.next();
            Integer num = fr.nextInt();
            set(word, num);
            if(fr.hasNextLine())
                fr.nextLine();
        }
    }

    abstract Integer hashFunctionOne(String input);

    public void appendTo(Integer index, SinglyLinkedList.Node newNode){
        linkListArray[index].add(newNode);
    }

    public void set(String key, Integer value) {
        SinglyLinkedList.Node newNode = new SinglyLinkedList.Node();
        newNode.setKey(key);
        newNode.setValue(value);
        appendTo(hashFunctionOne(key), newNode);
    }

    public Boolean delete(String key) {
        SinglyLinkedList.Node prev = linkListArray[hashFunctionOne(key)].get(0);
        SinglyLinkedList.Node current = prev.getNext();
        while (current != null){
            if(current.getKey().equals(key) && current.getNext() != null){
                prev.setNextNode(current.getNext());
                current.setNextNode(null);
                return true;
            }else if(current.getKey().equals(key)) {
                prev.setNextNode(null);
                return true;
            }
            if(current.getNext() != null) {
                prev = current;
                current = current.getNext();
            }else
                break;
        }
        return false;
    }

    abstract public Integer get(String key);

    public SinglyLinkedList.Node findIn(Integer index, String key){
        SinglyLinkedList.Node current = linkListArray[index].get(0);
        while (current != null){
            if(current.getKey().equals(key))
                break;
            if(current.getNext() != null)
                current = current.getNext();
            else
                break;
        }
        return current;
    }

    public boolean isEmpty() {
        return size() == 26;
    }

    public long size() {
        Integer sum = 0;
        for (int i = 0; i < linkListArray.length; i++) {
            sum += linkListArray[i].size();
        }
        return sum;
    }

    public boolean bucketSize(String key) {
        return false;
    }
}
