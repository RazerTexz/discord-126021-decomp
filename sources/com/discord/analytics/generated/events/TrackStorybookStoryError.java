package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackStorybookStoryError.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStorybookStoryError implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence storyId = null;
    private final transient String analyticsSchemaTypeName = "storybook_story_error";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackStorybookStoryError) && Intrinsics3.areEqual(this.storyId, ((TrackStorybookStoryError) other).storyId);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.storyId;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.E(outline.U("TrackStorybookStoryError(storyId="), this.storyId, ")");
    }
}
