package com.discord.widgets.forums;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetForumBrowserViewModel$MinimalStoreState$Valid extends WidgetForumBrowserViewModel$MinimalStoreState {
    private final Map<Long, Channel> activeThreads;
    private final Channel channel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowserViewModel$MinimalStoreState$Valid(Channel channel, Map<Long, Channel> map) {
        super(null);
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(map, "activeThreads");
        this.channel = channel;
        this.activeThreads = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetForumBrowserViewModel$MinimalStoreState$Valid copy$default(WidgetForumBrowserViewModel$MinimalStoreState$Valid widgetForumBrowserViewModel$MinimalStoreState$Valid, Channel channel, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = widgetForumBrowserViewModel$MinimalStoreState$Valid.channel;
        }
        if ((i & 2) != 0) {
            map = widgetForumBrowserViewModel$MinimalStoreState$Valid.activeThreads;
        }
        return widgetForumBrowserViewModel$MinimalStoreState$Valid.copy(channel, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final Map<Long, Channel> component2() {
        return this.activeThreads;
    }

    public final WidgetForumBrowserViewModel$MinimalStoreState$Valid copy(Channel channel, Map<Long, Channel> activeThreads) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(activeThreads, "activeThreads");
        return new WidgetForumBrowserViewModel$MinimalStoreState$Valid(channel, activeThreads);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetForumBrowserViewModel$MinimalStoreState$Valid)) {
            return false;
        }
        WidgetForumBrowserViewModel$MinimalStoreState$Valid widgetForumBrowserViewModel$MinimalStoreState$Valid = (WidgetForumBrowserViewModel$MinimalStoreState$Valid) other;
        return m.areEqual(this.channel, widgetForumBrowserViewModel$MinimalStoreState$Valid.channel) && m.areEqual(this.activeThreads, widgetForumBrowserViewModel$MinimalStoreState$Valid.activeThreads);
    }

    public final Map<Long, Channel> getActiveThreads() {
        return this.activeThreads;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Map<Long, Channel> map = this.activeThreads;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(channel=");
        sbU.append(this.channel);
        sbU.append(", activeThreads=");
        return a.M(sbU, this.activeThreads, ")");
    }
}
