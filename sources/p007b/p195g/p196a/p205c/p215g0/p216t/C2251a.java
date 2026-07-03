package p007b.p195g.p196a.p205c.p215g0.p216t;

import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2198s;
import p007b.p195g.p196a.p205c.p210c0.C2177c;
import p007b.p195g.p196a.p205c.p215g0.AbstractC2250s;
import p007b.p195g.p196a.p205c.p219i0.InterfaceC2339a;
import p007b.p195g.p196a.p205c.p221z.AbstractC2394l;

/* JADX INFO: renamed from: b.g.a.c.g0.t.a */
/* JADX INFO: compiled from: AttributePropertyWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2251a extends AbstractC2250s {
    private static final long serialVersionUID = 1;
    public final String _attrName;

    public C2251a(String str, AbstractC2198s abstractC2198s, InterfaceC2339a interfaceC2339a, AbstractC2360j abstractC2360j) {
        super(abstractC2198s, interfaceC2339a, abstractC2360j, null, null, null, abstractC2198s.mo1850g(), null);
        this._attrName = str;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2250s
    /* JADX INFO: renamed from: j */
    public Object mo2017j(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws Exception {
        return abstractC2374x.m2258w(this._attrName);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2250s
    /* JADX INFO: renamed from: k */
    public AbstractC2250s mo2018k(AbstractC2394l<?> abstractC2394l, C2177c c2177c, AbstractC2198s abstractC2198s, AbstractC2360j abstractC2360j) {
        throw new IllegalStateException("Should not be called on this type");
    }
}
