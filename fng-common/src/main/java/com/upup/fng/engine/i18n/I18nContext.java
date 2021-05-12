package com.upup.fng.engine.i18n;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 国际化资源加载类
 *
 * @author wuou
 * @version 1.0.0
 * @date 2020/12/9 下午4:31
 */
@Component
public class I18nContext {

    /**
     * 配置文件中的国际化
     */
    private static Map<String, String> enMap = new HashMap<>();

    /**
     * 多个配置文件地址
     */
    private static Map<String, String> chMap = new HashMap<>();

    
    /**
     * 类加载加载配置文件
     */
    @PostConstruct
    public void init(){
        Properties properties = new Properties();
        InputStream resourceAsStream = I18nContext.class.getClassLoader()
                .getResourceAsStream("i18nPath.properties");
        try {
            properties.load(resourceAsStream);
            loadI18nKey(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                resourceAsStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 初始化map
     * @param properties 配置文件
     * @throws IOException io读取异常
     */
    private static void loadI18nKey(Properties properties) throws IOException {
        for(Map.Entry<Object, Object> e : properties.entrySet()){
            Properties pro = new Properties();
            InputStream resource = I18nContext.class.getClassLoader()
                    .getResourceAsStream(e.getValue().toString());
            pro.load(resource);
            if(e.getKey().toString().endsWith("_en.properties")){
                for (Map.Entry<Object,Object> e1 : pro.entrySet()) {
                    enMap.put(e1.getKey().toString(),e1.getValue().toString());
                }
            }
            if(e.getKey().toString().endsWith("_zh_CN.properties")){
                for (Map.Entry<Object,Object> e1 : pro.entrySet()) {
                    chMap.put(e1.getKey().toString(),e1.getValue().toString());
                }
            }
            resource.close();
        }
    }

    /**
     *  拿到国际化value
     * @param language 语言环境
     * @param key map-->key
     * @return value
     */
    public static String get(String language, String key){
        return language=="en"?enMap.get(key):chMap.get(key);
    }
}
