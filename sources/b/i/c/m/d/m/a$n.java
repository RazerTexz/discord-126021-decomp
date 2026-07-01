package b.i.c.m.d.m;

import com.discord.models.domain.ModelAuditLogEntry;
import java.io.IOException;

/* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$n implements b.i.c.p.c<v$d$d$a$b$d> {
    public static final a$n a = new a$n();

    @Override // b.i.c.p.b
    public void a(Object obj, b.i.c.p.d dVar) throws IOException {
        v$d$d$a$b$d v_d_d_a_b_d = (v$d$d$a$b$d) obj;
        b.i.c.p.d dVar2 = dVar;
        dVar2.f(ModelAuditLogEntry.CHANGE_KEY_NAME, v_d_d_a_b_d.c());
        dVar2.c("importance", v_d_d_a_b_d.b());
        dVar2.f("frames", v_d_d_a_b_d.a());
    }
}
