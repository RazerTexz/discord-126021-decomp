package com.discord.widgets.chat.overlay;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreStream;

/* JADX INFO: compiled from: WidgetChatOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatOverlay$onViewBoundOrOnResume$2 implements View$OnClickListener {
    public static final WidgetChatOverlay$onViewBoundOrOnResume$2 INSTANCE = new WidgetChatOverlay$onViewBoundOrOnResume$2();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StoreStream.Companion.getMessagesLoader().requestNewestMessages();
    }
}
