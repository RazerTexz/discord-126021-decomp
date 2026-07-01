package com.discord.api.user;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.api.user.UserSurveyFetchResponse, reason: use source file name */
/* JADX INFO: compiled from: UserSurvey.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class UserSurvey3 {
    private final UserSurvey survey;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final UserSurvey getSurvey() {
        return this.survey;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof UserSurvey3) && Intrinsics3.areEqual(this.survey, ((UserSurvey3) other).survey);
        }
        return true;
    }

    public int hashCode() {
        UserSurvey userSurvey = this.survey;
        if (userSurvey != null) {
            return userSurvey.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("UserSurveyFetchResponse(survey=");
        sbU.append(this.survey);
        sbU.append(")");
        return sbU.toString();
    }
}
