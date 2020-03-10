package com.zipcodewilmington.dashamap;

public class DashaMapThree extends DashaMap{

    public DashaMapThree(){
        linkListArray = new SinglyLinkedList[52];
        initializeArrayOfLinkedList(linkListArray);
    }

    @Override
    public void initializeArrayOfLinkedList(SinglyLinkedList[] list){
        for (int i = 0; i < 52; i++) {
            list[i] = new SinglyLinkedList();
            SinglyLinkedList.Node alpha = new SinglyLinkedList.Node();
            alpha.setKey(""+ (char)('a' + i));
            alpha.setValue(null);
            list[i].add(alpha);
        }
    }

    @Override
    Integer hashFunctionOne(String input) {
        if(input.length() == 1){
            Character firstChar = input.toLowerCase().charAt(0);
            return firstChar % 97;
        }
        if (input.length() > 1) {
            Character firstChar = input.toLowerCase().charAt(0);
            Character secondChar = input.toLowerCase().charAt(1);
            return (firstChar % 97) + (secondChar % 97);
        }
        return null;
    }

    @Override
    public Integer get(String key) {
        Character firstChar = key.toLowerCase().charAt(0);
        Character secondChar = key.toLowerCase().charAt(1);
        Integer letter = (firstChar % 97) + (secondChar % 97);
        SinglyLinkedList.Node foundNode = findIn(letter, key);
        return (Integer) foundNode.getValue();
    }
}
