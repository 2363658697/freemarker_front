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
            //配置ftl查找目录
            cfg.setDirectoryForTemplateLoading(new File("src/main/resources"));
            //设置数据的抓取模式
            cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_0));

            //构建数据     
            Map root = new HashMap();
            root.put("maps", maps);
            
            String savePath = "src/main/webapp/index.html";
            
            // 实例化模版对象
            Template temp = cfg.getTemplate("index.ftl");

            //定义文件输出流，把模版内容输出到html文件中
            FileOutputStream fileOutputStream = new FileOutputStream(savePath);
            Writer out = new OutputStreamWriter(fileOutputStream);

            temp.process(root, out);
            out.flush();
        } catch (Exception e) {
            
        }

        
    }

}
