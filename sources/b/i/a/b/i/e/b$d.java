package b.i.a.b.i.e;

import java.io.IOException;

/* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b$d implements b.i.c.p.c<l> {
    public static final b$d a = new b$d();

    @Override // b.i.c.p.b
    public void a(Object obj, b.i.c.p.d dVar) throws IOException {
        l lVar = (l) obj;
        b.i.c.p.d dVar2 = dVar;
        dVar2.b("eventTimeMs", lVar.b());
        dVar2.f("eventCode", lVar.a());
        dVar2.b("eventUptimeMs", lVar.c());
        dVar2.f("sourceExtension", lVar.e());
        dVar2.f("sourceExtensionJsonProto3", lVar.f());
        dVar2.b("timezoneOffsetSeconds", lVar.g());
        dVar2.f("networkConnectionInfo", lVar.d());
    }
}
