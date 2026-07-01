package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackSurveySubmitted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSurveySubmitted implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence surveyType = null;
    private final CharSequence question1 = null;
    private final CharSequence answer1 = null;
    private final Boolean isOther1 = null;
    private final CharSequence question2 = null;
    private final CharSequence answer2 = null;
    private final Boolean isOther2 = null;
    private final transient String analyticsSchemaTypeName = "survey_submitted";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSurveySubmitted)) {
            return false;
        }
        TrackSurveySubmitted trackSurveySubmitted = (TrackSurveySubmitted) other;
        return Intrinsics3.areEqual(this.surveyType, trackSurveySubmitted.surveyType) && Intrinsics3.areEqual(this.question1, trackSurveySubmitted.question1) && Intrinsics3.areEqual(this.answer1, trackSurveySubmitted.answer1) && Intrinsics3.areEqual(this.isOther1, trackSurveySubmitted.isOther1) && Intrinsics3.areEqual(this.question2, trackSurveySubmitted.question2) && Intrinsics3.areEqual(this.answer2, trackSurveySubmitted.answer2) && Intrinsics3.areEqual(this.isOther2, trackSurveySubmitted.isOther2);
    }

    public int hashCode() {
        CharSequence charSequence = this.surveyType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.question1;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.answer1;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool = this.isOther1;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.question2;
        int iHashCode5 = (iHashCode4 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.answer2;
        int iHashCode6 = (iHashCode5 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Boolean bool2 = this.isOther2;
        return iHashCode6 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSurveySubmitted(surveyType=");
        sbU.append(this.surveyType);
        sbU.append(", question1=");
        sbU.append(this.question1);
        sbU.append(", answer1=");
        sbU.append(this.answer1);
        sbU.append(", isOther1=");
        sbU.append(this.isOther1);
        sbU.append(", question2=");
        sbU.append(this.question2);
        sbU.append(", answer2=");
        sbU.append(this.answer2);
        sbU.append(", isOther2=");
        return outline.D(sbU, this.isOther2, ")");
    }
}
