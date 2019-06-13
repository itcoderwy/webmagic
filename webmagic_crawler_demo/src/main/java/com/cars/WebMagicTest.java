package com.cars;

import us.codecraft.webmagic.Spider;

/**
 * @ClassName WebMagicTest
 * @Description TODO
 * @Author lenovo
 * @Date 2019/6/12 22:05
 * @Version 1.0
 **/
public class WebMagicTest {
    public static void main(String[] args) {
        //爬取某个网站整个页面的爬取
        //1,创建页面解析器
        //2,设置爬取的url
        Spider.create(new MyPageProcessor())
                    .addUrl("https://www.csdn.net/")   //通过下载器下载页面
                    .run()
                    ;
    }
}
