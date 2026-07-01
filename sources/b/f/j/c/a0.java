package b.f.j.c;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: StagingArea.java */
/* JADX INFO: loaded from: classes.dex */
public class a0 {
    public Map<CacheKey, b.f.j.j.e> a = new HashMap();

    public synchronized b.f.j.j.e a(CacheKey cacheKey) {
        Objects.requireNonNull(cacheKey);
        b.f.j.j.e eVarA = this.a.get(cacheKey);
        if (eVarA != null) {
            synchronized (eVarA) {
                if (!b.f.j.j.e.u(eVarA)) {
                    this.a.remove(cacheKey);
                    b.f.d.e.a.m(a0.class, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(eVarA)), cacheKey.b(), Integer.valueOf(System.identityHashCode(cacheKey)));
                    return null;
                }
                eVarA = b.f.j.j.e.a(eVarA);
            }
        }
        return eVarA;
    }

    public synchronized void b(CacheKey cacheKey, b.f.j.j.e eVar) {
        b.c.a.a0.d.i(Boolean.valueOf(b.f.j.j.e.u(eVar)));
        b.f.j.j.e eVarPut = this.a.put(cacheKey, b.f.j.j.e.a(eVar));
        if (eVarPut != null) {
            eVarPut.close();
        }
        synchronized (this) {
            this.a.size();
            int i = b.f.d.e.a.a;
        }
    }

    public boolean c(CacheKey cacheKey) {
        b.f.j.j.e eVarRemove;
        Objects.requireNonNull(cacheKey);
        synchronized (this) {
            eVarRemove = this.a.remove(cacheKey);
        }
        if (eVarRemove == null) {
            return false;
        }
        try {
            return eVarRemove.t();
        } finally {
            eVarRemove.close();
        }
    }

    public synchronized boolean d(CacheKey cacheKey, b.f.j.j.e eVar) {
        Objects.requireNonNull(cacheKey);
        Objects.requireNonNull(eVar);
        b.c.a.a0.d.i(Boolean.valueOf(b.f.j.j.e.u(eVar)));
        b.f.j.j.e eVar2 = this.a.get(cacheKey);
        if (eVar2 == null) {
            return false;
        }
        CloseableReference<PooledByteBuffer> closeableReferenceC = eVar2.c();
        CloseableReference<PooledByteBuffer> closeableReferenceC2 = eVar.c();
        if (closeableReferenceC != null && closeableReferenceC2 != null) {
            try {
                if (closeableReferenceC.u() == closeableReferenceC2.u()) {
                    this.a.remove(cacheKey);
                    closeableReferenceC2.close();
                    closeableReferenceC.close();
                    eVar2.close();
                    synchronized (this) {
                        this.a.size();
                        int i = b.f.d.e.a.a;
                    }
                    return true;
                }
            } catch (Throwable th) {
                closeableReferenceC2.close();
                closeableReferenceC.close();
                eVar2.close();
                throw th;
            }
        }
        if (closeableReferenceC2 != null) {
            closeableReferenceC2.close();
        }
        if (closeableReferenceC != null) {
            closeableReferenceC.close();
        }
        eVar2.close();
        return false;
    }
}
