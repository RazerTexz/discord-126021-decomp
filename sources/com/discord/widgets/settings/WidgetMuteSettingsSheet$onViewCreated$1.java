package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetMuteSettingsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMuteSettingsSheet$onViewCreated$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetMuteSettingsSheet this$0;

    public WidgetMuteSettingsSheet$onViewCreated$1(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
        this.this$0 = widgetMuteSettingsSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        MuteSettingsSheetViewModel muteSettingsSheetViewModelAccess$getViewModel$p = WidgetMuteSettingsSheet.access$getViewModel$p(this.this$0);
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        muteSettingsSheetViewModelAccess$getViewModel$p.selectMuteDurationMs(900000L, context);
    }
}
