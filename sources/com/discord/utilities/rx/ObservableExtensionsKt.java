package com.discord.utilities.rx;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.discord.app.AppComponent;
import com.discord.restapi.utils.RetryWithDelay;
import com.discord.utilities.analytics.Traits$Payment$Type;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import d0.z.d.m;
import j0.l.a.r;
import j0.l.e.b;
import j0.p.a;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservableExtensionsKt {
    public static final <T> void appSubscribe(Observable<T> observable, Class<?> cls, Context context, Function1<? super Subscription, Unit> function1, Function1<? super Error, Unit> function2, Function0<Unit> function0, Function0<Unit> function3, Function1<? super T, Unit> function4) {
        m.checkNotNullParameter(observable, "$this$appSubscribe");
        m.checkNotNullParameter(cls, "errorClass");
        m.checkNotNullParameter(function0, "onCompleted");
        m.checkNotNullParameter(function3, "onTerminated");
        m.checkNotNullParameter(function4, "onNext");
        String simpleName = cls.getSimpleName();
        m.checkNotNullExpressionValue(simpleName, "errorClass.simpleName");
        appSubscribe(observable, context, simpleName, function1, function4, function2, function0, function3);
    }

    public static /* synthetic */ void appSubscribe$default(Observable observable, Class cls, Context context, Function1 function1, Function1 function2, Function0 function0, Function0 function3, Function1 function4, int i, Object obj) {
        appSubscribe(observable, (Class<?>) cls, (i & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((i & 4) != 0 ? null : function1), (Function1<? super Error, Unit>) ((i & 8) != 0 ? null : function2), (Function0<Unit>) ((i & 16) != 0 ? ObservableExtensionsKt$appSubscribe$1.INSTANCE : function0), (Function0<Unit>) ((i & 32) != 0 ? ObservableExtensionsKt$appSubscribe$2.INSTANCE : function3), function4);
    }

    public static final <T> Observable<T> bindToComponentLifecycle(Observable<T> observable, AppComponent appComponent, MGRecyclerAdapterSimple<?> mGRecyclerAdapterSimple) {
        m.checkNotNullParameter(observable, "$this$bindToComponentLifecycle");
        m.checkNotNullParameter(appComponent, "appComponent");
        Observable<T> observableA0 = observable.a0(appComponent.getUnsubscribeSignal());
        if (appComponent instanceof Fragment) {
            observableA0 = observableA0.y(new ObservableExtensionsKt$bindToComponentLifecycle$$inlined$let$lambda$1(appComponent));
        }
        Observable<T> observableW = observableA0.w(new ObservableExtensionsKt$bindToComponentLifecycle$2(mGRecyclerAdapterSimple));
        m.checkNotNullExpressionValue(observableW, "takeUntil(appComponent.u…beFromUpdates()\n        }");
        return observableW;
    }

    public static /* synthetic */ Observable bindToComponentLifecycle$default(Observable observable, AppComponent appComponent, MGRecyclerAdapterSimple mGRecyclerAdapterSimple, int i, Object obj) {
        if ((i & 2) != 0) {
            mGRecyclerAdapterSimple = null;
        }
        return bindToComponentLifecycle(observable, appComponent, mGRecyclerAdapterSimple);
    }

    public static final <T> Observable<T> computationBuffered(Observable<T> observable) {
        m.checkNotNullParameter(observable, "$this$computationBuffered");
        Observable<T> observableJ = observable.K().X(a.a()).J(a.a());
        m.checkNotNullExpressionValue(observableJ, "onBackpressureBuffer()\n …Schedulers.computation())");
        return observableJ;
    }

    public static final <T> Observable<T> computationLatest(Observable<T> observable) {
        m.checkNotNullParameter(observable, "$this$computationLatest");
        Observable<T> observableJ = observable.L().X(a.a()).J(a.a());
        m.checkNotNullExpressionValue(observableJ, "onBackpressureLatest()\n …Schedulers.computation())");
        return observableJ;
    }

    public static final /* synthetic */ <T> Observable<T> filterIs(Observable<?> observable) {
        m.checkNotNullParameter(observable, "$this$filterIs");
        m.needClassReification();
        Observable<?> observableY = observable.y(ObservableExtensionsKt$filterIs$1.INSTANCE);
        m.needClassReification();
        Observable<T> observable2 = (Observable<T>) observableY.G(ObservableExtensionsKt$filterIs$2.INSTANCE);
        m.checkNotNullExpressionValue(observable2, "filter { it is T }.map { it as T }");
        return observable2;
    }

    public static final /* synthetic */ <T> Observable<T> filterNull(Observable<T> observable) {
        m.checkNotNullParameter(observable, "$this$filterNull");
        Observable<T> observable2 = (Observable<T>) observable.y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observable2, "filter { it != null }.map { it!! }");
        return observable2;
    }

    public static final <T> Observable<T> leadingEdgeThrottle(Observable<T> observable, long j, TimeUnit timeUnit) {
        m.checkNotNullParameter(observable, "$this$leadingEdgeThrottle");
        m.checkNotNullParameter(timeUnit, "timeUnit");
        Observable<T> observableH0 = Observable.h0(new r(observable.j, new LeadingEdgeThrottle(j, timeUnit)));
        m.checkNotNullExpressionValue(observableH0, "lift(LeadingEdgeThrottle…indowDuration, timeUnit))");
        return observableH0;
    }

    public static final <T> Observable<T> restSubscribeOn(Observable<T> observable, boolean z2) {
        m.checkNotNullParameter(observable, "$this$restSubscribeOn");
        Observable<T> observableX = observable.X(a.c());
        if (z2) {
            RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
            m.checkNotNullExpressionValue(observableX, "observable");
            observableX = RetryWithDelay.restRetry$default(retryWithDelay, observableX, 0L, null, null, 7, null);
        }
        m.checkNotNullExpressionValue(observableX, "subscribeOn(Schedulers.i… observable\n      }\n    }");
        return observableX;
    }

    public static /* synthetic */ Observable restSubscribeOn$default(Observable observable, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return restSubscribeOn(observable, z2);
    }

    public static final <T> Observable<T> takeSingleUntilTimeout(Observable<T> observable, long j, boolean z2) {
        m.checkNotNullParameter(observable, "$this$takeSingleUntilTimeout");
        Observable<T> observableZ = observable.Z(1);
        Observable<T> observableC0 = z2 ? observableZ.c0(j, TimeUnit.MILLISECONDS) : observableZ.a0(Observable.d0(j, TimeUnit.MILLISECONDS));
        m.checkNotNullExpressionValue(observableC0, "take(1).let {\n      if (…LISECONDS))\n      }\n    }");
        return computationLatest(observableC0);
    }

    public static /* synthetic */ Observable takeSingleUntilTimeout$default(Observable observable, long j, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 5000;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return takeSingleUntilTimeout(observable, j, z2);
    }

    public static final <K, V> Observable<Map<K, V>> toMap(Observable<Pair<K, V>> observable) {
        m.checkNotNullParameter(observable, "$this$toMap");
        Observable<Map<K, V>> observableG0 = observable.g0(ObservableExtensionsKt$toMap$1.INSTANCE, ObservableExtensionsKt$toMap$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG0, "toMap({ it.first }, { it.second })");
        return observableG0;
    }

    public static final <T> Observable<T> ui(Observable<T> observable) {
        m.checkNotNullParameter(observable, "$this$ui");
        Observable<T> observableJ = observable.J(j0.j.b.a.a());
        m.checkNotNullExpressionValue(observableJ, "observeOn(AndroidSchedulers.mainThread())");
        return observableJ;
    }

    public static /* synthetic */ Observable ui$default(Observable observable, AppComponent appComponent, MGRecyclerAdapterSimple mGRecyclerAdapterSimple, int i, Object obj) {
        if ((i & 2) != 0) {
            mGRecyclerAdapterSimple = null;
        }
        return ui(observable, appComponent, mGRecyclerAdapterSimple);
    }

    public static final <T> Observable<T> withDimmer(Observable<T> observable, DimmerView dimmerView, long j) {
        m.checkNotNullParameter(observable, "$this$withDimmer");
        Observable<T> observableH0 = Observable.h0(new r(observable.j, new OnDelayedEmissionHandler(new ObservableExtensionsKt$withDimmer$1(dimmerView), j, TimeUnit.MILLISECONDS, null, 8, null)));
        m.checkNotNullExpressionValue(observableH0, "lift(\n        OnDelayedE…LISECONDS\n        )\n    )");
        return observableH0;
    }

    public static /* synthetic */ Observable withDimmer$default(Observable observable, DimmerView dimmerView, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 300;
        }
        return withDimmer(observable, dimmerView, j);
    }

    public static final <T> Observable<T> ui(Observable<T> observable, AppComponent appComponent, MGRecyclerAdapterSimple<?> mGRecyclerAdapterSimple) {
        m.checkNotNullParameter(observable, "$this$ui");
        m.checkNotNullParameter(appComponent, "appComponent");
        return bindToComponentLifecycle(ui(observable), appComponent, mGRecyclerAdapterSimple);
    }

    public static final <T> void appSubscribe(Observable<T> observable, Context context, String str, Function1<? super Subscription, Unit> function1, Function1<? super T, Unit> function2, Function1<? super Error, Unit> function3, Function0<Unit> function0, Function0<Unit> function4) {
        m.checkNotNullParameter(observable, "$this$appSubscribe");
        m.checkNotNullParameter(str, "errorTag");
        m.checkNotNullParameter(function2, "onNext");
        m.checkNotNullParameter(function0, "onCompleted");
        m.checkNotNullParameter(function4, "onTerminated");
        WeakReference weakReference = new WeakReference(context);
        ObservableExtensionsKt$sam$rx_functions_Action1$0 observableExtensionsKt$sam$rx_functions_Action1$0 = new ObservableExtensionsKt$sam$rx_functions_Action1$0(function2);
        ObservableExtensionsKt$appSubscribe$subscription$1 observableExtensionsKt$appSubscribe$subscription$1 = new ObservableExtensionsKt$appSubscribe$subscription$1(str, function3, weakReference, function4);
        ObservableExtensionsKt$appSubscribe$subscription$2 observableExtensionsKt$appSubscribe$subscription$2 = new ObservableExtensionsKt$appSubscribe$subscription$2(function0, function4);
        Objects.requireNonNull(observable);
        Subscription subscriptionU = observable.U(new b(observableExtensionsKt$sam$rx_functions_Action1$0, observableExtensionsKt$appSubscribe$subscription$1, observableExtensionsKt$appSubscribe$subscription$2));
        if (function1 != null) {
            m.checkNotNullExpressionValue(subscriptionU, Traits$Payment$Type.SUBSCRIPTION);
            function1.invoke(subscriptionU);
        }
    }

    public static /* synthetic */ void appSubscribe$default(Observable observable, Context context, String str, Function1 function1, Function1 function2, Function1 function3, Function0 function0, Function0 function4, int i, Object obj) {
        appSubscribe(observable, (i & 1) != 0 ? null : context, str, (Function1<? super Subscription, Unit>) ((i & 4) != 0 ? null : function1), function2, (Function1<? super Error, Unit>) ((i & 16) != 0 ? null : function3), (Function0<Unit>) ((i & 32) != 0 ? ObservableExtensionsKt$appSubscribe$3.INSTANCE : function0), (Function0<Unit>) ((i & 64) != 0 ? ObservableExtensionsKt$appSubscribe$4.INSTANCE : function4));
    }
}
