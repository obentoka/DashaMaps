package com.zipcodewilmington.dashamap;

public interface HashMapX {
    // fundamentals
    public void set(String key, Integer value);
    public String delete(String key);
    public Integer get(String key);
    public boolean isEmpty();
    public long size();

    // testing access MADE IT TO NOT PROTECTED
    boolean bucketSize(String key); // used for tests
}
