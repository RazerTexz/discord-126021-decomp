package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.EnumC2112h;
import p007b.p195g.p196a.p198b.p203s.C2138b;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;

/* JADX INFO: renamed from: b.g.a.c.g0.u.e0 */
/* JADX INFO: compiled from: RawSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2281e0<T> extends AbstractC2305q0<T> {
    public C2281e0(Class<?> cls) {
        super(cls, false);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(T t, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        abstractC2108d.mo1644V(t.toString());
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: g */
    public void mo1808g(T t, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        C2138b c2138bMo1959e = abstractC2215g.mo1959e(abstractC2108d, abstractC2215g.m1958d(t, EnumC2112h.VALUE_EMBEDDED_OBJECT));
        abstractC2108d.mo1644V(t.toString());
        abstractC2215g.mo1960f(abstractC2108d, c2138bMo1959e);
    }
}
