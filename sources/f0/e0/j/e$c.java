package f0.e0.j;

import java.io.IOException;

/* JADX INFO: compiled from: Http2Connection.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e$c {
    public static final e$c a = new e$c$a();

    public void a(e eVar, s sVar) {
        d0.z.d.m.checkParameterIsNotNull(eVar, "connection");
        d0.z.d.m.checkParameterIsNotNull(sVar, "settings");
    }

    public abstract void b(n nVar) throws IOException;
}
