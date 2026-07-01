package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.a.a0.c;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGift$configureResolvedUI$$inlined$apply$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetChatListAdapterItemGift$Model$Resolved $model$inlined;
    public final /* synthetic */ WidgetChatListAdapterItemGift this$0;

    public WidgetChatListAdapterItemGift$configureResolvedUI$$inlined$apply$lambda$1(WidgetChatListAdapterItemGift widgetChatListAdapterItemGift, WidgetChatListAdapterItemGift$Model$Resolved widgetChatListAdapterItemGift$Model$Resolved) {
        this.this$0 = widgetChatListAdapterItemGift;
        this.$model$inlined = widgetChatListAdapterItemGift$Model$Resolved;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        c.k.a(this.$model$inlined.getGift().getCode(), "Embed", WidgetChatListAdapterItemGift.access$getItem$p(this.this$0).getChannelId());
    }
}
