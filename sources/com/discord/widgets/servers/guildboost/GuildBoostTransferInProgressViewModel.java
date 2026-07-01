package com.discord.widgets.servers.guildboost;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreGuildBoost$State$Loaded;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: GuildBoostTransferInProgressViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostTransferInProgressViewModel extends d0<GuildBoostTransferInProgressViewModel$ViewState> {
    private final long boostId;
    private Subscription guildBoostingSubscription;
    private final long previousGuildId;
    private final RestAPI restAPI;
    private final long slotId;
    private final StoreGuildBoost storeGuildBoost;
    private final long targetGuildId;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildBoostTransferInProgressViewModel(long j, long j2, long j3, long j4, RestAPI restAPI, StoreGuildBoost storeGuildBoost, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observable2;
        RestAPI api = (i & 16) != 0 ? RestAPI.Companion.getApi() : restAPI;
        StoreGuildBoost guildBoosts = (i & 32) != 0 ? StoreStream.Companion.getGuildBoosts() : storeGuildBoost;
        if ((i & 64) != 0) {
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            Observable observableI = Observable.i(storeStream$Companion.getGuilds().observeGuild(j3), storeStream$Companion.getGuilds().observeGuild(j4), StoreGuildBoost.observeGuildBoostState$default(storeStream$Companion.getGuildBoosts(), null, 1, null), GuildBoostTransferInProgressViewModel$1.INSTANCE);
            m.checkNotNullExpressionValue(observableI, "Observable.combineLatest…guildBoostState\n    )\n  }");
            observable2 = observableI;
        } else {
            observable2 = observable;
        }
        this(j, j2, j3, j4, api, guildBoosts, observable2);
    }

    public static final /* synthetic */ void access$handleGuildBoostingCompleted(GuildBoostTransferInProgressViewModel guildBoostTransferInProgressViewModel) {
        guildBoostTransferInProgressViewModel.handleGuildBoostingCompleted();
    }

    public static final /* synthetic */ void access$handleGuildBoostingError(GuildBoostTransferInProgressViewModel guildBoostTransferInProgressViewModel) {
        guildBoostTransferInProgressViewModel.handleGuildBoostingError();
    }

    public static final /* synthetic */ void access$handleStoreState(GuildBoostTransferInProgressViewModel guildBoostTransferInProgressViewModel, GuildBoostTransferInProgressViewModel$StoreState guildBoostTransferInProgressViewModel$StoreState) {
        guildBoostTransferInProgressViewModel.handleStoreState(guildBoostTransferInProgressViewModel$StoreState);
    }

    @MainThread
    private final void handleGuildBoostingCompleted() {
        this.storeGuildBoost.fetchUserGuildBoostState();
        GuildBoostTransferInProgressViewModel$ViewState guildBoostTransferInProgressViewModel$ViewStateRequireViewState = requireViewState();
        if (guildBoostTransferInProgressViewModel$ViewStateRequireViewState instanceof GuildBoostTransferInProgressViewModel$ViewState$PreTransfer) {
            GuildBoostTransferInProgressViewModel$ViewState$PreTransfer guildBoostTransferInProgressViewModel$ViewState$PreTransfer = (GuildBoostTransferInProgressViewModel$ViewState$PreTransfer) guildBoostTransferInProgressViewModel$ViewStateRequireViewState;
            guildBoostTransferInProgressViewModel$ViewStateRequireViewState = new GuildBoostTransferInProgressViewModel$ViewState$PostTransfer(guildBoostTransferInProgressViewModel$ViewState$PreTransfer.getTargetGuild(), guildBoostTransferInProgressViewModel$ViewState$PreTransfer.getTargetGuildSubscriptionCount());
        }
        updateViewState(guildBoostTransferInProgressViewModel$ViewStateRequireViewState);
    }

    @MainThread
    private final void handleGuildBoostingError() {
        updateViewState(GuildBoostTransferInProgressViewModel$ViewState$ErrorTransfer.INSTANCE);
    }

    @MainThread
    private final void handleGuildBoostingStarted() {
        Object objCopy$default = (GuildBoostTransferInProgressViewModel$ViewState) requireViewState();
        if (objCopy$default instanceof GuildBoostTransferInProgressViewModel$ViewState$PreTransfer) {
            objCopy$default = GuildBoostTransferInProgressViewModel$ViewState$PreTransfer.copy$default((GuildBoostTransferInProgressViewModel$ViewState$PreTransfer) objCopy$default, null, null, 0, true, 7, null);
        }
        updateViewState(objCopy$default);
    }

    @MainThread
    private final void handleStoreState(GuildBoostTransferInProgressViewModel$StoreState storeState) {
        int size;
        if (storeState.getPreviousGuild() == null || storeState.getTargetGuild() == null) {
            updateViewState(GuildBoostTransferInProgressViewModel$ViewState$ErrorLoading.INSTANCE);
            return;
        }
        if (storeState.getGuildBoostState() instanceof StoreGuildBoost$State$Loaded) {
            Collection<ModelGuildBoostSlot> collectionValues = ((StoreGuildBoost$State$Loaded) storeState.getGuildBoostState()).getBoostSlotMap().values();
            ArrayList arrayList = new ArrayList();
            for (Object obj : collectionValues) {
                ModelAppliedGuildBoost premiumGuildSubscription = ((ModelGuildBoostSlot) obj).getPremiumGuildSubscription();
                if (premiumGuildSubscription != null && premiumGuildSubscription.getGuildId() == this.targetGuildId) {
                    arrayList.add(obj);
                }
            }
            size = arrayList.size();
        } else {
            size = 0;
        }
        updateViewState(new GuildBoostTransferInProgressViewModel$ViewState$PreTransfer(storeState.getPreviousGuild(), storeState.getTargetGuild(), size, false));
    }

    public final long getBoostId() {
        return this.boostId;
    }

    public final long getPreviousGuildId() {
        return this.previousGuildId;
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final long getSlotId() {
        return this.slotId;
    }

    public final StoreGuildBoost getStoreGuildBoost() {
        return this.storeGuildBoost;
    }

    public final long getTargetGuildId() {
        return this.targetGuildId;
    }

    @Override // b.a.d.d0, androidx.view.ViewModel
    public void onCleared() {
        Subscription subscription = this.guildBoostingSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        super.onCleared();
    }

    @MainThread
    public final void transferGuildBoost() {
        handleGuildBoostingStarted();
        Observable<R> observableA = this.restAPI.unsubscribeToGuild(this.previousGuildId, this.boostId).A(new GuildBoostTransferInProgressViewModel$transferGuildBoost$1(this));
        m.checkNotNullExpressionValue(observableA, "restAPI\n        .unsubsc…              )\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(observableA, false, 1, null), this, null, 2, null), GuildBoostTransferInProgressViewModel.class, (Context) null, (Function1) null, new GuildBoostTransferInProgressViewModel$transferGuildBoost$2(this), (Function0) null, (Function0) null, new GuildBoostTransferInProgressViewModel$transferGuildBoost$3(this), 54, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostTransferInProgressViewModel(long j, long j2, long j3, long j4, RestAPI restAPI, StoreGuildBoost storeGuildBoost, Observable<GuildBoostTransferInProgressViewModel$StoreState> observable) {
        super(GuildBoostTransferInProgressViewModel$ViewState$Loading.INSTANCE);
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(storeGuildBoost, "storeGuildBoost");
        m.checkNotNullParameter(observable, "storeObservable");
        this.slotId = j;
        this.boostId = j2;
        this.previousGuildId = j3;
        this.targetGuildId = j4;
        this.restAPI = restAPI;
        this.storeGuildBoost = storeGuildBoost;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), GuildBoostTransferInProgressViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildBoostTransferInProgressViewModel$2(this), 62, (Object) null);
    }
}
