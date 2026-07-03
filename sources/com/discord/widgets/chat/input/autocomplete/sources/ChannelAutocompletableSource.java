package com.discord.widgets.chat.input.autocomplete.sources;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannels;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.AutocompletableComparator;
import com.discord.widgets.chat.input.autocomplete.ChannelAutocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import p507d0.C12116o;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.functions.Func3;

/* JADX INFO: compiled from: ChannelAutocompletableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelAutocompletableSource {
    private final StoreChannels storeChannels;
    private final StorePermissions storePermissions;
    private final StoreThreadsActiveJoined storeThreadsActiveJoined;

    public ChannelAutocompletableSource(StoreChannels storeChannels, StoreThreadsActiveJoined storeThreadsActiveJoined, StorePermissions storePermissions) {
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        C12238m.checkNotNullParameter(storeThreadsActiveJoined, "storeThreadsActiveJoined");
        C12238m.checkNotNullParameter(storePermissions, "storePermissions");
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
        Observable observableM11075i = Observable.m11075i(ObservableExtensionsKt.computationLatest(StoreChannels.observeChannelsForGuild$default(this.storeChannels, guildId, null, 2, null)), this.storeThreadsActiveJoined.observeActiveJoinedThreadsChannelsForGuild(guildId), ObservableExtensionsKt.computationLatest(this.storePermissions.observePermissionsForAllChannels()), new Func3<Map<Long, ? extends Channel>, Map<Long, ? extends Channel>, Map<Long, ? extends Long>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>>() { // from class: com.discord.widgets.chat.input.autocomplete.sources.ChannelAutocompletableSource.observeChannelAutocompletables.1
            @Override // p658rx.functions.Func3
            public /* bridge */ /* synthetic */ Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> call(Map<Long, ? extends Channel> map, Map<Long, ? extends Channel> map2, Map<Long, ? extends Long> map3) {
                return call2((Map<Long, Channel>) map, (Map<Long, Channel>) map2, (Map<Long, Long>) map3);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Map<LeadingIdentifier, TreeSet<Autocompletable>> call2(Map<Long, Channel> map, Map<Long, Channel> map2, Map<Long, Long> map3) {
                TreeSet treeSet = new TreeSet(new AutocompletableComparator());
                C12238m.checkNotNullExpressionValue(map2, "activeJoinedThreads");
                C12238m.checkNotNullExpressionValue(map, "guildChannels");
                for (Channel channel : C12136h0.plus(map2, map).values()) {
                    if (ChannelUtils.m7698v(channel) || ChannelUtils.m7675J(channel) || ChannelUtils.m7687k(channel)) {
                        C12238m.checkNotNullExpressionValue(map3, ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS);
                        if (PermissionUtils.hasAccess(channel, map3)) {
                            treeSet.add(new ChannelAutocompletable(channel));
                        }
                    }
                }
                return C12134g0.mapOf(C12116o.m10073to(LeadingIdentifier.CHANNELS, treeSet));
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11075i, "Observable.combineLatest…ANNELS to channels)\n    }");
        Observable observableM11112r = ObservableExtensionsKt.computationLatest(observableM11075i).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "Observable.combineLatest…  .distinctUntilChanged()");
        return ObservableExtensionsKt.leadingEdgeThrottle(observableM11112r, 500L, TimeUnit.MILLISECONDS);
    }
}
