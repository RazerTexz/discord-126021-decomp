package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuildTemplate;
import com.discord.analytics.generated.traits.TrackGuildTemplate2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackCreateGuildViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackCreateGuildViewed implements AnalyticsSchema, TrackBase2, TrackGuildTemplate2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackGuildTemplate trackGuildTemplate;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence flowStep = null;
    private final transient String analyticsSchemaTypeName = "create_guild_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackCreateGuildViewed) && Intrinsics3.areEqual(this.flowStep, ((TrackCreateGuildViewed) other).flowStep);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.flowStep;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.E(outline.U("TrackCreateGuildViewed(flowStep="), this.flowStep, ")");
    }
}
