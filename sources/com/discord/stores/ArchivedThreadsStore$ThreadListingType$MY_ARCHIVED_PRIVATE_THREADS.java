package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.thread.ThreadListing;
import com.discord.utilities.rest.RestAPI;
import d0.t.u;
import d0.z.d.m;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: ArchivedThreadsStore.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ArchivedThreadsStore$ThreadListingType$MY_ARCHIVED_PRIVATE_THREADS extends ArchivedThreadsStore$ThreadListingType {
    public ArchivedThreadsStore$ThreadListingType$MY_ARCHIVED_PRIVATE_THREADS(String str, int i) {
        super(str, i, null);
    }

    @Override // com.discord.stores.ArchivedThreadsStore$ThreadListingType
    public Observable<ThreadListing> fetchNext(long channelId, List<Channel> threads) {
        m.checkNotNullParameter(threads, "threads");
        Channel channel = (Channel) u.lastOrNull((List) threads);
        return RestAPI.Companion.getApi().getMyPrivateArchivedThreads(channelId, channel != null ? Long.valueOf(channel.getId()) : null);
    }
}
