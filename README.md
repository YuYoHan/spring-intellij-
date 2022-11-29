# spring-intellij-
여기서는 인텔리제이로 스프링을 공부하는 것을 연습할 것이다.

Maven + Spring MVC를 이용하여 메이븐과 스프링으로 설정된 프로젝트 생성

![](https://velog.velcdn.com/images/dbekdms17/post/05afd3cf-bc14-4284-abb0-1fb15c97872c/image.png)

인텔리제이를 실행하고 Create New Project를 클릭해서 새 프로젝트를 생성하도록 하겠습니다.

![](https://velog.velcdn.com/images/dbekdms17/post/fb688e88-8323-46b3-bb7b-f7ac57335b9f/image.png)

프로젝트 템플릿 목록에서 메이븐(Maven)을 선택하고 프로젝트에서 사용할 Project SDK(JDK)를 선택해주세요.

![](https://velog.velcdn.com/images/dbekdms17/post/97eda343-688f-4147-9ded-1307daa924be/image.png)

GroupId는 프로젝트의 가장 최상위 패키지(Top level package) 명으로 사용되고, ArtifactId는 프로젝트 명으로 사용됩니다.

(GroupId는 대표적으로 프로젝트가 진행되는 회사 도메인을 역순으로 작성합니다. 속한 회사가 없거나 단독으로 진행하는 사이드 프로젝트인 경우에는 자신이 사용할 도메인을 하나 정한 후 역순으로 작성해주세요.)

 

Version은 기본으로 "1.0-SNAPSHOT"으로 설정되어 있는데 "SNAPSHOT"은 해당 버전이 개발 버전이라는 걸 의미합니다.

(추가로 배포 버전은 "RELEASE"를 붙여서 사용합니다. 이해가 안 돼도 괜찮습니다. 경험이 쌓이면 자연스레 알게 되는 부분이므로 읽어보고 넘어가도록 합니다.)

![](https://velog.velcdn.com/images/dbekdms17/post/d9aff24b-2b0f-4744-85d0-c35d57811a94/image.png)

메이븐 프로젝트가 생성되었습니다.

좌측에 프로젝트 툴 윈도우(Project tool window)를 보면 src 디렉토리와 pom.xml 파일로 구성되어 있습니다.

![](https://velog.velcdn.com/images/dbekdms17/post/5e20d059-c15d-4d5f-b46f-d2fec3f47dec/image.png)

앞서, 메이븐(Maven) 프로젝트를 생성했기 때문에 이제부터는 Spring MVC를 설정할 순서입니다.

spring-project-initialize 모듈(Module)을 우클릭하여 Add Framework Support... 를 클릭해주세요.

![](https://velog.velcdn.com/images/dbekdms17/post/c936a2e3-1782-461f-8dba-33a66e535523/image.png)

팝업 창이 나타나면 좌측 프레임워크 목록에서 Spring MVC를 선택해주세요.

(현재 인텔리제이에서는 5.2.3 버전의 스프링 프레임워크를 제공하고 있습니다.)

![](https://velog.velcdn.com/images/dbekdms17/post/0dad8674-60a8-4b2e-8619-1f7ef3a50e84/image.png)

Spring MVC 설정이 완료되었습니다.

프로젝트 툴 윈도우를 확인해보면 lib와 web 디렉토리가 추가되었습니다.

![](https://velog.velcdn.com/images/dbekdms17/post/048e1a5e-e172-46df-8dfb-317ee7f88bd7/image.png)

lib 디렉토리를 삭제해주도록 하겠습니다.


[그림 6]을 다시 확인해보면 인텔리제이에서는 Spring 5.2.3 버전을 제공하고 있다는 것을 알 수 있고,

인텔리제이에서 제공하는 프레임워크는 lib 디렉토리에 기본 라이브러리를 자동으로 추가시킵니다. 그러나 기본으로 제공되는 라이브러리를 사용하지 않고 메이븐 저장소(Maven Repository)를 이용하여 라이브러리를 관리할 것이기 때문에 인텔리제이가 추가한 라이브러리를 삭제하는 것입니다.

![](https://velog.velcdn.com/images/dbekdms17/post/70156d69-33be-4d0c-a499-ff133fdb75a3/image.png)

Command+;(Ctrl+Alt+Shift+S) 단축키를 이용하여 Project Structure 창을 활성화하고, 프로젝트 설정(Project Settings) 목록에서 Libraries에 추가되어 있는 Spring MVC-5.2.3.RELEASE와 Spring-5.2.3.RELEASE를 삭제해야 합니다.


([그림 8]에서 lib 디렉토리와 인텔리제이에서 자동으로 추가한 라이브러리를 전부 삭제했기 때문에 프로젝트에 설정된 라이브러리는 존재하지 않아 무의미하기 때문입니다.)

![](https://velog.velcdn.com/images/dbekdms17/post/f1dd564d-c7af-4f1f-82d2-095092d9da9c/image.png)

![](https://velog.velcdn.com/images/dbekdms17/post/5e2e3e29-c886-48cd-87bc-5c392bc19f62/image.png)
인텔리제이에서 스프링 프로젝트 생성을 완료했습니다.

([그림 10]과 [그림 11]은 스프링 프로젝트가 완성된 결과 화면입니다.)


---
1. pom에 적었는데 다운이 안될 경우 
![](https://velog.velcdn.com/images/dbekdms17/post/174d4f3b-6515-419c-95f6-4c7389643695/image.png)

pom.xml 화면을 클릭하면 옆에 자그마하게 뜨는데 그것을 클릭하면
자동으로 다운 받아준다.
그러면 다음과 같이 받아진다.

![](https://velog.velcdn.com/images/dbekdms17/post/9150e965-8109-4935-8377-21ebfe53152c/image.png)


2. src/main/java & src/main/resources

이클립스에서 보면 스프링 프로젝트를 만들면 자동으로 생성되지만 인텔리제이에서는 자동으로 만들어지지 않는다.
그렇기 때문에 직접 생성해줘야 한다.

먼저 폴더를 생성해줘야 한다.

![](https://velog.velcdn.com/images/dbekdms17/post/5275381d-c6ea-4947-a40f-52ff7cf9ad9e/image.png)
![](https://velog.velcdn.com/images/dbekdms17/post/af24b0b3-61c4-484d-89bd-daa34555ffc3/image.png)

디렉토리를 소스 디렉토리로 설정하려면 다음과 같이 해야한다.

![](https://velog.velcdn.com/images/dbekdms17/post/ec936a71-eb8d-4d8e-9ac1-cf0a76b00250/image.png)
![](https://velog.velcdn.com/images/dbekdms17/post/f85e3913-9fa0-4a4b-bd97-cb605bc2c1d5/image.png)

> **HomeController내용**
```java
package com.example.controller;
>
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
>
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
>
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
>
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
>
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
>
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
>
        String formattedDate = dateFormat.format(date);
>
        model.addAttribute("serverTime", formattedDate );
>
        return "index";
    }
>
}
>
```

log4j.xml을 추가하고 내용을 작성한다.
![](https://velog.velcdn.com/images/dbekdms17/post/f8349988-a8bd-4c05-aba8-65a76e9e9621/image.png)

>```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE log4j:configuration PUBLIC "-//APACHE//DTD LOG4J 1.2//EN" "log4j.dtd">
<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">
?
    <!-- Appenders -->
    <appender name="console" class="org.apache.log4j.ConsoleAppender">
        <param name="Target" value="System.out" />
        <layout class="org.apache.log4j.PatternLayout">
            <param name="ConversionPattern" value="%-5p: %c - %m%n" />
        </layout>
    </appender>
>
    <!-- Application Loggers -->
    <logger name="com.example.ex00">
        <level value="info" />
    </logger>
>
    <!-- 3rdparty Loggers -->
    <logger name="org.springframework.core">
        <level value="info" />
    </logger>
>
    <logger name="org.springframework.beans">
        <level value="info" />
    </logger>
>
    <logger name="org.springframework.context">
        <level value="info" />
    </logger>
>
    <logger name="org.springframework.web">
        <level value="info" />
    </logger>
>
    <!-- Root Logger -->
    <root>
        <priority value="warn" />
        <appender-ref ref="console" />
    </root>
>
</log4j:configuration>
```


3. test 생성

먼저 src안에 test를 만들어 주고 그안에 java와 resource를 만들어준다.

![](https://velog.velcdn.com/images/dbekdms17/post/c22d7cdf-a8dc-45fa-ba04-d7887f9d6158/image.png)


4. webapp 안에 구성

![](https://velog.velcdn.com/images/dbekdms17/post/d1b09a4e-d783-4360-b2e9-bd167428f3e8/image.png)

![](https://velog.velcdn.com/images/dbekdms17/post/b24a5114-79d5-4cf1-8a5e-aafcd8db9e79/image.png)
![](https://velog.velcdn.com/images/dbekdms17/post/114b1001-d83e-45ba-b4b8-56625a847af7/image.png)


`web.xml`에 내용을 추가한다.

>```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="2.5" xmlns="http://java.sun.com/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee https://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">
>
    <!-- The definition of the Root Spring Container shared by all Servlets and Filters -->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/spring/root-context.xml</param-value>
    </context-param>
>
    <!-- Creates the Spring Container shared by all Servlets and Filters -->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
>
    <!-- Processes application requests -->
    <servlet>
        <servlet-name>appServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
>
    <servlet-mapping>
        <servlet-name>appServlet</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
>
</web-app>
```

![](https://velog.velcdn.com/images/dbekdms17/post/1a0235a1-7e4d-4bcd-a382-9e98b20abbfe/image.png)
![업로드중..](blob:https://velog.io/18024e7d-f576-4911-a0c9-8d5465908124)


>**root-context.xml**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mybatis-spring="http://mybatis.org/schema/mybatis-spring"
       xsi:schemaLocation="http://mybatis.org/schema/mybatis-spring http://mybatis.org/schema/mybatis-spring-1.2.xsd
		http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd">
>
    <!-- property를 참고로 hikariConfig라는 bean이 생성된다. -->
    <bean id="hikariConfig" class="com.zaxxer.hikari.HikariConfig">
        <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"></property>
        <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/web0315"></property>
        <property name="username" value="root"></property>
        <property name="password" value="1234"></property>
    </bean>
>
    <!-- 위에서 hikariConfig라는 bean을 참고로 해서 DataSource라는 bean 생성된다. -->
    <bean id="dataSource" class="com.zaxxer.hikari.HikariDataSource" destroy-method="close">
        <!-- hikariConfig라는 객체를 참고하라는 것 -->
        <constructor-arg ref="hikariConfig"/>
    </bean>
    <!-- Root Context: defines shared resources visible to all other web components -->
    <!-- 어디서 scan하면 니가 주입할 객체들을 찾을 수 있는지 알려주는 것 -->
    <context:component-scan base-package="com.example.sample"/>
    <!-- Root Context: defines shared resources visible to all other web components -->
>
</beans>
```

>**servlet-context.xml**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">
>
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/views/"/>
        <property name="suffix" value=".jsp"/>
        <property name="order" value="1"/>
    </bean>
>
    <context:component-scan base-package="com.example.controller"/>
</beans>
```
