package com.discord.widgets.channels;

import com.discord.api.channel.Channel;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSelector$BaseFilterFunction implements WidgetChannelSelector$FilterFunction {
    @Override // com.discord.widgets.channels.WidgetChannelSelector$FilterFunction
    public boolean includeChannel(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        return WidgetChannelSelector$FilterFunction$DefaultImpls.includeChannel(this, channel);
    }
}
