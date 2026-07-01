package com.discord.widgets.bugreports;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import b.a.y.b0;
import b.a.y.b0$a;
import com.discord.app.AppFragment;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetBugReport$onViewBound$6 implements View$OnClickListener {
    public final /* synthetic */ WidgetBugReport this$0;

    public WidgetBugReport$onViewBound$6(WidgetBugReport widgetBugReport) {
        this.this$0 = widgetBugReport;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        AppFragment.hideKeyboard$default(this.this$0, null, 1, null);
        b0$a b0_a = b0.k;
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        String string = this.this$0.getString(2131887316);
        m.checkNotNullExpressionValue(string, "getString(R.string.bug_report_priority)");
        b0$a.b(b0_a, childFragmentManager, string, this.this$0.getItems(), false, new WidgetBugReport$onViewBound$6$1(this), 8);
    }
}
