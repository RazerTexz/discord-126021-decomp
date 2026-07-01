package com.discord.widgets.announcements;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.widgets.channels.WidgetChannelSelector$FilterFunction;
import d0.z.d.m;
import java.util.Set;

/* JADX INFO: compiled from: WidgetChannelFollowSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelFollowSheet$ChannelFollowChannelFilterFunction implements WidgetChannelSelector$FilterFunction {
    private final Set<Long> channelIds;
    private final long selectedGuildId;

    public WidgetChannelFollowSheet$ChannelFollowChannelFilterFunction(long j, Set<Long> set) {
        m.checkNotNullParameter(set, "channelIds");
        this.selectedGuildId = j;
        this.channelIds = set;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final long getSelectedGuildId() {
        return this.selectedGuildId;
    }

    private final Set<Long> component2() {
        return this.channelIds;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChannelFollowSheet$ChannelFollowChannelFilterFunction copy$default(WidgetChannelFollowSheet$ChannelFollowChannelFilterFunction widgetChannelFollowSheet$ChannelFollowChannelFilterFunction, long j, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetChannelFollowSheet$ChannelFollowChannelFilterFunction.selectedGuildId;
        }
        if ((i & 2) != 0) {
            set = widgetChannelFollowSheet$ChannelFollowChannelFilterFunction.channelIds;
        }
        return widgetChannelFollowSheet$ChannelFollowChannelFilterFunction.copy(j, set);
    }

    public final WidgetChannelFollowSheet$ChannelFollowChannelFilterFunction copy(long selectedGuildId, Set<Long> channelIds) {
        m.checkNotNullParameter(channelIds, "channelIds");
        return new WidgetChannelFollowSheet$ChannelFollowChannelFilterFunction(selectedGuildId, channelIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelFollowSheet$ChannelFollowChannelFilterFunction)) {
            return false;
        }
        WidgetChannelFollowSheet$ChannelFollowChannelFilterFunction widgetChannelFollowSheet$ChannelFollowChannelFilterFunction = (WidgetChannelFollowSheet$ChannelFollowChannelFilterFunction) other;
        return this.selectedGuildId == widgetChannelFollowSheet$ChannelFollowChannelFilterFunction.selectedGuildId && m.areEqual(this.channelIds, widgetChannelFollowSheet$ChannelFollowChannelFilterFunction.channelIds);
    }

    public int hashCode() {
        int iA = b.a(this.selectedGuildId) * 31;
        Set<Long> set = this.channelIds;
        return iA + (set != null ? set.hashCode() : 0);
    }

    @Override // com.discord.widgets.channels.WidgetChannelSelector$FilterFunction
    public boolean includeChannel(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        return this.channelIds.contains(Long.valueOf(channel.getId())) && channel.getGuildId() == this.selectedGuildId;
    }

    public String toString() {
        StringBuilder sbU = a.U("ChannelFollowChannelFilterFunction(selectedGuildId=");
        sbU.append(this.selectedGuildId);
        sbU.append(", channelIds=");
        return a.N(sbU, this.channelIds, ")");
    }
}
