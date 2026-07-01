package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import b.a.d.o;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelCall;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreCalls.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCalls {
    private final HashMap<Long, ModelCall> calls;
    private final SerializedSubject<HashMap<Long, ModelCall>, HashMap<Long, ModelCall>> callsSubject;
    private boolean connectionReady;
    private long selectedChannelId;
    private long selectedGuildId;
    private final StoreStream stream;

    public StoreCalls(StoreStream storeStream) {
        m.checkNotNullParameter(storeStream, "stream");
        this.stream = storeStream;
        this.calls = new HashMap<>();
        this.callsSubject = new SerializedSubject<>(BehaviorSubject.k0());
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreCalls storeCalls) {
        return storeCalls.stream;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void call$default(StoreCalls storeCalls, AppComponent appComponent, Context context, FragmentManager fragmentManager, long j, Function0 function0, int i, Object obj) {
        if ((i & 16) != 0) {
            function0 = null;
        }
        storeCalls.call(appComponent, context, fragmentManager, j, function0);
    }

    private final void callConnect() {
        if (this.connectionReady && this.selectedGuildId == 0) {
            long j = this.selectedChannelId;
            if (j <= 0 || this.calls.containsKey(Long.valueOf(j))) {
                return;
            }
            this.calls.put(Long.valueOf(this.selectedChannelId), null);
            this.stream.getGatewaySocket().callConnect(this.selectedChannelId);
        }
    }

    private final void callSubjectUpdate(boolean updated) {
        if (updated) {
            SerializedSubject<HashMap<Long, ModelCall>, HashMap<Long, ModelCall>> serializedSubject = this.callsSubject;
            serializedSubject.k.onNext(new HashMap<>(this.calls));
        }
    }

    public static /* synthetic */ void callSubjectUpdate$default(StoreCalls storeCalls, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        storeCalls.callSubjectUpdate(z2);
    }

    private final void findCall(long channelId, Function1<? super ModelCall, Unit> onFoundCall) {
        Observable<R> observableK = get(channelId).k(o.c(StoreCalls$findCall$1.INSTANCE, null, 3L, TimeUnit.SECONDS));
        m.checkNotNullExpressionValue(observableK, "get(channelId)\n        .…l?, 3, TimeUnit.SECONDS))");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableK, 0L, false, 3, null), StoreCalls.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, onFoundCall, 62, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void ring$default(StoreCalls storeCalls, long j, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        storeCalls.ring(j, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void stopRinging$default(StoreCalls storeCalls, long j, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        storeCalls.stopRinging(j, list);
    }

    public final void call(AppComponent appComponent, Context context, FragmentManager fragmentManager, long channelId, Function0<Unit> onError) {
        m.checkNotNullParameter(appComponent, "appComponent");
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        StoreCalls$call$1 storeCalls$call$1 = new StoreCalls$call$1(this, channelId);
        StoreCalls$call$2 storeCalls$call$2 = new StoreCalls$call$2(this, channelId, appComponent, context, storeCalls$call$1, onError, fragmentManager);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableZ = Observable.j0(storeStream$Companion.getChannels().observeChannel(channelId).k(o.c(StoreCalls$call$3.INSTANCE, null, 5000L, TimeUnit.MILLISECONDS)), storeStream$Companion.getVoiceStates().observeForPrivateChannels(channelId), StoreCalls$call$4.INSTANCE).Z(1);
        m.checkNotNullExpressionValue(observableZ, "Observable\n        .zip(…tates) }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(observableZ, StoreCalls.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreCalls$call$5(storeCalls$call$2, storeCalls$call$1), 62, (Object) null);
    }

    public final Observable<ModelCall> get(long channelId) {
        Observable<R> observableG = this.callsSubject.G(new StoreCalls$get$1(channelId));
        m.checkNotNullExpressionValue(observableG, "callsSubject\n          .…lls -> calls[channelId] }");
        Observable<ModelCall> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        m.checkNotNullExpressionValue(observableR, "callsSubject\n          .…  .distinctUntilChanged()");
        return observableR;
    }

    public final void handleCallCreateOrUpdate(ModelCall call) {
        m.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        long channelId = call.getChannelId();
        boolean z2 = true;
        if (!m.areEqual(call, this.calls.get(Long.valueOf(channelId)))) {
            this.calls.put(Long.valueOf(channelId), call);
        } else {
            z2 = false;
        }
        callSubjectUpdate(z2);
    }

    public final void handleCallDelete(ModelCall callDelete) {
        m.checkNotNullParameter(callDelete, "callDelete");
        long channelId = callDelete.getChannelId();
        if (this.calls.containsKey(Long.valueOf(channelId))) {
            this.calls.put(Long.valueOf(channelId), null);
            callSubjectUpdate$default(this, false, 1, null);
        }
    }

    public final void handleChannelSelect(long channelId) {
        this.selectedChannelId = channelId;
        callConnect();
    }

    public final void handleConnectionOpen() {
        this.calls.clear();
        callSubjectUpdate$default(this, false, 1, null);
        callConnect();
    }

    public final void handleConnectionReady(boolean connectionReady) {
        this.connectionReady = connectionReady;
        callConnect();
    }

    public final void handleGuildSelect(long guildId) {
        this.selectedGuildId = guildId;
        callConnect();
    }

    public final void ring(long channelId, List<Long> recipients) {
        findCall(channelId, new StoreCalls$ring$1(this, recipients));
    }

    public final void stopRinging(long channelId, List<Long> recipients) {
        findCall(channelId, new StoreCalls$stopRinging$1(this, channelId, recipients));
    }
}
