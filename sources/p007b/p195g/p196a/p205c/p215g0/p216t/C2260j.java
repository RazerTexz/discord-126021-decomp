package p007b.p195g.p196a.p205c.p215g0.p216t;

import p007b.p195g.p196a.p197a.AbstractC2082i0;
import p007b.p195g.p196a.p198b.InterfaceC2115k;
import p007b.p195g.p196a.p198b.p200p.C2130j;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.C2370t;

/* JADX INFO: renamed from: b.g.a.c.g0.t.j */
/* JADX INFO: compiled from: ObjectIdWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2260j {

    /* JADX INFO: renamed from: a */
    public final AbstractC2360j f4818a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC2115k f4819b;

    /* JADX INFO: renamed from: c */
    public final AbstractC2082i0<?> f4820c;

    /* JADX INFO: renamed from: d */
    public final AbstractC2364n<Object> f4821d;

    /* JADX INFO: renamed from: e */
    public final boolean f4822e;

    public C2260j(AbstractC2360j abstractC2360j, InterfaceC2115k interfaceC2115k, AbstractC2082i0<?> abstractC2082i0, AbstractC2364n<?> abstractC2364n, boolean z2) {
        this.f4818a = abstractC2360j;
        this.f4819b = interfaceC2115k;
        this.f4820c = abstractC2082i0;
        this.f4821d = abstractC2364n;
        this.f4822e = z2;
    }

    /* JADX INFO: renamed from: a */
    public static C2260j m2031a(AbstractC2360j abstractC2360j, C2370t c2370t, AbstractC2082i0<?> abstractC2082i0, boolean z2) {
        String str = c2370t == null ? null : c2370t._simpleName;
        return new C2260j(abstractC2360j, str != null ? new C2130j(str) : null, abstractC2082i0, null, z2);
    }
}
