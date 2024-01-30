package ru.netology.rest.service;

import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


public abstract class ArgumentResolver implements HandlerMethodArgumentResolver {

    private final WebArgumentResolver adaptee;

    protected ArgumentResolver(WebArgumentResolver adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        try {
            NativeWebRequest webRequest = getWebRequest();
            Object result = this.adaptee.resolveArgument(parameter, webRequest);
            if (result == WebArgumentResolver.UNRESOLVED) {
                return false;
            } else {
                return ClassUtils.isAssignableValue(parameter.getParameterType(), result);
            }
        } catch (Exception ex) {
            return false;
        }
    }


    @Override
    @Nullable
    public Object resolveArgument(MethodParameter parameter, @Nullable ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, @Nullable WebDataBinderFactory binderFactory) throws Exception {

        Class<?> paramType = parameter.getParameterType();
        Object result = this.adaptee.resolveArgument(parameter, webRequest);
        if (result == WebArgumentResolver.UNRESOLVED || !ClassUtils.isAssignableValue(paramType, result)) {
            throw new IllegalStateException("Standard argument type [" + paramType.getName() + "] in method " + parameter.getMethod() +
                            "resolved to incompatible value of type [" + (result != null ? result.getClass() : null) + "]. " +
                    "Consider declaring the argument type in a less specific fashion.");
        }
        return result;
    }

    protected abstract NativeWebRequest getWebRequest();

}
