package com.esotericsoftware.kryo.util;

import b.d.b.a.outline;
import b.e.a.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import sun.misc.Cleaner;
import sun.misc.Unsafe;
import sun.nio.ch.DirectBuffer;

/* JADX INFO: loaded from: classes.dex */
public class UnsafeUtil {
    private static final Unsafe _unsafe;
    public static final long byteArrayBaseOffset;
    public static final long charArrayBaseOffset;
    public static Constructor<? extends ByteBuffer> directByteBufferConstr;
    public static final long doubleArrayBaseOffset;
    public static final long floatArrayBaseOffset;
    public static final long intArrayBaseOffset;
    public static final long longArrayBaseOffset;
    public static final long shortArrayBaseOffset;

    static {
        long jArrayBaseOffset;
        Unsafe unsafe;
        long jArrayBaseOffset2;
        long jArrayBaseOffset3;
        long jArrayBaseOffset4;
        long jArrayBaseOffset5;
        long jArrayBaseOffset6;
        long j;
        Unsafe unsafe2;
        long j2;
        long j3;
        long jArrayBaseOffset7;
        long j4;
        try {
            if (Util.IS_ANDROID) {
                Log.a aVar = Log.a;
                jArrayBaseOffset7 = 0;
                j3 = 0;
                j2 = 0;
                unsafe2 = null;
                jArrayBaseOffset3 = 0;
                jArrayBaseOffset4 = 0;
                jArrayBaseOffset5 = 0;
                j4 = 0;
            } else {
                Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
                declaredField.setAccessible(true);
                unsafe = (Unsafe) declaredField.get(null);
                try {
                    jArrayBaseOffset2 = unsafe.arrayBaseOffset(byte[].class);
                    try {
                        jArrayBaseOffset3 = unsafe.arrayBaseOffset(char[].class);
                        try {
                            jArrayBaseOffset4 = unsafe.arrayBaseOffset(short[].class);
                            try {
                                jArrayBaseOffset5 = unsafe.arrayBaseOffset(int[].class);
                                try {
                                    jArrayBaseOffset6 = unsafe.arrayBaseOffset(float[].class);
                                    try {
                                        jArrayBaseOffset = unsafe.arrayBaseOffset(long[].class);
                                        try {
                                            jArrayBaseOffset7 = unsafe.arrayBaseOffset(double[].class);
                                            j4 = jArrayBaseOffset6;
                                            unsafe2 = unsafe;
                                            j2 = jArrayBaseOffset;
                                            j3 = jArrayBaseOffset2;
                                        } catch (Exception unused) {
                                            Log.a aVar2 = Log.a;
                                            j = 0;
                                            unsafe2 = unsafe;
                                            j2 = jArrayBaseOffset;
                                            j3 = jArrayBaseOffset2;
                                        }
                                    } catch (Exception unused2) {
                                        jArrayBaseOffset = 0;
                                    }
                                } catch (Exception unused3) {
                                    jArrayBaseOffset = 0;
                                    jArrayBaseOffset6 = 0;
                                    Log.a aVar3 = Log.a;
                                    j = 0;
                                    unsafe2 = unsafe;
                                    j2 = jArrayBaseOffset;
                                    j3 = jArrayBaseOffset2;
                                    byteArrayBaseOffset = j3;
                                    charArrayBaseOffset = jArrayBaseOffset3;
                                    shortArrayBaseOffset = jArrayBaseOffset4;
                                    intArrayBaseOffset = jArrayBaseOffset5;
                                    floatArrayBaseOffset = jArrayBaseOffset6;
                                    longArrayBaseOffset = j2;
                                    doubleArrayBaseOffset = j;
                                    _unsafe = unsafe2;
                                    Constructor declaredConstructor = ByteBuffer.allocateDirect(1).getClass().getDeclaredConstructor(Long.TYPE, Integer.TYPE, Object.class);
                                    directByteBufferConstr = declaredConstructor;
                                    declaredConstructor.setAccessible(true);
                                }
                            } catch (Exception unused4) {
                                jArrayBaseOffset = 0;
                                jArrayBaseOffset5 = 0;
                                jArrayBaseOffset6 = 0;
                                Log.a aVar4 = Log.a;
                                j = 0;
                                unsafe2 = unsafe;
                                j2 = jArrayBaseOffset;
                                j3 = jArrayBaseOffset2;
                                byteArrayBaseOffset = j3;
                                charArrayBaseOffset = jArrayBaseOffset3;
                                shortArrayBaseOffset = jArrayBaseOffset4;
                                intArrayBaseOffset = jArrayBaseOffset5;
                                floatArrayBaseOffset = jArrayBaseOffset6;
                                longArrayBaseOffset = j2;
                                doubleArrayBaseOffset = j;
                                _unsafe = unsafe2;
                                Constructor declaredConstructor2 = ByteBuffer.allocateDirect(1).getClass().getDeclaredConstructor(Long.TYPE, Integer.TYPE, Object.class);
                                directByteBufferConstr = declaredConstructor2;
                                declaredConstructor2.setAccessible(true);
                            }
                        } catch (Exception unused5) {
                            jArrayBaseOffset = 0;
                            jArrayBaseOffset4 = 0;
                            jArrayBaseOffset5 = 0;
                            jArrayBaseOffset6 = 0;
                            Log.a aVar5 = Log.a;
                            j = 0;
                            unsafe2 = unsafe;
                            j2 = jArrayBaseOffset;
                            j3 = jArrayBaseOffset2;
                            byteArrayBaseOffset = j3;
                            charArrayBaseOffset = jArrayBaseOffset3;
                            shortArrayBaseOffset = jArrayBaseOffset4;
                            intArrayBaseOffset = jArrayBaseOffset5;
                            floatArrayBaseOffset = jArrayBaseOffset6;
                            longArrayBaseOffset = j2;
                            doubleArrayBaseOffset = j;
                            _unsafe = unsafe2;
                            Constructor declaredConstructor3 = ByteBuffer.allocateDirect(1).getClass().getDeclaredConstructor(Long.TYPE, Integer.TYPE, Object.class);
                            directByteBufferConstr = declaredConstructor3;
                            declaredConstructor3.setAccessible(true);
                        }
                    } catch (Exception unused6) {
                        jArrayBaseOffset = 0;
                        jArrayBaseOffset3 = 0;
                        jArrayBaseOffset4 = 0;
                        jArrayBaseOffset5 = 0;
                        jArrayBaseOffset6 = 0;
                        Log.a aVar6 = Log.a;
                        j = 0;
                        unsafe2 = unsafe;
                        j2 = jArrayBaseOffset;
                        j3 = jArrayBaseOffset2;
                        byteArrayBaseOffset = j3;
                        charArrayBaseOffset = jArrayBaseOffset3;
                        shortArrayBaseOffset = jArrayBaseOffset4;
                        intArrayBaseOffset = jArrayBaseOffset5;
                        floatArrayBaseOffset = jArrayBaseOffset6;
                        longArrayBaseOffset = j2;
                        doubleArrayBaseOffset = j;
                        _unsafe = unsafe2;
                        Constructor declaredConstructor4 = ByteBuffer.allocateDirect(1).getClass().getDeclaredConstructor(Long.TYPE, Integer.TYPE, Object.class);
                        directByteBufferConstr = declaredConstructor4;
                        declaredConstructor4.setAccessible(true);
                    }
                } catch (Exception unused7) {
                    jArrayBaseOffset = 0;
                    jArrayBaseOffset2 = 0;
                    jArrayBaseOffset3 = 0;
                    jArrayBaseOffset4 = 0;
                    jArrayBaseOffset5 = 0;
                    jArrayBaseOffset6 = 0;
                    Log.a aVar7 = Log.a;
                    j = 0;
                    unsafe2 = unsafe;
                    j2 = jArrayBaseOffset;
                    j3 = jArrayBaseOffset2;
                    byteArrayBaseOffset = j3;
                    charArrayBaseOffset = jArrayBaseOffset3;
                    shortArrayBaseOffset = jArrayBaseOffset4;
                    intArrayBaseOffset = jArrayBaseOffset5;
                    floatArrayBaseOffset = jArrayBaseOffset6;
                    longArrayBaseOffset = j2;
                    doubleArrayBaseOffset = j;
                    _unsafe = unsafe2;
                    Constructor declaredConstructor5 = ByteBuffer.allocateDirect(1).getClass().getDeclaredConstructor(Long.TYPE, Integer.TYPE, Object.class);
                    directByteBufferConstr = declaredConstructor5;
                    declaredConstructor5.setAccessible(true);
                }
            }
            jArrayBaseOffset6 = j4;
            j = jArrayBaseOffset7;
        } catch (Exception unused8) {
            jArrayBaseOffset = 0;
            unsafe = null;
        }
        byteArrayBaseOffset = j3;
        charArrayBaseOffset = jArrayBaseOffset3;
        shortArrayBaseOffset = jArrayBaseOffset4;
        intArrayBaseOffset = jArrayBaseOffset5;
        floatArrayBaseOffset = jArrayBaseOffset6;
        longArrayBaseOffset = j2;
        doubleArrayBaseOffset = j;
        _unsafe = unsafe2;
        try {
            Constructor declaredConstructor6 = ByteBuffer.allocateDirect(1).getClass().getDeclaredConstructor(Long.TYPE, Integer.TYPE, Object.class);
            directByteBufferConstr = declaredConstructor6;
            declaredConstructor6.setAccessible(true);
        } catch (Exception unused9) {
            directByteBufferConstr = null;
        }
    }

