package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackCreateInstantInvite.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackCreateInstantInvite implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Boolean temporary = null;
    private final Long maxUses = null;
    private final Long maxAge = null;
    private final Boolean regenerate = null;
    private final Boolean unique = null;
    private final CharSequence code = null;
    private final Long guildId = null;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long inviteType = null;
    private final transient String analyticsSchemaTypeName = "create_instant_invite";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackCreateInstantInvite)) {
            return false;
        }
        TrackCreateInstantInvite trackCreateInstantInvite = (TrackCreateInstantInvite) other;
        return C12238m.areEqual(this.temporary, trackCreateInstantInvite.temporary) && C12238m.areEqual(this.maxUses, trackCreateInstantInvite.maxUses) && C12238m.areEqual(this.maxAge, trackCreateInstantInvite.maxAge) && C12238m.areEqual(this.regenerate, trackCreateInstantInvite.regenerate) && C12238m.areEqual(this.unique, trackCreateInstantInvite.unique) && C12238m.areEqual(this.code, trackCreateInstantInvite.code) && C12238m.areEqual(this.guildId, trackCreateInstantInvite.guildId) && C12238m.areEqual(this.channelId, trackCreateInstantInvite.channelId) && C12238m.areEqual(this.channelType, trackCreateInstantInvite.channelType) && C12238m.areEqual(this.inviteType, trackCreateInstantInvite.inviteType);
    }

    public int hashCode() {
        Boolean bool = this.temporary;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Long l = this.maxUses;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.maxAge;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool2 = this.regenerate;
        int iHashCode4 = (iHashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.unique;
        int iHashCode5 = (iHashCode4 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        CharSequence charSequence = this.code;
        int iHashCode6 = (iHashCode5 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode7 = (iHashCode6 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.channelId;
        int iHashCode8 = (iHashCode7 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.channelType;
        int iHashCode9 = (iHashCode8 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.inviteType;
        return iHashCode9 + (l6 != null ? l6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackCreateInstantInvite(temporary=");
        sbM833U.append(this.temporary);
        sbM833U.append(", maxUses=");
        sbM833U.append(this.maxUses);
        sbM833U.append(", maxAge=");
        sbM833U.append(this.maxAge);
        sbM833U.append(", regenerate=");
        sbM833U.append(this.regenerate);
        sbM833U.append(", unique=");
        sbM833U.append(this.unique);
        sbM833U.append(", code=");
        sbM833U.append(this.code);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", inviteType=");
        return C1643a.m819G(sbM833U, this.inviteType, ")");
    }
}
