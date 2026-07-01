package com.discord.utilities.surveys;

import androidx.core.app.NotificationCompat;
import com.discord.api.user.UserSurvey;
import j0.k.b;

/* JADX INFO: compiled from: SurveyUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SurveyUtils$getSurveyToShow$1<T, R> implements b<UserSurvey, SurveyUtils$Survey> {
    public static final SurveyUtils$getSurveyToShow$1 INSTANCE = new SurveyUtils$getSurveyToShow$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ SurveyUtils$Survey call(UserSurvey userSurvey) {
        return call2(userSurvey);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final SurveyUtils$Survey call2(UserSurvey userSurvey) {
        if (userSurvey != null) {
            return new SurveyUtils$Survey(userSurvey.getKey(), userSurvey.getUrl(), userSurvey.getKey(), userSurvey.getPrompt(), userSurvey.getCta());
        }
        return null;
    }
}
