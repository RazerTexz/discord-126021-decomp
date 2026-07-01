package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreThreadDraft.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadDraft$setDraftSending$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreThreadDraft this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreThreadDraft$setDraftSending$1(StoreThreadDraft storeThreadDraft) {
        super(0);
        this.this$0 = storeThreadDraft;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        BehaviorSubject behaviorSubjectAccess$getDraftStateSubject$p = StoreThreadDraft.access$getDraftStateSubject$p(this.this$0);
        BehaviorSubject behaviorSubjectAccess$getDraftStateSubject$p2 = StoreThreadDraft.access$getDraftStateSubject$p(this.this$0);
        m.checkNotNullExpressionValue(behaviorSubjectAccess$getDraftStateSubject$p2, "draftStateSubject");
        behaviorSubjectAccess$getDraftStateSubject$p.onNext(StoreThreadDraft$ThreadDraftState.copy$default((StoreThreadDraft$ThreadDraftState) behaviorSubjectAccess$getDraftStateSubject$p2.n0(), false, null, null, true, false, 23, null));
    }
}
