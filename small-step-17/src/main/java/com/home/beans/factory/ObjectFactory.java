package com.home.beans.factory;

import com.home.beans.BeansException;

public interface ObjectFactory<T> {

    T getObject() throws BeansException;
}
