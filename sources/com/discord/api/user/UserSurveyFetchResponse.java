package com.discord.api.user;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
            return (other instanceof UserSurveyFetchResponse) && C12238m.areEqual(this.survey, ((UserSurveyFetchResponse) other).survey);
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
        StringBuilder sbM833U = C1643a.m833U("UserSurveyFetchResponse(survey=");
        sbM833U.append(this.survey);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
