# Square

Saves and gets a number from an Oracle database and squares it.

The idea of the project is that there are two rest-services which saves and gets a number from a database. One rest-service will save a number that is supplied through a frontend. The other rest-service takes an id number from the frontend, looks in the database for that id, takes the number and squares it. Finally the service returns the value to the frontend. I am trying to make the project to run and during the testing I want a in-memory database (H2) to simulate the database.

Installation <br>
A dependency is needed from Oracle at http://www.oracle.com/technetwork/database/features/jdbc/jdbc-drivers-12c-download-1958347.html called ojdbc7.jar. Download it to eg "C:\ojdbc7.jar" and in the terminal of the project write "mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc7 -Dpackaging=jar -Dversion=12.1.0.1 -DgeneratePom=true -Dfile=C:\ojdbc7.jar" to install that one separately.

Issues <br>
1. When running main application maven cannot start a bean. Why? What is wrong?
2. When running only the test in the square-app module it say "Failed to load ApplicationContext". Why? Again what is wrong?

Error report of issue 1 with starting main application: <br>
"C:\Program Files\Java\jdk1.8.0_162\bin\java" -Dmaven.multiModuleProjectDirectory=D:\ProgramProjekt\IntelliJ\Square\square-app "-Dmaven.home=C:\Program Files\apache-maven-3.5.2" "-Dclassworlds.conf=C:\Program Files\apache-maven-3.5.2\bin\m2.conf" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2017.3\lib\idea_rt.jar=59283:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2017.3\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\apache-maven-3.5.2\boot\plexus-classworlds-2.5.2.jar" org.codehaus.classworlds.Launcher -Didea.version=2017.3.3 org.springframework.boot:spring-boot-maven-plugin:1.5.9.RELEASE:run
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] Building square-app 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] >>> spring-boot-maven-plugin:1.5.9.RELEASE:run (default-cli) > test-compile @ square-app >>>
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ square-app ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 2 resources
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ square-app ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ square-app ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory D:\ProgramProjekt\IntelliJ\Square\square-app\src\test\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ square-app ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] <<< spring-boot-maven-plugin:1.5.9.RELEASE:run (default-cli) < test-compile @ square-app <<<
[INFO] 
[INFO] 
[INFO] --- spring-boot-maven-plugin:1.5.9.RELEASE:run (default-cli) @ square-app ---

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.5.9.RELEASE)

2018-01-29 01:27:38.574   INFO 2184 --- [           main] square.app.SquareApplication             : Starting SquareApplication on Ansoas with PID 2184 (D:\ProgramProjekt\IntelliJ\Square\square-app\target\classes started by Ansoas in D:\ProgramProjekt\IntelliJ\Square\square-app)
2018-01-29 01:27:38.590   INFO 2184 --- [           main] square.app.SquareApplication             : The following profiles are active: dev
2018-01-29 01:27:38.653   INFO 2184 --- [           main] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@22a2c888: startup date [Mon Jan 29 01:27:38 CET 2018]; root of context hierarchy
2018-01-29 01:27:40.184   INFO 2184 --- [           main] o.s.b.f.s.DefaultListableBeanFactory     : Overriding bean definition for bean 'httpRequestHandlerAdapter' with a different definition: replacing [Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration$EnableWebMvcConfiguration; factoryMethodName=httpRequestHandlerAdapter; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/boot/autoconfigure/web/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]] with [Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration; factoryMethodName=httpRequestHandlerAdapter; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springframework/data/rest/webmvc/config/RepositoryRestMvcConfiguration.class]]
2018-01-29 01:27:40.856   INFO 2184 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration$$EnhancerBySpringCGLIB$$afb036a0] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2018-01-29 01:27:40.996   WARN 2184 --- [           main] ationConfigEmbeddedWebApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.context.ApplicationContextException: Unable to start embedded container; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'tomcatEmbeddedServletContainerFactory' defined in class path resource [org/springframework/boot/autoconfigure/web/EmbeddedServletContainerAutoConfiguration$EmbeddedTomcat.class]: Initialization of bean failed; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'org.springframework.boot.autoconfigure.web.HttpEncodingAutoConfiguration': Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'spring.http.encoding-org.springframework.boot.autoconfigure.web.HttpEncodingProperties': Initialization of bean failed; nested exception is java.lang.NoClassDefFoundError: javax/validation/ClockProvider
2018-01-29 01:27:40.996   INFO 2184 --- [           main] utoConfigurationReportLoggingInitializer : 

Error starting ApplicationContext. To display the auto-configuration report re-run your application with 'debug' enabled.
2018-01-29 01:27:41.012  ERROR 2184 --- [           main] o.s.boot.SpringApplication               : Application startup failed

