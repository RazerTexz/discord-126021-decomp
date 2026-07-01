package com.esotericsoftware.kryo.serializers;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class TaggedFieldSerializer$1 implements Comparator<FieldSerializer$CachedField> {
    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(FieldSerializer$CachedField fieldSerializer$CachedField, FieldSerializer$CachedField fieldSerializer$CachedField2) {
        return compare2(fieldSerializer$CachedField, fieldSerializer$CachedField2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(FieldSerializer$CachedField fieldSerializer$CachedField, FieldSerializer$CachedField fieldSerializer$CachedField2) {
        return ((TaggedFieldSerializer$Tag) fieldSerializer$CachedField.getField().getAnnotation(TaggedFieldSerializer$Tag.class)).value() - ((TaggedFieldSerializer$Tag) fieldSerializer$CachedField2.getField().getAnnotation(TaggedFieldSerializer$Tag.class)).value();
    }
}
