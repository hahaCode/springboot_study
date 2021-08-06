## SpringBoot

### SpringBoot概述

* SpringBoot概述
  1. Spring 的缺点
     + 配置繁琐: 虽然Spring组件代码是轻量级的, 但它的配置却是重量级的
     + 依赖繁琐: 项目的依赖管理也是一件耗时耗力的事情, 在搭建环境时, 需要分析要导入哪些库的坐标, 而且
                还需要分析导入与之有依赖关系的其他库的坐标, 一旦选错了版本, 随之而来的不兼容问题就会
                严重阻碍项目的开发进度。
       
  2. SpringBoot功能
     + 自动配置
     + 起步依赖
     + 辅助功能: 提供了一些大型项目中常见的非功能性特性, 如嵌入式服务器, 安全, 指标, 健康检测, 外部配置等
    
  3. 小结
     + SpringBoot并不是对Spring功能上的增强, 而是提供了一种快速使用Spring的方式
     + SpringBoot在创建项目时, 使用的是jar的打包方式
     + SpringBoot的引导类是项目的入口, 运行main方法就可以启动项目
     + 使用SpringBoot和Spring构建的项目, 业务代码编写的方式完全一样
     + 在spring-boot-starter-parent中定义了各种技术的版本信息, 组合了一套最优搭配的技术版本

### SpringBoot配置

* 配置文件分类
  1. SpringBoot是基于约定的, 所以很多配置都有默认值, 但如果想使用自己的配置替换默认配置的话, 就可以使用application.properties
     或者application.yml(application.yaml)进行配置 
     + 在同一级目录下优先级为 properties > yml > yaml
    
  2. YAML基本语法
     + 大小写敏感
     + 数据值前面必须有空格, 作为分隔符
     + 使用缩进表示层级关系
     + 缩进时不能用TAB, 只能用空格, 因为各个操作系统Tab对应的空格数目可能不相同, 导致层次混乱
     + 缩进的空格数目不重要, 只要相同层级的元素左侧对其即可
     + `#`表示注释, 会被解析器忽略
    
  3. YAML数据格式
     + 对象: 键值对的集合
     ```yaml
      person:
        name: zhangsan
      # 或者可以采用行内写法
      student: {name: lisi} 
     ```
     + 数组
     ```yaml
      address:
        - beijing
        - shanghai
      # 行内写法
      address1: [beijing,shanghai]
     ```
     + 纯量(单个的, 不可再分的值)
     ```yaml
        message1: 'hello \n world' # 单引号忽略转义字符
        message2: "hello \n world" # 双引号识别转义字符
     ```
     + 参数引用
     ```yaml
        name: haha
        person:
          name: ${name} 
     ```
     
* 读取配置内容
  1. @Value
  2. Environment
  3. @ConfigurationProperties(prefix = "person")
    
* 使用profile来进行不同环境配置的动态切换
  1. profile配置方式
     + 多profile文件方式: 提供多个配置文件, 每个代表一种环境
       - application-dev.properties/yml开发环境
       - application-test.properties/yml测试环境
       - application-pro.properties/yml生产环境
     + yml多文档方式
       - 在yml中使用 `---` 分隔不同配置
  2. profile激活方式
     + 配置文件: 在配置文件中配置spring.profiles.active=dev
     + 虚拟机参数: 在VM options指定: -Dspring.profiles.active=dev
     + 命令行参数: java -jar xxx.jar --spring.profiles.active=dev
    
* 内部配置的加载顺序(加载顺序就是下面的排列顺序, 高优先级配置的属性会生效)
  1. file:/config/: 当前项目下的/config目录下
  2. file:/       : 当前目录的根目录
  3. classpath:/config/: classpath的/config目录
  4. classpath:/       : classpath的根目录  
    
* 外部配置加载顺序(太多了 参考官网)(内部外部配置可以起到互补的作用)

### SpringBoot高级

* SpringBoot原理分析

* SpringBoot监控