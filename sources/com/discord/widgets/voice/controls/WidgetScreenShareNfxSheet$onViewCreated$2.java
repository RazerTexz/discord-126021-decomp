package com.discord.widgets.voice.controls;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetScreenShareNfxSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetScreenShareNfxSheet$onViewCreated$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetScreenShareNfxSheet this$0;

    public WidgetScreenShareNfxSheet$onViewCreated$2(WidgetScreenShareNfxSheet widgetScreenShareNfxSheet) {
        this.this$0 = widgetScreenShareNfxSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
        WidgetScreenShareNfxSheet.access$maybeNavigateToVoiceBottomSheet(this.this$0);
    }
}