org.springframework.context.ApplicationContextException: Unable to start embedded container; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'tomcatEmbeddedServletContainerFactory' defined in class path resource [org/springframework/boot/autoconfigure/web/EmbeddedServletContainerAutoConfiguration$EmbeddedTomcat.class]: Initialization of bean failed; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'org.springframework.boot.autoconfigure.web.HttpEncodingAutoConfiguration': Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'spring.http.encoding-org.springframework.boot.autoconfigure.web.HttpEncodingProperties': Initialization of bean failed; nested exception is java.lang.NoClassDefFoundError: javax/validation/ClockProvider
	at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.onRefresh(EmbeddedWebApplicationContext.java:137) ~[spring-boot-1.5.9.RELEASE.jar:1.5.9.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:543) ~[spring-context-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.refresh(EmbeddedWebApplicationContext.java:122) ~[spring-boot-1.5.9.RELEASE.jar:1.5.9.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:693) [spring-boot-1.5.9.RELEASE.jar:1.5.9.RELEASE]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:360) [spring-boot-1.5.9.RELEASE.jar:1.5.9.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:303) [spring-boot-1.5.9.RELEASE.jar:1.5.9.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1118) [spring-boot-1.5.9.RELEASE.jar:1.5.9.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1107) [spring-boot-1.5.9.RELEASE.jar:1.5.9.RELEASE]
	at square.app.SquareApplication.main(SquareApplication.java:14) [classes/:na]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_162]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_162]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_162]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_162]
	at org.springframework.boot.maven.AbstractRunMojo$LaunchRunner.run(AbstractRunMojo.java:527) [spring-boot-maven-plugin-1.5.9.RELEASE.jar:1.5.9.RELEASE]
	at java.lang.Thread.run(Thread.java:748) [na:1.8.0_162]
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'tomcatEmbeddedServletContainerFactory' defined in class path resource [org/springframework/boot/autoconfigure/web/EmbeddedServletContainerAutoConfiguration$EmbeddedTomcat.class]: Initialization of bean failed; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'org.springframework.boot.autoconfigure.web.HttpEncodingAutoConfiguration': Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'spring.http.encoding-org.springframework.boot.autoconfigure.web.HttpEncodingProperties': Initialization of bean failed; nested exception is java.lang.NoClassDefFoundError: javax/validation/ClockProvider
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:591) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:502) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:312) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:228) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:310) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:205) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.getEmbeddedServletContainerFactory(EmbeddedWebApplicationContext.java:199) ~[spring-boot-1.5.9.RELEASE.jar:1.5.9.RELEASE]
	at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.createEmbeddedServletContainer(EmbeddedWebApplicationContext.java:162) ~[spring-boot-1.5.9.RELEASE.jar:1.5.9.RELEASE]
	at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.onRefresh(EmbeddedWebApplicationContext.java:134) ~[spring-boot-1.5.9.RELEASE.jar:1.5.9.RELEASE]
	... 14 common frames omitted
Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'org.springframework.boot.autoconfigure.web.HttpEncodingAutoConfiguration': Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'spring.http.encoding-org.springframework.boot.autoconfigure.web.HttpEncodingProperties': Initialization of bean failed; nested exception is java.lang.NoClassDefFoundError: javax/validation/ClockProvider
	at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:729) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.ConstructorResolver.autowireConstructor(ConstructorResolver.java:192) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireConstructor(AbstractAutowireCapableBeanFactory.java:1270) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1127) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:545) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:502) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:312) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:228) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:310) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:200) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:368) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1250) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1099) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:545) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:502) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:312) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:228) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:310) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:200) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeansOfType(DefaultListableBeanFactory.java:516) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizerBeanPostProcessor.getCustomizers(EmbeddedServletContainerCustomizerBeanPostProcessor.java:82) ~[spring-boot-1.5.9.RELEASE.jar:1.5.9.RELEASE]
	at org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizerBeanPostProcessor.postProcessBeforeInitialization(EmbeddedServletContainerCustomizerBeanPostProcessor.java:72) ~[spring-boot-1.5.9.RELEASE.jar:1.5.9.RELEASE]
	at org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizerBeanPostProcessor.postProcessBeforeInitialization(EmbeddedServletContainerCustomizerBeanPostProcessor.java:59) ~[spring-boot-1.5.9.RELEASE.jar:1.5.9.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization(AbstractAutowireCapableBeanFactory.java:423) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1702) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:583) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	... 22 common frames omitted
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'spring.http.encoding-org.springframework.boot.autoconfigure.web.HttpEncodingProperties': Initialization of bean failed; nested exception is java.lang.NoClassDefFoundError: javax/validation/ClockProvider
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:591) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:502) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:312) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:228) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:310) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:200) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:251) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1138) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1065) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.ConstructorResolver.resolveAutowiredArgument(ConstructorResolver.java:815) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:721) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	... 47 common frames omitted
Caused by: java.lang.NoClassDefFoundError: javax/validation/ClockProvider
	at org.hibernate.validator.HibernateValidator.createGenericConfiguration(HibernateValidator.java:33) ~[hibernate-validator-6.0.7.Final.jar:6.0.7.Final]
	at javax.validation.Validation$GenericBootstrapImpl.configure(Validation.java:276) ~[validation-api-1.1.0.Final.jar:na]
	at org.springframework.boot.validation.MessageInterpolatorFactory.getObject(MessageInterpolatorFactory.java:53) ~[spring-boot-1.5.9.RELEASE.jar:1.5.9.RELEASE]
	at org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor$ValidatedLocalValidatorFactoryBean.<init>(ConfigurationPropertiesBindingPostProcessor.java:412) ~[spring-boot-1.5.9.RELEASE.jar:1.5.9.RELEASE]
	at org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor.getValidator(ConfigurationPropertiesBindingPostProcessor.java:369) ~[spring-boot-1.5.9.RELEASE.jar:1.5.9.RELEASE]
	at org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor.determineValidator(ConfigurationPropertiesBindingPostProcessor.java:353) ~[spring-boot-1.5.9.RELEASE.jar:1.5.9.RELEASE]
	at org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor.postProcessBeforeInitialization(ConfigurationPropertiesBindingPostProcessor.java:315) ~[spring-boot-1.5.9.RELEASE.jar:1.5.9.RELEASE]
	at org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor.postProcessBeforeInitialization(ConfigurationPropertiesBindingPostProcessor.java:292) ~[spring-boot-1.5.9.RELEASE.jar:1.5.9.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization(AbstractAutowireCapableBeanFactory.java:423) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1702) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:583) ~[spring-beans-5.0.3.RELEASE.jar:5.0.3.RELEASE]
	... 57 common frames omitted
