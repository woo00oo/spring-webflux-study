package com.example.springwebflux._1_reative_streams;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MySub implements Subscriber<Integer> {

    private Subscription s;
    private static Integer BUFFER_SIZE = 3;

    // 데이터를 최초 통지할때 호출되는 함수 (Subscription 객체로 데이터 구독 요청 및 해지 요청)
    @Override
    public void onSubscribe(Subscription s) {
        System.out.println("구독자 : 구독 정보 잘 받았어");
        this.s = s;
        System.out.println("구독자 : 나 이제 신문 " + BUFFER_SIZE + "개씩 줘");
        s.request(BUFFER_SIZE); //신문 버퍼 사이즈 만큼 매일매일 줘 ! (백프레셔) 소비자가 한번에 처리할 수 있는 개수를 요청
    }

    // 데이터를 통지할때마다 호출되는 함수
    @Override
    public void onNext(Integer integer) {
        System.out.println("onNext() : " + integer);

        BUFFER_SIZE--;

        if (BUFFER_SIZE == 0) {
            System.out.println("하루 지남");
            BUFFER_SIZE = 3;
            s.request(BUFFER_SIZE);
        }
    }

    // 데이터를 통지할 때 에러가 발생할 때 호출되는 함수
    @Override
    public void onError(Throwable t) {
        System.out.println("구독중 에러");
    }

    // 데이터 통지가 끝났음을 알리는 함수
    @Override
    public void onComplete() {
        System.out.println("구독 완료");
    }

}
