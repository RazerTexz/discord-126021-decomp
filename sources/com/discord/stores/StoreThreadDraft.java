package com.discord.stores;

import d0.z.d.m;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreThreadDraft.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadDraft extends StoreV2 {
    private final Dispatcher dispatcher;
    private final BehaviorSubject<StoreThreadDraft$ThreadDraftState> draftStateSubject;

    public StoreThreadDraft(Dispatcher dispatcher) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        this.draftStateSubject = BehaviorSubject.l0(new StoreThreadDraft$ThreadDraftState(false, null, null, false, false, 31, null));
    }

    public static final /* synthetic */ BehaviorSubject access$getDraftStateSubject$p(StoreThreadDraft storeThreadDraft) {
        return storeThreadDraft.draftStateSubject;
    }

    public final void clearDraftState() {
        this.dispatcher.schedule(new StoreThreadDraft$clearDraftState$1(this));
    }

    public final Observable<StoreThreadDraft$ThreadDraftState> observeDraftState() {
        BehaviorSubject<StoreThreadDraft$ThreadDraftState> behaviorSubject = this.draftStateSubject;
        m.checkNotNullExpressionValue(behaviorSubject, "draftStateSubject");
        return behaviorSubject;
    }

    public final void setDraftSending() {
        this.dispatcher.schedule(new StoreThreadDraft$setDraftSending$1(this));
    }

    public final void setDraftState(StoreThreadDraft$ThreadDraftState draftState) {
        m.checkNotNullParameter(draftState, "draftState");
        this.dispatcher.schedule(new StoreThreadDraft$setDraftState$1(this, draftState));
    }
}
