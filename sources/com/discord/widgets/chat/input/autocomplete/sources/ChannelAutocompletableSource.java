package com.discord.widgets.chat.input.autocomplete.sources;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannels;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.AutocompletableComparator;
import com.discord.widgets.chat.input.autocomplete.ChannelAutocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import d0.Tuples;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func3;

/* JADX INFO: compiled from: ChannelAutocompletableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelAutocompletableSource {
    private final StoreChannels storeChannels;
    private final StorePermissions storePermissions;
    private final StoreThreadsActiveJoined storeThreadsActiveJoined;

    public ChannelAutocompletableSource(StoreChannels storeChannels, StoreThreadsActiveJoined storeThreadsActiveJoined, StorePermissions storePermissions) {
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeThreadsActiveJoined, "storeThreadsActiveJoined");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
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
        Observable observableI = Observable.i(ObservableExtensionsKt.computationLatest(StoreChannels.observeChannelsForGuild$default(this.storeChannels, guildId, null, 2, null)), this.storeThreadsActiveJoined.observeActiveJoinedThreadsChannelsForGuild(guildId), ObservableExtensionsKt.computationLatest(this.storePermissions.observePermissionsForAllChannels()), new Func3<Map<Long, ? extends Channel>, Map<Long, ? extends Channel>, Map<Long, ? extends Long>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>>() { // from class: com.discord.widgets.chat.input.autocomplete.sources.ChannelAutocompletableSource.observeChannelAutocompletables.1
            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> call(Map<Long, ? extends Channel> map, Map<Long, ? extends Channel> map2, Map<Long, ? extends Long> map3) {
                return call2((Map<Long, Channel>) map, (Map<Long, Channel>) map2, (Map<Long, Long>) map3);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Map<LeadingIdentifier, TreeSet<Autocompletable>> call2(Map<Long, Channel> map, Map<Long, Channel> map2, Map<Long, Long> map3) {
                TreeSet treeSet = new TreeSet(new AutocompletableComparator());
                Intrinsics3.checkNotNullExpressionValue(map2, "activeJoinedThreads");
                Intrinsics3.checkNotNullExpressionValue(map, "guildChannels");
                for (Channel channel : Maps6.plus(map2, map).values()) {
                    if (ChannelUtils.v(channel) || ChannelUtils.J(channel) || ChannelUtils.k(channel)) {
                        Intrinsics3.checkNotNullExpressionValue(map3, ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS);
                        if (PermissionUtils.hasAccess(channel, map3)) {
                            treeSet.add(new ChannelAutocompletable(channel));
                        }
                    }
                }
                return MapsJVM.mapOf(Tuples.to(LeadingIdentifier.CHANNELS, treeSet));
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…ANNELS to channels)\n    }");
        Observable observableR = ObservableExtensionsKt.computationLatest(observableI).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        return ObservableExtensionsKt.leadingEdgeThrottle(observableR, 500L, TimeUnit.MILLISECONDS);
    }
}
