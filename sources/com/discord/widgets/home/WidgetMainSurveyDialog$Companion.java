package com.discord.widgets.home;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetMainSurveyDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMainSurveyDialog$Companion {
    private WidgetMainSurveyDialog$Companion() {
    }

    public final void show(FragmentManager fragmentManager, String surveyId, String surveyUrl, String surveyBody, String surveyTitle) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(surveyId, "surveyId");
        m.checkNotNullParameter(surveyUrl, "surveyUrl");
        m.checkNotNullParameter(surveyBody, "surveyBody");
        m.checkNotNullParameter(surveyTitle, "surveyTitle");
        WidgetMainSurveyDialog widgetMainSurveyDialog = new WidgetMainSurveyDialog();
        Bundle bundle = new Bundle();
        bundle.putString("extra_survey_id", surveyId);
        bundle.putString("extra_survey_url", surveyUrl);
        bundle.putString("extra_survey_body", surveyBody);
        bundle.putString("extra_survey_title", surveyTitle);
        widgetMainSurveyDialog.setArguments(bundle);
        widgetMainSurveyDialog.show(fragmentManager, "WidgetMainSurveyDialog");
    }

    public /* synthetic */ WidgetMainSurveyDialog$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
