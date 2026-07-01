package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildScheduledEventInvite$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetChatListAdapterItemGuildScheduledEventInvite$Model $model;
    public final /* synthetic */ WidgetChatListAdapterItemGuildScheduledEventInvite this$0;

    public WidgetChatListAdapterItemGuildScheduledEventInvite$configureUI$3(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite, WidgetChatListAdapterItemGuildScheduledEventInvite$Model widgetChatListAdapterItemGuildScheduledEventInvite$Model) {
        this.this$0 = widgetChatListAdapterItemGuildScheduledEventInvite;
        this.$model = widgetChatListAdapterItemGuildScheduledEventInvite$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChatListAdapterItemGuildScheduledEventInvite.access$getGuildScheduledEventStore$p(this.this$0).toggleMeRsvpForEvent(this.$model.getGuildScheduledEvent());
    }
}
