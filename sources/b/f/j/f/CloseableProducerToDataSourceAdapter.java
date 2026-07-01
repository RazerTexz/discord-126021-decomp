package b.f.j.f;

import b.f.j.k.RequestListener2;
import b.f.j.p.Producer2;
import b.f.j.p.SettableProducerContext;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: renamed from: b.f.j.f.d, reason: use source file name */
/* JADX INFO: compiled from: CloseableProducerToDataSourceAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class CloseableProducerToDataSourceAdapter<T> extends AbstractProducerToDataSourceAdapter2<CloseableReference<T>> {
    public CloseableProducerToDataSourceAdapter(Producer2<CloseableReference<T>> producer2, SettableProducerContext settableProducerContext, RequestListener2 requestListener2) {
        super(producer2, settableProducerContext, requestListener2);
    }

    @Override // b.f.e.AbstractDataSource3
    public void g(Object obj) {
        Class<CloseableReference> cls = CloseableReference.j;
        ((CloseableReference) obj).close();
    }

    @Override // b.f.e.AbstractDataSource3, com.facebook.datasource.DataSource
    public Object getResult() {
        return CloseableReference.n((CloseableReference) super.getResult());
    }
}
