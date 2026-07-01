package b.i.c.m.d.m;

import java.io.IOException;

/* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$p implements b.i.c.p.c<v$d$d$b> {
    public static final a$p a = new a$p();

    @Override // b.i.c.p.b
    public void a(Object obj, b.i.c.p.d dVar) throws IOException {
        v$d$d$b v_d_d_b = (v$d$d$b) obj;
        b.i.c.p.d dVar2 = dVar;
        dVar2.f("batteryLevel", v_d_d_b.a());
        dVar2.c("batteryVelocity", v_d_d_b.b());
        dVar2.a("proximityOn", v_d_d_b.f());
        dVar2.c("orientation", v_d_d_b.d());
        dVar2.b("ramUsed", v_d_d_b.e());
        dVar2.b("diskUsed", v_d_d_b.c());
    }
}
