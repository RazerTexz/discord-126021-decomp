package com.discord.widgets.chat.input;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput$configureChatGuard$8 implements View$OnClickListener {
    public final /* synthetic */ WidgetChatInput this$0;

    public WidgetChatInput$configureChatGuard$8(WidgetChatInput widgetChatInput) {
        this.this$0 = widgetChatInput;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ChatInputViewModel chatInputViewModelAccess$getViewModel$p = WidgetChatInput.access$getViewModel$p(this.this$0);
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        chatInputViewModelAccess$getViewModel$p.verifyAccount(context);
    }
}
