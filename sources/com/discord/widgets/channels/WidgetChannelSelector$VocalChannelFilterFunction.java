package com.discord.widgets.channels;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSelector$VocalChannelFilterFunction implements WidgetChannelSelector$FilterFunction {
    public static final WidgetChannelSelector$VocalChannelFilterFunction INSTANCE = new WidgetChannelSelector$VocalChannelFilterFunction();

    private WidgetChannelSelector$VocalChannelFilterFunction() {
    }

    @Override // com.discord.widgets.channels.WidgetChannelSelector$FilterFunction
    public boolean includeChannel(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        return ChannelUtils.w(channel);
    }
}
