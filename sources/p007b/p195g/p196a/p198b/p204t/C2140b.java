package p007b.p195g.p196a.p198b.p204t;

import java.lang.ref.SoftReference;
import p007b.p195g.p196a.p198b.p204t.C2150l;

/* JADX INFO: renamed from: b.g.a.b.t.b */
/* JADX INFO: compiled from: BufferRecyclers.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2140b {

    /* JADX INFO: renamed from: a */
    public static final C2150l f4595a;

    /* JADX INFO: renamed from: b */
    public static final ThreadLocal<SoftReference<C2139a>> f4596b;

    static {
        boolean zEquals;
        try {
            zEquals = "true".equals(System.getProperty("com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers"));
        } catch (SecurityException unused) {
            zEquals = false;
        }
        f4595a = zEquals ? C2150l.a.f4616a : null;
        f4596b = new ThreadLocal<>();
    }
}
