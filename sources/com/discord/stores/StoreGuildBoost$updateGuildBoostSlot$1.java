package com.discord.stores;

import com.discord.models.domain.ModelGuildBoostSlot;
import d0.t.h0;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildBoost$updateGuildBoostSlot$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ModelGuildBoostSlot $newSlot;
    public final /* synthetic */ StoreGuildBoost this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildBoost$updateGuildBoostSlot$1(StoreGuildBoost storeGuildBoost, ModelGuildBoostSlot modelGuildBoostSlot) {
        super(0);
        this.this$0 = storeGuildBoost;
        this.$newSlot = modelGuildBoostSlot;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGuildBoost$State storeGuildBoost$StateAccess$getState$p = StoreGuildBoost.access$getState$p(this.this$0);
        if (storeGuildBoost$StateAccess$getState$p instanceof StoreGuildBoost$State$Loaded) {
            StoreGuildBoost.access$setState$p(this.this$0, new StoreGuildBoost$State$Loaded(h0.plus(((StoreGuildBoost$State$Loaded) storeGuildBoost$StateAccess$getState$p).getBoostSlotMap(), d0.o.to(Long.valueOf(this.$newSlot.getId()), this.$newSlot))));
            this.this$0.markChanged();
        }
    }
}
