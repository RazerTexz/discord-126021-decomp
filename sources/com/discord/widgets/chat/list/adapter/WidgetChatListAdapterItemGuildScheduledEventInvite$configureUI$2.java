package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildScheduledEventInvite$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetChatListAdapterItemGuildScheduledEventInvite$Model $model;
    public final /* synthetic */ WidgetChatListAdapterItemGuildScheduledEventInvite this$0;

    public WidgetChatListAdapterItemGuildScheduledEventInvite$configureUI$2(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite, WidgetChatListAdapterItemGuildScheduledEventInvite$Model widgetChatListAdapterItemGuildScheduledEventInvite$Model) {
        this.this$0 = widgetChatListAdapterItemGuildScheduledEventInvite;
        this.$model = widgetChatListAdapterItemGuildScheduledEventInvite$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (this.$model.isInGuild()) {
            WidgetGuildScheduledEventDetailsBottomSheet.Companion.showForGuild(WidgetChatListAdapterItemGuildScheduledEventInvite.access$getAdapter$p(this.this$0).getFragmentManager(), this.$model.getGuildScheduledEvent().getId());
        } else {
            WidgetChatListAdapterItemInviteBase.joinServerOrDM$default(this.this$0, WidgetChatListAdapterItemGuildScheduledEventInvite.class, this.$model.getInvite(), null, null, 12, null);
        }
    }
}
