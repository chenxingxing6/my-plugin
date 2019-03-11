# my-plugin
手写maven插件

### 1POM.XML
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.demo</groupId>
    <artifactId>my-plugin</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>maven-plugin</packaging>

    <dependencies>
        <dependency>
            <groupId>org.apache.maven</groupId>
            <artifactId>maven-plugin-api</artifactId>
            <version>3.5.0</version>
        </dependency>
        <dependency>
            <groupId>org.apache.maven.plugin-tools</groupId>
            <artifactId>maven-plugin-annotations</artifactId>
            <version>3.5</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.6.1</version>
                <configuration>
                    <source>1.7</source>
                    <target>1.7</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

---

### 2编写插件
```java
package com.demo;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * User: lanxinghua
 * Date: 2019/3/11 10:17
 * Desc: maven插件
 */
//这里的cxx就为该插件的goal
@Mojo(name = "cxx", defaultPhase = LifecyclePhase.PACKAGE)
public class DemoMojo extends AbstractMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException{
        System.out.println("maven插件");
    }
}
```

然后打包

---


### 3项目中引用插件
```xml
<plugin>
    <groupId>com.demo</groupId>
    <artifactId>my-plugin</artifactId>
    <version>1.0-SNAPSHOT</version>
</plugin>
```

---

### 4配置在什么阶段运行
```xml
<plugin>
    <groupId>com.demo</groupId>
    <artifactId>my-plugin</artifactId>
    <version>1.0-SNAPSHOT</version>
    <executions>
        <execution>
            <id>my-plugin</id>
            <phase>pre-clean</phase>
            <goals>
                <goal>cxx</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

---
### 5.运行结果
```html
INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building mis-provider 1.0.0
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- my-plugin:1.0-SNAPSHOT:cxx (my-plugin) @ mis-provider ---
maven插件
[INFO] 
[INFO] --- maven-clean-plugin:3.0.0:clean (default-clean) @ mis-provider ---
[INFO] Deleting /Users/cxx/IdeaProjects/mis-center-soa/mis-provider/target
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 0.528 s
[INFO] Finished at: 2019-03-11T10:41:28+08:00
[INFO] Final Memory: 15M/309M
[INFO] ------------------------------------------------------------------------
[WARNING] The requested profile "thirdparty" could not be activated because it does not exist.
```






