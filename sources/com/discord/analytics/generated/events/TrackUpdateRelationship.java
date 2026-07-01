package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackUpdateRelationship.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUpdateRelationship implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Boolean isInitiator = null;
    private final Long mutualGuilds = null;
    private final Long otherUser = null;
    private final Long type = null;
    private final Long userGuilds = null;
    private final transient String analyticsSchemaTypeName = "update_relationship";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUpdateRelationship)) {
            return false;
        }
        TrackUpdateRelationship trackUpdateRelationship = (TrackUpdateRelationship) other;
        return m.areEqual(this.isInitiator, trackUpdateRelationship.isInitiator) && m.areEqual(this.mutualGuilds, trackUpdateRelationship.mutualGuilds) && m.areEqual(this.otherUser, trackUpdateRelationship.otherUser) && m.areEqual(this.type, trackUpdateRelationship.type) && m.areEqual(this.userGuilds, trackUpdateRelationship.userGuilds);
    }

    public int hashCode() {
        Boolean bool = this.isInitiator;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Long l = this.mutualGuilds;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.otherUser;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.type;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.userGuilds;
        return iHashCode4 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackUpdateRelationship(isInitiator=");
        sbU.append(this.isInitiator);
        sbU.append(", mutualGuilds=");
        sbU.append(this.mutualGuilds);
        sbU.append(", otherUser=");
        sbU.append(this.otherUser);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", userGuilds=");
        return a.G(sbU, this.userGuilds, ")");
    }
}
