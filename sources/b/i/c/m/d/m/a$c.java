package b.i.c.m.d.m;

import com.discord.utilities.analytics.ChatInputComponentTypes;
import java.io.IOException;

/* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$c implements b.i.c.p.c<v$c> {
    public static final a$c a = new a$c();

    @Override // b.i.c.p.b
    public void a(Object obj, b.i.c.p.d dVar) throws IOException {
        v$c v_c = (v$c) obj;
        b.i.c.p.d dVar2 = dVar;
        dVar2.f(ChatInputComponentTypes.FILES, v_c.a());
        dVar2.f("orgId", v_c.b());
    }
}
