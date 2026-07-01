package com.discord.utilities.rx;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.discord.app.AppComponent;
import com.discord.restapi.utils.RetryWithDelay;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.j.b.AndroidSchedulers;
import j0.k.Func1;
import j0.l.a.OnSubscribeLift;
import j0.l.e.ActionSubscriber;
import j0.p.Schedulers2;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservableExtensionsKt {

    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$appSubscribe$1, reason: invalid class name */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$appSubscribe$2, reason: invalid class name */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$appSubscribe$3, reason: invalid class name */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$appSubscribe$4, reason: invalid class name */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1, reason: invalid class name */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class AnonymousClass1<T, R> implements Func1<T, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // j0.k.Func1
        public final Boolean call(T t) {
            return Boolean.valueOf(t != null);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2, reason: invalid class name */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class AnonymousClass2<T, R> implements Func1<T, T> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.Func1
        public final T call(T t) {
            Intrinsics3.checkNotNull(t);
            return t;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$withDimmer$1, reason: invalid class name */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ DimmerView $dimmer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DimmerView dimmerView) {
            super(1);
            this.$dimmer = dimmerView;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            DimmerView dimmerView = this.$dimmer;
            if (dimmerView != null) {
                DimmerView.setDimmed$default(dimmerView, z2, false, 2, null);
            }
        }
    }

    public static final <T> void appSubscribe(Observable<T> observable, Class<?> cls, Context context, Function1<? super Subscription, Unit> function1, Function1<? super Error, Unit> function2, Function0<Unit> function0, Function0<Unit> function3, Function1<? super T, Unit> function4) {
        Intrinsics3.checkNotNullParameter(observable, "$this$appSubscribe");
        Intrinsics3.checkNotNullParameter(cls, "errorClass");
        Intrinsics3.checkNotNullParameter(function0, "onCompleted");
        Intrinsics3.checkNotNullParameter(function3, "onTerminated");
        Intrinsics3.checkNotNullParameter(function4, "onNext");
        String simpleName = cls.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "errorClass.simpleName");
        appSubscribe(observable, context, simpleName, function1, function4, function2, function0, function3);
    }

    public static final <T> Observable<T> bindToComponentLifecycle(Observable<T> observable, final AppComponent appComponent, final MGRecyclerAdapterSimple<?> mGRecyclerAdapterSimple) {
        Intrinsics3.checkNotNullParameter(observable, "$this$bindToComponentLifecycle");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Observable<T> observableA0 = observable.a0(appComponent.getUnsubscribeSignal());
        if (appComponent instanceof Fragment) {
            observableA0 = observableA0.y(new Func1<T, Boolean>() { // from class: com.discord.utilities.rx.ObservableExtensionsKt$bindToComponentLifecycle$$inlined$let$lambda$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // j0.k.Func1
                public final Boolean call(T t) {
                    FragmentActivity fragmentActivityE;
                    return Boolean.valueOf((!((Fragment) appComponent).isAdded() || ((Fragment) appComponent).isRemoving() || (fragmentActivityE = ((Fragment) appComponent).e()) == null || fragmentActivityE.isFinishing()) ? false : true);
                }
            });
        }
        Observable<T> observableW = observableA0.w(new Action0() { // from class: com.discord.utilities.rx.ObservableExtensionsKt.bindToComponentLifecycle.2
            @Override // rx.functions.Action0
            public final void call() {
                MGRecyclerAdapterSimple mGRecyclerAdapterSimple2 = mGRecyclerAdapterSimple;
                if (mGRecyclerAdapterSimple2 != null) {
                    mGRecyclerAdapterSimple2.unsubscribeFromUpdates();
                }
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableW, "takeUntil(appComponent.u…beFromUpdates()\n        }");
        return observableW;
    }

    public static /* synthetic */ Observable bindToComponentLifecycle$default(Observable observable, AppComponent appComponent, MGRecyclerAdapterSimple mGRecyclerAdapterSimple, int i, Object obj) {
        if ((i & 2) != 0) {
            mGRecyclerAdapterSimple = null;
        }
        return bindToComponentLifecycle(observable, appComponent, mGRecyclerAdapterSimple);
    }

    public static final <T> Observable<T> computationBuffered(Observable<T> observable) {
        Intrinsics3.checkNotNullParameter(observable, "$this$computationBuffered");
        Observable<T> observableJ = observable.K().X(Schedulers2.a()).J(Schedulers2.a());
        Intrinsics3.checkNotNullExpressionValue(observableJ, "onBackpressureBuffer()\n …Schedulers.computation())");
        return observableJ;
    }

    public static final <T> Observable<T> computationLatest(Observable<T> observable) {
        Intrinsics3.checkNotNullParameter(observable, "$this$computationLatest");
        Observable<T> observableJ = observable.L().X(Schedulers2.a()).J(Schedulers2.a());
        Intrinsics3.checkNotNullExpressionValue(observableJ, "onBackpressureLatest()\n …Schedulers.computation())");
        return observableJ;
    }

    public static final /* synthetic */ <T> Observable<T> filterIs(Observable<?> observable) {
        Intrinsics3.checkNotNullParameter(observable, "$this$filterIs");
        Intrinsics3.needClassReification();
        Observable<?> observableY = observable.y(new Func1<Object, Boolean>() { // from class: com.discord.utilities.rx.ObservableExtensionsKt.filterIs.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // j0.k.Func1
            public final Boolean call(Object obj) {
                Intrinsics3.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                return Boolean.valueOf(obj instanceof Object);
            }
        });
        Intrinsics3.needClassReification();
        Observable<T> observable2 = (Observable<T>) observableY.G(new Func1<Object, T>() { // from class: com.discord.utilities.rx.ObservableExtensionsKt.filterIs.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // j0.k.Func1
            public final T call(Object obj) {
                Intrinsics3.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                return obj;
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observable2, "filter { it is T }.map { it as T }");
        return observable2;
    }

    public static final /* synthetic */ <T> Observable<T> filterNull(Observable<T> observable) {
        Intrinsics3.checkNotNullParameter(observable, "$this$filterNull");
        Observable<T> observable2 = (Observable<T>) observable.y(AnonymousClass1.INSTANCE).G(AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observable2, "filter { it != null }.map { it!! }");
        return observable2;
    }

    public static final <T> Observable<T> leadingEdgeThrottle(Observable<T> observable, long j, TimeUnit timeUnit) {
        Intrinsics3.checkNotNullParameter(observable, "$this$leadingEdgeThrottle");
        Intrinsics3.checkNotNullParameter(timeUnit, "timeUnit");
        Observable<T> observableH0 = Observable.h0(new OnSubscribeLift(observable.j, new LeadingEdgeThrottle(j, timeUnit)));
        Intrinsics3.checkNotNullExpressionValue(observableH0, "lift(LeadingEdgeThrottle…indowDuration, timeUnit))");
        return observableH0;
    }

    public static final <T> Observable<T> restSubscribeOn(Observable<T> observable, boolean z2) {
        Intrinsics3.checkNotNullParameter(observable, "$this$restSubscribeOn");
        Observable<T> observableX = observable.X(Schedulers2.c());
        if (z2) {
            RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(observableX, "observable");
            observableX = RetryWithDelay.restRetry$default(retryWithDelay, observableX, 0L, null, null, 7, null);
        }
        Intrinsics3.checkNotNullExpressionValue(observableX, "subscribeOn(Schedulers.i… observable\n      }\n    }");
        return observableX;
    }

    public static /* synthetic */ Observable restSubscribeOn$default(Observable observable, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return restSubscribeOn(observable, z2);
    }

    public static final <T> Observable<T> takeSingleUntilTimeout(Observable<T> observable, long j, boolean z2) {
        Intrinsics3.checkNotNullParameter(observable, "$this$takeSingleUntilTimeout");
        Observable<T> observableZ = observable.Z(1);
        Observable<T> observableC0 = z2 ? observableZ.c0(j, TimeUnit.MILLISECONDS) : observableZ.a0(Observable.d0(j, TimeUnit.MILLISECONDS));
        Intrinsics3.checkNotNullExpressionValue(observableC0, "take(1).let {\n      if (…LISECONDS))\n      }\n    }");
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

    public static final <K, V> Observable<Map<K, V>> toMap(Observable<Tuples2<K, V>> observable) {
        Intrinsics3.checkNotNullParameter(observable, "$this$toMap");
        Observable<Map<K, V>> observableG0 = observable.g0(new Func1<Tuples2<? extends K, ? extends V>, K>() { // from class: com.discord.utilities.rx.ObservableExtensionsKt.toMap.1
            @Override // j0.k.Func1
            public final K call(Tuples2<? extends K, ? extends V> tuples2) {
                return tuples2.getFirst();
            }
        }, new Func1<Tuples2<? extends K, ? extends V>, V>() { // from class: com.discord.utilities.rx.ObservableExtensionsKt.toMap.2
            @Override // j0.k.Func1
            public final V call(Tuples2<? extends K, ? extends V> tuples2) {
                return tuples2.getSecond();
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG0, "toMap({ it.first }, { it.second })");
        return observableG0;
    }

    public static final <T> Observable<T> ui(Observable<T> observable) {
        Intrinsics3.checkNotNullParameter(observable, "$this$ui");
        Observable<T> observableJ = observable.J(AndroidSchedulers.a());
        Intrinsics3.checkNotNullExpressionValue(observableJ, "observeOn(AndroidSchedulers.mainThread())");
        return observableJ;
    }

    public static /* synthetic */ Observable ui$default(Observable observable, AppComponent appComponent, MGRecyclerAdapterSimple mGRecyclerAdapterSimple, int i, Object obj) {
        if ((i & 2) != 0) {
            mGRecyclerAdapterSimple = null;
        }
        return ui(observable, appComponent, mGRecyclerAdapterSimple);
    }

    public static final <T> Observable<T> withDimmer(Observable<T> observable, DimmerView dimmerView, long j) {
        Intrinsics3.checkNotNullParameter(observable, "$this$withDimmer");
        Observable<T> observableH0 = Observable.h0(new OnSubscribeLift(observable.j, new OnDelayedEmissionHandler(new AnonymousClass1(dimmerView), j, TimeUnit.MILLISECONDS, null, 8, null)));
        Intrinsics3.checkNotNullExpressionValue(observableH0, "lift(\n        OnDelayedE…LISECONDS\n        )\n    )");
        return observableH0;
    }

    public static /* synthetic */ Observable withDimmer$default(Observable observable, DimmerView dimmerView, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 300;
        }
        return withDimmer(observable, dimmerView, j);
    }

    public static final <T> Observable<T> ui(Observable<T> observable, AppComponent appComponent, MGRecyclerAdapterSimple<?> mGRecyclerAdapterSimple) {
        Intrinsics3.checkNotNullParameter(observable, "$this$ui");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        return bindToComponentLifecycle(ui(observable), appComponent, mGRecyclerAdapterSimple);
    }

    public static final <T> void appSubscribe(Observable<T> observable, Context context, final String str, Function1<? super Subscription, Unit> function1, Function1<? super T, Unit> function2, final Function1<? super Error, Unit> function3, final Function0<Unit> function0, final Function0<Unit> function4) {
        Intrinsics3.checkNotNullParameter(observable, "$this$appSubscribe");
        Intrinsics3.checkNotNullParameter(str, "errorTag");
        Intrinsics3.checkNotNullParameter(function2, "onNext");
        Intrinsics3.checkNotNullParameter(function0, "onCompleted");
        Intrinsics3.checkNotNullParameter(function4, "onTerminated");
        final WeakReference weakReference = new WeakReference(context);
        ObservableExtensionsKt$sam$rx_functions_Action1$0 observableExtensionsKt$sam$rx_functions_Action1$0 = new ObservableExtensionsKt$sam$rx_functions_Action1$0(function2);
        Action1<Throwable> action1 = new Action1<Throwable>() { // from class: com.discord.utilities.rx.ObservableExtensionsKt$appSubscribe$subscription$1
            @Override // rx.functions.Action1
            public final void call(Throwable th) throws Throwable {
                String str2 = str;
                Function1 function5 = function3;
                Object observableExtensionsKt$sam$rx_functions_Action1$1 = function5;
                if (function5 != null) {
                    observableExtensionsKt$sam$rx_functions_Action1$1 = new ObservableExtensionsKt$sam$rx_functions_Action1$0(function5);
                }
                Error.handle(th, str2, (Action1) observableExtensionsKt$sam$rx_functions_Action1$1, (Context) weakReference.get());
                function4.invoke();
            }
        };
        Action0 action0 = new Action0() { // from class: com.discord.utilities.rx.ObservableExtensionsKt$appSubscribe$subscription$2
            @Override // rx.functions.Action0
            public final void call() {
                function0.invoke();
                function4.invoke();
            }
        };
        Objects.requireNonNull(observable);
        Subscription subscriptionU = observable.U(new ActionSubscriber(observableExtensionsKt$sam$rx_functions_Action1$0, action1, action0));
        if (function1 != null) {
            Intrinsics3.checkNotNullExpressionValue(subscriptionU, Traits.Payment.Type.SUBSCRIPTION);
            function1.invoke(subscriptionU);
        }
    }
}
