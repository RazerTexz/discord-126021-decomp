package com.discord.widgets.mobile_reports;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.report.ReportNodeBottomButton;
import com.discord.databinding.ViewMobileReportsBottomButtonBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.widgets.mobile_reports.MobileReportsViewModel;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MobileReportsBottomButton.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MobileReportsBottomButton extends LinearLayout {
    private final ViewMobileReportsBottomButtonBinding binding;

    public MobileReportsBottomButton(Context context) {
        this(context, null, 0, 6, null);
    }

    public MobileReportsBottomButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ MobileReportsBottomButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setup(final ReportNodeBottomButton bottomButton, MobileReportsViewModel.SubmitState submitState, final Function1<? super ReportNodeBottomButton, Unit> handleButtonPress) {
        this.binding.c.setOnClickListener(null);
        this.binding.f2202b.setOnClickListener(null);
        LinkifiedTextView linkifiedTextView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.reportNodeBottomButtonDescription");
        boolean z2 = bottomButton instanceof ReportNodeBottomButton.Submit;
        linkifiedTextView.setVisibility(z2 ? 0 : 8);
        MaterialButton materialButton = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.reportNodeBottomButtonCancel");
        boolean z3 = bottomButton instanceof ReportNodeBottomButton.Cancel;
        materialButton.setVisibility(z3 ? 0 : 8);
        LoadingButton loadingButton = this.binding.f2202b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.reportNodeBottomButton");
        MaterialButton materialButton2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.reportNodeBottomButtonCancel");
        loadingButton.setVisibility((materialButton2.getVisibility() == 0) ^ true ? 0 : 8);
        boolean z4 = submitState instanceof MobileReportsViewModel.SubmitState.Loading;
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.reportNodeBottomButtonErrorText");
        textView.setVisibility(submitState instanceof MobileReportsViewModel.SubmitState.Error ? 0 : 8);
        this.binding.f2202b.setIsLoading(z4);
        LoadingButton loadingButton2 = this.binding.f2202b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton2, "binding.reportNodeBottomButton");
        loadingButton2.setEnabled(!z4);
        if (z2) {
            LinkifiedTextView linkifiedTextView2 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.reportNodeBottomButtonDescription");
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            linkifiedTextView2.setText(FormatUtils.b(context, R.string.mobile_reports_submit_info_text, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null));
            this.binding.f2202b.setText(getContext().getString(R.string.mobile_reports_submit_report));
            this.binding.f2202b.setBackgroundColor(ColorCompat.getColor(getContext(), R.color.status_red));
            this.binding.f2202b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.mobile_reports.MobileReportsBottomButton.setup.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1 function1 = handleButtonPress;
                    if (function1 != null) {
                    }
                }
            });
            return;
        }
        if (bottomButton instanceof ReportNodeBottomButton.Done) {
            this.binding.f2202b.setText(getContext().getString(R.string.done));
            this.binding.f2202b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.mobile_reports.MobileReportsBottomButton.setup.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1 function1 = handleButtonPress;
                    if (function1 != null) {
                    }
                }
            });
        } else if (bottomButton instanceof ReportNodeBottomButton.Next) {
            this.binding.f2202b.setText(getContext().getString(R.string.next));
            this.binding.f2202b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.mobile_reports.MobileReportsBottomButton.setup.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1 function1 = handleButtonPress;
                    if (function1 != null) {
                    }
                }
            });
        } else if (z3) {
            this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.mobile_reports.MobileReportsBottomButton.setup.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1 function1 = handleButtonPress;
                    if (function1 != null) {
                    }
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileReportsBottomButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_mobile_reports_bottom_button, this);
        int i2 = R.id.report_node_bottom_button;
        LoadingButton loadingButton = (LoadingButton) findViewById(R.id.report_node_bottom_button);
        if (loadingButton != null) {
            i2 = R.id.report_node_bottom_button_cancel;
            MaterialButton materialButton = (MaterialButton) findViewById(R.id.report_node_bottom_button_cancel);
            if (materialButton != null) {
                i2 = R.id.report_node_bottom_button_description;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) findViewById(R.id.report_node_bottom_button_description);
                if (linkifiedTextView != null) {
                    i2 = R.id.report_node_bottom_button_error_text;
                    TextView textView = (TextView) findViewById(R.id.report_node_bottom_button_error_text);
                    if (textView != null) {
                        ViewMobileReportsBottomButtonBinding viewMobileReportsBottomButtonBinding = new ViewMobileReportsBottomButtonBinding(this, loadingButton, materialButton, linkifiedTextView, textView);
                        Intrinsics3.checkNotNullExpressionValue(viewMobileReportsBottomButtonBinding, "ViewMobileReportsBottomB…ater.from(context), this)");
                        this.binding = viewMobileReportsBottomButtonBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }
}
