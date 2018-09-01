package com.nilov;

import org.springframework.beans.factory.DisponsableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.stereotype.Component;

@Component
public class ProductService implements InitializingBean, DisponsableBean {
    @Autowired
    private PromotionsService promotionsService;

    public PromotionsService getPromotionsService() {
        return promotionsService;
    }

    public void setPromotionsService(PromotionsService promotionsService) {
        this.promotionsService = promotionsService;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("ProductService init...");
    }

    @Override
    public void destroy() {
        System.out.println("ProductService destroy...");
    }
}
