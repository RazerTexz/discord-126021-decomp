package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.AbstractC2110f;
import p007b.p195g.p196a.p198b.EnumC2112h;
import p007b.p195g.p196a.p198b.p203s.C2138b;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2375a;

/* JADX INFO: renamed from: b.g.a.c.g0.u.x */
/* JADX INFO: compiled from: NumberSerializers.java */
/* JADX INFO: loaded from: classes3.dex */
@InterfaceC2375a
public class C2318x extends AbstractC2316w<Object> {
    public C2318x(Class<?> cls) {
        super(cls, AbstractC2110f.b.DOUBLE, "number");
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        abstractC2108d.mo1632C(((Double) obj).doubleValue());
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2303p0, p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: g */
    public void mo1808g(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        Double d = (Double) obj;
        double dDoubleValue = d.doubleValue();
        if (!(Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue))) {
            abstractC2108d.mo1632C(d.doubleValue());
            return;
        }
        C2138b c2138bMo1959e = abstractC2215g.mo1959e(abstractC2108d, abstractC2215g.m1958d(obj, EnumC2112h.VALUE_NUMBER_FLOAT));
        abstractC2108d.mo1632C(d.doubleValue());
        abstractC2215g.mo1960f(abstractC2108d, c2138bMo1959e);
    }
}
