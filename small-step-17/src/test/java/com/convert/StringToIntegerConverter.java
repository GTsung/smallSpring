package com.convert;

import com.convert.convert.Converter;

/**
 * @author GTsung
 * @date 2021/10/17
 */
public class StringToIntegerConverter implements Converter<String, Integer> {

    @Override
    public Integer convert(String source) {
        return Integer.valueOf(source);
    }

}