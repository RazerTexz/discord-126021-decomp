package b.a.s;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.appcompat.widget.ActivityChooserModel;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.a.s.a, reason: use source file name */
/* JADX INFO: compiled from: ScreenshotDetector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ScreenshotDetector2 implements Application.ActivityLifecycleCallbacks {
    public boolean j;
    public final ScreenshotContentObserver k;

    public ScreenshotDetector2(ScreenshotContentObserver screenshotContentObserver) {
        Intrinsics3.checkNotNullParameter(screenshotContentObserver, "observer");
        this.k = screenshotContentObserver;
    }

    public final void a(boolean z2) {
        if (!z2 && this.j) {
            ScreenshotContentObserver screenshotContentObserver = this.k;
            screenshotContentObserver.d.unregisterContentObserver(screenshotContentObserver);
            this.j = false;
        }
        if (!z2 || this.j) {
            return;
        }
        ScreenshotContentObserver screenshotContentObserver2 = this.k;
        screenshotContentObserver2.d.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, screenshotContentObserver2);
        this.j = true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (this.j) {
            ScreenshotContentObserver screenshotContentObserver = this.k;
            screenshotContentObserver.d.unregisterContentObserver(screenshotContentObserver);
            this.j = false;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (this.j) {
            return;
        }
        ScreenshotContentObserver screenshotContentObserver = this.k;
        screenshotContentObserver.d.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, screenshotContentObserver);
        this.j = true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(bundle, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }
}
