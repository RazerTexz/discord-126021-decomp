package com.discord.widgets.voice.fullscreen;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreen$configureActionBar$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetCallPreviewFullscreen this$0;

    public WidgetCallPreviewFullscreen$configureActionBar$1(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        this.this$0 = widgetCallPreviewFullscreen;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetCallPreviewFullscreen.finishActivity$default(this.this$0, true, false, 2, null);
    }
}
