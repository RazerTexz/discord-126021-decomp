package com.esotericsoftware.kryo.serializers;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public interface FieldSerializer$CachedFieldFactory {
    FieldSerializer$CachedField createCachedField(Class cls, Field field, FieldSerializer fieldSerializer);
}
