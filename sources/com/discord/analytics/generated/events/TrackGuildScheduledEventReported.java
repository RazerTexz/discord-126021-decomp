package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackGuildScheduledEventReported.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildScheduledEventReported implements AnalyticsSchema, TrackBase2, TrackGuild2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final CharSequence reportType = null;
    private final CharSequence reportSubType = null;
    private final CharSequence subject = null;
    private final CharSequence description = null;
    private final Long reasonEnum = null;
    private final Long guildScheduledEventId = null;
    private final transient String analyticsSchemaTypeName = "guild_scheduled_event_reported";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildScheduledEventReported)) {
            return false;
        }
        TrackGuildScheduledEventReported trackGuildScheduledEventReported = (TrackGuildScheduledEventReported) other;
        return Intrinsics3.areEqual(this.reportType, trackGuildScheduledEventReported.reportType) && Intrinsics3.areEqual(this.reportSubType, trackGuildScheduledEventReported.reportSubType) && Intrinsics3.areEqual(this.subject, trackGuildScheduledEventReported.subject) && Intrinsics3.areEqual(this.description, trackGuildScheduledEventReported.description) && Intrinsics3.areEqual(this.reasonEnum, trackGuildScheduledEventReported.reasonEnum) && Intrinsics3.areEqual(this.guildScheduledEventId, trackGuildScheduledEventReported.guildScheduledEventId);
    }

    public int hashCode() {
        CharSequence charSequence = this.reportType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.reportSubType;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.subject;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.description;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l = this.reasonEnum;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.guildScheduledEventId;
        return iHashCode5 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildScheduledEventReported(reportType=");
        sbU.append(this.reportType);
        sbU.append(", reportSubType=");
        sbU.append(this.reportSubType);
        sbU.append(", subject=");
        sbU.append(this.subject);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", reasonEnum=");
        sbU.append(this.reasonEnum);
        sbU.append(", guildScheduledEventId=");
        return outline.G(sbU, this.guildScheduledEventId, ")");
    }
}
