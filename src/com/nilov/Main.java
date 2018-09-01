package com.nilov;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;

public class Main {
    public static void main(String[] args){
        new Main();
    }

    private Main() {
        try {
            testBeanFactory();
            testContext();
        }catch (ReflectiveOperationException e){
            e.printStackTrace();
        }
    }

    private void testBeanFactory() throws ReflectiveOperationException{
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.addPostProcessor(new CustomPostProcessor());
        beanFactory.instantiate("com.nilov");
        beanFactory.populateProperties();
        beanFactory.injectBeanNames();
        beanFactory.injectBeanFactory();
        beanFactory.initializeBeans();
        ProductService productService = (ProductService) beanFactory.getBean("productService");
        System.out.println(productService);

        PromotionsService promotionsService = productService.getPromotionsService();
        System.out.println("Bean name = " + promotionsService.getBeanName());
        System.out.println("BeanFactory = " + promotionsService.getBeanFactory());

        beanFactory.close();
    }

    private void testContext() throws ReflectiveOperationException{
        ApplicationContext applicationContext = new ApplicationContext("com.nilov");
        applicationContext.close();
    }
}
