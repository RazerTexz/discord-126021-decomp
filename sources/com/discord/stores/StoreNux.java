package com.discord.stores;

import d0.z.d.m;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreNux.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNux extends Store {
    private final Dispatcher dispatcher;
    private StoreNux$NuxState nuxState;
    private final BehaviorSubject<StoreNux$NuxState> nuxStateSubject;

    public StoreNux(Dispatcher dispatcher) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        StoreNux$NuxState storeNux$NuxState = new StoreNux$NuxState(false, false, false, false, false, null, 63, null);
        this.nuxState = storeNux$NuxState;
        this.nuxStateSubject = BehaviorSubject.l0(storeNux$NuxState);
    }

    public static final /* synthetic */ StoreNux$NuxState access$getNuxState$p(StoreNux storeNux) {
        return storeNux.nuxState;
    }

    public static final /* synthetic */ void access$publishNuxUpdated(StoreNux storeNux, StoreNux$NuxState storeNux$NuxState) {
        storeNux.publishNuxUpdated(storeNux$NuxState);
    }

    public static final /* synthetic */ void access$setNuxState$p(StoreNux storeNux, StoreNux$NuxState storeNux$NuxState) {
        storeNux.nuxState = storeNux$NuxState;
    }

    private final void publishNuxUpdated(StoreNux$NuxState nuxState) {
        this.nuxStateSubject.onNext(nuxState);
    }

    public final void clearNux() {
        this.dispatcher.schedule(new StoreNux$clearNux$1(this));
    }

    public final Observable<StoreNux$NuxState> getNuxState() {
        Observable<StoreNux$NuxState> observableR = this.nuxStateSubject.r();
        m.checkNotNullExpressionValue(observableR, "nuxStateSubject.distinctUntilChanged()");
        return observableR;
    }

    @StoreThread
    public final void handleGuildSelected(long guildId) {
        Long guildBoostHintGuildId = this.nuxState.getGuildBoostHintGuildId();
        if (guildBoostHintGuildId != null && guildBoostHintGuildId.longValue() == guildId) {
            return;
        }
        StoreNux$NuxState storeNux$NuxStateCopy$default = StoreNux$NuxState.copy$default(this.nuxState, false, false, false, false, false, null, 31, null);
        this.nuxState = storeNux$NuxStateCopy$default;
        publishNuxUpdated(storeNux$NuxStateCopy$default);
    }

    @StoreThread
    public final void handleSamplePremiumGuildSelected(long guildId) {
        StoreNux$NuxState storeNux$NuxStateCopy$default = StoreNux$NuxState.copy$default(this.nuxState, false, false, false, false, false, Long.valueOf(guildId), 31, null);
        this.nuxState = storeNux$NuxStateCopy$default;
        publishNuxUpdated(storeNux$NuxStateCopy$default);
    }

    public final void setContactSyncCompleted(boolean value) {
        updateNux(new StoreNux$setContactSyncCompleted$1(value));
    }

    public final void setFirstOpen(boolean value) {
        updateNux(new StoreNux$setFirstOpen$1(value));
    }

    public final void setPostRegister(boolean value) {
        updateNux(new StoreNux$setPostRegister$1(value));
    }

    public final void setPostRegisterWithInvite(boolean value) {
        updateNux(new StoreNux$setPostRegisterWithInvite$1(value));
    }

    public final void setPremiumGuildHintGuildId(Long value) {
        updateNux(new StoreNux$setPremiumGuildHintGuildId$1(value));
    }

    public final void updateNux(Function1<? super StoreNux$NuxState, StoreNux$NuxState> updateFunction) {
        m.checkNotNullParameter(updateFunction, "updateFunction");
        this.dispatcher.schedule(new StoreNux$updateNux$1(this, updateFunction));
    }
}
