package p007b.p195g.p196a.p205c.p210c0;

import java.io.Serializable;
import p007b.p195g.p196a.p197a.InterfaceC2081i;
import p007b.p195g.p196a.p197a.InterfaceC2094p;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.C2369s;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p221z.AbstractC2394l;

/* JADX INFO: renamed from: b.g.a.c.c0.v */
/* JADX INFO: compiled from: ConcreteBeanPropertyBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2201v implements InterfaceC2206d, Serializable {
    private static final long serialVersionUID = 1;
    public final C2369s _metadata;

    public AbstractC2201v(C2369s c2369s) {
        this._metadata = c2369s == null ? C2369s.f5027l : c2369s;
    }

    @Override // p007b.p195g.p196a.p205c.InterfaceC2206d
    /* JADX INFO: renamed from: a */
    public InterfaceC2081i.d mo1928a(AbstractC2394l<?> abstractC2394l, Class<?> cls) {
        AbstractC2188i member;
        InterfaceC2081i.d dVarMo2271i = abstractC2394l.mo2271i(cls);
        AbstractC2165b abstractC2165bM2267e = abstractC2394l.m2267e();
        InterfaceC2081i.d dVarMo1784h = (abstractC2165bM2267e == null || (member = getMember()) == null) ? null : abstractC2165bM2267e.mo1784h(member);
        if (dVarMo2271i == null) {
            return dVarMo1784h == null ? InterfaceC2206d.f4765c : dVarMo1784h;
        }
        return dVarMo1784h == null ? dVarMo2271i : dVarMo2271i.m1607k(dVarMo1784h);
    }

    @Override // p007b.p195g.p196a.p205c.InterfaceC2206d
    /* JADX INFO: renamed from: b */
    public InterfaceC2094p.b mo1929b(AbstractC2394l<?> abstractC2394l, Class<?> cls) {
        AbstractC2165b abstractC2165bM2267e = abstractC2394l.m2267e();
        AbstractC2188i member = getMember();
        if (member == null) {
            return abstractC2394l.mo2272j(cls);
        }
        InterfaceC2094p.b bVarMo2269g = abstractC2394l.mo2269g(cls, member.mo1820d());
        if (abstractC2165bM2267e == null) {
            return bVarMo2269g;
        }
        InterfaceC2094p.b bVarMo1802z = abstractC2165bM2267e.mo1802z(member);
        return bVarMo2269g == null ? bVarMo1802z : bVarMo2269g.m1618a(bVarMo1802z);
    }

    public AbstractC2201v(AbstractC2201v abstractC2201v) {
        this._metadata = abstractC2201v._metadata;
    }
}
