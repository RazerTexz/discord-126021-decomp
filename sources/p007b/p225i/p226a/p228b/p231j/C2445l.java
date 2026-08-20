package p007b.p225i.p226a.p228b.p231j;

import java.util.HashMap;
import java.util.Objects;
import p007b.p225i.p226a.p228b.AbstractC2408c;
import p007b.p225i.p226a.p228b.C2407b;
import p007b.p225i.p226a.p228b.EnumC2409d;
import p007b.p225i.p226a.p228b.InterfaceC2410e;
import p007b.p225i.p226a.p228b.InterfaceC2411f;
import p007b.p225i.p226a.p228b.InterfaceC2413h;
import p007b.p225i.p226a.p228b.p231j.p236t.InterfaceC2470e;

/* JADX INFO: renamed from: b.i.a.b.j.l */
/* JADX INFO: compiled from: TransportImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2445l<T> implements InterfaceC2411f<T> {

    /* JADX INFO: renamed from: a */
    public final AbstractC2442i f5285a;

    /* JADX INFO: renamed from: b */
    public final String f5286b;

    /* JADX INFO: renamed from: c */
    public final C2407b f5287c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC2410e<T, byte[]> f5288d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC2446m f5289e;

    public C2445l(AbstractC2442i abstractC2442i, String str, C2407b c2407b, InterfaceC2410e<T, byte[]> interfaceC2410e, InterfaceC2446m interfaceC2446m) {
        this.f5285a = abstractC2442i;
        this.f5286b = str;
        this.f5287c = c2407b;
        this.f5288d = interfaceC2410e;
        this.f5289e = interfaceC2446m;
    }

    @Override // p007b.p225i.p226a.p228b.InterfaceC2411f
    /* JADX INFO: renamed from: a */
    public void mo2289a(AbstractC2408c<T> abstractC2408c) {
        mo2290b(abstractC2408c, new InterfaceC2413h() { // from class: b.i.a.b.j.k
            @Override // p007b.p225i.p226a.p228b.InterfaceC2413h
            /* JADX INFO: renamed from: a */
            public void mo2292a(Exception exc) {
            }
        });
    }

    @Override // p007b.p225i.p226a.p228b.InterfaceC2411f
    /* JADX INFO: renamed from: b */
    public void mo2290b(AbstractC2408c<T> abstractC2408c, InterfaceC2413h interfaceC2413h) {
        InterfaceC2446m interfaceC2446m = this.f5289e;
        AbstractC2442i abstractC2442i = this.f5285a;
        Objects.requireNonNull(abstractC2442i, "Null transportContext");
        Objects.requireNonNull(abstractC2408c, "Null event");
        String str = this.f5286b;
        Objects.requireNonNull(str, "Null transportName");
        InterfaceC2410e<T, byte[]> interfaceC2410e = this.f5288d;
        Objects.requireNonNull(interfaceC2410e, "Null transformer");
        C2407b c2407b = this.f5287c;
        Objects.requireNonNull(c2407b, "Null encoding");
        C2447n c2447n = (C2447n) interfaceC2446m;
        InterfaceC2470e interfaceC2470e = c2447n.f5293d;
        EnumC2409d enumC2409dMo2288c = abstractC2408c.mo2288c();
        AbstractC2442i.a aVarM2358a = AbstractC2442i.m2358a();
        aVarM2358a.mo2352b(abstractC2442i.mo2348b());
        aVarM2358a.mo2353c(enumC2409dMo2288c);
        C2435b.b bVar = (C2435b.b) aVarM2358a;
        bVar.f5262b = abstractC2442i.mo2349c();
        AbstractC2442i abstractC2442iMo2351a = bVar.mo2351a();
        C2434a.b bVar2 = new C2434a.b();
        bVar2.f5257f = new HashMap();
        bVar2.m2345e(c2447n.f5291b.mo2413a());
        bVar2.m2347g(c2447n.f5292c.mo2413a());
        bVar2.m2346f(str);
        bVar2.m2344d(new C2438e(c2407b, interfaceC2410e.apply(abstractC2408c.mo2287b())));
        bVar2.f5253b = abstractC2408c.mo2286a();
        interfaceC2470e.mo2373a(abstractC2442iMo2351a, bVar2.mo2342b(), interfaceC2413h);
    }
}
