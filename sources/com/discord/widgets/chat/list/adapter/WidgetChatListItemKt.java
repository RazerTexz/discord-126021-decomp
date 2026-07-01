package com.discord.widgets.chat.list.adapter;

import com.discord.api.user.User;
import com.discord.models.message.Message;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: WidgetChatListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListItemKt {
    public static final boolean isUserMentioned(WidgetChatListAdapter widgetChatListAdapter, Message message) {
        boolean z2;
        m.checkNotNullParameter(widgetChatListAdapter, "$this$isUserMentioned");
        m.checkNotNullParameter(message, "message");
        if (widgetChatListAdapter.getMentionMeMessageLevelHighlighting()) {
            if (m.areEqual(message.getMentionEveryone(), Boolean.TRUE)) {
                return true;
            }
            List<User> mentions = message.getMentions();
            if (mentions != null) {
                Iterator<T> it = mentions.iterator();
                while (it.hasNext()) {
                    if (((User) it.next()).getId() == widgetChatListAdapter.getData().getUserId()) {
                        return true;
                    }
                }
            }
            List<Long> mentionRoles = message.getMentionRoles();
            if (mentionRoles != null) {
                if (mentionRoles.isEmpty()) {
                    z2 = false;
                } else {
                    Iterator<T> it2 = mentionRoles.iterator();
                    while (it2.hasNext()) {
                        if (widgetChatListAdapter.getData().getMyRoleIds().contains(Long.valueOf(((Number) it2.next()).longValue()))) {
                            z2 = true;
                        }
                    }
                    z2 = false;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }
}
