package com.discord.widgets.chat.input;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput$configureContextBarReplying$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetChatInput this$0;

    public WidgetChatInput$configureContextBarReplying$4(WidgetChatInput widgetChatInput) {
        this.this$0 = widgetChatInput;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChatInput.access$getViewModel$p(this.this$0).togglePendingReplyShouldMention();
    }
}
