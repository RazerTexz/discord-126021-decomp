package b.i.a.c.e3.b0;

import android.database.SQLException;
import android.os.ConditionVariable;
import android.util.Log;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.e3.b0.CachedContent;
import b.i.a.c.f3.Log2;
import b.i.a.c.u2.DatabaseProvider;
import b.i.b.b.ImmutableSet2;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.upstream.cache.Cache;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

/* JADX INFO: renamed from: b.i.a.c.e3.b0.r, reason: use source file name */
/* JADX INFO: compiled from: SimpleCache.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SimpleCache2 implements Cache {
    public static final HashSet<File> a = new HashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f938b;
    public final CacheEvictor c;
    public final CachedContentIndex d;

    @Nullable
    public final CacheFileMetadataIndex e;
    public final HashMap<String, ArrayList<Cache.a>> f;
    public final Random g;
    public final boolean h;
    public long i;
    public long j;
    public Cache.CacheException k;

    public SimpleCache2(File file, CacheEvictor cacheEvictor, DatabaseProvider databaseProvider) {
        boolean zAdd;
        CachedContentIndex cachedContentIndex = new CachedContentIndex(databaseProvider, file, null, false, false);
        CacheFileMetadataIndex cacheFileMetadataIndex = new CacheFileMetadataIndex(databaseProvider);
        synchronized (SimpleCache2.class) {
            zAdd = a.add(file.getAbsoluteFile());
        }
        if (!zAdd) {
            String strValueOf = String.valueOf(file);
            throw new IllegalStateException(outline.j(strValueOf.length() + 46, "Another SimpleCache instance uses the folder: ", strValueOf));
        }
        this.f938b = file;
        this.c = cacheEvictor;
        this.d = cachedContentIndex;
        this.e = cacheFileMetadataIndex;
        this.f = new HashMap<>();
        this.g = new Random();
        this.h = true;
        this.i = -1L;
        ConditionVariable conditionVariable = new ConditionVariable();
        new SimpleCache(this, "ExoPlayer:SimpleCacheInit", conditionVariable).start();
        conditionVariable.block();
    }

    public static void j(SimpleCache2 simpleCache2) {
        long j;
        if (!simpleCache2.f938b.exists()) {
            try {
                m(simpleCache2.f938b);
            } catch (Cache.CacheException e) {
                simpleCache2.k = e;
                return;
            }
        }
        File[] fileArrListFiles = simpleCache2.f938b.listFiles();
        if (fileArrListFiles == null) {
            String strValueOf = String.valueOf(simpleCache2.f938b);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 38);
            sb.append("Failed to list cache directory files: ");
            sb.append(strValueOf);
            String string = sb.toString();
            Log.e("SimpleCache", string);
            simpleCache2.k = new Cache.CacheException(string);
            return;
        }
        int length = fileArrListFiles.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                j = -1;
                break;
            }
            File file = fileArrListFiles[i];
            String name = file.getName();
            if (name.endsWith(".uid")) {
                try {
                    j = Long.parseLong(name.substring(0, name.indexOf(46)), 16);
                    break;
                } catch (NumberFormatException unused) {
                    String strValueOf2 = String.valueOf(file);
                    StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 20);
                    sb2.append("Malformed UID file: ");
                    sb2.append(strValueOf2);
                    Log.e("SimpleCache", sb2.toString());
                    file.delete();
                }
            }
            i++;
        }
        simpleCache2.i = j;
        if (j == -1) {
            try {
                simpleCache2.i = n(simpleCache2.f938b);
            } catch (IOException e2) {
                String strValueOf3 = String.valueOf(simpleCache2.f938b);
                StringBuilder sb3 = new StringBuilder(strValueOf3.length() + 28);
                sb3.append("Failed to create cache UID: ");
                sb3.append(strValueOf3);
                String string2 = sb3.toString();
                Log2.b("SimpleCache", string2, e2);
                simpleCache2.k = new Cache.CacheException(string2, e2);
                return;
            }
        }
        try {
            simpleCache2.d.e(simpleCache2.i);
            CacheFileMetadataIndex cacheFileMetadataIndex = simpleCache2.e;
            if (cacheFileMetadataIndex != null) {
                cacheFileMetadataIndex.b(simpleCache2.i);
                Map<String, CacheFileMetadata> mapA = simpleCache2.e.a();
                simpleCache2.p(simpleCache2.f938b, true, fileArrListFiles, mapA);
                simpleCache2.e.c(((HashMap) mapA).keySet());
            } else {
                simpleCache2.p(simpleCache2.f938b, true, fileArrListFiles, null);
            }
            CachedContentIndex cachedContentIndex = simpleCache2.d;
            Iterator it = ImmutableSet2.m(cachedContentIndex.a.keySet()).iterator();
            while (it.hasNext()) {
                cachedContentIndex.f((String) it.next());
            }
            try {
                simpleCache2.d.g();
            } catch (IOException e3) {
                Log2.b("SimpleCache", "Storing index file failed", e3);
            }
        } catch (IOException e4) {
            String strValueOf4 = String.valueOf(simpleCache2.f938b);
            StringBuilder sb4 = new StringBuilder(strValueOf4.length() + 36);
            sb4.append("Failed to initialize cache indices: ");
            sb4.append(strValueOf4);
            String string3 = sb4.toString();
            Log2.b("SimpleCache", string3, e4);
            simpleCache2.k = new Cache.CacheException(string3, e4);
        }
    }

    public static void m(File file) throws Cache.CacheException {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String strValueOf = String.valueOf(file);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 34);
        sb.append("Failed to create cache directory: ");
        sb.append(strValueOf);
        String string = sb.toString();
        Log.e("SimpleCache", string);
        throw new Cache.CacheException(string);
    }

    public static long n(File file) throws IOException {
        long jNextLong = new SecureRandom().nextLong();
        long jAbs = jNextLong == Long.MIN_VALUE ? 0L : Math.abs(jNextLong);
        String strValueOf = String.valueOf(Long.toString(jAbs, 16));
        File file2 = new File(file, ".uid".length() != 0 ? strValueOf.concat(".uid") : new String(strValueOf));
        if (file2.createNewFile()) {
            return jAbs;
        }
        String strValueOf2 = String.valueOf(file2);
        throw new IOException(outline.j(strValueOf2.length() + 27, "Failed to create UID file: ", strValueOf2));
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized File a(String str, long j, long j2) throws Cache.CacheException {
        CachedContent cachedContent;
        File file;
        AnimatableValueParser.D(true);
        l();
        cachedContent = this.d.a.get(str);
        Objects.requireNonNull(cachedContent);
        AnimatableValueParser.D(cachedContent.a(j, j2));
        if (!this.f938b.exists()) {
            m(this.f938b);
            r();
        }
        this.c.a(this, str, j, j2);
        file = new File(this.f938b, Integer.toString(this.g.nextInt(10)));
        if (!file.exists()) {
            m(file);
        }
        return SimpleCacheSpan.h(file, cachedContent.a, j, System.currentTimeMillis());
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized ContentMetadata2 b(String str) {
        CachedContent cachedContent;
        AnimatableValueParser.D(true);
        cachedContent = this.d.a.get(str);
        return cachedContent != null ? cachedContent.e : DefaultContentMetadata.a;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void c(String str, ContentMetadataMutations contentMetadataMutations) throws Cache.CacheException {
        AnimatableValueParser.D(true);
        l();
        CachedContentIndex cachedContentIndex = this.d;
        CachedContent cachedContentD = cachedContentIndex.d(str);
        DefaultContentMetadata defaultContentMetadata = cachedContentD.e;
        DefaultContentMetadata defaultContentMetadataA = defaultContentMetadata.a(contentMetadataMutations);
        cachedContentD.e = defaultContentMetadataA;
        if (!defaultContentMetadataA.equals(defaultContentMetadata)) {
            cachedContentIndex.e.c(cachedContentD);
        }
        try {
            this.d.g();
        } catch (IOException e) {
            throw new Cache.CacheException(e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void d(CacheSpan cacheSpan) {
        AnimatableValueParser.D(true);
        q(cacheSpan);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0059 A[PHI: r20
      0x0059: PHI (r20v6 b.i.a.c.e3.b0.s) = (r20v3 b.i.a.c.e3.b0.s), (r20v7 b.i.a.c.e3.b0.s) binds: [B:23:0x0056, B:18:0x0049] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:26:0x005b A[PHI: r20
      0x005b: PHI (r20v4 b.i.a.c.e3.b0.s) = (r20v3 b.i.a.c.e3.b0.s), (r20v3 b.i.a.c.e3.b0.s), (r20v7 b.i.a.c.e3.b0.s), (r20v7 b.i.a.c.e3.b0.s) binds: [B:21:0x0050, B:24:0x0058, B:16:0x0044, B:19:0x004b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    @Nullable
    public synchronized CacheSpan e(String str, long j, long j2) throws Cache.CacheException {
        SimpleCacheSpan simpleCacheSpan;
        boolean z2;
        boolean z3;
        AnimatableValueParser.D(true);
        l();
        SimpleCacheSpan simpleCacheSpanO = o(str, j, j2);
        if (simpleCacheSpanO.m) {
            return s(str, simpleCacheSpanO);
        }
        CachedContent cachedContentD = this.d.d(str);
        long j3 = simpleCacheSpanO.l;
        int i = 0;
        while (true) {
            if (i >= cachedContentD.d.size()) {
                simpleCacheSpan = simpleCacheSpanO;
                cachedContentD.d.add(new CachedContent.a(j, j3));
                z2 = true;
                break;
            }
            CachedContent.a aVar = cachedContentD.d.get(i);
            long j4 = aVar.a;
            if (j4 <= j) {
                simpleCacheSpan = simpleCacheSpanO;
                long j5 = aVar.f931b;
                if (j5 == -1 || j4 + j5 > j) {
                    z3 = true;
                } else {
                    z3 = false;
                }
            } else {
                simpleCacheSpan = simpleCacheSpanO;
                if (j3 == -1 || j + j3 > j4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
            }
            if (z3) {
                z2 = false;
                break;
            }
            i++;
            simpleCacheSpanO = simpleCacheSpan;
        }
        if (z2) {
            return simpleCacheSpan;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized CacheSpan f(String str, long j, long j2) throws InterruptedException, Cache.CacheException {
        CacheSpan cacheSpanE;
        AnimatableValueParser.D(true);
        l();
        while (true) {
            cacheSpanE = e(str, j, j2);
            if (cacheSpanE == null) {
                wait();
            }
        }
        return cacheSpanE;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void g(File file, long j) throws Cache.CacheException {
        boolean z2 = true;
        AnimatableValueParser.D(true);
        if (file.exists()) {
            if (j == 0) {
                file.delete();
                return;
            }
            SimpleCacheSpan simpleCacheSpanG = SimpleCacheSpan.g(file, j, -9223372036854775807L, this.d);
            Objects.requireNonNull(simpleCacheSpanG);
            CachedContent cachedContentC = this.d.c(simpleCacheSpanG.j);
            Objects.requireNonNull(cachedContentC);
            AnimatableValueParser.D(cachedContentC.a(simpleCacheSpanG.k, simpleCacheSpanG.l));
            long jA = ContentMetadata.a(cachedContentC.e);
            if (jA != -1) {
                if (simpleCacheSpanG.k + simpleCacheSpanG.l > jA) {
                    z2 = false;
                }
                AnimatableValueParser.D(z2);
            }
            if (this.e == null) {
                k(simpleCacheSpanG);
                this.d.g();
                notifyAll();
                return;
            }
            try {
                this.e.d(file.getName(), simpleCacheSpanG.l, simpleCacheSpanG.o);
                k(simpleCacheSpanG);
                try {
                    this.d.g();
                    notifyAll();
                    return;
                } catch (IOException e) {
                    throw new Cache.CacheException(e);
                }
            } catch (IOException e2) {
                throw new Cache.CacheException(e2);
            }
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long h() {
        AnimatableValueParser.D(true);
        return this.j;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void i(CacheSpan cacheSpan) {
        AnimatableValueParser.D(true);
        CachedContent cachedContentC = this.d.c(cacheSpan.j);
        Objects.requireNonNull(cachedContentC);
        long j = cacheSpan.k;
        for (int i = 0; i < cachedContentC.d.size(); i++) {
            if (cachedContentC.d.get(i).a == j) {
                cachedContentC.d.remove(i);
                this.d.f(cachedContentC.f930b);
                notifyAll();
            }
        }
        throw new IllegalStateException();
    }

    public final void k(SimpleCacheSpan simpleCacheSpan) {
        this.d.d(simpleCacheSpan.j).c.add(simpleCacheSpan);
        this.j += simpleCacheSpan.l;
        ArrayList<Cache.a> arrayList = this.f.get(simpleCacheSpan.j);
        if (arrayList != null) {
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                } else {
                    arrayList.get(size).d(this, simpleCacheSpan);
                }
            }
        }
        this.c.d(this, simpleCacheSpan);
    }

    public synchronized void l() throws Cache.CacheException {
        Cache.CacheException cacheException = this.k;
        if (cacheException != null) {
            throw cacheException;
        }
    }

    public final SimpleCacheSpan o(String str, long j, long j2) {
        SimpleCacheSpan simpleCacheSpanFloor;
        long j3;
        CachedContent cachedContent = this.d.a.get(str);
        if (cachedContent == null) {
            return new SimpleCacheSpan(str, j, j2, -9223372036854775807L, null);
        }
        while (true) {
            SimpleCacheSpan simpleCacheSpan = new SimpleCacheSpan(cachedContent.f930b, j, -1L, -9223372036854775807L, null);
            simpleCacheSpanFloor = cachedContent.c.floor(simpleCacheSpan);
            if (simpleCacheSpanFloor == null || simpleCacheSpanFloor.k + simpleCacheSpanFloor.l <= j) {
                SimpleCacheSpan simpleCacheSpanCeiling = cachedContent.c.ceiling(simpleCacheSpan);
                if (simpleCacheSpanCeiling != null) {
                    long jMin = simpleCacheSpanCeiling.k - j;
                    if (j2 != -1) {
                        jMin = Math.min(jMin, j2);
                    }
                    j3 = jMin;
                } else {
                    j3 = j2;
                }
                simpleCacheSpanFloor = new SimpleCacheSpan(cachedContent.f930b, j, j3, -9223372036854775807L, null);
            }
            if (!simpleCacheSpanFloor.m || simpleCacheSpanFloor.n.length() == simpleCacheSpanFloor.l) {
                break;
            }
            r();
        }
        return simpleCacheSpanFloor;
    }

    public final void p(File file, boolean z2, @Nullable File[] fileArr, @Nullable Map<String, CacheFileMetadata> map) {
        if (fileArr == null || fileArr.length == 0) {
            if (z2) {
                return;
            }
            file.delete();
            return;
        }
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (z2 && name.indexOf(46) == -1) {
                p(file2, false, file2.listFiles(), map);
            } else if (!z2 || (!name.startsWith("cached_content_index.exi") && !name.endsWith(".uid"))) {
                long j = -1;
                long j2 = -9223372036854775807L;
                CacheFileMetadata cacheFileMetadataRemove = map != null ? map.remove(name) : null;
                if (cacheFileMetadataRemove != null) {
                    j = cacheFileMetadataRemove.a;
                    j2 = cacheFileMetadataRemove.f928b;
                }
                SimpleCacheSpan simpleCacheSpanG = SimpleCacheSpan.g(file2, j, j2, this.d);
                if (simpleCacheSpanG != null) {
                    k(simpleCacheSpanG);
                } else {
                    file2.delete();
                }
            }
        }
    }

    public final void q(CacheSpan cacheSpan) {
        boolean z2;
        CachedContent cachedContentC = this.d.c(cacheSpan.j);
        if (cachedContentC != null) {
            if (cachedContentC.c.remove(cacheSpan)) {
                File file = cacheSpan.n;
                if (file != null) {
                    file.delete();
                }
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.j -= cacheSpan.l;
                if (this.e != null) {
                    String name = cacheSpan.n.getName();
                    try {
                        CacheFileMetadataIndex cacheFileMetadataIndex = this.e;
                        Objects.requireNonNull(cacheFileMetadataIndex.c);
                        try {
                            cacheFileMetadataIndex.f929b.getWritableDatabase().delete(cacheFileMetadataIndex.c, "name = ?", new String[]{name});
                        } catch (SQLException e) {
                            throw new DatabaseIOException(e);
                        }
                    } catch (IOException unused) {
                        String strValueOf = String.valueOf(name);
                        Log.w("SimpleCache", strValueOf.length() != 0 ? "Failed to remove file index entry for: ".concat(strValueOf) : new String("Failed to remove file index entry for: "));
                    }
                }
                this.d.f(cachedContentC.f930b);
                ArrayList<Cache.a> arrayList = this.f.get(cacheSpan.j);
                if (arrayList != null) {
                    int size = arrayList.size();
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        } else {
                            arrayList.get(size).b(this, cacheSpan);
                        }
                    }
                }
                this.c.b(this, cacheSpan);
            }
        }
    }

    public final void r() {
        ArrayList arrayList = new ArrayList();
        Iterator it = Collections.unmodifiableCollection(this.d.a.values()).iterator();
        while (it.hasNext()) {
            for (SimpleCacheSpan simpleCacheSpan : ((CachedContent) it.next()).c) {
                if (simpleCacheSpan.n.length() != simpleCacheSpan.l) {
                    arrayList.add(simpleCacheSpan);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            q((CacheSpan) arrayList.get(i));
        }
    }

    public final SimpleCacheSpan s(String str, SimpleCacheSpan simpleCacheSpan) {
        File file;
        if (!this.h) {
            return simpleCacheSpan;
        }
        File file2 = simpleCacheSpan.n;
        Objects.requireNonNull(file2);
        String name = file2.getName();
        long j = simpleCacheSpan.l;
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z2 = false;
        CacheFileMetadataIndex cacheFileMetadataIndex = this.e;
        if (cacheFileMetadataIndex != null) {
            try {
                cacheFileMetadataIndex.d(name, j, jCurrentTimeMillis);
            } catch (IOException unused) {
                Log.w("SimpleCache", "Failed to update index with new touch timestamp.");
            }
        } else {
            z2 = true;
        }
        CachedContent cachedContent = this.d.a.get(str);
        AnimatableValueParser.D(cachedContent.c.remove(simpleCacheSpan));
        File file3 = simpleCacheSpan.n;
        Objects.requireNonNull(file3);
        if (z2) {
            File parentFile = file3.getParentFile();
            Objects.requireNonNull(parentFile);
            File fileH = SimpleCacheSpan.h(parentFile, cachedContent.a, simpleCacheSpan.k, jCurrentTimeMillis);
            if (file3.renameTo(fileH)) {
                file = fileH;
            } else {
                String strValueOf = String.valueOf(file3);
                String strValueOf2 = String.valueOf(fileH);
                Log.w("CachedContent", outline.l(strValueOf2.length() + strValueOf.length() + 21, "Failed to rename ", strValueOf, " to ", strValueOf2));
                file = file3;
            }
        } else {
            file = file3;
        }
        AnimatableValueParser.D(simpleCacheSpan.m);
        SimpleCacheSpan simpleCacheSpan2 = new SimpleCacheSpan(simpleCacheSpan.j, simpleCacheSpan.k, simpleCacheSpan.l, jCurrentTimeMillis, file);
        cachedContent.c.add(simpleCacheSpan2);
        ArrayList<Cache.a> arrayList = this.f.get(simpleCacheSpan.j);
        if (arrayList != null) {
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                arrayList.get(size).c(this, simpleCacheSpan, simpleCacheSpan2);
            }
        }
        this.c.c(this, simpleCacheSpan, simpleCacheSpan2);
        return simpleCacheSpan2;
    }
}
