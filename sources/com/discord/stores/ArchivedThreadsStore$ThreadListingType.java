package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.thread.ThreadListing;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: ArchivedThreadsStore.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ArchivedThreadsStore$ThreadListingType {
    private static final /* synthetic */ ArchivedThreadsStore$ThreadListingType[] $VALUES;
    public static final ArchivedThreadsStore$ThreadListingType ALL_ARCHIVED_PRIVATE_THREADS;
    public static final ArchivedThreadsStore$ThreadListingType ALL_ARCHIVED_PUBLIC_THREADS;
    public static final ArchivedThreadsStore$ThreadListingType$Companion Companion;
    public static final ArchivedThreadsStore$ThreadListingType MY_ARCHIVED_PRIVATE_THREADS;

    static {
        ArchivedThreadsStore$ThreadListingType$MY_ARCHIVED_PRIVATE_THREADS archivedThreadsStore$ThreadListingType$MY_ARCHIVED_PRIVATE_THREADS = new ArchivedThreadsStore$ThreadListingType$MY_ARCHIVED_PRIVATE_THREADS("MY_ARCHIVED_PRIVATE_THREADS", 0);
        MY_ARCHIVED_PRIVATE_THREADS = archivedThreadsStore$ThreadListingType$MY_ARCHIVED_PRIVATE_THREADS;
        ArchivedThreadsStore$ThreadListingType$ALL_ARCHIVED_PUBLIC_THREADS archivedThreadsStore$ThreadListingType$ALL_ARCHIVED_PUBLIC_THREADS = new ArchivedThreadsStore$ThreadListingType$ALL_ARCHIVED_PUBLIC_THREADS("ALL_ARCHIVED_PUBLIC_THREADS", 1);
        ALL_ARCHIVED_PUBLIC_THREADS = archivedThreadsStore$ThreadListingType$ALL_ARCHIVED_PUBLIC_THREADS;
        ArchivedThreadsStore$ThreadListingType$ALL_ARCHIVED_PRIVATE_THREADS archivedThreadsStore$ThreadListingType$ALL_ARCHIVED_PRIVATE_THREADS = new ArchivedThreadsStore$ThreadListingType$ALL_ARCHIVED_PRIVATE_THREADS("ALL_ARCHIVED_PRIVATE_THREADS", 2);
        ALL_ARCHIVED_PRIVATE_THREADS = archivedThreadsStore$ThreadListingType$ALL_ARCHIVED_PRIVATE_THREADS;
        $VALUES = new ArchivedThreadsStore$ThreadListingType[]{archivedThreadsStore$ThreadListingType$MY_ARCHIVED_PRIVATE_THREADS, archivedThreadsStore$ThreadListingType$ALL_ARCHIVED_PUBLIC_THREADS, archivedThreadsStore$ThreadListingType$ALL_ARCHIVED_PRIVATE_THREADS};
        Companion = new ArchivedThreadsStore$ThreadListingType$Companion(null);
    }

    private ArchivedThreadsStore$ThreadListingType(String str, int i) {
        super(str, i);
    }

    public static ArchivedThreadsStore$ThreadListingType valueOf(String str) {
        return (ArchivedThreadsStore$ThreadListingType) Enum.valueOf(ArchivedThreadsStore$ThreadListingType.class, str);
    }

    public static ArchivedThreadsStore$ThreadListingType[] values() {
        return (ArchivedThreadsStore$ThreadListingType[]) $VALUES.clone();
    }

    public abstract Observable<ThreadListing> fetchNext(long channelId, List<Channel> threads);

    public /* synthetic */ ArchivedThreadsStore$ThreadListingType(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i);
    }
}
