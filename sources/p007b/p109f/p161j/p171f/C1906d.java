package p007b.p109f.p161j.p171f;

import com.facebook.common.references.CloseableReference;
import p007b.p109f.p161j.p176k.InterfaceC1927d;
import p007b.p109f.p161j.p181p.C1973d1;
import p007b.p109f.p161j.p181p.InterfaceC2018w0;

/* JADX INFO: renamed from: b.f.j.f.d */
/* JADX INFO: compiled from: CloseableProducerToDataSourceAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class C1906d<T> extends AbstractC1904b<CloseableReference<T>> {
    public C1906d(InterfaceC2018w0<CloseableReference<T>> interfaceC2018w0, C1973d1 c1973d1, InterfaceC1927d interfaceC1927d) {
        super(interfaceC2018w0, c1973d1, interfaceC1927d);
    }

    @Override // p007b.p109f.p129e.AbstractC1723c
    /* JADX INFO: renamed from: g */
    public void mo1023g(Object obj) {
        Class<CloseableReference> cls = CloseableReference.f19438j;
        ((CloseableReference) obj).close();
    }

    @Override // p007b.p109f.p129e.AbstractC1723c, com.facebook.datasource.DataSource
    public Object getResult() {
        return CloseableReference.m8636n((CloseableReference) super.getResult());
    }
}
