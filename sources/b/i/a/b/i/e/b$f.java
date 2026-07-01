package b.i.a.b.i.e;

import java.io.IOException;

/* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b$f implements b.i.c.p.c<o> {
    public static final b$f a = new b$f();

    @Override // b.i.c.p.b
    public void a(Object obj, b.i.c.p.d dVar) throws IOException {
        o oVar = (o) obj;
        b.i.c.p.d dVar2 = dVar;
        dVar2.f("networkType", oVar.b());
        dVar2.f("mobileSubtype", oVar.a());
    }
}
