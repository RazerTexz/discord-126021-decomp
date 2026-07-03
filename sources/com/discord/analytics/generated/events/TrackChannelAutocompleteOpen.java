package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackChannelAutocompleteOpen.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackChannelAutocompleteOpen implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence autocompleteType = null;
    private final Boolean hasSticker = null;
    private final Boolean hasEmoji = null;
    private final Long numStickerResults = null;
    private final Long numEmojiResults = null;
    private final transient String analyticsSchemaTypeName = "channel_autocomplete_open";

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
        if (!(other instanceof TrackChannelAutocompleteOpen)) {
            return false;
        }
        TrackChannelAutocompleteOpen trackChannelAutocompleteOpen = (TrackChannelAutocompleteOpen) other;
        return C12238m.areEqual(this.autocompleteType, trackChannelAutocompleteOpen.autocompleteType) && C12238m.areEqual(this.hasSticker, trackChannelAutocompleteOpen.hasSticker) && C12238m.areEqual(this.hasEmoji, trackChannelAutocompleteOpen.hasEmoji) && C12238m.areEqual(this.numStickerResults, trackChannelAutocompleteOpen.numStickerResults) && C12238m.areEqual(this.numEmojiResults, trackChannelAutocompleteOpen.numEmojiResults);
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
        StringBuilder sbM833U = C1643a.m833U("TrackChannelAutocompleteOpen(autocompleteType=");
        sbM833U.append(this.autocompleteType);
        sbM833U.append(", hasSticker=");
        sbM833U.append(this.hasSticker);
        sbM833U.append(", hasEmoji=");
        sbM833U.append(this.hasEmoji);
        sbM833U.append(", numStickerResults=");
        sbM833U.append(this.numStickerResults);
        sbM833U.append(", numEmojiResults=");
        return C1643a.m819G(sbM833U, this.numEmojiResults, ")");
    }
}
