package cn.et.model;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * ServletContext���������ڣ�������Ӧ�õķ����������� �͹رգ����٣�
 * @author Administrator
 *
 */
public class SlContextListence implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("�����Ķ�������");

	} 

	
	/**
	 * ������ʱ����
	 */
	public void contextInitialized(ServletContextEvent arg0) {
	    Timer timer=new Timer();
        
        MyTask  task=new MyTask();
        
        timer.schedule(task, 1,5000);
        
	}
}
