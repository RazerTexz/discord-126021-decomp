package b.f.j.c;

import com.facebook.cache.common.CacheKey;

/* JADX INFO: compiled from: BufferedDiskCache.java */
/* JADX INFO: loaded from: classes.dex */
public class f$a implements Runnable {
    public final /* synthetic */ CacheKey j;
    public final /* synthetic */ b.f.j.j.e k;
    public final /* synthetic */ f l;

    public f$a(f fVar, Object obj, CacheKey cacheKey, b.f.j.j.e eVar) {
        this.l = fVar;
        this.j = cacheKey;
        this.k = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            f.b(this.l, this.j, this.k);
            this.l.f.d(this.j, this.k);
            b.f.j.j.e eVar = this.k;
            if (eVar != null) {
                eVar.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                this.l.f.d(this.j, this.k);
                b.f.j.j.e eVar2 = this.k;
                if (eVar2 != null) {
                    eVar2.close();
                }
                throw th2;
            }
        }
    }
}
