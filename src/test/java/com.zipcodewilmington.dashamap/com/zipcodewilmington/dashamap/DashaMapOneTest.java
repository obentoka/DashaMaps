package com.zipcodewilmington.dashamap.com.zipcodewilmington.dashamap;

import com.zipcodewilmington.dashamap.DashaMapOne;
import com.zipcodewilmington.dashamap.SinglyLinkedList;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class DashaMapOneTest {

    private static final Logger LOGGER =
            Logger.getLogger((DashaMapOneTest.class.getName()));
    DashaMapOne test;

    @Before
    public void init(){
        test = new DashaMapOne();
    }

    @Test
    public void constructorTest(){
        for (int i = 0; i < 26; i++) {
            char alpha = (char)('a' + i);
            LOGGER.info("" + test.get("" + alpha));
        }
    }

    @Test
    public void fileReaderTest() throws IOException {
        test.readFile();
        FileWriter fw = new FileWriter("/Users/vle/Documents/Projects/Week5/DashaMaps 3.4/DashaMaps/hash-list.txt");
        for (int i = 0; i < 26; i++) {
            SinglyLinkedList.Node current = test.nodeArray[i].get(0);
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
}