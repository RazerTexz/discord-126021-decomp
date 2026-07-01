package b.i.c.m.d.k;

import androidx.annotation.NonNull;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.k.CrashlyticsUncaughtExceptionHandler;
import b.i.c.m.d.s.SettingsDataProvider;
import java.util.Date;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class b0 implements CrashlyticsUncaughtExceptionHandler.a {
    public final /* synthetic */ x a;

    public b0(x xVar) {
        this.a = xVar;
    }

    public void a(@NonNull SettingsDataProvider settingsDataProvider, @NonNull Thread thread, @NonNull Throwable th) {
        x xVar = this.a;
        synchronized (xVar) {
            Logger3.a.b("Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
            try {
                Utils3.a(xVar.m.c(new d0(xVar, new Date(), th, thread, settingsDataProvider)));
            } catch (Exception unused) {
            }
        }
    }
}
