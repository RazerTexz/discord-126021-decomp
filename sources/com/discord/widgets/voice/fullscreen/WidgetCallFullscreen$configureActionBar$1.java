package com.discord.widgets.voice.fullscreen;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$configureActionBar$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetCallFullscreenViewModel$ViewState$Valid $viewState;
    public final /* synthetic */ WidgetCallFullscreen this$0;

    public WidgetCallFullscreen$configureActionBar$1(WidgetCallFullscreen widgetCallFullscreen, WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid) {
        this.this$0 = widgetCallFullscreen;
        this.$viewState = widgetCallFullscreenViewModel$ViewState$Valid;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetCallFullscreen.access$finishActivity(this.this$0, false, this.$viewState.isTextInVoiceEnabled());
    }
}
