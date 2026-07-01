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

/* JADX INFO: compiled from: TrackChannelAutocompleteOpen.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackChannelAutocompleteOpen implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence autocompleteType = null;
    private final Boolean hasSticker = null;
    private final Boolean hasEmoji = null;
    private final Long numStickerResults = null;
    private final Long numEmojiResults = null;
    private final transient String analyticsSchemaTypeName = "channel_autocomplete_open";

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
        if (!(other instanceof TrackChannelAutocompleteOpen)) {
            return false;
        }
        TrackChannelAutocompleteOpen trackChannelAutocompleteOpen = (TrackChannelAutocompleteOpen) other;
        return Intrinsics3.areEqual(this.autocompleteType, trackChannelAutocompleteOpen.autocompleteType) && Intrinsics3.areEqual(this.hasSticker, trackChannelAutocompleteOpen.hasSticker) && Intrinsics3.areEqual(this.hasEmoji, trackChannelAutocompleteOpen.hasEmoji) && Intrinsics3.areEqual(this.numStickerResults, trackChannelAutocompleteOpen.numStickerResults) && Intrinsics3.areEqual(this.numEmojiResults, trackChannelAutocompleteOpen.numEmojiResults);
    }

    public int hashCode() {
        CharSequence charSequence = this.autocompleteType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.hasSticker;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasEmoji;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l = this.numStickerResults;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.numEmojiResults;
        return iHashCode4 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackChannelAutocompleteOpen(autocompleteType=");
        sbU.append(this.autocompleteType);
        sbU.append(", hasSticker=");
        sbU.append(this.hasSticker);
        sbU.append(", hasEmoji=");
        sbU.append(this.hasEmoji);
        sbU.append(", numStickerResults=");
        sbU.append(this.numStickerResults);
        sbU.append(", numEmojiResults=");
        return outline.G(sbU, this.numEmojiResults, ")");
    }
}
