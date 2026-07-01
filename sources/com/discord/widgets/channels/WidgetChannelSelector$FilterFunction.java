package com.discord.widgets.channels;

import com.discord.api.channel.Channel;
import java.io.Serializable;

/* JADX INFO: compiled from: WidgetChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface WidgetChannelSelector$FilterFunction extends Serializable {
    boolean includeChannel(Channel channel);
}
