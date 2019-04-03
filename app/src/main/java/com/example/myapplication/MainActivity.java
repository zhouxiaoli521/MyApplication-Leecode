package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static {
        System.loadLibrary("native-lib");
    }
    HandlerThread mHT;
    Handler mainHander,workHander;
    TextView tv;
    Button bt1,bt2,bt3;
    public static native String stringFromJNI();
    //添加的一个带参有返回值的native函数
    public native String setString(String str);
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        bt1 = findViewById(R.id.button);
        bt2 = findViewById(R.id.button2);
        bt3 = findViewById(R.id.button3);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);

        //和主线程关联的handler
        mainHander=new Handler( );

        mHT=new HandlerThread("handlerThread");
        mHT.start();

        /*
         * 步骤3：创建工作线程Handler & 复写handleMessage（）
         * 作用：关联HandlerThread的Looper对象、实现消息处理操作 & 与其他线程进行通信
         * 注：消息处理操作（HandlerMessage（））的执行线程 = mHandlerThread所创建的工作线程中执行
         */
        workHander=new Handler(mHT.getLooper()){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case 1:
                        try {
                            for(int i=0;i<10;i++){
                                Thread.sleep(100);
                                updateUI("0."+i);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        updateUI("我爱学习");
                        break;
                    case 2:
                        try {
                            for(int i=0;i<30;i++){
                                Thread.sleep(100);
                                updateUI(""+(i/10.0));
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        updateUI("我不爱学习");
                        break;
                }
            }
        };

        //调用MainActivity中的方法(stringFromJNI()方法)...
        tv.setText(stringFromJNI());

        //调用MainActivity中的方法(setString()方法)...
        bt1.setText(setString("Hello,欢迎来到JNI的世界..."));

        //调用HongBao类中的java方法<sub()方法>
        bt2.setText("测试HongBao类java中sub(5,3)方法相减的结果："+HongBao.sub(5,3));

        //调用HongBao类中的java native方法<add()方法>
        bt3.setText("测试HongBao类native的add(5,3)方法相加的结果："+HongBao.add(3,5));

//        Log.e("Message",JNITest.get());
    }

    private void updateUI(final String msg){
        mainHander.post(new Runnable() {
            @Override
            public void run() {
                tv.setText(msg);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    public void onClick(final View view) {
        Message msg=Message.obtain();
        switch (view.getId()){
            case R.id.button:
                msg.what=1;
                msg.obj="A";
                workHander.sendMessage(msg);
                break;
            case R.id.button2:
                msg.what=2;
                msg.obj="B";
                workHander.sendMessage(msg);
                break;
            case R.id.button3:
//                mHT.quit();
                startActivity(new Intent(MainActivity.this,RecyclerViewTestActivity.class));
                break;
        }
    }
}
