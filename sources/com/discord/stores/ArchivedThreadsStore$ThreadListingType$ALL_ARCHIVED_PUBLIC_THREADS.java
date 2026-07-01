package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.thread.ThreadListing;
import com.discord.utilities.rest.RestAPI;
import d0.z.d.m;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: ArchivedThreadsStore.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ArchivedThreadsStore$ThreadListingType$ALL_ARCHIVED_PUBLIC_THREADS extends ArchivedThreadsStore$ThreadListingType {
    public ArchivedThreadsStore$ThreadListingType$ALL_ARCHIVED_PUBLIC_THREADS(String str, int i) {
        super(str, i, null);
    }

    @Override // com.discord.stores.ArchivedThreadsStore$ThreadListingType
    public Observable<ThreadListing> fetchNext(long channelId, List<Channel> threads) {
        m.checkNotNullParameter(threads, "threads");
        try {
            return RestAPI.Companion.getApi().getAllPublicArchivedThreads(channelId, ArchivedThreadsStore$ThreadListingType$Companion.access$getLastArchiveTimestamp(ArchivedThreadsStore$ThreadListingType.Companion, threads));
        } catch (IllegalStateException e) {
            Observable<ThreadListing> observableX = Observable.x(e);
            m.checkNotNullExpressionValue(observableX, "Observable.error(e)");
            return observableX;
        }
    }
}
