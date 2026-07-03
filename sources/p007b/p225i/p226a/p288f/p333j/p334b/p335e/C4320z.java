package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3301k;

/* JADX INFO: renamed from: b.i.a.f.j.b.e.z */
/* JADX INFO: loaded from: classes3.dex */
public final class C4320z implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: j */
    public final Activity f11441j;

    /* JADX INFO: renamed from: k */
    public final C4286i f11442k;

    public C4320z(Activity activity, C4286i c4286i, C4302q c4302q) {
        this.f11441j = activity;
        this.f11442k = c4286i;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (activity == this.f11441j) {
            Log.v("NearbyMessages", String.format("Unregistering ClientLifecycleSafetyNet's ActivityLifecycleCallbacks for %s", activity.getPackageName()));
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        if (activity == this.f11441j) {
            C4286i c4286i = this.f11442k;
            final int i = 1;
            c4286i.m4046c(new C4318y(c4286i, new InterfaceC4269a0(i) { // from class: b.i.a.f.j.b.e.p
                @Override // p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4269a0
                /* JADX INFO: renamed from: a */
                public final void mo5981a(C4280f c4280f, C3301k c3301k) throws RemoteException {
                    c4280f.m5982G(1);
                }
            }));
        }
    }
}
