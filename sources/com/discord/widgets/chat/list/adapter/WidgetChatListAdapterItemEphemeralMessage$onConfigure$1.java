package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import android.widget.ImageView;
import b.a.d.f;
import com.discord.utilities.uri.UriHandler;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEphemeralMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEphemeralMessage$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetChatListAdapterItemEphemeralMessage this$0;

    public WidgetChatListAdapterItemEphemeralMessage$onConfigure$1(WidgetChatListAdapterItemEphemeralMessage widgetChatListAdapterItemEphemeralMessage) {
        this.this$0 = widgetChatListAdapterItemEphemeralMessage;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        UriHandler uriHandler = UriHandler.INSTANCE;
        ImageView imageView = WidgetChatListAdapterItemEphemeralMessage.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(imageView, "binding.chatListAdapterItemIconHelp");
        Context context = imageView.getContext();
        m.checkNotNullExpressionValue(context, "binding.chatListAdapterItemIconHelp.context");
        UriHandler.handle$default(uriHandler, context, f.a.a(1500000580222L, null), false, false, null, 28, null);
    }
}
