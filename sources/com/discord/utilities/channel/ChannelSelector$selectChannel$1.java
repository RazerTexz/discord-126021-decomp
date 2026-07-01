package com.discord.utilities.channel;

import com.discord.stores.SelectedChannelAnalyticsLocation;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelSelector$selectChannel$1 extends o implements Function1 {
    public final /* synthetic */ SelectedChannelAnalyticsLocation $analyticsLocation;
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ Long $peekParent;
    public final /* synthetic */ ChannelSelector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelSelector$selectChannel$1(ChannelSelector channelSelector, long j, long j2, Long l, SelectedChannelAnalyticsLocation selectedChannelAnalyticsLocation) {
        super(1);
        this.this$0 = channelSelector;
        this.$guildId = j;
        this.$channelId = j2;
        this.$peekParent = l;
        this.$analyticsLocation = selectedChannelAnalyticsLocation;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Void) obj);
        return Unit.a;
    }

    public final void invoke(Void r8) {
        ChannelSelector.access$gotoChannel(this.this$0, this.$guildId, this.$channelId, this.$peekParent, this.$analyticsLocation);
    }
}
