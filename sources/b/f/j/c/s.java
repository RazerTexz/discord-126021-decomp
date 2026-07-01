package b.f.j.c;

import com.facebook.common.references.CloseableReference;

/* JADX INFO: compiled from: InstrumentedMemoryCache.java */
/* JADX INFO: loaded from: classes.dex */
public class s<K, V> implements w<K, V> {
    public final w<K, V> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f559b;

    public s(w<K, V> wVar, x xVar) {
        this.a = wVar;
        this.f559b = xVar;
    }

    @Override // b.f.j.c.w
    public CloseableReference<V> a(K k, CloseableReference<V> closeableReference) {
        this.f559b.c(k);
        return this.a.a(k, closeableReference);
    }

    @Override // b.f.j.c.w
    public int d(b.f.d.d.j<K> jVar) {
        return this.a.d(jVar);
    }

    @Override // b.f.j.c.w
    public CloseableReference<V> get(K k) {
        CloseableReference<V> closeableReference = this.a.get(k);
        if (closeableReference == null) {
            this.f559b.b(k);
        } else {
            this.f559b.a(k);
        }
        return closeableReference;
    }
}
