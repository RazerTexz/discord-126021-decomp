package com.esotericsoftware.kryo.serializers;

import b.e.b.d;
import com.esotericsoftware.kryo.Serializer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class BeanSerializer$CachedProperty<X> {
    public Method getMethod;
    public int getterAccessIndex;
    public String name;
    public Serializer serializer;
    public Method setMethod;
    public Class setMethodType;
    public int setterAccessIndex;
    public final /* synthetic */ BeanSerializer this$0;

    public BeanSerializer$CachedProperty(BeanSerializer beanSerializer) {
        this.this$0 = beanSerializer;
    }

    public Object get(Object obj) throws IllegalAccessException, InvocationTargetException {
        Object obj2 = this.this$0.access;
        return obj2 != null ? ((d) obj2).d(obj, this.getterAccessIndex, new Object[0]) : this.getMethod.invoke(obj, BeanSerializer.noArgs);
    }

    public void set(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        Object obj3 = this.this$0.access;
        if (obj3 != null) {
            ((d) obj3).d(obj, this.setterAccessIndex, obj2);
        } else {
            this.setMethod.invoke(obj, obj2);
        }
    }

    public String toString() {
        return this.name;
    }
}
