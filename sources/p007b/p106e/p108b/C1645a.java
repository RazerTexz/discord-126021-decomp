package p007b.p106e.p108b;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: b.e.b.a */
/* JADX INFO: compiled from: AccessClassLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class C1645a extends ClassLoader {

    /* JADX INFO: renamed from: a */
    public static final WeakHashMap<ClassLoader, WeakReference<C1645a>> f3009a = new WeakHashMap<>();

    /* JADX INFO: renamed from: b */
    public static final ClassLoader f3010b;

    /* JADX INFO: renamed from: c */
    public static volatile C1645a f3011c;

    /* JADX INFO: renamed from: d */
    public static volatile Method f3012d;

    static {
        ClassLoader classLoader = C1645a.class.getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        f3010b = classLoader;
        f3011c = new C1645a(classLoader);
    }

    public C1645a(ClassLoader classLoader) {
        super(classLoader);
    }

    /* JADX INFO: renamed from: b */
    public static C1645a m889b(Class cls) {
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        ClassLoader classLoader2 = f3010b;
        if (classLoader2.equals(classLoader)) {
            if (f3011c == null) {
                synchronized (f3009a) {
                    if (f3011c == null) {
                        f3011c = new C1645a(classLoader2);
                    }
                }
            }
            return f3011c;
        }
        WeakHashMap<ClassLoader, WeakReference<C1645a>> weakHashMap = f3009a;
        synchronized (weakHashMap) {
            WeakReference<C1645a> weakReference = weakHashMap.get(classLoader);
            if (weakReference != null) {
                C1645a c1645a = weakReference.get();
                if (c1645a != null) {
                    return c1645a;
                }
                weakHashMap.remove(classLoader);
            }
            C1645a c1645a2 = new C1645a(classLoader);
            weakHashMap.put(classLoader, new WeakReference<>(c1645a2));
            return c1645a2;
        }
    }

    /* JADX INFO: renamed from: c */
    public static Method m890c() throws Exception {
        if (f3012d == null) {
            synchronized (f3009a) {
                Class cls = Integer.TYPE;
                f3012d = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, cls, cls, ProtectionDomain.class);
                try {
                    f3012d.setAccessible(true);
                } catch (Exception unused) {
                }
            }
        }
        return f3012d;
    }

    /* JADX INFO: renamed from: a */
    public Class<?> m891a(String str, byte[] bArr) throws ClassFormatError {
        try {
            return (Class) m890c().invoke(getParent(), str, bArr, 0, Integer.valueOf(bArr.length), getClass().getProtectionDomain());
        } catch (Exception unused) {
            return defineClass(str, bArr, 0, bArr.length, C1645a.class.getProtectionDomain());
        }
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z2) throws ClassNotFoundException {
        if (str.equals(AbstractC1647c.class.getName())) {
            return AbstractC1647c.class;
        }
        if (str.equals(AbstractC1648d.class.getName())) {
            return AbstractC1648d.class;
        }
        if (str.equals(AbstractC1646b.class.getName())) {
            return AbstractC1646b.class;
        }
        return str.equals(AbstractC1649e.class.getName()) ? AbstractC1649e.class : super.loadClass(str, z2);
    }
}
