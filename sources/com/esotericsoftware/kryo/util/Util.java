package com.esotericsoftware.kryo.util;

import b.e.a.a;
import b.e.a.a$a;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class Util {
    public static final boolean IS_ANDROID;
    private static final ConcurrentHashMap<String, Boolean> classAvailabilities;

    @Deprecated
    public static boolean isAndroid;

    static {
        boolean zEquals = "Dalvik".equals(System.getProperty("java.vm.name"));
        IS_ANDROID = zEquals;
        isAndroid = zEquals;
        classAvailabilities = new ConcurrentHashMap<>();
    }

    public static String className(Class cls) {
        if (!cls.isArray()) {
            return (cls.isPrimitive() || cls == Object.class || cls == Boolean.class || cls == Byte.class || cls == Character.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class) ? cls.getSimpleName() : cls.getName();
        }
        Class elementClass = getElementClass(cls);
        StringBuilder sb = new StringBuilder(16);
        int dimensionCount = getDimensionCount(cls);
        for (int i = 0; i < dimensionCount; i++) {
            sb.append("[]");
        }
        return className(elementClass) + ((Object) sb);
    }

    public static int getDimensionCount(Class cls) {
        int i = 0;
        for (Class<?> componentType = cls.getComponentType(); componentType != null; componentType = componentType.getComponentType()) {
            i++;
        }
        return i;
    }

    public static Class getElementClass(Class cls) {
        while (cls.getComponentType() != null) {
            cls = cls.getComponentType();
        }
        return cls;
    }

    public static Class getPrimitiveClass(Class cls) {
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Float.class) {
            return Float.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        if (cls == Long.class) {
            return Long.TYPE;
        }
        if (cls == Byte.class) {
            return Byte.TYPE;
        }
        if (cls == Character.class) {
            return Character.TYPE;
        }
        if (cls == Short.class) {
            return Short.TYPE;
        }
        if (cls == Double.class) {
            return Double.TYPE;
        }
        return cls == Void.class ? Void.TYPE : cls;
    }

    public static Class getWrapperClass(Class cls) {
        if (cls == Integer.TYPE) {
            return Integer.class;
        }
        if (cls == Float.TYPE) {
            return Float.class;
        }
        if (cls == Boolean.TYPE) {
            return Boolean.class;
        }
        if (cls == Long.TYPE) {
            return Long.class;
        }
        if (cls == Byte.TYPE) {
            return Byte.class;
        }
        if (cls == Character.TYPE) {
            return Character.class;
        }
        if (cls == Short.TYPE) {
            return Short.class;
        }
        return cls == Double.TYPE ? Double.class : Void.class;
    }

    public static boolean isClassAvailable(String str) {
        Boolean bool = classAvailabilities.get(str);
        if (bool == null) {
            try {
                Class.forName(str);
                bool = Boolean.TRUE;
            } catch (Exception unused) {
                a$a a_a = a.a;
                bool = Boolean.FALSE;
            }
            classAvailabilities.put(str, bool);
        }
        return bool.booleanValue();
    }

    public static boolean isWrapperClass(Class cls) {
        return cls == Integer.class || cls == Float.class || cls == Boolean.class || cls == Long.class || cls == Byte.class || cls == Character.class || cls == Short.class || cls == Double.class;
    }

    public static void log(String str, Object obj) {
        if (obj == null) {
            a$a a_a = a.a;
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls.isPrimitive() || cls == Boolean.class || cls == Byte.class || cls == Character.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class) {
            a$a a_a2 = a.a;
        } else {
            string(obj);
            a$a a_a3 = a.a;
        }
    }

    public static String string(Object obj) {
        if (obj == null) {
            return "null";
        }
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            return className(cls);
        }
        try {
            if (cls.getMethod("toString", new Class[0]).getDeclaringClass() == Object.class) {
                a$a a_a = a.a;
                return cls.getSimpleName();
            }
        } catch (Exception unused) {
        }
        try {
            return String.valueOf(obj);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            a$a a_a2 = a.a;
            sb.append(cls.getSimpleName());
            sb.append("(Exception ");
            sb.append(th);
            sb.append(" in toString)");
            return sb.toString();
        }
    }

    public static int swapInt(int i) {
        return ((i >> 24) & 255) | ((i & 255) << 24) | ((65280 & i) << 8) | ((16711680 & i) >> 8);
    }

    public static long swapLong(long j) {
        return (((j >> 56) & 255) << 0) | (((j >> 0) & 255) << 56) | (((j >> 8) & 255) << 48) | (((j >> 16) & 255) << 40) | (((j >> 24) & 255) << 32) | (((j >> 32) & 255) << 24) | (((j >> 40) & 255) << 16) | (((j >> 48) & 255) << 8);
    }
}
