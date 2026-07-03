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
        if (!(other instanceof TrackChannelAutocompleteSelected)) {
            return false;
        }
        TrackChannelAutocompleteSelected trackChannelAutocompleteSelected = (TrackChannelAutocompleteSelected) other;
        return C12238m.areEqual(this.autocompleteType, trackChannelAutocompleteSelected.autocompleteType) && C12238m.areEqual(this.hasSticker, trackChannelAutocompleteSelected.hasSticker) && C12238m.areEqual(this.hasEmoji, trackChannelAutocompleteSelected.hasEmoji) && C12238m.areEqual(this.numStickerResults, trackChannelAutocompleteSelected.numStickerResults) && C12238m.areEqual(this.numEmojiResults, trackChannelAutocompleteSelected.numEmojiResults) && C12238m.areEqual(this.selection, trackChannelAutocompleteSelected.selection) && C12238m.areEqual(this.selectionType, trackChannelAutocompleteSelected.selectionType) && C12238m.areEqual(this.stickerId, trackChannelAutocompleteSelected.stickerId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackChannelAutocompleteSelected(autocompleteType=");
        sbM833U.append(this.autocompleteType);
        sbM833U.append(", hasSticker=");
        sbM833U.append(this.hasSticker);
        sbM833U.append(", hasEmoji=");
        sbM833U.append(this.hasEmoji);
        sbM833U.append(", numStickerResults=");
        sbM833U.append(this.numStickerResults);
        sbM833U.append(", numEmojiResults=");
        sbM833U.append(this.numEmojiResults);
        sbM833U.append(", selection=");
        sbM833U.append(this.selection);
        sbM833U.append(", selectionType=");
        sbM833U.append(this.selectionType);
        sbM833U.append(", stickerId=");
        return C1643a.m819G(sbM833U, this.stickerId, ")");
    }
}
