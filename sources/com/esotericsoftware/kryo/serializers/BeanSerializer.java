package com.esotericsoftware.kryo.serializers;

import b.d.b.a.outline;
import b.e.a.Log;
import b.e.b.MethodAccess;
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
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class BeanSerializer<T> extends Serializer<T> {
    public static final Object[] noArgs = new Object[0];
    public Object access;
    private CachedProperty[] properties;

    public class CachedProperty<X> {
        public Method getMethod;
        public int getterAccessIndex;
        public String name;
        public Serializer serializer;
        public Method setMethod;
        public Class setMethodType;
        public int setterAccessIndex;

        public CachedProperty() {
        }

        public Object get(Object obj) throws IllegalAccessException, InvocationTargetException {
            Object obj2 = BeanSerializer.this.access;
            return obj2 != null ? ((MethodAccess) obj2).d(obj, this.getterAccessIndex, new Object[0]) : this.getMethod.invoke(obj, BeanSerializer.noArgs);
        }

        public void set(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
            Object obj3 = BeanSerializer.this.access;
            if (obj3 != null) {
                ((MethodAccess) obj3).d(obj, this.setterAccessIndex, obj2);
            } else {
                this.setMethod.invoke(obj, obj2);
            }
        }

        public String toString() {
            return this.name;
        }
    }

    public BeanSerializer(Kryo kryo, Class cls) {
        try {
            PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(cls).getPropertyDescriptors();
            Arrays.sort(propertyDescriptors, new Comparator<PropertyDescriptor>() { // from class: com.esotericsoftware.kryo.serializers.BeanSerializer.1
                @Override // java.util.Comparator
                public int compare(PropertyDescriptor propertyDescriptor, PropertyDescriptor propertyDescriptor2) {
                    return propertyDescriptor.getName().compareTo(propertyDescriptor2.getName());
                }
            });
            ArrayList arrayList = new ArrayList(propertyDescriptors.length);
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String name = propertyDescriptor.getName();
                if (!name.equals("class")) {
                    Method readMethod = propertyDescriptor.getReadMethod();
                    Method writeMethod = propertyDescriptor.getWriteMethod();
                    if (readMethod != null && writeMethod != null) {
                        Class<?> returnType = readMethod.getReturnType();
                        Serializer serializer = kryo.isFinal(returnType) ? kryo.getRegistration(returnType).getSerializer() : null;
                        CachedProperty cachedProperty = new CachedProperty();
                        cachedProperty.name = name;
                        cachedProperty.getMethod = readMethod;
                        cachedProperty.setMethod = writeMethod;
                        cachedProperty.serializer = serializer;
                        cachedProperty.setMethodType = writeMethod.getParameterTypes()[0];
                        arrayList.add(cachedProperty);
                    }
                }
            }
            this.properties = (CachedProperty[]) arrayList.toArray(new CachedProperty[arrayList.size()]);
            try {
                this.access = MethodAccess.b(cls);
                int length = this.properties.length;
                for (int i = 0; i < length; i++) {
                    CachedProperty cachedProperty2 = this.properties[i];
                    cachedProperty2.getterAccessIndex = ((MethodAccess) this.access).c(cachedProperty2.getMethod.getName(), cachedProperty2.getMethod.getParameterTypes());
                    cachedProperty2.setterAccessIndex = ((MethodAccess) this.access).c(cachedProperty2.setMethod.getName(), cachedProperty2.setMethod.getParameterTypes());
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
            CachedProperty cachedProperty = this.properties[i];
            try {
                cachedProperty.set(t2, cachedProperty.get(t));
            } catch (KryoException e) {
                e.addTrace(cachedProperty + " (" + t2.getClass().getName() + ")");
                throw e;
            } catch (RuntimeException e2) {
                KryoException kryoException = new KryoException(e2);
                kryoException.addTrace(cachedProperty + " (" + t2.getClass().getName() + ")");
                throw kryoException;
            } catch (Exception e3) {
                throw new KryoException("Error copying bean property: " + cachedProperty + " (" + t2.getClass().getName() + ")", e3);
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
            CachedProperty cachedProperty = this.properties[i];
            try {
                Log.a aVar = Log.a;
                Serializer serializer = cachedProperty.serializer;
                cachedProperty.set(t, serializer != null ? kryo.readObjectOrNull(input, cachedProperty.setMethodType, serializer) : kryo.readClassAndObject(input));
            } catch (KryoException e) {
                e.addTrace(cachedProperty + " (" + t.getClass().getName() + ")");
                throw e;
            } catch (IllegalAccessException e2) {
                throw new KryoException("Error accessing setter method: " + cachedProperty + " (" + t.getClass().getName() + ")", e2);
            } catch (RuntimeException e3) {
                KryoException kryoException = new KryoException(e3);
                kryoException.addTrace(cachedProperty + " (" + t.getClass().getName() + ")");
                throw kryoException;
            } catch (InvocationTargetException e4) {
                throw new KryoException("Error invoking setter method: " + cachedProperty + " (" + t.getClass().getName() + ")", e4);
            }
        }
        return t;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public void write(Kryo kryo, Output output, T t) {
        Class<?> cls = t.getClass();
        int length = this.properties.length;
        for (int i = 0; i < length; i++) {
            CachedProperty cachedProperty = this.properties[i];
            try {
                Log.a aVar = Log.a;
                Object obj = cachedProperty.get(t);
                Serializer serializer = cachedProperty.serializer;
                if (serializer != null) {
                    kryo.writeObjectOrNull(output, obj, serializer);
                } else {
                    kryo.writeClassAndObject(output, obj);
                }
            } catch (KryoException e) {
                StringBuilder sb = new StringBuilder();
                sb.append(cachedProperty);
                sb.append(" (");
                outline.m0(cls, sb, ")", e);
                throw e;
            } catch (IllegalAccessException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error accessing getter method: ");
                sb2.append(cachedProperty);
                sb2.append(" (");
                throw new KryoException(outline.o(cls, sb2, ")"), e2);
            } catch (RuntimeException e3) {
                KryoException kryoException = new KryoException(e3);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(cachedProperty);
                sb3.append(" (");
                outline.m0(cls, sb3, ")", kryoException);
                throw kryoException;
            } catch (InvocationTargetException e4) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Error invoking getter method: ");
                sb4.append(cachedProperty);
                sb4.append(" (");
                throw new KryoException(outline.o(cls, sb4, ")"), e4);
            }
        }
    }
}
