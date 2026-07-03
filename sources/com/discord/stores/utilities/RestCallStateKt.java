package com.discord.stores.utilities;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import com.discord.analytics.generated.traits.TrackNetworkMetadata;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.testing.TestUtilsKt;
import java.net.UnknownHostException;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import okhttp3.Request;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import retrofit2.HttpException;
import retrofit2.Response;

/* JADX INFO: compiled from: RestCallState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestCallStateKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.discord.stores.utilities.RestCallStateKt$executeRequest$1 */
    /* JADX INFO: compiled from: RestCallState.kt */
    public static final class C66371<T> extends AbstractC12240o implements Function1<T, Unit> {
        public final /* synthetic */ Function1 $resultHandler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C66371(Function1 function1) {
            super(1);
            this.$resultHandler = function1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(T t) {
            this.$resultHandler.invoke(new Success(t));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.utilities.RestCallStateKt$executeRequest$2 */
    /* JADX INFO: compiled from: RestCallState.kt */
    public static final class C66382 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ Function1 $resultHandler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C66382(Function1 function1) {
            super(1);
            this.$resultHandler = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "error");
            this.$resultHandler.invoke(new Failure(error));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.utilities.RestCallStateKt$handleResponse$1 */
    /* JADX INFO: compiled from: RestCallState.kt */
    public static final class C66391 extends AbstractC12240o implements Function1<Loading, Unit> {
        public static final C66391 INSTANCE = new C66391();

        public C66391() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Loading loading) {
            invoke2(loading);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Loading loading) {
            C12238m.checkNotNullParameter(loading, "it");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.discord.stores.utilities.RestCallStateKt$handleResponse$2 */
    /* JADX INFO: compiled from: RestCallState.kt */
    public static final class C66402<T> extends AbstractC12240o implements Function1<Failure<? extends T>, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C66402(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke((Failure) obj);
            return Unit.f27425a;
        }

        public final void invoke(final Failure<? extends T> failure) {
            C12238m.checkNotNullParameter(failure, "failure");
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.discord.stores.utilities.RestCallStateKt.handleResponse.2.1
                @Override // java.lang.Runnable
                public final void run() {
                    failure.getError().showToasts(C66402.this.$context);
                }
            });
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.discord.stores.utilities.RestCallStateKt$handleResponse$3 */
    /* JADX INFO: compiled from: RestCallState.kt */
    public static final class C66413<T> extends AbstractC12240o implements Function1<Success<? extends T>, Unit> {
        public static final C66413 INSTANCE = new C66413();

        public C66413() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke((Success) obj);
            return Unit.f27425a;
        }

        public final void invoke(Success<? extends T> success) {
            C12238m.checkNotNullParameter(success, "it");
        }
    }

    public static final <T> void executeRequest(Observable<T> observable, Function1<? super RestCallState<? extends T>, Unit> function1) {
        C12238m.checkNotNullParameter(observable, "$this$executeRequest");
        C12238m.checkNotNullParameter(function1, "resultHandler");
        function1.invoke(Loading.INSTANCE);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(observable, false, 1, null), (Class<?>) observable.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C66382(function1)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C66371(function1));
    }

    public static final Request getRequest(Response<?> response) {
        C12238m.checkNotNullParameter(response, "$this$getRequest");
        okhttp3.Response response2 = response.f27631a;
        Objects.requireNonNull(response2, "null cannot be cast to non-null type okhttp3.Response");
        return response2.request;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> TrackNetworkMetadataReceiver getSchema(Function1<? super T, ? extends TrackNetworkMetadataReceiver> function1, TrackNetworkMetadata trackNetworkMetadata, T t) {
        C12238m.checkNotNullParameter(function1, "networkActionProvider");
        TrackNetworkMetadataReceiver trackNetworkMetadataReceiverInvoke = function1.invoke(t);
        if (trackNetworkMetadataReceiverInvoke != null) {
            trackNetworkMetadataReceiverInvoke.mo7529b(trackNetworkMetadata);
        }
        return trackNetworkMetadataReceiverInvoke;
    }

    public static /* synthetic */ TrackNetworkMetadataReceiver getSchema$default(Function1 function1, TrackNetworkMetadata trackNetworkMetadata, Object obj, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        return getSchema(function1, trackNetworkMetadata, obj);
    }

    @MainThread
    public static final <T> void handleResponse(RestCallState<? extends T> restCallState, Context context, Function1<? super Loading, Unit> function1, Function1<? super Failure<? extends T>, Unit> function2, Function1<? super Success<? extends T>, Unit> function3) {
        C12238m.checkNotNullParameter(restCallState, "$this$handleResponse");
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(function1, "onLoading");
        C12238m.checkNotNullParameter(function2, "onFailure");
        C12238m.checkNotNullParameter(function3, "onSuccess");
        if (restCallState instanceof Loading) {
            function1.invoke(restCallState);
        } else if (restCallState instanceof Success) {
            function3.invoke(restCallState);
        } else if (restCallState instanceof Failure) {
            function2.invoke(restCallState);
        }
    }

    public static /* synthetic */ void handleResponse$default(RestCallState restCallState, Context context, Function1 function1, Function1 function2, Function1 function3, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = C66391.INSTANCE;
        }
        if ((i & 4) != 0) {
            function2 = new C66402(context);
        }
        if ((i & 8) != 0) {
            function3 = C66413.INSTANCE;
        }
        handleResponse(restCallState, context, function1, function2, function3);
    }

    public static final <T> Observable<T> logNetworkAction(Observable<Response<T>> observable, final Function1<? super T, ? extends TrackNetworkMetadataReceiver> function1) {
        C12238m.checkNotNullParameter(observable, "$this$logNetworkAction");
        C12238m.checkNotNullParameter(function1, "networkActionProvider");
        if (TestUtilsKt.getIS_JUNIT_TEST()) {
            Observable<T> observable2 = (Observable<T>) observable.m11083G(new InterfaceC12589b<Response<T>, T>() { // from class: com.discord.stores.utilities.RestCallStateKt.logNetworkAction.1
                @Override // p637j0.p641k.InterfaceC12589b
                public final T call(Response<T> response) {
                    return response.f27632b;
                }
            });
            C12238m.checkNotNullExpressionValue(observable2, "map { it.body() }");
            return observable2;
        }
        final AnalyticsUtils.Tracker tracker = AnalyticsTracker.INSTANCE.getTracker();
        Observable<T> observable3 = (Observable<T>) observable.m11115u(new Action1<Response<T>>() { // from class: com.discord.stores.utilities.RestCallStateKt.logNetworkAction.2
            @Override // p658rx.functions.Action1
            public final void call(Response<T> response) {
                TrackNetworkMetadataReceiver schema;
                C12238m.checkNotNullExpressionValue(response, "response");
                if (!response.m11057a()) {
                    throw new HttpException(response);
                }
                Request request = RestCallStateKt.getRequest(response);
                if (!GrowthTeamFeatures.INSTANCE.isNetworkActionLoggingEnabled() || (schema = RestCallStateKt.getSchema(function1, new TrackNetworkMetadata(request.url.f25984l, request.method, Long.valueOf(response.f27631a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String), null, null, 24), response.f27632b)) == null) {
                    return;
                }
                tracker.track(schema);
            }
        }).m11114t(new Action1<Throwable>() { // from class: com.discord.stores.utilities.RestCallStateKt.logNetworkAction.3
            /* JADX WARN: Code duplicated, block: B:29:0x006e  */
            @Override // p658rx.functions.Action1
            public final void call(Throwable th) {
                TrackNetworkMetadata trackNetworkMetadata;
                TrackNetworkMetadataReceiver schema$default;
                Request request;
                if (GrowthTeamFeatures.INSTANCE.isNetworkActionLoggingEnabled()) {
                    if (th instanceof HttpException) {
                        HttpException httpException = (HttpException) th;
                        Response<?> response = httpException.f27630j;
                        if (response == null || (request = RestCallStateKt.getRequest(response)) == null) {
                            trackNetworkMetadata = null;
                        } else {
                            String str = request.url.f25984l;
                            String str2 = request.method;
                            Response<?> response2 = httpException.f27630j;
                            Long lValueOf = response2 != null ? Long.valueOf(response2.f27631a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String) : null;
                            Response<?> response3 = httpException.f27630j;
                            Long lValueOf2 = response3 != null ? Long.valueOf(response3.f27631a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String) : null;
                            Response<?> response4 = httpException.f27630j;
                            String str3 = response4 != null ? response4.f27631a.message : null;
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
                    if (trackNetworkMetadata == null || (schema$default = RestCallStateKt.getSchema$default(function1, trackNetworkMetadata, null, 4, null)) == null) {
                        return;
                    }
                    tracker.track(schema$default);
                }
            }
        }).m11083G(new InterfaceC12589b<Response<T>, T>() { // from class: com.discord.stores.utilities.RestCallStateKt.logNetworkAction.4
            @Override // p637j0.p641k.InterfaceC12589b
            public final T call(Response<T> response) {
                return response.f27632b;
            }
        });
        C12238m.checkNotNullExpressionValue(observable3, "doOnNext { response ->\n …rectly.\n    it.body()\n  }");
        return observable3;
    }
}
