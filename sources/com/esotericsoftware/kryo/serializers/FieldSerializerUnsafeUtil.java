package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.esotericsoftware.kryo.util.IntArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface FieldSerializerUnsafeUtil {

    public static class Factory {
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

    void createUnsafeCacheFieldsAndRegions(List<Field> list, List<FieldSerializer.CachedField> list2, int i, IntArray intArray);

    long getObjectFieldOffset(Field field);
}
