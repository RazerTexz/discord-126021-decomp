package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2375a;

/* JADX INFO: renamed from: b.g.a.c.g0.u.h */
/* JADX INFO: compiled from: CalendarSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@InterfaceC2375a
public class C2286h extends AbstractC2294l<Calendar> {

    /* JADX INFO: renamed from: k */
    public static final C2286h f4854k = new C2286h();

    public C2286h() {
        super(Calendar.class, null, null);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        Calendar calendar = (Calendar) obj;
        if (m2066p(abstractC2374x)) {
            abstractC2108d.mo1635I(calendar == null ? 0L : calendar.getTimeInMillis());
        } else {
            m2067q(calendar.getTime(), abstractC2108d, abstractC2374x);
        }
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2294l
    /* JADX INFO: renamed from: r */
    public AbstractC2294l<Calendar> mo2060r(Boolean bool, DateFormat dateFormat) {
        return new C2286h(bool, dateFormat);
    }

    public C2286h(Boolean bool, DateFormat dateFormat) {
        super(Calendar.class, bool, dateFormat);
    }
}
