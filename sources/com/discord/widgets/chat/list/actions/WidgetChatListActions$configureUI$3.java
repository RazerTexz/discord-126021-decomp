package com.discord.widgets.chat.list.actions;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.chat.managereactions.WidgetManageReactions;
import com.discord.widgets.chat.managereactions.WidgetManageReactions$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetChatListActions this$0;

    public WidgetChatListActions$configureUI$3(WidgetChatListActions widgetChatListActions) {
        this.this$0 = widgetChatListActions;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetManageReactions$Companion widgetManageReactions$Companion = WidgetManageReactions.Companion;
        long jAccess$getChannelId$p = WidgetChatListActions.access$getChannelId$p(this.this$0);
        long jAccess$getMessageId$p = WidgetChatListActions.access$getMessageId$p(this.this$0);
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        WidgetManageReactions$Companion.create$default(widgetManageReactions$Companion, jAccess$getChannelId$p, jAccess$getMessageId$p, contextRequireContext, null, 8, null);
    }
}
