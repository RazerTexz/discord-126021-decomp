package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackAutoSuggestExpressionSelected.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAutoSuggestExpressionSelected implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final Long stickerId = null;
    private final Long emojiId = null;
    private final CharSequence suggestionTrigger = null;
    private final transient String analyticsSchemaTypeName = "auto_suggest_expression_selected";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAutoSuggestExpressionSelected)) {
            return false;
        }
        TrackAutoSuggestExpressionSelected trackAutoSuggestExpressionSelected = (TrackAutoSuggestExpressionSelected) other;
        return m.areEqual(this.stickerId, trackAutoSuggestExpressionSelected.stickerId) && m.areEqual(this.emojiId, trackAutoSuggestExpressionSelected.emojiId) && m.areEqual(this.suggestionTrigger, trackAutoSuggestExpressionSelected.suggestionTrigger);
    }

    public int hashCode() {
        Long l = this.stickerId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.emojiId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.suggestionTrigger;
        return iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackAutoSuggestExpressionSelected(stickerId=");
        sbU.append(this.stickerId);
        sbU.append(", emojiId=");
        sbU.append(this.emojiId);
        sbU.append(", suggestionTrigger=");
        return a.E(sbU, this.suggestionTrigger, ")");
    }
}
