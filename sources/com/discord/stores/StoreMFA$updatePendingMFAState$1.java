package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMFA.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMFA$updatePendingMFAState$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreMFA$MFAActivationState $newActivationState;
    public final /* synthetic */ StoreMFA this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMFA$updatePendingMFAState$1(StoreMFA storeMFA, StoreMFA$MFAActivationState storeMFA$MFAActivationState) {
        super(0);
        this.this$0 = storeMFA;
        this.$newActivationState = storeMFA$MFAActivationState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreMFA storeMFA = this.this$0;
        StoreMFA.access$setState$p(storeMFA, StoreMFA$State.copy$default(StoreMFA.access$getState$p(storeMFA), this.$newActivationState, false, 2, null));
        this.this$0.markChanged();
    }
}
