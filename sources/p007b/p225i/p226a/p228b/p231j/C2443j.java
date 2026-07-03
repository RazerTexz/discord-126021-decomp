package p007b.p225i.p226a.p228b.p231j;

import java.util.Set;
import p007b.p225i.p226a.p228b.C2407b;
import p007b.p225i.p226a.p228b.InterfaceC2410e;
import p007b.p225i.p226a.p228b.InterfaceC2411f;
import p007b.p225i.p226a.p228b.InterfaceC2412g;

/* JADX INFO: renamed from: b.i.a.b.j.j */
/* JADX INFO: compiled from: TransportFactoryImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2443j implements InterfaceC2412g {

    /* JADX INFO: renamed from: a */
    public final Set<C2407b> f5281a;

    /* JADX INFO: renamed from: b */
    public final AbstractC2442i f5282b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC2446m f5283c;

    public C2443j(Set<C2407b> set, AbstractC2442i abstractC2442i, InterfaceC2446m interfaceC2446m) {
        this.f5281a = set;
        this.f5282b = abstractC2442i;
        this.f5283c = interfaceC2446m;
    }

    @Override // p007b.p225i.p226a.p228b.InterfaceC2412g
    /* JADX INFO: renamed from: a */
    public <T> InterfaceC2411f<T> mo2291a(String str, Class<T> cls, C2407b c2407b, InterfaceC2410e<T, byte[]> interfaceC2410e) {
        if (this.f5281a.contains(c2407b)) {
            return new C2445l(this.f5282b, str, c2407b, interfaceC2410e, this.f5283c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", c2407b, this.f5281a));
    }
}
