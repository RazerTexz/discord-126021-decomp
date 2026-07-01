package com.discord.widgets.chat.list.adapter;

import b.d.b.a.a;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGift$Companion {
    private WidgetChatListAdapterItemGift$Companion() {
    }

    public static final /* synthetic */ String access$getDiscordStoreURL(WidgetChatListAdapterItemGift$Companion widgetChatListAdapterItemGift$Companion, long j) {
        return widgetChatListAdapterItemGift$Companion.getDiscordStoreURL(j);
    }

    private final String getDiscordStoreURL(long skuId) {
        return a.t("https://discord.com/store/skus/", skuId);
    }

    public /* synthetic */ WidgetChatListAdapterItemGift$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
