package com.discord.widgets.chat.list.adapter;

import android.view.View;
import com.discord.models.message.Message;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.MessageEntry;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildInviteReminder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildInviteReminder$onConfigure$2 extends o implements Function1<View, Unit> {
    public final /* synthetic */ ChatListEntry $data;
    public final /* synthetic */ WidgetChatListAdapterItemGuildInviteReminder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGuildInviteReminder$onConfigure$2(WidgetChatListAdapterItemGuildInviteReminder widgetChatListAdapterItemGuildInviteReminder, ChatListEntry chatListEntry) {
        super(1);
        this.this$0 = widgetChatListAdapterItemGuildInviteReminder;
        this.$data = chatListEntry;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetChatListAdapter$EventHandler eventHandler = WidgetChatListAdapterItemGuildInviteReminder.access$getAdapter$p(this.this$0).getEventHandler();
        Message message = ((MessageEntry) this.$data).getMessage();
        View view2 = this.this$0.itemView;
        m.checkNotNullExpressionValue(view2, "itemView");
        String string = view2.getContext().getString(2131896236);
        m.checkNotNullExpressionValue(string, "itemView.context.getStri…ssage_invite_users_owner)");
        eventHandler.onMessageLongClicked(message, string, false);
    }
}
