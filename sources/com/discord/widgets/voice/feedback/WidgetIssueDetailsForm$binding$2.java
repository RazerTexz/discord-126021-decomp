package com.discord.widgets.voice.feedback;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetIssueDetailsFormBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetIssueDetailsForm.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetIssueDetailsForm$binding$2 extends C12236k implements Function1<View, WidgetIssueDetailsFormBinding> {
    public static final WidgetIssueDetailsForm$binding$2 INSTANCE = new WidgetIssueDetailsForm$binding$2();

    public WidgetIssueDetailsForm$binding$2() {
        super(1, WidgetIssueDetailsFormBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetIssueDetailsFormBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetIssueDetailsFormBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.issue_details_cx_prompt;
        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.issue_details_cx_prompt);
        if (linkifiedTextView != null) {
            i = C5419R.id.issue_details_input;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.issue_details_input);
            if (textInputLayout != null) {
                i = C5419R.id.issue_details_submit_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.issue_details_submit_button);
                if (materialButton != null) {
                    return new WidgetIssueDetailsFormBinding((NestedScrollView) view, linkifiedTextView, textInputLayout, materialButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
