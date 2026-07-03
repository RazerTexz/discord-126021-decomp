package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuildTemplate;
import com.discord.analytics.generated.traits.TrackGuildTemplateReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackCreateGuildViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackCreateGuildViewed implements AnalyticsSchema, TrackBaseReceiver, TrackGuildTemplateReceiver, TrackLocationMetadataReceiver {
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
            return (other instanceof TrackCreateGuildViewed) && C12238m.areEqual(this.flowStep, ((TrackCreateGuildViewed) other).flowStep);
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
        return C1643a.m817E(C1643a.m833U("TrackCreateGuildViewed(flowStep="), this.flowStep, ")");
    }
}
