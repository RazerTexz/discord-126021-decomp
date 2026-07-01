package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackAutoSuggestDisplayed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAutoSuggestDisplayed implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence suggestionTrigger = null;
    private final transient String analyticsSchemaTypeName = "auto_suggest_displayed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackAutoSuggestDisplayed) && Intrinsics3.areEqual(this.suggestionTrigger, ((TrackAutoSuggestDisplayed) other).suggestionTrigger);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.suggestionTrigger;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.E(outline.U("TrackAutoSuggestDisplayed(suggestionTrigger="), this.suggestionTrigger, ")");
    }
}
