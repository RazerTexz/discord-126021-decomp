package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackUserReauth.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUserReauth implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean success = null;
    private final transient String analyticsSchemaTypeName = "user_reauth";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackUserReauth) && Intrinsics3.areEqual(this.success, ((TrackUserReauth) other).success);
        }
        return true;
    }

    public int hashCode() {
        Boolean bool = this.success;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.D(outline.U("TrackUserReauth(success="), this.success, ")");
    }
}
