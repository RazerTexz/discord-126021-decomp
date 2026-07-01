package com.discord.stores;

import com.discord.stores.StoreLurking;
import com.discord.utilities.channel.ChannelSelector;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.stores.StoreLurking$startLurkingAndNavigate$1$1$jumpToDestination$1, reason: use source file name */
/* JADX INFO: compiled from: StoreLurking.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLurking2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Long $channelId;
    public final /* synthetic */ StoreLurking.AnonymousClass1.C01461 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreLurking2(StoreLurking.AnonymousClass1.C01461 c01461, Long l) {
        super(0);
        this.this$0 = c01461;
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
            StoreLurking.this.stream.getGuildSelected().set(StoreLurking.AnonymousClass1.this.$guildId);
        } else {
            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), StoreLurking.AnonymousClass1.this.$guildId, this.$channelId.longValue(), null, null, 12, null);
        }
    }
}
