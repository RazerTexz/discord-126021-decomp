package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackJoinedIntegration.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackJoinedIntegration implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long guild = null;
    private final Long guildOwner = null;
    private final CharSequence integration = null;
    private final CharSequence integrationType = null;
    private final Long integrationUser = null;
    private final Long userDay = null;
    private final Long userGuilds = null;
    private final transient String analyticsSchemaTypeName = "joined_integration";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackJoinedIntegration)) {
            return false;
        }
        TrackJoinedIntegration trackJoinedIntegration = (TrackJoinedIntegration) other;
        return Intrinsics3.areEqual(this.guild, trackJoinedIntegration.guild) && Intrinsics3.areEqual(this.guildOwner, trackJoinedIntegration.guildOwner) && Intrinsics3.areEqual(this.integration, trackJoinedIntegration.integration) && Intrinsics3.areEqual(this.integrationType, trackJoinedIntegration.integrationType) && Intrinsics3.areEqual(this.integrationUser, trackJoinedIntegration.integrationUser) && Intrinsics3.areEqual(this.userDay, trackJoinedIntegration.userDay) && Intrinsics3.areEqual(this.userGuilds, trackJoinedIntegration.userGuilds);
    }

    public int hashCode() {
        Long l = this.guild;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildOwner;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.integration;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.integrationType;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l3 = this.integrationUser;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.userDay;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.userGuilds;
        return iHashCode6 + (l5 != null ? l5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackJoinedIntegration(guild=");
        sbU.append(this.guild);
        sbU.append(", guildOwner=");
        sbU.append(this.guildOwner);
        sbU.append(", integration=");
        sbU.append(this.integration);
        sbU.append(", integrationType=");
        sbU.append(this.integrationType);
        sbU.append(", integrationUser=");
        sbU.append(this.integrationUser);
        sbU.append(", userDay=");
        sbU.append(this.userDay);
        sbU.append(", userGuilds=");
        return outline.G(sbU, this.userGuilds, ")");
    }
}
