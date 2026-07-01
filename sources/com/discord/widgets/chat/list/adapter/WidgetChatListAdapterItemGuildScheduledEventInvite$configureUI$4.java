package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildScheduledEventInvite$configureUI$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetChatListAdapterItemGuildScheduledEventInvite$Model $model;
    public final /* synthetic */ WidgetChatListAdapterItemGuildScheduledEventInvite this$0;

    public WidgetChatListAdapterItemGuildScheduledEventInvite$configureUI$4(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite, WidgetChatListAdapterItemGuildScheduledEventInvite$Model widgetChatListAdapterItemGuildScheduledEventInvite$Model) {
        this.this$0 = widgetChatListAdapterItemGuildScheduledEventInvite;
        this.$model = widgetChatListAdapterItemGuildScheduledEventInvite$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Job jobAccess$getInviteJoinJob$p = WidgetChatListAdapterItemGuildScheduledEventInvite.access$getInviteJoinJob$p(this.this$0);
        if (jobAccess$getInviteJoinJob$p == null || !jobAccess$getInviteJoinJob$p.a()) {
            WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite = this.this$0;
            WidgetChatListAdapterItemGuildScheduledEventInvite.access$setInviteJoinJob$p(widgetChatListAdapterItemGuildScheduledEventInvite, WidgetChatListAdapterItemInviteBase.joinServerOrDM$default(widgetChatListAdapterItemGuildScheduledEventInvite, widgetChatListAdapterItemGuildScheduledEventInvite.getClass(), this.$model.getInvite(), null, null, 12, null));
        }
    }
}
