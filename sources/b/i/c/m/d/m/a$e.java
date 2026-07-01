package b.i.c.m.d.m;

import java.io.IOException;

/* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$e implements b.i.c.p.c<v$d$a> {
    public static final a$e a = new a$e();

    @Override // b.i.c.p.b
    public void a(Object obj, b.i.c.p.d dVar) throws IOException {
        v$d$a v_d_a = (v$d$a) obj;
        b.i.c.p.d dVar2 = dVar;
        dVar2.f("identifier", v_d_a.d());
        dVar2.f("version", v_d_a.g());
        dVar2.f("displayVersion", v_d_a.c());
        dVar2.f("organization", v_d_a.f());
        dVar2.f("installationUuid", v_d_a.e());
        dVar2.f("developmentPlatform", v_d_a.a());
        dVar2.f("developmentPlatformVersion", v_d_a.b());
    }
}
