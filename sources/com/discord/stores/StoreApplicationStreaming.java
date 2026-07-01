package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.guild.Guild;
import com.discord.api.voice.state.VoiceState;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelApplicationStream$CallStream;
import com.discord.models.domain.ModelApplicationStream$GuildStream;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.StreamCreateOrUpdate;
import com.discord.models.domain.StreamDelete;
import com.discord.models.domain.StreamDelete$Reason;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import d0.t.h0;
import d0.z.d.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreApplicationStreaming.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationStreaming extends StoreV2 {
    private StoreApplicationStreaming$ActiveApplicationStream activeApplicationStream;
    private final ArrayDeque<String> breadCrumbs;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final StoreRtcConnection rtcConnectionStore;
    private final StoreStream storeStream;
    private final HashMap<String, List<Long>> streamSpectators;
    private Map<String, ? extends List<Long>> streamSpectatorsSnapshot;
    private final StoreApplicationStreaming$StreamViewerTracker streamViewerTracker;
    private final HashMap<Long, ModelApplicationStream> streamsByUser;
    private Map<Long, ? extends ModelApplicationStream> streamsByUserSnapshot;
    private ModelApplicationStream targetStream;
    private final StoreUser userStore;
    private final StoreVoiceChannelSelected voiceChannelSelectedStore;

    public /* synthetic */ StoreApplicationStreaming(StoreStream storeStream, Dispatcher dispatcher, StoreUser storeUser, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreRtcConnection storeRtcConnection, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, storeUser, storeVoiceChannelSelected, storeRtcConnection, (i & 32) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ StoreApplicationStreaming$ActiveApplicationStream access$getActiveApplicationStream$p(StoreApplicationStreaming storeApplicationStreaming) {
        return storeApplicationStreaming.activeApplicationStream;
    }

    public static final /* synthetic */ StoreRtcConnection access$getRtcConnectionStore$p(StoreApplicationStreaming storeApplicationStreaming) {
        return storeApplicationStreaming.rtcConnectionStore;
    }

    public static final /* synthetic */ StoreStream access$getStoreStream$p(StoreApplicationStreaming storeApplicationStreaming) {
        return storeApplicationStreaming.storeStream;
    }

    public static final /* synthetic */ Map access$getStreamSpectatorsSnapshot$p(StoreApplicationStreaming storeApplicationStreaming) {
        return storeApplicationStreaming.streamSpectatorsSnapshot;
    }

    public static final /* synthetic */ Map access$getStreamsByUserSnapshot$p(StoreApplicationStreaming storeApplicationStreaming) {
        return storeApplicationStreaming.streamsByUserSnapshot;
    }

    public static final /* synthetic */ StoreUser access$getUserStore$p(StoreApplicationStreaming storeApplicationStreaming) {
        return storeApplicationStreaming.userStore;
    }

    public static final /* synthetic */ void access$setActiveApplicationStream$p(StoreApplicationStreaming storeApplicationStreaming, StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream) {
        storeApplicationStreaming.activeApplicationStream = storeApplicationStreaming$ActiveApplicationStream;
    }

    public static final /* synthetic */ void access$setStreamSpectatorsSnapshot$p(StoreApplicationStreaming storeApplicationStreaming, Map map) {
        storeApplicationStreaming.streamSpectatorsSnapshot = map;
    }

    public static final /* synthetic */ void access$setStreamsByUserSnapshot$p(StoreApplicationStreaming storeApplicationStreaming, Map map) {
        storeApplicationStreaming.streamsByUserSnapshot = map;
    }

    public static final /* synthetic */ void access$stopStreamInternal(StoreApplicationStreaming storeApplicationStreaming, String str) {
        storeApplicationStreaming.stopStreamInternal(str);
    }

    private final synchronized void addBreadCrumb(String message) {
        this.breadCrumbs.addLast(message + ", on thread: " + Thread.currentThread());
        ArrayDeque<String> arrayDeque = this.breadCrumbs;
        if (arrayDeque.size() > 50) {
            arrayDeque.removeFirst();
        }
    }

    public static /* synthetic */ void createStream$default(StoreApplicationStreaming storeApplicationStreaming, long j, Long l, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        storeApplicationStreaming.createStream(j, l, str);
    }

    private final synchronized void dumpBreadcrumbs() {
        Iterator<String> it = this.breadCrumbs.iterator();
        while (it.hasNext()) {
            AppLog.g.recordBreadcrumb(it.next(), "StoreApplicationStreaming");
        }
    }

    @StoreThread
    private final void handleStreamCreateOrUpdate(String streamKey, boolean paused, List<Long> viewerIds) {
        updateActiveApplicationStream(new StoreApplicationStreaming$ActiveApplicationStream(paused ? StoreApplicationStreaming$ActiveApplicationStream$State.PAUSED : StoreApplicationStreaming$ActiveApplicationStream$State.ACTIVE, ModelApplicationStream.Companion.decodeStreamKey(streamKey)));
        this.streamSpectators.put(streamKey, viewerIds);
        this.streamViewerTracker.onStreamUpdated(streamKey, viewerIds.size());
        markChanged();
    }

    public static /* synthetic */ void handleVoiceStateUpdate$default(StoreApplicationStreaming storeApplicationStreaming, VoiceState voiceState, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = voiceState.getGuildId();
        }
        storeApplicationStreaming.handleVoiceStateUpdate(voiceState, j);
    }

    private final void stopStreamInternal(String streamKey) {
        this.storeStream.handleStreamDelete(new StreamDelete(streamKey, StreamDelete$Reason.USER_REQUESTED, false), true);
    }

    public static /* synthetic */ void targetStream$default(StoreApplicationStreaming storeApplicationStreaming, String str, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        storeApplicationStreaming.targetStream(str, z2);
    }

    @StoreThread
    private final void updateActiveApplicationStream(StoreApplicationStreaming$ActiveApplicationStream activeApplicationStream) {
        boolean zIsScreenSharing = isScreenSharing(this.activeApplicationStream);
        boolean zIsScreenSharing2 = isScreenSharing(activeApplicationStream);
        if (zIsScreenSharing != zIsScreenSharing2) {
            this.storeStream.handleIsScreenSharingChanged(zIsScreenSharing2);
        }
        this.activeApplicationStream = activeApplicationStream;
    }

    public final void createStream(long channelId, Long guildId, String preferredRegion) {
        this.dispatcher.schedule(new StoreApplicationStreaming$createStream$1(this, channelId, guildId, preferredRegion));
    }

    @StoreThread
    public final String getActiveApplicationStreamKeyInternal$app_productionGoogleRelease() {
        ModelApplicationStream stream;
        StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream = this.activeApplicationStream;
        if (storeApplicationStreaming$ActiveApplicationStream == null || (stream = storeApplicationStreaming$ActiveApplicationStream.getStream()) == null) {
            return null;
        }
        return stream.getEncodedStreamKey();
    }

    @StoreThread
    public final Integer getMaxViewersForStream(long userId, long channelId, Long guildId) {
        return this.streamViewerTracker.getMaxViewers((guildId != null ? new ModelApplicationStream$GuildStream(guildId.longValue(), channelId, userId) : new ModelApplicationStream$CallStream(channelId, userId)).getEncodedStreamKey());
    }

    public final Map<Long, ModelApplicationStream> getStreamsByUser() {
        return this.streamsByUserSnapshot;
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        addBreadCrumb("Connection open, clearing streams by user.");
        this.streamsByUser.clear();
        this.streamViewerTracker.clear();
        StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream = this.activeApplicationStream;
        if (storeApplicationStreaming$ActiveApplicationStream != null && storeApplicationStreaming$ActiveApplicationStream.getState() != StoreApplicationStreaming$ActiveApplicationStream$State.ENDED) {
            targetStream(storeApplicationStreaming$ActiveApplicationStream.getStream().getEncodedStreamKey(), true);
        }
        List<Guild> guilds = payload.getGuilds();
        m.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            List<VoiceState> listR = guild.R();
            if (listR != null) {
                Iterator<T> it = listR.iterator();
                while (it.hasNext()) {
                    handleVoiceStateUpdate((VoiceState) it.next(), guild.getId());
                }
            }
        }
        markChanged();
    }

    @StoreThread
    public final void handleStreamCreate(StreamCreateOrUpdate streamCreate) {
        m.checkNotNullParameter(streamCreate, "streamCreate");
        this.streamViewerTracker.remove(streamCreate.getStreamKey());
        handleStreamCreateOrUpdate(streamCreate.getStreamKey(), streamCreate.getPaused(), streamCreate.getViewerIds());
    }

    @StoreThread
    public final void handleStreamCreateRequest(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        updateActiveApplicationStream(new StoreApplicationStreaming$ActiveApplicationStream(StoreApplicationStreaming$ActiveApplicationStream$State.CONNECTING, ModelApplicationStream.Companion.decodeStreamKey(streamKey)));
        markChanged();
    }

    @StoreThread
    public final void handleStreamDelete(StreamDelete streamDelete) {
        ModelApplicationStream stream;
        StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream;
        m.checkNotNullParameter(streamDelete, "streamDelete");
        this.streamSpectators.remove(streamDelete.getStreamKey());
        if (streamDelete.getReason() == StreamDelete$Reason.STREAM_FULL) {
            updateActiveApplicationStream(new StoreApplicationStreaming$ActiveApplicationStream(StoreApplicationStreaming$ActiveApplicationStream$State.DENIED_FULL, ModelApplicationStream.Companion.decodeStreamKey(streamDelete.getStreamKey())));
            markChanged();
            return;
        }
        StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream2 = this.activeApplicationStream;
        if (storeApplicationStreaming$ActiveApplicationStream2 == null || (stream = storeApplicationStreaming$ActiveApplicationStream2.getStream()) == null) {
            stream = this.targetStream;
        }
        StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStreamCopy$default = null;
        if (m.areEqual(stream != null ? stream.getEncodedStreamKey() : null, streamDelete.getStreamKey())) {
            if (streamDelete.getUnavailable()) {
                StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream3 = this.activeApplicationStream;
                if (storeApplicationStreaming$ActiveApplicationStream3 != null) {
                    storeApplicationStreaming$ActiveApplicationStreamCopy$default = StoreApplicationStreaming$ActiveApplicationStream.copy$default(storeApplicationStreaming$ActiveApplicationStream3, StoreApplicationStreaming$ActiveApplicationStream$State.RECONNECTING, null, 2, null);
                }
            } else if (streamDelete.getReason() != StreamDelete$Reason.USER_REQUESTED && (storeApplicationStreaming$ActiveApplicationStream = this.activeApplicationStream) != null) {
                storeApplicationStreaming$ActiveApplicationStreamCopy$default = StoreApplicationStreaming$ActiveApplicationStream.copy$default(storeApplicationStreaming$ActiveApplicationStream, StoreApplicationStreaming$ActiveApplicationStream$State.ENDED, null, 2, null);
            }
            updateActiveApplicationStream(storeApplicationStreaming$ActiveApplicationStreamCopy$default);
            markChanged();
        }
    }

    @StoreThread
    public final void handleStreamTargeted(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        ModelApplicationStream modelApplicationStreamDecodeStreamKey = ModelApplicationStream.Companion.decodeStreamKey(streamKey);
        StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream = this.activeApplicationStream;
        if (m.areEqual(modelApplicationStreamDecodeStreamKey, storeApplicationStreaming$ActiveApplicationStream != null ? storeApplicationStreaming$ActiveApplicationStream.getStream() : null) && storeApplicationStreaming$ActiveApplicationStream.getState().isStreamActive()) {
            return;
        }
        if (this.voiceChannelSelectedStore.getSelectedVoiceChannelId() != modelApplicationStreamDecodeStreamKey.getChannelId()) {
            this.targetStream = modelApplicationStreamDecodeStreamKey;
        } else {
            this.storeStream.streamWatch(modelApplicationStreamDecodeStreamKey.getEncodedStreamKey());
            this.targetStream = null;
        }
    }

    @StoreThread
    public final void handleStreamUpdate(StreamCreateOrUpdate streamUpdate) {
        m.checkNotNullParameter(streamUpdate, "streamUpdate");
        handleStreamCreateOrUpdate(streamUpdate.getStreamKey(), streamUpdate.getPaused(), streamUpdate.getViewerIds());
    }

    @StoreThread
    public final void handleStreamWatch(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        updateActiveApplicationStream(new StoreApplicationStreaming$ActiveApplicationStream(StoreApplicationStreaming$ActiveApplicationStream$State.CONNECTING, ModelApplicationStream.Companion.decodeStreamKey(streamKey)));
        markChanged();
    }

    @StoreThread
    public final void handleVoiceChannelSelected(long channelId) {
        ModelApplicationStream stream;
        ModelApplicationStream modelApplicationStream = this.targetStream;
        if (modelApplicationStream != null && channelId == modelApplicationStream.getChannelId()) {
            StoreStream storeStream = this.storeStream;
            ModelApplicationStream modelApplicationStream2 = this.targetStream;
            m.checkNotNull(modelApplicationStream2);
            storeStream.streamWatch(modelApplicationStream2.getEncodedStreamKey());
            this.targetStream = null;
            return;
        }
        StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream = this.activeApplicationStream;
        if (storeApplicationStreaming$ActiveApplicationStream == null || (stream = storeApplicationStreaming$ActiveApplicationStream.getStream()) == null || stream.getChannelId() != channelId) {
            updateActiveApplicationStream(null);
            this.targetStream = null;
            markChanged();
        }
    }

    @StoreThread
    public final void handleVoiceStateUpdate(VoiceState voiceState, long guildId) {
        m.checkNotNullParameter(voiceState, "voiceState");
        addBreadCrumb("Handling a voice state update for " + voiceState.getUserId());
        Long channelId = voiceState.getChannelId();
        long userId = voiceState.getUserId();
        boolean selfStream = voiceState.getSelfStream();
        boolean z2 = guildId != 0;
        boolean z3 = (channelId == null || channelId.longValue() == 0) ? false : true;
        if (selfStream && z2 && z3) {
            HashMap<Long, ModelApplicationStream> map = this.streamsByUser;
            Long lValueOf = Long.valueOf(userId);
            m.checkNotNull(channelId);
            map.put(lValueOf, new ModelApplicationStream$GuildStream(guildId, channelId.longValue(), userId));
            markChanged();
        } else if (selfStream && z3) {
            HashMap<Long, ModelApplicationStream> map2 = this.streamsByUser;
            Long lValueOf2 = Long.valueOf(userId);
            m.checkNotNull(channelId);
            map2.put(lValueOf2, new ModelApplicationStream$CallStream(channelId.longValue(), userId));
            markChanged();
        } else if (this.streamsByUser.containsKey(Long.valueOf(userId))) {
            this.streamsByUser.remove(Long.valueOf(userId));
            markChanged();
        }
        StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream = this.activeApplicationStream;
        if (storeApplicationStreaming$ActiveApplicationStream != null && userId == this.userStore.getMe().getId()) {
            long channelId2 = storeApplicationStreaming$ActiveApplicationStream.getStream().getChannelId();
            Long channelId3 = voiceState.getChannelId();
            if (channelId3 == null || channelId2 != channelId3.longValue()) {
                updateActiveApplicationStream(null);
                markChanged();
            }
        }
        ModelApplicationStream modelApplicationStream = this.streamsByUser.get(Long.valueOf(userId));
        if (selfStream && modelApplicationStream != null && storeApplicationStreaming$ActiveApplicationStream != null && m.areEqual(modelApplicationStream.getEncodedStreamKey(), storeApplicationStreaming$ActiveApplicationStream.getStream().getEncodedStreamKey()) && storeApplicationStreaming$ActiveApplicationStream.getState() == StoreApplicationStreaming$ActiveApplicationStream$State.ENDED) {
            handleStreamTargeted(modelApplicationStream.getEncodedStreamKey());
        }
    }

    @StoreThread
    public final boolean isScreenSharing() {
        return isScreenSharing(this.activeApplicationStream);
    }

    @StoreThread
    public final boolean isUserStreaming(long userId) {
        addBreadCrumb("Asking if " + userId + " is streaming");
        return this.streamsByUser.containsKey(Long.valueOf(userId));
    }

    public final Observable<StoreApplicationStreaming$ActiveApplicationStream> observeActiveStream() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreApplicationStreaming$observeActiveStream$1(this), 14, null);
    }

    public final Observable<Map<String, List<Long>>> observeStreamSpectators() {
        Observable<Map<String, List<Long>>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreApplicationStreaming$observeStreamSpectators$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, ModelApplicationStream>> observeStreamsByUser() {
        Observable<Map<Long, ModelApplicationStream>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreApplicationStreaming$observeStreamsByUser$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, ModelApplicationStream>> observeStreamsForGuild(long guildId) {
        Observable<Map<Long, ModelApplicationStream>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreApplicationStreaming$observeStreamsForGuild$1(this, guildId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<ModelApplicationStream> observeStreamsForUser(long userId) {
        Observable<ModelApplicationStream> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreApplicationStreaming$observeStreamsForUser$1(this, userId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() throws Exception {
        super.snapshotData();
        StringBuilder sbU = a.U("Snapshotting 'streamsByUser' of size, ");
        sbU.append(this.streamsByUser.size());
        addBreadCrumb(sbU.toString());
        try {
            this.streamsByUserSnapshot = new HashMap(this.streamsByUser);
            this.streamSpectatorsSnapshot = new HashMap(this.streamSpectators);
        } catch (Exception e) {
            dumpBreadcrumbs();
            throw e;
        }
    }

    public final void stopStream(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        this.dispatcher.schedule(new StoreApplicationStreaming$stopStream$1(this, streamKey));
    }

    public final void targetStream(String streamKey, boolean force) {
        m.checkNotNullParameter(streamKey, "streamKey");
        this.dispatcher.schedule(new StoreApplicationStreaming$targetStream$1(this, streamKey, force));
    }

    public StoreApplicationStreaming(StoreStream storeStream, Dispatcher dispatcher, StoreUser storeUser, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreRtcConnection storeRtcConnection, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeStream, "storeStream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(storeUser, "userStore");
        m.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        m.checkNotNullParameter(storeRtcConnection, "rtcConnectionStore");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        this.userStore = storeUser;
        this.voiceChannelSelectedStore = storeVoiceChannelSelected;
        this.rtcConnectionStore = storeRtcConnection;
        this.observationDeck = observationDeck;
        this.breadCrumbs = new ArrayDeque<>();
        this.streamsByUser = new HashMap<>();
        this.streamsByUserSnapshot = h0.emptyMap();
        this.streamSpectators = new HashMap<>();
        this.streamSpectatorsSnapshot = h0.emptyMap();
        this.streamViewerTracker = new StoreApplicationStreaming$StreamViewerTracker();
        addBreadCrumb("Initializing the store.");
    }

    private final boolean isScreenSharing(StoreApplicationStreaming$ActiveApplicationStream activeApplicationStream) {
        return activeApplicationStream != null && activeApplicationStream.getStream().getOwnerId() == this.userStore.getMe().getId();
    }
}
