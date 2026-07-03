package com.discord.stores;

import android.content.Context;
import androidx.core.content.p004pm.ShortcutManagerCompat;
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
import com.discord.utilities.collections.CollectionExtensionsKt;
import com.discord.utilities.frecency.FrecencyTracker;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.search.network.state.SearchState;
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
import p007b.p008a.p018d.C0879o;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p578f0.C12078q;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12160r;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannels extends StoreV2 {
    private static final StoreChannels$Companion$InitializedUpdateSource$1 InitializedUpdateSource = new ObservationDeck.UpdateSource() { // from class: com.discord.stores.StoreChannels$Companion$InitializedUpdateSource$1
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

    /* JADX INFO: renamed from: com.discord.stores.StoreChannels$handleGuildRemove$2 */
    /* JADX INFO: compiled from: StoreChannels.kt */
    public static final class C58162 extends AbstractC12240o implements Function1<Channel, Boolean> {
        public final /* synthetic */ Guild $guild;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58162(Guild guild) {
            super(1);
            this.$guild = guild;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
            return Boolean.valueOf(invoke2(channel));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Channel channel) {
            C12238m.checkNotNullParameter(channel, "thread");
            return channel.getGuildId() == this.$guild.getId();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChannels$observeAllChannels$1 */
    /* JADX INFO: compiled from: StoreChannels.kt */
    public static final class C58171 extends AbstractC12240o implements Function0<Map<Long, ? extends Channel>> {
        public C58171() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Channel> invoke() {
            return C12136h0.plus(StoreChannels.this.channelsByIdSnapshot, StoreChannels.this.threadsByIdSnapshot);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChannels$observeChannel$1 */
    /* JADX INFO: compiled from: StoreChannels.kt */
    public static final class C58181 extends AbstractC12240o implements Function0<Channel> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58181(long j) {
            super(0);
            this.$channelId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Channel invoke() {
            return StoreChannels.this.getChannel(this.$channelId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChannels$observeGuildAndPrivateChannels$1 */
    /* JADX INFO: compiled from: StoreChannels.kt */
    public static final class C58251 extends AbstractC12240o implements Function0<Map<Long, ? extends Channel>> {
        public C58251() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Channel> invoke() {
            return StoreChannels.this.channelsByIdSnapshot;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChannels$observeInitializedForAuthedUser$1 */
    /* JADX INFO: compiled from: StoreChannels.kt */
    public static final class C58271 extends AbstractC12240o implements Function0<Boolean> {
        public C58271() {
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

    /* JADX INFO: renamed from: com.discord.stores.StoreChannels$observeNames$1 */
    /* JADX INFO: compiled from: StoreChannels.kt */
    public static final class C58281 extends AbstractC12240o implements Function0<Map<Long, ? extends String>> {
        public C58281() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends String> invoke() {
            return StoreChannels.this.channelNamesSnapshot;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChannels$observeThreadsFromMessages$1 */
    /* JADX INFO: compiled from: StoreChannels.kt */
    public static final class C58301 extends AbstractC12240o implements Function0<Map<Long, ? extends Channel>> {
        public final /* synthetic */ List $messages;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58301(List list) {
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
            LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(arrayList2, 10)), 16));
            for (Object obj2 : arrayList2) {
                linkedHashMap.put(Long.valueOf(((Channel) obj2).getId()), obj2);
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChannels$onGroupCreated$1 */
    /* JADX INFO: compiled from: StoreChannels.kt */
    public static final class C58311 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ Channel $channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58311(Channel channel) {
            super(0);
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
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

    @StoreThread
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

    @StoreThread
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

    @StoreThread
    public final List<Channel> findChannelsByCategoryInternal$app_productionGoogleRelease(long guildId, long categoryId) {
        Collection<Channel> collectionValues;
        Map<Long, Channel> map = this.channelsByGuild.get(Long.valueOf(guildId));
        if (map == null || (collectionValues = map.values()) == null) {
            return C12147n.emptyList();
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

    @StoreThread
    public final Channel getChannelInternal$app_productionGoogleRelease(long guildId, long channelId) {
        Channel channel;
        Map<Long, Channel> map = this.channelsByGuild.get(Long.valueOf(guildId));
        return (map == null || (channel = map.get(Long.valueOf(channelId))) == null) ? this.threadsById.get(Long.valueOf(channelId)) : channel;
    }

    public final Map<Long, String> getChannelNames() {
        return this.channelNamesSnapshot;
    }

    @StoreThread
    public final Map<Long, String> getChannelNamesInternal$app_productionGoogleRelease() {
        return this.channelNames;
    }

    @StoreThread
    public final Map<Long, Map<Long, Channel>> getChannelsByGuildInternal$app_productionGoogleRelease() {
        return this.channelsByGuild;
    }

    @StoreThread
    public final Map<Long, Channel> getChannelsByIdInternal$app_productionGoogleRelease() {
        Collection<Map<Long, Channel>> collectionValues = this.channelsByGuild.values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            C12160r.addAll(arrayList, ((Map) it.next()).values());
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            linkedHashMap.put(Long.valueOf(((Channel) obj).getId()), obj);
        }
        return linkedHashMap;
    }

    public final Map<Long, Channel> getChannelsForGuild(long guildId) {
        Map<Long, Channel> map = this.channelsByGuildSnapshot.get(Long.valueOf(guildId));
        return map != null ? map : C12136h0.emptyMap();
    }

    @StoreThread
    public final Map<Long, Channel> getChannelsForGuildInternal$app_productionGoogleRelease(long guildId) {
        return this.channelsByGuild.get(Long.valueOf(guildId));
    }

    @StoreThread
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

    @StoreThread
    public final Map<Long, Channel> getThreadsByIdInternal$app_productionGoogleRelease() {
        return this.threadsById;
    }

    @StoreThread
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

    @StoreThread
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

    @StoreThread
    public final void handleChannelOrThreadCreateOrUpdate(Channel channel) {
        C12238m.checkNotNullParameter(channel, "channel");
        if (ChannelUtils.m7701y(channel)) {
            return;
        }
        long guildId = !ChannelUtils.m7667B(channel) ? channel.getGuildId() : 0L;
        long id2 = channel.getId();
        if (ChannelUtils.m7673H(channel)) {
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
            if (!C12238m.areEqual(channel, channel2)) {
                if (channel2 != null) {
                    map3.put(Long.valueOf(id2), Channel.m7629a(channel, null, 0, channel.getGuildId() != 0 ? channel.getGuildId() : guildId, null, 0L, 0L, 0L, null, channel2.m7659z(), 0, null, 0, 0, null, 0L, 0L, null, false, 0L, null, 0, null, null, null, null, null, null, null, null, null, null, null, -261));
                } else {
                    map3.put(Long.valueOf(id2), Channel.m7629a(channel, null, 0, channel.getGuildId() != 0 ? channel.getGuildId() : guildId, null, 0L, 0L, 0L, null, null, 0, null, 0, 0, null, 0L, 0L, null, false, 0L, null, 0, null, null, null, null, null, null, null, null, null, null, null, -5));
                }
            }
            boolean nsfw = channel.getNsfw();
            if (channel2 == null || nsfw != channel2.getNsfw()) {
                Iterator<T> it = getThreadsForChannelInternal$app_productionGoogleRelease(channel.getId()).iterator();
                while (it.hasNext()) {
                    storeThread$app_productionGoogleRelease((Channel) it.next(), guildId, channel);
                }
            }
            this.channelNames.put(Long.valueOf(id2), ChannelUtils.m7679c(channel));
        }
        markChanged();
    }

    @StoreThread
    public final void handleChannelOrThreadDelete(Channel channel) {
        Map<Long, Channel> map;
        C12238m.checkNotNullParameter(channel, "channel");
        long guildId = !ChannelUtils.m7667B(channel) ? channel.getGuildId() : 0L;
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

    @StoreThread
    public final void handleConnected(boolean connected) {
        this.isConnectionOpen = connected;
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        C12238m.checkNotNullParameter(payload, "payload");
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
        ArrayList<Channel> arrayListM840a0 = C1643a.m840a0(privateChannels, "payload.privateChannels");
        for (Object obj : privateChannels) {
            Channel channel = (Channel) obj;
            C12238m.checkNotNullExpressionValue(channel, "it");
            if (!ChannelUtils.m7701y(channel)) {
                arrayListM840a0.add(obj);
            }
        }
        for (Channel channel2 : arrayListM840a0) {
            Long lValueOf = Long.valueOf(channel2.getId());
            C12238m.checkNotNullExpressionValue(channel2, "privateChannel");
            map3.put(lValueOf, channel2);
        }
        List<Guild> guilds = payload.getGuilds();
        C12238m.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            Map<Long, Map<Long, Channel>> map4 = this.channelsByGuild;
            Long lValueOf2 = Long.valueOf(guild.getId());
            Map<Long, Channel> map5 = map4.get(lValueOf2);
            if (map5 == null) {
                map5 = new HashMap<>();
                map4.put(lValueOf2, map5);
            }
            Map<Long, Channel> map6 = map5;
            List<Channel> listM7860g = guild.m7860g();
            if (listM7860g != null) {
                for (Channel channel3 : listM7860g) {
                    map6.put(Long.valueOf(channel3.getId()), Channel.m7629a(channel3, null, 0, channel3.getGuildId() != 0 ? channel3.getGuildId() : guild.getId(), null, 0L, 0L, 0L, null, null, 0, null, 0, 0, null, 0L, 0L, null, false, 0L, null, 0, null, null, null, null, null, null, null, null, null, null, null, -5));
                }
            }
            List<Channel> listM7849N = guild.m7849N();
            if (listM7849N != null) {
                for (Channel channel4 : listM7849N) {
                    if (ChannelUtils.m7673H(channel4)) {
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
                map7.put((Long) entry.getKey(), ChannelUtils.m7679c((Channel) entry.getValue()));
            }
        }
        this.handledReadyPayload = true;
        updateInitializationState();
        markChanged();
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00f3  */
    @StoreThread
    public final void handleGroupDMRecipient(ChannelRecipient recipient, boolean add) {
        ArrayList arrayList;
        List<ChannelRecipientNick> listM7650q;
        ArrayList arrayList2;
        C12238m.checkNotNullParameter(recipient, "recipient");
        Map<Long, Channel> map = this.channelsByGuild.get(0L);
        if (map != null) {
            long jM7660a = recipient.getChannelId();
            Channel channel = map.get(Long.valueOf(jM7660a));
            if (channel != null) {
                long guildId = channel.getGuildId();
                if (add) {
                    List<User> listM7659z = channel.m7659z();
                    ArrayList arrayList3 = listM7659z != null ? new ArrayList(listM7659z) : new ArrayList();
                    arrayList3.add(recipient.getUser());
                    arrayList = arrayList3;
                } else {
                    ArrayList arrayList4 = new ArrayList();
                    List<User> listM7659z2 = channel.m7659z();
                    if (listM7659z2 == null) {
                        listM7659z2 = C12147n.emptyList();
                    }
                    for (User user : listM7659z2) {
                        if (user.getId() != recipient.getUser().getId()) {
                            arrayList4.add(user);
                        }
                    }
                    arrayList = arrayList4;
                }
                long guildId2 = channel.getGuildId() != 0 ? channel.getGuildId() : guildId;
                String strM7661b = recipient.getNick();
                if (strM7661b == null) {
                    listM7650q = channel.m7650q();
                } else {
                    List<ChannelRecipientNick> listM7650q2 = channel.m7650q();
                    if (listM7650q2 != null) {
                        arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(listM7650q2, 10));
                        for (ChannelRecipientNick channelRecipientNick : listM7650q2) {
                            if (channelRecipientNick.m7664b() == recipient.getUser().getId()) {
                                channelRecipientNick = new ChannelRecipientNick(recipient.getUser().getId(), strM7661b);
                            }
                            arrayList2.add(channelRecipientNick);
                        }
                    } else {
                        arrayList2 = null;
                    }
                    if (arrayList2 != null) {
                        listM7650q = arrayList2;
                    } else {
                        listM7650q = channel.m7650q();
                    }
                }
                Channel channelM7629a = Channel.m7629a(channel, null, 0, guildId2, null, 0L, 0L, 0L, null, arrayList, 0, null, 0, 0, null, 0L, 0L, listM7650q, false, 0L, null, 0, null, null, null, null, null, null, null, null, null, null, null, -65797);
                Map<Long, Channel> map2 = this.channelsByGuild.get(Long.valueOf(guildId));
                if (map2 != null) {
                    map2.put(Long.valueOf(jM7660a), channelM7629a);
                }
                markChanged();
            }
        }
    }

    @StoreThread
    public final void handleGuildAdd(Guild guild) {
        C12238m.checkNotNullParameter(guild, "guild");
        Map<Long, Map<Long, Channel>> map = this.channelsByGuild;
        Long lValueOf = Long.valueOf(guild.getId());
        Map<Long, Channel> map2 = map.get(lValueOf);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(lValueOf, map2);
        }
        Map<Long, Channel> map3 = map2;
        List<Channel> listM7860g = guild.m7860g();
        if (listM7860g != null) {
            for (Channel channel : listM7860g) {
                map3.put(Long.valueOf(channel.getId()), Channel.m7629a(channel, null, 0, channel.getGuildId() != 0 ? channel.getGuildId() : guild.getId(), null, 0L, 0L, 0L, null, null, 0, null, 0, 0, null, 0L, 0L, null, false, 0L, null, 0, null, null, null, null, null, null, null, null, null, null, null, -5));
                this.channelNames.put(Long.valueOf(channel.getId()), ChannelUtils.m7679c(channel));
            }
        }
        List<Channel> listM7849N = guild.m7849N();
        if (listM7849N != null) {
            for (Channel channel2 : listM7849N) {
                if (ChannelUtils.m7673H(channel2)) {
                    storeThread$app_productionGoogleRelease$default(this, channel2, guild.getId(), null, 4, null);
                }
            }
        }
        markChanged();
    }

    @StoreThread
    public final void handleGuildRemove(Guild guild) {
        Set<Long> setKeySet;
        C12238m.checkNotNullParameter(guild, "guild");
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
            C12160r.removeAll(this.threadsById.values(), new C58162(guild));
        }
        markChanged();
    }

    @StoreThread
    public final void handleMessagesLoaded(List<Message> messages) {
        C12238m.checkNotNullParameter(messages, "messages");
        Iterator<Message> it = messages.iterator();
        while (it.hasNext()) {
            Channel thread = it.next().getThread();
            if (thread != null) {
                if (!this.threadsById.containsKey(Long.valueOf(thread.getId())) && ChannelUtils.m7673H(thread)) {
                    storeThread$app_productionGoogleRelease$default(this, thread, 0L, null, 6, null);
                    markChanged();
                }
                if (!this.isConnectionOpen) {
                    this.preloadedThreads.put(Long.valueOf(thread.getId()), thread);
                }
            }
        }
    }

    @StoreThread
    public final void handleSearchFinish(SearchState searchState) {
        C12238m.checkNotNullParameter(searchState, "searchState");
        List<Channel> threads = searchState.getThreads();
        if (threads != null) {
            for (Channel channel : threads) {
                if (!this.threadsById.containsKey(Long.valueOf(channel.getId())) && ChannelUtils.m7673H(channel)) {
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
                if (thread != null && !this.threadsById.containsKey(Long.valueOf(thread.getId())) && ChannelUtils.m7673H(thread)) {
                    storeThread$app_productionGoogleRelease$default(this, thread, 0L, null, 6, null);
                    markChanged();
                }
            }
        }
    }

    @StoreThread
    public final void handleStoreInitTimeout() {
        this.isStoreInitTimedOut = true;
        updateInitializationState();
    }

    @StoreThread
    public final void handleThreadCreateOrUpdate(Channel channel) {
        C12238m.checkNotNullParameter(channel, "channel");
        if (ChannelUtils.m7673H(channel)) {
            handleChannelOrThreadCreateOrUpdate(channel);
        }
    }

    @StoreThread
    public final void handleThreadListSync(ModelThreadListSync payload) {
        C12238m.checkNotNullParameter(payload, "payload");
        if (payload.getThreads().isEmpty()) {
            return;
        }
        for (Channel channel : payload.getThreads()) {
            if (ChannelUtils.m7673H(channel)) {
                storeThread$app_productionGoogleRelease$default(this, channel, payload.getGuildId(), null, 4, null);
            }
        }
        markChanged();
    }

    @StoreThread
    public final void init() {
        List listFilterNotNull = C12163u.filterNotNull(this.channelsCache.get());
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
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(C12134g0.mapCapacity(linkedHashMap.size()));
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
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C58171(), 14, null);
    }

    public final Observable<Channel> observeChannel(long channelId) {
        Observable<Channel> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C58181(channelId), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck\n        …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<List<Channel>> observeChannelCategories(long guildId) {
        Observable<List<Channel>> observableM11112r = observeChannelsForGuild$default(this, guildId, null, 2, null).m11083G(new InterfaceC12589b<Map<Long, ? extends Channel>, List<? extends Channel>>() { // from class: com.discord.stores.StoreChannels.observeChannelCategories.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ List<? extends Channel> call(Map<Long, ? extends Channel> map) {
                return call2((Map<Long, Channel>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<Channel> call2(Map<Long, Channel> map) {
                Collection<Channel> collectionValues = map.values();
                ArrayList arrayList = new ArrayList();
                for (T t : collectionValues) {
                    if (ChannelUtils.m7687k((Channel) t)) {
                        arrayList.add(t);
                    }
                }
                return arrayList;
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observeChannelsForGuild(…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<Long, Channel>> observeChannelsForGuild(long j) {
        return observeChannelsForGuild$default(this, j, null, 2, null);
    }

    public final Observable<Map<Long, Channel>> observeChannelsForGuild(final long guildId, final Integer type) {
        Observable<Map<Long, Channel>> observableM11112r = observeGuildAndPrivateChannels().m11099Y(new InterfaceC12589b<Map<Long, ? extends Channel>, Observable<? extends Map<Long, ? extends Channel>>>() { // from class: com.discord.stores.StoreChannels.observeChannelsForGuild.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends Channel>> call(Map<Long, ? extends Channel> map) {
                return call2((Map<Long, Channel>) map);
            }

            /* JADX WARN: Code duplicated, block: B:15:0x0043  */
            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Map<Long, Channel>> call2(Map<Long, Channel> map) {
                boolean z2;
                C12238m.checkNotNullExpressionValue(map, "channels");
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
                return new C12721k(linkedHashMap);
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observeGuildAndPrivateCh…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<List<Channel>> observeDMs() {
        Observable observableM11083G = observePrivateChannels().m11083G(new InterfaceC12589b<Map<Long, ? extends Channel>, List<? extends Channel>>() { // from class: com.discord.stores.StoreChannels.observeDMs.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ List<? extends Channel> call(Map<Long, ? extends Channel> map) {
                return call2((Map<Long, Channel>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<Channel> call2(Map<Long, Channel> map) {
                Collection<Channel> collectionValues = map.values();
                ArrayList arrayList = new ArrayList();
                for (T t : collectionValues) {
                    if (ChannelUtils.m7689m((Channel) t)) {
                        arrayList.add(t);
                    }
                }
                return arrayList;
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "observePrivateChannels()…nel -> channel.isDM() } }");
        return observableM11083G;
    }

    public final Observable<Channel> observeDefaultChannel(final long guildId) {
        Observable<Channel> observableM11112r = this.observeChannelPermissionsForGuild.invoke(Long.valueOf(guildId)).m11099Y(new InterfaceC12589b<Map<Long, ? extends Long>, Observable<? extends Channel>>() { // from class: com.discord.stores.StoreChannels.observeDefaultChannel.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Observable<? extends Channel> call(Map<Long, ? extends Long> map) {
                return call2((Map<Long, Long>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Channel> call2(final Map<Long, Long> map) {
                return StoreChannels.this.observeChannelsForGuild(guildId, 0).m11083G(new InterfaceC12589b<Map<Long, ? extends Channel>, Channel>() { // from class: com.discord.stores.StoreChannels.observeDefaultChannel.1.1

                    /* JADX INFO: renamed from: com.discord.stores.StoreChannels$observeDefaultChannel$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: StoreChannels.kt */
                    public static final class C132521 extends AbstractC12240o implements Function1<Channel, Boolean> {
                        public C132521() {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
                            return Boolean.valueOf(invoke2(channel));
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final boolean invoke2(Channel channel) {
                            C12238m.checkNotNullParameter(channel, "channel");
                            return PermissionUtils.can(Permission.VIEW_CHANNEL, (Long) C1643a.m845d(channel, map));
                        }
                    }

                    @Override // p637j0.p641k.InterfaceC12589b
                    public /* bridge */ /* synthetic */ Channel call(Map<Long, ? extends Channel> map2) {
                        return call2((Map<Long, Channel>) map2);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final Channel call2(Map<Long, Channel> map2) {
                        return (Channel) C12078q.firstOrNull(C12078q.sortedWith(C12078q.filter(C12163u.asSequence(map2.values()), new C132521()), ChannelUtils.m7684h(Channel.INSTANCE)));
                    }
                });
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observeChannelPermission…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<List<Channel>> observeDirectShareCandidates(final Context context) {
        C12238m.checkNotNullParameter(context, "context");
        Observable observableM11083G = observeGuildAndPrivateChannels().m11118y(new InterfaceC12589b<Map<Long, ? extends Channel>, Boolean>() { // from class: com.discord.stores.StoreChannels.observeDirectShareCandidates.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Boolean call(Map<Long, ? extends Channel> map) {
                return call2((Map<Long, Channel>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Map<Long, Channel> map) {
                C12238m.checkNotNullExpressionValue(map, "it");
                return Boolean.valueOf(!map.isEmpty());
            }
        }).m11083G(new InterfaceC12589b<Map<Long, ? extends Channel>, List<? extends Channel>>() { // from class: com.discord.stores.StoreChannels.observeDirectShareCandidates.2
            @Override // p637j0.p641k.InterfaceC12589b
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
                    if (ChannelUtils.m7689m((Channel) t)) {
                        arrayList2.add(t);
                    }
                }
                return C12163u.take(arrayList2, ShortcutManagerCompat.getMaxShortcutCountPerActivity(context));
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "observeGuildAndPrivateCh…ity(context))\n          }");
        return observableM11083G;
    }

    public final Observable<Map<Long, Channel>> observeGuildAndPrivateChannels() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C58251(), 14, null);
    }

    public final Observable<Map<Long, List<Long>>> observeIds(boolean includeThreads) {
        Observable<Map<Long, List<Long>>> observableM11112r = (includeThreads ? observeAllChannels() : observeGuildAndPrivateChannels()).m11083G(new InterfaceC12589b<Map<Long, ? extends Channel>, Map<Long, ? extends List<? extends Long>>>() { // from class: com.discord.stores.StoreChannels.observeIds.1
            @Override // p637j0.p641k.InterfaceC12589b
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
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(C12134g0.mapCapacity(linkedHashMap.size()));
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    Object key = entry.getKey();
                    List list = (List) entry.getValue();
                    ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(Long.valueOf(((Channel) it.next()).getId()));
                    }
                    linkedHashMap2.put(key, arrayList2);
                }
                return linkedHashMap2;
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "channelsObservable\n     …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Boolean> observeInitializedForAuthedUser() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{InitializedUpdateSource}, false, null, null, new C58271(), 14, null);
    }

    public final Observable<Map<Long, String>> observeNames() {
        Observable<Map<Long, String>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C58281(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck\n        …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Channel> observePrivateChannel(final long channelId) {
        Observable<Channel> observableM11112r = observePrivateChannels().m11083G(new InterfaceC12589b<Map<Long, ? extends Channel>, Channel>() { // from class: com.discord.stores.StoreChannels.observePrivateChannel.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Channel call(Map<Long, ? extends Channel> map) {
                return call2((Map<Long, Channel>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Channel call2(Map<Long, Channel> map) {
                return map.get(Long.valueOf(channelId));
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observePrivateChannels()…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<Long, Channel>> observePrivateChannels() {
        return observeChannelsForGuild$default(this, 0L, null, 2, null);
    }

    public final Observable<Map<Long, Channel>> observeThreadsFromMessages(List<Message> messages) {
        C12238m.checkNotNullParameter(messages, "messages");
        Observable<Map<Long, Channel>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C58301(messages), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck\n        …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final void onGroupCreated(Channel channel) {
        C12238m.checkNotNullParameter(channel, "channel");
        this.dispatcher.schedule(new C58311(channel));
    }

    public final void setInitializedForAuthedUser$app_productionGoogleRelease(boolean z2) {
        this.initializedForAuthedUser = z2;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        Collection<Map<Long, Channel>> collectionValues = this.channelsByGuild.values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            C12160r.addAll(arrayList, ((Map) it.next()).values());
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
        List listFlatten = C12149o.flatten(arrayList2);
        Persister<List<Channel>> persister = this.channelsCache;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList) {
            if (!listFlatten.contains(Long.valueOf(((Channel) obj).getId()))) {
                arrayList3.add(obj);
            }
        }
        Persister.set$default(persister, arrayList3, false, 2, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj2 : arrayList) {
            linkedHashMap.put(Long.valueOf(((Channel) obj2).getId()), obj2);
        }
        this.channelsByIdSnapshot = linkedHashMap;
        Map<Long, Map<Long, Channel>> map2 = this.channelsByGuild;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(C12134g0.mapCapacity(map2.size()));
        Iterator<T> it3 = map2.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            linkedHashMap2.put(entry.getKey(), CollectionExtensionsKt.snapshot$default((Map) entry.getValue(), 0, 0.0f, 3, null));
        }
        this.channelsByGuildSnapshot = linkedHashMap2;
        this.channelNamesSnapshot = CollectionExtensionsKt.snapshot$default(this.channelNames, 0, 0.0f, 3, null);
        this.threadsByIdSnapshot = CollectionExtensionsKt.snapshot$default(this.threadsById, 0, 0.0f, 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003e  */
    /* JADX WARN: Code duplicated, block: B:15:0x0043  */
    @StoreThread
    public final void storeThread$app_productionGoogleRelease(Channel thread, long fallbackGuildId, Channel parentChannel) {
        Boolean boolValueOf;
        boolean nsfw;
        boolean nsfw2;
        C12238m.checkNotNullParameter(thread, "thread");
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
            this.threadsById.put(Long.valueOf(thread.getId()), Channel.m7629a(thread, null, 0, guildId, null, 0L, 0L, 0L, null, null, 0, null, 0, 0, null, 0L, 0L, null, nsfw2, 0L, null, 0, null, null, null, null, null, null, null, null, null, null, null, -131077));
            this.channelNames.put(Long.valueOf(thread.getId()), ChannelUtils.m7679c(thread));
        }
        nsfw = parentChannel.getNsfw();
        boolValueOf = Boolean.valueOf(nsfw);
        if (boolValueOf != null) {
            nsfw2 = boolValueOf.booleanValue();
        } else {
            nsfw2 = thread.getNsfw();
        }
        this.threadsById.put(Long.valueOf(thread.getId()), Channel.m7629a(thread, null, 0, guildId, null, 0L, 0L, 0L, null, null, 0, null, 0, 0, null, 0L, 0L, null, nsfw2, 0L, null, 0, null, null, null, null, null, null, null, null, null, null, null, -131077));
        this.channelNames.put(Long.valueOf(thread.getId()), ChannelUtils.m7679c(thread));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreChannels(Dispatcher dispatcher, ObservationDeck observationDeck, Function1<? super Long, ? extends Observable<Map<Long, Long>>> function1, Function0<? extends List<Long>> function0, Function0<Boolean> function2, Persister<List<Channel>> persister) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(function1, "observeChannelPermissionsForGuild");
        C12238m.checkNotNullParameter(function0, "getLurkingGuildIds");
        C12238m.checkNotNullParameter(function2, "isAuthenticated");
        C12238m.checkNotNullParameter(persister, "channelsCache");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.observeChannelPermissionsForGuild = function1;
        this.getLurkingGuildIds = function0;
        this.isAuthenticated = function2;
        this.channelsCache = persister;
        this.channelsByIdSnapshot = new HashMap();
        this.channelNamesSnapshot = new HashMap();
        this.channelNames = new HashMap();
        this.channelsByGuildSnapshot = C12136h0.emptyMap();
        HashMap map = new HashMap();
        this.channelsByGuild = map;
        this.threadsByIdSnapshot = new HashMap();
        this.threadsById = new HashMap();
        this.preloadedThreads = new HashMap();
        map.put(0L, new HashMap());
    }

    public final Observable<Map<Long, String>> observeNames(Collection<Long> channelIds) {
        C12238m.checkNotNullParameter(channelIds, "channelIds");
        Observable observableM11108k = observeNames().m11108k(C0879o.m175a(channelIds));
        C12238m.checkNotNullExpressionValue(observableM11108k, "observeNames().compose(A…rs.filterMap(channelIds))");
        return observableM11108k;
    }
}
