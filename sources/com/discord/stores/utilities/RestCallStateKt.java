package com.discord.stores.utilities;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import com.discord.analytics.generated.traits.TrackNetworkMetadata;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AnalyticsUtils$Tracker;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.testing.TestUtilsKt;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import okhttp3.Request;
import retrofit2.Response;
import rx.Observable;

/* JADX INFO: compiled from: RestCallState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestCallStateKt {
    public static final <T> void executeRequest(Observable<T> observable, Function1<? super RestCallState<? extends T>, Unit> function1) {
        m.checkNotNullParameter(observable, "$this$executeRequest");
        m.checkNotNullParameter(function1, "resultHandler");
        function1.invoke(Loading.INSTANCE);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(observable, false, 1, null), observable.getClass(), (Context) null, (Function1) null, new RestCallStateKt$executeRequest$2(function1), (Function0) null, (Function0) null, new RestCallStateKt$executeRequest$1(function1), 54, (Object) null);
    }

    public static final Request getRequest(Response<?> response) {
        m.checkNotNullParameter(response, "$this$getRequest");
        okhttp3.Response response2 = response.a;
        Objects.requireNonNull(response2, "null cannot be cast to non-null type okhttp3.Response");
        return response2.request;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> TrackNetworkMetadataReceiver getSchema(Function1<? super T, ? extends TrackNetworkMetadataReceiver> function1, TrackNetworkMetadata trackNetworkMetadata, T t) {
        m.checkNotNullParameter(function1, "networkActionProvider");
        TrackNetworkMetadataReceiver trackNetworkMetadataReceiverInvoke = function1.invoke(t);
        if (trackNetworkMetadataReceiverInvoke != null) {
            trackNetworkMetadataReceiverInvoke.b(trackNetworkMetadata);
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
        m.checkNotNullParameter(restCallState, "$this$handleResponse");
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(function1, "onLoading");
        m.checkNotNullParameter(function2, "onFailure");
        m.checkNotNullParameter(function3, "onSuccess");
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
            function1 = RestCallStateKt$handleResponse$1.INSTANCE;
        }
        if ((i & 4) != 0) {
            function2 = new RestCallStateKt$handleResponse$2(context);
        }
        if ((i & 8) != 0) {
            function3 = RestCallStateKt$handleResponse$3.INSTANCE;
        }
        handleResponse(restCallState, context, function1, function2, function3);
    }

    public static final <T> Observable<T> logNetworkAction(Observable<Response<T>> observable, Function1<? super T, ? extends TrackNetworkMetadataReceiver> function1) {
        m.checkNotNullParameter(observable, "$this$logNetworkAction");
        m.checkNotNullParameter(function1, "networkActionProvider");
        if (TestUtilsKt.getIS_JUNIT_TEST()) {
            Observable<T> observable2 = (Observable<T>) observable.G(RestCallStateKt$logNetworkAction$1.INSTANCE);
            m.checkNotNullExpressionValue(observable2, "map { it.body() }");
            return observable2;
        }
        AnalyticsUtils$Tracker tracker = AnalyticsTracker.INSTANCE.getTracker();
        Observable<T> observable3 = (Observable<T>) observable.u(new RestCallStateKt$logNetworkAction$2(function1, tracker)).t(new RestCallStateKt$logNetworkAction$3(function1, tracker)).G(RestCallStateKt$logNetworkAction$4.INSTANCE);
        m.checkNotNullExpressionValue(observable3, "doOnNext { response ->\n …rectly.\n    it.body()\n  }");
        return observable3;
    }
}
