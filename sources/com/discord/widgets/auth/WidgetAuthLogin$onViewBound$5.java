package com.discord.widgets.auth;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.notice.WidgetNoticeDialog$Builder;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLogin$onViewBound$5 implements View$OnClickListener {
    public final /* synthetic */ WidgetAuthLogin this$0;

    public WidgetAuthLogin$onViewBound$5(WidgetAuthLogin widgetAuthLogin) {
        this.this$0 = widgetAuthLogin;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetNoticeDialog$Builder negativeButton$default = WidgetNoticeDialog$Builder.setNegativeButton$default(new WidgetNoticeDialog$Builder(this.this$0.requireContext()).setTitle(2131893650).setMessage(2131893651).setPositiveButton(2131893652, WidgetAuthLogin$onViewBound$5$1.INSTANCE), 2131887437, (Function1) null, 2, (Object) null);
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        negativeButton$default.show(parentFragmentManager);
    }
}
