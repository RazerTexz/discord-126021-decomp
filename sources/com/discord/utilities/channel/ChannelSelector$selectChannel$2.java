package com.discord.utilities.channel;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.SelectedChannelAnalyticsLocation;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelSelector$selectChannel$2 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ SelectedChannelAnalyticsLocation $analyticsLocation;
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ Long $peekParent;
    public final /* synthetic */ ChannelSelector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelSelector$selectChannel$2(ChannelSelector channelSelector, long j, long j2, Long l, SelectedChannelAnalyticsLocation selectedChannelAnalyticsLocation) {
        super(1);
        this.this$0 = channelSelector;
        this.$guildId = j;
        this.$channelId = j2;
        this.$peekParent = l;
        this.$analyticsLocation = selectedChannelAnalyticsLocation;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX WARN: Code duplicated, block: B:6:0x001f  */
    /* JADX WARN: Code duplicated, block: B:8:0x0028  */
    /* JADX WARN: Code duplicated, block: B:9:0x002a  */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        boolean z2;
        if (TextInVoiceFeatureFlag.Companion.getINSTANCE().isEnabled(Long.valueOf(channel.getGuildId()))) {
            m.checkNotNullExpressionValue(channel, "channel");
            if (ChannelUtils.D(channel)) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            m.checkNotNullExpressionValue(channel, "channel");
            if (ChannelUtils.J(channel)) {
                z2 = true;
            } else {
                m.checkNotNullExpressionValue(channel, "channel");
                if (ChannelUtils.D(channel)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
        }
        ChannelSelector.access$gotoChannel(this.this$0, this.$guildId, z2 ? this.$guildId : this.$channelId, this.$peekParent, this.$analyticsLocation);
        if (z2) {
            this.this$0.getStream().getVoiceChannelSelected().selectVoiceChannel(this.$channelId);
        }
    }
}
