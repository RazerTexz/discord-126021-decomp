package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackAddReaction.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAddReaction implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long messageId = null;
    private final Long emojiId = null;
    private final CharSequence emojiName = null;
    private final Boolean emojiAnimated = null;
    private final Long uniqueReactionCount = null;
    private final transient String analyticsSchemaTypeName = "add_reaction";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAddReaction)) {
            return false;
        }
        TrackAddReaction trackAddReaction = (TrackAddReaction) other;
        return C12238m.areEqual(this.guildId, trackAddReaction.guildId) && C12238m.areEqual(this.channelId, trackAddReaction.channelId) && C12238m.areEqual(this.channelType, trackAddReaction.channelType) && C12238m.areEqual(this.messageId, trackAddReaction.messageId) && C12238m.areEqual(this.emojiId, trackAddReaction.emojiId) && C12238m.areEqual(this.emojiName, trackAddReaction.emojiName) && C12238m.areEqual(this.emojiAnimated, trackAddReaction.emojiAnimated) && C12238m.areEqual(this.uniqueReactionCount, trackAddReaction.uniqueReactionCount);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.channelType;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.messageId;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.emojiId;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        CharSequence charSequence = this.emojiName;
        int iHashCode6 = (iHashCode5 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.emojiAnimated;
        int iHashCode7 = (iHashCode6 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l6 = this.uniqueReactionCount;
        return iHashCode7 + (l6 != null ? l6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackAddReaction(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", emojiId=");
        sbM833U.append(this.emojiId);
        sbM833U.append(", emojiName=");
        sbM833U.append(this.emojiName);
        sbM833U.append(", emojiAnimated=");
        sbM833U.append(this.emojiAnimated);
        sbM833U.append(", uniqueReactionCount=");
        return C1643a.m819G(sbM833U, this.uniqueReactionCount, ")");
    }
}
