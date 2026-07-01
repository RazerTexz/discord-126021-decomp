package b.a.s;

import android.app.Activity;
import android.app.Application$ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.provider.MediaStore$Images$Media;
import androidx.appcompat.widget.ActivityChooserModel;
import d0.z.d.m;

/* JADX INFO: compiled from: ScreenshotDetector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Application$ActivityLifecycleCallbacks {
    public boolean j;
    public final b k;

    public a(b bVar) {
        m.checkNotNullParameter(bVar, "observer");
        this.k = bVar;
    }

    public final void a(boolean z2) {
        if (!z2 && this.j) {
            b bVar = this.k;
            bVar.d.unregisterContentObserver(bVar);
            this.j = false;
        }
        if (!z2 || this.j) {
            return;
        }
        b bVar2 = this.k;
        bVar2.d.registerContentObserver(MediaStore$Images$Media.EXTERNAL_CONTENT_URI, true, bVar2);
        this.j = true;
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (this.j) {
            b bVar = this.k;
            bVar.d.unregisterContentObserver(bVar);
            this.j = false;
        }
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (this.j) {
            return;
        }
        b bVar = this.k;
        bVar.d.registerContentObserver(MediaStore$Images$Media.EXTERNAL_CONTENT_URI, true, bVar);
        this.j = true;
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        m.checkNotNullParameter(bundle, "outState");
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }
}
