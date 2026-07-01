package b.i.a.b.i.e;

import java.io.IOException;

/* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b$c implements b.i.c.p.c<k> {
    public static final b$c a = new b$c();

    @Override // b.i.c.p.b
    public void a(Object obj, b.i.c.p.d dVar) throws IOException {
        k kVar = (k) obj;
        b.i.c.p.d dVar2 = dVar;
        dVar2.f("clientType", kVar.b());
        dVar2.f("androidClientInfo", kVar.a());
    }
}
