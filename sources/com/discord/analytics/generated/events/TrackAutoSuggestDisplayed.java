package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackAutoSuggestDisplayed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAutoSuggestDisplayed implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver {
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
            return (other instanceof TrackAutoSuggestDisplayed) && C12238m.areEqual(this.suggestionTrigger, ((TrackAutoSuggestDisplayed) other).suggestionTrigger);
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
        return C1643a.m817E(C1643a.m833U("TrackAutoSuggestDisplayed(suggestionTrigger="), this.suggestionTrigger, ")");
    }
}
