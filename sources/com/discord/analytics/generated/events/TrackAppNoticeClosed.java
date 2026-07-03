package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackAppNoticeClosed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAppNoticeClosed implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.noticeType, trackAppNoticeClosed.noticeType) && C12238m.areEqual(this.action, trackAppNoticeClosed.action) && C12238m.areEqual(this.surveyId, trackAppNoticeClosed.surveyId) && C12238m.areEqual(this.dismissed, trackAppNoticeClosed.dismissed);
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
        StringBuilder sbM833U = C1643a.m833U("TrackAppNoticeClosed(noticeType=");
        sbM833U.append(this.noticeType);
        sbM833U.append(", action=");
        sbM833U.append(this.action);
        sbM833U.append(", surveyId=");
        sbM833U.append(this.surveyId);
        sbM833U.append(", dismissed=");
        return C1643a.m816D(sbM833U, this.dismissed, ")");
    }
}
