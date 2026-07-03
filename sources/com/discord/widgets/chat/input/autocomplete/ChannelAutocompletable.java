package com.discord.widgets.chat.input.autocomplete;

import com.discord.api.channel.Channel;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Autocompletable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelAutocompletable extends Autocompletable {
    private final Channel channel;
    private final List<String> textMatchers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelAutocompletable(Channel channel) {
        super(null);
        C12238m.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.textMatchers = C12145m.listOf(leadingIdentifier().getIdentifier() + channel.getName());
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
        C12238m.checkNotNullParameter(channel, "channel");
        return new ChannelAutocompletable(channel);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ChannelAutocompletable) && C12238m.areEqual(this.channel, ((ChannelAutocompletable) other).channel);
        }
        return true;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public String getInputReplacement() {
        StringBuilder sbM833U = C1643a.m833U("<#");
        sbM833U.append(this.channel.getId());
        sbM833U.append('>');
        return sbM833U.toString();
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
        StringBuilder sbM833U = C1643a.m833U("ChannelAutocompletable(channel=");
        sbM833U.append(this.channel);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
