package com.discord.widgets.channels.threads.browser;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetThreadBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetThreadBrowserViewModel$ViewState$GoToChannel extends WidgetThreadBrowserViewModel$ViewState {
    private final Channel channel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserViewModel$ViewState$GoToChannel(Channel channel) {
        super(null);
        m.checkNotNullParameter(channel, "channel");
        this.channel = channel;
    }

    public static /* synthetic */ WidgetThreadBrowserViewModel$ViewState$GoToChannel copy$default(WidgetThreadBrowserViewModel$ViewState$GoToChannel widgetThreadBrowserViewModel$ViewState$GoToChannel, Channel channel, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = widgetThreadBrowserViewModel$ViewState$GoToChannel.channel;
        }
        return widgetThreadBrowserViewModel$ViewState$GoToChannel.copy(channel);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final WidgetThreadBrowserViewModel$ViewState$GoToChannel copy(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        return new WidgetThreadBrowserViewModel$ViewState$GoToChannel(channel);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetThreadBrowserViewModel$ViewState$GoToChannel) && m.areEqual(this.channel, ((WidgetThreadBrowserViewModel$ViewState$GoToChannel) other).channel);
        }
        return true;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public int hashCode() {
        Channel channel = this.channel;
        if (channel != null) {
            return channel.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("GoToChannel(channel=");
        sbU.append(this.channel);
        sbU.append(")");
        return sbU.toString();
    }
}
