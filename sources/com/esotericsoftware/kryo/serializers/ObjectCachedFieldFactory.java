package com.esotericsoftware.kryo.serializers;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class ObjectCachedFieldFactory implements FieldSerializer$CachedFieldFactory {
    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedFieldFactory
    public FieldSerializer$CachedField createCachedField(Class cls, Field field, FieldSerializer fieldSerializer) {
        if (!cls.isPrimitive()) {
            return new ObjectField(fieldSerializer);
        }
        if (cls == Boolean.TYPE) {
            return new ObjectField$ObjectBooleanField(fieldSerializer);
        }
        if (cls == Byte.TYPE) {
            return new ObjectField$ObjectByteField(fieldSerializer);
        }
        if (cls == Character.TYPE) {
            return new ObjectField$ObjectCharField(fieldSerializer);
        }
        if (cls == Short.TYPE) {
            return new ObjectField$ObjectShortField(fieldSerializer);
        }
        if (cls == Integer.TYPE) {
            return new ObjectField$ObjectIntField(fieldSerializer);
        }
        if (cls == Long.TYPE) {
            return new ObjectField$ObjectLongField(fieldSerializer);
        }
        if (cls == Float.TYPE) {
            return new ObjectField$ObjectFloatField(fieldSerializer);
        }
        return cls == Double.TYPE ? new ObjectField$ObjectDoubleField(fieldSerializer) : new ObjectField(fieldSerializer);
    }
}
