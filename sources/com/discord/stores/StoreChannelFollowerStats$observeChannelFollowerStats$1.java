package com.discord.stores;

import com.discord.models.domain.ModelChannelFollowerStats;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreChannelFollowerStats.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelFollowerStats$observeChannelFollowerStats$1 extends o implements Function0<ModelChannelFollowerStats> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreChannelFollowerStats this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChannelFollowerStats$observeChannelFollowerStats$1(StoreChannelFollowerStats storeChannelFollowerStats, long j) {
        super(0);
        this.this$0 = storeChannelFollowerStats;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ModelChannelFollowerStats invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ModelChannelFollowerStats invoke() {
        StoreChannelFollowerStats$ChannelFollowerStatData storeChannelFollowerStats$ChannelFollowerStatData = (StoreChannelFollowerStats$ChannelFollowerStatData) StoreChannelFollowerStats.access$getChannelFollowerStatsStateSnapshot$p(this.this$0).get(Long.valueOf(this.$channelId));
        if (storeChannelFollowerStats$ChannelFollowerStatData != null) {
            return storeChannelFollowerStats$ChannelFollowerStatData.getData();
        }
        return null;
    }
}
