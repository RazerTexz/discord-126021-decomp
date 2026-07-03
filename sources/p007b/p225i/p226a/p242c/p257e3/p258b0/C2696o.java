package p007b.p225i.p226a.p242c.p257e3.p258b0;

import com.google.android.exoplayer2.upstream.cache.Cache;
import java.util.Comparator;
import java.util.TreeSet;

/* JADX INFO: renamed from: b.i.a.c.e3.b0.o */
/* JADX INFO: compiled from: LeastRecentlyUsedCacheEvictor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2696o implements InterfaceC2685d {

    /* JADX INFO: renamed from: a */
    public final TreeSet<C2689h> f6501a = new TreeSet<>(new Comparator() { // from class: b.i.a.c.e3.b0.b
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            C2689h c2689h = (C2689h) obj;
            C2689h c2689h2 = (C2689h) obj2;
            long j = c2689h.f6470o;
            long j2 = c2689h2.f6470o;
            if (j - j2 == 0) {
                return c2689h.compareTo(c2689h2);
            }
            return j < j2 ? -1 : 1;
        }
    });

    /* JADX INFO: renamed from: b */
    public long f6502b;

    public C2696o(long j) {
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.InterfaceC2685d
    /* JADX INFO: renamed from: a */
    public void mo2785a(Cache cache, String str, long j, long j2) {
        if (j2 != -1) {
            m2821f(cache, j2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.InterfaceC10774a
    /* JADX INFO: renamed from: b */
    public void mo2818b(Cache cache, C2689h c2689h) {
        this.f6501a.remove(c2689h);
        this.f6502b -= c2689h.f6467l;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.InterfaceC10774a
    /* JADX INFO: renamed from: c */
    public void mo2819c(Cache cache, C2689h c2689h, C2689h c2689h2) {
        this.f6501a.remove(c2689h);
        this.f6502b -= c2689h.f6467l;
        mo2820d(cache, c2689h2);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.InterfaceC10774a
    /* JADX INFO: renamed from: d */
    public void mo2820d(Cache cache, C2689h c2689h) {
        this.f6501a.add(c2689h);
        this.f6502b += c2689h.f6467l;
        m2821f(cache, 0L);
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.InterfaceC2685d
    /* JADX INFO: renamed from: e */
    public void mo2786e() {
    }

    /* JADX INFO: renamed from: f */
    public final void m2821f(Cache cache, long j) {
        while (this.f6502b + j > 104857600 && !this.f6501a.isEmpty()) {
            cache.mo2829d(this.f6501a.first());
        }
    }
}
