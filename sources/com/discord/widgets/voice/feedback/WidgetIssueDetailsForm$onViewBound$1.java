package com.discord.widgets.voice.feedback;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetIssueDetailsForm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetIssueDetailsForm$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetIssueDetailsForm this$0;

    public WidgetIssueDetailsForm$onViewBound$1(WidgetIssueDetailsForm widgetIssueDetailsForm) {
        this.this$0 = widgetIssueDetailsForm;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        TextInputLayout textInputLayout = WidgetIssueDetailsForm.access$getBinding$p(this.this$0).c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.issueDetailsInput");
        WidgetIssueDetailsForm.access$getViewModel$p(this.this$0).submitForm(ViewExtensions.getTextOrEmpty(textInputLayout));
    }
}
