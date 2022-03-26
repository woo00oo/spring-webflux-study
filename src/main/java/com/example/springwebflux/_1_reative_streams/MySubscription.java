package com.example.springwebflux._1_reative_streams;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Iterator;

public class MySubscription implements Subscription {

    private Subscriber subscriber;
    private Iterator<Integer> iterator;

    // 어떤 구독자가 어떤 데이터를 구독하는 지에 대한 정보를 생성
    public MySubscription(Subscriber subscriber, Iterable<Integer> iterable) {
        this.subscriber = subscriber;
        this.iterator = iterable.iterator();
    }

    @Override
    public void request(long n) {
        while (n > 0) {
            if(iterator.hasNext()) {
                subscriber.onNext(iterator.next());
            } else {
                subscriber.onComplete();
                break;
            }
        }
    }

    @Override
    public void cancel() {

    }
}
