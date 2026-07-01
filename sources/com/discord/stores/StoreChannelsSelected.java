package com.discord.stores;

import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.frecency.FrecencyTracker;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.user.search.ChannelFrecencyTracker;
import d0.t.g0;
import d0.t.h0;
import d0.t.n0;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: StoreChannelsSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelsSelected extends StoreV2 {
    private static final String CACHE_KEY_SELECTED_CHANNEL_IDS = "CACHE_KEY_SELECTED_CHANNEL_IDS";
    public static final long ID_THREAD_DRAFT = -3;
    public static final long ID_UNAVAILABLE = -1;
    public static final long ID_UNINITIALIZED = -2;
    public static final long ID_UNSELECTED = 0;
    private final Dispatcher dispatcher;
    private final ChannelFrecencyTracker frecency;
    private final Persister<ChannelFrecencyTracker> frecencyCache;
    private boolean handledReadyPayload;
    private boolean initializedForAuthedUser;
    private boolean isStoreInitTimedOut;
    private final ObservationDeck observationDeck;
    private StoreChannelsSelected$ResolvedSelectedChannel previouslySelectedChannel;
    private StoreChannelsSelected$ResolvedSelectedChannel selectedChannel;
    private final Persister<Map<Long, Long>> selectedChannelIdsCache;
    private final StoreChannels storeChannels;
    private final StoreGuildSelected storeGuildSelected;
    private final StorePermissions storePermissions;
    private final StoreStream stream;
    private final Map<Long, StoreChannelsSelected$UserChannelSelection> userChannelSelections;
    private Subscription validateSelectedChannelSubscription;
    public static final StoreChannelsSelected$Companion Companion = new StoreChannelsSelected$Companion(null);
    private static final StoreChannelsSelected$Companion$InitializedUpdateSource$1 InitializedUpdateSource = new StoreChannelsSelected$Companion$InitializedUpdateSource$1();

    public StoreChannelsSelected(StoreStream storeStream, StoreChannels storeChannels, StorePermissions storePermissions, StoreGuildSelected storeGuildSelected, Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeStream, "stream");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storePermissions, "storePermissions");
        m.checkNotNullParameter(storeGuildSelected, "storeGuildSelected");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.stream = storeStream;
        this.storeChannels = storeChannels;
        this.storePermissions = storePermissions;
        this.storeGuildSelected = storeGuildSelected;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.userChannelSelections = new HashMap();
        this.selectedChannelIdsCache = new Persister<>(CACHE_KEY_SELECTED_CHANNEL_IDS, new HashMap());
        StoreChannelsSelected$ResolvedSelectedChannel$Uninitialized storeChannelsSelected$ResolvedSelectedChannel$Uninitialized = StoreChannelsSelected$ResolvedSelectedChannel$Uninitialized.INSTANCE;
        this.selectedChannel = storeChannelsSelected$ResolvedSelectedChannel$Uninitialized;
        this.previouslySelectedChannel = storeChannelsSelected$ResolvedSelectedChannel$Uninitialized;
        Persister<ChannelFrecencyTracker> persister = new Persister<>("CHANNEL_HISTORY_V3", new ChannelFrecencyTracker());
        this.frecencyCache = persister;
        this.frecency = persister.get();
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreChannelsSelected storeChannelsSelected) {
        return storeChannelsSelected.dispatcher;
    }

    public static final /* synthetic */ boolean access$getInitializedForAuthedUser$p(StoreChannelsSelected storeChannelsSelected) {
        return storeChannelsSelected.initializedForAuthedUser;
    }

    public static final /* synthetic */ StoreChannelsSelected$Companion$InitializedUpdateSource$1 access$getInitializedUpdateSource$cp() {
        return InitializedUpdateSource;
    }

    public static final /* synthetic */ ObservationDeck access$getObservationDeck$p(StoreChannelsSelected storeChannelsSelected) {
        return storeChannelsSelected.observationDeck;
    }

    public static final /* synthetic */ StoreChannelsSelected$ResolvedSelectedChannel access$getPreviouslySelectedChannel$p(StoreChannelsSelected storeChannelsSelected) {
        return storeChannelsSelected.previouslySelectedChannel;
    }

    public static final /* synthetic */ StoreChannelsSelected$ResolvedSelectedChannel access$getSelectedChannel$p(StoreChannelsSelected storeChannelsSelected) {
        return storeChannelsSelected.selectedChannel;
    }

    public static final /* synthetic */ StoreChannels access$getStoreChannels$p(StoreChannelsSelected storeChannelsSelected) {
        return storeChannelsSelected.storeChannels;
    }

    public static final /* synthetic */ Subscription access$getValidateSelectedChannelSubscription$p(StoreChannelsSelected storeChannelsSelected) {
        return storeChannelsSelected.validateSelectedChannelSubscription;
    }

    public static final /* synthetic */ void access$onSelectedChannelResolved(StoreChannelsSelected storeChannelsSelected, StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        storeChannelsSelected.onSelectedChannelResolved(storeChannelsSelected$ResolvedSelectedChannel);
    }

    public static final /* synthetic */ StoreChannelsSelected$ResolvedSelectedChannel access$resolveSelectedChannel(StoreChannelsSelected storeChannelsSelected, StoreChannelsSelected$UserChannelSelection storeChannelsSelected$UserChannelSelection, Channel channel, Map map, long j, Map map2, boolean z2) {
        return storeChannelsSelected.resolveSelectedChannel(storeChannelsSelected$UserChannelSelection, channel, map, j, map2, z2);
    }

    public static final /* synthetic */ void access$setInitializedForAuthedUser$p(StoreChannelsSelected storeChannelsSelected, boolean z2) {
        storeChannelsSelected.initializedForAuthedUser = z2;
    }

    public static final /* synthetic */ void access$setPreviouslySelectedChannel$p(StoreChannelsSelected storeChannelsSelected, StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        storeChannelsSelected.previouslySelectedChannel = storeChannelsSelected$ResolvedSelectedChannel;
    }

    public static final /* synthetic */ void access$setSelectedChannel$p(StoreChannelsSelected storeChannelsSelected, StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        storeChannelsSelected.selectedChannel = storeChannelsSelected$ResolvedSelectedChannel;
    }

    public static final /* synthetic */ void access$setValidateSelectedChannelSubscription$p(StoreChannelsSelected storeChannelsSelected, Subscription subscription) {
        storeChannelsSelected.validateSelectedChannelSubscription = subscription;
    }

    private final Channel getFirstAvailableChannel(Map<Long, Channel> channels, long guildId, Map<Long, Long> permissions) {
        Collection<Channel> collectionValues = channels.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            Channel channel = (Channel) obj;
            if (channel.getGuildId() == guildId && ChannelUtils.v(channel) && PermissionUtils.hasAccess(channel, permissions)) {
                arrayList.add(obj);
            }
        }
        return (Channel) u.firstOrNull(u.sortedWith(arrayList, ChannelUtils.h(Channel.Companion)));
    }

    private final boolean isValidResolution(Channel channel, long guildId, Map<Long, Long> permissions) {
        return channel.getGuildId() == guildId && ChannelUtils.G(channel) && PermissionUtils.hasAccess(channel, permissions);
    }

    @StoreThread
    private final void loadFromCache() {
        Map<Long, StoreChannelsSelected$UserChannelSelection> map = this.userChannelSelections;
        Map<Long, Long> map2 = this.selectedChannelIdsCache.get();
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(map2.size()));
        Iterator<T> it = map2.entrySet().iterator();
        while (it.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it.next();
            linkedHashMap.put(map$Entry.getKey(), new StoreChannelsSelected$UserChannelSelection$SelectedChannel(((Number) map$Entry.getValue()).longValue(), null, null, 6, null));
        }
        map.putAll(linkedHashMap);
    }

    @StoreThread
    private final void onSelectedChannelResolved(StoreChannelsSelected$ResolvedSelectedChannel resolvedSelectedChannel) {
        if (this.selectedChannel.getId() != resolvedSelectedChannel.getId()) {
            this.previouslySelectedChannel = this.selectedChannel;
        }
        this.selectedChannel = resolvedSelectedChannel;
        boolean z2 = resolvedSelectedChannel instanceof StoreChannelsSelected$ResolvedSelectedChannel$Channel;
        if (z2) {
            StoreChannelsSelected$ResolvedSelectedChannel$Channel storeChannelsSelected$ResolvedSelectedChannel$Channel = (StoreChannelsSelected$ResolvedSelectedChannel$Channel) resolvedSelectedChannel;
            this.userChannelSelections.put(Long.valueOf(storeChannelsSelected$ResolvedSelectedChannel$Channel.getChannel().getGuildId()), new StoreChannelsSelected$UserChannelSelection$SelectedChannel(storeChannelsSelected$ResolvedSelectedChannel$Channel.getChannel().getId(), storeChannelsSelected$ResolvedSelectedChannel$Channel.getPeekParent(), null, 4, null));
            FrecencyTracker.track$default(this.frecency, Long.valueOf(storeChannelsSelected$ResolvedSelectedChannel$Channel.getChannel().getId()), 0L, 2, null);
        }
        if (z2) {
            StoreChannelsSelected$ResolvedSelectedChannel$Channel storeChannelsSelected$ResolvedSelectedChannel$Channel2 = (StoreChannelsSelected$ResolvedSelectedChannel$Channel) resolvedSelectedChannel;
            if (ChannelUtils.J(storeChannelsSelected$ResolvedSelectedChannel$Channel2.getChannel())) {
                this.stream.getAnalytics().trackTextInVoiceOpened(resolvedSelectedChannel.getId(), storeChannelsSelected$ResolvedSelectedChannel$Channel2.getAnalyticsLocation());
            }
            this.stream.getAnalytics().trackChannelOpened(resolvedSelectedChannel.getId(), storeChannelsSelected$ResolvedSelectedChannel$Channel2.getAnalyticsViewType(), storeChannelsSelected$ResolvedSelectedChannel$Channel2.getAnalyticsLocation());
        }
        updateInitializationState();
        markChanged();
    }

    private final StoreChannelsSelected$ResolvedSelectedChannel resolveSelectedChannel(StoreChannelsSelected$UserChannelSelection userChannelSelection, Channel resolvedChannel, Map<Long, Channel> channels, long guildId, Map<Long, Long> permissions, boolean storeChannelsInitializedForAuthedUser) {
        StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannelResolveWithChannel;
        if (!storeChannelsInitializedForAuthedUser) {
            return StoreChannelsSelected$ResolvedSelectedChannel$Uninitialized.INSTANCE;
        }
        if (resolvedChannel != null && isValidResolution(resolvedChannel, guildId, permissions)) {
            return (userChannelSelection == null || (storeChannelsSelected$ResolvedSelectedChannelResolveWithChannel = userChannelSelection.resolveWithChannel(resolvedChannel)) == null) ? StoreChannelsSelected$ResolvedSelectedChannel$Unselected.INSTANCE : storeChannelsSelected$ResolvedSelectedChannelResolveWithChannel;
        }
        if (guildId == 0) {
            return StoreChannelsSelected$ResolvedSelectedChannel$Unselected.INSTANCE;
        }
        Channel firstAvailableChannel = getFirstAvailableChannel(channels, guildId, permissions);
        return firstAvailableChannel == null ? StoreChannelsSelected$ResolvedSelectedChannel$Unavailable.INSTANCE : new StoreChannelsSelected$ResolvedSelectedChannel$Channel(firstAvailableChannel, null, null);
    }

    @StoreThread
    private final void updateInitializationState() {
        boolean z2 = this.stream.getAuthentication().getAuthState() != null;
        boolean z3 = this.initializedForAuthedUser;
        boolean z4 = z2 && this.storeChannels.getInitializedForAuthedUser() && ((this.userChannelSelections.isEmpty() ^ true) || this.handledReadyPayload || this.isStoreInitTimedOut) && (m.areEqual(this.selectedChannel, StoreChannelsSelected$ResolvedSelectedChannel$Uninitialized.INSTANCE) ^ true);
        if (z3 || !z4) {
            return;
        }
        this.initializedForAuthedUser = true;
        markChanged(InitializedUpdateSource);
    }

    @StoreThread
    private final void validateSelectedChannel() {
        Subscription subscription = this.validateSelectedChannelSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Map<Long, Channel> channelsByIdInternal$app_productionGoogleRelease = this.storeChannels.getChannelsByIdInternal$app_productionGoogleRelease();
        boolean initializedForAuthedUser = this.storeChannels.getInitializedForAuthedUser();
        long selectedGuildIdInternal$app_productionGoogleRelease = this.storeGuildSelected.getSelectedGuildIdInternal$app_productionGoogleRelease();
        Observable observableR = ObservableExtensionsKt.computationLatest(ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this.storeGuildSelected, this.storeChannels, this.storePermissions}, false, null, null, new StoreChannelsSelected$validateSelectedChannel$1(this, this.userChannelSelections.get(Long.valueOf(selectedGuildIdInternal$app_productionGoogleRelease)), channelsByIdInternal$app_productionGoogleRelease, selectedGuildIdInternal$app_productionGoogleRelease, this.storePermissions.getPermissionsByChannelInternal$app_productionGoogleRelease(selectedGuildIdInternal$app_productionGoogleRelease), initializedForAuthedUser), 14, null)).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, StoreChannelsSelected.class, (Context) null, new StoreChannelsSelected$validateSelectedChannel$2(this), (Function1) null, (Function0) null, (Function0) null, new StoreChannelsSelected$validateSelectedChannel$3(this), 58, (Object) null);
    }

    @StoreThread
    public final void dismissCreateThread() {
        StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel = this.selectedChannel;
        if (!(storeChannelsSelected$ResolvedSelectedChannel instanceof StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft)) {
            storeChannelsSelected$ResolvedSelectedChannel = null;
        }
        StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft = (StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft) storeChannelsSelected$ResolvedSelectedChannel;
        if (storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft != null) {
            Channel parentChannel = storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft.getParentChannel();
            this.userChannelSelections.put(Long.valueOf(parentChannel.getGuildId()), new StoreChannelsSelected$UserChannelSelection$SelectedChannel(parentChannel.getId(), null, null, 6, null));
            validateSelectedChannel();
        }
    }

    public final ChannelFrecencyTracker getFrecency() {
        return this.frecency;
    }

    public final long getId() {
        return this.selectedChannel.getId();
    }

    public final Channel getSelectedChannel() {
        StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel = this.selectedChannel;
        if (!(storeChannelsSelected$ResolvedSelectedChannel instanceof StoreChannelsSelected$ResolvedSelectedChannel$Channel)) {
            storeChannelsSelected$ResolvedSelectedChannel = null;
        }
        StoreChannelsSelected$ResolvedSelectedChannel$Channel storeChannelsSelected$ResolvedSelectedChannel$Channel = (StoreChannelsSelected$ResolvedSelectedChannel$Channel) storeChannelsSelected$ResolvedSelectedChannel;
        if (storeChannelsSelected$ResolvedSelectedChannel$Channel != null) {
            return storeChannelsSelected$ResolvedSelectedChannel$Channel.getChannel();
        }
        return null;
    }

    @StoreThread
    public final void handleChannelOrThreadCreateOrUpdate(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        if (channel.getId() == this.selectedChannel.getId()) {
            validateSelectedChannel();
        }
    }

    @StoreThread
    public final void handleChannelOrThreadDelete(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        if (channel.getId() == this.selectedChannel.getId()) {
            validateSelectedChannel();
        }
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        List<Guild> guilds = payload.getGuilds();
        m.checkNotNullExpressionValue(guilds, "payload.guilds");
        HashSet hashSetHashSetOf = n0.hashSetOf(0L);
        Iterator<T> it = guilds.iterator();
        while (it.hasNext()) {
            hashSetHashSetOf.add(Long.valueOf(((Guild) it.next()).getId()));
        }
        Map<Long, StoreChannelsSelected$UserChannelSelection> map = this.userChannelSelections;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, StoreChannelsSelected$UserChannelSelection> map$Entry : map.entrySet()) {
            if (hashSetHashSetOf.contains(Long.valueOf(map$Entry.getKey().longValue()))) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        Map<? extends Long, ? extends StoreChannelsSelected$UserChannelSelection> mutableMap = h0.toMutableMap(linkedHashMap);
        if (!mutableMap.containsKey(0L)) {
            mutableMap.put(0L, StoreChannelsSelected$UserChannelSelection$Unselected.INSTANCE);
        }
        this.userChannelSelections.clear();
        this.userChannelSelections.putAll(mutableMap);
        this.handledReadyPayload = true;
        validateSelectedChannel();
    }

    @StoreThread
    public final void handleGuildAdd(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        if (this.storeGuildSelected.getSelectedGuildIdInternal$app_productionGoogleRelease() == guild.getId()) {
            validateSelectedChannel();
        }
    }

    @StoreThread
    public final void handleGuildRemove(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        Channel maybeChannel = this.selectedChannel.getMaybeChannel();
        if (maybeChannel == null || maybeChannel.getGuildId() != guild.getId()) {
            return;
        }
        validateSelectedChannel();
    }

    @StoreThread
    public final void handleGuildSelected() {
        validateSelectedChannel();
    }

    @StoreThread
    public final void handleStoreInitTimeout() {
        this.isStoreInitTimedOut = true;
        updateInitializationState();
        if (m.areEqual(this.selectedChannel, StoreChannelsSelected$ResolvedSelectedChannel$Uninitialized.INSTANCE)) {
            validateSelectedChannel();
        }
    }

    @StoreThread
    public final void init() {
        loadFromCache();
        validateSelectedChannel();
    }

    public final Observable<Long> observeId() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreChannelsSelected$observeId$1(this), 14, null);
    }

    public final Observable<Boolean> observeInitializedForAuthedUser() {
        Observable observableY = this.storeChannels.observeInitializedForAuthedUser().Y(new StoreChannelsSelected$observeInitializedForAuthedUser$1(this));
        m.checkNotNullExpressionValue(observableY, "storeChannels.observeIni…            }\n          }");
        return observableY;
    }

    public final Observable<Long> observePreviousId() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreChannelsSelected$observePreviousId$1(this), 14, null);
    }

    public final Observable<StoreChannelsSelected$ResolvedSelectedChannel> observeResolvedSelectedChannel() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreChannelsSelected$observeResolvedSelectedChannel$1(this), 14, null);
    }

    public final Observable<Channel> observeSelectedChannel() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreChannelsSelected$observeSelectedChannel$1(this), 14, null);
    }

    @StoreThread
    public final void openCreateThread(long guildId, long channelId, Long parentMessageId, String threadStartLocation) {
        this.userChannelSelections.put(Long.valueOf(guildId), new StoreChannelsSelected$UserChannelSelection$ThreadDraft(channelId, parentMessageId, threadStartLocation));
        validateSelectedChannel();
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        Persister.set$default(this.frecencyCache, this.frecency, false, 2, null);
        Map<Long, StoreChannelsSelected$UserChannelSelection> map = this.userChannelSelections;
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it.next();
            linkedHashMap.put(map$Entry.getKey(), Long.valueOf(((StoreChannelsSelected$UserChannelSelection) map$Entry.getValue()).getId()));
        }
        this.selectedChannelIdsCache.set(linkedHashMap, true);
    }

    @StoreThread
    public final void trySelectChannel(long guildId, long channelId, Long peekParent, SelectedChannelAnalyticsLocation analyticsLocation) {
        StoreChannelsSelected$UserChannelSelection storeChannelsSelected$UserChannelSelection = this.userChannelSelections.get(Long.valueOf(guildId));
        if (!(storeChannelsSelected$UserChannelSelection instanceof StoreChannelsSelected$UserChannelSelection$SelectedChannel)) {
            storeChannelsSelected$UserChannelSelection = null;
        }
        StoreChannelsSelected$UserChannelSelection$SelectedChannel storeChannelsSelected$UserChannelSelection$SelectedChannel = (StoreChannelsSelected$UserChannelSelection$SelectedChannel) storeChannelsSelected$UserChannelSelection;
        if (storeChannelsSelected$UserChannelSelection$SelectedChannel == null || storeChannelsSelected$UserChannelSelection$SelectedChannel.getChannelId() != channelId) {
            this.userChannelSelections.put(Long.valueOf(guildId), new StoreChannelsSelected$UserChannelSelection$SelectedChannel(channelId, peekParent, analyticsLocation));
            validateSelectedChannel();
        }
    }
}
