package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.accountId, trackUpdateConnectedAccount.accountId) && C12238m.areEqual(this.accountName, trackUpdateConnectedAccount.accountName) && C12238m.areEqual(this.connected, trackUpdateConnectedAccount.connected) && C12238m.areEqual(this.platformType, trackUpdateConnectedAccount.platformType) && C12238m.areEqual(this.visibility, trackUpdateConnectedAccount.visibility) && C12238m.areEqual(this.friendSync, trackUpdateConnectedAccount.friendSync) && C12238m.areEqual(this.partner, trackUpdateConnectedAccount.partner) && C12238m.areEqual(this.linkMethod, trackUpdateConnectedAccount.linkMethod);
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
        StringBuilder sbM833U = C1643a.m833U("TrackUpdateConnectedAccount(accountId=");
        sbM833U.append(this.accountId);
        sbM833U.append(", accountName=");
        sbM833U.append(this.accountName);
        sbM833U.append(", connected=");
        sbM833U.append(this.connected);
        sbM833U.append(", platformType=");
        sbM833U.append(this.platformType);
        sbM833U.append(", visibility=");
        sbM833U.append(this.visibility);
        sbM833U.append(", friendSync=");
        sbM833U.append(this.friendSync);
        sbM833U.append(", partner=");
        sbM833U.append(this.partner);
        sbM833U.append(", linkMethod=");
        return C1643a.m817E(sbM833U, this.linkMethod, ")");
    }
}
