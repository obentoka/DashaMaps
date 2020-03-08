package com.zipcodewilmington.dashamap.com.zipcodewilmington.dashamap;

import com.zipcodewilmington.dashamap.DashaMapOne;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
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
    public void fileReaderTest() throws FileNotFoundException {
        test.readFile();
        for (int i = 0; i < 26; i++) {
            Node current = test.nodeArray[i];
            while (current.getNext() != null){
                LOGGER.info(""+test.nodeArray[i].getValue());
                current = current.getNext();
            }
        }
    }
}