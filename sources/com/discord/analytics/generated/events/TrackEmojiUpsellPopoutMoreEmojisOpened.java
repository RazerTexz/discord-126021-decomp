package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackEmojiUpsellPopoutMoreEmojisOpened.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackEmojiUpsellPopoutMoreEmojisOpened implements AnalyticsSchema, TrackBaseReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private final Long guildId = null;
    private final Long emojiId = null;
    private final transient String analyticsSchemaTypeName = "emoji_upsell_popout_more_emojis_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackEmojiUpsellPopoutMoreEmojisOpened)) {
            return false;
        }
        TrackEmojiUpsellPopoutMoreEmojisOpened trackEmojiUpsellPopoutMoreEmojisOpened = (TrackEmojiUpsellPopoutMoreEmojisOpened) other;
        return C12238m.areEqual(this.guildId, trackEmojiUpsellPopoutMoreEmojisOpened.guildId) && C12238m.areEqual(this.emojiId, trackEmojiUpsellPopoutMoreEmojisOpened.emojiId);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.emojiId;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackEmojiUpsellPopoutMoreEmojisOpened(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", emojiId=");
        return C1643a.m819G(sbM833U, this.emojiId, ")");
    }
}
