package p007b.p008a.p020e;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserModel;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: b.a.e.b */
/* JADX INFO: compiled from: Backgrounded.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0892b implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Function1 f595j;

    public C0892b(Function1 function1) {
        this.f595j = function1;
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
        C0894d c0894d = C0894d.f600d;
        Function1 function1 = this.f595j;
        Observable<T> observableM11111q = new C12721k(Boolean.TRUE).m11111q(2000L, TimeUnit.MILLISECONDS);
        C0893c c0893c = new C0893c(new C0891a(c0894d));
        Object c0893c2 = function1;
        if (function1 != null) {
            c0893c2 = new C0893c(function1);
        }
        C0894d.f599c = observableM11111q.m11097W(c0893c, (Action1) c0893c2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        C0894d c0894d = C0894d.f600d;
        C0894d.f597a = false;
        Subscription subscription = C0894d.f599c;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        C0894d.f598b.onNext(Boolean.FALSE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        C12238m.checkNotNullParameter(bundle, "bundle");
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
