package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGift$ModelProvider$getInvalidGift$1<T1, T2, R> implements Func2<Long, Long, WidgetChatListAdapterItemGift$Model> {
    public static final WidgetChatListAdapterItemGift$ModelProvider$getInvalidGift$1 INSTANCE = new WidgetChatListAdapterItemGift$ModelProvider$getInvalidGift$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemGift$Model call(Long l, Long l2) {
        return call2(l, l2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListAdapterItemGift$Model call2(Long l, Long l2) {
        m.checkNotNullExpressionValue(l2, "meId");
        return new WidgetChatListAdapterItemGift$Model$Invalid(l, l2.longValue());
    }
}
