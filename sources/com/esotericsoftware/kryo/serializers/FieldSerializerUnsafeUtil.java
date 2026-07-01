package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.util.IntArray;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface FieldSerializerUnsafeUtil {
    void createUnsafeCacheFieldsAndRegions(List<Field> list, List<FieldSerializer$CachedField> list2, int i, IntArray intArray);

    long getObjectFieldOffset(Field field);
}
