package p007b.p195g.p196a.p205c.p212e0.p213h;

import p007b.p195g.p196a.p197a.InterfaceC2070c0;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p212e0.InterfaceC2213e;

/* JADX INFO: renamed from: b.g.a.c.e0.h.d */
/* JADX INFO: compiled from: AsPropertyTypeSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2219d extends C2216a {

    /* JADX INFO: renamed from: c */
    public final String f4771c;

    public C2219d(InterfaceC2213e interfaceC2213e, InterfaceC2206d interfaceC2206d, String str) {
        super(interfaceC2213e, interfaceC2206d);
        this.f4771c = str;
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.p213h.AbstractC2228m, p007b.p195g.p196a.p205c.p212e0.AbstractC2215g
    /* JADX INFO: renamed from: b */
    public String mo1956b() {
        return this.f4771c;
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.p213h.C2216a, p007b.p195g.p196a.p205c.p212e0.AbstractC2215g
    /* JADX INFO: renamed from: c */
    public InterfaceC2070c0.a mo1957c() {
        return InterfaceC2070c0.a.PROPERTY;
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.p213h.C2216a
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public C2219d mo1955a(InterfaceC2206d interfaceC2206d) {
        return this.f4780b == interfaceC2206d ? this : new C2219d(this.f4779a, interfaceC2206d, this.f4771c);
    }
}
