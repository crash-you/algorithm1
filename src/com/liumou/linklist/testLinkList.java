package com.liumou.linklist;

import org.junit.jupiter.api.Test;

public class testLinkList {

    @Test
    public void test1(){
        SingleLinkList singleLinkList = new SingleLinkList();
        singleLinkList.addFirst(1);
        singleLinkList.addFirst(2);
        singleLinkList.addFirst(3);
        singleLinkList.addFirst(4);
        singleLinkList.addFirst(5);
        singleLinkList.addFirst(6);

        singleLinkList.loop1(value->{
            System.out.println(value);
        });
    }
}
