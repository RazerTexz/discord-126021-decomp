package p007b.p109f.p161j.p171f;

import p007b.p109f.p129e.AbstractC1723c;
import p007b.p109f.p161j.p176k.InterfaceC1927d;
import p007b.p109f.p161j.p181p.C1973d1;
import p007b.p109f.p161j.p181p.InterfaceC2018w0;
import p007b.p109f.p161j.p183r.C2030b;

/* JADX INFO: renamed from: b.f.j.f.b */
/* JADX INFO: compiled from: AbstractProducerToDataSourceAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1904b<T> extends AbstractC1723c<T> {

    /* JADX INFO: renamed from: h */
    public final C1973d1 f3866h;

    /* JADX INFO: renamed from: i */
    public final InterfaceC1927d f3867i;

    public AbstractC1904b(InterfaceC2018w0<T> interfaceC2018w0, C1973d1 c1973d1, InterfaceC1927d interfaceC1927d) {
        C2030b.m1527b();
        this.f3866h = c1973d1;
        this.f3867i = interfaceC1927d;
        this.f3152a = c1973d1.f4032h;
        C2030b.m1527b();
        interfaceC1927d.mo1355b(c1973d1);
        C2030b.m1527b();
        C2030b.m1527b();
        interfaceC2018w0.mo1417b(new C1903a(this), c1973d1);
        C2030b.m1527b();
        C2030b.m1527b();
    }

    @Override // p007b.p109f.p129e.AbstractC1723c, com.facebook.datasource.DataSource
    public boolean close() {
        if (!super.close()) {
            return false;
        }
        if (mo1019c()) {
            return true;
        }
        this.f3867i.mo1362i(this.f3866h);
        this.f3866h.m1460u();
        return true;
    }
}
