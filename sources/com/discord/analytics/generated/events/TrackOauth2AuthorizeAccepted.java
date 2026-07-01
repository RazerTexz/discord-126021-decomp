package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackOauth2AuthorizeAccepted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackOauth2AuthorizeAccepted implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final transient String analyticsSchemaTypeName = "oauth2_authorize_accepted";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackOauth2AuthorizeAccepted) && m.areEqual(this.applicationId, ((TrackOauth2AuthorizeAccepted) other).applicationId);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.applicationId;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.G(a.U("TrackOauth2AuthorizeAccepted(applicationId="), this.applicationId, ")");
    }
}
