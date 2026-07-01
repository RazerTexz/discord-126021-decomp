package com.discord.widgets.channels;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelSelector$TypeFilterFunction implements WidgetChannelSelector$FilterFunction {
    private final int type;

    public WidgetChannelSelector$TypeFilterFunction(int i) {
        this.type = i;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final int getType() {
        return this.type;
    }

    public static /* synthetic */ WidgetChannelSelector$TypeFilterFunction copy$default(WidgetChannelSelector$TypeFilterFunction widgetChannelSelector$TypeFilterFunction, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetChannelSelector$TypeFilterFunction.type;
        }
        return widgetChannelSelector$TypeFilterFunction.copy(i);
    }

    public final WidgetChannelSelector$TypeFilterFunction copy(int type) {
        return new WidgetChannelSelector$TypeFilterFunction(type);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetChannelSelector$TypeFilterFunction) && this.type == ((WidgetChannelSelector$TypeFilterFunction) other).type;
        }
        return true;
    }

    public int hashCode() {
        return this.type;
    }

    @Override // com.discord.widgets.channels.WidgetChannelSelector$FilterFunction
    public boolean includeChannel(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        return this.type == channel.getType();
    }

    public String toString() {
        return a.B(a.U("TypeFilterFunction(type="), this.type, ")");
    }
}
