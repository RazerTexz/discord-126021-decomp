package com.discord.widgets.mobile_reports;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.report.ReportNodeBottomButton;
import com.discord.api.report.ReportNodeBottomButton$Cancel;
import com.discord.api.report.ReportNodeBottomButton$Done;
import com.discord.api.report.ReportNodeBottomButton$Next;
import com.discord.api.report.ReportNodeBottomButton$Submit;
import com.discord.databinding.ViewMobileReportsBottomButtonBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
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

    public final void setup(ReportNodeBottomButton bottomButton, MobileReportsViewModel$SubmitState submitState, Function1<? super ReportNodeBottomButton, Unit> handleButtonPress) {
        this.binding.c.setOnClickListener(null);
        this.binding.f2202b.setOnClickListener(null);
        LinkifiedTextView linkifiedTextView = this.binding.d;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.reportNodeBottomButtonDescription");
        boolean z2 = bottomButton instanceof ReportNodeBottomButton$Submit;
        linkifiedTextView.setVisibility(z2 ? 0 : 8);
        MaterialButton materialButton = this.binding.c;
        m.checkNotNullExpressionValue(materialButton, "binding.reportNodeBottomButtonCancel");
        boolean z3 = bottomButton instanceof ReportNodeBottomButton$Cancel;
        materialButton.setVisibility(z3 ? 0 : 8);
        LoadingButton loadingButton = this.binding.f2202b;
        m.checkNotNullExpressionValue(loadingButton, "binding.reportNodeBottomButton");
        MaterialButton materialButton2 = this.binding.c;
        m.checkNotNullExpressionValue(materialButton2, "binding.reportNodeBottomButtonCancel");
        loadingButton.setVisibility((materialButton2.getVisibility() == 0) ^ true ? 0 : 8);
        boolean z4 = submitState instanceof MobileReportsViewModel$SubmitState$Loading;
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.reportNodeBottomButtonErrorText");
        textView.setVisibility(submitState instanceof MobileReportsViewModel$SubmitState$Error ? 0 : 8);
        this.binding.f2202b.setIsLoading(z4);
        LoadingButton loadingButton2 = this.binding.f2202b;
        m.checkNotNullExpressionValue(loadingButton2, "binding.reportNodeBottomButton");
        loadingButton2.setEnabled(!z4);
        if (z2) {
            LinkifiedTextView linkifiedTextView2 = this.binding.d;
            m.checkNotNullExpressionValue(linkifiedTextView2, "binding.reportNodeBottomButtonDescription");
            Context context = getContext();
            m.checkNotNullExpressionValue(context, "context");
            linkifiedTextView2.setText(b.h(context, 2131893044, new Object[0], null, 4));
            this.binding.f2202b.setText(getContext().getString(2131893045));
            this.binding.f2202b.setBackgroundColor(ColorCompat.getColor(getContext(), 2131100368));
            this.binding.f2202b.setOnClickListener(new MobileReportsBottomButton$setup$1(handleButtonPress, bottomButton));
            return;
        }
        if (bottomButton instanceof ReportNodeBottomButton$Done) {
            this.binding.f2202b.setText(getContext().getString(2131888587));
            this.binding.f2202b.setOnClickListener(new MobileReportsBottomButton$setup$2(handleButtonPress, bottomButton));
        } else if (bottomButton instanceof ReportNodeBottomButton$Next) {
            this.binding.f2202b.setText(getContext().getString(2131893214));
            this.binding.f2202b.setOnClickListener(new MobileReportsBottomButton$setup$3(handleButtonPress, bottomButton));
        } else if (z3) {
            this.binding.c.setOnClickListener(new MobileReportsBottomButton$setup$4(handleButtonPress, bottomButton));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileReportsBottomButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R$layout.view_mobile_reports_bottom_button, this);
        int i2 = R$id.report_node_bottom_button;
        LoadingButton loadingButton = (LoadingButton) findViewById(R$id.report_node_bottom_button);
        if (loadingButton != null) {
            i2 = R$id.report_node_bottom_button_cancel;
            MaterialButton materialButton = (MaterialButton) findViewById(R$id.report_node_bottom_button_cancel);
            if (materialButton != null) {
                i2 = R$id.report_node_bottom_button_description;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) findViewById(R$id.report_node_bottom_button_description);
                if (linkifiedTextView != null) {
                    i2 = R$id.report_node_bottom_button_error_text;
                    TextView textView = (TextView) findViewById(R$id.report_node_bottom_button_error_text);
                    if (textView != null) {
                        ViewMobileReportsBottomButtonBinding viewMobileReportsBottomButtonBinding = new ViewMobileReportsBottomButtonBinding(this, loadingButton, materialButton, linkifiedTextView, textView);
                        m.checkNotNullExpressionValue(viewMobileReportsBottomButtonBinding, "ViewMobileReportsBottomB…ater.from(context), this)");
                        this.binding = viewMobileReportsBottomButtonBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }
}
