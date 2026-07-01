package com.discord.widgets.contact_sync;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.views.CheckedSetting;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSync$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetContactSync this$0;

    public WidgetContactSync$configureUI$3(WidgetContactSync widgetContactSync) {
        this.this$0 = widgetContactSync;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        CheckedSetting checkedSetting = WidgetContactSync.access$getBinding$p(this.this$0).e.e.c;
        m.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncLandi…ontactSyncDiscoveryToggle");
        boolean zIsChecked = checkedSetting.isChecked();
        WidgetContactSync.access$getViewModel$p(this.this$0).onPermissionsToggle(!zIsChecked, !zIsChecked);
    }
}
