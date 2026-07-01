package b.f.j.c;

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

/* JADX INFO: compiled from: BufferedDiskCache.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    public final b.f.b.b.h a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.f.d.g.g f555b;
    public final b.f.d.g.j c;
    public final Executor d;
    public final Executor e;
    public final a0 f = new a0();
    public final r g;

    public f(b.f.b.b.h hVar, b.f.d.g.g gVar, b.f.d.g.j jVar, Executor executor, Executor executor2, r rVar) {
        this.a = hVar;
        this.f555b = gVar;
        this.c = jVar;
        this.d = executor;
        this.e = executor2;
        this.g = rVar;
    }

    public static PooledByteBuffer a(f fVar, CacheKey cacheKey) throws IOException {
        Objects.requireNonNull(fVar);
        try {
            cacheKey.b();
            int i = b.f.d.e.a.a;
            b.f.a.a aVarB = ((b.f.b.b.d) fVar.a).b(cacheKey);
            if (aVarB == null) {
                cacheKey.b();
                Objects.requireNonNull((z) fVar.g);
                return null;
            }
            cacheKey.b();
            Objects.requireNonNull((z) fVar.g);
            FileInputStream fileInputStream = new FileInputStream(aVarB.a);
            try {
                PooledByteBuffer pooledByteBufferD = fVar.f555b.d(fileInputStream, (int) aVarB.a());
                fileInputStream.close();
                cacheKey.b();
                return pooledByteBufferD;
            } catch (Throwable th) {
                fileInputStream.close();
                throw th;
            }
        } catch (IOException e) {
            b.f.d.e.a.n(f.class, e, "Exception reading from cache for %s", cacheKey.b());
            Objects.requireNonNull((z) fVar.g);
            throw e;
        }
    }

    public static void b(f fVar, CacheKey cacheKey, b.f.j.j.e eVar) {
        Objects.requireNonNull(fVar);
        cacheKey.b();
        int i = b.f.d.e.a.a;
        try {
            ((b.f.b.b.d) fVar.a).d(cacheKey, new h(fVar, eVar));
            Objects.requireNonNull((z) fVar.g);
            cacheKey.b();
        } catch (IOException e) {
            b.f.d.e.a.n(f.class, e, "Failed to write to disk-cache for key %s", cacheKey.b());
        }
    }

    public void c(CacheKey cacheKey) {
        b.f.b.b.d dVar = (b.f.b.b.d) this.a;
        Objects.requireNonNull(dVar);
        try {
            synchronized (dVar.q) {
                List<String> listZ0 = b.c.a.a0.d.z0(cacheKey);
                int i = 0;
                while (true) {
                    ArrayList arrayList = (ArrayList) listZ0;
                    if (i >= arrayList.size()) {
                        return;
                    }
                    String str = (String) arrayList.get(i);
                    if (dVar.k.c(str, cacheKey)) {
                        dVar.h.add(str);
                        return;
                    }
                    i++;
                }
            }
        } catch (IOException unused) {
            b.f.b.b.i iVarA = b.f.b.b.i.a();
            iVarA.d = cacheKey;
            Objects.requireNonNull((b.f.b.a.e) dVar.g);
            iVarA.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final z.g<b.f.j.j.e> d(CacheKey cacheKey, b.f.j.j.e eVar) {
        cacheKey.b();
        int i = b.f.d.e.a.a;
        Objects.requireNonNull((z) this.g);
        ExecutorService executorService = z.g.a;
        if (eVar instanceof Boolean) {
            return ((Boolean) eVar).booleanValue() ? z.g.e : z.g.f;
        }
        z.g<b.f.j.j.e> gVar = new z.g<>();
        if (gVar.h(eVar)) {
            return gVar;
        }
        throw new IllegalStateException("Cannot set the result of a completed task.");
    }

    public z.g<b.f.j.j.e> e(CacheKey cacheKey, AtomicBoolean atomicBoolean) {
        z.g<b.f.j.j.e> gVarC;
        try {
            b.f.j.r.b.b();
            b.f.j.j.e eVarA = this.f.a(cacheKey);
            if (eVarA != null) {
                z.g<b.f.j.j.e> gVarD = d(cacheKey, eVarA);
                b.f.j.r.b.b();
                return gVarD;
            }
            try {
                gVarC = z.g.a(new e(this, null, atomicBoolean, cacheKey), this.d);
            } catch (Exception e) {
                b.f.d.e.a.n(f.class, e, "Failed to schedule disk-cache read for %s", ((b.f.b.a.f) cacheKey).a);
                gVarC = z.g.c(e);
            }
            b.f.j.r.b.b();
            return gVarC;
        } catch (Throwable th) {
            b.f.j.r.b.b();
            throw th;
        }
    }

    public void f(CacheKey cacheKey, b.f.j.j.e eVar) {
        try {
            b.f.j.r.b.b();
            Objects.requireNonNull(cacheKey);
            b.c.a.a0.d.i(Boolean.valueOf(b.f.j.j.e.u(eVar)));
            this.f.b(cacheKey, eVar);
            b.f.j.j.e eVarA = b.f.j.j.e.a(eVar);
            try {
                this.e.execute(new f$a(this, null, cacheKey, eVarA));
            } catch (Exception e) {
                b.f.d.e.a.n(f.class, e, "Failed to schedule disk-cache write for %s", cacheKey.b());
                this.f.d(cacheKey, eVar);
                if (eVarA != null) {
                    eVarA.close();
                }
            }
        } finally {
            b.f.j.r.b.b();
        }
    }
}
