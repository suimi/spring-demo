
spring bean 初始化过程

```
AbstractAutowireCapableBeanFactory.initializeBean(String, Object, RootBeanDefinition)  (org.springframework.beans.factory.support)
    AbstractAutowireCapableBeanFactory.doCreateBean(String, RootBeanDefinition, Object[])  (org.springframework.beans.factory.support)
        AbstractAutowireCapableBeanFactory.createBean(String, RootBeanDefinition, Object[])(2 usages)  (org.springframework.beans.factory.support)
            AbstractBeanFactory.doGetBean(String, Class<T>, Object[], boolean)  (org.springframework.beans.factory.support)
                AbstractBeanFactory.getBean(String)  (org.springframework.beans.factory.support)                
                    DefaultListableBeanFactory.preInstantiateSingletons()(3 usages)  (org.springframework.beans.factory.support)
                        AbstractApplicationContext.finishBeanFactoryInitialization(ConfigurableListableBeanFactory)  (org.springframework.context.support)
                            AbstractApplicationContext.refresh()  (org.springframework.context.support)                           
                                SpringApplication.refresh(ApplicationContext)  (org.springframework.boot)
                                    SpringApplication.refreshContext(ConfigurableApplicationContext)  (org.springframework.boot)
                                        SpringApplication.run(String...)  (org.springframework.boot)
```