package p007b.p225i.p361c.p369m.p370d.p373k;

import androidx.annotation.NonNull;
import java.util.Date;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.p384s.InterfaceC4736d;

/* JADX INFO: renamed from: b.i.c.m.d.k.b0 */
/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4611b0 implements C4648p0.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C4663x f12266a;

    public C4611b0(C4663x c4663x) {
        this.f12266a = c4663x;
    }

    /* JADX INFO: renamed from: a */
    public void m6395a(@NonNull InterfaceC4736d interfaceC4736d, @NonNull Thread thread, @NonNull Throwable th) {
        C4663x c4663x = this.f12266a;
        synchronized (c4663x) {
            C4592b.f12227a.m6371b("Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
            try {
                C4630h1.m6432a(c4663x.f12433m.m6438c(new CallableC4617d0(c4663x, new Date(), th, thread, interfaceC4736d)));
            } catch (Exception unused) {
            }
        }
    }
}
