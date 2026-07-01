package b.i.c.m.d.m;

import java.io.IOException;

/* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$q implements b.i.c.p.c<v$d$d> {
    public static final a$q a = new a$q();

    @Override // b.i.c.p.b
    public void a(Object obj, b.i.c.p.d dVar) throws IOException {
        v$d$d v_d_d = (v$d$d) obj;
        b.i.c.p.d dVar2 = dVar;
        dVar2.b("timestamp", v_d_d.d());
        dVar2.f("type", v_d_d.e());
        dVar2.f("app", v_d_d.a());
        dVar2.f("device", v_d_d.b());
        dVar2.f("log", v_d_d.c());
    }
}
