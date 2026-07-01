package b.f.j.c;

import b.f.d.e.FLog;
import b.f.j.j.EncodedImage2;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: b.f.j.c.e, reason: use source file name */
/* JADX INFO: compiled from: BufferedDiskCache.java */
/* JADX INFO: loaded from: classes.dex */
public class BufferedDiskCache implements Callable<EncodedImage2> {
    public final /* synthetic */ AtomicBoolean j;
    public final /* synthetic */ CacheKey k;
    public final /* synthetic */ BufferedDiskCache2 l;

    public BufferedDiskCache(BufferedDiskCache2 bufferedDiskCache2, Object obj, AtomicBoolean atomicBoolean, CacheKey cacheKey) {
        this.l = bufferedDiskCache2;
        this.j = atomicBoolean;
        this.k = cacheKey;
    }

    @Override // java.util.concurrent.Callable
    public EncodedImage2 call() throws Exception {
        try {
            if (this.j.get()) {
                throw new CancellationException();
            }
            EncodedImage2 encodedImage2A = this.l.f.a(this.k);
            if (encodedImage2A == null) {
                this.k.b();
                int i = FLog.a;
                Objects.requireNonNull((NoOpImageCacheStatsTracker) this.l.g);
                encodedImage2A = null;
                try {
                    PooledByteBuffer pooledByteBufferA = BufferedDiskCache2.a(this.l, this.k);
                    if (pooledByteBufferA != null) {
                        CloseableReference closeableReferenceA = CloseableReference.A(pooledByteBufferA);
                        try {
                            EncodedImage2 encodedImage2 = new EncodedImage2(closeableReferenceA);
                            if (closeableReferenceA != null) {
                                closeableReferenceA.close();
                            }
                            encodedImage2A = encodedImage2;
                        } catch (Throwable th) {
                            if (closeableReferenceA != null) {
                                closeableReferenceA.close();
                            }
                            throw th;
                        }
                    }
                } catch (Exception unused) {
                }
                return encodedImage2A;
            }
            this.k.b();
            int i2 = FLog.a;
            Objects.requireNonNull((NoOpImageCacheStatsTracker) this.l.g);
            if (!Thread.interrupted()) {
                return encodedImage2A;
            }
            FLog.i(BufferedDiskCache2.class, "Host thread was interrupted, decreasing reference count");
            encodedImage2A.close();
            throw new InterruptedException();
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
