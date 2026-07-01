package com.discord.widgets.mobile_reports;

import b.d.b.a.a;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: MobileReportsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MobileReportsViewModel$GuildScheduledEventPreview {
    private final GuildScheduledEvent event;
    private final Guild guild;

    public MobileReportsViewModel$GuildScheduledEventPreview(Guild guild, GuildScheduledEvent guildScheduledEvent) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(guildScheduledEvent, "event");
        this.guild = guild;
        this.event = guildScheduledEvent;
    }

    public static /* synthetic */ MobileReportsViewModel$GuildScheduledEventPreview copy$default(MobileReportsViewModel$GuildScheduledEventPreview mobileReportsViewModel$GuildScheduledEventPreview, Guild guild, GuildScheduledEvent guildScheduledEvent, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = mobileReportsViewModel$GuildScheduledEventPreview.guild;
        }
        if ((i & 2) != 0) {
            guildScheduledEvent = mobileReportsViewModel$GuildScheduledEventPreview.event;
        }
        return mobileReportsViewModel$GuildScheduledEventPreview.copy(guild, guildScheduledEvent);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final GuildScheduledEvent getEvent() {
        return this.event;
    }

    public final MobileReportsViewModel$GuildScheduledEventPreview copy(Guild guild, GuildScheduledEvent event) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(event, "event");
        return new MobileReportsViewModel$GuildScheduledEventPreview(guild, event);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MobileReportsViewModel$GuildScheduledEventPreview)) {
            return false;
        }
        MobileReportsViewModel$GuildScheduledEventPreview mobileReportsViewModel$GuildScheduledEventPreview = (MobileReportsViewModel$GuildScheduledEventPreview) other;
        return m.areEqual(this.guild, mobileReportsViewModel$GuildScheduledEventPreview.guild) && m.areEqual(this.event, mobileReportsViewModel$GuildScheduledEventPreview.event);
    }

    public final GuildScheduledEvent getEvent() {
        return this.event;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        GuildScheduledEvent guildScheduledEvent = this.event;
        return iHashCode + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildScheduledEventPreview(guild=");
        sbU.append(this.guild);
        sbU.append(", event=");
        sbU.append(this.event);
        sbU.append(")");
        return sbU.toString();
    }
}
