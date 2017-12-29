package cn.et.model;

import java.util.List;
import java.util.Map;

public class MyNews {
    
        public List<Map<String, String>> queryNews(){
            String sql="select * from news";
            List<Map<String, String>> list = null;
            try {
                list = DbUtils.query(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        }
        
}
