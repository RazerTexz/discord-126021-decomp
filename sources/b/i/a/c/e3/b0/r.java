package b.i.a.c.e3.b0;

import android.database.SQLException;
import android.os.ConditionVariable;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.Cache$CacheException;
import com.google.android.exoplayer2.upstream.cache.Cache$a;
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

/* JADX INFO: compiled from: SimpleCache.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements Cache {
    public static final HashSet<File> a = new HashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f938b;
    public final d c;
    public final j d;

    @Nullable
    public final f e;
    public final HashMap<String, ArrayList<Cache$a>> f;
    public final Random g;
    public final boolean h;
    public long i;
    public long j;
    public Cache$CacheException k;

    public r(File file, d dVar, b.i.a.c.u2.a aVar) {
        boolean zAdd;
        j jVar = new j(aVar, file, null, false, false);
        f fVar = new f(aVar);
        synchronized (r.class) {
            zAdd = a.add(file.getAbsoluteFile());
        }
        if (!zAdd) {
            String strValueOf = String.valueOf(file);
            throw new IllegalStateException(b.d.b.a.a.j(strValueOf.length() + 46, "Another SimpleCache instance uses the folder: ", strValueOf));
        }
        this.f938b = file;
        this.c = dVar;
        this.d = jVar;
        this.e = fVar;
        this.f = new HashMap<>();
        this.g = new Random();
        this.h = true;
        this.i = -1L;
        ConditionVariable conditionVariable = new ConditionVariable();
        new q(this, "ExoPlayer:SimpleCacheInit", conditionVariable).start();
        conditionVariable.block();
    }

    public static void j(r rVar) {
        long j;
        if (!rVar.f938b.exists()) {
            try {
                m(rVar.f938b);
            } catch (Cache$CacheException e) {
                rVar.k = e;
                return;
            }
        }
        File[] fileArrListFiles = rVar.f938b.listFiles();
        if (fileArrListFiles == null) {
            String strValueOf = String.valueOf(rVar.f938b);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 38);
            sb.append("Failed to list cache directory files: ");
            sb.append(strValueOf);
            String string = sb.toString();
            Log.e("SimpleCache", string);
            rVar.k = new Cache$CacheException(string);
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
        rVar.i = j;
        if (j == -1) {
            try {
                rVar.i = n(rVar.f938b);
            } catch (IOException e2) {
                String strValueOf3 = String.valueOf(rVar.f938b);
                StringBuilder sb3 = new StringBuilder(strValueOf3.length() + 28);
                sb3.append("Failed to create cache UID: ");
                sb3.append(strValueOf3);
                String string2 = sb3.toString();
                b.i.a.c.f3.q.b("SimpleCache", string2, e2);
                rVar.k = new Cache$CacheException(string2, e2);
                return;
            }
        }
        try {
            rVar.d.e(rVar.i);
            f fVar = rVar.e;
            if (fVar != null) {
                fVar.b(rVar.i);
                Map<String, e> mapA = rVar.e.a();
                rVar.p(rVar.f938b, true, fileArrListFiles, mapA);
                rVar.e.c(((HashMap) mapA).keySet());
            } else {
                rVar.p(rVar.f938b, true, fileArrListFiles, null);
            }
            j jVar = rVar.d;
            Iterator itJ = b.i.b.b.r.m(jVar.a.keySet()).j();
            while (itJ.hasNext()) {
                jVar.f((String) itJ.next());
            }
            try {
                rVar.d.g();
            } catch (IOException e3) {
                b.i.a.c.f3.q.b("SimpleCache", "Storing index file failed", e3);
            }
        } catch (IOException e4) {
            String strValueOf4 = String.valueOf(rVar.f938b);
            StringBuilder sb4 = new StringBuilder(strValueOf4.length() + 36);
            sb4.append("Failed to initialize cache indices: ");
            sb4.append(strValueOf4);
            String string3 = sb4.toString();
            b.i.a.c.f3.q.b("SimpleCache", string3, e4);
            rVar.k = new Cache$CacheException(string3, e4);
        }
    }

    public static void m(File file) throws Cache$CacheException {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String strValueOf = String.valueOf(file);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 34);
        sb.append("Failed to create cache directory: ");
        sb.append(strValueOf);
        String string = sb.toString();
        Log.e("SimpleCache", string);
        throw new Cache$CacheException(string);
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
        throw new IOException(b.d.b.a.a.j(strValueOf2.length() + 27, "Failed to create UID file: ", strValueOf2));
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized File a(String str, long j, long j2) throws Cache$CacheException {
        i iVar;
        File file;
        b.c.a.a0.d.D(true);
        l();
        iVar = this.d.a.get(str);
        Objects.requireNonNull(iVar);
        b.c.a.a0.d.D(iVar.a(j, j2));
        if (!this.f938b.exists()) {
            m(this.f938b);
            r();
        }
        this.c.a(this, str, j, j2);
        file = new File(this.f938b, Integer.toString(this.g.nextInt(10)));
        if (!file.exists()) {
            m(file);
        }
        return s.h(file, iVar.a, j, System.currentTimeMillis());
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized l b(String str) {
        i iVar;
        b.c.a.a0.d.D(true);
        iVar = this.d.a.get(str);
        return iVar != null ? iVar.e : n.a;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void c(String str, m mVar) throws Cache$CacheException {
        b.c.a.a0.d.D(true);
        l();
        j jVar = this.d;
        i iVarD = jVar.d(str);
        n nVar = iVarD.e;
        n nVarA = nVar.a(mVar);
        iVarD.e = nVarA;
        if (!nVarA.equals(nVar)) {
            jVar.e.c(iVarD);
        }
        try {
            this.d.g();
        } catch (IOException e) {
            throw new Cache$CacheException(e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void d(h hVar) {
        b.c.a.a0.d.D(true);
        q(hVar);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0059 A[PHI: r20
      0x0059: PHI (r20v6 b.i.a.c.e3.b0.s) = (r20v3 b.i.a.c.e3.b0.s), (r20v7 b.i.a.c.e3.b0.s) binds: [B:23:0x0056, B:18:0x0049] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:26:0x005b A[PHI: r20
      0x005b: PHI (r20v4 b.i.a.c.e3.b0.s) = (r20v3 b.i.a.c.e3.b0.s), (r20v3 b.i.a.c.e3.b0.s), (r20v7 b.i.a.c.e3.b0.s), (r20v7 b.i.a.c.e3.b0.s) binds: [B:21:0x0050, B:24:0x0058, B:16:0x0044, B:19:0x004b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    @Nullable
    public synchronized h e(String str, long j, long j2) throws Cache$CacheException {
        s sVar;
        boolean z2;
        boolean z3;
        b.c.a.a0.d.D(true);
        l();
        s sVarO = o(str, j, j2);
        if (sVarO.m) {
            return s(str, sVarO);
        }
        i iVarD = this.d.d(str);
        long j3 = sVarO.l;
        int i = 0;
        while (true) {
            if (i >= iVarD.d.size()) {
                sVar = sVarO;
                iVarD.d.add(new i$a(j, j3));
                z2 = true;
                break;
            }
            i$a i_a = iVarD.d.get(i);
            long j4 = i_a.a;
            if (j4 <= j) {
                sVar = sVarO;
                long j5 = i_a.f931b;
                if (j5 == -1 || j4 + j5 > j) {
                    z3 = true;
                } else {
                    z3 = false;
                }
            } else {
                sVar = sVarO;
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
            sVarO = sVar;
        }
        if (z2) {
            return sVar;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized h f(String str, long j, long j2) throws InterruptedException, Cache$CacheException {
        h hVarE;
        b.c.a.a0.d.D(true);
        l();
        while (true) {
            hVarE = e(str, j, j2);
            if (hVarE == null) {
                wait();
            }
        }
        return hVarE;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void g(File file, long j) throws Cache$CacheException {
        boolean z2 = true;
        b.c.a.a0.d.D(true);
        if (file.exists()) {
            if (j == 0) {
                file.delete();
                return;
            }
            s sVarG = s.g(file, j, -9223372036854775807L, this.d);
            Objects.requireNonNull(sVarG);
            i iVarC = this.d.c(sVarG.j);
            Objects.requireNonNull(iVarC);
            b.c.a.a0.d.D(iVarC.a(sVarG.k, sVarG.l));
            long jA = k.a(iVarC.e);
            if (jA != -1) {
                if (sVarG.k + sVarG.l > jA) {
                    z2 = false;
                }
                b.c.a.a0.d.D(z2);
            }
            if (this.e == null) {
                k(sVarG);
                this.d.g();
                notifyAll();
                return;
            }
            try {
                this.e.d(file.getName(), sVarG.l, sVarG.o);
                k(sVarG);
                try {
                    this.d.g();
                    notifyAll();
                    return;
                } catch (IOException e) {
                    throw new Cache$CacheException(e);
                }
            } catch (IOException e2) {
                throw new Cache$CacheException(e2);
            }
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long h() {
        b.c.a.a0.d.D(true);
        return this.j;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void i(h hVar) {
        b.c.a.a0.d.D(true);
        i iVarC = this.d.c(hVar.j);
        Objects.requireNonNull(iVarC);
        long j = hVar.k;
        for (int i = 0; i < iVarC.d.size(); i++) {
            if (iVarC.d.get(i).a == j) {
                iVarC.d.remove(i);
                this.d.f(iVarC.f930b);
                notifyAll();
            }
        }
        throw new IllegalStateException();
    }

    public final void k(s sVar) {
        this.d.d(sVar.j).c.add(sVar);
        this.j += sVar.l;
        ArrayList<Cache$a> arrayList = this.f.get(sVar.j);
        if (arrayList != null) {
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                } else {
                    arrayList.get(size).d(this, sVar);
                }
            }
        }
        this.c.d(this, sVar);
    }

    public synchronized void l() throws Cache$CacheException {
        Cache$CacheException cache$CacheException = this.k;
        if (cache$CacheException != null) {
            throw cache$CacheException;
        }
    }

    public final s o(String str, long j, long j2) {
        s sVarFloor;
        long j3;
        i iVar = this.d.a.get(str);
        if (iVar == null) {
            return new s(str, j, j2, -9223372036854775807L, null);
        }
        while (true) {
            s sVar = new s(iVar.f930b, j, -1L, -9223372036854775807L, null);
            sVarFloor = iVar.c.floor(sVar);
            if (sVarFloor == null || sVarFloor.k + sVarFloor.l <= j) {
                s sVarCeiling = iVar.c.ceiling(sVar);
                if (sVarCeiling != null) {
                    long jMin = sVarCeiling.k - j;
                    if (j2 != -1) {
                        jMin = Math.min(jMin, j2);
                    }
                    j3 = jMin;
                } else {
                    j3 = j2;
                }
                sVarFloor = new s(iVar.f930b, j, j3, -9223372036854775807L, null);
            }
            if (!sVarFloor.m || sVarFloor.n.length() == sVarFloor.l) {
                break;
            }
            r();
        }
        return sVarFloor;
    }

    public final void p(File file, boolean z2, @Nullable File[] fileArr, @Nullable Map<String, e> map) {
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
                e eVarRemove = map != null ? map.remove(name) : null;
                if (eVarRemove != null) {
                    j = eVarRemove.a;
                    j2 = eVarRemove.f928b;
                }
                s sVarG = s.g(file2, j, j2, this.d);
                if (sVarG != null) {
                    k(sVarG);
                } else {
                    file2.delete();
                }
            }
        }
    }

    public final void q(h hVar) {
        boolean z2;
        i iVarC = this.d.c(hVar.j);
        if (iVarC != null) {
            if (iVarC.c.remove(hVar)) {
                File file = hVar.n;
                if (file != null) {
                    file.delete();
                }
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.j -= hVar.l;
                if (this.e != null) {
                    String name = hVar.n.getName();
                    try {
                        f fVar = this.e;
                        Objects.requireNonNull(fVar.c);
                        try {
                            fVar.f929b.getWritableDatabase().delete(fVar.c, "name = ?", new String[]{name});
                        } catch (SQLException e) {
                            throw new DatabaseIOException(e);
                        }
                    } catch (IOException unused) {
                        String strValueOf = String.valueOf(name);
                        Log.w("SimpleCache", strValueOf.length() != 0 ? "Failed to remove file index entry for: ".concat(strValueOf) : new String("Failed to remove file index entry for: "));
                    }
                }
                this.d.f(iVarC.f930b);
                ArrayList<Cache$a> arrayList = this.f.get(hVar.j);
                if (arrayList != null) {
                    int size = arrayList.size();
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        } else {
                            arrayList.get(size).b(this, hVar);
                        }
                    }
                }
                this.c.b(this, hVar);
            }
        }
    }

    public final void r() {
        ArrayList arrayList = new ArrayList();
        Iterator it = Collections.unmodifiableCollection(this.d.a.values()).iterator();
        while (it.hasNext()) {
            for (s sVar : ((i) it.next()).c) {
                if (sVar.n.length() != sVar.l) {
                    arrayList.add(sVar);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            q((h) arrayList.get(i));
        }
    }

    public final s s(String str, s sVar) {
        File file;
        if (!this.h) {
            return sVar;
        }
        File file2 = sVar.n;
        Objects.requireNonNull(file2);
        String name = file2.getName();
        long j = sVar.l;
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z2 = false;
        f fVar = this.e;
        if (fVar != null) {
            try {
                fVar.d(name, j, jCurrentTimeMillis);
            } catch (IOException unused) {
                Log.w("SimpleCache", "Failed to update index with new touch timestamp.");
            }
        } else {
            z2 = true;
        }
        i iVar = this.d.a.get(str);
        b.c.a.a0.d.D(iVar.c.remove(sVar));
        File file3 = sVar.n;
        Objects.requireNonNull(file3);
        if (z2) {
            File parentFile = file3.getParentFile();
            Objects.requireNonNull(parentFile);
            File fileH = s.h(parentFile, iVar.a, sVar.k, jCurrentTimeMillis);
            if (file3.renameTo(fileH)) {
                file = fileH;
            } else {
                String strValueOf = String.valueOf(file3);
                String strValueOf2 = String.valueOf(fileH);
                Log.w("CachedContent", b.d.b.a.a.l(strValueOf2.length() + strValueOf.length() + 21, "Failed to rename ", strValueOf, " to ", strValueOf2));
                file = file3;
            }
        } else {
            file = file3;
        }
        b.c.a.a0.d.D(sVar.m);
        s sVar2 = new s(sVar.j, sVar.k, sVar.l, jCurrentTimeMillis, file);
        iVar.c.add(sVar2);
        ArrayList<Cache$a> arrayList = this.f.get(sVar.j);
        if (arrayList != null) {
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                arrayList.get(size).c(this, sVar, sVar2);
            }
        }
        this.c.c(this, sVar, sVar2);
        return sVar2;
    }
}
