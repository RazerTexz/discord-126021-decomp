package com.discord.widgets.chat.list.actions;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions$configureUI$11 implements View$OnClickListener {
    public final /* synthetic */ WidgetChatListActions$Model $data;
    public final /* synthetic */ WidgetChatListActions this$0;

    public WidgetChatListActions$configureUI$11(WidgetChatListActions widgetChatListActions, WidgetChatListActions$Model widgetChatListActions$Model) {
        this.this$0 = widgetChatListActions;
        this.$data = widgetChatListActions$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChatListActions.access$toggleMessagePin(this.this$0, this.$data.getMessage());
    }
}
