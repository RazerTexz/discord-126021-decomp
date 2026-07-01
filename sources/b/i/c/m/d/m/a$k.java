package b.i.c.m.d.m;

import java.io.IOException;

/* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$k implements b.i.c.p.c<v$d$d$a$b> {
    public static final a$k a = new a$k();

    @Override // b.i.c.p.b
    public void a(Object obj, b.i.c.p.d dVar) throws IOException {
        v$d$d$a$b v_d_d_a_b = (v$d$d$a$b) obj;
        b.i.c.p.d dVar2 = dVar;
        dVar2.f("threads", v_d_d_a_b.d());
        dVar2.f("exception", v_d_d_a_b.b());
        dVar2.f("signal", v_d_d_a_b.c());
        dVar2.f("binaries", v_d_d_a_b.a());
    }
}
