package p007b.p109f.p111b.p113b;

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
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p110a.C1650a;
import p007b.p109f.p111b.p112a.C1653c;
import p007b.p109f.p111b.p112a.C1654d;
import p007b.p109f.p111b.p112a.C1655e;
import p007b.p109f.p111b.p112a.InterfaceC1651a;
import p007b.p109f.p111b.p112a.InterfaceC1652b;
import p007b.p109f.p111b.p112a.InterfaceC1657g;
import p007b.p109f.p111b.p113b.C1658a;
import p007b.p109f.p111b.p113b.InterfaceC1660c;
import p007b.p109f.p115d.p116a.InterfaceC1668a;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p115d.p124i.C1710a;
import p007b.p109f.p115d.p126k.C1715c;
import p007b.p109f.p115d.p126k.InterfaceC1713a;

/* JADX INFO: renamed from: b.f.b.b.d */
/* JADX INFO: compiled from: DiskStorageCache.java */
/* JADX INFO: loaded from: classes.dex */
public class C1661d implements InterfaceC1665h {

    /* JADX INFO: renamed from: a */
    public static final long f3041a = TimeUnit.HOURS.toMillis(2);

    /* JADX INFO: renamed from: b */
    public static final long f3042b = TimeUnit.MINUTES.toMillis(30);

    /* JADX INFO: renamed from: c */
    public final long f3043c;

    /* JADX INFO: renamed from: d */
    public final long f3044d;

    /* JADX INFO: renamed from: e */
    public final CountDownLatch f3045e;

    /* JADX INFO: renamed from: f */
    public long f3046f;

    /* JADX INFO: renamed from: g */
    public final InterfaceC1652b f3047g;

    /* JADX INFO: renamed from: h */
    @VisibleForTesting
    public final Set<String> f3048h;

    /* JADX INFO: renamed from: i */
    public long f3049i;

    /* JADX INFO: renamed from: j */
    public final C1710a f3050j;

    /* JADX INFO: renamed from: k */
    public final InterfaceC1660c f3051k;

    /* JADX INFO: renamed from: l */
    public final InterfaceC1664g f3052l;

    /* JADX INFO: renamed from: m */
    public final InterfaceC1651a f3053m;

    /* JADX INFO: renamed from: n */
    public final boolean f3054n;

    /* JADX INFO: renamed from: o */
    public final b f3055o;

    /* JADX INFO: renamed from: p */
    public final InterfaceC1713a f3056p;

    /* JADX INFO: renamed from: q */
    public final Object f3057q = new Object();

    /* JADX INFO: renamed from: b.f.b.b.d$a */
    /* JADX INFO: compiled from: DiskStorageCache.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (C1661d.this.f3057q) {
                C1661d.this.m953e();
            }
            Objects.requireNonNull(C1661d.this);
            C1661d.this.f3045e.countDown();
        }
    }

    /* JADX INFO: renamed from: b.f.b.b.d$b */
    /* JADX INFO: compiled from: DiskStorageCache.java */
    @VisibleForTesting
    public static class b {

        /* JADX INFO: renamed from: a */
        public boolean f3059a = false;

        /* JADX INFO: renamed from: b */
        public long f3060b = -1;

        /* JADX INFO: renamed from: c */
        public long f3061c = -1;

        /* JADX INFO: renamed from: a */
        public synchronized long m957a() {
            return this.f3060b;
        }

        /* JADX INFO: renamed from: b */
        public synchronized void m958b(long j, long j2) {
            if (this.f3059a) {
                this.f3060b += j;
                this.f3061c += j2;
            }
        }
    }

    /* JADX INFO: renamed from: b.f.b.b.d$c */
    /* JADX INFO: compiled from: DiskStorageCache.java */
    public static class c {

        /* JADX INFO: renamed from: a */
        public final long f3062a;

        /* JADX INFO: renamed from: b */
        public final long f3063b;

        /* JADX INFO: renamed from: c */
        public final long f3064c;

        public c(long j, long j2, long j3) {
            this.f3062a = j;
            this.f3063b = j2;
            this.f3064c = j3;
        }
    }

