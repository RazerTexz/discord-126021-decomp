package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackIntegrationRemoved.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackIntegrationRemoved implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long id = null;
    private final Long guildId = null;
    private final Long applicationId = null;
    private final List<CharSequence> scopes = null;
    private final transient String analyticsSchemaTypeName = "integration_removed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackIntegrationRemoved)) {
            return false;
        }
        TrackIntegrationRemoved trackIntegrationRemoved = (TrackIntegrationRemoved) other;
        return C12238m.areEqual(this.id, trackIntegrationRemoved.id) && C12238m.areEqual(this.guildId, trackIntegrationRemoved.guildId) && C12238m.areEqual(this.applicationId, trackIntegrationRemoved.applicationId) && C12238m.areEqual(this.scopes, trackIntegrationRemoved.scopes);
    }

    public int hashCode() {
        Long l = this.id;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.applicationId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        List<CharSequence> list = this.scopes;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackIntegrationRemoved(id=");
        sbM833U.append(this.id);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", scopes=");
        return C1643a.m824L(sbM833U, this.scopes, ")");
    }
}
