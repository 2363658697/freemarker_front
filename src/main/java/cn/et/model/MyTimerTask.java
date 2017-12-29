package cn.et.model;

import java.util.Timer;

public class MyTimerTask {
        public static void main(String[] args) {
            Timer timer=new Timer();
            
            MyTask  task=new MyTask();
            
            timer.schedule(task, 1,5000);
            
        }
}
