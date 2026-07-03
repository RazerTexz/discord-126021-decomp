package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.pushToken, trackDataInfraTest.pushToken) && C12238m.areEqual(this.pushTokenArr, trackDataInfraTest.pushTokenArr) && C12238m.areEqual(this.requiredStr, trackDataInfraTest.requiredStr) && C12238m.areEqual(this.optionalStr, trackDataInfraTest.optionalStr);
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
        StringBuilder sbM833U = C1643a.m833U("TrackDataInfraTest(pushToken=");
        sbM833U.append(this.pushToken);
        sbM833U.append(", pushTokenArr=");
        sbM833U.append(this.pushTokenArr);
        sbM833U.append(", requiredStr=");
        sbM833U.append(this.requiredStr);
        sbM833U.append(", optionalStr=");
        return C1643a.m817E(sbM833U, this.optionalStr, ")");
    }
}
