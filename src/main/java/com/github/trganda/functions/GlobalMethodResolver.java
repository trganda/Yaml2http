package com.github.trganda.functions;

import org.springframework.expression.spel.support.ReflectiveMethodResolver;

import java.lang.reflect.Method;

public class GlobalMethodResolver extends ReflectiveMethodResolver {

    @Override
    protected Method[] getMethods(Class<?> type) {
        try {
            return new Method[] {
                    Functions.class.getDeclaredMethod("randomInt", Integer.TYPE, Integer.TYPE),
                    Functions.class.getDeclaredMethod("base64", String.class),
                    Functions.class.getDeclaredMethod("md5", String.class),
            };
        }
        catch (NoSuchMethodException ex) {
            return new Method[0];
        }
    }
    
}
