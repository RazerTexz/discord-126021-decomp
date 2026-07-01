package b.g.a.b.t;

import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: BufferRecyclers.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static final l a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<SoftReference<a>> f677b;

    static {
        boolean zEquals;
        try {
            zEquals = "true".equals(System.getProperty("com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers"));
        } catch (SecurityException unused) {
            zEquals = false;
        }
        a = zEquals ? l$a.a : null;
        f677b = new ThreadLocal<>();
    }
}
