package com.discord.utilities.surveys;

import d0.z.d.m;

/* JADX INFO: compiled from: SurveyUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public class SurveyUtils$Survey {
    private final String noticeKey;
    private final String surveyBody;
    private final String surveyId;
    private final String surveyTitle;
    private final String surveyURL;

    public SurveyUtils$Survey(String str, String str2, String str3, String str4, String str5) {
        m.checkNotNullParameter(str, "surveyId");
        m.checkNotNullParameter(str2, "surveyURL");
        m.checkNotNullParameter(str3, "noticeKey");
        m.checkNotNullParameter(str4, "surveyBody");
        m.checkNotNullParameter(str5, "surveyTitle");
        this.surveyId = str;
        this.surveyURL = str2;
        this.noticeKey = str3;
        this.surveyBody = str4;
        this.surveyTitle = str5;
    }

    public String getNoticeKey() {
        return this.noticeKey;
    }

    public String getSurveyBody() {
        return this.surveyBody;
    }

    public String getSurveyId() {
        return this.surveyId;
    }

    public String getSurveyTitle() {
        return this.surveyTitle;
    }

    public String getSurveyURL() {
        return this.surveyURL;
    }
}
