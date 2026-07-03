package com.discord.utilities.p501rx;

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
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p638j.p640b.C12586a;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p643a.C12666r;
import p637j0.p642l.p647e.C12712b;
import p637j0.p653p.C12781a;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action0;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservableExtensionsKt {

    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$appSubscribe$1 */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class C68791 extends AbstractC12240o implements Function0<Unit> {
        public static final C68791 INSTANCE = new C68791();

        public C68791() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$appSubscribe$2 */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class C68802 extends AbstractC12240o implements Function0<Unit> {
        public static final C68802 INSTANCE = new C68802();

        public C68802() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$appSubscribe$3 */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class C68813 extends AbstractC12240o implements Function0<Unit> {
        public static final C68813 INSTANCE = new C68813();

        public C68813() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$appSubscribe$4 */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class C68824 extends AbstractC12240o implements Function0<Unit> {
        public static final C68824 INSTANCE = new C68824();

        public C68824() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1 */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class C68871<T, R> implements InterfaceC12589b<T, Boolean> {
        public static final C68871 INSTANCE = new C68871();

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p637j0.p641k.InterfaceC12589b
        public final Boolean call(T t) {
            return Boolean.valueOf(t != null);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2 */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class C68882<T, R> implements InterfaceC12589b<T, T> {
        public static final C68882 INSTANCE = new C68882();

        @Override // p637j0.p641k.InterfaceC12589b
        public final T call(T t) {
            C12238m.checkNotNull(t);
            return t;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$withDimmer$1 */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class C68911 extends AbstractC12240o implements Function1<Boolean, Unit> {
        public final /* synthetic */ DimmerView $dimmer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C68911(DimmerView dimmerView) {
            super(1);
            this.$dimmer = dimmerView;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            DimmerView dimmerView = this.$dimmer;
            if (dimmerView != null) {
                DimmerView.setDimmed$default(dimmerView, z2, false, 2, null);
            }
        }
    }

    public static final <T> void appSubscribe(Observable<T> observable, Class<?> cls, Context context, Function1<? super Subscription, Unit> function1, Function1<? super Error, Unit> function2, Function0<Unit> function0, Function0<Unit> function3, Function1<? super T, Unit> function4) {
        C12238m.checkNotNullParameter(observable, "$this$appSubscribe");
        C12238m.checkNotNullParameter(cls, "errorClass");
        C12238m.checkNotNullParameter(function0, "onCompleted");
        C12238m.checkNotNullParameter(function3, "onTerminated");
        C12238m.checkNotNullParameter(function4, "onNext");
        String simpleName = cls.getSimpleName();
        C12238m.checkNotNullExpressionValue(simpleName, "errorClass.simpleName");
        appSubscribe(observable, context, simpleName, function1, function4, function2, function0, function3);
    }

    public static /* synthetic */ void appSubscribe$default(Observable observable, Class cls, Context context, Function1 function1, Function1 function2, Function0 function0, Function0 function3, Function1 function4, int i, Object obj) {
        appSubscribe(observable, (Class<?>) cls, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : function1), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : function2), (Function0<Unit>) ((58 & 16) != 0 ? C68791.INSTANCE : function0), (Function0<Unit>) ((58 & 32) != 0 ? C68802.INSTANCE : function3), function4);
    }

    public static final <T> Observable<T> bindToComponentLifecycle(Observable<T> observable, final AppComponent appComponent, final MGRecyclerAdapterSimple<?> mGRecyclerAdapterSimple) {
        C12238m.checkNotNullParameter(observable, "$this$bindToComponentLifecycle");
        C12238m.checkNotNullParameter(appComponent, "appComponent");
        Observable<T> observableM11102a0 = observable.m11102a0(appComponent.getUnsubscribeSignal());
        if (appComponent instanceof Fragment) {
            observableM11102a0 = observableM11102a0.m11118y(new InterfaceC12589b<T, Boolean>() { // from class: com.discord.utilities.rx.ObservableExtensionsKt$bindToComponentLifecycle$$inlined$let$lambda$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // p637j0.p641k.InterfaceC12589b
                public final Boolean call(T t) {
                    FragmentActivity fragmentActivityM95e;
                    return Boolean.valueOf((!((Fragment) appComponent).isAdded() || ((Fragment) appComponent).isRemoving() || (fragmentActivityM95e = ((Fragment) appComponent).m95e()) == null || fragmentActivityM95e.isFinishing()) ? false : true);
                }
            });
        }
        Observable<T> observableM11117w = observableM11102a0.m11117w(new Action0() { // from class: com.discord.utilities.rx.ObservableExtensionsKt.bindToComponentLifecycle.2
            @Override // p658rx.functions.Action0
            public final void call() {
                MGRecyclerAdapterSimple mGRecyclerAdapterSimple2 = mGRecyclerAdapterSimple;
                if (mGRecyclerAdapterSimple2 != null) {
                    mGRecyclerAdapterSimple2.unsubscribeFromUpdates();
                }
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11117w, "takeUntil(appComponent.u…beFromUpdates()\n        }");
        return observableM11117w;
    }

    public static /* synthetic */ Observable bindToComponentLifecycle$default(Observable observable, AppComponent appComponent, MGRecyclerAdapterSimple mGRecyclerAdapterSimple, int i, Object obj) {
        if ((i & 2) != 0) {
            mGRecyclerAdapterSimple = null;
        }
        return bindToComponentLifecycle(observable, appComponent, mGRecyclerAdapterSimple);
    }

    public static final <T> Observable<T> computationBuffered(Observable<T> observable) {
        C12238m.checkNotNullParameter(observable, "$this$computationBuffered");
        Observable<T> observableM11084J = observable.m11085K().m11098X(C12781a.m10873a()).m11084J(C12781a.m10873a());
        C12238m.checkNotNullExpressionValue(observableM11084J, "onBackpressureBuffer()\n …Schedulers.computation())");
        return observableM11084J;
    }

    public static final <T> Observable<T> computationLatest(Observable<T> observable) {
        C12238m.checkNotNullParameter(observable, "$this$computationLatest");
        Observable<T> observableM11084J = observable.m11086L().m11098X(C12781a.m10873a()).m11084J(C12781a.m10873a());
        C12238m.checkNotNullExpressionValue(observableM11084J, "onBackpressureLatest()\n …Schedulers.computation())");
        return observableM11084J;
    }

    public static final /* synthetic */ <T> Observable<T> filterIs(Observable<?> observable) {
        C12238m.checkNotNullParameter(observable, "$this$filterIs");
        C12238m.needClassReification();
        Observable<?> observableM11118y = observable.m11118y(new InterfaceC12589b<Object, Boolean>() { // from class: com.discord.utilities.rx.ObservableExtensionsKt.filterIs.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(Object obj) {
                C12238m.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                return Boolean.valueOf(obj instanceof Object);
            }
        });
        C12238m.needClassReification();
        Observable<T> observable2 = (Observable<T>) observableM11118y.m11083G(new InterfaceC12589b<Object, T>() { // from class: com.discord.utilities.rx.ObservableExtensionsKt.filterIs.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // p637j0.p641k.InterfaceC12589b
            public final T call(Object obj) {
                C12238m.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                return obj;
            }
        });
        C12238m.checkNotNullExpressionValue(observable2, "filter { it is T }.map { it as T }");
        return observable2;
    }

    public static final /* synthetic */ <T> Observable<T> filterNull(Observable<T> observable) {
        C12238m.checkNotNullParameter(observable, "$this$filterNull");
        Observable<T> observable2 = (Observable<T>) observable.m11118y(C68871.INSTANCE).m11083G(C68882.INSTANCE);
        C12238m.checkNotNullExpressionValue(observable2, "filter { it != null }.map { it!! }");
        return observable2;
    }

    public static final <T> Observable<T> leadingEdgeThrottle(Observable<T> observable, long j, TimeUnit timeUnit) {
        C12238m.checkNotNullParameter(observable, "$this$leadingEdgeThrottle");
        C12238m.checkNotNullParameter(timeUnit, "timeUnit");
        Observable<T> observableM11074h0 = Observable.m11074h0(new C12666r(observable.f27640j, new LeadingEdgeThrottle(j, timeUnit)));
        C12238m.checkNotNullExpressionValue(observableM11074h0, "lift(LeadingEdgeThrottle…indowDuration, timeUnit))");
        return observableM11074h0;
    }

    public static final <T> Observable<T> restSubscribeOn(Observable<T> observable, boolean z2) {
        C12238m.checkNotNullParameter(observable, "$this$restSubscribeOn");
        Observable<T> observableM11098X = observable.m11098X(C12781a.m10875c());
        if (z2) {
            RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
            C12238m.checkNotNullExpressionValue(observableM11098X, "observable");
            observableM11098X = RetryWithDelay.restRetry$default(retryWithDelay, observableM11098X, 0L, null, null, 7, null);
        }
        C12238m.checkNotNullExpressionValue(observableM11098X, "subscribeOn(Schedulers.i… observable\n      }\n    }");
        return observableM11098X;
    }

    public static /* synthetic */ Observable restSubscribeOn$default(Observable observable, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return restSubscribeOn(observable, z2);
    }

    public static final <T> Observable<T> takeSingleUntilTimeout(Observable<T> observable, long j, boolean z2) {
        C12238m.checkNotNullParameter(observable, "$this$takeSingleUntilTimeout");
        Observable<T> observableM11100Z = observable.m11100Z(1);
        Observable<T> observableM11104c0 = z2 ? observableM11100Z.m11104c0(j, TimeUnit.MILLISECONDS) : observableM11100Z.m11102a0(Observable.m11068d0(j, TimeUnit.MILLISECONDS));
        C12238m.checkNotNullExpressionValue(observableM11104c0, "take(1).let {\n      if (…LISECONDS))\n      }\n    }");
        return computationLatest(observableM11104c0);
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
        C12238m.checkNotNullParameter(observable, "$this$toMap");
        Observable<Map<K, V>> observableM11106g0 = observable.m11106g0(new InterfaceC12589b<Pair<? extends K, ? extends V>, K>() { // from class: com.discord.utilities.rx.ObservableExtensionsKt.toMap.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final K call(Pair<? extends K, ? extends V> pair) {
                return pair.getFirst();
            }
        }, new InterfaceC12589b<Pair<? extends K, ? extends V>, V>() { // from class: com.discord.utilities.rx.ObservableExtensionsKt.toMap.2
            @Override // p637j0.p641k.InterfaceC12589b
            public final V call(Pair<? extends K, ? extends V> pair) {
                return pair.getSecond();
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11106g0, "toMap({ it.first }, { it.second })");
        return observableM11106g0;
    }

    /* JADX INFO: renamed from: ui */
    public static final <T> Observable<T> m8518ui(Observable<T> observable) {
        C12238m.checkNotNullParameter(observable, "$this$ui");
        Observable<T> observableM11084J = observable.m11084J(C12586a.m10738a());
        C12238m.checkNotNullExpressionValue(observableM11084J, "observeOn(AndroidSchedulers.mainThread())");
        return observableM11084J;
    }

    public static /* synthetic */ Observable ui$default(Observable observable, AppComponent appComponent, MGRecyclerAdapterSimple mGRecyclerAdapterSimple, int i, Object obj) {
        if ((i & 2) != 0) {
            mGRecyclerAdapterSimple = null;
        }
        return m8519ui(observable, appComponent, mGRecyclerAdapterSimple);
    }

    public static final <T> Observable<T> withDimmer(Observable<T> observable, DimmerView dimmerView, long j) {
        C12238m.checkNotNullParameter(observable, "$this$withDimmer");
        Observable<T> observableM11074h0 = Observable.m11074h0(new C12666r(observable.f27640j, new OnDelayedEmissionHandler(new C68911(dimmerView), j, TimeUnit.MILLISECONDS, null, 8, null)));
        C12238m.checkNotNullExpressionValue(observableM11074h0, "lift(\n        OnDelayedE…LISECONDS\n        )\n    )");
        return observableM11074h0;
    }

    public static /* synthetic */ Observable withDimmer$default(Observable observable, DimmerView dimmerView, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 300;
        }
        return withDimmer(observable, dimmerView, j);
    }

    /* JADX INFO: renamed from: ui */
    public static final <T> Observable<T> m8519ui(Observable<T> observable, AppComponent appComponent, MGRecyclerAdapterSimple<?> mGRecyclerAdapterSimple) {
        C12238m.checkNotNullParameter(observable, "$this$ui");
        C12238m.checkNotNullParameter(appComponent, "appComponent");
        return bindToComponentLifecycle(m8518ui(observable), appComponent, mGRecyclerAdapterSimple);
    }

    public static final <T> void appSubscribe(Observable<T> observable, Context context, final String str, Function1<? super Subscription, Unit> function1, Function1<? super T, Unit> function2, final Function1<? super Error, Unit> function3, final Function0<Unit> function0, final Function0<Unit> function4) {
        C12238m.checkNotNullParameter(observable, "$this$appSubscribe");
        C12238m.checkNotNullParameter(str, "errorTag");
        C12238m.checkNotNullParameter(function2, "onNext");
        C12238m.checkNotNullParameter(function0, "onCompleted");
        C12238m.checkNotNullParameter(function4, "onTerminated");
        final WeakReference weakReference = new WeakReference(context);
        ObservableExtensionsKt$sam$rx_functions_Action1$0 observableExtensionsKt$sam$rx_functions_Action1$0 = new ObservableExtensionsKt$sam$rx_functions_Action1$0(function2);
        Action1<Throwable> action1 = new Action1<Throwable>() { // from class: com.discord.utilities.rx.ObservableExtensionsKt$appSubscribe$subscription$1
            @Override // p658rx.functions.Action1
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
            @Override // p658rx.functions.Action0
            public final void call() {
                function0.invoke();
                function4.invoke();
            }
        };
        Objects.requireNonNull(observable);
        Subscription subscriptionM11095U = observable.m11095U(new C12712b(observableExtensionsKt$sam$rx_functions_Action1$0, action1, action0));
        if (function1 != null) {
            C12238m.checkNotNullExpressionValue(subscriptionM11095U, Traits.Payment.Type.SUBSCRIPTION);
            function1.invoke(subscriptionM11095U);
        }
    }
}
