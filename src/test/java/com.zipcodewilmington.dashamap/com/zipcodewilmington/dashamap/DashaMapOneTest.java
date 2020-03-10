package com.zipcodewilmington.dashamap.com.zipcodewilmington.dashamap;

import com.zipcodewilmington.dashamap.DashaMapOne;
import com.zipcodewilmington.dashamap.SinglyLinkedList;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class DashaMapOneTest {

    private static final Logger LOGGER =
            Logger.getLogger((DashaMapOneTest.class.getName()));
    DashaMapOne test;
    File file;

    @Before
    public void init() throws FileNotFoundException {
        test = new DashaMapOne();
        file = new File("/Users/vle/Documents/Projects/Week5/DashaMaps 3.4/DashaMaps/word-list.txt");
        test.readFile(file);
    }

    @Test
    public void constructorAndInializeTest(){
        for (int i = 0; i < 26; i++) {
            String expected = "" + (char)('a' + i);
            String actual = (String) test.linkListArray[i].get(0).getKey();
            assertEquals(expected, actual);
        }
    }

    @Test
    public void fileReaderTest() throws IOException {
        FileWriter fw = new FileWriter("/Users/vle/Documents/Projects/Week5/DashaMaps 3.4/DashaMaps/hash-list.txt");
        for (int i = 0; i < 26; i++) {
            SinglyLinkedList.Node current = test.linkListArray[i].get(0);
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

        Integer actual = (Integer) test.findIn(1, key).getValue();
        assertEquals(expected, actual);
    }

    @Test
    public void findInTest2(){
        String key  = "being";

        Integer actual = (Integer) test.findIn(25, key).getValue();
        assertNull(actual);
    }

    @Test
    public void getTest(){
        String key = "being";
        Integer expected = 13;

        Integer actual = test.get(key);

        assertEquals(expected, actual);
    }

    @Test
    public void getTest2(){
        String key = "zoo";

        Integer actual = test.get(key);

        assertNull(actual);
    }

    @Test
    public void deleteTest() throws IOException {
        Boolean actual = test.delete("being");

        assertTrue(actual);

        Boolean actual2 = test.delete("being");

        assertFalse(actual2);

        FileWriter fw = new FileWriter("/Users/vle/Documents/Projects/Week5/DashaMaps 3.4/DashaMaps/hash-list-deleted.txt");
        for (int i = 0; i < 26; i++) {
            SinglyLinkedList.Node current = test.linkListArray[i].get(0);
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
    public void isEmptyAndSizeTest(){
        DashaMapOne newTest = new DashaMapOne();

        assertTrue(newTest.isEmpty());
    }

    @Test
    public void isEmptyAndSizeTest2(){
        assertFalse(test.isEmpty());

        long expected = 150l;

        long actual = test.size();

        assertEquals(expected, actual);
    }
}