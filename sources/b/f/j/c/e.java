package b.f.j.c;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: BufferedDiskCache.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements Callable<b.f.j.j.e> {
    public final /* synthetic */ AtomicBoolean j;
    public final /* synthetic */ CacheKey k;
    public final /* synthetic */ f l;

    public e(f fVar, Object obj, AtomicBoolean atomicBoolean, CacheKey cacheKey) {
        this.l = fVar;
        this.j = atomicBoolean;
        this.k = cacheKey;
    }

    @Override // java.util.concurrent.Callable
    public b.f.j.j.e call() throws Exception {
        try {
            if (this.j.get()) {
                throw new CancellationException();
            }
            b.f.j.j.e eVarA = this.l.f.a(this.k);
            if (eVarA == null) {
                this.k.b();
                int i = b.f.d.e.a.a;
                Objects.requireNonNull((z) this.l.g);
                eVarA = null;
                try {
                    PooledByteBuffer pooledByteBufferA = f.a(this.l, this.k);
                    if (pooledByteBufferA != null) {
                        CloseableReference closeableReferenceA = CloseableReference.A(pooledByteBufferA);
                        try {
                            b.f.j.j.e eVar = new b.f.j.j.e(closeableReferenceA);
                            if (closeableReferenceA != null) {
                                closeableReferenceA.close();
                            }
                            eVarA = eVar;
                        } catch (Throwable th) {
                            if (closeableReferenceA != null) {
                                closeableReferenceA.close();
                            }
                            throw th;
                        }
                    }
                } catch (Exception unused) {
                }
                return eVarA;
            }
            this.k.b();
            int i2 = b.f.d.e.a.a;
            Objects.requireNonNull((z) this.l.g);
            if (!Thread.interrupted()) {
                return eVarA;
            }
            b.f.d.e.a.i(f.class, "Host thread was interrupted, decreasing reference count");
            eVarA.close();
            throw new InterruptedException();
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
