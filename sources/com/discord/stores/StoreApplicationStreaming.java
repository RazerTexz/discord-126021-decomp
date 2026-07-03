package com.discord.stores;

import com.discord.api.guild.Guild;
import com.discord.api.voice.state.VoiceState;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.StreamCreateOrUpdate;
import com.discord.models.domain.StreamDelete;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.logging.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12096m;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreApplicationStreaming.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationStreaming extends StoreV2 {
    private ActiveApplicationStream activeApplicationStream;
    private final ArrayDeque<String> breadCrumbs;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final StoreRtcConnection rtcConnectionStore;
    private final StoreStream storeStream;
    private final HashMap<String, List<Long>> streamSpectators;
    private Map<String, ? extends List<Long>> streamSpectatorsSnapshot;
    private final StreamViewerTracker streamViewerTracker;
    private final HashMap<Long, ModelApplicationStream> streamsByUser;
    private Map<Long, ? extends ModelApplicationStream> streamsByUserSnapshot;
    private ModelApplicationStream targetStream;
    private final StoreUser userStore;
    private final StoreVoiceChannelSelected voiceChannelSelectedStore;

    /* JADX INFO: compiled from: StoreApplicationStreaming.kt */
    public static final /* data */ class ActiveApplicationStream {
        private final State state;
        private final ModelApplicationStream stream;

        /* JADX INFO: compiled from: StoreApplicationStreaming.kt */
        public enum State {
            CONNECTING,
            ACTIVE,
            RECONNECTING,
            ENDED,
            PAUSED,
            DENIED_FULL;


            @Deprecated
            private static final List<State> ACTIVE_STATES;
            private static final Companion Companion;

            /* JADX INFO: compiled from: StoreApplicationStreaming.kt */
            public static final class Companion {
                private Companion() {
                }

                public final List<State> getACTIVE_STATES() {
                    return State.ACTIVE_STATES;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            static {
                State state = CONNECTING;
                State state2 = ACTIVE;
                State state3 = RECONNECTING;
                State state4 = PAUSED;
                Companion = new Companion(null);
                ACTIVE_STATES = C12147n.listOf((Object[]) new State[]{state, state2, state3, state4});
            }

            public final boolean isStreamActive() {
                return ACTIVE_STATES.contains(this);
            }
        }

        public ActiveApplicationStream(State state, ModelApplicationStream modelApplicationStream) {
            C12238m.checkNotNullParameter(state, "state");
            C12238m.checkNotNullParameter(modelApplicationStream, "stream");
            this.state = state;
            this.stream = modelApplicationStream;
        }

        public static /* synthetic */ ActiveApplicationStream copy$default(ActiveApplicationStream activeApplicationStream, State state, ModelApplicationStream modelApplicationStream, int i, Object obj) {
            if ((i & 1) != 0) {
                state = activeApplicationStream.state;
            }
            if ((i & 2) != 0) {
                modelApplicationStream = activeApplicationStream.stream;
            }
            return activeApplicationStream.copy(state, modelApplicationStream);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final State getState() {
            return this.state;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ModelApplicationStream getStream() {
            return this.stream;
        }

        public final ActiveApplicationStream copy(State state, ModelApplicationStream stream) {
            C12238m.checkNotNullParameter(state, "state");
            C12238m.checkNotNullParameter(stream, "stream");
            return new ActiveApplicationStream(state, stream);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActiveApplicationStream)) {
                return false;
            }
            ActiveApplicationStream activeApplicationStream = (ActiveApplicationStream) other;
            return C12238m.areEqual(this.state, activeApplicationStream.state) && C12238m.areEqual(this.stream, activeApplicationStream.stream);
        }

        public final State getState() {
            return this.state;
        }

        public final ModelApplicationStream getStream() {
            return this.stream;
        }

        public int hashCode() {
            State state = this.state;
            int iHashCode = (state != null ? state.hashCode() : 0) * 31;
            ModelApplicationStream modelApplicationStream = this.stream;
            return iHashCode + (modelApplicationStream != null ? modelApplicationStream.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ActiveApplicationStream(state=");
            sbM833U.append(this.state);
            sbM833U.append(", stream=");
            sbM833U.append(this.stream);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: StoreApplicationStreaming.kt */
    public static final class StreamViewerTracker {
        private final Map<String, Integer> maxViewersByStream = new HashMap();

        public final void clear() {
            this.maxViewersByStream.clear();
        }

        public final Integer getMaxViewers(String streamKey) {
            C12238m.checkNotNullParameter(streamKey, "streamKey");
            return this.maxViewersByStream.get(streamKey);
        }

        public final void onStreamUpdated(String streamKey, int viewerCount) {
            C12238m.checkNotNullParameter(streamKey, "streamKey");
            Integer num = this.maxViewersByStream.get(streamKey);
            this.maxViewersByStream.put(streamKey, Integer.valueOf(Math.max(num != null ? num.intValue() : 0, viewerCount)));
        }

        public final void remove(String streamKey) {
            C12238m.checkNotNullParameter(streamKey, "streamKey");
            this.maxViewersByStream.remove(streamKey);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreaming$createStream$1 */
    /* JADX INFO: compiled from: StoreApplicationStreaming.kt */
    public static final class C57441 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Long $guildId;
        public final /* synthetic */ String $preferredRegion;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57441(long j, Long l, String str) {
            super(0);
            this.$channelId = j;
            this.$guildId = l;
            this.$preferredRegion = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ActiveApplicationStream.State state;
            ActiveApplicationStream.State state2;
            ModelApplicationStream stream;
            RtcConnection rtcConnection$app_productionGoogleRelease = StoreApplicationStreaming.this.rtcConnectionStore.getRtcConnection();
            Object encodedStreamKey = null;
            boolean z2 = false;
            if (rtcConnection$app_productionGoogleRelease == null || rtcConnection$app_productionGoogleRelease.channelId != this.$channelId || (!C12238m.areEqual(rtcConnection$app_productionGoogleRelease.guildId, this.$guildId))) {
                AppLog appLog = AppLog.f14950g;
                StringBuilder sbM833U = C1643a.m833U("\n                Failed to start stream.\n                rtcConnection == null: ");
                sbM833U.append(rtcConnection$app_productionGoogleRelease == null);
                sbM833U.append("\n                rtcConnection.channelId != channelId: ");
                sbM833U.append(rtcConnection$app_productionGoogleRelease == null || rtcConnection$app_productionGoogleRelease.channelId != this.$channelId);
                sbM833U.append("\n                rtcConnection.guildId != guildId: ");
                sbM833U.append(!C12238m.areEqual(rtcConnection$app_productionGoogleRelease != null ? rtcConnection$app_productionGoogleRelease.guildId : null, this.$guildId));
                sbM833U.append("\n              ");
                Logger.e$default(appLog, "Failed to start stream.", new IllegalStateException(C12096m.trimIndent(sbM833U.toString())), null, 4, null);
                return;
            }
            long id2 = StoreApplicationStreaming.this.userStore.getMeSnapshot().getId();
            ModelApplicationStream guildStream = this.$guildId != null ? new ModelApplicationStream.GuildStream(this.$guildId.longValue(), this.$channelId, id2) : new ModelApplicationStream.CallStream(this.$channelId, id2);
            ActiveApplicationStream activeApplicationStream = StoreApplicationStreaming.this.activeApplicationStream;
            if (activeApplicationStream != null && (stream = activeApplicationStream.getStream()) != null) {
                encodedStreamKey = stream.getEncodedStreamKey();
            }
            if ((encodedStreamKey == guildStream.getEncodedStreamKey()) && activeApplicationStream != null && (state2 = activeApplicationStream.getState()) != null && state2.isStreamActive()) {
                z2 = true;
            }
            if (z2) {
                return;
            }
            if (activeApplicationStream != null && (state = activeApplicationStream.getState()) != null && state.isStreamActive()) {
                StoreApplicationStreaming.this.stopStreamInternal(activeApplicationStream.getStream().getEncodedStreamKey());
            }
            StoreApplicationStreaming.this.storeStream.streamCreate(guildStream.getEncodedStreamKey(), this.$preferredRegion);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreaming$observeActiveStream$1 */
    /* JADX INFO: compiled from: StoreApplicationStreaming.kt */
    public static final class C57451 extends AbstractC12240o implements Function0<ActiveApplicationStream> {
        public C57451() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ActiveApplicationStream invoke() {
            return StoreApplicationStreaming.this.activeApplicationStream;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreaming$observeStreamSpectators$1 */
    /* JADX INFO: compiled from: StoreApplicationStreaming.kt */
    public static final class C57461 extends AbstractC12240o implements Function0<Map<String, ? extends List<? extends Long>>> {
        public C57461() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<String, ? extends List<? extends Long>> invoke() {
            return StoreApplicationStreaming.this.streamSpectatorsSnapshot;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreaming$observeStreamsByUser$1 */
    /* JADX INFO: compiled from: StoreApplicationStreaming.kt */
    public static final class C57471 extends AbstractC12240o implements Function0<Map<Long, ? extends ModelApplicationStream>> {
        public C57471() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends ModelApplicationStream> invoke() {
            return StoreApplicationStreaming.this.getStreamsByUser();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreaming$observeStreamsForGuild$1 */
    /* JADX INFO: compiled from: StoreApplicationStreaming.kt */
    public static final class C57481 extends AbstractC12240o implements Function0<Map<Long, ? extends ModelApplicationStream>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57481(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends ModelApplicationStream> invoke() {
            Map map = StoreApplicationStreaming.this.streamsByUserSnapshot;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                ModelApplicationStream modelApplicationStream = (ModelApplicationStream) entry.getValue();
                if ((modelApplicationStream instanceof ModelApplicationStream.GuildStream) && ((ModelApplicationStream.GuildStream) modelApplicationStream).getGuildId() == this.$guildId) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreaming$observeStreamsForUser$1 */
    /* JADX INFO: compiled from: StoreApplicationStreaming.kt */
    public static final class C57491 extends AbstractC12240o implements Function0<ModelApplicationStream> {
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57491(long j) {
            super(0);
            this.$userId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ModelApplicationStream invoke() {
            return (ModelApplicationStream) StoreApplicationStreaming.this.streamsByUserSnapshot.get(Long.valueOf(this.$userId));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreaming$stopStream$1 */
    /* JADX INFO: compiled from: StoreApplicationStreaming.kt */
    public static final class C57501 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57501(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationStreaming.this.stopStreamInternal(this.$streamKey);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreaming$targetStream$1 */
    /* JADX INFO: compiled from: StoreApplicationStreaming.kt */
    public static final class C57511 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ boolean $force;
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57511(String str, boolean z2) {
            super(0);
            this.$streamKey = str;
            this.$force = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ActiveApplicationStream.State state;
            ModelApplicationStream stream;
            ActiveApplicationStream activeApplicationStream = StoreApplicationStreaming.this.activeApplicationStream;
            boolean z2 = C12238m.areEqual((activeApplicationStream == null || (stream = activeApplicationStream.getStream()) == null) ? null : stream.getEncodedStreamKey(), this.$streamKey) && activeApplicationStream.getState().isStreamActive();
            if (this.$force || !z2) {
                if (activeApplicationStream != null && (state = activeApplicationStream.getState()) != null && state.isStreamActive()) {
                    StoreApplicationStreaming.this.stopStreamInternal(activeApplicationStream.getStream().getEncodedStreamKey());
                }
                StoreApplicationStreaming.this.storeStream.handleStreamTargeted(this.$streamKey);
            }
        }
    }

    public /* synthetic */ StoreApplicationStreaming(StoreStream storeStream, Dispatcher dispatcher, StoreUser storeUser, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreRtcConnection storeRtcConnection, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, storeUser, storeVoiceChannelSelected, storeRtcConnection, (i & 32) != 0 ? ObservationDeckProvider.get() : observationDeck);
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
            AppLog.f14950g.recordBreadcrumb(it.next(), "StoreApplicationStreaming");
        }
    }

    @StoreThread
    private final void handleStreamCreateOrUpdate(String streamKey, boolean paused, List<Long> viewerIds) {
        updateActiveApplicationStream(new ActiveApplicationStream(paused ? ActiveApplicationStream.State.PAUSED : ActiveApplicationStream.State.ACTIVE, ModelApplicationStream.INSTANCE.decodeStreamKey(streamKey)));
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
        this.storeStream.handleStreamDelete(new StreamDelete(streamKey, StreamDelete.Reason.USER_REQUESTED, false), true);
    }

    public static /* synthetic */ void targetStream$default(StoreApplicationStreaming storeApplicationStreaming, String str, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        storeApplicationStreaming.targetStream(str, z2);
    }

    @StoreThread
    private final void updateActiveApplicationStream(ActiveApplicationStream activeApplicationStream) {
        boolean zIsScreenSharing = isScreenSharing(this.activeApplicationStream);
        boolean zIsScreenSharing2 = isScreenSharing(activeApplicationStream);
        if (zIsScreenSharing != zIsScreenSharing2) {
            this.storeStream.handleIsScreenSharingChanged(zIsScreenSharing2);
        }
        this.activeApplicationStream = activeApplicationStream;
    }

    public final void createStream(long channelId, Long guildId, String preferredRegion) {
        this.dispatcher.schedule(new C57441(channelId, guildId, preferredRegion));
    }

    @StoreThread
    /* JADX INFO: renamed from: getActiveApplicationStreamKeyInternal$app_productionGoogleRelease */
    public final String m8507xb25617db() {
        ModelApplicationStream stream;
        ActiveApplicationStream activeApplicationStream = this.activeApplicationStream;
        if (activeApplicationStream == null || (stream = activeApplicationStream.getStream()) == null) {
            return null;
        }
        return stream.getEncodedStreamKey();
    }

    @StoreThread
    public final Integer getMaxViewersForStream(long userId, long channelId, Long guildId) {
        return this.streamViewerTracker.getMaxViewers((guildId != null ? new ModelApplicationStream.GuildStream(guildId.longValue(), channelId, userId) : new ModelApplicationStream.CallStream(channelId, userId)).getEncodedStreamKey());
    }

    public final Map<Long, ModelApplicationStream> getStreamsByUser() {
        return this.streamsByUserSnapshot;
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        C12238m.checkNotNullParameter(payload, "payload");
        addBreadCrumb("Connection open, clearing streams by user.");
        this.streamsByUser.clear();
        this.streamViewerTracker.clear();
        ActiveApplicationStream activeApplicationStream = this.activeApplicationStream;
        if (activeApplicationStream != null && activeApplicationStream.getState() != ActiveApplicationStream.State.ENDED) {
            targetStream(activeApplicationStream.getStream().getEncodedStreamKey(), true);
        }
        List<Guild> guilds = payload.getGuilds();
        C12238m.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            List<VoiceState> listM7853R = guild.m7853R();
            if (listM7853R != null) {
                Iterator<T> it = listM7853R.iterator();
                while (it.hasNext()) {
                    handleVoiceStateUpdate((VoiceState) it.next(), guild.getId());
                }
            }
        }
        markChanged();
    }

    @StoreThread
    public final void handleStreamCreate(StreamCreateOrUpdate streamCreate) {
        C12238m.checkNotNullParameter(streamCreate, "streamCreate");
        this.streamViewerTracker.remove(streamCreate.getStreamKey());
        handleStreamCreateOrUpdate(streamCreate.getStreamKey(), streamCreate.getPaused(), streamCreate.getViewerIds());
    }

    @StoreThread
    public final void handleStreamCreateRequest(String streamKey) {
        C12238m.checkNotNullParameter(streamKey, "streamKey");
        updateActiveApplicationStream(new ActiveApplicationStream(ActiveApplicationStream.State.CONNECTING, ModelApplicationStream.INSTANCE.decodeStreamKey(streamKey)));
        markChanged();
    }

    @StoreThread
    public final void handleStreamDelete(StreamDelete streamDelete) {
        ModelApplicationStream stream;
        ActiveApplicationStream activeApplicationStream;
        C12238m.checkNotNullParameter(streamDelete, "streamDelete");
        this.streamSpectators.remove(streamDelete.getStreamKey());
        if (streamDelete.getReason() == StreamDelete.Reason.STREAM_FULL) {
            updateActiveApplicationStream(new ActiveApplicationStream(ActiveApplicationStream.State.DENIED_FULL, ModelApplicationStream.INSTANCE.decodeStreamKey(streamDelete.getStreamKey())));
            markChanged();
            return;
        }
        ActiveApplicationStream activeApplicationStream2 = this.activeApplicationStream;
        if (activeApplicationStream2 == null || (stream = activeApplicationStream2.getStream()) == null) {
            stream = this.targetStream;
        }
        ActiveApplicationStream activeApplicationStreamCopy$default = null;
        if (C12238m.areEqual(stream != null ? stream.getEncodedStreamKey() : null, streamDelete.getStreamKey())) {
            if (streamDelete.getUnavailable()) {
                ActiveApplicationStream activeApplicationStream3 = this.activeApplicationStream;
                if (activeApplicationStream3 != null) {
                    activeApplicationStreamCopy$default = ActiveApplicationStream.copy$default(activeApplicationStream3, ActiveApplicationStream.State.RECONNECTING, null, 2, null);
                }
            } else if (streamDelete.getReason() != StreamDelete.Reason.USER_REQUESTED && (activeApplicationStream = this.activeApplicationStream) != null) {
                activeApplicationStreamCopy$default = ActiveApplicationStream.copy$default(activeApplicationStream, ActiveApplicationStream.State.ENDED, null, 2, null);
            }
            updateActiveApplicationStream(activeApplicationStreamCopy$default);
            markChanged();
        }
    }

    @StoreThread
    public final void handleStreamTargeted(String streamKey) {
        C12238m.checkNotNullParameter(streamKey, "streamKey");
        ModelApplicationStream modelApplicationStreamDecodeStreamKey = ModelApplicationStream.INSTANCE.decodeStreamKey(streamKey);
        ActiveApplicationStream activeApplicationStream = this.activeApplicationStream;
        if (C12238m.areEqual(modelApplicationStreamDecodeStreamKey, activeApplicationStream != null ? activeApplicationStream.getStream() : null) && activeApplicationStream.getState().isStreamActive()) {
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
        C12238m.checkNotNullParameter(streamUpdate, "streamUpdate");
        handleStreamCreateOrUpdate(streamUpdate.getStreamKey(), streamUpdate.getPaused(), streamUpdate.getViewerIds());
    }

    @StoreThread
    public final void handleStreamWatch(String streamKey) {
        C12238m.checkNotNullParameter(streamKey, "streamKey");
        updateActiveApplicationStream(new ActiveApplicationStream(ActiveApplicationStream.State.CONNECTING, ModelApplicationStream.INSTANCE.decodeStreamKey(streamKey)));
        markChanged();
    }

    @StoreThread
    public final void handleVoiceChannelSelected(long channelId) {
        ModelApplicationStream stream;
        ModelApplicationStream modelApplicationStream = this.targetStream;
        if (modelApplicationStream != null && channelId == modelApplicationStream.getChannelId()) {
            StoreStream storeStream = this.storeStream;
            ModelApplicationStream modelApplicationStream2 = this.targetStream;
            C12238m.checkNotNull(modelApplicationStream2);
            storeStream.streamWatch(modelApplicationStream2.getEncodedStreamKey());
            this.targetStream = null;
            return;
        }
        ActiveApplicationStream activeApplicationStream = this.activeApplicationStream;
        if (activeApplicationStream == null || (stream = activeApplicationStream.getStream()) == null || stream.getChannelId() != channelId) {
            updateActiveApplicationStream(null);
            this.targetStream = null;
            markChanged();
        }
    }

    @StoreThread
    public final void handleVoiceStateUpdate(VoiceState voiceState, long guildId) {
        C12238m.checkNotNullParameter(voiceState, "voiceState");
        addBreadCrumb("Handling a voice state update for " + voiceState.getUserId());
        Long lM8328a = voiceState.getChannelId();
        long jM8340m = voiceState.getUserId();
        boolean zM8336i = voiceState.getSelfStream();
        boolean z2 = guildId != 0;
        boolean z3 = (lM8328a == null || lM8328a.longValue() == 0) ? false : true;
        if (zM8336i && z2 && z3) {
            HashMap<Long, ModelApplicationStream> map = this.streamsByUser;
            Long lValueOf = Long.valueOf(jM8340m);
            C12238m.checkNotNull(lM8328a);
            map.put(lValueOf, new ModelApplicationStream.GuildStream(guildId, lM8328a.longValue(), jM8340m));
            markChanged();
        } else if (zM8336i && z3) {
            HashMap<Long, ModelApplicationStream> map2 = this.streamsByUser;
            Long lValueOf2 = Long.valueOf(jM8340m);
            C12238m.checkNotNull(lM8328a);
            map2.put(lValueOf2, new ModelApplicationStream.CallStream(lM8328a.longValue(), jM8340m));
            markChanged();
        } else if (this.streamsByUser.containsKey(Long.valueOf(jM8340m))) {
            this.streamsByUser.remove(Long.valueOf(jM8340m));
            markChanged();
        }
        ActiveApplicationStream activeApplicationStream = this.activeApplicationStream;
        if (activeApplicationStream != null && jM8340m == this.userStore.getMe().getId()) {
            long channelId = activeApplicationStream.getStream().getChannelId();
            Long lM8328a2 = voiceState.getChannelId();
            if (lM8328a2 == null || channelId != lM8328a2.longValue()) {
                updateActiveApplicationStream(null);
                markChanged();
            }
        }
        ModelApplicationStream modelApplicationStream = this.streamsByUser.get(Long.valueOf(jM8340m));
        if (zM8336i && modelApplicationStream != null && activeApplicationStream != null && C12238m.areEqual(modelApplicationStream.getEncodedStreamKey(), activeApplicationStream.getStream().getEncodedStreamKey()) && activeApplicationStream.getState() == ActiveApplicationStream.State.ENDED) {
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

    public final Observable<ActiveApplicationStream> observeActiveStream() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C57451(), 14, null);
    }

    public final Observable<Map<String, List<Long>>> observeStreamSpectators() {
        Observable<Map<String, List<Long>>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C57461(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck\n        …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<Long, ModelApplicationStream>> observeStreamsByUser() {
        Observable<Map<Long, ModelApplicationStream>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C57471(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck\n        …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<Long, ModelApplicationStream>> observeStreamsForGuild(long guildId) {
        Observable<Map<Long, ModelApplicationStream>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C57481(guildId), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck\n        …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<ModelApplicationStream> observeStreamsForUser(long userId) {
        Observable<ModelApplicationStream> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C57491(userId), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck\n        …  .distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() throws Exception {
        super.snapshotData();
        StringBuilder sbM833U = C1643a.m833U("Snapshotting 'streamsByUser' of size, ");
        sbM833U.append(this.streamsByUser.size());
        addBreadCrumb(sbM833U.toString());
        try {
            this.streamsByUserSnapshot = new HashMap(this.streamsByUser);
            this.streamSpectatorsSnapshot = new HashMap(this.streamSpectators);
        } catch (Exception e) {
            dumpBreadcrumbs();
            throw e;
        }
    }

    public final void stopStream(String streamKey) {
        C12238m.checkNotNullParameter(streamKey, "streamKey");
        this.dispatcher.schedule(new C57501(streamKey));
    }

    public final void targetStream(String streamKey, boolean force) {
        C12238m.checkNotNullParameter(streamKey, "streamKey");
        this.dispatcher.schedule(new C57511(streamKey, force));
    }

    public StoreApplicationStreaming(StoreStream storeStream, Dispatcher dispatcher, StoreUser storeUser, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreRtcConnection storeRtcConnection, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(storeStream, "storeStream");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(storeUser, "userStore");
        C12238m.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        C12238m.checkNotNullParameter(storeRtcConnection, "rtcConnectionStore");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        this.userStore = storeUser;
        this.voiceChannelSelectedStore = storeVoiceChannelSelected;
        this.rtcConnectionStore = storeRtcConnection;
        this.observationDeck = observationDeck;
        this.breadCrumbs = new ArrayDeque<>();
        this.streamsByUser = new HashMap<>();
        this.streamsByUserSnapshot = C12136h0.emptyMap();
        this.streamSpectators = new HashMap<>();
        this.streamSpectatorsSnapshot = C12136h0.emptyMap();
        this.streamViewerTracker = new StreamViewerTracker();
        addBreadCrumb("Initializing the store.");
    }

    private final boolean isScreenSharing(ActiveApplicationStream activeApplicationStream) {
        return activeApplicationStream != null && activeApplicationStream.getStream().getOwnerId() == this.userStore.getMe().getId();
    }
}
