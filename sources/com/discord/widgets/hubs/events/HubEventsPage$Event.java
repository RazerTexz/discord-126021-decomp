package com.discord.widgets.hubs.events;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHubEventsPageAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HubEventsPage$Event extends HubEventsPage {
    private final HubGuildScheduledEventData guildScheduledEventData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HubEventsPage$Event(HubGuildScheduledEventData hubGuildScheduledEventData) {
        super(2, null);
        m.checkNotNullParameter(hubGuildScheduledEventData, "guildScheduledEventData");
        this.guildScheduledEventData = hubGuildScheduledEventData;
    }

    public static /* synthetic */ HubEventsPage$Event copy$default(HubEventsPage$Event hubEventsPage$Event, HubGuildScheduledEventData hubGuildScheduledEventData, int i, Object obj) {
        if ((i & 1) != 0) {
            hubGuildScheduledEventData = hubEventsPage$Event.guildScheduledEventData;
        }
        return hubEventsPage$Event.copy(hubGuildScheduledEventData);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final HubGuildScheduledEventData getGuildScheduledEventData() {
        return this.guildScheduledEventData;
    }

    public final HubEventsPage$Event copy(HubGuildScheduledEventData guildScheduledEventData) {
        m.checkNotNullParameter(guildScheduledEventData, "guildScheduledEventData");
        return new HubEventsPage$Event(guildScheduledEventData);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof HubEventsPage$Event) && m.areEqual(this.guildScheduledEventData, ((HubEventsPage$Event) other).guildScheduledEventData);
        }
        return true;
    }

    public final HubGuildScheduledEventData getGuildScheduledEventData() {
        return this.guildScheduledEventData;
    }

    public int hashCode() {
        HubGuildScheduledEventData hubGuildScheduledEventData = this.guildScheduledEventData;
        if (hubGuildScheduledEventData != null) {
            return hubGuildScheduledEventData.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Event(guildScheduledEventData=");
        sbU.append(this.guildScheduledEventData);
        sbU.append(")");
        return sbU.toString();
    }
}
