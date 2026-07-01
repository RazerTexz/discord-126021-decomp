package com.discord.stores;

import android.content.Context;
import androidx.core.content.pm.ShortcutManagerCompat;
import b.a.d.o;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelRecipient;
import com.discord.api.channel.ChannelRecipientNick;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.api.permission.Permission;
import com.discord.api.user.User;
import com.discord.models.domain.ModelPayload;
import com.discord.models.message.Message;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.collections.CollectionExtensions;
import com.discord.utilities.frecency.FrecencyTracker;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.search.network.state.SearchState;
import d0.d0._Ranges;
import d0.f0._Sequences2;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t.MutableCollections;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannels extends StoreV2 {
    private static final StoreChannels2 InitializedUpdateSource = new ObservationDeck.UpdateSource() { // from class: com.discord.stores.StoreChannels$Companion$InitializedUpdateSource$1
    };
    public static final long PRIVATE_CHANNELS_ID = 0;
    private final Map<Long, String> channelNames;
    private Map<Long, String> channelNamesSnapshot;
    private final Map<Long, Map<Long, Channel>> channelsByGuild;
    private Map<Long, ? extends Map<Long, Channel>> channelsByGuildSnapshot;
    private Map<Long, Channel> channelsByIdSnapshot;
    private final Persister<List<Channel>> channelsCache;
    private final Dispatcher dispatcher;
    private final Function0<List<Long>> getLurkingGuildIds;
    private boolean handledReadyPayload;
    private boolean initializedForAuthedUser;
    private final Function0<Boolean> isAuthenticated;
    private boolean isConnectionOpen;
    private boolean isStoreInitTimedOut;
    private final ObservationDeck observationDeck;
    private final Function1<Long, Observable<Map<Long, Long>>> observeChannelPermissionsForGuild;
    private final Map<Long, Channel> preloadedThreads;
    private final Map<Long, Channel> threadsById;
    private Map<Long, Channel> threadsByIdSnapshot;

    /* JADX INFO: renamed from: com.discord.stores.StoreChannels$handleGuildRemove$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreChannels.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Channel, Boolean> {
        public final /* synthetic */ Guild $guild;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Guild guild) {
            super(1);
            this.$guild = guild;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
            return Boolean.valueOf(invoke2(channel));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "thread");
            return channel.getGuildId() == this.$guild.getId();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChannels$observeAllChannels$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreChannels.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Channel>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Channel> invoke() {
            return Maps6.plus(StoreChannels.this.channelsByIdSnapshot, StoreChannels.this.threadsByIdSnapshot);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChannels$observeChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreChannels.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Channel> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Channel invoke() {
            return StoreChannels.this.getChannel(this.$channelId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChannels$observeGuildAndPrivateChannels$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreChannels.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Channel>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Channel> invoke() {
            return StoreChannels.this.channelsByIdSnapshot;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChannels$observeInitializedForAuthedUser$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreChannels.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return StoreChannels.this.getInitializedForAuthedUser();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChannels$observeNames$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreChannels.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends String>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends String> invoke() {
            return StoreChannels.this.channelNamesSnapshot;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChannels$observeThreadsFromMessages$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreChannels.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Channel>> {
        public final /* synthetic */ List $messages;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list) {
            super(0);
            this.$messages = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Channel> invoke() {
            List list = this.$messages;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((Message) obj).hasThread()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Channel channel = StoreChannels.this.getChannel(((Message) it.next()).getId());
                if (channel != null) {
                    arrayList2.add(channel);
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(arrayList2, 10)), 16));
            for (Object obj2 : arrayList2) {
                linkedHashMap.put(Long.valueOf(((Channel) obj2).getId()), obj2);
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChannels$onGroupCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreChannels.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Channel $channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Channel channel) {
            super(0);
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreChannels.this.handleChannelOrThreadCreateOrUpdate(this.$channel);
        }
    }

    public /* synthetic */ StoreChannels(Dispatcher dispatcher, ObservationDeck observationDeck, Function1 function1, Function0 function0, Function0 function2, Persister persister, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, observationDeck, function1, function0, function2, (i & 32) != 0 ? new Persister("STORE_CHANNELS_V26", new ArrayList()) : persister);
    }

    public static /* synthetic */ Observable observeChannelsForGuild$default(StoreChannels storeChannels, long j, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        return storeChannels.observeChannelsForGuild(j, num);
    }

    public static /* synthetic */ Observable observeIds$default(StoreChannels storeChannels, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return storeChannels.observeIds(z2);
    }

    public static /* synthetic */ void storeThread$app_productionGoogleRelease$default(StoreChannels storeChannels, Channel channel, long j, Channel channel2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        if ((i & 4) != 0) {
            channel2 = null;
        }
        storeChannels.storeThread$app_productionGoogleRelease(channel, j, channel2);
    }

    @Store3
    private final void updateInitializationState() {
        boolean z2 = this.initializedForAuthedUser;
        boolean z3 = this.isAuthenticated.invoke().booleanValue() && ((getChannelsByIdInternal$app_productionGoogleRelease().isEmpty() ^ true) || this.handledReadyPayload || this.isStoreInitTimedOut);
        if (z2 || !z3) {
            return;
        }
        this.initializedForAuthedUser = true;
        markChanged(InitializedUpdateSource);
    }

    public final Channel findChannelById(long channelId) {
        if (this.threadsByIdSnapshot.containsKey(Long.valueOf(channelId))) {
            return this.threadsByIdSnapshot.get(Long.valueOf(channelId));
        }
        Iterator<T> it = this.channelsByGuildSnapshot.values().iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            if (map.containsKey(Long.valueOf(channelId))) {
                return (Channel) map.get(Long.valueOf(channelId));
            }
        }
        return null;
    }

    @Store3
    public final Channel findChannelByIdInternal$app_productionGoogleRelease(long channelId) {
        if (this.threadsById.containsKey(Long.valueOf(channelId))) {
            return this.threadsById.get(Long.valueOf(channelId));
        }
        Iterator<T> it = this.channelsByGuild.values().iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            if (map.containsKey(Long.valueOf(channelId))) {
                return (Channel) map.get(Long.valueOf(channelId));
            }
        }
        return null;
    }

    @Store3
    public final List<Channel> findChannelsByCategoryInternal$app_productionGoogleRelease(long guildId, long categoryId) {
        Collection<Channel> collectionValues;
        Map<Long, Channel> map = this.channelsByGuild.get(Long.valueOf(guildId));
        if (map == null || (collectionValues = map.values()) == null) {
            return Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((Channel) obj).getParentId() == categoryId) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final Channel getChannel(long channelId) {
        Channel channel = this.channelsByIdSnapshot.get(Long.valueOf(channelId));
        return channel != null ? channel : this.threadsByIdSnapshot.get(Long.valueOf(channelId));
    }

    @Store3
    public final Channel getChannelInternal$app_productionGoogleRelease(long guildId, long channelId) {
        Channel channel;
        Map<Long, Channel> map = this.channelsByGuild.get(Long.valueOf(guildId));
        return (map == null || (channel = map.get(Long.valueOf(channelId))) == null) ? this.threadsById.get(Long.valueOf(channelId)) : channel;
    }

    public final Map<Long, String> getChannelNames() {
        return this.channelNamesSnapshot;
    }

    @Store3
    public final Map<Long, String> getChannelNamesInternal$app_productionGoogleRelease() {
        return this.channelNames;
    }

    @Store3
    public final Map<Long, Map<Long, Channel>> getChannelsByGuildInternal$app_productionGoogleRelease() {
        return this.channelsByGuild;
    }

    @Store3
    public final Map<Long, Channel> getChannelsByIdInternal$app_productionGoogleRelease() {
        Collection<Map<Long, Channel>> collectionValues = this.channelsByGuild.values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            MutableCollections.addAll(arrayList, ((Map) it.next()).values());
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            linkedHashMap.put(Long.valueOf(((Channel) obj).getId()), obj);
        }
        return linkedHashMap;
    }

    public final Map<Long, Channel> getChannelsForGuild(long guildId) {
        Map<Long, Channel> map = this.channelsByGuildSnapshot.get(Long.valueOf(guildId));
        return map != null ? map : Maps6.emptyMap();
    }

    @Store3
    public final Map<Long, Channel> getChannelsForGuildInternal$app_productionGoogleRelease(long guildId) {
        return this.channelsByGuild.get(Long.valueOf(guildId));
    }

    @Store3
    public final Channel getGuildChannelInternal$app_productionGoogleRelease(long guildId, long channelId) {
        Map<Long, Channel> map = this.channelsByGuild.get(Long.valueOf(guildId));
        if (map != null) {
            return map.get(Long.valueOf(channelId));
        }
        return null;
    }

    /* JADX INFO: renamed from: getInitializedForAuthedUser$app_productionGoogleRelease, reason: from getter */
    public final boolean getInitializedForAuthedUser() {
        return this.initializedForAuthedUser;
    }

    @Store3
    public final Map<Long, Channel> getThreadsByIdInternal$app_productionGoogleRelease() {
        return this.threadsById;
    }

    @Store3
    public final List<Channel> getThreadsForChannelInternal$app_productionGoogleRelease(long channelId) {
        Collection<Channel> collectionValues = this.threadsById.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((Channel) obj).getParentId() == channelId) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Store3
    public final List<Channel> getThreadsForGuildInternal$app_productionGoogleRelease(long guildId) {
        Collection<Channel> collectionValues = this.threadsById.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((Channel) obj).getGuildId() == guildId) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Store3
    public final void handleChannelOrThreadCreateOrUpdate(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (ChannelUtils.y(channel)) {
            return;
        }
        long guildId = !ChannelUtils.B(channel) ? channel.getGuildId() : 0L;
        long id2 = channel.getId();
        if (ChannelUtils.H(channel)) {
            storeThread$app_productionGoogleRelease$default(this, channel, guildId, null, 4, null);
        } else {
            Map<Long, Map<Long, Channel>> map = this.channelsByGuild;
            Long lValueOf = Long.valueOf(guildId);
            Map<Long, Channel> map2 = map.get(lValueOf);
            if (map2 == null) {
                map2 = new HashMap<>();
                map.put(lValueOf, map2);
            }
            Map<Long, Channel> map3 = map2;
            Channel channel2 = map3.get(Long.valueOf(id2));
            if (!Intrinsics3.areEqual(channel, channel2)) {
                if (channel2 != null) {
                    map3.put(Long.valueOf(id2), Channel.a(channel, null, 0, channel.getGuildId() != 0 ? channel.getGuildId() : guildId, null, 0L, 0L, 0L, null, channel2.z(), 0, null, 0, 0, null, 0L, 0L, null, false, 0L, null, 0, null, null, null, null, null, null, null, null, null, null, null, -261));
                } else {
                    map3.put(Long.valueOf(id2), Channel.a(channel, null, 0, channel.getGuildId() != 0 ? channel.getGuildId() : guildId, null, 0L, 0L, 0L, null, null, 0, null, 0, 0, null, 0L, 0L, null, false, 0L, null, 0, null, null, null, null, null, null, null, null, null, null, null, -5));
                }
            }
            boolean nsfw = channel.getNsfw();
            if (channel2 == null || nsfw != channel2.getNsfw()) {
                Iterator<T> it = getThreadsForChannelInternal$app_productionGoogleRelease(channel.getId()).iterator();
                while (it.hasNext()) {
                    storeThread$app_productionGoogleRelease((Channel) it.next(), guildId, channel);
                }
            }
            this.channelNames.put(Long.valueOf(id2), ChannelUtils.c(channel));
        }
        markChanged();
    }

    @Store3
    public final void handleChannelOrThreadDelete(Channel channel) {
        Map<Long, Channel> map;
        Intrinsics3.checkNotNullParameter(channel, "channel");
        long guildId = !ChannelUtils.B(channel) ? channel.getGuildId() : 0L;
        long id2 = channel.getId();
        if (this.channelsByGuild.containsKey(Long.valueOf(guildId)) && (map = this.channelsByGuild.get(Long.valueOf(guildId))) != null && map.containsKey(Long.valueOf(id2))) {
            Map<Long, Channel> map2 = this.channelsByGuild.get(Long.valueOf(guildId));
            if (map2 != null) {
                map2.remove(Long.valueOf(id2));
            }
            markChanged();
        }
        if (this.channelNames.containsKey(Long.valueOf(id2))) {
            this.channelNames.remove(Long.valueOf(id2));
            markChanged();
        }
        if (this.threadsById.containsKey(Long.valueOf(id2))) {
            this.threadsById.remove(Long.valueOf(id2));
            markChanged();
        }
    }

    @Store3
    public final void handleConnected(boolean connected) {
        this.isConnectionOpen = connected;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.isConnectionOpen = true;
        this.channelsByGuild.clear();
        this.channelNames.clear();
        this.threadsById.clear();
        Map<Long, Map<Long, Channel>> map = this.channelsByGuild;
        Map<Long, Channel> map2 = map.get(0L);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(0L, map2);
        }
        Map<Long, Channel> map3 = map2;
        List<Channel> privateChannels = payload.getPrivateChannels();
        ArrayList<Channel> arrayListA0 = outline.a0(privateChannels, "payload.privateChannels");
        for (Object obj : privateChannels) {
            Channel channel = (Channel) obj;
            Intrinsics3.checkNotNullExpressionValue(channel, "it");
            if (!ChannelUtils.y(channel)) {
                arrayListA0.add(obj);
            }
        }
        for (Channel channel2 : arrayListA0) {
            Long lValueOf = Long.valueOf(channel2.getId());
            Intrinsics3.checkNotNullExpressionValue(channel2, "privateChannel");
            map3.put(lValueOf, channel2);
        }
        List<Guild> guilds = payload.getGuilds();
        Intrinsics3.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            Map<Long, Map<Long, Channel>> map4 = this.channelsByGuild;
            Long lValueOf2 = Long.valueOf(guild.getId());
            Map<Long, Channel> map5 = map4.get(lValueOf2);
            if (map5 == null) {
                map5 = new HashMap<>();
                map4.put(lValueOf2, map5);
            }
            Map<Long, Channel> map6 = map5;
            List<Channel> listG = guild.g();
            if (listG != null) {
                for (Channel channel3 : listG) {
                    map6.put(Long.valueOf(channel3.getId()), Channel.a(channel3, null, 0, channel3.getGuildId() != 0 ? channel3.getGuildId() : guild.getId(), null, 0L, 0L, 0L, null, null, 0, null, 0, 0, null, 0L, 0L, null, false, 0L, null, 0, null, null, null, null, null, null, null, null, null, null, null, -5));
                }
            }
            List<Channel> listN = guild.N();
            if (listN != null) {
                for (Channel channel4 : listN) {
                    if (ChannelUtils.H(channel4)) {
                        storeThread$app_productionGoogleRelease$default(this, channel4, guild.getId(), null, 4, null);
                    }
                }
            }
        }
        for (Channel channel5 : this.preloadedThreads.values()) {
            if (!this.threadsById.containsKey(Long.valueOf(channel5.getId()))) {
                storeThread$app_productionGoogleRelease$default(this, channel5, channel5.getGuildId(), null, 4, null);
            }
        }
        this.preloadedThreads.clear();
        Iterator<Map.Entry<Long, Map<Long, Channel>>> it = this.channelsByGuild.entrySet().iterator();
        while (it.hasNext()) {
            Map<Long, Channel> value = it.next().getValue();
            Map<Long, String> map7 = this.channelNames;
            Iterator<T> it2 = value.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                map7.put((Long) entry.getKey(), ChannelUtils.c((Channel) entry.getValue()));
            }
        }
        this.handledReadyPayload = true;
        updateInitializationState();
        markChanged();
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00f3  */
    @Store3
    public final void handleGroupDMRecipient(ChannelRecipient recipient, boolean add) {
        ArrayList arrayList;
        List<ChannelRecipientNick> listQ;
        ArrayList arrayList2;
        Intrinsics3.checkNotNullParameter(recipient, "recipient");
        Map<Long, Channel> map = this.channelsByGuild.get(0L);
        if (map != null) {
            long jA = recipient.getChannelId();
            Channel channel = map.get(Long.valueOf(jA));
            if (channel != null) {
                long guildId = channel.getGuildId();
                if (add) {
                    List<User> listZ = channel.z();
                    ArrayList arrayList3 = listZ != null ? new ArrayList(listZ) : new ArrayList();
                    arrayList3.add(recipient.getUser());
                    arrayList = arrayList3;
                } else {
                    ArrayList arrayList4 = new ArrayList();
                    List<User> listZ2 = channel.z();
                    if (listZ2 == null) {
                        listZ2 = Collections2.emptyList();
                    }
                    for (User user : listZ2) {
                        if (user.getId() != recipient.getUser().getId()) {
                            arrayList4.add(user);
                        }
                    }
                    arrayList = arrayList4;
                }
                long guildId2 = channel.getGuildId() != 0 ? channel.getGuildId() : guildId;
                String strB = recipient.getNick();
                if (strB == null) {
                    listQ = channel.q();
                } else {
                    List<ChannelRecipientNick> listQ2 = channel.q();
                    if (listQ2 != null) {
                        arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(listQ2, 10));
                        for (ChannelRecipientNick channelRecipientNick : listQ2) {
                            if (channelRecipientNick.b() == recipient.getUser().getId()) {
                                channelRecipientNick = new ChannelRecipientNick(recipient.getUser().getId(), strB);
                            }
                            arrayList2.add(channelRecipientNick);
                        }
                    } else {
                        arrayList2 = null;
                    }
                    if (arrayList2 != null) {
                        listQ = arrayList2;
                    } else {
                        listQ = channel.q();
                    }
                }
                Channel channelA = Channel.a(channel, null, 0, guildId2, null, 0L, 0L, 0L, null, arrayList, 0, null, 0, 0, null, 0L, 0L, listQ, false, 0L, null, 0, null, null, null, null, null, null, null, null, null, null, null, -65797);
                Map<Long, Channel> map2 = this.channelsByGuild.get(Long.valueOf(guildId));
                if (map2 != null) {
                    map2.put(Long.valueOf(jA), channelA);
                }
                markChanged();
            }
        }
    }

    @Store3
    public final void handleGuildAdd(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        Map<Long, Map<Long, Channel>> map = this.channelsByGuild;
        Long lValueOf = Long.valueOf(guild.getId());
        Map<Long, Channel> map2 = map.get(lValueOf);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(lValueOf, map2);
        }
        Map<Long, Channel> map3 = map2;
        List<Channel> listG = guild.g();
        if (listG != null) {
            for (Channel channel : listG) {
                map3.put(Long.valueOf(channel.getId()), Channel.a(channel, null, 0, channel.getGuildId() != 0 ? channel.getGuildId() : guild.getId(), null, 0L, 0L, 0L, null, null, 0, null, 0, 0, null, 0L, 0L, null, false, 0L, null, 0, null, null, null, null, null, null, null, null, null, null, null, -5));
                this.channelNames.put(Long.valueOf(channel.getId()), ChannelUtils.c(channel));
            }
        }
        List<Channel> listN = guild.N();
        if (listN != null) {
            for (Channel channel2 : listN) {
                if (ChannelUtils.H(channel2)) {
                    storeThread$app_productionGoogleRelease$default(this, channel2, guild.getId(), null, 4, null);
                }
            }
        }
        markChanged();
    }

    @Store3
    public final void handleGuildRemove(Guild guild) {
        Set<Long> setKeySet;
        Intrinsics3.checkNotNullParameter(guild, "guild");
        long id2 = guild.getId();
        if (this.channelsByGuild.containsKey(Long.valueOf(id2))) {
            Map<Long, Channel> map = this.channelsByGuild.get(Long.valueOf(id2));
            if (map != null && (setKeySet = map.keySet()) != null) {
                Iterator<T> it = setKeySet.iterator();
                while (it.hasNext()) {
                    this.channelNames.remove(Long.valueOf(((Number) it.next()).longValue()));
                }
            }
            this.channelsByGuild.remove(Long.valueOf(guild.getId()));
            MutableCollections.removeAll(this.threadsById.values(), new AnonymousClass2(guild));
        }
        markChanged();
    }

    @Store3
    public final void handleMessagesLoaded(List<Message> messages) {
        Intrinsics3.checkNotNullParameter(messages, "messages");
        Iterator<Message> it = messages.iterator();
        while (it.hasNext()) {
            Channel thread = it.next().getThread();
            if (thread != null) {
                if (!this.threadsById.containsKey(Long.valueOf(thread.getId())) && ChannelUtils.H(thread)) {
                    storeThread$app_productionGoogleRelease$default(this, thread, 0L, null, 6, null);
                    markChanged();
                }
                if (!this.isConnectionOpen) {
                    this.preloadedThreads.put(Long.valueOf(thread.getId()), thread);
                }
            }
        }
    }

    @Store3
    public final void handleSearchFinish(SearchState searchState) {
        Intrinsics3.checkNotNullParameter(searchState, "searchState");
        List<Channel> threads = searchState.getThreads();
        if (threads != null) {
            for (Channel channel : threads) {
                if (!this.threadsById.containsKey(Long.valueOf(channel.getId())) && ChannelUtils.H(channel)) {
                    storeThread$app_productionGoogleRelease$default(this, channel, 0L, null, 6, null);
                    markChanged();
                }
            }
        }
        List<Message> hits = searchState.getHits();
        if (hits != null) {
            Iterator<T> it = hits.iterator();
            while (it.hasNext()) {
                Channel thread = ((Message) it.next()).getThread();
                if (thread != null && !this.threadsById.containsKey(Long.valueOf(thread.getId())) && ChannelUtils.H(thread)) {
                    storeThread$app_productionGoogleRelease$default(this, thread, 0L, null, 6, null);
                    markChanged();
                }
            }
        }
    }

    @Store3
    public final void handleStoreInitTimeout() {
        this.isStoreInitTimedOut = true;
        updateInitializationState();
    }

    @Store3
    public final void handleThreadCreateOrUpdate(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (ChannelUtils.H(channel)) {
            handleChannelOrThreadCreateOrUpdate(channel);
        }
    }

    @Store3
    public final void handleThreadListSync(ModelThreadListSync payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        if (payload.getThreads().isEmpty()) {
            return;
        }
        for (Channel channel : payload.getThreads()) {
            if (ChannelUtils.H(channel)) {
                storeThread$app_productionGoogleRelease$default(this, channel, payload.getGuildId(), null, 4, null);
            }
        }
        markChanged();
    }

    @Store3
    public final void init() {
        List listFilterNotNull = _Collections.filterNotNull(this.channelsCache.get());
        Map<Long, Map<Long, Channel>> map = this.channelsByGuild;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : listFilterNotNull) {
            Long lValueOf = Long.valueOf(((Channel) obj).getGuildId());
            Object arrayList = linkedHashMap.get(lValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(lValueOf, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsJVM.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            List list = (List) entry.getValue();
            HashMap map2 = new HashMap();
            for (Object obj2 : list) {
                map2.put(Long.valueOf(((Channel) obj2).getId()), obj2);
            }
            linkedHashMap2.put(key, map2);
        }
        map.putAll(linkedHashMap2);
        updateInitializationState();
        markChanged();
    }

    public final Observable<Map<Long, Channel>> observeAllChannels() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Channel> observeChannel(long channelId) {
        Observable<Channel> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(channelId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<List<Channel>> observeChannelCategories(long guildId) {
        Observable<List<Channel>> observableR = observeChannelsForGuild$default(this, guildId, null, 2, null).G(new Func1<Map<Long, ? extends Channel>, List<? extends Channel>>() { // from class: com.discord.stores.StoreChannels.observeChannelCategories.1
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ List<? extends Channel> call(Map<Long, ? extends Channel> map) {
                return call2((Map<Long, Channel>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<Channel> call2(Map<Long, Channel> map) {
                Collection<Channel> collectionValues = map.values();
                ArrayList arrayList = new ArrayList();
                for (T t : collectionValues) {
                    if (ChannelUtils.k((Channel) t)) {
                        arrayList.add(t);
                    }
                }
                return arrayList;
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeChannelsForGuild(…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Channel>> observeChannelsForGuild(long j) {
        return observeChannelsForGuild$default(this, j, null, 2, null);
    }

    public final Observable<Map<Long, Channel>> observeChannelsForGuild(final long guildId, final Integer type) {
        Observable<Map<Long, Channel>> observableR = observeGuildAndPrivateChannels().Y(new Func1<Map<Long, ? extends Channel>, Observable<? extends Map<Long, ? extends Channel>>>() { // from class: com.discord.stores.StoreChannels.observeChannelsForGuild.1
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends Channel>> call(Map<Long, ? extends Channel> map) {
                return call2((Map<Long, Channel>) map);
            }

            /* JADX WARN: Code duplicated, block: B:15:0x0043  */
            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Map<Long, Channel>> call2(Map<Long, Channel> map) {
                boolean z2;
                Intrinsics3.checkNotNullExpressionValue(map, "channels");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<Long, Channel> entry : map.entrySet()) {
                    Channel value = entry.getValue();
                    if (value.getGuildId() != guildId) {
                        z2 = false;
                    } else {
                        if (type != null) {
                            int type2 = value.getType();
                            Integer num = type;
                            if (num == null || type2 != num.intValue()) {
                                z2 = false;
                            }
                        }
                        z2 = true;
                    }
                    if (z2) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                return new ScalarSynchronousObservable(linkedHashMap);
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeGuildAndPrivateCh…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<List<Channel>> observeDMs() {
        Observable observableG = observePrivateChannels().G(new Func1<Map<Long, ? extends Channel>, List<? extends Channel>>() { // from class: com.discord.stores.StoreChannels.observeDMs.1
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ List<? extends Channel> call(Map<Long, ? extends Channel> map) {
                return call2((Map<Long, Channel>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<Channel> call2(Map<Long, Channel> map) {
                Collection<Channel> collectionValues = map.values();
                ArrayList arrayList = new ArrayList();
                for (T t : collectionValues) {
                    if (ChannelUtils.m((Channel) t)) {
                        arrayList.add(t);
                    }
                }
                return arrayList;
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "observePrivateChannels()…nel -> channel.isDM() } }");
        return observableG;
    }

    public final Observable<Channel> observeDefaultChannel(final long guildId) {
        Observable<Channel> observableR = this.observeChannelPermissionsForGuild.invoke(Long.valueOf(guildId)).Y(new Func1<Map<Long, ? extends Long>, Observable<? extends Channel>>() { // from class: com.discord.stores.StoreChannels.observeDefaultChannel.1
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends Channel> call(Map<Long, ? extends Long> map) {
                return call2((Map<Long, Long>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Channel> call2(final Map<Long, Long> map) {
                return StoreChannels.this.observeChannelsForGuild(guildId, 0).G(new Func1<Map<Long, ? extends Channel>, Channel>() { // from class: com.discord.stores.StoreChannels.observeDefaultChannel.1.1

                    /* JADX INFO: renamed from: com.discord.stores.StoreChannels$observeDefaultChannel$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: StoreChannels.kt */
                    public static final class C01051 extends Lambda implements Function1<Channel, Boolean> {
                        public C01051() {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
                            return Boolean.valueOf(invoke2(channel));
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final boolean invoke2(Channel channel) {
                            Intrinsics3.checkNotNullParameter(channel, "channel");
                            return PermissionUtils.can(Permission.VIEW_CHANNEL, (Long) outline.d(channel, map));
                        }
                    }

                    @Override // j0.k.Func1
                    public /* bridge */ /* synthetic */ Channel call(Map<Long, ? extends Channel> map2) {
                        return call2((Map<Long, Channel>) map2);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final Channel call2(Map<Long, Channel> map2) {
                        return (Channel) _Sequences2.firstOrNull(_Sequences2.sortedWith(_Sequences2.filter(_Collections.asSequence(map2.values()), new C01051()), ChannelUtils.h(Channel.INSTANCE)));
                    }
                });
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeChannelPermission…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<List<Channel>> observeDirectShareCandidates(final Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Observable observableG = observeGuildAndPrivateChannels().y(new Func1<Map<Long, ? extends Channel>, Boolean>() { // from class: com.discord.stores.StoreChannels.observeDirectShareCandidates.1
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Boolean call(Map<Long, ? extends Channel> map) {
                return call2((Map<Long, Channel>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Map<Long, Channel> map) {
                Intrinsics3.checkNotNullExpressionValue(map, "it");
                return Boolean.valueOf(!map.isEmpty());
            }
        }).G(new Func1<Map<Long, ? extends Channel>, List<? extends Channel>>() { // from class: com.discord.stores.StoreChannels.observeDirectShareCandidates.2
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ List<? extends Channel> call(Map<Long, ? extends Channel> map) {
                return call2((Map<Long, Channel>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<Channel> call2(Map<Long, Channel> map) {
                Collection sortedKeys$default = FrecencyTracker.getSortedKeys$default(StoreStream.INSTANCE.getChannelsSelected().getFrecency(), 0L, 1, null);
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = sortedKeys$default.iterator();
                while (it.hasNext()) {
                    Channel channel = map.get(Long.valueOf(((Number) it.next()).longValue()));
                    if (channel != null) {
                        arrayList.add(channel);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (T t : arrayList) {
                    if (ChannelUtils.m((Channel) t)) {
                        arrayList2.add(t);
                    }
                }
                return _Collections.take(arrayList2, ShortcutManagerCompat.getMaxShortcutCountPerActivity(context));
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "observeGuildAndPrivateCh…ity(context))\n          }");
        return observableG;
    }

    public final Observable<Map<Long, Channel>> observeGuildAndPrivateChannels() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Map<Long, List<Long>>> observeIds(boolean includeThreads) {
        Observable<Map<Long, List<Long>>> observableR = (includeThreads ? observeAllChannels() : observeGuildAndPrivateChannels()).G(new Func1<Map<Long, ? extends Channel>, Map<Long, ? extends List<? extends Long>>>() { // from class: com.discord.stores.StoreChannels.observeIds.1
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Map<Long, ? extends List<? extends Long>> call(Map<Long, ? extends Channel> map) {
                return call2((Map<Long, Channel>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Map<Long, List<Long>> call2(Map<Long, Channel> map) {
                Collection<Channel> collectionValues = map.values();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (T t : collectionValues) {
                    Long lValueOf = Long.valueOf(((Channel) t).getGuildId());
                    Object arrayList = linkedHashMap.get(lValueOf);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        linkedHashMap.put(lValueOf, arrayList);
                    }
                    ((List) arrayList).add(t);
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsJVM.mapCapacity(linkedHashMap.size()));
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    Object key = entry.getKey();
                    List list = (List) entry.getValue();
                    ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(Long.valueOf(((Channel) it.next()).getId()));
                    }
                    linkedHashMap2.put(key, arrayList2);
                }
                return linkedHashMap2;
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "channelsObservable\n     …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> observeInitializedForAuthedUser() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{InitializedUpdateSource}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Map<Long, String>> observeNames() {
        Observable<Map<Long, String>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Channel> observePrivateChannel(final long channelId) {
        Observable<Channel> observableR = observePrivateChannels().G(new Func1<Map<Long, ? extends Channel>, Channel>() { // from class: com.discord.stores.StoreChannels.observePrivateChannel.1
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Channel call(Map<Long, ? extends Channel> map) {
                return call2((Map<Long, Channel>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Channel call2(Map<Long, Channel> map) {
                return map.get(Long.valueOf(channelId));
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observePrivateChannels()…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Channel>> observePrivateChannels() {
        return observeChannelsForGuild$default(this, 0L, null, 2, null);
    }

    public final Observable<Map<Long, Channel>> observeThreadsFromMessages(List<Message> messages) {
        Intrinsics3.checkNotNullParameter(messages, "messages");
        Observable<Map<Long, Channel>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(messages), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final void onGroupCreated(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.dispatcher.schedule(new AnonymousClass1(channel));
    }

    public final void setInitializedForAuthedUser$app_productionGoogleRelease(boolean z2) {
        this.initializedForAuthedUser = z2;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        Collection<Map<Long, Channel>> collectionValues = this.channelsByGuild.values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            MutableCollections.addAll(arrayList, ((Map) it.next()).values());
        }
        List<Long> listInvoke = this.getLurkingGuildIds.invoke();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it2 = listInvoke.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Map<Long, Channel> map = this.channelsByGuild.get(Long.valueOf(((Number) it2.next()).longValue()));
            Set<Long> setKeySet = map != null ? map.keySet() : null;
            if (setKeySet != null) {
                arrayList2.add(setKeySet);
            }
        }
        List listFlatten = Iterables2.flatten(arrayList2);
        Persister<List<Channel>> persister = this.channelsCache;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList) {
            if (!listFlatten.contains(Long.valueOf(((Channel) obj).getId()))) {
                arrayList3.add(obj);
            }
        }
        Persister.set$default(persister, arrayList3, false, 2, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj2 : arrayList) {
            linkedHashMap.put(Long.valueOf(((Channel) obj2).getId()), obj2);
        }
        this.channelsByIdSnapshot = linkedHashMap;
        Map<Long, Map<Long, Channel>> map2 = this.channelsByGuild;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsJVM.mapCapacity(map2.size()));
        Iterator<T> it3 = map2.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            linkedHashMap2.put(entry.getKey(), CollectionExtensions.snapshot$default((Map) entry.getValue(), 0, 0.0f, 3, null));
        }
        this.channelsByGuildSnapshot = linkedHashMap2;
        this.channelNamesSnapshot = CollectionExtensions.snapshot$default(this.channelNames, 0, 0.0f, 3, null);
        this.threadsByIdSnapshot = CollectionExtensions.snapshot$default(this.threadsById, 0, 0.0f, 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003e  */
    /* JADX WARN: Code duplicated, block: B:15:0x0043  */
    @Store3
    public final void storeThread$app_productionGoogleRelease(Channel thread, long fallbackGuildId, Channel parentChannel) {
        Boolean boolValueOf;
        boolean nsfw;
        boolean nsfw2;
        Intrinsics3.checkNotNullParameter(thread, "thread");
        long guildId = thread.getGuildId() != 0 ? thread.getGuildId() : fallbackGuildId;
        if (parentChannel == null) {
            Channel channelInternal$app_productionGoogleRelease = getChannelInternal$app_productionGoogleRelease(thread.getGuildId(), thread.getParentId());
            if (channelInternal$app_productionGoogleRelease != null) {
                nsfw = channelInternal$app_productionGoogleRelease.getNsfw();
            } else {
                boolValueOf = null;
            }
            if (boolValueOf != null) {
                nsfw2 = boolValueOf.booleanValue();
            } else {
                nsfw2 = thread.getNsfw();
            }
            this.threadsById.put(Long.valueOf(thread.getId()), Channel.a(thread, null, 0, guildId, null, 0L, 0L, 0L, null, null, 0, null, 0, 0, null, 0L, 0L, null, nsfw2, 0L, null, 0, null, null, null, null, null, null, null, null, null, null, null, -131077));
            this.channelNames.put(Long.valueOf(thread.getId()), ChannelUtils.c(thread));
        }
        nsfw = parentChannel.getNsfw();
        boolValueOf = Boolean.valueOf(nsfw);
        if (boolValueOf != null) {
            nsfw2 = boolValueOf.booleanValue();
        } else {
            nsfw2 = thread.getNsfw();
        }
        this.threadsById.put(Long.valueOf(thread.getId()), Channel.a(thread, null, 0, guildId, null, 0L, 0L, 0L, null, null, 0, null, 0, 0, null, 0L, 0L, null, nsfw2, 0L, null, 0, null, null, null, null, null, null, null, null, null, null, null, -131077));
        this.channelNames.put(Long.valueOf(thread.getId()), ChannelUtils.c(thread));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreChannels(Dispatcher dispatcher, ObservationDeck observationDeck, Function1<? super Long, ? extends Observable<Map<Long, Long>>> function1, Function0<? extends List<Long>> function0, Function0<Boolean> function2, Persister<List<Channel>> persister) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(function1, "observeChannelPermissionsForGuild");
        Intrinsics3.checkNotNullParameter(function0, "getLurkingGuildIds");
        Intrinsics3.checkNotNullParameter(function2, "isAuthenticated");
        Intrinsics3.checkNotNullParameter(persister, "channelsCache");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.observeChannelPermissionsForGuild = function1;
        this.getLurkingGuildIds = function0;
        this.isAuthenticated = function2;
        this.channelsCache = persister;
        this.channelsByIdSnapshot = new HashMap();
        this.channelNamesSnapshot = new HashMap();
        this.channelNames = new HashMap();
        this.channelsByGuildSnapshot = Maps6.emptyMap();
        HashMap map = new HashMap();
        this.channelsByGuild = map;
        this.threadsByIdSnapshot = new HashMap();
        this.threadsById = new HashMap();
        this.preloadedThreads = new HashMap();
        map.put(0L, new HashMap());
    }

    public final Observable<Map<Long, String>> observeNames(Collection<Long> channelIds) {
        Intrinsics3.checkNotNullParameter(channelIds, "channelIds");
        Observable observableK = observeNames().k(o.a(channelIds));
        Intrinsics3.checkNotNullExpressionValue(observableK, "observeNames().compose(A…rs.filterMap(channelIds))");
        return observableK;
    }
}
