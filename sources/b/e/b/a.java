package b.e.b;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: AccessClassLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends ClassLoader {
    public static final WeakHashMap<ClassLoader, WeakReference<a>> a = new WeakHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ClassLoader f454b;
    public static volatile a c;
    public static volatile Method d;

    static {
        ClassLoader classLoader = a.class.getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        f454b = classLoader;
        c = new a(classLoader);
    }

    public a(ClassLoader classLoader) {
        super(classLoader);
    }

    public static a b(Class cls) {
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        ClassLoader classLoader2 = f454b;
        if (classLoader2.equals(classLoader)) {
            if (c == null) {
                synchronized (a) {
                    if (c == null) {
                        c = new a(classLoader2);
                    }
                }
            }
            return c;
        }
        WeakHashMap<ClassLoader, WeakReference<a>> weakHashMap = a;
        synchronized (weakHashMap) {
            WeakReference<a> weakReference = weakHashMap.get(classLoader);
            if (weakReference != null) {
                a aVar = weakReference.get();
                if (aVar != null) {
                    return aVar;
                }
                weakHashMap.remove(classLoader);
            }
            a aVar2 = new a(classLoader);
            weakHashMap.put(classLoader, new WeakReference<>(aVar2));
            return aVar2;
        }
    }

    public static Method c() throws Exception {
        if (d == null) {
            synchronized (a) {
                Class cls = Integer.TYPE;
                d = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, cls, cls, ProtectionDomain.class);
                try {
                    d.setAccessible(true);
                } catch (Exception unused) {
                }
            }
        }
        return d;
    }

    public Class<?> a(String str, byte[] bArr) throws ClassFormatError {
        try {
            return (Class) c().invoke(getParent(), str, bArr, 0, Integer.valueOf(bArr.length), getClass().getProtectionDomain());
        } catch (Exception unused) {
            return defineClass(str, bArr, 0, bArr.length, a.class.getProtectionDomain());
        }
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z2) throws ClassNotFoundException {
        if (str.equals(c.class.getName())) {
            return c.class;
        }
        if (str.equals(d.class.getName())) {
            return d.class;
        }
        if (str.equals(b.class.getName())) {
            return b.class;
        }
        return str.equals(e.class.getName()) ? e.class : super.loadClass(str, z2);
    }
}
