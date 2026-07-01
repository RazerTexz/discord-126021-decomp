package com.discord.stores;

import com.discord.models.domain.ModelChannelFollowerStatsDto;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreChannelFollowerStats.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelFollowerStats$fetchIfNonexistingOrStale$1$1 extends o implements Function1<ModelChannelFollowerStatsDto, Unit> {
    public final /* synthetic */ StoreChannelFollowerStats$fetchIfNonexistingOrStale$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChannelFollowerStats$fetchIfNonexistingOrStale$1$1(StoreChannelFollowerStats$fetchIfNonexistingOrStale$1 storeChannelFollowerStats$fetchIfNonexistingOrStale$1) {
        super(1);
        this.this$0 = storeChannelFollowerStats$fetchIfNonexistingOrStale$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelChannelFollowerStatsDto modelChannelFollowerStatsDto) {
        invoke2(modelChannelFollowerStatsDto);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelChannelFollowerStatsDto modelChannelFollowerStatsDto) {
        StoreChannelFollowerStats.access$getDispatcher$p(this.this$0.this$0).schedule(new StoreChannelFollowerStats$fetchIfNonexistingOrStale$1$1$1(this, modelChannelFollowerStatsDto));
    }
}
