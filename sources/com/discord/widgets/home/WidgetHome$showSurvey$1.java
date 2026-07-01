package com.discord.widgets.home;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.surveys.SurveyUtils$Survey;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome$showSurvey$1 extends o implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ SurveyUtils$Survey $survey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHome$showSurvey$1(SurveyUtils$Survey surveyUtils$Survey) {
        super(1);
        this.$survey = surveyUtils$Survey;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        m.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        WidgetMainSurveyDialog$Companion widgetMainSurveyDialog$Companion = WidgetMainSurveyDialog.Companion;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        m.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        widgetMainSurveyDialog$Companion.show(supportFragmentManager, this.$survey.getSurveyId(), this.$survey.getSurveyURL(), this.$survey.getSurveyBody(), this.$survey.getSurveyTitle());
        StoreNotices.markSeen$default(StoreStream.Companion.getNotices(), this.$survey.getNoticeKey(), 0L, 2, null);
        return true;
    }
}
