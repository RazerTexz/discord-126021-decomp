package b.f.b.b;

import android.os.StatFs;
import androidx.annotation.VisibleForTesting;
import b.c.a.a0.AnimatableValueParser;
import b.f.a.FileBinaryResource;
import b.f.b.a.CacheErrorLogger;
import b.f.b.a.CacheEventListener;
import b.f.b.a.MultiCacheKey;
import b.f.b.a.NoOpCacheErrorLogger;
import b.f.b.a.NoOpCacheEventListener;
import b.f.b.a.WriterCallback;
import b.f.b.b.DefaultDiskStorage;
import b.f.b.b.DiskStorage;
import b.f.d.a.DiskTrimmableRegistry;
import b.f.d.e.FLog;
import b.f.d.i.StatFsHelper;
import b.f.d.k.Clock2;
import b.f.d.k.SystemClock;
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

/* JADX INFO: renamed from: b.f.b.b.d, reason: use source file name */
/* JADX INFO: compiled from: DiskStorageCache.java */
/* JADX INFO: loaded from: classes.dex */
public class DiskStorageCache implements FileCache {
    public static final long a = TimeUnit.HOURS.toMillis(2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f463b = TimeUnit.MINUTES.toMillis(30);
    public final long c;
    public final long d;
    public final CountDownLatch e;
    public long f;
    public final CacheEventListener g;

    @VisibleForTesting
    public final Set<String> h;
    public long i;
    public final StatFsHelper j;
    public final DiskStorage k;
    public final EntryEvictionComparatorSupplier l;
    public final CacheErrorLogger m;
    public final boolean n;
    public final b o;
    public final Clock2 p;
    public final Object q = new Object();

    /* JADX INFO: renamed from: b.f.b.b.d$a */
    /* JADX INFO: compiled from: DiskStorageCache.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (DiskStorageCache.this.q) {
                DiskStorageCache.this.e();
            }
            Objects.requireNonNull(DiskStorageCache.this);
            DiskStorageCache.this.e.countDown();
        }
    }

    /* JADX INFO: renamed from: b.f.b.b.d$b */
    /* JADX INFO: compiled from: DiskStorageCache.java */
    @VisibleForTesting
    public static class b {
        public boolean a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f464b = -1;
        public long c = -1;

        public synchronized long a() {
            return this.f464b;
        }

        public synchronized void b(long j, long j2) {
            if (this.a) {
                this.f464b += j;
                this.c += j2;
            }
        }
    }

    /* JADX INFO: renamed from: b.f.b.b.d$c */
    /* JADX INFO: compiled from: DiskStorageCache.java */
    public static class c {
        public final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f465b;
        public final long c;

        public c(long j, long j2, long j3) {
            this.a = j;
            this.f465b = j2;
            this.c = j3;
        }
    }

    public DiskStorageCache(DiskStorage diskStorage, EntryEvictionComparatorSupplier entryEvictionComparatorSupplier, c cVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, DiskTrimmableRegistry diskTrimmableRegistry, Executor executor, boolean z2) {
        StatFsHelper statFsHelper;
        this.c = cVar.f465b;
        long j = cVar.c;
        this.d = j;
        this.f = j;
        StatFsHelper statFsHelper2 = StatFsHelper.a;
        synchronized (StatFsHelper.class) {
            if (StatFsHelper.a == null) {
                StatFsHelper.a = new StatFsHelper();
            }
            statFsHelper = StatFsHelper.a;
        }
        this.j = statFsHelper;
        this.k = diskStorage;
        this.l = entryEvictionComparatorSupplier;
        this.i = -1L;
        this.g = cacheEventListener;
        this.m = cacheErrorLogger;
        this.o = new b();
        this.p = SystemClock.a;
        this.n = z2;
        this.h = new HashSet();
        if (!z2) {
            this.e = new CountDownLatch(0);
        } else {
            this.e = new CountDownLatch(1);
            executor.execute(new a());
        }
    }

    public final void a(long j, int i) throws IOException {
        try {
            Collection<DiskStorage.a> collectionC = c(this.k.e());
            long jA = this.o.a() - j;
            int i2 = 0;
            long j2 = 0;
            for (DiskStorage.a aVar : (ArrayList) collectionC) {
                if (j2 > jA) {
                    break;
                }
                long jG = this.k.g(aVar);
                this.h.remove(aVar.getId());
                if (jG > 0) {
                    i2++;
                    j2 += jG;
                    SettableCacheEvent settableCacheEventA = SettableCacheEvent.a();
                    aVar.getId();
                    Objects.requireNonNull((NoOpCacheEventListener) this.g);
                    settableCacheEventA.b();
                }
            }
            this.o.b(-j2, -i2);
            this.k.a();
        } catch (IOException e) {
            CacheErrorLogger cacheErrorLogger = this.m;
            e.getMessage();
            Objects.requireNonNull((NoOpCacheErrorLogger) cacheErrorLogger);
            throw e;
        }
    }

    public FileBinaryResource b(CacheKey cacheKey) {
        FileBinaryResource fileBinaryResourceD;
        SettableCacheEvent settableCacheEventA = SettableCacheEvent.a();
        settableCacheEventA.d = cacheKey;
        try {
            try {
                synchronized (this.q) {
                    List<String> listZ0 = AnimatableValueParser.z0(cacheKey);
                    int i = 0;
                    String str = null;
                    fileBinaryResourceD = null;
                    while (true) {
                        ArrayList arrayList = (ArrayList) listZ0;
                        if (i >= arrayList.size() || (fileBinaryResourceD = this.k.d((str = (String) arrayList.get(i)), cacheKey)) != null) {
                            break;
                            break;
                        }
                        i++;
                    }
                    if (fileBinaryResourceD == null) {
                        Objects.requireNonNull((NoOpCacheEventListener) this.g);
                        this.h.remove(str);
                    } else {
                        Objects.requireNonNull(str);
                        Objects.requireNonNull((NoOpCacheEventListener) this.g);
                        this.h.add(str);
                    }
                }
                settableCacheEventA.b();
                return fileBinaryResourceD;
            } catch (IOException unused) {
                Objects.requireNonNull((NoOpCacheErrorLogger) this.m);
                Objects.requireNonNull((NoOpCacheEventListener) this.g);
                settableCacheEventA.b();
                return null;
            }
        } catch (Throwable th) {
            settableCacheEventA.b();
            throw th;
        }
    }

    public final Collection<DiskStorage.a> c(Collection<DiskStorage.a> collection) {
        Objects.requireNonNull((SystemClock) this.p);
        long jCurrentTimeMillis = System.currentTimeMillis() + a;
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (DiskStorage.a aVar : collection) {
            if (aVar.a() > jCurrentTimeMillis) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.l.get());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    public FileBinaryResource d(CacheKey cacheKey, WriterCallback writerCallback) throws IOException {
        String strW1;
        FileBinaryResource fileBinaryResourceB;
        SettableCacheEvent settableCacheEventA = SettableCacheEvent.a();
        settableCacheEventA.d = cacheKey;
        Objects.requireNonNull((NoOpCacheEventListener) this.g);
        synchronized (this.q) {
            try {
                try {
                    if (cacheKey instanceof MultiCacheKey) {
                        throw null;
                    }
                    strW1 = AnimatableValueParser.W1(cacheKey);
                    try {
                    } catch (Throwable th) {
                        settableCacheEventA.b();
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
            DiskStorage.b bVarG = g(strW1, cacheKey);
            try {
                DefaultDiskStorage.f fVar = (DefaultDiskStorage.f) bVarG;
                fVar.c(writerCallback, cacheKey);
                synchronized (this.q) {
                    fileBinaryResourceB = fVar.b(cacheKey);
                    this.h.add(strW1);
                    this.o.b(fileBinaryResourceB.a(), 1L);
                }
                fileBinaryResourceB.a();
                this.o.a();
                Objects.requireNonNull((NoOpCacheEventListener) this.g);
                if (!fVar.a()) {
                    FLog.a(DiskStorageCache.class, "Failed to delete temp file");
                }
                settableCacheEventA.b();
                return fileBinaryResourceB;
            } catch (Throwable th3) {
                if (!((DefaultDiskStorage.f) bVarG).a()) {
                    FLog.a(DiskStorageCache.class, "Failed to delete temp file");
                }
                throw th3;
            }
        } catch (IOException e2) {
            Objects.requireNonNull((NoOpCacheEventListener) this.g);
            FLog.b(DiskStorageCache.class, "Failed inserting a file into the cache", e2);
            throw e2;
        }
    }

    public final boolean e() {
        boolean z2;
        long j;
        long j2;
        Objects.requireNonNull((SystemClock) this.p);
        long jCurrentTimeMillis = System.currentTimeMillis();
        b bVar = this.o;
        synchronized (bVar) {
            z2 = bVar.a;
        }
        long jMax = -1;
        if (z2) {
            long j3 = this.i;
            if (j3 != -1 && jCurrentTimeMillis - j3 <= f463b) {
                return false;
            }
        }
        Objects.requireNonNull((SystemClock) this.p);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        long j4 = a + jCurrentTimeMillis2;
        Set<String> hashSet = (this.n && this.h.isEmpty()) ? this.h : this.n ? new HashSet<>() : null;
        try {
            long size = 0;
            boolean z3 = false;
            int i = 0;
            for (DiskStorage.a aVar : this.k.e()) {
                i++;
                size += aVar.getSize();
                if (aVar.a() > j4) {
                    aVar.getSize();
                    j2 = j4;
                    jMax = Math.max(aVar.a() - jCurrentTimeMillis2, jMax);
                    z3 = true;
                } else {
                    j2 = j4;
                    if (this.n) {
                        Objects.requireNonNull(hashSet);
                        hashSet.add(aVar.getId());
                    }
                }
                j4 = j2;
            }
            if (z3) {
                Objects.requireNonNull((NoOpCacheErrorLogger) this.m);
            }
            b bVar2 = this.o;
            synchronized (bVar2) {
                j = bVar2.c;
            }
            long j5 = i;
            if (j != j5 || this.o.a() != size) {
                if (this.n && this.h != hashSet) {
                    Objects.requireNonNull(hashSet);
                    this.h.clear();
                    this.h.addAll(hashSet);
                }
                b bVar3 = this.o;
                synchronized (bVar3) {
                    bVar3.c = j5;
                    bVar3.f464b = size;
                    bVar3.a = true;
                }
            }
            this.i = jCurrentTimeMillis2;
            return true;
        } catch (IOException e) {
            CacheErrorLogger cacheErrorLogger = this.m;
            e.getMessage();
            Objects.requireNonNull((NoOpCacheErrorLogger) cacheErrorLogger);
            return false;
        }
    }

    public void f(CacheKey cacheKey) {
        synchronized (this.q) {
            try {
                List<String> listZ0 = AnimatableValueParser.z0(cacheKey);
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
                CacheErrorLogger cacheErrorLogger = this.m;
                e.getMessage();
                Objects.requireNonNull((NoOpCacheErrorLogger) cacheErrorLogger);
            }
        }
    }

    public final DiskStorage.b g(String str, CacheKey cacheKey) throws IOException {
        synchronized (this.q) {
            boolean zE = e();
            h();
            long jA = this.o.a();
            if (jA > this.f && !zE) {
                b bVar = this.o;
                synchronized (bVar) {
                    bVar.a = false;
                    bVar.c = -1L;
                    bVar.f464b = -1L;
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
        char c2 = this.k.isExternal() ? (char) 2 : (char) 1;
        StatFsHelper statFsHelper = this.j;
        long jA = this.d - this.o.a();
        statFsHelper.a();
        statFsHelper.a();
        if (statFsHelper.h.tryLock()) {
            try {
                if (android.os.SystemClock.uptimeMillis() - statFsHelper.g > StatFsHelper.f473b) {
                    statFsHelper.b();
                }
                statFsHelper.h.unlock();
            } catch (Throwable th) {
                statFsHelper.h.unlock();
                throw th;
            }
        }
        StatFs statFs = c2 == 1 ? statFsHelper.c : statFsHelper.e;
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
