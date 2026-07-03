package p007b.p195g.p196a.p205c.p219i0;

import java.util.Objects;
import p007b.p195g.p196a.p197a.InterfaceC2094p;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.C2369s;
import p007b.p195g.p196a.p205c.C2370t;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2188i;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2198s;
import p007b.p195g.p196a.p205c.p210c0.C2185g;
import p007b.p195g.p196a.p205c.p210c0.C2189j;
import p007b.p195g.p196a.p205c.p210c0.C2192m;
import p007b.p195g.p196a.p205c.p221z.AbstractC2394l;

/* JADX INFO: renamed from: b.g.a.c.i0.q */
/* JADX INFO: compiled from: SimpleBeanPropertyDefinition.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2355q extends AbstractC2198s {

    /* JADX INFO: renamed from: k */
    public final AbstractC2165b f4963k;

    /* JADX INFO: renamed from: l */
    public final AbstractC2188i f4964l;

    /* JADX INFO: renamed from: m */
    public final C2369s f4965m;

    /* JADX INFO: renamed from: n */
    public final C2370t f4966n;

    /* JADX INFO: renamed from: o */
    public final InterfaceC2094p.b f4967o;

    public C2355q(AbstractC2165b abstractC2165b, AbstractC2188i abstractC2188i, C2370t c2370t, C2369s c2369s, InterfaceC2094p.b bVar) {
        this.f4963k = abstractC2165b;
        this.f4964l = abstractC2188i;
        this.f4966n = c2370t;
        this.f4965m = c2369s == null ? C2369s.f5026k : c2369s;
        this.f4967o = bVar;
    }

    /* JADX INFO: renamed from: w */
    public static C2355q m2203w(AbstractC2394l<?> abstractC2394l, AbstractC2188i abstractC2188i, C2370t c2370t, C2369s c2369s, InterfaceC2094p.a aVar) {
        InterfaceC2094p.b bVar;
        InterfaceC2094p.a aVar2;
        if (aVar == null || aVar == (aVar2 = InterfaceC2094p.a.USE_DEFAULTS)) {
            bVar = AbstractC2198s.f4747j;
        } else {
            bVar = aVar != aVar2 ? new InterfaceC2094p.b(aVar, null, null, null) : InterfaceC2094p.b.f4436j;
        }
        return new C2355q(abstractC2394l.m2267e(), abstractC2188i, c2370t, c2369s, bVar);
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: g */
    public InterfaceC2094p.b mo1850g() {
        return this.f4967o;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: k */
    public C2192m mo1853k() {
        AbstractC2188i abstractC2188i = this.f4964l;
        if (abstractC2188i instanceof C2192m) {
            return (C2192m) abstractC2188i;
        }
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: l */
    public C2185g mo1854l() {
        AbstractC2188i abstractC2188i = this.f4964l;
        if (abstractC2188i instanceof C2185g) {
            return (C2185g) abstractC2188i;
        }
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: m */
    public C2370t mo1855m() {
        return this.f4966n;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: n */
    public C2189j mo1856n() {
        AbstractC2188i abstractC2188i = this.f4964l;
        if ((abstractC2188i instanceof C2189j) && ((C2189j) abstractC2188i).m1905o() == 0) {
            return (C2189j) this.f4964l;
        }
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: o */
    public C2369s mo1857o() {
        return this.f4965m;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: p */
    public String mo1858p() {
        return this.f4966n._simpleName;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: q */
    public AbstractC2188i mo1859q() {
        return this.f4964l;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: r */
    public Class<?> mo1860r() {
        AbstractC2188i abstractC2188i = this.f4964l;
        return abstractC2188i == null ? Object.class : abstractC2188i.mo1820d();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: s */
    public C2189j mo1861s() {
        AbstractC2188i abstractC2188i = this.f4964l;
        if ((abstractC2188i instanceof C2189j) && ((C2189j) abstractC2188i).m1905o() == 1) {
            return (C2189j) this.f4964l;
        }
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: t */
    public C2370t mo1862t() {
        AbstractC2165b abstractC2165b = this.f4963k;
        if (abstractC2165b != null && this.f4964l != null) {
            Objects.requireNonNull(abstractC2165b);
        }
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2198s
    /* JADX INFO: renamed from: u */
    public boolean mo1863u() {
        return false;
    }
}
