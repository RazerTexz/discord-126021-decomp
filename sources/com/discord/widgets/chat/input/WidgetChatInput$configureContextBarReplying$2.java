package com.discord.widgets.chat.input;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput$configureContextBarReplying$2 implements View$OnClickListener {
    public final /* synthetic */ ChatInputViewModel$ViewState$Loaded$PendingReplyState$Replying $model;
    public final /* synthetic */ WidgetChatInput this$0;

    public WidgetChatInput$configureContextBarReplying$2(WidgetChatInput widgetChatInput, ChatInputViewModel$ViewState$Loaded$PendingReplyState$Replying chatInputViewModel$ViewState$Loaded$PendingReplyState$Replying) {
        this.this$0 = widgetChatInput;
        this.$model = chatInputViewModel$ViewState$Loaded$PendingReplyState$Replying;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChatInput.access$getViewModel$p(this.this$0).jumpToMessageReference(this.$model.getMessageReference());
    }
}
