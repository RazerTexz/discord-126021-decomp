package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: TrackDataInfraTest.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDataInfraTest implements AnalyticsSchema, TrackBaseReceiver {
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
        return m.areEqual(this.pushToken, trackDataInfraTest.pushToken) && m.areEqual(this.pushTokenArr, trackDataInfraTest.pushTokenArr) && m.areEqual(this.requiredStr, trackDataInfraTest.requiredStr) && m.areEqual(this.optionalStr, trackDataInfraTest.optionalStr);
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
        StringBuilder sbU = a.U("TrackDataInfraTest(pushToken=");
        sbU.append(this.pushToken);
        sbU.append(", pushTokenArr=");
        sbU.append(this.pushTokenArr);
        sbU.append(", requiredStr=");
        sbU.append(this.requiredStr);
        sbU.append(", optionalStr=");
        return a.E(sbU, this.optionalStr, ")");
    }
}
