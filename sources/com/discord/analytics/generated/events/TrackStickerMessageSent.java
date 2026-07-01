package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: TrackStickerMessageSent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStickerMessageSent implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long messageId = null;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long guildId = null;
    private final List<Long> stickerIds = null;
    private final transient String analyticsSchemaTypeName = "sticker_message_sent";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStickerMessageSent)) {
            return false;
        }
        TrackStickerMessageSent trackStickerMessageSent = (TrackStickerMessageSent) other;
        return Intrinsics3.areEqual(this.messageId, trackStickerMessageSent.messageId) && Intrinsics3.areEqual(this.channelId, trackStickerMessageSent.channelId) && Intrinsics3.areEqual(this.channelType, trackStickerMessageSent.channelType) && Intrinsics3.areEqual(this.guildId, trackStickerMessageSent.guildId) && Intrinsics3.areEqual(this.stickerIds, trackStickerMessageSent.stickerIds);
    }

    public int hashCode() {
        Long l = this.messageId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.channelType;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.guildId;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        List<Long> list = this.stickerIds;
        return iHashCode4 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStickerMessageSent(messageId=");
        sbU.append(this.messageId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", stickerIds=");
        return outline.L(sbU, this.stickerIds, ")");
    }
}
