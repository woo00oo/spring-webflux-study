package com.example.springwebflux._1_reative_streams;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.Arrays;

public class MyPub implements Publisher<Integer> {

    Iterable<Integer> iterable = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

    //데이터를 생성하고 발행하는 역할
    @Override
    public void subscribe(Subscriber<? super Integer> s) {
        System.out.println("구독자 : 출판사야 나 너희 신문 볼게");
        System.out.println("신문사 : 구독 정보를 만들어서 줄테니 기다려!");
        MySubscription mySubscription = new MySubscription(s, iterable);
        System.out.println("신문사 : 구독 정보 생성 완료 했어 잘받아!");
        s.onSubscribe(mySubscription);

    }

}
