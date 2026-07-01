package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGiftCodeMetadata;
import com.discord.analytics.generated.traits.TrackGiftCodeMetadata2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackGiftCodeSent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGiftCodeSent implements AnalyticsSchema, TrackBase2, TrackStoreSkuMetadata2, TrackGiftCodeMetadata2, TrackLocationMetadata2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGiftCodeMetadata trackGiftCodeMetadata;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private final Long messageId = null;
    private final Boolean automaticSend = null;
    private final transient String analyticsSchemaTypeName = "gift_code_sent";

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
        if (!(other instanceof TrackGiftCodeSent)) {
            return false;
        }
        TrackGiftCodeSent trackGiftCodeSent = (TrackGiftCodeSent) other;
        return Intrinsics3.areEqual(this.messageId, trackGiftCodeSent.messageId) && Intrinsics3.areEqual(this.automaticSend, trackGiftCodeSent.automaticSend);
    }

    public int hashCode() {
        Long l = this.messageId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Boolean bool = this.automaticSend;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGiftCodeSent(messageId=");
        sbU.append(this.messageId);
        sbU.append(", automaticSend=");
        return outline.D(sbU, this.automaticSend, ")");
    }
}
