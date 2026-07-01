package com.discord.widgets.settings.account;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetDisableDeleteAccountDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDisableDeleteAccountDialog$onViewBound$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetDisableDeleteAccountDialog$Mode $mode;
    public final /* synthetic */ WidgetDisableDeleteAccountDialog this$0;

    public WidgetDisableDeleteAccountDialog$onViewBound$4(WidgetDisableDeleteAccountDialog widgetDisableDeleteAccountDialog, WidgetDisableDeleteAccountDialog$Mode widgetDisableDeleteAccountDialog$Mode) {
        this.this$0 = widgetDisableDeleteAccountDialog;
        this.$mode = widgetDisableDeleteAccountDialog$Mode;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetDisableDeleteAccountDialog.access$onDisableClicked(this.this$0, this.$mode);
    }
}
