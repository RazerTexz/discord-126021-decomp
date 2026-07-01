package b.i.a.c.e3.b0;

import com.google.android.exoplayer2.upstream.cache.Cache;
import java.util.TreeSet;

/* JADX INFO: compiled from: LeastRecentlyUsedCacheEvictor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements d {
    public final TreeSet<h> a = new TreeSet<>(b.j);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f937b;

    public o(long j) {
    }

    @Override // b.i.a.c.e3.b0.d
    public void a(Cache cache, String str, long j, long j2) {
        if (j2 != -1) {
            f(cache, j2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache$a
    public void b(Cache cache, h hVar) {
        this.a.remove(hVar);
        this.f937b -= hVar.l;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache$a
    public void c(Cache cache, h hVar, h hVar2) {
        this.a.remove(hVar);
        this.f937b -= hVar.l;
        d(cache, hVar2);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache$a
    public void d(Cache cache, h hVar) {
        this.a.add(hVar);
        this.f937b += hVar.l;
        f(cache, 0L);
    }

    @Override // b.i.a.c.e3.b0.d
    public void e() {
    }

    public final void f(Cache cache, long j) {
        while (this.f937b + j > 104857600 && !this.a.isEmpty()) {
            cache.d(this.a.first());
        }
    }
}
