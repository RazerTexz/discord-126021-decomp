package p007b.p195g.p196a.p205c.p210c0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import p007b.p195g.p196a.p197a.InterfaceC2081i;
import p007b.p195g.p196a.p197a.InterfaceC2094p;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.AbstractC2172c;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.p221z.AbstractC2394l;

/* JADX INFO: renamed from: b.g.a.c.c0.q */
/* JADX INFO: compiled from: BasicBeanDescription.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2196q extends AbstractC2172c {

    /* JADX INFO: renamed from: b */
    public static final Class<?>[] f4732b = new Class[0];

    /* JADX INFO: renamed from: c */
    public final C2176b0 f4733c;

    /* JADX INFO: renamed from: d */
    public final AbstractC2394l<?> f4734d;

    /* JADX INFO: renamed from: e */
    public final AbstractC2165b f4735e;

    /* JADX INFO: renamed from: f */
    public final C2177c f4736f;

    /* JADX INFO: renamed from: g */
    public Class<?>[] f4737g;

    /* JADX INFO: renamed from: h */
    public boolean f4738h;

    /* JADX INFO: renamed from: i */
    public List<AbstractC2198s> f4739i;

    /* JADX INFO: renamed from: j */
    public C2174a0 f4740j;

    public C2196q(AbstractC2394l<?> abstractC2394l, AbstractC2360j abstractC2360j, C2177c c2177c, List<AbstractC2198s> list) {
        super(abstractC2360j);
        this.f4733c = null;
        this.f4734d = abstractC2394l;
        if (abstractC2394l == null) {
            this.f4735e = null;
        } else {
            this.f4735e = abstractC2394l.m2267e();
        }
        this.f4736f = c2177c;
        this.f4739i = list;
    }

    /* JADX INFO: renamed from: e */
    public static C2196q m1918e(AbstractC2394l<?> abstractC2394l, AbstractC2360j abstractC2360j, C2177c c2177c) {
        return new C2196q(abstractC2394l, abstractC2360j, c2177c, Collections.emptyList());
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2172c
    /* JADX INFO: renamed from: a */
    public InterfaceC2081i.d mo1812a(InterfaceC2081i.d dVar) {
        InterfaceC2081i.d dVarMo1784h;
        AbstractC2165b abstractC2165b = this.f4735e;
        if (abstractC2165b == null || (dVarMo1784h = abstractC2165b.mo1784h(this.f4736f)) == null) {
            dVarMo1784h = null;
        }
        InterfaceC2081i.d dVarMo2271i = this.f4734d.mo2271i(this.f4736f.f4655l);
        if (dVarMo2271i != null) {
            return dVarMo1784h == null ? dVarMo2271i : dVarMo1784h.m1607k(dVarMo2271i);
        }
        return dVarMo1784h;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2172c
    /* JADX INFO: renamed from: b */
    public AbstractC2188i mo1813b() {
        C2176b0 c2176b0 = this.f4733c;
        if (c2176b0 == null) {
            return null;
        }
        if (!c2176b0.f4641i) {
            c2176b0.m1829h();
        }
        LinkedList<AbstractC2188i> linkedList = c2176b0.f4650r;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() <= 1) {
            return c2176b0.f4650r.get(0);
        }
        c2176b0.m1830i("Multiple 'as-value' properties defined (%s vs %s)", c2176b0.f4650r.get(0), c2176b0.f4650r.get(1));
        throw null;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2172c
    /* JADX INFO: renamed from: c */
    public InterfaceC2094p.b mo1814c(InterfaceC2094p.b bVar) {
        InterfaceC2094p.b bVarMo1802z;
        AbstractC2165b abstractC2165b = this.f4735e;
        if (abstractC2165b == null || (bVarMo1802z = abstractC2165b.mo1802z(this.f4736f)) == null) {
            return bVar;
        }
        return bVar == null ? bVarMo1802z : bVar.m1618a(bVarMo1802z);
    }

    /* JADX INFO: renamed from: d */
    public List<AbstractC2198s> m1919d() {
        if (this.f4739i == null) {
            C2176b0 c2176b0 = this.f4733c;
            if (!c2176b0.f4641i) {
                c2176b0.m1829h();
            }
            this.f4739i = new ArrayList(c2176b0.f4642j.values());
        }
        return this.f4739i;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C2196q(C2176b0 c2176b0) {
        AbstractC2360j abstractC2360j = c2176b0.f4636d;
        C2177c c2177c = c2176b0.f4637e;
        super(abstractC2360j);
        this.f4733c = c2176b0;
        AbstractC2394l<?> abstractC2394l = c2176b0.f4633a;
        this.f4734d = abstractC2394l;
        if (abstractC2394l == null) {
            this.f4735e = null;
        } else {
            this.f4735e = abstractC2394l.m2267e();
        }
        this.f4736f = c2177c;
        C2174a0 c2174a0Mo1794r = c2176b0.f4639g.mo1794r(c2176b0.f4637e);
        this.f4740j = c2174a0Mo1794r != null ? c2176b0.f4639g.mo1795s(c2176b0.f4637e, c2174a0Mo1794r) : c2174a0Mo1794r;
    }
}