    public C1661d(InterfaceC1660c interfaceC1660c, InterfaceC1664g interfaceC1664g, c cVar, InterfaceC1652b interfaceC1652b, InterfaceC1651a interfaceC1651a, InterfaceC1668a interfaceC1668a, Executor executor, boolean z2) {
        C1710a c1710a;
        this.f3043c = cVar.f3063b;
        long j = cVar.f3064c;
        this.f3044d = j;
        this.f3046f = j;
        C1710a c1710a2 = C1710a.f3119a;
        synchronized (C1710a.class) {
            if (C1710a.f3119a == null) {
                C1710a.f3119a = new C1710a();
            }
            c1710a = C1710a.f3119a;
        }
        this.f3050j = c1710a;
        this.f3051k = interfaceC1660c;
        this.f3052l = interfaceC1664g;
        this.f3049i = -1L;
        this.f3047g = interfaceC1652b;
        this.f3053m = interfaceC1651a;
        this.f3055o = new b();
        this.f3056p = C1715c.f3133a;
        this.f3054n = z2;
        this.f3048h = new HashSet();
        if (!z2) {
            this.f3045e = new CountDownLatch(0);
        } else {
            this.f3045e = new CountDownLatch(1);
            executor.execute(new a());
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m949a(long j, int i) throws IOException {
        try {
            Collection<InterfaceC1660c.a> collectionM951c = m951c(this.f3051k.mo936e());
            long jM957a = this.f3055o.m957a() - j;
            int i2 = 0;
            long j2 = 0;
            for (InterfaceC1660c.a aVar : (ArrayList) collectionM951c) {
                if (j2 > jM957a) {
                    break;
                }
                long jMo938g = this.f3051k.mo938g(aVar);
                this.f3048h.remove(aVar.getId());
                if (jMo938g > 0) {
                    i2++;
                    j2 += jMo938g;
                    C1666i c1666iM961a = C1666i.m961a();
                    aVar.getId();
                    Objects.requireNonNull((C1655e) this.f3047g);
                    c1666iM961a.m962b();
                }
            }
            this.f3055o.m958b(-j2, -i2);
            this.f3051k.mo932a();
        } catch (IOException e) {
            InterfaceC1651a interfaceC1651a = this.f3053m;
            e.getMessage();
            Objects.requireNonNull((C1654d) interfaceC1651a);
            throw e;
        }
    }

    /* JADX INFO: renamed from: b */
    public C1650a m950b(CacheKey cacheKey) {
        C1650a c1650aMo935d;
        C1666i c1666iM961a = C1666i.m961a();
        c1666iM961a.f3075d = cacheKey;
        try {
            try {
                synchronized (this.f3057q) {
                    List<String> listM596z0 = C1460d.m596z0(cacheKey);
                    int i = 0;
                    String str = null;
                    c1650aMo935d = null;
                    while (true) {
                        ArrayList arrayList = (ArrayList) listM596z0;
                        if (i >= arrayList.size() || (c1650aMo935d = this.f3051k.mo935d((str = (String) arrayList.get(i)), cacheKey)) != null) {
                            break;
                            break;
                        }
                        i++;
                    }
                    if (c1650aMo935d == null) {
                        Objects.requireNonNull((C1655e) this.f3047g);
                        this.f3048h.remove(str);
                    } else {
                        Objects.requireNonNull(str);
                        Objects.requireNonNull((C1655e) this.f3047g);
                        this.f3048h.add(str);
                    }
                }
                c1666iM961a.m962b();
                return c1650aMo935d;
            } catch (IOException unused) {
                Objects.requireNonNull((C1654d) this.f3053m);
                Objects.requireNonNull((C1655e) this.f3047g);
                c1666iM961a.m962b();
                return null;
            }
        } catch (Throwable th) {
            c1666iM961a.m962b();
            throw th;
        }
    }

    /* JADX INFO: renamed from: c */
    public final Collection<InterfaceC1660c.a> m951c(Collection<InterfaceC1660c.a> collection) {
        Objects.requireNonNull((C1715c) this.f3056p);
        long jCurrentTimeMillis = System.currentTimeMillis() + f3041a;
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (InterfaceC1660c.a aVar : collection) {
            if (aVar.mo945a() > jCurrentTimeMillis) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.f3052l.get());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    /* JADX INFO: renamed from: d */
    public C1650a m952d(CacheKey cacheKey, InterfaceC1657g interfaceC1657g) throws IOException {
        String strM485W1;
        C1650a c1650aM947b;
        C1666i c1666iM961a = C1666i.m961a();
        c1666iM961a.f3075d = cacheKey;
        Objects.requireNonNull((C1655e) this.f3047g);
        synchronized (this.f3057q) {
            try {
                try {
                    if (cacheKey instanceof C1653c) {
                        throw null;
                    }
                    strM485W1 = C1460d.m485W1(cacheKey);
                    try {
                    } catch (Throwable th) {
                        c1666iM961a.m962b();
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
            InterfaceC1660c.b bVarM955g = m955g(strM485W1, cacheKey);
            try {
                C1658a.f fVar = (C1658a.f) bVarM955g;
                fVar.m948c(interfaceC1657g, cacheKey);
                synchronized (this.f3057q) {
                    c1650aM947b = fVar.m947b(cacheKey);
                    this.f3048h.add(strM485W1);
                    this.f3055o.m958b(c1650aM947b.m928a(), 1L);
                }
                c1650aM947b.m928a();
                this.f3055o.m957a();
                Objects.requireNonNull((C1655e) this.f3047g);
                if (!fVar.m946a()) {
                    C1691a.m973a(C1661d.class, "Failed to delete temp file");
                }
                c1666iM961a.m962b();
                return c1650aM947b;
            } catch (Throwable th3) {
                if (!((C1658a.f) bVarM955g).m946a()) {
                    C1691a.m973a(C1661d.class, "Failed to delete temp file");
                }
                throw th3;
            }
        } catch (IOException e2) {
            Objects.requireNonNull((C1655e) this.f3047g);
            C1691a.m974b(C1661d.class, "Failed inserting a file into the cache", e2);
            throw e2;
        }
    }

    /* JADX INFO: renamed from: e */
    public final boolean m953e() {
        boolean z2;
        long j;
        long j2;
        Objects.requireNonNull((C1715c) this.f3056p);
        long jCurrentTimeMillis = System.currentTimeMillis();
        b bVar = this.f3055o;
        synchronized (bVar) {
            z2 = bVar.f3059a;
        }
        long jMax = -1;
        if (z2) {
            long j3 = this.f3049i;
            if (j3 != -1 && jCurrentTimeMillis - j3 <= f3042b) {
                return false;
            }
        }
        Objects.requireNonNull((C1715c) this.f3056p);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        long j4 = f3041a + jCurrentTimeMillis2;
        Set<String> hashSet = (this.f3054n && this.f3048h.isEmpty()) ? this.f3048h : this.f3054n ? new HashSet<>() : null;
        try {
            long size = 0;
            boolean z3 = false;
            int i = 0;
            for (InterfaceC1660c.a aVar : this.f3051k.mo936e()) {
                i++;
                size += aVar.getSize();
                if (aVar.mo945a() > j4) {
                    aVar.getSize();
                    j2 = j4;
                    jMax = Math.max(aVar.mo945a() - jCurrentTimeMillis2, jMax);
                    z3 = true;
                } else {
                    j2 = j4;
                    if (this.f3054n) {
                        Objects.requireNonNull(hashSet);
                        hashSet.add(aVar.getId());
                    }
                }
                j4 = j2;
            }
            if (z3) {
                Objects.requireNonNull((C1654d) this.f3053m);
            }
            b bVar2 = this.f3055o;
            synchronized (bVar2) {
                j = bVar2.f3061c;
            }
            long j5 = i;
            if (j != j5 || this.f3055o.m957a() != size) {
                if (this.f3054n && this.f3048h != hashSet) {
                    Objects.requireNonNull(hashSet);
                    this.f3048h.clear();
                    this.f3048h.addAll(hashSet);
                }
                b bVar3 = this.f3055o;
                synchronized (bVar3) {
                    bVar3.f3061c = j5;
                    bVar3.f3060b = size;
                    bVar3.f3059a = true;
                }
            }
            this.f3049i = jCurrentTimeMillis2;
            return true;
        } catch (IOException e) {
            InterfaceC1651a interfaceC1651a = this.f3053m;
            e.getMessage();
            Objects.requireNonNull((C1654d) interfaceC1651a);
            return false;
        }
    }

    /* JADX INFO: renamed from: f */
    public void m954f(CacheKey cacheKey) {
        synchronized (this.f3057q) {
            try {
                List<String> listM596z0 = C1460d.m596z0(cacheKey);
                int i = 0;
                while (true) {
                    ArrayList arrayList = (ArrayList) listM596z0;
                    if (i >= arrayList.size()) {
                        break;
                    }
                    String str = (String) arrayList.get(i);
                    this.f3051k.mo937f(str);
                    this.f3048h.remove(str);
                    i++;
                }
            } catch (IOException e) {
                InterfaceC1651a interfaceC1651a = this.f3053m;
                e.getMessage();
                Objects.requireNonNull((C1654d) interfaceC1651a);
            }
        }
    }

    /* JADX INFO: renamed from: g */
    public final InterfaceC1660c.b m955g(String str, CacheKey cacheKey) throws IOException {
        synchronized (this.f3057q) {
            boolean zM953e = m953e();
            m956h();
            long jM957a = this.f3055o.m957a();
            if (jM957a > this.f3046f && !zM953e) {
                b bVar = this.f3055o;
                synchronized (bVar) {
                    bVar.f3059a = false;
                    bVar.f3061c = -1L;
                    bVar.f3060b = -1L;
                }
                m953e();
            }
            long j = this.f3046f;
            if (jM957a > j) {
                m949a((j * 9) / 10, 1);
            }
        }
        return this.f3051k.mo933b(str, cacheKey);
    }

    /* JADX INFO: renamed from: h */
    public final void m956h() {
        long availableBlocksLong;
        boolean z2 = true;
        char c2 = this.f3051k.isExternal() ? (char) 2 : (char) 1;
        C1710a c1710a = this.f3050j;
        long jM957a = this.f3044d - this.f3055o.m957a();
        c1710a.m1000a();
        c1710a.m1000a();
        if (c1710a.f3126h.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - c1710a.f3125g > C1710a.f3120b) {
                    c1710a.m1001b();
                }
                c1710a.f3126h.unlock();
            } catch (Throwable th) {
                c1710a.f3126h.unlock();
                throw th;
            }
        }
        StatFs statFs = c2 == 1 ? c1710a.f3121c : c1710a.f3123e;
        if (statFs != null) {
            availableBlocksLong = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
        } else {
            availableBlocksLong = 0;
        }
        if (availableBlocksLong > 0 && availableBlocksLong >= jM957a) {
            z2 = false;
        }
        if (z2) {
            this.f3046f = this.f3043c;
        } else {
            this.f3046f = this.f3044d;
        }
    }
}
