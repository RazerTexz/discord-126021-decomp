package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGiftCodeMetadata;
import com.discord.analytics.generated.traits.TrackGiftCodeMetadataReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackGiftCodeSent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGiftCodeSent implements AnalyticsSchema, TrackBaseReceiver, TrackStoreSkuMetadataReceiver, TrackGiftCodeMetadataReceiver, TrackLocationMetadataReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGiftCodeMetadata trackGiftCodeMetadata;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private final Long messageId = null;
    private final Boolean automaticSend = null;
    private final transient String analyticsSchemaTypeName = "gift_code_sent";

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
        if (!(other instanceof TrackGiftCodeSent)) {
            return false;
        }
        TrackGiftCodeSent trackGiftCodeSent = (TrackGiftCodeSent) other;
        return C12238m.areEqual(this.messageId, trackGiftCodeSent.messageId) && C12238m.areEqual(this.automaticSend, trackGiftCodeSent.automaticSend);
    }

    public int hashCode() {
        Long l = this.messageId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Boolean bool = this.automaticSend;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackGiftCodeSent(messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", automaticSend=");
        return C1643a.m816D(sbM833U, this.automaticSend, ")");
    }
}
