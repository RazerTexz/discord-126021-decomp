package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackIgnorePlatformAccount.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackIgnorePlatformAccount implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence platformType = null;
    private final CharSequence displayType = null;
    private final transient String analyticsSchemaTypeName = "ignore_platform_account";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackIgnorePlatformAccount)) {
            return false;
        }
        TrackIgnorePlatformAccount trackIgnorePlatformAccount = (TrackIgnorePlatformAccount) other;
        return Intrinsics3.areEqual(this.platformType, trackIgnorePlatformAccount.platformType) && Intrinsics3.areEqual(this.displayType, trackIgnorePlatformAccount.displayType);
    }

    public int hashCode() {
        CharSequence charSequence = this.platformType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.displayType;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackIgnorePlatformAccount(platformType=");
        sbU.append(this.platformType);
        sbU.append(", displayType=");
        return outline.E(sbU, this.displayType, ")");
    }
}
