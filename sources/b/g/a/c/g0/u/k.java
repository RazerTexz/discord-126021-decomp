package b.g.a.c.g0.u;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

/* JADX INFO: compiled from: DateSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class k extends l<Date> {
    public static final k k = new k();

    public k() {
        super(Date.class, null, null);
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        Date date = (Date) obj;
        if (p(xVar)) {
            dVar.I(date == null ? 0L : date.getTime());
        } else {
            q(date, dVar, xVar);
        }
    }

    @Override // b.g.a.c.g0.u.l
    public l<Date> r(Boolean bool, DateFormat dateFormat) {
        return new k(bool, dateFormat);
    }

    public k(Boolean bool, DateFormat dateFormat) {
        super(Date.class, bool, dateFormat);
    }
}