Caused by: java.lang.ClassNotFoundException: javax.validation.ClockProvider
	at java.net.URLClassLoader.findClass(URLClassLoader.java:381) ~[na:1.8.0_162]
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424) ~[na:1.8.0_162]
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357) ~[na:1.8.0_162]
	... 68 common frames omitted

[WARNING] 
java.lang.reflect.InvocationTargetException
    at sun.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:62)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke (Method.java:498)
    at org.springframework.boot.maven.AbstractRunMojo$LaunchRunner.run (AbstractRunMojo.java:527)
    at java.lang.Thread.run (Thread.java:748)
Caused by: org.springframework.context.ApplicationContextException: Unable to start embedded container; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'tomcatEmbeddedServletContainerFactory' defined in class path resource [org/springframework/boot/autoconfigure/web/EmbeddedServletContainerAutoConfiguration$EmbeddedTomcat.class]: Initialization of bean failed; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'org.springframework.boot.autoconfigure.web.HttpEncodingAutoConfiguration': Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'spring.http.encoding-org.springframework.boot.autoconfigure.web.HttpEncodingProperties': Initialization of bean failed; nested exception is java.lang.NoClassDefFoundError: javax/validation/ClockProvider
    at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.onRefresh (EmbeddedWebApplicationContext.java:137)
    at org.springframework.context.support.AbstractApplicationContext.refresh (AbstractApplicationContext.java:543)
    at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.refresh (EmbeddedWebApplicationContext.java:122)
    at org.springframework.boot.SpringApplication.refresh (SpringApplication.java:693)
    at org.springframework.boot.SpringApplication.refreshContext (SpringApplication.java:360)
    at org.springframework.boot.SpringApplication.run (SpringApplication.java:303)
    at org.springframework.boot.SpringApplication.run (SpringApplication.java:1118)
    at org.springframework.boot.SpringApplication.run (SpringApplication.java:1107)
    at square.app.SquareApplication.main (SquareApplication.java:14)
    at sun.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:62)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke (Method.java:498)
    at org.springframework.boot.maven.AbstractRunMojo$LaunchRunner.run (AbstractRunMojo.java:527)
    at java.lang.Thread.run (Thread.java:748)
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'tomcatEmbeddedServletContainerFactory' defined in class path resource [org/springframework/boot/autoconfigure/web/EmbeddedServletContainerAutoConfiguration$EmbeddedTomcat.class]: Initialization of bean failed; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'org.springframework.boot.autoconfigure.web.HttpEncodingAutoConfiguration': Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'spring.http.encoding-org.springframework.boot.autoconfigure.web.HttpEncodingProperties': Initialization of bean failed; nested exception is java.lang.NoClassDefFoundError: javax/validation/ClockProvider
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean (AbstractAutowireCapableBeanFactory.java:591)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean (AbstractAutowireCapableBeanFactory.java:502)
    at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0 (AbstractBeanFactory.java:312)
    at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton (DefaultSingletonBeanRegistry.java:228)
    at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean (AbstractBeanFactory.java:310)
    at org.springframework.beans.factory.support.AbstractBeanFactory.getBean (AbstractBeanFactory.java:205)
    at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.getEmbeddedServletContainerFactory (EmbeddedWebApplicationContext.java:199)
    at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.createEmbeddedServletContainer (EmbeddedWebApplicationContext.java:162)
    at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.onRefresh (EmbeddedWebApplicationContext.java:134)
    at org.springframework.context.support.AbstractApplicationContext.refresh (AbstractApplicationContext.java:543)
    at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.refresh (EmbeddedWebApplicationContext.java:122)
    at org.springframework.boot.SpringApplication.refresh (SpringApplication.java:693)
    at org.springframework.boot.SpringApplication.refreshContext (SpringApplication.java:360)
    at org.springframework.boot.SpringApplication.run (SpringApplication.java:303)
    at org.springframework.boot.SpringApplication.run (SpringApplication.java:1118)
    at org.springframework.boot.SpringApplication.run (SpringApplication.java:1107)
    at square.app.SquareApplication.main (SquareApplication.java:14)
    at sun.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:62)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke (Method.java:498)
    at org.springframework.boot.maven.AbstractRunMojo$LaunchRunner.run (AbstractRunMojo.java:527)
    at java.lang.Thread.run (Thread.java:748)
Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'org.springframework.boot.autoconfigure.web.HttpEncodingAutoConfiguration': Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'spring.http.encoding-org.springframework.boot.autoconfigure.web.HttpEncodingProperties': Initialization of bean failed; nested exception is java.lang.NoClassDefFoundError: javax/validation/ClockProvider
    at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray (ConstructorResolver.java:729)
    at org.springframework.beans.factory.support.ConstructorResolver.autowireConstructor (ConstructorResolver.java:192)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireConstructor (AbstractAutowireCapableBeanFactory.java:1270)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance (AbstractAutowireCapableBeanFactory.java:1127)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean (AbstractAutowireCapableBeanFactory.java:545)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean (AbstractAutowireCapableBeanFactory.java:502)
    at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0 (AbstractBeanFactory.java:312)
    at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton (DefaultSingletonBeanRegistry.java:228)
    at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean (AbstractBeanFactory.java:310)
    at org.springframework.beans.factory.support.AbstractBeanFactory.getBean (AbstractBeanFactory.java:200)
    at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod (ConstructorResolver.java:368)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod (AbstractAutowireCapableBeanFactory.java:1250)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance (AbstractAutowireCapableBeanFactory.java:1099)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean (AbstractAutowireCapableBeanFactory.java:545)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean (AbstractAutowireCapableBeanFactory.java:502)
    at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0 (AbstractBeanFactory.java:312)
    at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton (DefaultSingletonBeanRegistry.java:228)
    at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean (AbstractBeanFactory.java:310)
    at org.springframework.beans.factory.support.AbstractBeanFactory.getBean (AbstractBeanFactory.java:200)
    at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeansOfType (DefaultListableBeanFactory.java:516)
    at org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizerBeanPostProcessor.getCustomizers (EmbeddedServletContainerCustomizerBeanPostProcessor.java:82)
    at org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizerBeanPostProcessor.postProcessBeforeInitialization (EmbeddedServletContainerCustomizerBeanPostProcessor.java:72)
    at org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizerBeanPostProcessor.postProcessBeforeInitialization (EmbeddedServletContainerCustomizerBeanPostProcessor.java:59)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization (AbstractAutowireCapableBeanFactory.java:423)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean (AbstractAutowireCapableBeanFactory.java:1702)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean (AbstractAutowireCapableBeanFactory.java:583)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean (AbstractAutowireCapableBeanFactory.java:502)
    at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0 (AbstractBeanFactory.java:312)
    at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton (DefaultSingletonBeanRegistry.java:228)
    at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean (AbstractBeanFactory.java:310)
    at org.springframework.beans.factory.support.AbstractBeanFactory.getBean (AbstractBeanFactory.java:205)
    at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.getEmbeddedServletContainerFactory (EmbeddedWebApplicationContext.java:199)
    at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.createEmbeddedServletContainer (EmbeddedWebApplicationContext.java:162)
    at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.onRefresh (EmbeddedWebApplicationContext.java:134)
    at org.springframework.context.support.AbstractApplicationContext.refresh (AbstractApplicationContext.java:543)
    at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.refresh (EmbeddedWebApplicationContext.java:122)
    at org.springframework.boot.SpringApplication.refresh (SpringApplication.java:693)
    at org.springframework.boot.SpringApplication.refreshContext (SpringApplication.java:360)
    at org.springframework.boot.SpringApplication.run (SpringApplication.java:303)
    at org.springframework.boot.SpringApplication.run (SpringApplication.java:1118)
    at org.springframework.boot.SpringApplication.run (SpringApplication.java:1107)
    at square.app.SquareApplication.main (SquareApplication.java:14)
    at sun.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:62)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke (Method.java:498)
    at org.springframework.boot.maven.AbstractRunMojo$LaunchRunner.run (AbstractRunMojo.java:527)
    at java.lang.Thread.run (Thread.java:748)
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'spring.http.encoding-org.springframework.boot.autoconfigure.web.HttpEncodingProperties': Initialization of bean failed; nested exception is java.lang.NoClassDefFoundError: javax/validation/ClockProvider
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean (AbstractAutowireCapableBeanFactory.java:591)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean (AbstractAutowireCapableBeanFactory.java:502)
    at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0 (AbstractBeanFactory.java:312)
    at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton (DefaultSingletonBeanRegistry.java:228)
    at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean (AbstractBeanFactory.java:310)
    at org.springframework.beans.factory.support.AbstractBeanFactory.getBean (AbstractBeanFactory.java:200)
    at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate (DependencyDescriptor.java:251)
    at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency (DefaultListableBeanFactory.java:1138)
    at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency (DefaultListableBeanFactory.java:1065)
    at org.springframework.beans.factory.support.ConstructorResolver.resolveAutowiredArgument (ConstructorResolver.java:815)
    at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray (ConstructorResolver.java:721)
    at org.springframework.beans.factory.support.ConstructorResolver.autowireConstructor (ConstructorResolver.java:192)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireConstructor (AbstractAutowireCapableBeanFactory.java:1270)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance (AbstractAutowireCapableBeanFactory.java:1127)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean (AbstractAutowireCapableBeanFactory.java:545)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean (AbstractAutowireCapableBeanFactory.java:502)
    at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0 (AbstractBeanFactory.java:312)
    at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton (DefaultSingletonBeanRegistry.java:228)
    at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean (AbstractBeanFactory.java:310)
    at org.springframework.beans.factory.support.AbstractBeanFactory.getBean (AbstractBeanFactory.java:200)
    at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod (ConstructorResolver.java:368)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod (AbstractAutowireCapableBeanFactory.java:1250)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance (AbstractAutowireCapableBeanFactory.java:1099)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean (AbstractAutowireCapableBeanFactory.java:545)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean (AbstractAutowireCapableBeanFactory.java:502)
    at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0 (AbstractBeanFactory.java:312)
    at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton (DefaultSingletonBeanRegistry.java:228)
    at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean (AbstractBeanFactory.java:310)
    at org.springframework.beans.factory.support.AbstractBeanFactory.getBean (AbstractBeanFactory.java:200)
    at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeansOfType (DefaultListableBeanFactory.java:516)
    at org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizerBeanPostProcessor.getCustomizers (EmbeddedServletContainerCustomizerBeanPostProcessor.java:82)
    at org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizerBeanPostProcessor.postProcessBeforeInitialization (EmbeddedServletContainerCustomizerBeanPostProcessor.java:72)
    at org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizerBeanPostProcessor.postProcessBeforeInitialization (EmbeddedServletContainerCustomizerBeanPostProcessor.java:59)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization (AbstractAutowireCapableBeanFactory.java:423)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean (AbstractAutowireCapableBeanFactory.java:1702)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean (AbstractAutowireCapableBeanFactory.java:583)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean (AbstractAutowireCapableBeanFactory.java:502)
    at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0 (AbstractBeanFactory.java:312)
    at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton (DefaultSingletonBeanRegistry.java:228)
    at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean (AbstractBeanFactory.java:310)
    at org.springframework.beans.factory.support.AbstractBeanFactory.getBean (AbstractBeanFactory.java:205)
    at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.getEmbeddedServletContainerFactory (EmbeddedWebApplicationContext.java:199)
    at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.createEmbeddedServletContainer (EmbeddedWebApplicationContext.java:162)
    at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.onRefresh (EmbeddedWebApplicationContext.java:134)
    at org.springframework.context.support.AbstractApplicationContext.refresh (AbstractApplicationContext.java:543)
    at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.refresh (EmbeddedWebApplicationContext.java:122)
    at org.springframework.boot.SpringApplication.refresh (SpringApplication.java:693)
    at org.springframework.boot.SpringApplication.refreshContext (SpringApplication.java:360)
    at org.springframework.boot.SpringApplication.run (SpringApplication.java:303)
    at org.springframework.boot.SpringApplication.run (SpringApplication.java:1118)
    at org.springframework.boot.SpringApplication.run (SpringApplication.java:1107)
    at square.app.SquareApplication.main (SquareApplication.java:14)
    at sun.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:62)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke (Method.java:498)
    at org.springframework.boot.maven.AbstractRunMojo$LaunchRunner.run (AbstractRunMojo.java:527)
    at java.lang.Thread.run (Thread.java:748)
