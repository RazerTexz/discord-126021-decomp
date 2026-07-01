package b.a.e;

import android.app.Activity;
import android.app.Application$ActivityLifecycleCallbacks;
import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserModel;
import d0.z.d.m;
import j0.l.e.k;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/* JADX INFO: compiled from: Backgrounded.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Application$ActivityLifecycleCallbacks {
    public final /* synthetic */ Function1 j;

    public b(Function1 function1) {
        this.j = function1;
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
        d dVar = d.d;
        Function1 function1 = this.j;
        Observable<T> observableQ = new k(Boolean.TRUE).q(2000L, TimeUnit.MILLISECONDS);
        c cVar = new c(new a(dVar));
        Object cVar2 = function1;
        if (function1 != null) {
            cVar2 = new c(function1);
        }
        d.c = observableQ.W(cVar, (Action1) cVar2);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        d dVar = d.d;
        d.a = false;
        Subscription subscription = d.c;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        d.f65b.onNext(Boolean.FALSE);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        m.checkNotNullParameter(bundle, "bundle");
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
