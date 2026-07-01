package com.discord.stores;

import com.discord.models.message.Message;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StorePinnedMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePinnedMessages$Companion {
    private StorePinnedMessages$Companion() {
    }

    public static final /* synthetic */ Message access$getMessage(StorePinnedMessages$Companion storePinnedMessages$Companion, List list, long j) {
        return storePinnedMessages$Companion.getMessage(list, j);
    }

    public static final /* synthetic */ int access$getMessageIndex(StorePinnedMessages$Companion storePinnedMessages$Companion, List list, long j) {
        return storePinnedMessages$Companion.getMessageIndex(list, j);
    }

    private final Message getMessage(List<Message> channelMessages, long messageId) {
        Object obj = null;
        if (channelMessages == null) {
            return null;
        }
        for (Object obj2 : channelMessages) {
            if (((Message) obj2).getId() == messageId) {
                obj = obj2;
                break;
            }
        }
        return (Message) obj;
    }

    private final int getMessageIndex(List<Message> channelPinnedMessages, long messageId) {
        Iterator<Message> it = channelPinnedMessages.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getId() == messageId) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public /* synthetic */ StorePinnedMessages$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
