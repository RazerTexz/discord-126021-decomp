package com.esotericsoftware.kryo.serializers;

import b.e.a.a;
import b.e.a.a$a;
import b.e.b.c;
import com.esotericsoftware.kryo.util.IntArray;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class FieldSerializerUnsafeUtilImpl implements FieldSerializerUnsafeUtil {
    private FieldSerializer serializer;

    public FieldSerializerUnsafeUtilImpl(FieldSerializer fieldSerializer) {
        this.serializer = fieldSerializer;
    }

    private int fieldSizeOf(Class<?> cls) {
        if (cls == Integer.TYPE || cls == Float.TYPE) {
            return 4;
        }
        if (cls == Long.TYPE || cls == Double.TYPE) {
            return 8;
        }
        if (cls == Byte.TYPE || cls == Boolean.TYPE) {
            return 1;
        }
        if (cls == Short.TYPE || cls == Character.TYPE) {
            return 2;
        }
        return UnsafeUtil.unsafe().addressSize();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0092  */
    /* JADX WARN: Code duplicated, block: B:23:0x009c  */
    /* JADX WARN: Code duplicated, block: B:24:0x00aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:26:0x00b1  */
    @Override // com.esotericsoftware.kryo.serializers.FieldSerializerUnsafeUtil
    public void createUnsafeCacheFieldsAndRegions(List<Field> list, List<FieldSerializer$CachedField> list2, int i, IntArray intArray) {
        int i2;
        int iH;
        long jObjectFieldOffset;
        long j = 0;
        Field field = null;
        long j2 = -1;
        int i3 = 0;
        boolean z2 = false;
        int i4 = 0;
        int i5 = -1;
        for (int size = list.size(); i3 < size; size = i2) {
            Field field2 = list.get(i3);
            if (this.serializer.access != null) {
                i2 = size;
                iH = intArray.get(i + i3) == 1 ? ((c) this.serializer.access).h(field2.getName()) : -1;
                jObjectFieldOffset = UnsafeUtil.unsafe().objectFieldOffset(field2);
                long jFieldSizeOf = jObjectFieldOffset + ((long) fieldSizeOf(field2.getType()));
                if (field2.getType().isPrimitive() && z2) {
                    if (i4 > 1) {
                        a$a a_a = a.a;
                        UnsafeCacheFields$UnsafeRegionField unsafeCacheFields$UnsafeRegionField = new UnsafeCacheFields$UnsafeRegionField(j, j2 - j);
                        unsafeCacheFields$UnsafeRegionField.field = field;
                        list2.add(unsafeCacheFields$UnsafeRegionField);
                    } else if (field != null) {
                        list2.add(this.serializer.newCachedField(field, list2.size(), i5));
                    }
                    list2.add(this.serializer.newCachedField(field2, list2.size(), iH));
                    z2 = false;
                } else if (!field2.getType().isPrimitive()) {
                    list2.add(this.serializer.newCachedField(field2, list2.size(), iH));
                } else if (z2) {
                    i4++;
                } else {
                    j = jObjectFieldOffset;
                    z2 = true;
                    i4 = 1;
                }
                i3++;
                field = field2;
                i5 = iH;
                j2 = jFieldSizeOf;
            } else {
                i2 = size;
            }
            jObjectFieldOffset = UnsafeUtil.unsafe().objectFieldOffset(field2);
            long jFieldSizeOf2 = jObjectFieldOffset + ((long) fieldSizeOf(field2.getType()));
            if (field2.getType().isPrimitive()) {
                if (!field2.getType().isPrimitive()) {
                    list2.add(this.serializer.newCachedField(field2, list2.size(), iH));
                } else if (z2) {
                    j = jObjectFieldOffset;
                    z2 = true;
                    i4 = 1;
                } else {
                    i4++;
                }
            } else if (!field2.getType().isPrimitive()) {
                list2.add(this.serializer.newCachedField(field2, list2.size(), iH));
            } else if (z2) {
                j = jObjectFieldOffset;
                z2 = true;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            field = field2;
            i5 = iH;
            j2 = jFieldSizeOf2;
        }
        if (!this.serializer.getUseAsmEnabled() && this.serializer.getUseMemRegions() && z2) {
            if (i4 <= 1) {
                if (field != null) {
                    list2.add(this.serializer.newCachedField(field, list2.size(), i5));
                }
            } else {
                a$a a_a2 = a.a;
                UnsafeCacheFields$UnsafeRegionField unsafeCacheFields$UnsafeRegionField2 = new UnsafeCacheFields$UnsafeRegionField(j, j2 - j);
                unsafeCacheFields$UnsafeRegionField2.field = field;
                list2.add(unsafeCacheFields$UnsafeRegionField2);
            }
        }
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializerUnsafeUtil
    public long getObjectFieldOffset(Field field) {
        return UnsafeUtil.unsafe().objectFieldOffset(field);
    }
}
