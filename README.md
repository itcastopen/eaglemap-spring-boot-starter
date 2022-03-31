 <img src="docs/images/itcast.png" style="zoom: 80%;" />  <img src="docs/images/logo.png" style="zoom: 80%;" />

# 关于eaglemap-spring-boot-starter

eaglemap-spring-boot-starter是基于EagleMap-sdk完成与SpringBoot的整合。

EagleMap-sdk源码地址：

https://gitee.com/itcastopen/EagleMap-sdk.git

https://github.com/itcastopen/EagleMap-sdk.git

# 快速使用

> **第一步，导入maven依赖**

~~~xml
<dependency>
    <groupId>com.itheima.em</groupId>
    <artifactId>eaglemap-spring-boot-starter</artifactId>
    <version>{version}</version>
</dependency>

<!-- 如果是SNAPSHOT版本，如要在项目的pom.xml文件中引入快照版源 -->
<repositories>
    <repository>
        <id>sonatypeSnapshots</id>
        <name>Sonatype Snapshots</name>
        <releases>
            <enabled>false</enabled>
        </releases>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
        <url>https://s01.oss.sonatype.org/content/repositories/snapshots/</url>
    </repository>
</repositories>
~~~

> **第二步，配置application.yml文件**

~~~yml
eagle:
  host: 127.0.0.1 #EagleMap服务地址
  port: 8484 #EagleMap服务端口
  timeout: 10000 #http请求的超时时间
~~~

**第三步，测试用例**

~~~java
package cn.itcast.em.boot;

import EagleMapTemplate;
import IpResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EagleMapTest {

    @Autowired //自动注入
    private EagleMapTemplate eagleMapTemplate;

    @Test
    public void queryIp() {
        String ip = "114.242.26.45";
        //根据ip地址查询对应的地区、经纬度坐标等信息
        IpResult ipResult = this.eagleMapTemplate.opsForBase().queryIp(ip);
        System.out.println(ipResult);
    }

}
~~~
