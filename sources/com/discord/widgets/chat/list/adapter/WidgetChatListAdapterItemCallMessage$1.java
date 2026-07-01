package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnAttachStateChangeListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemCallMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemCallMessage$1 implements View$OnAttachStateChangeListener {
    public final /* synthetic */ WidgetChatListAdapterItemCallMessage this$0;

    public WidgetChatListAdapterItemCallMessage$1(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage) {
        this.this$0 = widgetChatListAdapterItemCallMessage;
    }

    @Override // android.view.View$OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v) {
        m.checkNotNullParameter(v, "v");
        WidgetChatListAdapterItemCallMessage.access$resetCurrentChatListEntry(this.this$0);
    }

    @Override // android.view.View$OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v) {
        m.checkNotNullParameter(v, "v");
        WidgetChatListAdapterItemCallMessage.access$clearSubscriptions(this.this$0);
    }
}
