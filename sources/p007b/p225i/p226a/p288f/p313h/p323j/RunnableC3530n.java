package p007b.p225i.p226a.p288f.p313h.p323j;

import android.content.ComponentName;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p291b.C3180f;

/* JADX INFO: renamed from: b.i.a.f.h.j.n */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC3530n implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ ComponentName f9762j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ ServiceConnectionC3526l f9763k;

    public RunnableC3530n(ServiceConnectionC3526l serviceConnectionC3526l, ComponentName componentName) {
        this.f9763k = serviceConnectionC3526l;
        this.f9762j = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C3522j c3522j = this.f9763k.f9756l;
        ComponentName componentName = this.f9762j;
        Objects.requireNonNull(c3522j);
        C3180f.m3967b();
        if (c3522j.f9743m != null) {
            c3522j.f9743m = null;
            c3522j.m4431b("Disconnected from device AnalyticsService", componentName);
            C3497a c3497aM4436s = c3522j.m4436s();
            c3497aM4436s.m4444N();
            C3180f.m3967b();
            C3538r c3538r = c3497aM4436s.f9661l;
            C3180f.m3967b();
            c3538r.m4444N();
            c3538r.m4427C("Service disconnected");
        }
    }
}
