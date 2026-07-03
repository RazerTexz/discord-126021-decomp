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
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackIarBlockUserButtonClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackIarBlockUserButtonClicked implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence otherUserId = null;
    private final Long reportId = null;
    private final transient String analyticsSchemaTypeName = "iar_block_user_button_clicked";

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
        if (!(other instanceof TrackIarBlockUserButtonClicked)) {
            return false;
        }
        TrackIarBlockUserButtonClicked trackIarBlockUserButtonClicked = (TrackIarBlockUserButtonClicked) other;
        return C12238m.areEqual(this.otherUserId, trackIarBlockUserButtonClicked.otherUserId) && C12238m.areEqual(this.reportId, trackIarBlockUserButtonClicked.reportId);
    }

    public int hashCode() {
        CharSequence charSequence = this.otherUserId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.reportId;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackIarBlockUserButtonClicked(otherUserId=");
        sbM833U.append(this.otherUserId);
        sbM833U.append(", reportId=");
        return C1643a.m819G(sbM833U, this.reportId, ")");
    }
}
