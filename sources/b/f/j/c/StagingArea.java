package b.f.j.c;

import b.c.a.a0.AnimatableValueParser;
import b.f.d.e.FLog;
import b.f.j.j.EncodedImage2;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.c.a0, reason: use source file name */
/* JADX INFO: compiled from: StagingArea.java */
/* JADX INFO: loaded from: classes.dex */
public class StagingArea {
    public Map<CacheKey, EncodedImage2> a = new HashMap();

    public synchronized EncodedImage2 a(CacheKey cacheKey) {
        Objects.requireNonNull(cacheKey);
        EncodedImage2 encodedImage2A = this.a.get(cacheKey);
        if (encodedImage2A != null) {
            synchronized (encodedImage2A) {
                if (!EncodedImage2.u(encodedImage2A)) {
                    this.a.remove(cacheKey);
                    FLog.m(StagingArea.class, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(encodedImage2A)), cacheKey.b(), Integer.valueOf(System.identityHashCode(cacheKey)));
                    return null;
                }
                encodedImage2A = EncodedImage2.a(encodedImage2A);
            }
        }
        return encodedImage2A;
    }

    public synchronized void b(CacheKey cacheKey, EncodedImage2 encodedImage2) {
        AnimatableValueParser.i(Boolean.valueOf(EncodedImage2.u(encodedImage2)));
        EncodedImage2 encodedImage2Put = this.a.put(cacheKey, EncodedImage2.a(encodedImage2));
        if (encodedImage2Put != null) {
            encodedImage2Put.close();
        }
        synchronized (this) {
            this.a.size();
            int i = FLog.a;
        }
    }

    public boolean c(CacheKey cacheKey) {
        EncodedImage2 encodedImage2Remove;
        Objects.requireNonNull(cacheKey);
        synchronized (this) {
            encodedImage2Remove = this.a.remove(cacheKey);
        }
        if (encodedImage2Remove == null) {
            return false;
        }
        try {
            return encodedImage2Remove.t();
        } finally {
            encodedImage2Remove.close();
        }
    }

    public synchronized boolean d(CacheKey cacheKey, EncodedImage2 encodedImage2) {
        Objects.requireNonNull(cacheKey);
        Objects.requireNonNull(encodedImage2);
        AnimatableValueParser.i(Boolean.valueOf(EncodedImage2.u(encodedImage2)));
        EncodedImage2 encodedImage3 = this.a.get(cacheKey);
        if (encodedImage3 == null) {
            return false;
        }
        CloseableReference<PooledByteBuffer> closeableReferenceC = encodedImage3.c();
        CloseableReference<PooledByteBuffer> closeableReferenceC2 = encodedImage2.c();
        if (closeableReferenceC != null && closeableReferenceC2 != null) {
            try {
                if (closeableReferenceC.u() == closeableReferenceC2.u()) {
                    this.a.remove(cacheKey);
                    closeableReferenceC2.close();
                    closeableReferenceC.close();
                    encodedImage3.close();
                    synchronized (this) {
                        this.a.size();
                        int i = FLog.a;
                    }
                    return true;
                }
            } catch (Throwable th) {
                closeableReferenceC2.close();
                closeableReferenceC.close();
                encodedImage3.close();
                throw th;
            }
        }
        if (closeableReferenceC2 != null) {
            closeableReferenceC2.close();
        }
        if (closeableReferenceC != null) {
            closeableReferenceC.close();
        }
        encodedImage3.close();
        return false;
    }
}