    public static final ByteBuffer getDirectBufferAt(long j, int i) {
        Constructor<? extends ByteBuffer> constructor = directByteBufferConstr;
        if (constructor == null) {
            return null;
        }
        try {
            return constructor.newInstance(Long.valueOf(j), Integer.valueOf(i), null);
        } catch (Exception e) {
            throw new RuntimeException(outline.t("Cannot allocate ByteBuffer at a given address: ", j), e);
        }
    }

    public static void releaseBuffer(ByteBuffer byteBuffer) {
        Cleaner cleaner;
        if (byteBuffer == null || !byteBuffer.isDirect() || (cleaner = ((DirectBuffer) byteBuffer).cleaner()) == null) {
            return;
        }
        cleaner.clean();
    }

    public static Field[] sortFieldsByOffset(List<Field> list) {
        Field[] fieldArr = (Field[]) list.toArray(new Field[0]);
        Arrays.sort(fieldArr, new Comparator<Field>() { // from class: com.esotericsoftware.kryo.util.UnsafeUtil.1
            @Override // java.util.Comparator
            public int compare(Field field, Field field2) {
                long jObjectFieldOffset = UnsafeUtil.unsafe().objectFieldOffset(field);
                long jObjectFieldOffset2 = UnsafeUtil.unsafe().objectFieldOffset(field2);
                if (jObjectFieldOffset < jObjectFieldOffset2) {
                    return -1;
                }
                return jObjectFieldOffset == jObjectFieldOffset2 ? 0 : 1;
            }
        });
        for (Field field : list) {
            Log.a aVar = Log.a;
        }
        return fieldArr;
    }

    public static final Unsafe unsafe() {
        return _unsafe;
    }
}
