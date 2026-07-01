package com.discord.widgets.voice.sheet;

import b.d.b.a.a;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import d0.z.d.m;

/* JADX INFO: compiled from: CallParticipantsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class CallParticipantsAdapter$ListItem$Event extends CallParticipantsAdapter$ListItem {
    private final boolean canStartEvent;
    private final GuildScheduledEvent event;
    private final boolean isCurrentUserInCall;
    private final String key;
    private final int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallParticipantsAdapter$ListItem$Event(GuildScheduledEvent guildScheduledEvent, boolean z2, boolean z3) {
        super(null);
        m.checkNotNullParameter(guildScheduledEvent, "event");
        this.event = guildScheduledEvent;
        this.canStartEvent = z2;
        this.isCurrentUserInCall = z3;
        this.type = 5;
        this.key = String.valueOf(5);
    }

    public static /* synthetic */ CallParticipantsAdapter$ListItem$Event copy$default(CallParticipantsAdapter$ListItem$Event callParticipantsAdapter$ListItem$Event, GuildScheduledEvent guildScheduledEvent, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            guildScheduledEvent = callParticipantsAdapter$ListItem$Event.event;
        }
        if ((i & 2) != 0) {
            z2 = callParticipantsAdapter$ListItem$Event.canStartEvent;
        }
        if ((i & 4) != 0) {
            z3 = callParticipantsAdapter$ListItem$Event.isCurrentUserInCall;
        }
        return callParticipantsAdapter$ListItem$Event.copy(guildScheduledEvent, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildScheduledEvent getEvent() {
        return this.event;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanStartEvent() {
        return this.canStartEvent;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsCurrentUserInCall() {
        return this.isCurrentUserInCall;
    }

    public final CallParticipantsAdapter$ListItem$Event copy(GuildScheduledEvent event, boolean canStartEvent, boolean isCurrentUserInCall) {
        m.checkNotNullParameter(event, "event");
        return new CallParticipantsAdapter$ListItem$Event(event, canStartEvent, isCurrentUserInCall);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallParticipantsAdapter$ListItem$Event)) {
            return false;
        }
        CallParticipantsAdapter$ListItem$Event callParticipantsAdapter$ListItem$Event = (CallParticipantsAdapter$ListItem$Event) other;
        return m.areEqual(this.event, callParticipantsAdapter$ListItem$Event.event) && this.canStartEvent == callParticipantsAdapter$ListItem$Event.canStartEvent && this.isCurrentUserInCall == callParticipantsAdapter$ListItem$Event.isCurrentUserInCall;
    }

    public final boolean getCanStartEvent() {
        return this.canStartEvent;
    }

    public final GuildScheduledEvent getEvent() {
        return this.event;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        GuildScheduledEvent guildScheduledEvent = this.event;
        int iHashCode = (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0) * 31;
        boolean z2 = this.canStartEvent;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z3 = this.isCurrentUserInCall;
        return i + (z3 ? 1 : z3);
    }

    public final boolean isCurrentUserInCall() {
        return this.isCurrentUserInCall;
    }

    public String toString() {
        StringBuilder sbU = a.U("Event(event=");
        sbU.append(this.event);
        sbU.append(", canStartEvent=");
        sbU.append(this.canStartEvent);
        sbU.append(", isCurrentUserInCall=");
        return a.O(sbU, this.isCurrentUserInCall, ")");
    }
}
