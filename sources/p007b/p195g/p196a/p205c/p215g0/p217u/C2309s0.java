package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.util.TimeZone;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.EnumC2112h;
import p007b.p195g.p196a.p198b.p203s.C2138b;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;

/* JADX INFO: renamed from: b.g.a.c.g0.u.s0 */
/* JADX INFO: compiled from: TimeZoneSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2309s0 extends AbstractC2303p0<TimeZone> {
    public C2309s0() {
        super(TimeZone.class);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        abstractC2108d.mo1658j0(((TimeZone) obj).getID());
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2303p0, p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: g */
    public void mo1808g(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        TimeZone timeZone = (TimeZone) obj;
        C2138b c2138bM1958d = abstractC2215g.m1958d(timeZone, EnumC2112h.VALUE_STRING);
        c2138bM1958d.f4585b = TimeZone.class;
        C2138b c2138bMo1959e = abstractC2215g.mo1959e(abstractC2108d, c2138bM1958d);
        abstractC2108d.mo1658j0(timeZone.getID());
        abstractC2215g.mo1960f(abstractC2108d, c2138bMo1959e);
    }
}