Caused by: java.lang.NoClassDefFoundError: javax/validation/ClockProvider
    at org.hibernate.validator.HibernateValidator.createGenericConfiguration (HibernateValidator.java:33)
    at javax.validation.Validation$GenericBootstrapImpl.configure (Validation.java:276)
    at org.springframework.boot.validation.MessageInterpolatorFactory.getObject (MessageInterpolatorFactory.java:53)
    at org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor$ValidatedLocalValidatorFactoryBean.<init> (ConfigurationPropertiesBindingPostProcessor.java:412)
    at org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor.getValidator (ConfigurationPropertiesBindingPostProcessor.java:369)
    at org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor.determineValidator (ConfigurationPropertiesBindingPostProcessor.java:353)
    at org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor.postProcessBeforeInitialization (ConfigurationPropertiesBindingPostProcessor.java:315)
    at org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor.postProcessBeforeInitialization (ConfigurationPropertiesBindingPostProcessor.java:292)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization (AbstractAutowireCapableBeanFactory.java:423)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean (AbstractAutowireCapableBeanFactory.java:1702)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean (AbstractAutowireCapableBeanFactory.java:583)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean (AbstractAutowireCapableBeanFactory.java:502)
    at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0 (AbstractBeanFactory.java:312)
    at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton (DefaultSingletonBeanRegistry.java:228)
    at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean (AbstractBeanFactory.java:310)
    at org.springframework.beans.factory.support.AbstractBeanFactory.getBean (AbstractBeanFactory.java:200)
    at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate (DependencyDescriptor.java:251)
    at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency (DefaultListableBeanFactory.java:1138)
    at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency (DefaultListableBeanFactory.java:1065)
    at org.springframework.beans.factory.support.ConstructorResolver.resolveAutowiredArgument (ConstructorResolver.java:815)
    at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray (ConstructorResolver.java:721)
    at org.springframework.beans.factory.support.ConstructorResolver.autowireConstructor (ConstructorResolver.java:192)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireConstructor (AbstractAutowireCapableBeanFactory.java:1270)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance (AbstractAutowireCapableBeanFactory.java:1127)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean (AbstractAutowireCapableBeanFactory.java:545)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean (AbstractAutowireCapableBeanFactory.java:502)
    at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0 (AbstractBeanFactory.java:312)
    at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton (DefaultSingletonBeanRegistry.java:228)
    at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean (AbstractBeanFactory.java:310)
    at org.springframework.beans.factory.support.AbstractBeanFactory.getBean (AbstractBeanFactory.java:200)
    at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod (ConstructorResolver.java:368)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod (AbstractAutowireCapableBeanFactory.java:1250)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance (AbstractAutowireCapableBeanFactory.java:1099)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean (AbstractAutowireCapableBeanFactory.java:545)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean (AbstractAutowireCapableBeanFactory.java:502)
    at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0 (AbstractBeanFactory.java:312)
    at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton (DefaultSingletonBeanRegistry.java:228)
    at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean (AbstractBeanFactory.java:310)
    at org.springframework.beans.factory.support.AbstractBeanFactory.getBean (AbstractBeanFactory.java:200)
    at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeansOfType (DefaultListableBeanFactory.java:516)
    at org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizerBeanPostProcessor.getCustomizers (EmbeddedServletContainerCustomizerBeanPostProcessor.java:82)
    at org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizerBeanPostProcessor.postProcessBeforeInitialization (EmbeddedServletContainerCustomizerBeanPostProcessor.java:72)
    at org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizerBeanPostProcessor.postProcessBeforeInitialization (EmbeddedServletContainerCustomizerBeanPostProcessor.java:59)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization (AbstractAutowireCapableBeanFactory.java:423)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean (AbstractAutowireCapableBeanFactory.java:1702)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean (AbstractAutowireCapableBeanFactory.java:583)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean (AbstractAutowireCapableBeanFactory.java:502)
    at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0 (AbstractBeanFactory.java:312)
    at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton (DefaultSingletonBeanRegistry.java:228)
    at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean (AbstractBeanFactory.java:310)
    at org.springframework.beans.factory.support.AbstractBeanFactory.getBean (AbstractBeanFactory.java:205)
    at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.getEmbeddedServletContainerFactory (EmbeddedWebApplicationContext.java:199)
    at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.createEmbeddedServletContainer (EmbeddedWebApplicationContext.java:162)
    at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.onRefresh (EmbeddedWebApplicationContext.java:134)
    at org.springframework.context.support.AbstractApplicationContext.refresh (AbstractApplicationContext.java:543)
    at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.refresh (EmbeddedWebApplicationContext.java:122)
    at org.springframework.boot.SpringApplication.refresh (SpringApplication.java:693)
    at org.springframework.boot.SpringApplication.refreshContext (SpringApplication.java:360)
    at org.springframework.boot.SpringApplication.run (SpringApplication.java:303)
    at org.springframework.boot.SpringApplication.run (SpringApplication.java:1118)
    at org.springframework.boot.SpringApplication.run (SpringApplication.java:1107)
    at square.app.SquareApplication.main (SquareApplication.java:14)
    at sun.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:62)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke (Method.java:498)
    at org.springframework.boot.maven.AbstractRunMojo$LaunchRunner.run (AbstractRunMojo.java:527)
    at java.lang.Thread.run (Thread.java:748)
