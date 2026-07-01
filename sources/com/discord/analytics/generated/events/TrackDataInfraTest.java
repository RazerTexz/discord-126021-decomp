package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: TrackDataInfraTest.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDataInfraTest implements AnalyticsSchema, TrackBase2 {
    private final transient String analyticsSchemaTypeName;
    private final CharSequence optionalStr;
    private final CharSequence pushToken;
    private final List<CharSequence> pushTokenArr;
    private final CharSequence requiredStr;
    private TrackBase trackBase;

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDataInfraTest)) {
            return false;
        }
        TrackDataInfraTest trackDataInfraTest = (TrackDataInfraTest) other;
        return Intrinsics3.areEqual(this.pushToken, trackDataInfraTest.pushToken) && Intrinsics3.areEqual(this.pushTokenArr, trackDataInfraTest.pushTokenArr) && Intrinsics3.areEqual(this.requiredStr, trackDataInfraTest.requiredStr) && Intrinsics3.areEqual(this.optionalStr, trackDataInfraTest.optionalStr);
    }

    public int hashCode() {
        CharSequence charSequence = this.pushToken;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        List<CharSequence> list = this.pushTokenArr;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.requiredStr;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.optionalStr;
        return iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackDataInfraTest(pushToken=");
        sbU.append(this.pushToken);
        sbU.append(", pushTokenArr=");
        sbU.append(this.pushTokenArr);
        sbU.append(", requiredStr=");
        sbU.append(this.requiredStr);
        sbU.append(", optionalStr=");
        return outline.E(sbU, this.optionalStr, ")");
    }
}
