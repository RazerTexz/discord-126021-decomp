package com.discord.widgets.voice.feedback;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.discord.R$id;
import com.discord.databinding.WidgetIssueDetailsFormBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetIssueDetailsForm.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetIssueDetailsForm$binding$2 extends k implements Function1<View, WidgetIssueDetailsFormBinding> {
    public static final WidgetIssueDetailsForm$binding$2 INSTANCE = new WidgetIssueDetailsForm$binding$2();

    public WidgetIssueDetailsForm$binding$2() {
        super(1, WidgetIssueDetailsFormBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetIssueDetailsFormBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetIssueDetailsFormBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetIssueDetailsFormBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.issue_details_cx_prompt;
        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.issue_details_cx_prompt);
        if (linkifiedTextView != null) {
            i = R$id.issue_details_input;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.issue_details_input);
            if (textInputLayout != null) {
                i = R$id.issue_details_submit_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.issue_details_submit_button);
                if (materialButton != null) {
                    return new WidgetIssueDetailsFormBinding((NestedScrollView) view, linkifiedTextView, textInputLayout, materialButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
