package com.discord.widgets.chat.input.models;

import com.discord.api.channel.Channel;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: CommandOptionValue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelOptionValue extends CommandOptionValue {
    private final Channel channel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelOptionValue(Channel channel) {
        super(String.valueOf(channel.getId()), null);
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.channel = channel;
    }

    public final Channel getChannel() {
        return this.channel;
    }
}
