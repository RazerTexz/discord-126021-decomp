package com.esotericsoftware.kryo.serializers;

import b.e.a.a;
import b.e.a.a$a;
import b.e.b.d;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class BeanSerializer<T> extends Serializer<T> {
    public static final Object[] noArgs = new Object[0];
    public Object access;
    private BeanSerializer$CachedProperty[] properties;

    public BeanSerializer(Kryo kryo, Class cls) {
        try {
            PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(cls).getPropertyDescriptors();
            Arrays.sort(propertyDescriptors, new BeanSerializer$1(this));
            ArrayList arrayList = new ArrayList(propertyDescriptors.length);
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String name = propertyDescriptor.getName();
                if (!name.equals("class")) {
                    Method readMethod = propertyDescriptor.getReadMethod();
                    Method writeMethod = propertyDescriptor.getWriteMethod();
                    if (readMethod != null && writeMethod != null) {
                        Class<?> returnType = readMethod.getReturnType();
                        Serializer serializer = kryo.isFinal(returnType) ? kryo.getRegistration(returnType).getSerializer() : null;
                        BeanSerializer$CachedProperty beanSerializer$CachedProperty = new BeanSerializer$CachedProperty(this);
                        beanSerializer$CachedProperty.name = name;
                        beanSerializer$CachedProperty.getMethod = readMethod;
                        beanSerializer$CachedProperty.setMethod = writeMethod;
                        beanSerializer$CachedProperty.serializer = serializer;
                        beanSerializer$CachedProperty.setMethodType = writeMethod.getParameterTypes()[0];
                        arrayList.add(beanSerializer$CachedProperty);
                    }
                }
            }
            this.properties = (BeanSerializer$CachedProperty[]) arrayList.toArray(new BeanSerializer$CachedProperty[arrayList.size()]);
            try {
                this.access = d.b(cls);
                int length = this.properties.length;
                for (int i = 0; i < length; i++) {
                    BeanSerializer$CachedProperty beanSerializer$CachedProperty2 = this.properties[i];
                    beanSerializer$CachedProperty2.getterAccessIndex = ((d) this.access).c(beanSerializer$CachedProperty2.getMethod.getName(), beanSerializer$CachedProperty2.getMethod.getParameterTypes());
                    beanSerializer$CachedProperty2.setterAccessIndex = ((d) this.access).c(beanSerializer$CachedProperty2.setMethod.getName(), beanSerializer$CachedProperty2.setMethod.getParameterTypes());
                }
            } catch (Throwable unused) {
            }
        } catch (IntrospectionException e) {
            throw new KryoException("Error getting bean info.", e);
        }
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public T copy(Kryo kryo, T t) {
        T t2 = (T) kryo.newInstance(t.getClass());
        int length = this.properties.length;
        for (int i = 0; i < length; i++) {
            BeanSerializer$CachedProperty beanSerializer$CachedProperty = this.properties[i];
            try {
                beanSerializer$CachedProperty.set(t2, beanSerializer$CachedProperty.get(t));
            } catch (KryoException e) {
                e.addTrace(beanSerializer$CachedProperty + " (" + t2.getClass().getName() + ")");
                throw e;
            } catch (RuntimeException e2) {
                KryoException kryoException = new KryoException(e2);
                kryoException.addTrace(beanSerializer$CachedProperty + " (" + t2.getClass().getName() + ")");
                throw kryoException;
            } catch (Exception e3) {
                throw new KryoException("Error copying bean property: " + beanSerializer$CachedProperty + " (" + t2.getClass().getName() + ")", e3);
            }
        }
        return t2;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public T read(Kryo kryo, Input input, Class<T> cls) {
        T t = (T) kryo.newInstance(cls);
        kryo.reference(t);
        int length = this.properties.length;
        for (int i = 0; i < length; i++) {
            BeanSerializer$CachedProperty beanSerializer$CachedProperty = this.properties[i];
            try {
                a$a a_a = a.a;
                Serializer serializer = beanSerializer$CachedProperty.serializer;
                beanSerializer$CachedProperty.set(t, serializer != null ? kryo.readObjectOrNull(input, beanSerializer$CachedProperty.setMethodType, serializer) : kryo.readClassAndObject(input));
            } catch (KryoException e) {
                e.addTrace(beanSerializer$CachedProperty + " (" + t.getClass().getName() + ")");
                throw e;
            } catch (IllegalAccessException e2) {
                throw new KryoException("Error accessing setter method: " + beanSerializer$CachedProperty + " (" + t.getClass().getName() + ")", e2);
            } catch (RuntimeException e3) {
                KryoException kryoException = new KryoException(e3);
                kryoException.addTrace(beanSerializer$CachedProperty + " (" + t.getClass().getName() + ")");
                throw kryoException;
            } catch (InvocationTargetException e4) {
                throw new KryoException("Error invoking setter method: " + beanSerializer$CachedProperty + " (" + t.getClass().getName() + ")", e4);
            }
        }
        return t;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public void write(Kryo kryo, Output output, T t) {
        Class<?> cls = t.getClass();
        int length = this.properties.length;
        for (int i = 0; i < length; i++) {
            BeanSerializer$CachedProperty beanSerializer$CachedProperty = this.properties[i];
            try {
                a$a a_a = a.a;
                Object obj = beanSerializer$CachedProperty.get(t);
                Serializer serializer = beanSerializer$CachedProperty.serializer;
                if (serializer != null) {
                    kryo.writeObjectOrNull(output, obj, serializer);
                } else {
                    kryo.writeClassAndObject(output, obj);
                }
            } catch (KryoException e) {
                StringBuilder sb = new StringBuilder();
                sb.append(beanSerializer$CachedProperty);
                sb.append(" (");
                b.d.b.a.a.m0(cls, sb, ")", e);
                throw e;
            } catch (IllegalAccessException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error accessing getter method: ");
                sb2.append(beanSerializer$CachedProperty);
                sb2.append(" (");
                throw new KryoException(b.d.b.a.a.o(cls, sb2, ")"), e2);
            } catch (RuntimeException e3) {
                KryoException kryoException = new KryoException(e3);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(beanSerializer$CachedProperty);
                sb3.append(" (");
                b.d.b.a.a.m0(cls, sb3, ")", kryoException);
                throw kryoException;
            } catch (InvocationTargetException e4) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Error invoking getter method: ");
                sb4.append(beanSerializer$CachedProperty);
                sb4.append(" (");
                throw new KryoException(b.d.b.a.a.o(cls, sb4, ")"), e4);
            }
        }
    }
}
