package com.discord.widgets.home;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.databinding.ViewDialogConfirmationBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetMainSurveyDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMainSurveyDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetMainSurveyDialog.class, "binding", "getBinding()Lcom/discord/databinding/ViewDialogConfirmationBinding;", 0)};
    public static final WidgetMainSurveyDialog$Companion Companion = new WidgetMainSurveyDialog$Companion(null);
    private static final String EXTRA_SURVEY_BODY = "extra_survey_body";
    private static final String EXTRA_SURVEY_ID = "extra_survey_id";
    private static final String EXTRA_SURVEY_TITLE = "extra_survey_title";
    private static final String EXTRA_SURVEY_URL = "extra_survey_url";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetMainSurveyDialog() {
        super(R$layout.view_dialog_confirmation);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetMainSurveyDialog$binding$2.INSTANCE, null, 2, null);
    }

    private final ViewDialogConfirmationBinding getBinding() {
        return (ViewDialogConfirmationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(EXTRA_SURVEY_URL) : null;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString(EXTRA_SURVEY_BODY) : null;
        Bundle arguments3 = getArguments();
        String string3 = arguments3 != null ? arguments3.getString(EXTRA_SURVEY_ID) : null;
        Bundle arguments4 = getArguments();
        String string4 = arguments4 != null ? arguments4.getString(EXTRA_SURVEY_TITLE) : null;
        if (!(string == null || string.length() == 0)) {
            if (!(string3 == null || string3.length() == 0)) {
                TextView textView = getBinding().d;
                m.checkNotNullExpressionValue(textView, "binding.viewDialogConfirmationHeader");
                textView.setText(string4);
                TextView textView2 = getBinding().e;
                m.checkNotNullExpressionValue(textView2, "binding.viewDialogConfirmationText");
                textView2.setText(string2);
                MaterialButton materialButton = getBinding().f2185b;
                m.checkNotNullExpressionValue(materialButton, "binding.viewDialogConfirmationCancel");
                materialButton.setText(getString(2131893288));
                getBinding().f2185b.setOnClickListener(new WidgetMainSurveyDialog$onViewBound$1(this));
                MaterialButton materialButton2 = getBinding().c;
                m.checkNotNullExpressionValue(materialButton2, "binding.viewDialogConfirmationConfirm");
                materialButton2.setText(getString(2131893499));
                getBinding().c.setOnClickListener(new WidgetMainSurveyDialog$onViewBound$2(this, string));
                AnalyticsTracker.INSTANCE.surveyViewed(string3);
                return;
            }
        }
        dismiss();
    }
}
