package com.discord.widgets.chat.list.adapter;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChatListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapter$Companion {
    private WidgetChatListAdapter$Companion() {
    }

    public static final /* synthetic */ int access$findBestNewMessagesPosition(WidgetChatListAdapter$Companion widgetChatListAdapter$Companion, int i) {
        return widgetChatListAdapter$Companion.findBestNewMessagesPosition(i);
    }

    private final int findBestNewMessagesPosition(int numKnownMessages) {
        if (-1 <= numKnownMessages && 10 > numKnownMessages) {
            return -1;
        }
        if (10 <= numKnownMessages && 30 > numKnownMessages) {
            return numKnownMessages;
        }
        return 30;
    }

    public /* synthetic */ WidgetChatListAdapter$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
