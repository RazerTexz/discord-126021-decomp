package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.domain.ModelInvite;

/* JADX INFO: compiled from: WidgetChatListAdapterItemInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemInvite$configureResolvedUI$2 implements View$OnClickListener {
    public final /* synthetic */ ModelInvite $invite;
    public final /* synthetic */ WidgetChatListAdapterItemInvite this$0;

    public WidgetChatListAdapterItemInvite$configureResolvedUI$2(WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite, ModelInvite modelInvite) {
        this.this$0 = widgetChatListAdapterItemInvite;
        this.$invite = modelInvite;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite = this.this$0;
        WidgetChatListAdapterItemInviteBase.joinServerOrDM$default(widgetChatListAdapterItemInvite, widgetChatListAdapterItemInvite.getClass(), this.$invite, null, null, 12, null);
    }
}
