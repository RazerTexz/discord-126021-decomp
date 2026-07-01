package com.esotericsoftware.kryo.util;

import java.lang.reflect.Field;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class UnsafeUtil$1 implements Comparator<Field> {
    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Field field, Field field2) {
        return compare2(field, field2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(Field field, Field field2) {
        long jObjectFieldOffset = UnsafeUtil.unsafe().objectFieldOffset(field);
        long jObjectFieldOffset2 = UnsafeUtil.unsafe().objectFieldOffset(field2);
        if (jObjectFieldOffset < jObjectFieldOffset2) {
            return -1;
        }
        return jObjectFieldOffset == jObjectFieldOffset2 ? 0 : 1;
    }
}
