package com.discord.widgets.guildscheduledevent;

import b.d.b.a.a;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GuildEventPromptListView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildEventPromptListView$ScheduledEventData {
    private final GuildScheduledEvent guildScheduledEvent;
    private final Function0<Unit> onScheduledEventClick;

    public GuildEventPromptListView$ScheduledEventData(GuildScheduledEvent guildScheduledEvent, Function0<Unit> function0) {
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        m.checkNotNullParameter(function0, "onScheduledEventClick");
        this.guildScheduledEvent = guildScheduledEvent;
        this.onScheduledEventClick = function0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildEventPromptListView$ScheduledEventData copy$default(GuildEventPromptListView$ScheduledEventData guildEventPromptListView$ScheduledEventData, GuildScheduledEvent guildScheduledEvent, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            guildScheduledEvent = guildEventPromptListView$ScheduledEventData.guildScheduledEvent;
        }
        if ((i & 2) != 0) {
            function0 = guildEventPromptListView$ScheduledEventData.onScheduledEventClick;
        }
        return guildEventPromptListView$ScheduledEventData.copy(guildScheduledEvent, function0);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    public final Function0<Unit> component2() {
        return this.onScheduledEventClick;
    }

    public final GuildEventPromptListView$ScheduledEventData copy(GuildScheduledEvent guildScheduledEvent, Function0<Unit> onScheduledEventClick) {
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        m.checkNotNullParameter(onScheduledEventClick, "onScheduledEventClick");
        return new GuildEventPromptListView$ScheduledEventData(guildScheduledEvent, onScheduledEventClick);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildEventPromptListView$ScheduledEventData)) {
            return false;
        }
        GuildEventPromptListView$ScheduledEventData guildEventPromptListView$ScheduledEventData = (GuildEventPromptListView$ScheduledEventData) other;
        return m.areEqual(this.guildScheduledEvent, guildEventPromptListView$ScheduledEventData.guildScheduledEvent) && m.areEqual(this.onScheduledEventClick, guildEventPromptListView$ScheduledEventData.onScheduledEventClick);
    }

    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    public final Function0<Unit> getOnScheduledEventClick() {
        return this.onScheduledEventClick;
    }

    public int hashCode() {
        GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
        int iHashCode = (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0) * 31;
        Function0<Unit> function0 = this.onScheduledEventClick;
        return iHashCode + (function0 != null ? function0.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ScheduledEventData(guildScheduledEvent=");
        sbU.append(this.guildScheduledEvent);
        sbU.append(", onScheduledEventClick=");
        sbU.append(this.onScheduledEventClick);
        sbU.append(")");
        return sbU.toString();
    }
}
