package com.example.aspect.aspect;

import com.example.aspect.dominio.Nome;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectTeste {

    @Around("execution(* com.example.aspect.service.TesteService..*(..))")
    public Object testeAspect(ProceedingJoinPoint pjp) throws Throwable {

        try {
            Object proceed = pjp.proceed();
            Nome novo = (Nome) proceed;
            String nome = novo.getNome();
            String nomeTratado = nome.replace("-", " ");
            novo.setNome(nomeTratado);
            return novo;
        } catch (Throwable exc) {
            System.out.println(exc.getMessage());
            throw new Exception("teste");
        }
    }

}
