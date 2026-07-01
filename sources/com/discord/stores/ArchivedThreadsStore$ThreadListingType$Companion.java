package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.thread.ThreadMetadata;
import d0.t.u;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ArchivedThreadsStore.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ArchivedThreadsStore$ThreadListingType$Companion {
    private ArchivedThreadsStore$ThreadListingType$Companion() {
    }

    public static final /* synthetic */ String access$getLastArchiveTimestamp(ArchivedThreadsStore$ThreadListingType$Companion archivedThreadsStore$ThreadListingType$Companion, List list) {
        return archivedThreadsStore$ThreadListingType$Companion.getLastArchiveTimestamp(list);
    }

    private final String getLastArchiveTimestamp(List<Channel> threads) {
        String strA;
        if (threads.isEmpty()) {
            return null;
        }
        ThreadMetadata threadMetadata = ((Channel) u.last((List) threads)).getThreadMetadata();
        if (threadMetadata == null || (strA = threadMetadata.getArchiveTimestamp()) == null) {
            throw new IllegalStateException("Thread missing threadMetadata");
        }
        return strA;
    }

    public /* synthetic */ ArchivedThreadsStore$ThreadListingType$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
