package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: Autocompletable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelAutocompletable extends Autocompletable {
    private final Channel channel;
    private final List<String> textMatchers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelAutocompletable(Channel channel) {
        super(null);
        m.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.textMatchers = d0.t.m.listOf(leadingIdentifier().getIdentifier() + channel.getName());
    }

    public static /* synthetic */ ChannelAutocompletable copy$default(ChannelAutocompletable channelAutocompletable, Channel channel, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = channelAutocompletable.channel;
        }
        return channelAutocompletable.copy(channel);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final ChannelAutocompletable copy(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        return new ChannelAutocompletable(channel);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ChannelAutocompletable) && m.areEqual(this.channel, ((ChannelAutocompletable) other).channel);
        }
        return true;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public String getInputReplacement() {
        StringBuilder sbU = a.U("<#");
        sbU.append(this.channel.getId());
        sbU.append('>');
        return sbU.toString();
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getInputTextMatchers() {
        return this.textMatchers;
    }

    public final List<String> getTextMatchers() {
        return this.textMatchers;
    }

    public int hashCode() {
        Channel channel = this.channel;
        if (channel != null) {
            return channel.hashCode();
        }
        return 0;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public LeadingIdentifier leadingIdentifier() {
        return LeadingIdentifier.CHANNELS;
    }

    public String toString() {
        StringBuilder sbU = a.U("ChannelAutocompletable(channel=");
        sbU.append(this.channel);
        sbU.append(")");
        return sbU.toString();
    }
}
