package b.i.a.f.h.l;

import android.app.Activity;
import android.app.Application$ActivityLifecycleCallbacks;
import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class g$b implements Application$ActivityLifecycleCallbacks {
    public final /* synthetic */ g j;

    public g$b(g gVar) {
        this.j = gVar;
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        g gVar = this.j;
        gVar.e.execute(new e0(this, bundle, activity));
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        g gVar = this.j;
        gVar.e.execute(new j0(this, activity));
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        g gVar = this.j;
        gVar.e.execute(new f0(this, activity));
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        g gVar = this.j;
        gVar.e.execute(new g0(this, activity));
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        cc ccVar = new cc();
        g gVar = this.j;
        gVar.e.execute(new h0(this, activity, ccVar));
        Bundle bundleT0 = ccVar.t0(50L);
        if (bundleT0 != null) {
            bundle.putAll(bundleT0);
        }
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        g gVar = this.j;
        gVar.e.execute(new d0(this, activity));
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        g gVar = this.j;
        gVar.e.execute(new i0(this, activity));
    }
}
