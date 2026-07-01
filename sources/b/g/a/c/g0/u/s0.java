package b.g.a.c.g0.u;

import java.io.IOException;
import java.util.TimeZone;

/* JADX INFO: compiled from: TimeZoneSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class s0 extends p0<TimeZone> {
    public s0() {
        super(TimeZone.class);
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        dVar.j0(((TimeZone) obj).getID());
    }

    @Override // b.g.a.c.g0.u.p0, b.g.a.c.n
    public void g(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException {
        TimeZone timeZone = (TimeZone) obj;
        b.g.a.b.s.b bVarD = gVar.d(timeZone, b.g.a.b.h.VALUE_STRING);
        bVarD.f675b = TimeZone.class;
        b.g.a.b.s.b bVarE = gVar.e(dVar, bVarD);
        dVar.j0(timeZone.getID());
        gVar.f(dVar, bVarE);
    }
}
