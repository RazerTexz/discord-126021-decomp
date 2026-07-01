package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackStickerSearchViewAll.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStickerSearchViewAll implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Long stickerId = null;
    private final Long stickerPackId = null;
    private final transient String analyticsSchemaTypeName = "sticker_search_view_all";

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
        if (!(other instanceof TrackStickerSearchViewAll)) {
            return false;
        }
        TrackStickerSearchViewAll trackStickerSearchViewAll = (TrackStickerSearchViewAll) other;
        return Intrinsics3.areEqual(this.stickerId, trackStickerSearchViewAll.stickerId) && Intrinsics3.areEqual(this.stickerPackId, trackStickerSearchViewAll.stickerPackId);
    }

    public int hashCode() {
        Long l = this.stickerId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.stickerPackId;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStickerSearchViewAll(stickerId=");
        sbU.append(this.stickerId);
        sbU.append(", stickerPackId=");
        return outline.G(sbU, this.stickerPackId, ")");
    }
}
