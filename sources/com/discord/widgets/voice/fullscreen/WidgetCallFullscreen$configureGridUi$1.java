package com.discord.widgets.voice.fullscreen;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$configureGridUi$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetCallFullscreen this$0;

    public WidgetCallFullscreen$configureGridUi$1(WidgetCallFullscreen widgetCallFullscreen) {
        this.this$0 = widgetCallFullscreen;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetCallFullscreen.access$getViewModel$p(this.this$0).onEmptyStateTapped();
    }
}
