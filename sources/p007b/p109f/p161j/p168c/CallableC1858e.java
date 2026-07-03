package p007b.p109f.p161j.p168c;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p161j.p175j.C1919e;

/* JADX INFO: renamed from: b.f.j.c.e */
/* JADX INFO: compiled from: BufferedDiskCache.java */
/* JADX INFO: loaded from: classes.dex */
public class CallableC1858e implements Callable<C1919e> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AtomicBoolean f3658j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ CacheKey f3659k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C1859f f3660l;

    public CallableC1858e(C1859f c1859f, Object obj, AtomicBoolean atomicBoolean, CacheKey cacheKey) {
        this.f3660l = c1859f;
        this.f3658j = atomicBoolean;
        this.f3659k = cacheKey;
    }

    @Override // java.util.concurrent.Callable
    public C1919e call() throws Exception {
        try {
            if (this.f3658j.get()) {
                throw new CancellationException();
            }
            C1919e c1919eM1208a = this.f3660l.f3666f.m1208a(this.f3659k);
            if (c1919eM1208a == null) {
                this.f3659k.mo930b();
                int i = C1691a.f3102a;
                Objects.requireNonNull((C1879z) this.f3660l.f3667g);
                c1919eM1208a = null;
                try {
                    PooledByteBuffer pooledByteBufferM1215a = C1859f.m1215a(this.f3660l, this.f3659k);
                    if (pooledByteBufferM1215a != null) {
                        CloseableReference closeableReferenceM8632A = CloseableReference.m8632A(pooledByteBufferM1215a);
                        try {
                            C1919e c1919e = new C1919e(closeableReferenceM8632A);
                            if (closeableReferenceM8632A != null) {
                                closeableReferenceM8632A.close();
                            }
                            c1919eM1208a = c1919e;
                        } catch (Throwable th) {
                            if (closeableReferenceM8632A != null) {
                                closeableReferenceM8632A.close();
                            }
                            throw th;
                        }
                    }
                } catch (Exception unused) {
                }
                return c1919eM1208a;
            }
            this.f3659k.mo930b();
            int i2 = C1691a.f3102a;
            Objects.requireNonNull((C1879z) this.f3660l.f3667g);
            if (!Thread.interrupted()) {
                return c1919eM1208a;
            }
            C1691a.m981i(C1859f.class, "Host thread was interrupted, decreasing reference count");
            c1919eM1208a.close();
            throw new InterruptedException();
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
