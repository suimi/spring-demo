
### spring bean 初始化过程

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

### DeferredResult 异步处理过程
```
WebAsyncManager.startAsyncProcessing(Object[])  (org.springframework.web.context.request.async)
    WebAsyncManager.startCallableProcessing(WebAsyncTask<?>, Object...)  (org.springframework.web.context.request.async)
    WebAsyncManager.startDeferredResultProcessing(DeferredResult<?>, Object...)  (org.springframework.web.context.request.async)
        DeferredResultMethodReturnValueHandler.handleReturnValue(Object, MethodParameter, ModelAndViewContainer, NativeWebRequest)  (org.springframework.web.servlet.mvc.method.annotation)
            HandlerMethodReturnValueHandlerComposite.handleReturnValue(Object, MethodParameter, ModelAndViewContainer, NativeWebRequest)  (org.springframework.web.method.support)
                HandlerMethodReturnValueHandlerComposite.handleReturnValue(Object, MethodParameter, ModelAndViewContainer, NativeWebRequest)  (org.springframework.web.method.support)
                ServletInvocableHandlerMethod.invokeAndHandle(ServletWebRequest, ModelAndViewContainer, Object...)  (org.springframework.web.servlet.mvc.method.annotation)
                    RequestMappingHandlerAdapter.invokeHandlerMethod(HttpServletRequest, HttpServletResponse, HandlerMethod)  (org.springframework.web.servlet.mvc.method.annotation)
                        RequestMappingHandlerAdapter.handleInternal(HttpServletRequest, HttpServletResponse, HandlerMethod)(3 usages)  (org.springframework.web.servlet.mvc.method.annotation)
```
#### ReturnValueHandler初始化位置及handler顺序

`org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.afterPropertiesSet`
```java
private List<HandlerMethodReturnValueHandler> getDefaultReturnValueHandlers() {
		List<HandlerMethodReturnValueHandler> handlers = new ArrayList<HandlerMethodReturnValueHandler>();

		// Single-purpose return value types
		handlers.add(new ModelAndViewMethodReturnValueHandler());
		handlers.add(new ModelMethodProcessor());
		handlers.add(new ViewMethodReturnValueHandler());
		handlers.add(new ResponseBodyEmitterReturnValueHandler(getMessageConverters()));
		handlers.add(new StreamingResponseBodyReturnValueHandler());
		handlers.add(new HttpEntityMethodProcessor(getMessageConverters(),
				this.contentNegotiationManager, this.requestResponseBodyAdvice));
		handlers.add(new HttpHeadersReturnValueHandler());
		handlers.add(new CallableMethodReturnValueHandler());
		handlers.add(new DeferredResultMethodReturnValueHandler());
		handlers.add(new AsyncTaskMethodReturnValueHandler(this.beanFactory));

		// Annotation-based return value types
		handlers.add(new ModelAttributeMethodProcessor(false));
		handlers.add(new RequestResponseBodyMethodProcessor(getMessageConverters(),
				this.contentNegotiationManager, this.requestResponseBodyAdvice));

		// Multi-purpose return value types
		handlers.add(new ViewNameMethodReturnValueHandler());
		handlers.add(new MapMethodProcessor());

		// Custom return value types
		if (getCustomReturnValueHandlers() != null) {
			handlers.addAll(getCustomReturnValueHandlers());
		}

		// Catch-all
		if (!CollectionUtils.isEmpty(getModelAndViewResolvers())) {
			handlers.add(new ModelAndViewResolverMethodReturnValueHandler(getModelAndViewResolvers()));
		}
		else {
			handlers.add(new ModelAttributeMethodProcessor(true));
		}

		return handlers;
	}
```