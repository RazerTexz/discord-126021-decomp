package p007b.p008a.p049s;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.appcompat.widget.ActivityChooserModel;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.s.a */
/* JADX INFO: compiled from: ScreenshotDetector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1273a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: j */
    public boolean f1877j;

    /* JADX INFO: renamed from: k */
    public final C1274b f1878k;

    public C1273a(C1274b c1274b) {
        C12238m.checkNotNullParameter(c1274b, "observer");
        this.f1878k = c1274b;
    }

    /* JADX INFO: renamed from: a */
    public final void m364a(boolean z2) {
        if (!z2 && this.f1877j) {
            C1274b c1274b = this.f1878k;
            c1274b.f1882d.unregisterContentObserver(c1274b);
            this.f1877j = false;
        }
        if (!z2 || this.f1877j) {
            return;
        }
        C1274b c1274b2 = this.f1878k;
        c1274b2.f1882d.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, c1274b2);
        this.f1877j = true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (this.f1877j) {
            C1274b c1274b = this.f1878k;
            c1274b.f1882d.unregisterContentObserver(c1274b);
            this.f1877j = false;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (this.f1877j) {
            return;
        }
        C1274b c1274b = this.f1878k;
        c1274b.f1882d.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, c1274b);
        this.f1877j = true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        C12238m.checkNotNullParameter(bundle, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }
}
