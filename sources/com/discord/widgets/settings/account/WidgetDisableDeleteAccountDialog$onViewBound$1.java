package com.discord.widgets.settings.account;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetDisableDeleteAccountDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDisableDeleteAccountDialog$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetDisableDeleteAccountDialog this$0;

    public WidgetDisableDeleteAccountDialog$onViewBound$1(WidgetDisableDeleteAccountDialog widgetDisableDeleteAccountDialog) {
        this.this$0 = widgetDisableDeleteAccountDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
    }
}
