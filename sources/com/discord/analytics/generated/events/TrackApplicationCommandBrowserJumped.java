package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackApplicationCommandBrowserJumped.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackApplicationCommandBrowserJumped implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long targetApplicationId = null;
    private final transient String analyticsSchemaTypeName = "application_command_browser_jumped";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackApplicationCommandBrowserJumped) && m.areEqual(this.targetApplicationId, ((TrackApplicationCommandBrowserJumped) other).targetApplicationId);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.targetApplicationId;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.G(a.U("TrackApplicationCommandBrowserJumped(targetApplicationId="), this.targetApplicationId, ")");
    }
}
