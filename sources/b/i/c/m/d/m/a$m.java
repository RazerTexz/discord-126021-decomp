package b.i.c.m.d.m;

import com.discord.models.domain.ModelAuditLogEntry;
import java.io.IOException;

/* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$m implements b.i.c.p.c<v$d$d$a$b$c> {
    public static final a$m a = new a$m();

    @Override // b.i.c.p.b
    public void a(Object obj, b.i.c.p.d dVar) throws IOException {
        v$d$d$a$b$c v_d_d_a_b_c = (v$d$d$a$b$c) obj;
        b.i.c.p.d dVar2 = dVar;
        dVar2.f(ModelAuditLogEntry.CHANGE_KEY_NAME, v_d_d_a_b_c.c());
        dVar2.f(ModelAuditLogEntry.CHANGE_KEY_CODE, v_d_d_a_b_c.b());
        dVar2.b("address", v_d_d_a_b_c.a());
    }
}
