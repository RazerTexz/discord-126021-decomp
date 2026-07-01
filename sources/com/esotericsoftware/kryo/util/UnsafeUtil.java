package com.esotericsoftware.kryo.util;

import b.e.a.a;
import b.e.a.a$a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.Arrays;
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
                a$a a_a = a.a;
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
                                            a$a a_a2 = a.a;
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
                                    a$a a_a3 = a.a;
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
                                a$a a_a4 = a.a;
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
                            a$a a_a5 = a.a;
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
                        a$a a_a6 = a.a;
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
                    a$a a_a7 = a.a;
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
            throw new RuntimeException(b.d.b.a.a.t("Cannot allocate ByteBuffer at a given address: ", j), e);
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
        Arrays.sort(fieldArr, new UnsafeUtil$1());
        for (Field field : list) {
            a$a a_a = a.a;
        }
        return fieldArr;
    }

    public static final Unsafe unsafe() {
        return _unsafe;
    }
}
