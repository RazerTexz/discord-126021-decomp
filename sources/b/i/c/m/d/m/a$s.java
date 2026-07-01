package b.i.c.m.d.m;

import java.io.IOException;

/* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$s implements b.i.c.p.c<v$d$e> {
    public static final a$s a = new a$s();

    @Override // b.i.c.p.b
    public void a(Object obj, b.i.c.p.d dVar) throws IOException {
        v$d$e v_d_e = (v$d$e) obj;
        b.i.c.p.d dVar2 = dVar;
        dVar2.c("platform", v_d_e.b());
        dVar2.f("version", v_d_e.c());
        dVar2.f("buildVersion", v_d_e.a());
        dVar2.a("jailbroken", v_d_e.d());
    }
}
