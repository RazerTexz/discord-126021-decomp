package com.discord.widgets.voice.fullscreen;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreen$configureActionBar$3$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetCallPreviewFullscreen$configureActionBar$3 this$0;

    public WidgetCallPreviewFullscreen$configureActionBar$3$1(WidgetCallPreviewFullscreen$configureActionBar$3 widgetCallPreviewFullscreen$configureActionBar$3) {
        this.this$0 = widgetCallPreviewFullscreen$configureActionBar$3;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetCallPreviewFullscreen.access$transitionActivity(this.this$0.this$0);
        WidgetCallPreviewFullscreen.access$getViewModel$p(this.this$0.this$0).onTextInVoiceTapped();
    }
}
