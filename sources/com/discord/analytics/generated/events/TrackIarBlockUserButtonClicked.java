package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackIarBlockUserButtonClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackIarBlockUserButtonClicked implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence otherUserId = null;
    private final Long reportId = null;
    private final transient String analyticsSchemaTypeName = "iar_block_user_button_clicked";

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
        if (!(other instanceof TrackIarBlockUserButtonClicked)) {
            return false;
        }
        TrackIarBlockUserButtonClicked trackIarBlockUserButtonClicked = (TrackIarBlockUserButtonClicked) other;
        return Intrinsics3.areEqual(this.otherUserId, trackIarBlockUserButtonClicked.otherUserId) && Intrinsics3.areEqual(this.reportId, trackIarBlockUserButtonClicked.reportId);
    }

    public int hashCode() {
        CharSequence charSequence = this.otherUserId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.reportId;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackIarBlockUserButtonClicked(otherUserId=");
        sbU.append(this.otherUserId);
        sbU.append(", reportId=");
        return outline.G(sbU, this.reportId, ")");
    }
}
