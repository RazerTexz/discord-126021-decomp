package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.EnumC2112h;
import p007b.p195g.p196a.p198b.p203s.C2138b;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;

/* JADX INFO: renamed from: b.g.a.c.g0.u.p0 */
/* JADX INFO: compiled from: StdScalarSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2303p0<T> extends AbstractC2305q0<T> {
    public AbstractC2303p0(Class<T> cls) {
        super(cls);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: g */
    public void mo1808g(T t, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        C2138b c2138bMo1959e = abstractC2215g.mo1959e(abstractC2108d, abstractC2215g.m1958d(t, EnumC2112h.VALUE_STRING));
        mo1807f(t, abstractC2108d, abstractC2374x);
        abstractC2215g.mo1960f(abstractC2108d, c2138bMo1959e);
    }

    public AbstractC2303p0(Class<?> cls, boolean z2) {
        super(cls);
    }
}
