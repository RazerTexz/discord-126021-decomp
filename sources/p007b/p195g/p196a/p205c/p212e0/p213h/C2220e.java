package p007b.p195g.p196a.p205c.p212e0.p213h;

import p007b.p195g.p196a.p197a.InterfaceC2070c0;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p212e0.InterfaceC2213e;

/* JADX INFO: renamed from: b.g.a.c.e0.h.e */
/* JADX INFO: compiled from: AsWrapperTypeSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2220e extends AbstractC2228m {
    public C2220e(InterfaceC2213e interfaceC2213e, InterfaceC2206d interfaceC2206d) {
        super(interfaceC2213e, interfaceC2206d);
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.AbstractC2215g
    /* JADX INFO: renamed from: a */
    public AbstractC2215g mo1955a(InterfaceC2206d interfaceC2206d) {
        return this.f4780b == interfaceC2206d ? this : new C2220e(this.f4779a, interfaceC2206d);
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.AbstractC2215g
    /* JADX INFO: renamed from: c */
    public InterfaceC2070c0.a mo1957c() {
        return InterfaceC2070c0.a.WRAPPER_OBJECT;
    }
}
