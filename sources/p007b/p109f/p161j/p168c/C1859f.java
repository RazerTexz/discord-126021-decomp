package p007b.p109f.p161j.p168c;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p110a.C1650a;
import p007b.p109f.p111b.p112a.C1655e;
import p007b.p109f.p111b.p112a.C1656f;
import p007b.p109f.p111b.p113b.C1661d;
import p007b.p109f.p111b.p113b.C1666i;
import p007b.p109f.p111b.p113b.InterfaceC1665h;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p115d.p122g.C1703j;
import p007b.p109f.p115d.p122g.InterfaceC1700g;
import p007b.p109f.p161j.p175j.C1919e;
import p007b.p109f.p161j.p183r.C2030b;
import p686z.C13202g;

/* JADX INFO: renamed from: b.f.j.c.f */
/* JADX INFO: compiled from: BufferedDiskCache.java */
/* JADX INFO: loaded from: classes.dex */
public class C1859f {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1665h f3661a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1700g f3662b;

    /* JADX INFO: renamed from: c */
    public final C1703j f3663c;

    /* JADX INFO: renamed from: d */
    public final Executor f3664d;

    /* JADX INFO: renamed from: e */
    public final Executor f3665e;

    /* JADX INFO: renamed from: f */
    public final C1853a0 f3666f = new C1853a0();

    /* JADX INFO: renamed from: g */
    public final InterfaceC1871r f3667g;

