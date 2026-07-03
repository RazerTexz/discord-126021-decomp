package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackModalDismissed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackModalDismissed implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackLocationMetadataReceiver, TrackSourceMetadataReceiver {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackSourceMetadata trackSourceMetadata;
    private final CharSequence type = null;
    private final CharSequence dismissType = null;
    private final Long durationOpenMs = null;
    private final transient String analyticsSchemaTypeName = "modal_dismissed";

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
        if (!(other instanceof TrackModalDismissed)) {
            return false;
        }
        TrackModalDismissed trackModalDismissed = (TrackModalDismissed) other;
        return C12238m.areEqual(this.type, trackModalDismissed.type) && C12238m.areEqual(this.dismissType, trackModalDismissed.dismissType) && C12238m.areEqual(this.durationOpenMs, trackModalDismissed.durationOpenMs);
    }

    public int hashCode() {
        CharSequence charSequence = this.type;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.dismissType;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.durationOpenMs;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackModalDismissed(type=");
        sbM833U.append(this.type);
        sbM833U.append(", dismissType=");
        sbM833U.append(this.dismissType);
        sbM833U.append(", durationOpenMs=");
        return C1643a.m819G(sbM833U, this.durationOpenMs, ")");
    }
}
