package com.zipcodewilmington.dashamap;

public class DashaMapTwo extends DashaMap{

    public DashaMapTwo(){
        linkListArray = new SinglyLinkedList[26];
        initializeArrayOfLinkedList(linkListArray);
    }

    public Integer get(String key) {
        Character secondChar = key.charAt(1);
        Integer letter = secondChar.charValue() % 97;
        SinglyLinkedList.Node foundNode = findIn(letter, key);
        return (Integer) foundNode.getValue();
    }

    @Override
    Integer hashFunctionOne(String input) {
        if(input.length() == 1){
            Character firstChar = input.toLowerCase().charAt(0);
            return firstChar % 97;
        }
        if(input.length() > 1){
            Character firstChar = input.toLowerCase().charAt(1);
            return firstChar % 97;
        }
        return null;
    }
}
