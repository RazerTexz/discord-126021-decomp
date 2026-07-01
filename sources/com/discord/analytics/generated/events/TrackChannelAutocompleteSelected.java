package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackChannelAutocompleteSelected.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackChannelAutocompleteSelected implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence autocompleteType = null;
    private final Boolean hasSticker = null;
    private final Boolean hasEmoji = null;
    private final Long numStickerResults = null;
    private final Long numEmojiResults = null;
    private final CharSequence selection = null;
    private final CharSequence selectionType = null;
    private final Long stickerId = null;
    private final transient String analyticsSchemaTypeName = "channel_autocomplete_selected";

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
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
        if (!(other instanceof TrackChannelAutocompleteSelected)) {
            return false;
        }
        TrackChannelAutocompleteSelected trackChannelAutocompleteSelected = (TrackChannelAutocompleteSelected) other;
        return m.areEqual(this.autocompleteType, trackChannelAutocompleteSelected.autocompleteType) && m.areEqual(this.hasSticker, trackChannelAutocompleteSelected.hasSticker) && m.areEqual(this.hasEmoji, trackChannelAutocompleteSelected.hasEmoji) && m.areEqual(this.numStickerResults, trackChannelAutocompleteSelected.numStickerResults) && m.areEqual(this.numEmojiResults, trackChannelAutocompleteSelected.numEmojiResults) && m.areEqual(this.selection, trackChannelAutocompleteSelected.selection) && m.areEqual(this.selectionType, trackChannelAutocompleteSelected.selectionType) && m.areEqual(this.stickerId, trackChannelAutocompleteSelected.stickerId);
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
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.selection;
        int iHashCode6 = (iHashCode5 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.selectionType;
        int iHashCode7 = (iHashCode6 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l3 = this.stickerId;
        return iHashCode7 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackChannelAutocompleteSelected(autocompleteType=");
        sbU.append(this.autocompleteType);
        sbU.append(", hasSticker=");
        sbU.append(this.hasSticker);
        sbU.append(", hasEmoji=");
        sbU.append(this.hasEmoji);
        sbU.append(", numStickerResults=");
        sbU.append(this.numStickerResults);
        sbU.append(", numEmojiResults=");
        sbU.append(this.numEmojiResults);
        sbU.append(", selection=");
        sbU.append(this.selection);
        sbU.append(", selectionType=");
        sbU.append(this.selectionType);
        sbU.append(", stickerId=");
        return a.G(sbU, this.stickerId, ")");
    }
}
