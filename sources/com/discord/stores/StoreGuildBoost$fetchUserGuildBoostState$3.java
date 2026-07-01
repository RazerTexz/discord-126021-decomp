package com.discord.stores;

import com.discord.models.domain.ModelGuildBoostSlot;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildBoost$fetchUserGuildBoostState$3 extends o implements Function1<List<? extends ModelGuildBoostSlot>, Unit> {
    public final /* synthetic */ StoreGuildBoost this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildBoost$fetchUserGuildBoostState$3(StoreGuildBoost storeGuildBoost) {
        super(1);
        this.this$0 = storeGuildBoost;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelGuildBoostSlot> list) {
        invoke2((List<ModelGuildBoostSlot>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<ModelGuildBoostSlot> list) {
        m.checkNotNullParameter(list, "subscriptionsSlots");
        this.this$0.getDispatcher().schedule(new StoreGuildBoost$fetchUserGuildBoostState$3$1(this, list));
    }
}