Caused by: java.lang.ClassNotFoundException: javax.validation.ClockProvider
    at java.net.URLClassLoader.findClass (URLClassLoader.java:381)
    at java.lang.ClassLoader.loadClass (ClassLoader.java:424)
    at java.lang.ClassLoader.loadClass (ClassLoader.java:357)
    at org.hibernate.validator.HibernateValidator.createGenericConfiguration (HibernateValidator.java:33)
    at javax.validation.Validation$GenericBootstrapImpl.configure (Validation.java:276)
    at org.springframework.boot.validation.MessageInterpolatorFactory.getObject (MessageInterpolatorFactory.java:53)
    at org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor$ValidatedLocalValidatorFactoryBean.<init> (ConfigurationPropertiesBindingPostProcessor.java:412)
    at org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor.getValidator (ConfigurationPropertiesBindingPostProcessor.java:369)
    at org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor.determineValidator (ConfigurationPropertiesBindingPostProcessor.java:353)
    at org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor.postProcessBeforeInitialization (ConfigurationPropertiesBindingPostProcessor.java:315)
    at org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor.postProcessBeforeInitialization (ConfigurationPropertiesBindingPostProcessor.java:292)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization (AbstractAutowireCapableBeanFactory.java:423)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean (AbstractAutowireCapableBeanFactory.java:1702)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean (AbstractAutowireCapableBeanFactory.java:583)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean (AbstractAutowireCapableBeanFactory.java:502)
    at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0 (AbstractBeanFactory.java:312)
    at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton (DefaultSingletonBeanRegistry.java:228)
    at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean (AbstractBeanFactory.java:310)
    at org.springframework.beans.factory.support.AbstractBeanFactory.getBean (AbstractBeanFactory.java:200)
    at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate (DependencyDescriptor.java:251)
    at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency (DefaultListableBeanFactory.java:1138)
    at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency (DefaultListableBeanFactory.java:1065)
    at org.springframework.beans.factory.support.ConstructorResolver.resolveAutowiredArgument (ConstructorResolver.java:815)
    at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray (ConstructorResolver.java:721)
    at org.springframework.beans.factory.support.ConstructorResolver.autowireConstructor (ConstructorResolver.java:192)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireConstructor (AbstractAutowireCapableBeanFactory.java:1270)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance (AbstractAutowireCapableBeanFactory.java:1127)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean (AbstractAutowireCapableBeanFactory.java:545)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean (AbstractAutowireCapableBeanFactory.java:502)
    at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0 (AbstractBeanFactory.java:312)
    at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton (DefaultSingletonBeanRegistry.java:228)
    at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean (AbstractBeanFactory.java:310)
    at org.springframework.beans.factory.support.AbstractBeanFactory.getBean (AbstractBeanFactory.java:200)
    at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod (ConstructorResolver.java:368)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod (AbstractAutowireCapableBeanFactory.java:1250)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance (AbstractAutowireCapableBeanFactory.java:1099)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean (AbstractAutowireCapableBeanFactory.java:545)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean (AbstractAutowireCapableBeanFactory.java:502)
    at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0 (AbstractBeanFactory.java:312)
    at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton (DefaultSingletonBeanRegistry.java:228)
    at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean (AbstractBeanFactory.java:310)
    at org.springframework.beans.factory.support.AbstractBeanFactory.getBean (AbstractBeanFactory.java:200)
    at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeansOfType (DefaultListableBeanFactory.java:516)
    at org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizerBeanPostProcessor.getCustomizers (EmbeddedServletContainerCustomizerBeanPostProcessor.java:82)
    at org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizerBeanPostProcessor.postProcessBeforeInitialization (EmbeddedServletContainerCustomizerBeanPostProcessor.java:72)
    at org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizerBeanPostProcessor.postProcessBeforeInitialization (EmbeddedServletContainerCustomizerBeanPostProcessor.java:59)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization (AbstractAutowireCapableBeanFactory.java:423)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean (AbstractAutowireCapableBeanFactory.java:1702)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean (AbstractAutowireCapableBeanFactory.java:583)
    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean (AbstractAutowireCapableBeanFactory.java:502)
    at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0 (AbstractBeanFactory.java:312)
    at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton (DefaultSingletonBeanRegistry.java:228)
    at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean (AbstractBeanFactory.java:310)
    at org.springframework.beans.factory.support.AbstractBeanFactory.getBean (AbstractBeanFactory.java:205)
    at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.getEmbeddedServletContainerFactory (EmbeddedWebApplicationContext.java:199)
    at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.createEmbeddedServletContainer (EmbeddedWebApplicationContext.java:162)
    at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.onRefresh (EmbeddedWebApplicationContext.java:134)
    at org.springframework.context.support.AbstractApplicationContext.refresh (AbstractApplicationContext.java:543)
    at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.refresh (EmbeddedWebApplicationContext.java:122)
    at org.springframework.boot.SpringApplication.refresh (SpringApplication.java:693)
    at org.springframework.boot.SpringApplication.refreshContext (SpringApplication.java:360)
    at org.springframework.boot.SpringApplication.run (SpringApplication.java:303)
    at org.springframework.boot.SpringApplication.run (SpringApplication.java:1118)
    at org.springframework.boot.SpringApplication.run (SpringApplication.java:1107)
    at square.app.SquareApplication.main (SquareApplication.java:14)
    at sun.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:62)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke (Method.java:498)
    at org.springframework.boot.maven.AbstractRunMojo$LaunchRunner.run (AbstractRunMojo.java:527)
    at java.lang.Thread.run (Thread.java:748)
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 6.063 s
[INFO] Finished at: 2018-01-29T01:27:41+01:00
[INFO] Final Memory: 34M/378M
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.springframework.boot:spring-boot-maven-plugin:1.5.9.RELEASE:run (default-cli) on project square-app: An exception occurred while running. null: InvocationTargetException: Unable to start embedded container; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'tomcatEmbeddedServletContainerFactory' defined in class path resource [org/springframework/boot/autoconfigure/web/EmbeddedServletContainerAutoConfiguration$EmbeddedTomcat.class]: Initialization of bean failed; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'org.springframework.boot.autoconfigure.web.HttpEncodingAutoConfiguration': Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'spring.http.encoding-org.springframework.boot.autoconfigure.web.HttpEncodingProperties': Initialization of bean failed; nested exception is java.lang.NoClassDefFoundError: javax/validation/ClockProvider: javax.validation.ClockProvider -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException
Picked up JAVA_TOOL_OPTIONS: -Dfile.encoding=UTF8

