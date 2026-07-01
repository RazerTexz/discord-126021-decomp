package com.discord.widgets.playstation;

import android.app.Dialog;
import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetPlaystationIntegrationUpsellBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPlaystationIntegrationUpsellBottomSheet$onViewCreated$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetPlaystationIntegrationUpsellBottomSheet this$0;

    public WidgetPlaystationIntegrationUpsellBottomSheet$onViewCreated$3(WidgetPlaystationIntegrationUpsellBottomSheet widgetPlaystationIntegrationUpsellBottomSheet) {
        this.this$0 = widgetPlaystationIntegrationUpsellBottomSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Dialog dialog = this.this$0.getDialog();
        m.checkNotNull(dialog);
        dialog.cancel();
    }
}
