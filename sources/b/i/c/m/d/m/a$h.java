package b.i.c.m.d.m;

import java.io.IOException;

/* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$h implements b.i.c.p.c<v$d> {
    public static final a$h a = new a$h();

    @Override // b.i.c.p.b
    public void a(Object obj, b.i.c.p.d dVar) throws IOException {
        v$d v_d = (v$d) obj;
        b.i.c.p.d dVar2 = dVar;
        dVar2.f("generator", v_d.e());
        dVar2.f("identifier", v_d.g().getBytes(v.a));
        dVar2.b("startedAt", v_d.i());
        dVar2.f("endedAt", v_d.c());
        dVar2.a("crashed", v_d.k());
        dVar2.f("app", v_d.a());
        dVar2.f("user", v_d.j());
        dVar2.f("os", v_d.h());
        dVar2.f("device", v_d.b());
        dVar2.f("events", v_d.d());
        dVar2.c("generatorType", v_d.f());
    }
}
