package com.discord.widgets.channels.threads.browser;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.views.CheckedSetting;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetThreadBrowserFilterSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserFilterSheet$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetThreadBrowserFilterSheet this$0;

    public WidgetThreadBrowserFilterSheet$configureUI$1(WidgetThreadBrowserFilterSheet widgetThreadBrowserFilterSheet) {
        this.this$0 = widgetThreadBrowserFilterSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetThreadBrowserFilterSheet.access$getBinding$p(this.this$0).f2671b.toggle();
        WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModelAccess$getViewModel$p = WidgetThreadBrowserFilterSheet.access$getViewModel$p(this.this$0);
        CheckedSetting checkedSetting = WidgetThreadBrowserFilterSheet.access$getBinding$p(this.this$0).f2671b;
        m.checkNotNullExpressionValue(checkedSetting, "binding.threadBrowserModeratorView");
        widgetThreadBrowserArchivedViewModelAccess$getViewModel$p.onModeratorModeChanged(checkedSetting.isChecked());
    }
}
