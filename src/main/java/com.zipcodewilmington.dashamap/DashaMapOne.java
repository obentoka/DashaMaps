package com.zipcodewilmington.dashamap;

public class DashaMapOne extends DashaMap {

    public DashaMapOne(){
        linkListArray = new SinglyLinkedList[26];
        initializeArrayOfLinkedList(linkListArray);
    }

    public Integer get(String key) {
        Character firstChar = key.charAt(0);
        Integer letter = firstChar.charValue() % 97;
        SinglyLinkedList.Node foundNode = findIn(letter, key);
        return (Integer) foundNode.getValue();
    }

    @Override
    Integer hashFunctionOne(String input) {
        if(input.length() > 0){
            Character firstChar = input.toLowerCase().charAt(0);
            return firstChar % 97;
        }
        return null;
    }
}
