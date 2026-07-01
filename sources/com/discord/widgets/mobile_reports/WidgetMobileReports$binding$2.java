package com.discord.widgets.mobile_reports;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetMobileReportsBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetMobileReports.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetMobileReports$binding$2 extends k implements Function1<View, WidgetMobileReportsBinding> {
    public static final WidgetMobileReports$binding$2 INSTANCE = new WidgetMobileReports$binding$2();

    public WidgetMobileReports$binding$2() {
        super(1, WidgetMobileReportsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetMobileReportsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetMobileReportsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetMobileReportsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.menu_reports_node_view_holder;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.menu_reports_node_view_holder);
        if (frameLayout != null) {
            i = R$id.mobile_reports_progress_bar;
            ProgressBar progressBar = (ProgressBar) view.findViewById(R$id.mobile_reports_progress_bar);
            if (progressBar != null) {
                return new WidgetMobileReportsBinding((CoordinatorLayout) view, frameLayout, progressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
