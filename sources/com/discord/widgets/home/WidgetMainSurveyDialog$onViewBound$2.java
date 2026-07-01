package com.discord.widgets.home;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.utilities.uri.UriHandler;

/* JADX INFO: compiled from: WidgetMainSurveyDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMainSurveyDialog$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ String $surveyUrl;
    public final /* synthetic */ WidgetMainSurveyDialog this$0;

    public WidgetMainSurveyDialog$onViewBound$2(WidgetMainSurveyDialog widgetMainSurveyDialog, String str) {
        this.this$0 = widgetMainSurveyDialog;
        this.$surveyUrl = str;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        UriHandler.handle$default(UriHandler.INSTANCE, a.x(view, "button", "button.context"), this.$surveyUrl, false, false, null, 28, null);
        this.this$0.dismiss();
    }
}
