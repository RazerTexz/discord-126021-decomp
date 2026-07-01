package com.discord.utilities.channel;

import com.discord.stores.SelectedChannelAnalyticsLocation;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelSelector$gotoChannel$1 extends o implements Function0<Unit> {
    public final /* synthetic */ SelectedChannelAnalyticsLocation $analyticsLocation;
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ Long $peekParent;
    public final /* synthetic */ ChannelSelector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelSelector$gotoChannel$1(ChannelSelector channelSelector, long j, long j2, Long l, SelectedChannelAnalyticsLocation selectedChannelAnalyticsLocation) {
        super(0);
        this.this$0 = channelSelector;
        this.$guildId = j;
        this.$channelId = j2;
        this.$peekParent = l;
        this.$analyticsLocation = selectedChannelAnalyticsLocation;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.getStream().handleGuildSelected(this.$guildId);
        this.this$0.getStream().getChannelsSelected().trySelectChannel(this.$guildId, this.$channelId, this.$peekParent, this.$analyticsLocation);
    }
}
