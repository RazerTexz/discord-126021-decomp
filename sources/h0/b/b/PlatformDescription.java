package h0.b.b;

import org.objenesis.ObjenesisException;

/* JADX INFO: renamed from: h0.b.b.b, reason: use source file name */
/* JADX INFO: compiled from: PlatformDescription.java */
/* JADX INFO: loaded from: classes3.dex */
public final class PlatformDescription {
    public static final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f3734b;
    public static final boolean c;
    public static final String d;

    static {
        String property;
        System.getProperty("java.specification.version");
        System.getProperty("java.runtime.version");
        System.getProperty("java.vm.info");
        System.getProperty("java.vm.version");
        System.getProperty("java.vm.vendor");
        a = System.getProperty("java.vm.name");
        f3734b = a();
        boolean z2 = false;
        if (a() != 0 && (property = System.getProperty("java.boot.class.path")) != null && property.toLowerCase().contains("core-oj.jar")) {
            z2 = true;
        }
        c = z2;
        d = System.getProperty("com.google.appengine.runtime.version");
    }

    public static int a() {
        if (!b("Dalvik")) {
            return 0;
        }
        try {
            Class<?> cls = Class.forName("android.os.Build$VERSION");
            try {
                try {
                    try {
                        return ((Integer) cls.getField("SDK_INT").get(null)).intValue();
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                } catch (NoSuchFieldException unused) {
                    try {
                        return Integer.parseInt((String) cls.getField("SDK").get(null));
                    } catch (IllegalAccessException e2) {
                        throw new RuntimeException(e2);
                    }
                }
            } catch (NoSuchFieldException e3) {
                throw new ObjenesisException(e3);
            }
        } catch (ClassNotFoundException e4) {
            throw new ObjenesisException(e4);
        }
    }

    public static boolean b(String str) {
        return a.startsWith(str);
    }
}
