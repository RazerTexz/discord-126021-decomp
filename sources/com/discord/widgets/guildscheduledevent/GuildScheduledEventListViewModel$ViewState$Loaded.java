package com.discord.widgets.guildscheduledevent;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: GuildScheduledEventListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventListViewModel$ViewState$Loaded extends GuildScheduledEventListViewModel$ViewState {
    private final boolean canCreateEvents;
    private final List<GuildScheduledEventListItem$Event> guildScheduledEvents;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventListViewModel$ViewState$Loaded(List<GuildScheduledEventListItem$Event> list, boolean z2) {
        super(null);
        m.checkNotNullParameter(list, "guildScheduledEvents");
        this.guildScheduledEvents = list;
        this.canCreateEvents = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildScheduledEventListViewModel$ViewState$Loaded copy$default(GuildScheduledEventListViewModel$ViewState$Loaded guildScheduledEventListViewModel$ViewState$Loaded, List list, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = guildScheduledEventListViewModel$ViewState$Loaded.guildScheduledEvents;
        }
        if ((i & 2) != 0) {
            z2 = guildScheduledEventListViewModel$ViewState$Loaded.canCreateEvents;
        }
        return guildScheduledEventListViewModel$ViewState$Loaded.copy(list, z2);
    }

    public final List<GuildScheduledEventListItem$Event> component1() {
        return this.guildScheduledEvents;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanCreateEvents() {
        return this.canCreateEvents;
    }

    public final GuildScheduledEventListViewModel$ViewState$Loaded copy(List<GuildScheduledEventListItem$Event> guildScheduledEvents, boolean canCreateEvents) {
        m.checkNotNullParameter(guildScheduledEvents, "guildScheduledEvents");
        return new GuildScheduledEventListViewModel$ViewState$Loaded(guildScheduledEvents, canCreateEvents);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventListViewModel$ViewState$Loaded)) {
            return false;
        }
        GuildScheduledEventListViewModel$ViewState$Loaded guildScheduledEventListViewModel$ViewState$Loaded = (GuildScheduledEventListViewModel$ViewState$Loaded) other;
        return m.areEqual(this.guildScheduledEvents, guildScheduledEventListViewModel$ViewState$Loaded.guildScheduledEvents) && this.canCreateEvents == guildScheduledEventListViewModel$ViewState$Loaded.canCreateEvents;
    }

    public final boolean getCanCreateEvents() {
        return this.canCreateEvents;
    }

    public final List<GuildScheduledEventListItem$Event> getGuildScheduledEvents() {
        return this.guildScheduledEvents;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        List<GuildScheduledEventListItem$Event> list = this.guildScheduledEvents;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        boolean z2 = this.canCreateEvents;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(guildScheduledEvents=");
        sbU.append(this.guildScheduledEvents);
        sbU.append(", canCreateEvents=");
        return a.O(sbU, this.canCreateEvents, ")");
    }
}
