package b.i.a.f.h.j;

import android.content.ComponentName;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements Runnable {
    public final /* synthetic */ ComponentName j;
    public final /* synthetic */ l k;

    public n(l lVar, ComponentName componentName) {
        this.k = lVar;
        this.j = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.k.l;
        ComponentName componentName = this.j;
        Objects.requireNonNull(jVar);
        b.i.a.f.b.f.b();
        if (jVar.m != null) {
            jVar.m = null;
            jVar.b("Disconnected from device AnalyticsService", componentName);
            a aVarS = jVar.s();
            aVarS.N();
            b.i.a.f.b.f.b();
            r rVar = aVarS.l;
            b.i.a.f.b.f.b();
            rVar.N();
            rVar.C("Service disconnected");
        }
    }
}
