package com.zipcodewilmington.dashamap;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

public class DashaMapThreeTest {

    DashaMapThree test;
    File file;

    @Before
    public void init() throws FileNotFoundException {
        test = new DashaMapThree();
        file = new File("/Users/vle/Documents/Projects/Week5/DashaMaps 3.4/DashaMaps/word-list.txt");
        test.readFile(file);
    }

    @Test
    public void constructorAndInializeTest(){
        for (int i = 0; i < 52; i++) {
            String expected = "" + (char)('a' + i);
            String actual = (String) test.linkListArray[i].get(0).getKey();
            assertEquals(expected, actual);
        }
    }

    @Test
    public void fileReaderTest() throws IOException {
        FileWriter fw = new FileWriter("/Users/vle/Documents/Projects/Week5/DashaMaps 3.4/DashaMaps/hash-list-3.txt");
        for (int i = 0; i < 26; i++) {
            SinglyLinkedList.Node current = test.linkListArray[i].get(0);
            fw.write(current.getKey() + " " + current.getValue() + "\n");
            while (current.getNext() != null){
                if(current.getValue() != null) {
                    fw.write(current.getKey() + " " + current.getValue() + "\n");
                }
                current = current.getNext();
            }
            if(current.getValue() != null) {
                fw.write(current.getKey() + " " + current.getValue() + "\n");
            }
        }
        fw.close();
    }

    @Test
    public void findInTest(){
        String key  = "being";
        Integer expected = 13;

        Integer actual = (Integer) test.findIn(5, key).getValue();
        assertEquals(expected, actual);
    }

    @Test
    public void findInTest2(){
        String key  = "being";

        Integer actual = (Integer) test.findIn(42, key).getValue();
        assertNull(actual);
    }

    @Test
    public void getTest(){
        String key = "being";
        Integer expected = 13;

        Integer actual = test.get(key);

        assertEquals(expected, actual);
    }
}