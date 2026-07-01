package com.discord.utilities.viewcontroller;

import android.content.Context;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.analytics.Traits$Payment$Type;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: RxViewController.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class RxViewController<V extends View, T> {
    private Subscription subscription;
    private final V view;

    public RxViewController(V v) {
        m.checkNotNullParameter(v, "view");
        this.view = v;
    }

    private final <T> Subscription connectViewRx(View view, Observable<T> observable, Function1<? super T, Unit> onNext) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        Observable<T> observableA0 = observable.a0(new ViewDetachedFromWindowObservable(view).observe());
        m.checkNotNullExpressionValue(observableA0, "observable\n        .take…servable(view).observe())");
        Observable<T> observableY = ObservableExtensionsKt.ui(ObservableExtensionsKt.computationLatest(observableA0)).y(new RxViewController$connectViewRx$1(view));
        m.checkNotNullExpressionValue(observableY, "observable\n        .take…view.isAttachedToWindow }");
        ObservableExtensionsKt.appSubscribe$default(observableY, getClass(), (Context) null, new RxViewController$connectViewRx$2(ref$ObjectRef), (Function1) null, (Function0) null, (Function0) null, new RxViewController$connectViewRx$3(onNext), 58, (Object) null);
        T t = ref$ObjectRef.element;
        if (t == null) {
            m.throwUninitializedPropertyAccessException("subscriptionResult");
        }
        return (Subscription) t;
    }

    @MainThread
    public final void bind() {
        Subscription subscription = this.subscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.subscription = connectViewRx(this.view, observeState(), new RxViewController$bind$1(this));
    }

    public abstract void configureView(T viewState);

    public final V getView() {
        return this.view;
    }

    public abstract Observable<T> observeState();
}
