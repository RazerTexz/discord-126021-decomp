package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackStickerMessageSent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStickerMessageSent implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.messageId, trackStickerMessageSent.messageId) && C12238m.areEqual(this.channelId, trackStickerMessageSent.channelId) && C12238m.areEqual(this.channelType, trackStickerMessageSent.channelType) && C12238m.areEqual(this.guildId, trackStickerMessageSent.guildId) && C12238m.areEqual(this.stickerIds, trackStickerMessageSent.stickerIds);
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
        StringBuilder sbM833U = C1643a.m833U("TrackStickerMessageSent(messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", stickerIds=");
        return C1643a.m824L(sbM833U, this.stickerIds, ")");
    }
}
