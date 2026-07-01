package com.discord.widgets.chat.list.actions;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions$Companion {
    private WidgetChatListActions$Companion() {
    }

    public final void showForChat(FragmentManager fragmentManager, long channelId, long messageId, CharSequence messageContent) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(messageContent, "messageContent");
        WidgetChatListActions widgetChatListActions = new WidgetChatListActions();
        Bundle bundleT = a.T("INTENT_EXTRA_MESSAGE_CHANNEL_ID", channelId);
        bundleT.putLong("INTENT_EXTRA_MESSAGE_ID", messageId);
        bundleT.putCharSequence("INTENT_EXTRA_MESSAGE_CONTENT", messageContent);
        bundleT.putInt("INTENT_EXTRA_TYPE", 0);
        widgetChatListActions.setArguments(bundleT);
        widgetChatListActions.show(fragmentManager, WidgetChatListActions.class.getName());
    }

    public final void showForPin(FragmentManager fragmentManager, long channelId, long messageId, CharSequence messageContent) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(messageContent, "messageContent");
        Bundle bundle = new Bundle();
        bundle.putLong("INTENT_EXTRA_MESSAGE_CHANNEL_ID", channelId);
        bundle.putLong("INTENT_EXTRA_MESSAGE_ID", messageId);
        bundle.putCharSequence("INTENT_EXTRA_MESSAGE_CONTENT", messageContent);
        bundle.putInt("INTENT_EXTRA_TYPE", 1);
        WidgetChatListActions widgetChatListActions = new WidgetChatListActions();
        widgetChatListActions.setArguments(bundle);
        widgetChatListActions.show(fragmentManager, WidgetChatListActions.class.getName());
    }

    public /* synthetic */ WidgetChatListActions$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
