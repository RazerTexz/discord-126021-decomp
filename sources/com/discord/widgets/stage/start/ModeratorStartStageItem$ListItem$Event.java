package com.discord.widgets.stage.start;

import b.d.b.a.a;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import d0.z.d.m;

/* JADX INFO: compiled from: ModeratorStartStageItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ModeratorStartStageItem$ListItem$Event extends ModeratorStartStageItem$ListItem {
    private final GuildScheduledEvent event;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModeratorStartStageItem$ListItem$Event(GuildScheduledEvent guildScheduledEvent) {
        super(0, String.valueOf(guildScheduledEvent.getId()), 2131231750, 2131100304, 1, null);
        m.checkNotNullParameter(guildScheduledEvent, "event");
        this.event = guildScheduledEvent;
    }

    public static /* synthetic */ ModeratorStartStageItem$ListItem$Event copy$default(ModeratorStartStageItem$ListItem$Event moderatorStartStageItem$ListItem$Event, GuildScheduledEvent guildScheduledEvent, int i, Object obj) {
        if ((i & 1) != 0) {
            guildScheduledEvent = moderatorStartStageItem$ListItem$Event.event;
        }
        return moderatorStartStageItem$ListItem$Event.copy(guildScheduledEvent);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildScheduledEvent getEvent() {
        return this.event;
    }

    public final ModeratorStartStageItem$ListItem$Event copy(GuildScheduledEvent event) {
        m.checkNotNullParameter(event, "event");
        return new ModeratorStartStageItem$ListItem$Event(event);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ModeratorStartStageItem$ListItem$Event) && m.areEqual(this.event, ((ModeratorStartStageItem$ListItem$Event) other).event);
        }
        return true;
    }

    public final GuildScheduledEvent getEvent() {
        return this.event;
    }

    public int hashCode() {
        GuildScheduledEvent guildScheduledEvent = this.event;
        if (guildScheduledEvent != null) {
            return guildScheduledEvent.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Event(event=");
        sbU.append(this.event);
        sbU.append(")");
        return sbU.toString();
    }
}
