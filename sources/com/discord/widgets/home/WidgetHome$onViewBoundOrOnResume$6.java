package com.discord.widgets.home;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.surveys.SurveyUtils$Survey;
import com.discord.utilities.surveys.SurveyUtils$Survey$None;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome$onViewBoundOrOnResume$6<T, R> implements b<SurveyUtils$Survey, Boolean> {
    public static final WidgetHome$onViewBoundOrOnResume$6 INSTANCE = new WidgetHome$onViewBoundOrOnResume$6();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(SurveyUtils$Survey surveyUtils$Survey) {
        return call2(surveyUtils$Survey);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(SurveyUtils$Survey surveyUtils$Survey) {
        return Boolean.valueOf(!m.areEqual(surveyUtils$Survey, SurveyUtils$Survey$None.INSTANCE));
    }
}
