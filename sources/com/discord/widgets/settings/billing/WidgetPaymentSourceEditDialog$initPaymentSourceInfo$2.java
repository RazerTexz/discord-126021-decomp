package com.discord.widgets.settings.billing;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import b.a.k.b;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.notice.WidgetNoticeDialog$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPaymentSourceEditDialog$initPaymentSourceInfo$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetPaymentSourceEditDialog this$0;

    public WidgetPaymentSourceEditDialog$initPaymentSourceInfo$2(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog) {
        this.this$0 = widgetPaymentSourceEditDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetNoticeDialog$Companion widgetNoticeDialog$Companion = WidgetNoticeDialog.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetNoticeDialog$Companion.show$default(widgetNoticeDialog$Companion, parentFragmentManager, b.k(this.this$0, 2131893706, new Object[0], null, 4), b.k(this.this$0, 2131893707, new Object[0], null, 4), b.k(this.this$0, 2131893499, new Object[0], null, 4), "", null, null, null, null, null, null, null, 0, null, 16352, null);
    }
}
