package com.example.demo02.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Slf4j
//@Configuration //Step 1 : 声明一个Spring管理配置Bean
//@Aspect               //Step 2 :声明了这是一个切面类
public class AOPConfig {
    // Throwable 和exection什么关系
    //Step 3 :声明了一个表达式。描述要组织的目标的特性，用within表示目标类型带有注解
    @Around("@within(org.springframework.stereotype.Controller) ")
    public Object simpleAop(final ProceedingJoinPoint pjp) throws Throwable {
        //Step 4 : simpleAop 使用来织入的代码，其参数为  ProceedingJoinPoint
        try {
            Object[] args = pjp.getArgs();
            log.info("args :" + Arrays.asList(args));
            Object target = pjp.getTarget();
            //获取指定注解
            log.info(pjp.getSignature().toString());//String com.example.demo02.web.HelloWorldController.say()
            //log.info(pjp.getStaticPart().toString());//execution(String com.example.demo02.web.HelloWorldController.say())
            String methodName = pjp.getSignature().getName();
            log.info("被访问的方法名:{}", methodName);//方法名
            log.info("被访问的类名是:{}", pjp.getSignature().getDeclaringTypeName());//类名


            RequestMapping annotations = target.getClass().getDeclaredMethod(methodName).getAnnotation(RequestMapping.class);
            if (annotations != null) {
                String[] value = annotations.value();
                log.info("访问的路径是:{}", value);
            }

            //Step 5 :执行完切面代码，还继续执行应用代码
            //调用原有方法
            Object proceed = pjp.proceed(args);
            return proceed;

        } catch (Throwable e) {
            log.info("方法AOP出现异常");
            throw e;
        }

    }
}
