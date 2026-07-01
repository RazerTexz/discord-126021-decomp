package b.i.c.m.d.m;

import java.io.IOException;

/* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$g implements b.i.c.p.c<v$d$c> {
    public static final a$g a = new a$g();

    @Override // b.i.c.p.b
    public void a(Object obj, b.i.c.p.d dVar) throws IOException {
        v$d$c v_d_c = (v$d$c) obj;
        b.i.c.p.d dVar2 = dVar;
        dVar2.c("arch", v_d_c.a());
        dVar2.f("model", v_d_c.e());
        dVar2.c("cores", v_d_c.b());
        dVar2.b("ram", v_d_c.g());
        dVar2.b("diskSpace", v_d_c.c());
        dVar2.a("simulator", v_d_c.i());
        dVar2.c("state", v_d_c.h());
        dVar2.f("manufacturer", v_d_c.d());
        dVar2.f("modelClass", v_d_c.f());
    }
}
