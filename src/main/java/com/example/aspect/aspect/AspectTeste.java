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
            //get parameter data
            String nomeArg = (String)pjp.getArgs()[0];
            System.out.print("O nome que veio no parametro é: " + nomeArg);

            Object proceed = pjp.proceed();

            //transform data returned from method
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
