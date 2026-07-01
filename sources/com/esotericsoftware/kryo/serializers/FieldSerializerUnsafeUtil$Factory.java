package com.esotericsoftware.kryo.serializers;

import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes.dex */
public class FieldSerializerUnsafeUtil$Factory {
    public static Constructor<FieldSerializerUnsafeUtil> fieldSerializerUnsafeUtilConstructor;

    static {
        try {
            fieldSerializerUnsafeUtilConstructor = FieldSerializer.class.getClassLoader().loadClass("com.esotericsoftware.kryo.serializers.FieldSerializerUnsafeUtilImpl").getConstructor(FieldSerializer.class);
        } catch (Throwable unused) {
        }
    }

    public static FieldSerializerUnsafeUtil getInstance(FieldSerializer fieldSerializer) {
        Constructor<FieldSerializerUnsafeUtil> constructor = fieldSerializerUnsafeUtilConstructor;
        if (constructor == null) {
            return null;
        }
        try {
            return constructor.newInstance(fieldSerializer);
        } catch (Exception unused) {
            return null;
        }
    }
}