    /* JADX INFO: renamed from: b.f.j.c.f$a */
    /* JADX INFO: compiled from: BufferedDiskCache.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ CacheKey f3668j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ C1919e f3669k;

        public a(Object obj, CacheKey cacheKey, C1919e c1919e) {
            this.f3668j = cacheKey;
            this.f3669k = c1919e;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C1859f.m1216b(C1859f.this, this.f3668j, this.f3669k);
                C1859f.this.f3666f.m1211d(this.f3668j, this.f3669k);
                C1919e c1919e = this.f3669k;
                if (c1919e != null) {
                    c1919e.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    C1859f.this.f3666f.m1211d(this.f3668j, this.f3669k);
                    C1919e c1919e2 = this.f3669k;
                    if (c1919e2 != null) {
                        c1919e2.close();
                    }
                    throw th2;
                }
            }
        }
    }

    public C1859f(InterfaceC1665h interfaceC1665h, InterfaceC1700g interfaceC1700g, C1703j c1703j, Executor executor, Executor executor2, InterfaceC1871r interfaceC1871r) {
        this.f3661a = interfaceC1665h;
        this.f3662b = interfaceC1700g;
        this.f3663c = c1703j;
        this.f3664d = executor;
        this.f3665e = executor2;
        this.f3667g = interfaceC1871r;
    }

    /* JADX INFO: renamed from: a */
    public static PooledByteBuffer m1215a(C1859f c1859f, CacheKey cacheKey) throws IOException {
        Objects.requireNonNull(c1859f);
        try {
            cacheKey.mo930b();
            int i = C1691a.f3102a;
            C1650a c1650aM950b = ((C1661d) c1859f.f3661a).m950b(cacheKey);
            if (c1650aM950b == null) {
                cacheKey.mo930b();
                Objects.requireNonNull((C1879z) c1859f.f3667g);
                return null;
            }
            cacheKey.mo930b();
            Objects.requireNonNull((C1879z) c1859f.f3667g);
            FileInputStream fileInputStream = new FileInputStream(c1650aM950b.f3016a);
            try {
                PooledByteBuffer pooledByteBufferMo996d = c1859f.f3662b.mo996d(fileInputStream, (int) c1650aM950b.m928a());
                fileInputStream.close();
                cacheKey.mo930b();
                return pooledByteBufferMo996d;
            } catch (Throwable th) {
                fileInputStream.close();
                throw th;
            }
        } catch (IOException e) {
            C1691a.m986n(C1859f.class, e, "Exception reading from cache for %s", cacheKey.mo930b());
            Objects.requireNonNull((C1879z) c1859f.f3667g);
            throw e;
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m1216b(C1859f c1859f, CacheKey cacheKey, C1919e c1919e) {
        Objects.requireNonNull(c1859f);
        cacheKey.mo930b();
        int i = C1691a.f3102a;
        try {
            ((C1661d) c1859f.f3661a).m952d(cacheKey, new C1861h(c1859f, c1919e));
            Objects.requireNonNull((C1879z) c1859f.f3667g);
            cacheKey.mo930b();
        } catch (IOException e) {
            C1691a.m986n(C1859f.class, e, "Failed to write to disk-cache for key %s", cacheKey.mo930b());
        }
    }

    /* JADX INFO: renamed from: c */
    public void m1217c(CacheKey cacheKey) {
        C1661d c1661d = (C1661d) this.f3661a;
        Objects.requireNonNull(c1661d);
        try {
            synchronized (c1661d.f3057q) {
                List<String> listM596z0 = C1460d.m596z0(cacheKey);
                int i = 0;
                while (true) {
                    ArrayList arrayList = (ArrayList) listM596z0;
                    if (i >= arrayList.size()) {
                        return;
                    }
                    String str = (String) arrayList.get(i);
                    if (c1661d.f3051k.mo934c(str, cacheKey)) {
                        c1661d.f3048h.add(str);
                        return;
                    }
                    i++;
                }
            }
        } catch (IOException unused) {
            C1666i c1666iM961a = C1666i.m961a();
            c1666iM961a.f3075d = cacheKey;
            Objects.requireNonNull((C1655e) c1661d.f3047g);
            c1666iM961a.m962b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: d */
    public final C13202g<C1919e> m1218d(CacheKey cacheKey, C1919e c1919e) {
        cacheKey.mo930b();
        int i = C1691a.f3102a;
        Objects.requireNonNull((C1879z) this.f3667g);
        ExecutorService executorService = C13202g.f27977a;
        if (c1919e instanceof Boolean) {
            return ((Boolean) c1919e).booleanValue() ? C13202g.f27981e : C13202g.f27982f;
        }
        C13202g<C1919e> c13202g = new C13202g<>();
        if (c13202g.m11373h(c1919e)) {
            return c13202g;
        }
        throw new IllegalStateException("Cannot set the result of a completed task.");
    }

    /* JADX INFO: renamed from: e */
    public C13202g<C1919e> m1219e(CacheKey cacheKey, AtomicBoolean atomicBoolean) {
        C13202g<C1919e> c13202gM11367c;
        try {
            C2030b.m1527b();
            C1919e c1919eM1208a = this.f3666f.m1208a(cacheKey);
            if (c1919eM1208a != null) {
                C13202g<C1919e> c13202gM1218d = m1218d(cacheKey, c1919eM1208a);
                C2030b.m1527b();
                return c13202gM1218d;
            }
            try {
                c13202gM11367c = C13202g.m11366a(new CallableC1858e(this, null, atomicBoolean, cacheKey), this.f3664d);
            } catch (Exception e) {
                C1691a.m986n(C1859f.class, e, "Failed to schedule disk-cache read for %s", ((C1656f) cacheKey).f3019a);
                c13202gM11367c = C13202g.m11367c(e);
            }
            C2030b.m1527b();
            return c13202gM11367c;
        } catch (Throwable th) {
            C2030b.m1527b();
            throw th;
        }
    }

    /* JADX INFO: renamed from: f */
    public void m1220f(CacheKey cacheKey, C1919e c1919e) {
        try {
            C2030b.m1527b();
            Objects.requireNonNull(cacheKey);
            C1460d.m527i(Boolean.valueOf(C1919e.m1338u(c1919e)));
            this.f3666f.m1209b(cacheKey, c1919e);
            C1919e c1919eM1336a = C1919e.m1336a(c1919e);
            try {
                this.f3665e.execute(new a(null, cacheKey, c1919eM1336a));
            } catch (Exception e) {
                C1691a.m986n(C1859f.class, e, "Failed to schedule disk-cache write for %s", cacheKey.mo930b());
                this.f3666f.m1211d(cacheKey, c1919e);
                if (c1919eM1336a != null) {
                    c1919eM1336a.close();
                }
            }
            C2030b.m1527b();
        } catch (Throwable th) {
            C2030b.m1527b();
            throw th;
        }
    }
}
