package com.discord.widgets.channels;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreStream;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSelector$InactiveStageChannelFilterFunction implements WidgetChannelSelector$FilterFunction {
    public static final WidgetChannelSelector$InactiveStageChannelFilterFunction INSTANCE = new WidgetChannelSelector$InactiveStageChannelFilterFunction();

    private WidgetChannelSelector$InactiveStageChannelFilterFunction() {
    }

    @Override // com.discord.widgets.channels.WidgetChannelSelector$FilterFunction
    public boolean includeChannel(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        return ChannelUtils.D(channel) && StoreStream.Companion.getStageInstances().getStageInstanceForChannel(channel.getId()) == null;
    }
}
