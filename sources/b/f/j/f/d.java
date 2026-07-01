package b.f.j.f;

import b.f.j.p.d1;
import b.f.j.p.w0;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: compiled from: CloseableProducerToDataSourceAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class d<T> extends b<CloseableReference<T>> {
    public d(w0<CloseableReference<T>> w0Var, d1 d1Var, b.f.j.k.d dVar) {
        super(w0Var, d1Var, dVar);
    }

    @Override // b.f.e.c
    public void g(Object obj) {
        Class<CloseableReference> cls = CloseableReference.j;
        ((CloseableReference) obj).close();
    }

    @Override // b.f.e.c, com.facebook.datasource.DataSource
    public Object getResult() {
        return CloseableReference.n((CloseableReference) super.getResult());
    }
}
