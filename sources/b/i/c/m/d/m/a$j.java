package b.i.c.m.d.m;

import com.discord.models.domain.ModelAuditLogEntry;
import java.io.IOException;

/* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$j implements b.i.c.p.c<v$d$d$a$b$a> {
    public static final a$j a = new a$j();

    @Override // b.i.c.p.b
    public void a(Object obj, b.i.c.p.d dVar) throws IOException {
        v$d$d$a$b$a v_d_d_a_b_a = (v$d$d$a$b$a) obj;
        b.i.c.p.d dVar2 = dVar;
        dVar2.b("baseAddress", v_d_d_a_b_a.a());
        dVar2.b("size", v_d_d_a_b_a.c());
        dVar2.f(ModelAuditLogEntry.CHANGE_KEY_NAME, v_d_d_a_b_a.b());
        String strD = v_d_d_a_b_a.d();
        dVar2.f("uuid", strD != null ? strD.getBytes(v.a) : null);
    }
}
