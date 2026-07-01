package com.discord.widgets.home;

import com.discord.utilities.surveys.SurveyUtils$Survey;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetHome$onViewBoundOrOnResume$7 extends k implements Function1<SurveyUtils$Survey, Unit> {
    public WidgetHome$onViewBoundOrOnResume$7(WidgetHome widgetHome) {
        super(1, widgetHome, WidgetHome.class, "showSurvey", "showSurvey(Lcom/discord/utilities/surveys/SurveyUtils$Survey;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SurveyUtils$Survey surveyUtils$Survey) {
        invoke2(surveyUtils$Survey);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SurveyUtils$Survey surveyUtils$Survey) {
        m.checkNotNullParameter(surveyUtils$Survey, "p1");
        WidgetHome.access$showSurvey((WidgetHome) this.receiver, surveyUtils$Survey);
    }
}
