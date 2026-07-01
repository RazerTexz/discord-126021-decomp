package com.discord.stores;

import com.discord.utilities.channel.ChannelSelector;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreLurking.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLurking$startLurkingAndNavigate$1$1$jumpToDestination$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Long $channelId;
    public final /* synthetic */ StoreLurking$startLurkingAndNavigate$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreLurking$startLurkingAndNavigate$1$1$jumpToDestination$1(StoreLurking$startLurkingAndNavigate$1$1 storeLurking$startLurkingAndNavigate$1$1, Long l) {
        super(0);
        this.this$0 = storeLurking$startLurkingAndNavigate$1$1;
        this.$channelId = l;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Long l;
        Long l2 = this.$channelId;
        if (l2 == null || ((l2 != null && l2.longValue() == 0) || ((l = this.$channelId) != null && l.longValue() == -1))) {
            StoreLurking.access$getStream$p(this.this$0.this$0.this$0).getGuildSelected().set(this.this$0.this$0.$guildId);
        } else {
            ChannelSelector.selectChannel$default(ChannelSelector.Companion.getInstance(), this.this$0.this$0.$guildId, this.$channelId.longValue(), null, null, 12, null);
        }
    }
}
