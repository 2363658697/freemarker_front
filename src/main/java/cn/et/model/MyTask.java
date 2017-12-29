package cn.et.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;


public class MyTask extends TimerTask{

    MyNews myNews = new MyNews();
    @Override
    public void run() {
        try {
            List<Map<String, String>> maps = myNews.queryNews();
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_0);
            //����ftl����Ŀ¼
            cfg.setDirectoryForTemplateLoading(new File("src/main/resources"));
            //�������ݵ�ץȡģʽ
            cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_0));

            //��������     
            Map root = new HashMap();
            root.put("maps", maps);
            
            String savePath = "src/main/webapp/index.html";
            
            // ʵ����ģ�����
            Template temp = cfg.getTemplate("index.ftl");

            //�����ļ����������ģ�����������html�ļ���
            FileOutputStream fileOutputStream = new FileOutputStream(savePath);
            Writer out = new OutputStreamWriter(fileOutputStream);

            temp.process(root, out);
            out.flush();
        } catch (Exception e) {
            
        }

        
    }

}
