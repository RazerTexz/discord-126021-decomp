package b.g.a.b.t;

import b.g.a.b.t.ThreadLocalBufferManager;
import java.lang.ref.SoftReference;

/* JADX INFO: renamed from: b.g.a.b.t.b, reason: use source file name */
/* JADX INFO: compiled from: BufferRecyclers.java */
/* JADX INFO: loaded from: classes3.dex */
public class BufferRecyclers {
    public static final ThreadLocalBufferManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<SoftReference<BufferRecycler>> f677b;

    static {
        boolean zEquals;
        try {
            zEquals = "true".equals(System.getProperty("com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers"));
        } catch (SecurityException unused) {
            zEquals = false;
        }
        a = zEquals ? ThreadLocalBufferManager.a.a : null;
        f677b = new ThreadLocal<>();
    }
}
