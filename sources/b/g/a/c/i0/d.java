package b.g.a.c.i0;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.Closeable;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ClassUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final Annotation[] a = new Annotation[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d$a[] f726b = new d$a[0];
    public static final Iterator<?> c = Collections.emptyIterator();

    public static void a(Class<?> cls, Class<?> cls2, Collection<Class<?>> collection, boolean z2) {
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
            a(cls3, cls2, collection, true);
        }
        a(cls.getSuperclass(), cls2, collection, true);
    }

    public static Method[] b(Class<?> cls, Throwable th) throws IllegalArgumentException {
        throw new IllegalArgumentException(String.format("Failed on call to `getDeclaredMethods()` on class `%s`, problem: (%s) %s", cls.getName(), th.getClass().getName(), th.getMessage()), th);
    }

    public static String c(String str) {
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
    public static void d(Member member, boolean z2) {
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

    public static String e(Object obj) {
        if (obj == null) {
            return "[null]";
        }
        return u(obj instanceof Class ? (Class) obj : obj.getClass());
    }

    public static void f(b.g.a.b.d dVar, Closeable closeable, Exception exc) throws IOException {
        if (dVar != null) {
            dVar.b(b.g.a.b.d$a.AUTO_CLOSE_JSON_CONTENT);
            try {
                dVar.close();
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
        x(exc);
        throw new RuntimeException(exc);
    }

    public static <T> T g(Class<T> cls, boolean z2) throws IllegalArgumentException {
        Constructor<T> declaredConstructor;
        try {
            declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (z2) {
                d(declaredConstructor, z2);
            } else if (!Modifier.isPublic(declaredConstructor.getModifiers())) {
                throw new IllegalArgumentException("Default constructor for " + cls.getName() + " is not accessible (non-public?): not allowed to try modify access via Reflection: cannot instantiate type");
            }
        } catch (NoSuchMethodException unused) {
            declaredConstructor = null;
        } catch (Exception e) {
            StringBuilder sbU = b.d.b.a.a.U("Failed to find default constructor of class ");
            sbU.append(cls.getName());
            sbU.append(", problem: ");
            sbU.append(e.getMessage());
            y(e, sbU.toString());
            throw null;
        }
        if (declaredConstructor == null) {
            throw new IllegalArgumentException(b.d.b.a.a.o(cls, b.d.b.a.a.U("Class "), " has no default (no arg) constructor"));
        }
        try {
            return declaredConstructor.newInstance(new Object[0]);
        } catch (Exception e2) {
            StringBuilder sbU2 = b.d.b.a.a.U("Failed to instantiate class ");
            sbU2.append(cls.getName());
            sbU2.append(", problem: ");
            sbU2.append(e2.getMessage());
            y(e2, sbU2.toString());
            throw null;
        }
    }

    public static String h(Throwable th) {
        return th instanceof JsonProcessingException ? ((JsonProcessingException) th).b() : th.getMessage();
    }

    public static Annotation[] i(Class<?> cls) {
        return t(cls) ? a : cls.getDeclaredAnnotations();
    }

    public static List<Class<?>> j(Class<?> cls, Class<?> cls2, boolean z2) {
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

    public static Method[] k(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader == null) {
                b(cls, e);
                throw null;
            }
            try {
                try {
                    return contextClassLoader.loadClass(cls.getName()).getDeclaredMethods();
                } catch (Throwable th) {
                    b(cls, th);
                    throw null;
                }
            } catch (ClassNotFoundException e2) {
                e.addSuppressed(e2);
                b(cls, e);
                throw null;
            }
        } catch (Throwable th2) {
            b(cls, th2);
            throw null;
        }
    }

    public static d$a[] l(Class<?> cls) {
        if (cls.isInterface() || t(cls)) {
            return f726b;
        }
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        int length = declaredConstructors.length;
        d$a[] d_aArr = new d$a[length];
        for (int i = 0; i < length; i++) {
            d_aArr[i] = new d$a(declaredConstructors[i]);
        }
        return d_aArr;
    }

    public static Class<?> m(Class<?> cls) {
        if (Modifier.isStatic(cls.getModifiers())) {
            return null;
        }
        try {
            if (!((t(cls) || cls.getEnclosingMethod() == null) ? false : true) && !t(cls)) {
                return cls.getEnclosingClass();
            }
            return null;
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static String n(b.g.a.c.j jVar) {
        if (jVar == null) {
            return "[null]";
        }
        StringBuilder sb = new StringBuilder(80);
        sb.append('`');
        sb.append(jVar.e());
        sb.append('`');
        return sb.toString();
    }

    public static boolean o(Object obj, Class<?> cls) {
        return obj != null && obj.getClass() == cls;
    }

    public static boolean p(Class<?> cls) {
        return cls == Void.class || cls == Void.TYPE || cls == b.g.a.c.y.h.class;
    }

    public static boolean q(Class<?> cls) {
        return Enum.class.isAssignableFrom(cls);
    }

    public static boolean r(Class<?> cls) {
        String name = cls.getName();
        return name.startsWith("java.") || name.startsWith("javax.");
    }

    public static boolean s(Object obj) {
        if (obj != null) {
            return obj.getClass().getAnnotation(b.g.a.c.y.a.class) != null;
        }
        return true;
    }

    public static boolean t(Class<?> cls) {
        return cls == Object.class || cls.isPrimitive();
    }

    public static String u(Class<?> cls) {
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

    public static Class<?> v(Class<?> cls) {
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

    public static Throwable w(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        }
        return th;
    }

    public static Throwable x(Throwable th) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        return th;
    }

    public static void y(Throwable th, String str) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        x(th);
        w(th);
        throw new IllegalArgumentException(str, th);
    }

    public static void z(Class<?> cls, Object obj, String str) {
        if (obj.getClass() != cls) {
            throw new IllegalStateException(String.format("Sub-class %s (of class %s) must override method '%s'", obj.getClass().getName(), cls.getName(), str));
        }
    }
}
