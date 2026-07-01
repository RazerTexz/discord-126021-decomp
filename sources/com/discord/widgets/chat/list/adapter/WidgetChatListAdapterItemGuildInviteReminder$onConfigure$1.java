package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare$Companion;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildInviteReminder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildInviteReminder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetChatListAdapterItemGuildInviteReminder this$0;

    public WidgetChatListAdapterItemGuildInviteReminder$onConfigure$1(WidgetChatListAdapterItemGuildInviteReminder widgetChatListAdapterItemGuildInviteReminder) {
        this.this$0 = widgetChatListAdapterItemGuildInviteReminder;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildInviteShare$Companion.launch$default(WidgetGuildInviteShare.Companion, a.x(view, "view", "view.context"), WidgetChatListAdapterItemGuildInviteReminder.access$getAdapter$p(this.this$0).getFragmentManager(), WidgetChatListAdapterItemGuildInviteReminder.access$getAdapter$p(this.this$0).getData().getGuildId(), null, false, null, null, "Welcome Message", 120, null);
    }
}
