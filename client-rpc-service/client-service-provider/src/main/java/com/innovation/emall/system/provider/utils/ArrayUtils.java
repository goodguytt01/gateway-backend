package com.innovation.emall.system.provider.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArrayUtils<S,T> {
    public  List<T> copyList(List<S> origin,List<T> result,Class clazz) throws IllegalAccessException,InstantiationException{
        if(origin!=null&&origin.size()>0){
            for(Object o:origin){
                T obj = (T)clazz.newInstance();
                BeanUtils.copyProperties(o,obj);
                result.add(obj);
                }
             }
        return result;
    }

}
