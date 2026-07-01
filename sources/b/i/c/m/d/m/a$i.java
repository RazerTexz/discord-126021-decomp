package b.i.c.m.d.m;

import java.io.IOException;

/* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$i implements b.i.c.p.c<v$d$d$a> {
    public static final a$i a = new a$i();

    @Override // b.i.c.p.b
    public void a(Object obj, b.i.c.p.d dVar) throws IOException {
        v$d$d$a v_d_d_a = (v$d$d$a) obj;
        b.i.c.p.d dVar2 = dVar;
        dVar2.f("execution", v_d_d_a.c());
        dVar2.f("customAttributes", v_d_d_a.b());
        dVar2.f("background", v_d_d_a.a());
        dVar2.c("uiOrientation", v_d_d_a.d());
    }
}
