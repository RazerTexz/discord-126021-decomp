package com.discord.stores.utilities;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import com.discord.analytics.generated.traits.TrackNetworkMetadata;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.testing.TestUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.net.UnknownHostException;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import okhttp3.Request;
import retrofit2.HttpException;
import retrofit2.Response;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/* JADX INFO: renamed from: com.discord.stores.utilities.RestCallStateKt, reason: use source file name */
/* JADX INFO: compiled from: RestCallState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestCallState5 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.discord.stores.utilities.RestCallStateKt$executeRequest$1, reason: invalid class name */
    /* JADX INFO: compiled from: RestCallState.kt */
    public static final class AnonymousClass1<T> extends Lambda implements Function1<T, Unit> {
        public final /* synthetic */ Function1 $resultHandler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function1 function1) {
            super(1);
            this.$resultHandler = function1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(T t) {
            this.$resultHandler.invoke(new RestCallState6(t));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.utilities.RestCallStateKt$executeRequest$2, reason: invalid class name */
    /* JADX INFO: compiled from: RestCallState.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ Function1 $resultHandler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Function1 function1) {
            super(1);
            this.$resultHandler = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            this.$resultHandler.invoke(new RestCallState3(error));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.utilities.RestCallStateKt$handleResponse$1, reason: invalid class name */
    /* JADX INFO: compiled from: RestCallState.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<RestCallState4, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState4 restCallState4) {
            invoke2(restCallState4);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState4 restCallState4) {
            Intrinsics3.checkNotNullParameter(restCallState4, "it");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.discord.stores.utilities.RestCallStateKt$handleResponse$2, reason: invalid class name */
    /* JADX INFO: compiled from: RestCallState.kt */
    public static final class AnonymousClass2<T> extends Lambda implements Function1<RestCallState3<? extends T>, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke((RestCallState3) obj);
            return Unit.a;
        }

        public final void invoke(final RestCallState3<? extends T> restCallState3) {
            Intrinsics3.checkNotNullParameter(restCallState3, "failure");
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.discord.stores.utilities.RestCallStateKt.handleResponse.2.1
                @Override // java.lang.Runnable
                public final void run() {
                    restCallState3.getError().showToasts(AnonymousClass2.this.$context);
                }
            });
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.discord.stores.utilities.RestCallStateKt$handleResponse$3, reason: invalid class name */
    /* JADX INFO: compiled from: RestCallState.kt */
    public static final class AnonymousClass3<T> extends Lambda implements Function1<RestCallState6<? extends T>, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke((RestCallState6) obj);
            return Unit.a;
        }

        public final void invoke(RestCallState6<? extends T> restCallState6) {
            Intrinsics3.checkNotNullParameter(restCallState6, "it");
        }
    }

    public static final <T> void executeRequest(Observable<T> observable, Function1<? super RestCallState<? extends T>, Unit> function1) {
        Intrinsics3.checkNotNullParameter(observable, "$this$executeRequest");
        Intrinsics3.checkNotNullParameter(function1, "resultHandler");
        function1.invoke(RestCallState4.INSTANCE);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(observable, false, 1, null), (Class<?>) observable.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2(function1)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(function1));
    }

    public static final Request getRequest(Response<?> response) {
        Intrinsics3.checkNotNullParameter(response, "$this$getRequest");
        okhttp3.Response response2 = response.a;
        Objects.requireNonNull(response2, "null cannot be cast to non-null type okhttp3.Response");
        return response2.request;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> TrackNetworkMetadata2 getSchema(Function1<? super T, ? extends TrackNetworkMetadata2> function1, TrackNetworkMetadata trackNetworkMetadata, T t) {
        Intrinsics3.checkNotNullParameter(function1, "networkActionProvider");
        TrackNetworkMetadata2 trackNetworkMetadata2Invoke = function1.invoke(t);
        if (trackNetworkMetadata2Invoke != null) {
            trackNetworkMetadata2Invoke.b(trackNetworkMetadata);
        }
        return trackNetworkMetadata2Invoke;
    }

    public static /* synthetic */ TrackNetworkMetadata2 getSchema$default(Function1 function1, TrackNetworkMetadata trackNetworkMetadata, Object obj, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        return getSchema(function1, trackNetworkMetadata, obj);
    }

    @MainThread
    public static final <T> void handleResponse(RestCallState<? extends T> restCallState, Context context, Function1<? super RestCallState4, Unit> function1, Function1<? super RestCallState3<? extends T>, Unit> function2, Function1<? super RestCallState6<? extends T>, Unit> function3) {
        Intrinsics3.checkNotNullParameter(restCallState, "$this$handleResponse");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(function1, "onLoading");
        Intrinsics3.checkNotNullParameter(function2, "onFailure");
        Intrinsics3.checkNotNullParameter(function3, "onSuccess");
        if (restCallState instanceof RestCallState4) {
            function1.invoke(restCallState);
        } else if (restCallState instanceof RestCallState6) {
            function3.invoke(restCallState);
        } else if (restCallState instanceof RestCallState3) {
            function2.invoke(restCallState);
        }
    }

    public static /* synthetic */ void handleResponse$default(RestCallState restCallState, Context context, Function1 function1, Function1 function2, Function1 function3, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = AnonymousClass1.INSTANCE;
        }
        if ((i & 4) != 0) {
            function2 = new AnonymousClass2(context);
        }
        if ((i & 8) != 0) {
            function3 = AnonymousClass3.INSTANCE;
        }
        handleResponse(restCallState, context, function1, function2, function3);
    }

    public static final <T> Observable<T> logNetworkAction(Observable<Response<T>> observable, final Function1<? super T, ? extends TrackNetworkMetadata2> function1) {
        Intrinsics3.checkNotNullParameter(observable, "$this$logNetworkAction");
        Intrinsics3.checkNotNullParameter(function1, "networkActionProvider");
        if (TestUtils.getIS_JUNIT_TEST()) {
            Observable<T> observable2 = (Observable<T>) observable.G(new Func1<Response<T>, T>() { // from class: com.discord.stores.utilities.RestCallStateKt.logNetworkAction.1
                @Override // j0.k.Func1
                public final T call(Response<T> response) {
                    return response.f3824b;
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observable2, "map { it.body() }");
            return observable2;
        }
        final AnalyticsUtils.Tracker tracker = AnalyticsTracker.INSTANCE.getTracker();
        Observable<T> observable3 = (Observable<T>) observable.u(new Action1<Response<T>>() { // from class: com.discord.stores.utilities.RestCallStateKt.logNetworkAction.2
            @Override // rx.functions.Action1
            public final void call(Response<T> response) {
                TrackNetworkMetadata2 schema;
                Intrinsics3.checkNotNullExpressionValue(response, "response");
                if (!response.a()) {
                    throw new HttpException(response);
                }
                Request request = RestCallState5.getRequest(response);
                if (!GrowthTeamFeatures.INSTANCE.isNetworkActionLoggingEnabled() || (schema = RestCallState5.getSchema(function1, new TrackNetworkMetadata(request.url.l, request.method, Long.valueOf(response.a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String), null, null, 24), response.f3824b)) == null) {
                    return;
                }
                tracker.track(schema);
            }
        }).t(new Action1<Throwable>() { // from class: com.discord.stores.utilities.RestCallStateKt.logNetworkAction.3
            /* JADX WARN: Code duplicated, block: B:29:0x006e  */
            @Override // rx.functions.Action1
            public final void call(Throwable th) {
                TrackNetworkMetadata trackNetworkMetadata;
                TrackNetworkMetadata2 schema$default;
                Request request;
                if (GrowthTeamFeatures.INSTANCE.isNetworkActionLoggingEnabled()) {
                    if (th instanceof HttpException) {
                        HttpException httpException = (HttpException) th;
                        Response<?> response = httpException.j;
                        if (response == null || (request = RestCallState5.getRequest(response)) == null) {
                            trackNetworkMetadata = null;
                        } else {
                            String str = request.url.l;
                            String str2 = request.method;
                            Response<?> response2 = httpException.j;
                            Long lValueOf = response2 != null ? Long.valueOf(response2.a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String) : null;
                            Response<?> response3 = httpException.j;
                            Long lValueOf2 = response3 != null ? Long.valueOf(response3.a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String) : null;
                            Response<?> response4 = httpException.j;
                            String str3 = response4 != null ? response4.a.message : null;
                            if (str3 == null) {
                                str3 = "";
                            }
                            trackNetworkMetadata = new TrackNetworkMetadata(str, str2, lValueOf, lValueOf2, str3);
                        }
                    } else if (th instanceof UnknownHostException) {
                        trackNetworkMetadata = new TrackNetworkMetadata(null, null, null, null, ((UnknownHostException) th).getLocalizedMessage(), 15);
                    } else {
                        trackNetworkMetadata = null;
                    }
                    if (trackNetworkMetadata == null || (schema$default = RestCallState5.getSchema$default(function1, trackNetworkMetadata, null, 4, null)) == null) {
                        return;
                    }
                    tracker.track(schema$default);
                }
            }
        }).G(new Func1<Response<T>, T>() { // from class: com.discord.stores.utilities.RestCallStateKt.logNetworkAction.4
            @Override // j0.k.Func1
            public final T call(Response<T> response) {
                return response.f3824b;
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observable3, "doOnNext { response ->\n …rectly.\n    it.body()\n  }");
        return observable3;
    }
}
