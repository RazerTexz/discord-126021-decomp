package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackUpdateConnectedAccount.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUpdateConnectedAccount implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence accountId = null;
    private final CharSequence accountName = null;
    private final Boolean connected = null;
    private final CharSequence platformType = null;
    private final Long visibility = null;
    private final Boolean friendSync = null;
    private final Boolean partner = null;
    private final CharSequence linkMethod = null;
    private final transient String analyticsSchemaTypeName = "update_connected_account";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUpdateConnectedAccount)) {
            return false;
        }
        TrackUpdateConnectedAccount trackUpdateConnectedAccount = (TrackUpdateConnectedAccount) other;
        return m.areEqual(this.accountId, trackUpdateConnectedAccount.accountId) && m.areEqual(this.accountName, trackUpdateConnectedAccount.accountName) && m.areEqual(this.connected, trackUpdateConnectedAccount.connected) && m.areEqual(this.platformType, trackUpdateConnectedAccount.platformType) && m.areEqual(this.visibility, trackUpdateConnectedAccount.visibility) && m.areEqual(this.friendSync, trackUpdateConnectedAccount.friendSync) && m.areEqual(this.partner, trackUpdateConnectedAccount.partner) && m.areEqual(this.linkMethod, trackUpdateConnectedAccount.linkMethod);
    }

    public int hashCode() {
        CharSequence charSequence = this.accountId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.accountName;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool = this.connected;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.platformType;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l = this.visibility;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool2 = this.friendSync;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.partner;
        int iHashCode7 = (iHashCode6 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.linkMethod;
        return iHashCode7 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackUpdateConnectedAccount(accountId=");
        sbU.append(this.accountId);
        sbU.append(", accountName=");
        sbU.append(this.accountName);
        sbU.append(", connected=");
        sbU.append(this.connected);
        sbU.append(", platformType=");
        sbU.append(this.platformType);
        sbU.append(", visibility=");
        sbU.append(this.visibility);
        sbU.append(", friendSync=");
        sbU.append(this.friendSync);
        sbU.append(", partner=");
        sbU.append(this.partner);
        sbU.append(", linkMethod=");
        return a.E(sbU, this.linkMethod, ")");
    }
}
