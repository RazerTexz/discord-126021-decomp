package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackSearchStarted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSearchStarted implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private final transient String analyticsSchemaTypeName;
    private final Long categoryId;
    private final CharSequence loadId;
    private final long modifiers;
    private final Long numModifiers;
    private final CharSequence prevSearchId;
    private final Boolean previewEnabled;
    private final CharSequence searchType;
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
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
        if (!(other instanceof TrackSearchStarted)) {
            return false;
        }
        TrackSearchStarted trackSearchStarted = (TrackSearchStarted) other;
        return m.areEqual(this.searchType, trackSearchStarted.searchType) && m.areEqual(this.loadId, trackSearchStarted.loadId) && m.areEqual(this.prevSearchId, trackSearchStarted.prevSearchId) && this.modifiers == trackSearchStarted.modifiers && m.areEqual(this.numModifiers, trackSearchStarted.numModifiers) && m.areEqual(this.previewEnabled, trackSearchStarted.previewEnabled) && m.areEqual(this.categoryId, trackSearchStarted.categoryId);
    }

    public int hashCode() {
        CharSequence charSequence = this.searchType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.loadId;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.prevSearchId;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        long j = this.modifiers;
        int i = (iHashCode3 + ((int) (j ^ (j >>> 32)))) * 31;
        Long l = this.numModifiers;
        int iHashCode4 = (i + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool = this.previewEnabled;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l2 = this.categoryId;
        return iHashCode5 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackSearchStarted(searchType=");
        sbU.append(this.searchType);
        sbU.append(", loadId=");
        sbU.append(this.loadId);
        sbU.append(", prevSearchId=");
        sbU.append(this.prevSearchId);
        sbU.append(", modifiers=");
        sbU.append(this.modifiers);
        sbU.append(", numModifiers=");
        sbU.append(this.numModifiers);
        sbU.append(", previewEnabled=");
        sbU.append(this.previewEnabled);
        sbU.append(", categoryId=");
        return a.G(sbU, this.categoryId, ")");
    }
}
