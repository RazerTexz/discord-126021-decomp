package b.i.c.m.d.m;

import java.io.IOException;

/* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$b implements b.i.c.p.c<v> {
    public static final a$b a = new a$b();

    @Override // b.i.c.p.b
    public void a(Object obj, b.i.c.p.d dVar) throws IOException {
        v vVar = (v) obj;
        b.i.c.p.d dVar2 = dVar;
        dVar2.f("sdkVersion", vVar.g());
        dVar2.f("gmpAppId", vVar.c());
        dVar2.c("platform", vVar.f());
        dVar2.f("installationUuid", vVar.d());
        dVar2.f("buildVersion", vVar.a());
        dVar2.f("displayVersion", vVar.b());
        dVar2.f("session", vVar.h());
        dVar2.f("ndkPayload", vVar.e());
    }
}
