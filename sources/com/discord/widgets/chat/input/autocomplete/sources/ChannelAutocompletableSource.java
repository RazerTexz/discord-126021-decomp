package com.discord.widgets.chat.input.autocomplete.sources;

import com.discord.stores.StoreChannels;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import d0.z.d.m;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* JADX INFO: compiled from: ChannelAutocompletableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelAutocompletableSource {
    private final StoreChannels storeChannels;
    private final StorePermissions storePermissions;
    private final StoreThreadsActiveJoined storeThreadsActiveJoined;

    public ChannelAutocompletableSource(StoreChannels storeChannels, StoreThreadsActiveJoined storeThreadsActiveJoined, StorePermissions storePermissions) {
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeThreadsActiveJoined, "storeThreadsActiveJoined");
        m.checkNotNullParameter(storePermissions, "storePermissions");
        this.storeChannels = storeChannels;
        this.storeThreadsActiveJoined = storeThreadsActiveJoined;
        this.storePermissions = storePermissions;
    }

    public final StoreChannels getStoreChannels() {
        return this.storeChannels;
    }

    public final StorePermissions getStorePermissions() {
        return this.storePermissions;
    }

    public final StoreThreadsActiveJoined getStoreThreadsActiveJoined() {
        return this.storeThreadsActiveJoined;
    }

    public final Observable<Map<LeadingIdentifier, TreeSet<Autocompletable>>> observeChannelAutocompletables(long guildId) {
        Observable observableI = Observable.i(ObservableExtensionsKt.computationLatest(StoreChannels.observeChannelsForGuild$default(this.storeChannels, guildId, null, 2, null)), this.storeThreadsActiveJoined.observeActiveJoinedThreadsChannelsForGuild(guildId), ObservableExtensionsKt.computationLatest(this.storePermissions.observePermissionsForAllChannels()), ChannelAutocompletableSource$observeChannelAutocompletables$1.INSTANCE);
        m.checkNotNullExpressionValue(observableI, "Observable.combineLatest…ANNELS to channels)\n    }");
        Observable observableR = ObservableExtensionsKt.computationLatest(observableI).r();
        m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        return ObservableExtensionsKt.leadingEdgeThrottle(observableR, 500L, TimeUnit.MILLISECONDS);
    }
}
