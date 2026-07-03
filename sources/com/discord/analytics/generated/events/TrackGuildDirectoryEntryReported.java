package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackGuildDirectoryEntryReported.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildDirectoryEntryReported implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence reportType = null;
    private final CharSequence reportSubType = null;
    private final CharSequence subject = null;
    private final CharSequence description = null;
    private final Long reasonEnum = null;
    private final Long reportId = null;
    private final transient String analyticsSchemaTypeName = "guild_directory_entry_reported";

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: c */
    public void mo7508c(TrackGuild trackGuild) {
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
        if (!(other instanceof TrackGuildDirectoryEntryReported)) {
            return false;
        }
        TrackGuildDirectoryEntryReported trackGuildDirectoryEntryReported = (TrackGuildDirectoryEntryReported) other;
        return C12238m.areEqual(this.reportType, trackGuildDirectoryEntryReported.reportType) && C12238m.areEqual(this.reportSubType, trackGuildDirectoryEntryReported.reportSubType) && C12238m.areEqual(this.subject, trackGuildDirectoryEntryReported.subject) && C12238m.areEqual(this.description, trackGuildDirectoryEntryReported.description) && C12238m.areEqual(this.reasonEnum, trackGuildDirectoryEntryReported.reasonEnum) && C12238m.areEqual(this.reportId, trackGuildDirectoryEntryReported.reportId);
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
        Long l2 = this.reportId;
        return iHashCode5 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackGuildDirectoryEntryReported(reportType=");
        sbM833U.append(this.reportType);
        sbM833U.append(", reportSubType=");
        sbM833U.append(this.reportSubType);
        sbM833U.append(", subject=");
        sbM833U.append(this.subject);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", reasonEnum=");
        sbM833U.append(this.reasonEnum);
        sbM833U.append(", reportId=");
        return C1643a.m819G(sbM833U, this.reportId, ")");
    }
}
