package b.i.c.m.d.m;

import com.discord.models.domain.ModelAuditLogEntry;
import java.io.IOException;

/* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$l implements b.i.c.p.c<v$d$d$a$b$b> {
    public static final a$l a = new a$l();

    @Override // b.i.c.p.b
    public void a(Object obj, b.i.c.p.d dVar) throws IOException {
        v$d$d$a$b$b v_d_d_a_b_b = (v$d$d$a$b$b) obj;
        b.i.c.p.d dVar2 = dVar;
        dVar2.f("type", v_d_d_a_b_b.e());
        dVar2.f(ModelAuditLogEntry.CHANGE_KEY_REASON, v_d_d_a_b_b.d());
        dVar2.f("frames", v_d_d_a_b_b.b());
        dVar2.f("causedBy", v_d_d_a_b_b.a());
        dVar2.c("overflowCount", v_d_d_a_b_b.c());
    }
}
