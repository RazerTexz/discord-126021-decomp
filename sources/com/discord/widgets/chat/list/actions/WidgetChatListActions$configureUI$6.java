package com.discord.widgets.chat.list.actions;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreStream;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions$configureUI$6 implements View$OnClickListener {
    public final /* synthetic */ WidgetChatListActions$Model $data;
    public final /* synthetic */ WidgetChatListActions this$0;

    public WidgetChatListActions$configureUI$6(WidgetChatListActions widgetChatListActions, WidgetChatListActions$Model widgetChatListActions$Model) {
        this.this$0 = widgetChatListActions;
        this.$data = widgetChatListActions$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StoreStream.Companion.getMessageAck().markUnread(this.$data.getMessage().getChannelId(), this.$data.getMessage().getId());
        this.this$0.dismiss();
    }
}
