package com.discord.api.user;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: UserSurvey.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class UserSurveyFetchResponse {
    private final UserSurvey survey;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final UserSurvey getSurvey() {
        return this.survey;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof UserSurveyFetchResponse) && m.areEqual(this.survey, ((UserSurveyFetchResponse) other).survey);
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
        StringBuilder sbU = a.U("UserSurveyFetchResponse(survey=");
        sbU.append(this.survey);
        sbU.append(")");
        return sbU.toString();
    }
}
