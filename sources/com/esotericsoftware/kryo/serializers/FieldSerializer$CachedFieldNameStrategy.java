package com.esotericsoftware.kryo.serializers;

/* JADX INFO: loaded from: classes.dex */
public interface FieldSerializer$CachedFieldNameStrategy {
    public static final FieldSerializer$CachedFieldNameStrategy DEFAULT = new FieldSerializer$CachedFieldNameStrategy$1();
    public static final FieldSerializer$CachedFieldNameStrategy EXTENDED = new FieldSerializer$CachedFieldNameStrategy$2();

    String getName(FieldSerializer$CachedField fieldSerializer$CachedField);
}
