package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuildTemplate;
import com.discord.analytics.generated.traits.TrackGuildTemplate2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackGuildTemplateResolved.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildTemplateResolved implements AnalyticsSchema, TrackBase2, TrackGuildTemplate2 {
    private TrackBase trackBase;
    private TrackGuildTemplate trackGuildTemplate;
    private final Boolean resolved = null;
    private final transient String analyticsSchemaTypeName = "guild_template_resolved";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackGuildTemplateResolved) && Intrinsics3.areEqual(this.resolved, ((TrackGuildTemplateResolved) other).resolved);
        }
        return true;
    }

    public int hashCode() {
        Boolean bool = this.resolved;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.D(outline.U("TrackGuildTemplateResolved(resolved="), this.resolved, ")");
    }
}
