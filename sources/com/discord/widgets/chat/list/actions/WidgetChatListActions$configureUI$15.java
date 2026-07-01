package com.discord.widgets.chat.list.actions;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.channel.ChannelSelector;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions$configureUI$15 implements View$OnClickListener {
    public final /* synthetic */ WidgetChatListActions$Model $data;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ WidgetChatListActions this$0;

    public WidgetChatListActions$configureUI$15(WidgetChatListActions widgetChatListActions, long j, WidgetChatListActions$Model widgetChatListActions$Model) {
        this.this$0 = widgetChatListActions;
        this.$guildId = j;
        this.$data = widgetChatListActions$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
        ChannelSelector.Companion.getInstance().openCreateThread(this.$guildId, this.$data.getMessage().getChannelId(), Long.valueOf(this.$data.getMessage().getId()), "Message");
    }
}
