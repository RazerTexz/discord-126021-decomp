package com.discord.widgets.tos;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetTosReportViolationBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.tos.WidgetTosReportViolation$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetTosReportViolation.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetTosReportViolation3 extends FunctionReferenceImpl implements Function1<View, WidgetTosReportViolationBinding> {
    public static final WidgetTosReportViolation3 INSTANCE = new WidgetTosReportViolation3();

    public WidgetTosReportViolation3() {
        super(1, WidgetTosReportViolationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetTosReportViolationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetTosReportViolationBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.report_button;
        LoadingButton loadingButton = (LoadingButton) view.findViewById(R.id.report_button);
        if (loadingButton != null) {
            i = R.id.report_header;
            TextView textView = (TextView) view.findViewById(R.id.report_header);
            if (textView != null) {
                i = R.id.report_reasons_container;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.report_reasons_container);
                if (linearLayout != null) {
                    i = R.id.report_reasons_header;
                    TextView textView2 = (TextView) view.findViewById(R.id.report_reasons_header);
                    if (textView2 != null) {
                        i = R.id.report_reasons_loading;
                        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.report_reasons_loading);
                        if (progressBar != null) {
                            i = R.id.report_tooltip;
                            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.report_tooltip);
                            if (linkifiedTextView != null) {
                                return new WidgetTosReportViolationBinding((CoordinatorLayout) view, loadingButton, textView, linearLayout, textView2, progressBar, linkifiedTextView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
