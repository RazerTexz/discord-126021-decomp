package b.i.a.b.i.e;

import java.io.IOException;

/* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b$a implements b.i.c.p.c<a> {
    public static final b$a a = new b$a();

    @Override // b.i.c.p.b
    public void a(Object obj, b.i.c.p.d dVar) throws IOException {
        a aVar = (a) obj;
        b.i.c.p.d dVar2 = dVar;
        dVar2.f("sdkVersion", aVar.l());
        dVar2.f("model", aVar.i());
        dVar2.f("hardware", aVar.e());
        dVar2.f("device", aVar.c());
        dVar2.f("product", aVar.k());
        dVar2.f("osBuild", aVar.j());
        dVar2.f("manufacturer", aVar.g());
        dVar2.f("fingerprint", aVar.d());
        dVar2.f("locale", aVar.f());
        dVar2.f("country", aVar.b());
        dVar2.f("mccMnc", aVar.h());
        dVar2.f("applicationBuild", aVar.a());
    }
}
