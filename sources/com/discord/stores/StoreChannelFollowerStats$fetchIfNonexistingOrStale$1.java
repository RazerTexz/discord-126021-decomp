package com.discord.stores;

import android.content.Context;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreChannelFollowerStats.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelFollowerStats$fetchIfNonexistingOrStale$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreChannelFollowerStats this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChannelFollowerStats$fetchIfNonexistingOrStale$1(StoreChannelFollowerStats storeChannelFollowerStats, long j) {
        super(0);
        this.this$0 = storeChannelFollowerStats;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        boolean z2 = StoreChannelFollowerStats.access$isExisting(this.this$0, this.$channelId) && !StoreChannelFollowerStats.access$isStale(this.this$0, this.$channelId);
        StoreChannelFollowerStats$ChannelFollowerStatData storeChannelFollowerStats$ChannelFollowerStatData = (StoreChannelFollowerStats$ChannelFollowerStatData) StoreChannelFollowerStats.access$getChannelFollowerStatsState$p(this.this$0).get(Long.valueOf(this.$channelId));
        boolean z3 = (storeChannelFollowerStats$ChannelFollowerStatData != null ? storeChannelFollowerStats$ChannelFollowerStatData.getFetchState() : null) == StoreChannelFollowerStats$FetchState.FETCHING;
        if (z2 || z3) {
            return;
        }
        StoreChannelFollowerStats.access$handleChannelFollowerStatsFetchStart(this.this$0, this.$channelId);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().getChannelFollowerStats(this.$channelId), false, 1, null), this.this$0.getClass(), (Context) null, (Function1) null, new StoreChannelFollowerStats$fetchIfNonexistingOrStale$1$2(this), (Function0) null, (Function0) null, new StoreChannelFollowerStats$fetchIfNonexistingOrStale$1$1(this), 54, (Object) null);
    }
}
