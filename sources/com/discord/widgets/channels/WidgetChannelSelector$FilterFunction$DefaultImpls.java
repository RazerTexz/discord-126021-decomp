package com.discord.widgets.channels;

import com.discord.api.channel.Channel;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSelector$FilterFunction$DefaultImpls {
    public static boolean includeChannel(WidgetChannelSelector$FilterFunction widgetChannelSelector$FilterFunction, Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        return true;
    }
}
