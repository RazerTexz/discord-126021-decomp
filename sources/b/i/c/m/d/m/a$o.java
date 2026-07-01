package b.i.c.m.d.m;

import java.io.IOException;

/* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$o implements b.i.c.p.c<v$d$d$a$b$d$a> {
    public static final a$o a = new a$o();

    @Override // b.i.c.p.b
    public void a(Object obj, b.i.c.p.d dVar) throws IOException {
        v$d$d$a$b$d$a v_d_d_a_b_d_a = (v$d$d$a$b$d$a) obj;
        b.i.c.p.d dVar2 = dVar;
        dVar2.b("pc", v_d_d_a_b_d_a.d());
        dVar2.f("symbol", v_d_d_a_b_d_a.e());
        dVar2.f("file", v_d_d_a_b_d_a.a());
        dVar2.b("offset", v_d_d_a_b_d_a.c());
        dVar2.c("importance", v_d_d_a_b_d_a.b());
    }
}
