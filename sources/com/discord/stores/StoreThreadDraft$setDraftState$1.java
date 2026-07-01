package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreThreadDraft.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadDraft$setDraftState$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreThreadDraft$ThreadDraftState $draftState;
    public final /* synthetic */ StoreThreadDraft this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreThreadDraft$setDraftState$1(StoreThreadDraft storeThreadDraft, StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState) {
        super(0);
        this.this$0 = storeThreadDraft;
        this.$draftState = storeThreadDraft$ThreadDraftState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreThreadDraft.access$getDraftStateSubject$p(this.this$0).onNext(this.$draftState);
    }
}