Process finished with exit code 1

<br><br>--------------------------------------------------------------------------------------------<br><br>
Error report of issue 2 with trying the test class: <br>

java.lang.IllegalStateException: Failed to load ApplicationContext

	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:125)
	at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:107)
	at org.springframework.test.context.support.DependencyInjectionTestExecutionListener.injectDependencies(DependencyInjectionTestExecutionListener.java:117)
	at org.springframework.test.context.support.DependencyInjectionTestExecutionListener.prepareTestInstance(DependencyInjectionTestExecutionListener.java:83)
	at org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener.prepareTestInstance(SpringBootDependencyInjectionTestExecutionListener.java:44)
	at org.springframework.test.context.TestContextManager.prepareTestInstance(TestContextManager.java:242)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.createTest(SpringJUnit4ClassRunner.java:227)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner$1.runReflectiveCall(SpringJUnit4ClassRunner.java:289)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.methodBlock(SpringJUnit4ClassRunner.java:291)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:246)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:97)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.springframework.test.context.junit4.statements.RunBeforeTestClassCallbacks.evaluate(RunBeforeTestClassCallbacks.java:61)
	at org.springframework.test.context.junit4.statements.RunAfterTestClassCallbacks.evaluate(RunAfterTestClassCallbacks.java:70)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.run(SpringJUnit4ClassRunner.java:190)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)
	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)
	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)
