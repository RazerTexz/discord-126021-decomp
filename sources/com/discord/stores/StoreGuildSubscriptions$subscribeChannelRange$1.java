package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: StoreGuildSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildSubscriptions$subscribeChannelRange$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ IntRange $range;
    public final /* synthetic */ StoreGuildSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildSubscriptions$subscribeChannelRange$1(StoreGuildSubscriptions storeGuildSubscriptions, IntRange intRange, long j, long j2) {
        super(0);
        this.this$0 = storeGuildSubscriptions;
        this.$range = intRange;
        this.$guildId = j;
        this.$channelId = j2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGuildSubscriptions.access$getSubscriptionsManager$p(this.this$0).subscribeChannel(this.$guildId, this.$channelId, StoreGuildSubscriptions$RangeComputer.computeRanges$default(StoreGuildSubscriptions$RangeComputer.INSTANCE, this.$range, 0, 2, null));
        this.this$0.markChanged();
    }
}
