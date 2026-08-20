package p007b.p225i.p226a.p242c.p257e3.p258b0;

import android.database.SQLException;
import android.os.ConditionVariable;
import android.util.Log;
import androidx.annotation.Nullable;
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
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p259f3.C2750q;
import p007b.p225i.p226a.p242c.p264u2.InterfaceC2946a;
import p007b.p225i.p355b.p357b.AbstractC4527r;

/* JADX INFO: renamed from: b.i.a.c.e3.b0.r */
/* JADX INFO: compiled from: SimpleCache.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2699r implements Cache {

    /* JADX INFO: renamed from: a */
    public static final HashSet<File> f6506a = new HashSet<>();

    /* JADX INFO: renamed from: b */
    public final File f6507b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC2685d f6508c;

    /* JADX INFO: renamed from: d */
    public final C2691j f6509d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public final C2687f f6510e;

    /* JADX INFO: renamed from: f */
    public final HashMap<String, ArrayList<Cache.InterfaceC10774a>> f6511f;

    /* JADX INFO: renamed from: g */
    public final Random f6512g;

    /* JADX INFO: renamed from: h */
    public final boolean f6513h;

    /* JADX INFO: renamed from: i */
    public long f6514i;

    /* JADX INFO: renamed from: j */
    public long f6515j;

    /* JADX INFO: renamed from: k */
    public Cache.CacheException f6516k;

    public C2699r(File file, InterfaceC2685d interfaceC2685d, InterfaceC2946a interfaceC2946a) {
        boolean zAdd;
        C2691j c2691j = new C2691j(interfaceC2946a, file, null, false, false);
        C2687f c2687f = new C2687f(interfaceC2946a);
        synchronized (C2699r.class) {
            zAdd = f6506a.add(file.getAbsoluteFile());
        }
        if (!zAdd) {
            String strValueOf = String.valueOf(file);
            throw new IllegalStateException(C1643a.m857j(strValueOf.length() + 46, "Another SimpleCache instance uses the folder: ", strValueOf));
        }
        this.f6507b = file;
        this.f6508c = interfaceC2685d;
        this.f6509d = c2691j;
        this.f6510e = c2687f;
        this.f6511f = new HashMap<>();
        this.f6512g = new Random();
        this.f6513h = true;
        this.f6514i = -1L;
        ConditionVariable conditionVariable = new ConditionVariable();
        new C2698q(this, "ExoPlayer:SimpleCacheInit", conditionVariable).start();
        conditionVariable.block();
    }

    /* JADX INFO: renamed from: j */
    public static void m2823j(C2699r c2699r) {
        long j;
        if (!c2699r.f6507b.exists()) {
            try {
                m2824m(c2699r.f6507b);
            } catch (Cache.CacheException e) {
                c2699r.f6516k = e;
                return;
            }
        }
        File[] fileArrListFiles = c2699r.f6507b.listFiles();
        if (fileArrListFiles == null) {
            String strValueOf = String.valueOf(c2699r.f6507b);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 38);
            sb.append("Failed to list cache directory files: ");
            sb.append(strValueOf);
            String string = sb.toString();
            Log.e("SimpleCache", string);
            c2699r.f6516k = new Cache.CacheException(string);
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
        c2699r.f6514i = j;
        if (j == -1) {
            try {
                c2699r.f6514i = m2825n(c2699r.f6507b);
            } catch (IOException e2) {
                String strValueOf3 = String.valueOf(c2699r.f6507b);
                StringBuilder sb3 = new StringBuilder(strValueOf3.length() + 28);
                sb3.append("Failed to create cache UID: ");
                sb3.append(strValueOf3);
                String string2 = sb3.toString();
                C2750q.m3039b("SimpleCache", string2, e2);
                c2699r.f6516k = new Cache.CacheException(string2, e2);
                return;
            }
        }
        try {
            c2699r.f6509d.m2797e(c2699r.f6514i);
            C2687f c2687f = c2699r.f6510e;
            if (c2687f != null) {
                c2687f.m2788b(c2699r.f6514i);
                Map<String, C2686e> mapM2787a = c2699r.f6510e.m2787a();
                c2699r.m2838p(c2699r.f6507b, true, fileArrListFiles, mapM2787a);
                c2699r.f6510e.m2789c(((HashMap) mapM2787a).keySet());
            } else {
                c2699r.m2838p(c2699r.f6507b, true, fileArrListFiles, null);
            }
            C2691j c2691j = c2699r.f6509d;
            Iterator it = AbstractC4527r.m6281m(c2691j.f6478a.keySet()).iterator();
            while (it.hasNext()) {
                c2691j.m2798f((String) it.next());
            }
            try {
                c2699r.f6509d.m2799g();
            } catch (IOException e3) {
                C2750q.m3039b("SimpleCache", "Storing index file failed", e3);
            }
        } catch (IOException e4) {
            String strValueOf4 = String.valueOf(c2699r.f6507b);
            StringBuilder sb4 = new StringBuilder(strValueOf4.length() + 36);
            sb4.append("Failed to initialize cache indices: ");
            sb4.append(strValueOf4);
            String string3 = sb4.toString();
            C2750q.m3039b("SimpleCache", string3, e4);
            c2699r.f6516k = new Cache.CacheException(string3, e4);
        }
    }

    /* JADX INFO: renamed from: m */
    public static void m2824m(File file) throws Cache.CacheException {
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

    /* JADX INFO: renamed from: n */
    public static long m2825n(File file) throws IOException {
        long jNextLong = new SecureRandom().nextLong();
        long jAbs = jNextLong == Long.MIN_VALUE ? 0L : Math.abs(jNextLong);
        String strValueOf = String.valueOf(Long.toString(jAbs, 16));
        File file2 = new File(file, ".uid".length() != 0 ? strValueOf.concat(".uid") : new String(strValueOf));
        if (file2.createNewFile()) {
            return jAbs;
        }
        String strValueOf2 = String.valueOf(file2);
        throw new IOException(C1643a.m857j(strValueOf2.length() + 27, "Failed to create UID file: ", strValueOf2));
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    /* JADX INFO: renamed from: a */
    public synchronized File mo2826a(String str, long j, long j2) throws Cache.CacheException {
        C2690i c2690i;
        File file;
        C1460d.m426D(true);
        m2836l();
        c2690i = this.f6509d.f6478a.get(str);
        Objects.requireNonNull(c2690i);
        C1460d.m426D(c2690i.m2792a(j, j2));
        if (!this.f6507b.exists()) {
            m2824m(this.f6507b);
            m2840r();
        }
        this.f6508c.mo2785a(this, str, j, j2);
        file = new File(this.f6507b, Integer.toString(this.f6512g.nextInt(10)));
        if (!file.exists()) {
            m2824m(file);
        }
        return C2700s.m2843h(file, c2690i.f6471a, j, System.currentTimeMillis());
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    /* JADX INFO: renamed from: b */
    public synchronized InterfaceC2693l mo2827b(String str) {
        C2690i c2690i;
        C1460d.m426D(true);
        c2690i = this.f6509d.f6478a.get(str);
        return c2690i != null ? c2690i.f6475e : C2695n.f6498a;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    /* JADX INFO: renamed from: c */
    public synchronized void mo2828c(String str, C2694m c2694m) throws Cache.CacheException {
        C1460d.m426D(true);
        m2836l();
        C2691j c2691j = this.f6509d;
        C2690i c2690iM2796d = c2691j.m2796d(str);
        C2695n c2695n = c2690iM2796d.f6475e;
        C2695n c2695nM2817a = c2695n.m2817a(c2694m);
        c2690iM2796d.f6475e = c2695nM2817a;
        if (!c2695nM2817a.equals(c2695n)) {
            c2691j.f6482e.mo2804c(c2690iM2796d);
        }
        try {
            this.f6509d.m2799g();
        } catch (IOException e) {
            throw new Cache.CacheException(e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    /* JADX INFO: renamed from: d */
    public synchronized void mo2829d(C2689h c2689h) {
        C1460d.m426D(true);
        m2839q(c2689h);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0059 A[PHI: r20
      0x0059: PHI (r20v6 b.i.a.c.e3.b0.s) = (r20v3 b.i.a.c.e3.b0.s), (r20v7 b.i.a.c.e3.b0.s) binds: [B:23:0x0056, B:18:0x0049] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:26:0x005b A[PHI: r20
      0x005b: PHI (r20v4 b.i.a.c.e3.b0.s) = (r20v3 b.i.a.c.e3.b0.s), (r20v3 b.i.a.c.e3.b0.s), (r20v7 b.i.a.c.e3.b0.s), (r20v7 b.i.a.c.e3.b0.s) binds: [B:21:0x0050, B:24:0x0058, B:16:0x0044, B:19:0x004b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    @Nullable
    /* JADX INFO: renamed from: e */
    public synchronized C2689h mo2830e(String str, long j, long j2) throws Cache.CacheException {
        C2700s c2700s;
        boolean z2;
        boolean z3;
        C1460d.m426D(true);
        m2836l();
        C2700s c2700sM2837o = m2837o(str, j, j2);
        if (c2700sM2837o.f6468m) {
            return m2841s(str, c2700sM2837o);
        }
        C2690i c2690iM2796d = this.f6509d.m2796d(str);
        long j3 = c2700sM2837o.f6467l;
        int i = 0;
        while (true) {
            if (i >= c2690iM2796d.f6474d.size()) {
                c2700s = c2700sM2837o;
                c2690iM2796d.f6474d.add(new C2690i.a(j, j3));
                z2 = true;
                break;
            }
            C2690i.a aVar = c2690iM2796d.f6474d.get(i);
            long j4 = aVar.f6476a;
            if (j4 <= j) {
                c2700s = c2700sM2837o;
                long j5 = aVar.f6477b;
                if (j5 == -1 || j4 + j5 > j) {
                    z3 = true;
                } else {
                    z3 = false;
                }
            } else {
                c2700s = c2700sM2837o;
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
            c2700sM2837o = c2700s;
        }
        if (z2) {
            return c2700s;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    /* JADX INFO: renamed from: f */
    public synchronized C2689h mo2831f(String str, long j, long j2) throws InterruptedException, Cache.CacheException {
        C2689h c2689hMo2830e;
        C1460d.m426D(true);
        m2836l();
        while (true) {
            c2689hMo2830e = mo2830e(str, j, j2);
            if (c2689hMo2830e == null) {
                wait();
            }
        }
        return c2689hMo2830e;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    /* JADX INFO: renamed from: g */
    public synchronized void mo2832g(File file, long j) throws Cache.CacheException {
        boolean z2 = true;
        C1460d.m426D(true);
        if (file.exists()) {
            if (j == 0) {
                file.delete();
                return;
            }
            C2700s c2700sM2842g = C2700s.m2842g(file, j, -9223372036854775807L, this.f6509d);
            Objects.requireNonNull(c2700sM2842g);
            C2690i c2690iM2795c = this.f6509d.m2795c(c2700sM2842g.f6465j);
            Objects.requireNonNull(c2690iM2795c);
            C1460d.m426D(c2690iM2795c.m2792a(c2700sM2842g.f6466k, c2700sM2842g.f6467l));
            long jM2814a = C2692k.m2814a(c2690iM2795c.f6475e);
            if (jM2814a != -1) {
                if (c2700sM2842g.f6466k + c2700sM2842g.f6467l > jM2814a) {
                    z2 = false;
                }
                C1460d.m426D(z2);
            }
            if (this.f6510e == null) {
                m2835k(c2700sM2842g);
                this.f6509d.m2799g();
                notifyAll();
                return;
            }
            try {
                this.f6510e.m2790d(file.getName(), c2700sM2842g.f6467l, c2700sM2842g.f6470o);
                m2835k(c2700sM2842g);
                try {
                    this.f6509d.m2799g();
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
    /* JADX INFO: renamed from: h */
    public synchronized long mo2833h() {
        C1460d.m426D(true);
        return this.f6515j;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    /* JADX INFO: renamed from: i */
    public synchronized void mo2834i(C2689h c2689h) {
        C1460d.m426D(true);
        C2690i c2690iM2795c = this.f6509d.m2795c(c2689h.f6465j);
        Objects.requireNonNull(c2690iM2795c);
        long j = c2689h.f6466k;
        for (int i = 0; i < c2690iM2795c.f6474d.size(); i++) {
            if (c2690iM2795c.f6474d.get(i).f6476a == j) {
                c2690iM2795c.f6474d.remove(i);
                this.f6509d.m2798f(c2690iM2795c.f6472b);
                notifyAll();
            }
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: renamed from: k */
    public final void m2835k(C2700s c2700s) {
        this.f6509d.m2796d(c2700s.f6465j).f6473c.add(c2700s);
        this.f6515j += c2700s.f6467l;
        ArrayList<Cache.InterfaceC10774a> arrayList = this.f6511f.get(c2700s.f6465j);
        if (arrayList != null) {
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                } else {
                    arrayList.get(size).mo2820d(this, c2700s);
                }
            }
        }
        this.f6508c.mo2820d(this, c2700s);
    }

    /* JADX INFO: renamed from: l */
    public synchronized void m2836l() throws Cache.CacheException {
        Cache.CacheException cacheException = this.f6516k;
        if (cacheException != null) {
            throw cacheException;
        }
    }

    /* JADX INFO: renamed from: o */
    public final C2700s m2837o(String str, long j, long j2) {
        C2700s c2700sFloor;
        long j3;
        C2690i c2690i = this.f6509d.f6478a.get(str);
        if (c2690i == null) {
            return new C2700s(str, j, j2, -9223372036854775807L, null);
        }
        while (true) {
            C2700s c2700s = new C2700s(c2690i.f6472b, j, -1L, -9223372036854775807L, null);
            c2700sFloor = c2690i.f6473c.floor(c2700s);
            if (c2700sFloor == null || c2700sFloor.f6466k + c2700sFloor.f6467l <= j) {
                C2700s c2700sCeiling = c2690i.f6473c.ceiling(c2700s);
                if (c2700sCeiling != null) {
                    long jMin = c2700sCeiling.f6466k - j;
                    if (j2 != -1) {
                        jMin = Math.min(jMin, j2);
                    }
                    j3 = jMin;
                } else {
                    j3 = j2;
                }
                c2700sFloor = new C2700s(c2690i.f6472b, j, j3, -9223372036854775807L, null);
            }
            if (!c2700sFloor.f6468m || c2700sFloor.f6469n.length() == c2700sFloor.f6467l) {
                break;
            }
            m2840r();
        }
        return c2700sFloor;
    }

    /* JADX INFO: renamed from: p */
    public final void m2838p(File file, boolean z2, @Nullable File[] fileArr, @Nullable Map<String, C2686e> map) {
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
                m2838p(file2, false, file2.listFiles(), map);
            } else if (!z2 || (!name.startsWith("cached_content_index.exi") && !name.endsWith(".uid"))) {
                long j = -1;
                long j2 = -9223372036854775807L;
                C2686e c2686eRemove = map != null ? map.remove(name) : null;
                if (c2686eRemove != null) {
                    j = c2686eRemove.f6459a;
                    j2 = c2686eRemove.f6460b;
                }
                C2700s c2700sM2842g = C2700s.m2842g(file2, j, j2, this.f6509d);
                if (c2700sM2842g != null) {
                    m2835k(c2700sM2842g);
                } else {
                    file2.delete();
                }
            }
        }
    }

    /* JADX INFO: renamed from: q */
    public final void m2839q(C2689h c2689h) {
        boolean z2;
        C2690i c2690iM2795c = this.f6509d.m2795c(c2689h.f6465j);
        if (c2690iM2795c != null) {
            if (c2690iM2795c.f6473c.remove(c2689h)) {
                File file = c2689h.f6469n;
                if (file != null) {
                    file.delete();
                }
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.f6515j -= c2689h.f6467l;
                if (this.f6510e != null) {
                    String name = c2689h.f6469n.getName();
                    try {
                        C2687f c2687f = this.f6510e;
                        Objects.requireNonNull(c2687f.f6463c);
                        try {
                            c2687f.f6462b.getWritableDatabase().delete(c2687f.f6463c, "name = ?", new String[]{name});
                        } catch (SQLException e) {
                            throw new DatabaseIOException(e);
                        }
                    } catch (IOException unused) {
                        String strValueOf = String.valueOf(name);
                        Log.w("SimpleCache", strValueOf.length() != 0 ? "Failed to remove file index entry for: ".concat(strValueOf) : new String("Failed to remove file index entry for: "));
                    }
                }
                this.f6509d.m2798f(c2690iM2795c.f6472b);
                ArrayList<Cache.InterfaceC10774a> arrayList = this.f6511f.get(c2689h.f6465j);
                if (arrayList != null) {
                    int size = arrayList.size();
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        } else {
                            arrayList.get(size).mo2818b(this, c2689h);
                        }
                    }
                }
                this.f6508c.mo2818b(this, c2689h);
            }
        }
    }

    /* JADX INFO: renamed from: r */
    public final void m2840r() {
        ArrayList arrayList = new ArrayList();
        Iterator it = Collections.unmodifiableCollection(this.f6509d.f6478a.values()).iterator();
        while (it.hasNext()) {
            for (C2700s c2700s : ((C2690i) it.next()).f6473c) {
                if (c2700s.f6469n.length() != c2700s.f6467l) {
                    arrayList.add(c2700s);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            m2839q((C2689h) arrayList.get(i));
        }
    }

    /* JADX INFO: renamed from: s */
    public final C2700s m2841s(String str, C2700s c2700s) {
        File file;
        if (!this.f6513h) {
            return c2700s;
        }
        File file2 = c2700s.f6469n;
        Objects.requireNonNull(file2);
        String name = file2.getName();
        long j = c2700s.f6467l;
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z2 = false;
        C2687f c2687f = this.f6510e;
        if (c2687f != null) {
            try {
                c2687f.m2790d(name, j, jCurrentTimeMillis);
            } catch (IOException unused) {
                Log.w("SimpleCache", "Failed to update index with new touch timestamp.");
            }
        } else {
            z2 = true;
        }
        C2690i c2690i = this.f6509d.f6478a.get(str);
        C1460d.m426D(c2690i.f6473c.remove(c2700s));
        File file3 = c2700s.f6469n;
        Objects.requireNonNull(file3);
        if (z2) {
            File parentFile = file3.getParentFile();
            Objects.requireNonNull(parentFile);
            File fileM2843h = C2700s.m2843h(parentFile, c2690i.f6471a, c2700s.f6466k, jCurrentTimeMillis);
            if (file3.renameTo(fileM2843h)) {
                file = fileM2843h;
            } else {
                String strValueOf = String.valueOf(file3);
                String strValueOf2 = String.valueOf(fileM2843h);
                Log.w("CachedContent", C1643a.m861l(strValueOf2.length() + strValueOf.length() + 21, "Failed to rename ", strValueOf, " to ", strValueOf2));
                file = file3;
            }
        } else {
            file = file3;
        }
        C1460d.m426D(c2700s.f6468m);
        C2700s c2700s2 = new C2700s(c2700s.f6465j, c2700s.f6466k, c2700s.f6467l, jCurrentTimeMillis, file);
        c2690i.f6473c.add(c2700s2);
        ArrayList<Cache.InterfaceC10774a> arrayList = this.f6511f.get(c2700s.f6465j);
        if (arrayList != null) {
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                arrayList.get(size).mo2819c(this, c2700s, c2700s2);
            }
        }
        this.f6508c.mo2819c(this, c2700s, c2700s2);
        return c2700s2;
    }
}
