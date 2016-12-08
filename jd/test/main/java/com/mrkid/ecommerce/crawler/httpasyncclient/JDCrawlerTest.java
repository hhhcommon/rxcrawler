package com.mrkid.ecommerce.crawler.httpasyncclient;

import com.mrkid.ecommerce.crawler.dto.JDCategoryDTO;
import com.mrkid.ecommerce.crawler.dto.JDSkuDTO;
import io.reactivex.Flowable;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * User: xudong
 * Date: 08/11/2016
 * Time: 4:45 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JDCrawlerTest {
    @Autowired
    JDCrawler jdCrawler;

    @org.junit.Test
    public void getAllCategories() throws Exception {
        jdCrawler.getAllCategories().blockingSubscribe(System.out::println);
    }

    @org.junit.Test
    public void getSku() throws Exception {
        final JDCategoryDTO category = new JDCategoryDTO();
        category.setLevel(3);
        category.setPath("670_699_700");
        category.setCid(700);

        category.setName("路由器");
        final Flowable<JDSkuDTO> sku = jdCrawler.getSku(category);

        sku.blockingSubscribe(l -> System.out.println(l));

    }

}