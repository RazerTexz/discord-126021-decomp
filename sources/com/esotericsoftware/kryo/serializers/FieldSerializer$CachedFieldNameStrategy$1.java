package com.esotericsoftware.kryo.serializers;

/* JADX INFO: loaded from: classes.dex */
public class FieldSerializer$CachedFieldNameStrategy$1 implements FieldSerializer$CachedFieldNameStrategy {
    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedFieldNameStrategy
    public String getName(FieldSerializer$CachedField fieldSerializer$CachedField) {
        return fieldSerializer$CachedField.field.getName();
    }
}
