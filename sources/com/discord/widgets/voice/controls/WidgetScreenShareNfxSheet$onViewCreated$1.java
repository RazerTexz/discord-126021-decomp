package com.discord.widgets.voice.controls;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.voice.stream.StreamNavigator;

/* JADX INFO: compiled from: WidgetScreenShareNfxSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetScreenShareNfxSheet$onViewCreated$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetScreenShareNfxSheet this$0;

    public WidgetScreenShareNfxSheet$onViewCreated$1(WidgetScreenShareNfxSheet widgetScreenShareNfxSheet) {
        this.this$0 = widgetScreenShareNfxSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StreamNavigator.requestStartStream(this.this$0);
    }
}
