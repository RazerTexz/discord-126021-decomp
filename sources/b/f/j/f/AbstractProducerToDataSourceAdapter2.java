package b.f.j.f;

import b.f.e.AbstractDataSource3;
import b.f.j.k.RequestListener2;
import b.f.j.p.Producer2;
import b.f.j.p.SettableProducerContext;
import b.f.j.r.FrescoSystrace;

/* JADX INFO: renamed from: b.f.j.f.b, reason: use source file name */
/* JADX INFO: compiled from: AbstractProducerToDataSourceAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractProducerToDataSourceAdapter2<T> extends AbstractDataSource3<T> {
    public final SettableProducerContext h;
    public final RequestListener2 i;

    public AbstractProducerToDataSourceAdapter2(Producer2<T> producer2, SettableProducerContext settableProducerContext, RequestListener2 requestListener2) {
        FrescoSystrace.b();
        this.h = settableProducerContext;
        this.i = requestListener2;
        this.a = settableProducerContext.h;
        FrescoSystrace.b();
        requestListener2.b(settableProducerContext);
        FrescoSystrace.b();
        FrescoSystrace.b();
        producer2.b(new AbstractProducerToDataSourceAdapter(this), settableProducerContext);
        FrescoSystrace.b();
        FrescoSystrace.b();
    }

    @Override // b.f.e.AbstractDataSource3, com.facebook.datasource.DataSource
    public boolean close() {
        if (!super.close()) {
            return false;
        }
        if (c()) {
            return true;
        }
        this.i.i(this.h);
        this.h.u();
        return true;
    }
}
