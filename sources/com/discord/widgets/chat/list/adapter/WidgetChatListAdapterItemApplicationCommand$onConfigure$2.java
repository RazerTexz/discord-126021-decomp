package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import android.widget.TextView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemApplicationCommand.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemApplicationCommand$onConfigure$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetChatListAdapterItemApplicationCommand this$0;

    public WidgetChatListAdapterItemApplicationCommand$onConfigure$2(WidgetChatListAdapterItemApplicationCommand widgetChatListAdapterItemApplicationCommand) {
        this.this$0 = widgetChatListAdapterItemApplicationCommand;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        TextView textView = WidgetChatListAdapterItemApplicationCommand.access$getBinding$p(this.this$0).f2308b;
        m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemTextCommand");
        if (textView.getMaxLines() == 1) {
            TextView textView2 = WidgetChatListAdapterItemApplicationCommand.access$getBinding$p(this.this$0).f2308b;
            m.checkNotNullExpressionValue(textView2, "binding.chatListAdapterItemTextCommand");
            textView2.setMaxLines(Integer.MAX_VALUE);
        } else {
            TextView textView3 = WidgetChatListAdapterItemApplicationCommand.access$getBinding$p(this.this$0).f2308b;
            m.checkNotNullExpressionValue(textView3, "binding.chatListAdapterItemTextCommand");
            textView3.setMaxLines(1);
        }
    }
}
