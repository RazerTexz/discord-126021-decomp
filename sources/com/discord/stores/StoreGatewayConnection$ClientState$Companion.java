package com.discord.stores;

import android.content.Context;
import b.a.d.k;
import b.a.d.l;
import b.a.e.d;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Scheduler;

/* JADX INFO: compiled from: StoreGatewayConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGatewayConnection$ClientState$Companion {
    private StoreGatewayConnection$ClientState$Companion() {
    }

    public static final /* synthetic */ StoreGatewayConnection$ClientState access$create(StoreGatewayConnection$ClientState$Companion storeGatewayConnection$ClientState$Companion, boolean z2, String str, long j, boolean z3, StoreClientDataState$ClientDataState storeClientDataState$ClientDataState) {
        return storeGatewayConnection$ClientState$Companion.create(z2, str, j, z3, storeClientDataState$ClientDataState);
    }

    private final StoreGatewayConnection$ClientState create(boolean backgrounded, String token, long selectedVoiceChannelId, boolean hasGatewayConnectionConsumers, StoreClientDataState$ClientDataState clientDataState) {
        boolean z2 = token != null;
        if (backgrounded && selectedVoiceChannelId <= 0 && !hasGatewayConnectionConsumers) {
            token = null;
        }
        return new StoreGatewayConnection$ClientState(token, z2, clientDataState);
    }

    public final void initialize(StoreStream stream, Scheduler scheduler, Function1<? super StoreGatewayConnection$ClientState, Unit> callback) {
        m.checkNotNullParameter(stream, "stream");
        m.checkNotNullParameter(scheduler, "scheduler");
        m.checkNotNullParameter(callback, "callback");
        Observable<Boolean> observableA = d.d.a();
        Observable<String> authedToken$app_productionGoogleRelease = stream.getAuthentication().getAuthedToken$app_productionGoogleRelease();
        Observable<Long> observableObserveSelectedVoiceChannelId = stream.getVoiceChannelSelected().observeSelectedVoiceChannelId();
        l lVar = l.c;
        Observable observableR = l.f59b.G(k.j).r();
        m.checkNotNullExpressionValue(observableR, "numGatewayConnectionCons…  .distinctUntilChanged()");
        Observable observableG = Observable.g(observableA, authedToken$app_productionGoogleRelease, observableObserveSelectedVoiceChannelId, observableR, stream.getClientDataState().observeClientState(), new StoreGatewayConnection$sam$rx_functions_Func5$0(new StoreGatewayConnection$ClientState$Companion$initialize$1(this)));
        m.checkNotNullExpressionValue(observableG, "Observable\n            .…   ::create\n            )");
        Observable observableJ = ObservableExtensionsKt.computationLatest(observableG).J(scheduler);
        m.checkNotNullExpressionValue(observableJ, "Observable\n            .…    .observeOn(scheduler)");
        ObservableExtensionsKt.appSubscribe$default(observableJ, (Context) null, "clientState", (Function1) null, callback, (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    public /* synthetic */ StoreGatewayConnection$ClientState$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