Caused by: org.springframework.context.ApplicationContextException: Unable to start embedded container; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'tomcatEmbeddedServletContainerFactory' defined in class path resource [org/springframework/boot/autoconfigure/web/EmbeddedServletContainerAutoConfiguration$EmbeddedTomcat.class]: Initialization of bean failed; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'org.springframework.boot.autoconfigure.web.HttpEncodingAutoConfiguration': Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'spring.http.encoding-org.springframework.boot.autoconfigure.web.HttpEncodingProperties': Initialization of bean failed; nested exception is java.lang.NoClassDefFoundError: javax/validation/ClockProvider
	at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.onRefresh(EmbeddedWebApplicationContext.java:137)
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:543)
	at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.refresh(EmbeddedWebApplicationContext.java:122)
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:693)
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:360)
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
	at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:120)
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:117)
	... 25 more
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'tomcatEmbeddedServletContainerFactory' defined in class path resource [org/springframework/boot/autoconfigure/web/EmbeddedServletContainerAutoConfiguration$EmbeddedTomcat.class]: Initialization of bean failed; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'org.springframework.boot.autoconfigure.web.HttpEncodingAutoConfiguration': Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'spring.http.encoding-org.springframework.boot.autoconfigure.web.HttpEncodingProperties': Initialization of bean failed; nested exception is java.lang.NoClassDefFoundError: javax/validation/ClockProvider
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:591)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:502)
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:312)
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:228)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:310)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:205)
	at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.getEmbeddedServletContainerFactory(EmbeddedWebApplicationContext.java:199)
	at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.createEmbeddedServletContainer(EmbeddedWebApplicationContext.java:162)
	at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.onRefresh(EmbeddedWebApplicationContext.java:134)
	... 33 more
Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'org.springframework.boot.autoconfigure.web.HttpEncodingAutoConfiguration': Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'spring.http.encoding-org.springframework.boot.autoconfigure.web.HttpEncodingProperties': Initialization of bean failed; nested exception is java.lang.NoClassDefFoundError: javax/validation/ClockProvider
	at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:729)
	at org.springframework.beans.factory.support.ConstructorResolver.autowireConstructor(ConstructorResolver.java:192)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireConstructor(AbstractAutowireCapableBeanFactory.java:1270)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1127)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:545)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:502)
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:312)
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:228)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:310)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:200)
	at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:368)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1250)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1099)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:545)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:502)
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:312)
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:228)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:310)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:200)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeansOfType(DefaultListableBeanFactory.java:516)
	at org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizerBeanPostProcessor.getCustomizers(EmbeddedServletContainerCustomizerBeanPostProcessor.java:82)
	at org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizerBeanPostProcessor.postProcessBeforeInitialization(EmbeddedServletContainerCustomizerBeanPostProcessor.java:72)
	at org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizerBeanPostProcessor.postProcessBeforeInitialization(EmbeddedServletContainerCustomizerBeanPostProcessor.java:59)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization(AbstractAutowireCapableBeanFactory.java:423)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1702)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:583)
	... 41 more
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'spring.http.encoding-org.springframework.boot.autoconfigure.web.HttpEncodingProperties': Initialization of bean failed; nested exception is java.lang.NoClassDefFoundError: javax/validation/ClockProvider
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:591)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:502)
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:312)
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:228)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:310)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:200)
	at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:251)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1138)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1065)
	at org.springframework.beans.factory.support.ConstructorResolver.resolveAutowiredArgument(ConstructorResolver.java:815)
	at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:721)
	... 66 more
Caused by: java.lang.NoClassDefFoundError: javax/validation/ClockProvider
	at org.hibernate.validator.HibernateValidator.createGenericConfiguration(HibernateValidator.java:33)
	at javax.validation.Validation$GenericBootstrapImpl.configure(Validation.java:276)
	at org.springframework.boot.validation.MessageInterpolatorFactory.getObject(MessageInterpolatorFactory.java:53)
	at org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor$ValidatedLocalValidatorFactoryBean.<init>(ConfigurationPropertiesBindingPostProcessor.java:412)
	at org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor.getValidator(ConfigurationPropertiesBindingPostProcessor.java:369)
	at org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor.determineValidator(ConfigurationPropertiesBindingPostProcessor.java:353)
	at org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor.postProcessBeforeInitialization(ConfigurationPropertiesBindingPostProcessor.java:315)
	at org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor.postProcessBeforeInitialization(ConfigurationPropertiesBindingPostProcessor.java:292)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization(AbstractAutowireCapableBeanFactory.java:423)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1702)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:583)
	... 76 more
Caused by: java.lang.ClassNotFoundException: javax.validation.ClockProvider
	at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:338)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	... 87 more

