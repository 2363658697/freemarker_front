package cn.et.model;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * ServletContext的生命周期：伴随着应用的发布（产生） 和关闭（销毁）
 * @author Administrator
 *
 */
public class SlContextListence implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("上下文对象销毁");

	} 

	
	/**
	 * 创建定时任务
	 */
	public void contextInitialized(ServletContextEvent arg0) {
	    Timer timer=new Timer();
        
        MyTask  task=new MyTask();
        
        timer.schedule(task, 1,5000);
        
	}
}
