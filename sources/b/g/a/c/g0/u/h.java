package b.g.a.c.g0.u;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;

/* JADX INFO: compiled from: CalendarSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class h extends l<Calendar> {
    public static final h k = new h();

    public h() {
        super(Calendar.class, null, null);
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        Calendar calendar = (Calendar) obj;
        if (p(xVar)) {
            dVar.I(calendar == null ? 0L : calendar.getTimeInMillis());
        } else {
            q(calendar.getTime(), dVar, xVar);
        }
    }

    @Override // b.g.a.c.g0.u.l
    public l<Calendar> r(Boolean bool, DateFormat dateFormat) {
        return new h(bool, dateFormat);
    }

    public h(Boolean bool, DateFormat dateFormat) {
        super(Calendar.class, bool, dateFormat);
    }
}
