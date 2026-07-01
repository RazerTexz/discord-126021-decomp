package com.discord.widgets.channels;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;
import java.util.Set;

/* JADX INFO: compiled from: WidgetChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelSelector$SetFilterFunction implements WidgetChannelSelector$FilterFunction {
    private final Set<Long> channelIds;

    public WidgetChannelSelector$SetFilterFunction(Set<Long> set) {
        m.checkNotNullParameter(set, "channelIds");
        this.channelIds = set;
    }

    private final Set<Long> component1() {
        return this.channelIds;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChannelSelector$SetFilterFunction copy$default(WidgetChannelSelector$SetFilterFunction widgetChannelSelector$SetFilterFunction, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            set = widgetChannelSelector$SetFilterFunction.channelIds;
        }
        return widgetChannelSelector$SetFilterFunction.copy(set);
    }

    public final WidgetChannelSelector$SetFilterFunction copy(Set<Long> channelIds) {
        m.checkNotNullParameter(channelIds, "channelIds");
        return new WidgetChannelSelector$SetFilterFunction(channelIds);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetChannelSelector$SetFilterFunction) && m.areEqual(this.channelIds, ((WidgetChannelSelector$SetFilterFunction) other).channelIds);
        }
        return true;
    }

    public int hashCode() {
        Set<Long> set = this.channelIds;
        if (set != null) {
            return set.hashCode();
        }
        return 0;
    }

    @Override // com.discord.widgets.channels.WidgetChannelSelector$FilterFunction
    public boolean includeChannel(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        return this.channelIds.contains(Long.valueOf(channel.getId()));
    }

    public String toString() {
        return a.N(a.U("SetFilterFunction(channelIds="), this.channelIds, ")");
    }
}
