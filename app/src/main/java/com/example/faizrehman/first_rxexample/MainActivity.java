package com.example.faizrehman.first_rxexample;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;


public class MainActivity extends AppCompatActivity {

    TextView textView,textView1;
    String normalText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.even);

       Observable<Integer> observable = Observable.just(1,2,3,4,5);





       // Func1<receivingtype,returntype>

        Observable<Integer> evenNum = observable.filter(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer % 2 == 0;
            }
        });

        Observable<String> printString = evenNum.map(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {

                return "Even Number is :"+integer;
            }
        });


       printString.subscribe(new Observer<String>() {
           @Override
           public void onCompleted() {
               textView.setText(normalText);
           }

           @Override
           public void onError(Throwable e) {

           }

           @Override
           public void onNext(String s) {
                normalText += "\n"+s;
           }
       });

       ;
        //if you working stop then unsubsribe
      //  subscription.unsubscribe();

    }
}
