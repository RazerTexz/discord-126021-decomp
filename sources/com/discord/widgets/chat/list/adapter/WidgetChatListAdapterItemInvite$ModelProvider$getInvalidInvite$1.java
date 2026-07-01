package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import d0.z.d.m;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetChatListAdapterItemInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemInvite$ModelProvider$getInvalidInvite$1<T1, T2, R> implements Func2<Long, User, WidgetChatListAdapterItemInvite$Model> {
    public static final WidgetChatListAdapterItemInvite$ModelProvider$getInvalidInvite$1 INSTANCE = new WidgetChatListAdapterItemInvite$ModelProvider$getInvalidInvite$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemInvite$Model call(Long l, User user) {
        return call2(l, user);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListAdapterItemInvite$Model call2(Long l, User user) {
        m.checkNotNullExpressionValue(l, "meId");
        return new WidgetChatListAdapterItemInvite$Model$Invalid(user, l.longValue(), null);
    }
}
