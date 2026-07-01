package b.f.b.b;

import android.os.StatFs;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import com.facebook.cache.common.CacheKey;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: DiskStorageCache.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements h {
    public static final long a = TimeUnit.HOURS.toMillis(2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f463b = TimeUnit.MINUTES.toMillis(30);
    public final long c;
    public final long d;
    public final CountDownLatch e;
    public long f;
    public final b.f.b.a.b g;

    @VisibleForTesting
    public final Set<String> h;
    public long i;
    public final b.f.d.i.a j;
    public final c k;
    public final g l;
    public final b.f.b.a.a m;
    public final boolean n;
    public final d$b o;
    public final b.f.d.k.a p;
    public final Object q = new Object();

    public d(c cVar, g gVar, d$c d_c, b.f.b.a.b bVar, b.f.b.a.a aVar, b.f.d.a.a aVar2, Executor executor, boolean z2) {
        b.f.d.i.a aVar3;
        this.c = d_c.f465b;
        long j = d_c.c;
        this.d = j;
        this.f = j;
        b.f.d.i.a aVar4 = b.f.d.i.a.a;
        synchronized (b.f.d.i.a.class) {
            if (b.f.d.i.a.a == null) {
                b.f.d.i.a.a = new b.f.d.i.a();
            }
            aVar3 = b.f.d.i.a.a;
        }
        this.j = aVar3;
        this.k = cVar;
        this.l = gVar;
        this.i = -1L;
        this.g = bVar;
        this.m = aVar;
        this.o = new d$b();
        this.p = b.f.d.k.c.a;
        this.n = z2;
        this.h = new HashSet();
        if (!z2) {
            this.e = new CountDownLatch(0);
        } else {
            this.e = new CountDownLatch(1);
            executor.execute(new d$a(this));
        }
    }

    public final void a(long j, int i) throws IOException {
        try {
            Collection<c$a> collectionC = c(this.k.e());
            long jA = this.o.a() - j;
            int i2 = 0;
            long j2 = 0;
            for (c$a c_a : (ArrayList) collectionC) {
                if (j2 > jA) {
                    break;
                }
                long jG = this.k.g(c_a);
                this.h.remove(c_a.getId());
                if (jG > 0) {
                    i2++;
                    j2 += jG;
                    i iVarA = i.a();
                    c_a.getId();
                    Objects.requireNonNull((b.f.b.a.e) this.g);
                    iVarA.b();
                }
            }
            this.o.b(-j2, -i2);
            this.k.a();
        } catch (IOException e) {
            b.f.b.a.a aVar = this.m;
            e.getMessage();
            Objects.requireNonNull((b.f.b.a.d) aVar);
            throw e;
        }
    }

    public b.f.a.a b(CacheKey cacheKey) {
        b.f.a.a aVarD;
        i iVarA = i.a();
        iVarA.d = cacheKey;
        try {
            try {
                synchronized (this.q) {
                    List<String> listZ0 = b.c.a.a0.d.z0(cacheKey);
                    int i = 0;
                    String str = null;
                    aVarD = null;
                    while (true) {
                        ArrayList arrayList = (ArrayList) listZ0;
                        if (i >= arrayList.size() || (aVarD = this.k.d((str = (String) arrayList.get(i)), cacheKey)) != null) {
                            break;
                            break;
                        }
                        i++;
                    }
                    if (aVarD == null) {
                        Objects.requireNonNull((b.f.b.a.e) this.g);
                        this.h.remove(str);
                    } else {
                        Objects.requireNonNull(str);
                        Objects.requireNonNull((b.f.b.a.e) this.g);
                        this.h.add(str);
                    }
                }
                iVarA.b();
                return aVarD;
            } catch (IOException unused) {
                Objects.requireNonNull((b.f.b.a.d) this.m);
                Objects.requireNonNull((b.f.b.a.e) this.g);
                iVarA.b();
                return null;
            }
        } catch (Throwable th) {
            iVarA.b();
            throw th;
        }
    }

    public final Collection<c$a> c(Collection<c$a> collection) {
        Objects.requireNonNull((b.f.d.k.c) this.p);
        long jCurrentTimeMillis = System.currentTimeMillis() + a;
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c$a c_a : collection) {
            if (c_a.a() > jCurrentTimeMillis) {
                arrayList.add(c_a);
            } else {
                arrayList2.add(c_a);
            }
        }
        Collections.sort(arrayList2, this.l.get());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    public b.f.a.a d(CacheKey cacheKey, b.f.b.a.g gVar) throws IOException {
        String strW1;
        b.f.a.a aVarB;
        i iVarA = i.a();
        iVarA.d = cacheKey;
        Objects.requireNonNull((b.f.b.a.e) this.g);
        synchronized (this.q) {
            try {
                try {
                    if (cacheKey instanceof b.f.b.a.c) {
                        throw null;
                    }
                    strW1 = b.c.a.a0.d.W1(cacheKey);
                    try {
                    } catch (Throwable th) {
                        iVarA.b();
                        throw th;
                    }
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        try {
            c$b c_bG = g(strW1, cacheKey);
            try {
                a$f a_f = (a$f) c_bG;
                a_f.c(gVar, cacheKey);
                synchronized (this.q) {
                    aVarB = a_f.b(cacheKey);
                    this.h.add(strW1);
                    this.o.b(aVarB.a(), 1L);
                }
                aVarB.a();
                this.o.a();
                Objects.requireNonNull((b.f.b.a.e) this.g);
                if (!a_f.a()) {
                    b.f.d.e.a.a(d.class, "Failed to delete temp file");
                }
                iVarA.b();
                return aVarB;
            } catch (Throwable th3) {
                if (!((a$f) c_bG).a()) {
                    b.f.d.e.a.a(d.class, "Failed to delete temp file");
                }
                throw th3;
            }
        } catch (IOException e2) {
            Objects.requireNonNull((b.f.b.a.e) this.g);
            b.f.d.e.a.b(d.class, "Failed inserting a file into the cache", e2);
            throw e2;
        }
    }

    public final boolean e() {
        boolean z2;
        long j;
        long j2;
        Objects.requireNonNull((b.f.d.k.c) this.p);
        long jCurrentTimeMillis = System.currentTimeMillis();
        d$b d_b = this.o;
        synchronized (d_b) {
            z2 = d_b.a;
        }
        long jMax = -1;
        if (z2) {
            long j3 = this.i;
            if (j3 != -1 && jCurrentTimeMillis - j3 <= f463b) {
                return false;
            }
        }
        Objects.requireNonNull((b.f.d.k.c) this.p);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        long j4 = a + jCurrentTimeMillis2;
        Set<String> hashSet = (this.n && this.h.isEmpty()) ? this.h : this.n ? new HashSet<>() : null;
        try {
            long size = 0;
            boolean z3 = false;
            int i = 0;
            for (c$a c_a : this.k.e()) {
                i++;
                size += c_a.getSize();
                if (c_a.a() > j4) {
                    c_a.getSize();
                    j2 = j4;
                    jMax = Math.max(c_a.a() - jCurrentTimeMillis2, jMax);
                    z3 = true;
                } else {
                    j2 = j4;
                    if (this.n) {
                        Objects.requireNonNull(hashSet);
                        hashSet.add(c_a.getId());
                    }
                }
                j4 = j2;
            }
            if (z3) {
                Objects.requireNonNull((b.f.b.a.d) this.m);
            }
            d$b d_b2 = this.o;
            synchronized (d_b2) {
                j = d_b2.c;
            }
            long j5 = i;
            if (j != j5 || this.o.a() != size) {
                if (this.n && this.h != hashSet) {
                    Objects.requireNonNull(hashSet);
                    this.h.clear();
                    this.h.addAll(hashSet);
                }
                d$b d_b3 = this.o;
                synchronized (d_b3) {
                    d_b3.c = j5;
                    d_b3.f464b = size;
                    d_b3.a = true;
                }
            }
            this.i = jCurrentTimeMillis2;
            return true;
        } catch (IOException e) {
            b.f.b.a.a aVar = this.m;
            e.getMessage();
            Objects.requireNonNull((b.f.b.a.d) aVar);
            return false;
        }
    }

    public void f(CacheKey cacheKey) {
        synchronized (this.q) {
            try {
                List<String> listZ0 = b.c.a.a0.d.z0(cacheKey);
                int i = 0;
                while (true) {
                    ArrayList arrayList = (ArrayList) listZ0;
                    if (i >= arrayList.size()) {
                        break;
                    }
                    String str = (String) arrayList.get(i);
                    this.k.f(str);
                    this.h.remove(str);
                    i++;
                }
            } catch (IOException e) {
                b.f.b.a.a aVar = this.m;
                e.getMessage();
                Objects.requireNonNull((b.f.b.a.d) aVar);
            }
        }
    }

    public final c$b g(String str, CacheKey cacheKey) throws IOException {
        synchronized (this.q) {
            boolean zE = e();
            h();
            long jA = this.o.a();
            if (jA > this.f && !zE) {
                d$b d_b = this.o;
                synchronized (d_b) {
                    d_b.a = false;
                    d_b.c = -1L;
                    d_b.f464b = -1L;
                }
                e();
            }
            long j = this.f;
            if (jA > j) {
                a((j * 9) / 10, 1);
            }
        }
        return this.k.b(str, cacheKey);
    }

    public final void h() {
        long availableBlocksLong;
        boolean z2 = true;
        char c = this.k.isExternal() ? (char) 2 : (char) 1;
        b.f.d.i.a aVar = this.j;
        long jA = this.d - this.o.a();
        aVar.a();
        aVar.a();
        if (aVar.h.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - aVar.g > b.f.d.i.a.f473b) {
                    aVar.b();
                }
                aVar.h.unlock();
            } catch (Throwable th) {
                aVar.h.unlock();
                throw th;
            }
        }
        StatFs statFs = c == 1 ? aVar.c : aVar.e;
        if (statFs != null) {
            availableBlocksLong = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
        } else {
            availableBlocksLong = 0;
        }
        if (availableBlocksLong > 0 && availableBlocksLong >= jA) {
            z2 = false;
        }
        if (z2) {
            this.f = this.c;
        } else {
            this.f = this.d;
        }
    }
}
