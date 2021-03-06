package com.basaki.aspect;

import com.basaki.annotation.MyAnno;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * {@code MyAspect} intercepts any private method execution if a
 * method is tagged with {@code com.basaki.annotation.MyAnno}
 * annotation.
 * <p>
 *
 * @author Indra Basak
 * @since 11/3/17
 */
@Component
@Aspect
public class MyAspect {

    @Before("@annotation(myAnnoAnnotation) && execution(private * *(..))")
    public void myAnnoAspect(JoinPoint jp, MyAnno myAnnoAnnotation) {
        System.out.println(
                "Entering MyAspect.myAnnoAspect() in class "
                        + jp.getSignature().getDeclaringTypeName()
                        + " - method: " + jp.getSignature().getName());
    }
}
