package b.f.j.p;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: compiled from: BitmapMemoryCacheGetProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends h {
    public f(b.f.j.c.w<CacheKey, b.f.j.j.c> wVar, b.f.j.c.i iVar, w0<CloseableReference<b.f.j.j.c>> w0Var) {
        super(wVar, iVar, w0Var);
    }

    @Override // b.f.j.p.h
    public String c() {
        return "pipe_ui";
    }

    @Override // b.f.j.p.h
    public String d() {
        return "BitmapMemoryCacheGetProducer";
    }

    @Override // b.f.j.p.h
    public l<CloseableReference<b.f.j.j.c>> e(l<CloseableReference<b.f.j.j.c>> lVar, CacheKey cacheKey, boolean z2) {
        return lVar;
    }
}
