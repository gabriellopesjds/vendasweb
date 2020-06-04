package com.gabriellopesjds.vendasweb.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

class ParameterizedTypeImpl implements ParameterizedType {

    private ParameterizedType delegate;

    private Type[] actualTypeArguments;

    ParameterizedTypeImpl(ParameterizedType delegate, Type[] actualTypeArguments) {
        this.delegate = delegate;
        this.actualTypeArguments = actualTypeArguments;
    }
    
    @Override
    public Type[] getActualTypeArguments() {
        return actualTypeArguments;
    }

    @Override
    public Type getRawType() {
        return delegate.getRawType();
    }

    @Override
    public Type getOwnerType() {
        return delegate.getOwnerType();
    }

}
