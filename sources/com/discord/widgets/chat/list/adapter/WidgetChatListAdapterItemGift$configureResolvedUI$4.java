package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.uri.UriHandler;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGift$configureResolvedUI$4 implements View$OnClickListener {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ WidgetChatListAdapterItemGift$Model$Resolved $model;

    public WidgetChatListAdapterItemGift$configureResolvedUI$4(Context context, WidgetChatListAdapterItemGift$Model$Resolved widgetChatListAdapterItemGift$Model$Resolved) {
        this.$context = context;
        this.$model = widgetChatListAdapterItemGift$Model$Resolved;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        UriHandler uriHandler = UriHandler.INSTANCE;
        Context context = this.$context;
        m.checkNotNullExpressionValue(context, "context");
        UriHandler.handle$default(uriHandler, context, WidgetChatListAdapterItemGift$Companion.access$getDiscordStoreURL(WidgetChatListAdapterItemGift.Companion, this.$model.getGift().getSkuId()), false, false, null, 28, null);
    }
}
