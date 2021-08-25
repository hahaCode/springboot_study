## SpringBoot Web项目

### 用springboot搭建一个web项目

* 静态资源的存路径 (资源的优先级也是按照下面的排列顺序)
  1. classpath: /resources (也就是 src/main/resources/resources)
  2. classpath:/static (也就是 src/main/resources/static)
  3. classpath：/public (也就是 src/main/resources/public)
  4. 还有一种用webjars方式引入 (这个的映射路径是localhost:8080/webjars/   一般不用)
  
* 模板引擎
  1. 存放路径 `classpath:/templates/` 
   
  ```java
  public static final String DEFAULT_PREFIX = "classpath:/templates/";

  public static final String DEFAULT_SUFFIX = ".html";
  ```
  2. Thymeleaf基础语法
    
  