package b.i.a.b.i.e;

import java.io.IOException;

/* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b$e implements b.i.c.p.c<m> {
    public static final b$e a = new b$e();

    @Override // b.i.c.p.b
    public void a(Object obj, b.i.c.p.d dVar) throws IOException {
        m mVar = (m) obj;
        b.i.c.p.d dVar2 = dVar;
        dVar2.b("requestTimeMs", mVar.f());
        dVar2.b("requestUptimeMs", mVar.g());
        dVar2.f("clientInfo", mVar.a());
        dVar2.f("logSource", mVar.c());
        dVar2.f("logSourceName", mVar.d());
        dVar2.f("logEvent", mVar.b());
        dVar2.f("qosTier", mVar.e());
    }
}
