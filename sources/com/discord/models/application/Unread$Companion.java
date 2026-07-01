package com.discord.models.application;

import com.discord.models.message.Message;
import d0.t.s;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Unread.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Unread$Companion {
    private Unread$Companion() {
    }

    public static final /* synthetic */ int access$getTotalMessages(Unread$Companion unread$Companion, Unread$Marker unread$Marker, List list) {
        return unread$Companion.getTotalMessages(unread$Marker, list);
    }

    private final int getTotalMessages(Unread$Marker marker, List<Message> messages) {
        int i = 0;
        if (!messages.isEmpty() && marker.getMessageId() != null) {
            Iterator it = s.asReversed(messages).iterator();
            while (it.hasNext()) {
                long id2 = ((Message) it.next()).getId();
                Long messageId = marker.getMessageId();
                if (messageId != null && id2 == messageId.longValue()) {
                    return i;
                }
                i++;
            }
        }
        return i;
    }

    public /* synthetic */ Unread$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
