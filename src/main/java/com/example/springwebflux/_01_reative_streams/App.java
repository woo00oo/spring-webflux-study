package com.example.springwebflux._01_reative_streams;

/*
    WebFlux = 단일 쓰레드, 비동기 + Stream을 통해 백프레셔가 적용된 데이터만큼 간헐적인 응답이 가능 + 데이터 소비가 끝나면 응답 종료
    SSE 적용(Servlet, WebFlux) = 데이터 소비가 끝나도 Stream 계속 유지
 */

public class App {

    public static void main(String[] args) {
        MyPub myPub = new MyPub(); //출판사 생성
        MySub mySub = new MySub(); //구독자 생성

        myPub.subscribe(mySub);
    }
}
