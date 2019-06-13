package com.cars;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @ClassName MyPageProcessor
 * @Description 1,负责解析页面   2,发现新的链接
 * @Author lenovo
 * @Date 2019/6/12 21:59
 * @Version 1.0
 **/
public class MyPageProcessor implements PageProcessor{
    //处理解析页面的方法   参数page对象  dowderloader下载组件下载页面返回页面封装到page对象中
    public void process(Page page) {
         //1,输出所有页面
        //System.out.println(page.getHtml().toString());
        //2,通过xpath表达式获取指定内容
        /*String xpathString = page.getHtml().xpath("//*[@id=\"nav\"]/div/div/ul/li[8]/a/text()").toString();
        System.out.println(xpathString);
        //3,通过种子页面 爬取其他的url
        page.addTargetRequests(page.getHtml().links().all());
        System.out.println("//*[@id=\"nav\"]/div/div/ul/li[8]/a/text()");*/
        //4,通过正则表达式 指定爬取页面  只需博客中文章的数据
        //https://blog.csdn.net/kexuanxiu1163/article/details/91461215
        page.addTargetRequests(page.getHtml().links().regex("https://blog.csdn.net/[0-9 a-z - _]+/article/details/[0-9]{8}").all());
        String title = page.getHtml().xpath("//*[@id=\"mainBox\"]/main/div[1]/div/div/div[1]/h1/text()").toString();
        System.out.println(title);

    }

    //设置爬取相关规则
    public Site getSite() {
        return Site.me()
                .setSleepTime(300)//爬取数据周期
                .setRetryTimes(3)//爬取失败后重试的次数   超过失败次数  放弃
                ;
    }
}
