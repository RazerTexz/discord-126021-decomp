package com.esotericsoftware.kryo.factories;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.util.Util;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes.dex */
public class ReflectionSerializerFactory implements SerializerFactory {
    private final Class<? extends Serializer> serializerClass;

    public ReflectionSerializerFactory(Class<? extends Serializer> cls) {
        this.serializerClass = cls;
    }

    @Override // com.esotericsoftware.kryo.factories.SerializerFactory
    public Serializer makeSerializer(Kryo kryo, Class<?> cls) {
        return makeSerializer(kryo, this.serializerClass, cls);
    }

    public static Serializer makeSerializer(Kryo kryo, Class<? extends Serializer> cls, Class<?> cls2) {
        try {
            try {
                try {
                    try {
                        return cls.getConstructor(Kryo.class, Class.class).newInstance(kryo, cls2);
                    } catch (NoSuchMethodException unused) {
                        return cls.newInstance();
                    }
                } catch (Exception e) {
                    StringBuilder sbM833U = C1643a.m833U("Unable to create serializer \"");
                    sbM833U.append(cls.getName());
                    sbM833U.append("\" for class: ");
                    sbM833U.append(Util.className(cls2));
                    throw new IllegalArgumentException(sbM833U.toString(), e);
                }
            } catch (NoSuchMethodException unused2) {
                return cls.getConstructor(Kryo.class).newInstance(kryo);
            }
        } catch (NoSuchMethodException unused3) {
            return cls.getConstructor(Class.class).newInstance(cls2);
        }
    }
}
