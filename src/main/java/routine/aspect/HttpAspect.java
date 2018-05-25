package routine.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Aop类
 * Component:在持久层、业务层和控制层分别采用 @Repository、@Service 和 @Controller 对分层中的类进行注释，而用 @Component 对那些比较中立的类进行注释
 *            这里就是说把这个类交给Spring管理，重新起个名字叫userManager，由于不好说这个类属于哪个层面，就用@Component
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);


    //@Pointcut:切点
    @Pointcut("execution(*  routine.controller..*.*(..))")
    //@Pointcut("execution(public * routine.controller.PaperController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println(">>><doBefore:请求开始>:");

        //url
        logger.info("<doBefore:请求开始>:","  [url:]"+ request.getRequestURL()+"  [method:]"+request.getMethod()+"  [ip:]"+request.getRemoteAddr()+
                     "  [class_method:]"+ joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()+
                     "  [args:]"+joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        logger.info("<doAfter>请求完成");
    }

    //获取返回的内容
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("<doAfterReturning:请求返回结果>:", object.toString());
    }

}
