package com.discord.widgets.status;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreStream;

/* JADX INFO: compiled from: WidgetChatStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatStatus$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetChatStatus$Model $data;

    public WidgetChatStatus$configureUI$2(WidgetChatStatus$Model widgetChatStatus$Model) {
        this.$data = widgetChatStatus$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StoreStream.Companion.getReadStates().markAsRead(Long.valueOf(this.$data.getUnreadChannelId()));
    }
}
