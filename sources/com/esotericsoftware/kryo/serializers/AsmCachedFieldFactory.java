package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.serializers.AsmCacheFields;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class AsmCachedFieldFactory implements FieldSerializer.CachedFieldFactory {
    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedFieldFactory
    public FieldSerializer.CachedField createCachedField(Class cls, Field field, FieldSerializer fieldSerializer) {
        if (!cls.isPrimitive()) {
            return (cls != String.class || (fieldSerializer.kryo.getReferences() && fieldSerializer.kryo.getReferenceResolver().useReferences(String.class))) ? new AsmCacheFields.AsmObjectField(fieldSerializer) : new AsmCacheFields.AsmStringField();
        }
        if (cls == Boolean.TYPE) {
            return new AsmCacheFields.AsmBooleanField();
        }
        if (cls == Byte.TYPE) {
            return new AsmCacheFields.AsmByteField();
        }
        if (cls == Character.TYPE) {
            return new AsmCacheFields.AsmCharField();
        }
        if (cls == Short.TYPE) {
            return new AsmCacheFields.AsmShortField();
        }
        if (cls == Integer.TYPE) {
            return new AsmCacheFields.AsmIntField();
        }
        if (cls == Long.TYPE) {
            return new AsmCacheFields.AsmLongField();
        }
        if (cls == Float.TYPE) {
            return new AsmCacheFields.AsmFloatField();
        }
        return cls == Double.TYPE ? new AsmCacheFields.AsmDoubleField() : new AsmCacheFields.AsmObjectField(fieldSerializer);
    }
}
