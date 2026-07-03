package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackDetectPlatformAccount.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDetectPlatformAccount implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence platformType = null;
    private final CharSequence displayType = null;
    private final transient String analyticsSchemaTypeName = "detect_platform_account";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDetectPlatformAccount)) {
            return false;
        }
        TrackDetectPlatformAccount trackDetectPlatformAccount = (TrackDetectPlatformAccount) other;
        return C12238m.areEqual(this.platformType, trackDetectPlatformAccount.platformType) && C12238m.areEqual(this.displayType, trackDetectPlatformAccount.displayType);
    }

    public int hashCode() {
        CharSequence charSequence = this.platformType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.displayType;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackDetectPlatformAccount(platformType=");
        sbM833U.append(this.platformType);
        sbM833U.append(", displayType=");
        return C1643a.m817E(sbM833U, this.displayType, ")");
    }
}
