package b.i.c.m.d.m;

import java.io.IOException;

/* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a implements b.i.c.p.c<v$b> {
    public static final a$a a = new a$a();

    @Override // b.i.c.p.b
    public void a(Object obj, b.i.c.p.d dVar) throws IOException {
        v$b v_b = (v$b) obj;
        b.i.c.p.d dVar2 = dVar;
        dVar2.f("key", v_b.a());
        dVar2.f("value", v_b.b());
    }
}
