package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildBoost$observeGuildBoostState$1 extends o implements Function0<StoreGuildBoost$State> {
    public final /* synthetic */ Long $guildId;
    public final /* synthetic */ StoreGuildBoost this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildBoost$observeGuildBoostState$1(StoreGuildBoost storeGuildBoost, Long l) {
        super(0);
        this.this$0 = storeGuildBoost;
        this.$guildId = l;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreGuildBoost$State invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreGuildBoost$State invoke() {
        StoreGuildBoost$State state = this.this$0.getStateSnapshot();
        return state instanceof StoreGuildBoost$State$Loaded ? ((StoreGuildBoost$State$Loaded) state).filterByGuildId(this.$guildId) : state;
    }
}
