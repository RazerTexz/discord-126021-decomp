package p007b.p195g.p196a.p205c.p219i0;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.Closeable;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.p220y.C2382h;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2375a;

/* JADX INFO: renamed from: b.g.a.c.i0.d */
/* JADX INFO: compiled from: ClassUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2342d {

    /* JADX INFO: renamed from: a */
    public static final Annotation[] f4944a = new Annotation[0];

    /* JADX INFO: renamed from: b */
    public static final a[] f4945b = new a[0];

    /* JADX INFO: renamed from: c */
    public static final Iterator<?> f4946c = Collections.emptyIterator();

    /* JADX INFO: renamed from: b.g.a.c.i0.d$a */
    /* JADX INFO: compiled from: ClassUtil.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final Constructor<?> f4947a;

        /* JADX INFO: renamed from: b */
        public transient Annotation[] f4948b;

        /* JADX INFO: renamed from: c */
        public transient Annotation[][] f4949c;

        /* JADX INFO: renamed from: d */
        public int f4950d = -1;

        public a(Constructor<?> constructor) {
            this.f4947a = constructor;
        }

        /* JADX INFO: renamed from: a */
        public int m2195a() {
            int i = this.f4950d;
            if (i >= 0) {
                return i;
            }
            int length = this.f4947a.getParameterTypes().length;
            this.f4950d = length;
            return length;
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.i0.d$b */
    /* JADX INFO: compiled from: ClassUtil.java */
    public static class b {

        /* JADX INFO: renamed from: a */
        public static final b f4951a = new b();

        /* JADX INFO: renamed from: b */
        public final Field f4952b = m2196a(EnumSet.class, "elementType", Class.class);

        /* JADX INFO: renamed from: c */
        public final Field f4953c = m2196a(EnumMap.class, "elementType", Class.class);

        /* JADX INFO: renamed from: a */
        public static Field m2196a(Class<?> cls, String str, Class<?> cls2) {
            Field field;
            Field[] declaredFields = cls.getDeclaredFields();
            int length = declaredFields.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    field = null;
                    break;
                }
                field = declaredFields[i];
                if (str.equals(field.getName()) && field.getType() == cls2) {
                    break;
                }
                i++;
            }
            if (field == null) {
                for (Field field2 : declaredFields) {
                    if (field2.getType() == cls2) {
                        if (field != null) {
                            return null;
                        }
                        field = field2;
                    }
                }
            }
            if (field != null) {
                try {
                    field.setAccessible(true);
                } catch (Throwable unused) {
                }
            }
            return field;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2169a(Class<?> cls, Class<?> cls2, Collection<Class<?>> collection, boolean z2) {
        if (cls == cls2 || cls == null || cls == Object.class) {
            return;
        }
        if (z2) {
            if (collection.contains(cls)) {
                return;
            } else {
                collection.add(cls);
            }
        }
        for (Class<?> cls3 : cls.getInterfaces()) {
            m2169a(cls3, cls2, collection, true);
        }
        m2169a(cls.getSuperclass(), cls2, collection, true);
    }

    /* JADX INFO: renamed from: b */
    public static Method[] m2170b(Class<?> cls, Throwable th) throws IllegalArgumentException {
        throw new IllegalArgumentException(String.format("Failed on call to `getDeclaredMethods()` on class `%s`, problem: (%s) %s", cls.getName(), th.getClass().getName(), th.getMessage()), th);
    }

    /* JADX INFO: renamed from: c */
    public static String m2171c(String str) {
        if (str == null) {
            return "[null]";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append('\'');
        sb.append(str);
        sb.append('\'');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: d */
    public static void m2172d(Member member, boolean z2) {
        AccessibleObject accessibleObject = (AccessibleObject) member;
        if (!z2) {
            try {
                if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                    return;
                }
            } catch (SecurityException e) {
                if (accessibleObject.isAccessible()) {
                    return;
                }
                throw new IllegalArgumentException("Cannot access " + member + " (from class " + member.getDeclaringClass().getName() + "; failed to set access: " + e.getMessage());
            }
        }
        accessibleObject.setAccessible(true);
    }

    /* JADX INFO: renamed from: e */
    public static String m2173e(Object obj) {
        if (obj == null) {
            return "[null]";
        }
        return m2189u(obj instanceof Class ? (Class) obj : obj.getClass());
    }

    /* JADX INFO: renamed from: f */
    public static void m2174f(AbstractC2108d abstractC2108d, Closeable closeable, Exception exc) throws IOException {
        if (abstractC2108d != null) {
            abstractC2108d.mo1648b(AbstractC2108d.a.AUTO_CLOSE_JSON_CONTENT);
            try {
                abstractC2108d.close();
            } catch (Exception e) {
                exc.addSuppressed(e);
            }
        }
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e2) {
                exc.addSuppressed(e2);
            }
        }
        if (exc instanceof IOException) {
            throw ((IOException) exc);
        }
        m2192x(exc);
        throw new RuntimeException(exc);
    }

    /* JADX INFO: renamed from: g */
    public static <T> T m2175g(Class<T> cls, boolean z2) throws IllegalArgumentException {
        Constructor<T> declaredConstructor;
        try {
            declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (z2) {
                m2172d(declaredConstructor, z2);
            } else if (!Modifier.isPublic(declaredConstructor.getModifiers())) {
                throw new IllegalArgumentException("Default constructor for " + cls.getName() + " is not accessible (non-public?): not allowed to try modify access via Reflection: cannot instantiate type");
            }
        } catch (NoSuchMethodException unused) {
            declaredConstructor = null;
        } catch (Exception e) {
            StringBuilder sbM833U = C1643a.m833U("Failed to find default constructor of class ");
            sbM833U.append(cls.getName());
            sbM833U.append(", problem: ");
            sbM833U.append(e.getMessage());
            m2193y(e, sbM833U.toString());
            throw null;
        }
        if (declaredConstructor == null) {
            throw new IllegalArgumentException(C1643a.m867o(cls, C1643a.m833U("Class "), " has no default (no arg) constructor"));
        }
        try {
            return declaredConstructor.newInstance(new Object[0]);
        } catch (Exception e2) {
            StringBuilder sbM833U2 = C1643a.m833U("Failed to instantiate class ");
            sbM833U2.append(cls.getName());
            sbM833U2.append(", problem: ");
            sbM833U2.append(e2.getMessage());
            m2193y(e2, sbM833U2.toString());
            throw null;
        }
    }

    /* JADX INFO: renamed from: h */
    public static String m2176h(Throwable th) {
        return th instanceof JsonProcessingException ? ((JsonProcessingException) th).m8740b() : th.getMessage();
    }

    /* JADX INFO: renamed from: i */
    public static Annotation[] m2177i(Class<?> cls) {
        return m2188t(cls) ? f4944a : cls.getDeclaredAnnotations();
    }

    /* JADX INFO: renamed from: j */
    public static List<Class<?>> m2178j(Class<?> cls, Class<?> cls2, boolean z2) {
        ArrayList arrayList = new ArrayList(8);
        if (cls != null && cls != cls2) {
            if (z2) {
                arrayList.add(cls);
            }
            while (true) {
                cls = cls.getSuperclass();
                if (cls == null || cls == cls2) {
                    break;
                }
                arrayList.add(cls);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: k */
    public static Method[] m2179k(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader == null) {
                m2170b(cls, e);
                throw null;
            }
            try {
                try {
                    return contextClassLoader.loadClass(cls.getName()).getDeclaredMethods();
                } catch (Throwable th) {
                    m2170b(cls, th);
                    throw null;
                }
            } catch (ClassNotFoundException e2) {
                e.addSuppressed(e2);
                m2170b(cls, e);
                throw null;
            }
        } catch (Throwable th2) {
            m2170b(cls, th2);
            throw null;
        }
    }

    /* JADX INFO: renamed from: l */
    public static a[] m2180l(Class<?> cls) {
        if (cls.isInterface() || m2188t(cls)) {
            return f4945b;
        }
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        int length = declaredConstructors.length;
        a[] aVarArr = new a[length];
        for (int i = 0; i < length; i++) {
            aVarArr[i] = new a(declaredConstructors[i]);
        }
        return aVarArr;
    }

    /* JADX INFO: renamed from: m */
    public static Class<?> m2181m(Class<?> cls) {
        if (Modifier.isStatic(cls.getModifiers())) {
            return null;
        }
        try {
            if (!((m2188t(cls) || cls.getEnclosingMethod() == null) ? false : true) && !m2188t(cls)) {
                return cls.getEnclosingClass();
            }
            return null;
        } catch (SecurityException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: n */
    public static String m2182n(AbstractC2360j abstractC2360j) {
        if (abstractC2360j == null) {
            return "[null]";
        }
        StringBuilder sb = new StringBuilder(80);
        sb.append('`');
        sb.append(abstractC2360j.mo1729e());
        sb.append('`');
        return sb.toString();
    }

    /* JADX INFO: renamed from: o */
    public static boolean m2183o(Object obj, Class<?> cls) {
        return obj != null && obj.getClass() == cls;
    }

    /* JADX INFO: renamed from: p */
    public static boolean m2184p(Class<?> cls) {
        return cls == Void.class || cls == Void.TYPE || cls == C2382h.class;
    }

    /* JADX INFO: renamed from: q */
    public static boolean m2185q(Class<?> cls) {
        return Enum.class.isAssignableFrom(cls);
    }

    /* JADX INFO: renamed from: r */
    public static boolean m2186r(Class<?> cls) {
        String name = cls.getName();
        return name.startsWith("java.") || name.startsWith("javax.");
    }

    /* JADX INFO: renamed from: s */
    public static boolean m2187s(Object obj) {
        if (obj != null) {
            return obj.getClass().getAnnotation(InterfaceC2375a.class) != null;
        }
        return true;
    }

    /* JADX INFO: renamed from: t */
    public static boolean m2188t(Class<?> cls) {
        return cls == Object.class || cls.isPrimitive();
    }

    /* JADX INFO: renamed from: u */
    public static String m2189u(Class<?> cls) {
        if (cls == null) {
            return "[null]";
        }
        int i = 0;
        while (cls.isArray()) {
            i++;
            cls = cls.getComponentType();
        }
        String simpleName = cls.isPrimitive() ? cls.getSimpleName() : cls.getName();
        if (i > 0) {
            StringBuilder sb = new StringBuilder(simpleName);
            do {
                sb.append("[]");
                i--;
            } while (i > 0);
            simpleName = sb.toString();
        }
        if (simpleName == null) {
            return "[null]";
        }
        StringBuilder sb2 = new StringBuilder(simpleName.length() + 2);
        sb2.append('`');
        sb2.append(simpleName);
        sb2.append('`');
        return sb2.toString();
    }

    /* JADX INFO: renamed from: v */
    public static Class<?> m2190v(Class<?> cls) {
        if (cls.isPrimitive()) {
            return cls;
        }
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Long.class) {
            return Long.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        if (cls == Double.class) {
            return Double.TYPE;
        }
        if (cls == Float.class) {
            return Float.TYPE;
        }
        if (cls == Byte.class) {
            return Byte.TYPE;
        }
        if (cls == Short.class) {
            return Short.TYPE;
        }
        if (cls == Character.class) {
            return Character.TYPE;
        }
        return null;
    }

    /* JADX INFO: renamed from: w */
    public static Throwable m2191w(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        }
        return th;
    }

    /* JADX INFO: renamed from: x */
    public static Throwable m2192x(Throwable th) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        return th;
    }

    /* JADX INFO: renamed from: y */
    public static void m2193y(Throwable th, String str) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        m2192x(th);
        m2191w(th);
        throw new IllegalArgumentException(str, th);
    }

    /* JADX INFO: renamed from: z */
    public static void m2194z(Class<?> cls, Object obj, String str) {
        if (obj.getClass() != cls) {
            throw new IllegalStateException(String.format("Sub-class %s (of class %s) must override method '%s'", obj.getClass().getName(), cls.getName(), str));
        }
    }
}
