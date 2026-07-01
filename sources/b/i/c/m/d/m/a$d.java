package b.i.c.m.d.m;

import java.io.IOException;

/* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$d implements b.i.c.p.c<v$c$a> {
    public static final a$d a = new a$d();

    @Override // b.i.c.p.b
    public void a(Object obj, b.i.c.p.d dVar) throws IOException {
        v$c$a v_c_a = (v$c$a) obj;
        b.i.c.p.d dVar2 = dVar;
        dVar2.f("filename", v_c_a.b());
        dVar2.f("contents", v_c_a.a());
    }
}
