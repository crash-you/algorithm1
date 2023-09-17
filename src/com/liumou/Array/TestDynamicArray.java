package com.liumou.Array;

import org.junit.jupiter.api.Test;

public class TestDynamicArray {

    @Test
    public void test1(){
       DynamicArray dynamicArray = new DynamicArray();
       dynamicArray.addLest(1);
       dynamicArray.addLest(2);
       dynamicArray.addLest(3);
       dynamicArray.addLest(4);
       dynamicArray.addLest(5);

       dynamicArray.foreach(
               (element) -> {
                   System.out.println(element);
               }
       );
    }

    @Test
    public void test2(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLest(1);
        dynamicArray.addLest(2);
        dynamicArray.addLest(3);
        dynamicArray.addLest(4);
        dynamicArray.addLest(5);

        for (Integer element : dynamicArray) {
            System.out.println(element);
        }
    }

}
