package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackAppNoticeClosed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAppNoticeClosed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence noticeType = null;
    private final CharSequence action = null;
    private final CharSequence surveyId = null;
    private final Boolean dismissed = null;
    private final transient String analyticsSchemaTypeName = "app_notice_closed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAppNoticeClosed)) {
            return false;
        }
        TrackAppNoticeClosed trackAppNoticeClosed = (TrackAppNoticeClosed) other;
        return Intrinsics3.areEqual(this.noticeType, trackAppNoticeClosed.noticeType) && Intrinsics3.areEqual(this.action, trackAppNoticeClosed.action) && Intrinsics3.areEqual(this.surveyId, trackAppNoticeClosed.surveyId) && Intrinsics3.areEqual(this.dismissed, trackAppNoticeClosed.dismissed);
    }

    public int hashCode() {
        CharSequence charSequence = this.noticeType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.action;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.surveyId;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool = this.dismissed;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackAppNoticeClosed(noticeType=");
        sbU.append(this.noticeType);
        sbU.append(", action=");
        sbU.append(this.action);
        sbU.append(", surveyId=");
        sbU.append(this.surveyId);
        sbU.append(", dismissed=");
        return outline.D(sbU, this.dismissed, ")");
    }
}
