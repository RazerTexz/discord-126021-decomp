package com.discord.stores;

import com.discord.models.domain.ModelChannelFollowerStats;
import com.discord.models.domain.ModelChannelFollowerStatsDto;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreChannelFollowerStats.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelFollowerStats$fetchIfNonexistingOrStale$1$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ModelChannelFollowerStatsDto $channelFollowerStats;
    public final /* synthetic */ StoreChannelFollowerStats$fetchIfNonexistingOrStale$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChannelFollowerStats$fetchIfNonexistingOrStale$1$1$1(StoreChannelFollowerStats$fetchIfNonexistingOrStale$1$1 storeChannelFollowerStats$fetchIfNonexistingOrStale$1$1, ModelChannelFollowerStatsDto modelChannelFollowerStatsDto) {
        super(0);
        this.this$0 = storeChannelFollowerStats$fetchIfNonexistingOrStale$1$1;
        this.$channelFollowerStats = modelChannelFollowerStatsDto;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreChannelFollowerStats$fetchIfNonexistingOrStale$1 storeChannelFollowerStats$fetchIfNonexistingOrStale$1 = this.this$0.this$0;
        StoreChannelFollowerStats.access$handleChannelFollowerStatsFetchSuccess(storeChannelFollowerStats$fetchIfNonexistingOrStale$1.this$0, storeChannelFollowerStats$fetchIfNonexistingOrStale$1.$channelId, ModelChannelFollowerStats.Companion.fromResponse(this.$channelFollowerStats));
    }
}
