package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2375a;

/* JADX INFO: renamed from: b.g.a.c.g0.u.k */
/* JADX INFO: compiled from: DateSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@InterfaceC2375a
public class C2292k extends AbstractC2294l<Date> {

    /* JADX INFO: renamed from: k */
    public static final C2292k f4856k = new C2292k();

    public C2292k() {
        super(Date.class, null, null);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        Date date = (Date) obj;
        if (m2066p(abstractC2374x)) {
            abstractC2108d.mo1635I(date == null ? 0L : date.getTime());
        } else {
            m2067q(date, abstractC2108d, abstractC2374x);
        }
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2294l
    /* JADX INFO: renamed from: r */
    public AbstractC2294l<Date> mo2060r(Boolean bool, DateFormat dateFormat) {
        return new C2292k(bool, dateFormat);
    }

    public C2292k(Boolean bool, DateFormat dateFormat) {
        super(Date.class, bool, dateFormat);
    }
}
