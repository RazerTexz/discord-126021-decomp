package b.i.c.m.d.k;

import androidx.annotation.NonNull;
import java.util.Date;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class b0 implements p0$a {
    public final /* synthetic */ x a;

    public b0(x xVar) {
        this.a = xVar;
    }

    public void a(@NonNull b.i.c.m.d.s.d dVar, @NonNull Thread thread, @NonNull Throwable th) {
        x xVar = this.a;
        synchronized (xVar) {
            b.i.c.m.d.b.a.b("Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
            try {
                h1.a(xVar.m.c(new d0(xVar, new Date(), th, thread, dVar)));
            } catch (Exception unused) {
            }
        }
    }
}
