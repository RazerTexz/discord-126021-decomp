package com.discord.widgets.guilds.list;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildsListViewModel$Event$ShowChannelActions extends WidgetGuildsListViewModel$Event {
    private final long channelId;

    public WidgetGuildsListViewModel$Event$ShowChannelActions(long j) {
        super(null);
        this.channelId = j;
    }

    public static /* synthetic */ WidgetGuildsListViewModel$Event$ShowChannelActions copy$default(WidgetGuildsListViewModel$Event$ShowChannelActions widgetGuildsListViewModel$Event$ShowChannelActions, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetGuildsListViewModel$Event$ShowChannelActions.channelId;
        }
        return widgetGuildsListViewModel$Event$ShowChannelActions.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    public final WidgetGuildsListViewModel$Event$ShowChannelActions copy(long channelId) {
        return new WidgetGuildsListViewModel$Event$ShowChannelActions(channelId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetGuildsListViewModel$Event$ShowChannelActions) && this.channelId == ((WidgetGuildsListViewModel$Event$ShowChannelActions) other).channelId;
        }
        return true;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public int hashCode() {
        return b.a(this.channelId);
    }

    public String toString() {
        return a.C(a.U("ShowChannelActions(channelId="), this.channelId, ")");
    }
}
