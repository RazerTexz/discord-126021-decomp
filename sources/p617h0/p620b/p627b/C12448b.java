package p617h0.p620b.p627b;

import org.objenesis.ObjenesisException;

/* JADX INFO: renamed from: h0.b.b.b */
/* JADX INFO: compiled from: PlatformDescription.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12448b {

    /* JADX INFO: renamed from: a */
    public static final String f26402a;

    /* JADX INFO: renamed from: b */
    public static final int f26403b;

    /* JADX INFO: renamed from: c */
    public static final boolean f26404c;

    /* JADX INFO: renamed from: d */
    public static final String f26405d;

    static {
        String property;
        System.getProperty("java.specification.version");
        System.getProperty("java.runtime.version");
        System.getProperty("java.vm.info");
        System.getProperty("java.vm.version");
        System.getProperty("java.vm.vendor");
        f26402a = System.getProperty("java.vm.name");
        f26403b = m10656a();
        boolean z2 = false;
        if (m10656a() != 0 && (property = System.getProperty("java.boot.class.path")) != null && property.toLowerCase().contains("core-oj.jar")) {
            z2 = true;
        }
        f26404c = z2;
        f26405d = System.getProperty("com.google.appengine.runtime.version");
    }

    /* JADX INFO: renamed from: a */
    public static int m10656a() {
        if (!m10657b("Dalvik")) {
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

    /* JADX INFO: renamed from: b */
    public static boolean m10657b(String str) {
        return f26402a.startsWith(str);
    }
}
