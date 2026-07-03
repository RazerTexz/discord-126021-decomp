package com.discord.widgets.chat.input.models;

import com.discord.api.channel.Channel;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: CommandOptionValue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelOptionValue extends CommandOptionValue {
    private final Channel channel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelOptionValue(Channel channel) {
        super(String.valueOf(channel.getId()), null);
        C12238m.checkNotNullParameter(channel, "channel");
        this.channel = channel;
    }

    public final Channel getChannel() {
        return this.channel;
    }
}
