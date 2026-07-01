package com.discord.stores;

import androidx.core.app.NotificationCompat;
import b.a.q.MediaSinkWantsManager5;
import b.a.q.w;
import b.d.b.a.outline;
import com.discord.app.App;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelApplicationStream3;
import com.discord.models.domain.ModelApplicationStream7;
import com.discord.models.domain.ModelPayload;
import com.discord.rtcconnection.MediaSinkWantsManager;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.VideoMetadata;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.collections.ListenerCollection;
import com.discord.utilities.collections.ListenerCollection2;
import com.discord.utilities.debug.DebugPrintable;
import com.discord.utilities.debug.DebugPrintable2;
import com.discord.utilities.debug.DebugPrintable3;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.networking.NetworkMonitor;
import com.discord.utilities.ssl.SecureSocketsLayerUtils;
import com.discord.utilities.systemlog.SystemLogUtils;
import com.discord.utilities.time.Clock;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import java.util.Objects;
import javax.net.ssl.SSLSocketFactory;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreStreamRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStreamRtcConnection extends StoreV2 implements DebugPrintable {
    public static final float MAX_STREAM_VOLUME = 300.0f;
    private static int instanceCounter;
    private final StoreAnalytics analyticsStore;
    private final Clock clock;
    private final long debugDisplayId;
    private final Dispatcher dispatcher;
    private final DebugPrintable3 dpc;
    private final ListenerCollection2<Listener> listenerSubject;
    private final ListenerCollection<Listener> listeners;
    private final Logger logger;
    private final String loggingTag;
    private final StoreMediaEngine mediaEngineStore;
    private NetworkMonitor networkMonitor;
    private final ObservationDeck observationDeck;
    private RtcConnection rtcConnection;
    private String sessionId;
    private State state;
    private final StoreRtcConnection storeRtcConnection;
    private final StoreStream storeStream;
    private Long streamOwner;
    private float streamVolume;
    private final StoreUser userStore;

    /* JADX INFO: compiled from: StoreStreamRtcConnection.kt */
    public static abstract class DefaultListener implements Listener {
        @Override // com.discord.stores.StoreStreamRtcConnection.Listener
        public void onConnected() {
        }

        @Override // com.discord.stores.StoreStreamRtcConnection.Listener
        public void onConnecting() {
        }

        @Override // com.discord.stores.StoreStreamRtcConnection.Listener
        public void onFirstFrameReceived(long ssrc) {
        }

        @Override // com.discord.stores.StoreStreamRtcConnection.Listener
        public void onFirstFrameSent() {
        }
    }

    /* JADX INFO: compiled from: StoreStreamRtcConnection.kt */
    public interface Listener {
        void onConnected();

        void onConnecting();

        /* synthetic */ void onFirstFrameReceived(long j);

        /* synthetic */ void onFirstFrameSent();
    }

    /* JADX INFO: compiled from: StoreStreamRtcConnection.kt */
    public final class RtcConnectionListener extends RtcConnection.b {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                RtcConnection.AnalyticsEvent.values();
                int[] iArr = new int[5];
                $EnumSwitchMapping$0 = iArr;
                iArr[RtcConnection.AnalyticsEvent.VIDEO_STREAM_ENDED.ordinal()] = 1;
                iArr[RtcConnection.AnalyticsEvent.MEDIA_SESSION_JOINED.ordinal()] = 2;
            }
        }

        public RtcConnectionListener() {
        }

        @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
        public void onAnalyticsEvent(RtcConnection.AnalyticsEvent event, Map<String, Object> properties) {
            Intrinsics3.checkNotNullParameter(event, "event");
            Intrinsics3.checkNotNullParameter(properties, "properties");
            int iOrdinal = event.ordinal();
            if (iOrdinal == 3) {
                StoreStreamRtcConnection.this.dispatcher.schedule(new StoreStreamRtcConnection$RtcConnectionListener$onAnalyticsEvent$1(this, properties));
            } else {
                if (iOrdinal != 4) {
                    return;
                }
                StoreStreamRtcConnection.this.analyticsStore.trackMediaSessionJoined(properties);
            }
        }

        @Override // com.discord.rtcconnection.RtcConnection.b
        public void onFirstFrameReceived(long ssrc) {
            StoreStreamRtcConnection.this.listenerSubject.notify(new StoreStreamRtcConnection$RtcConnectionListener$onFirstFrameReceived$1(ssrc));
        }

        @Override // com.discord.rtcconnection.RtcConnection.b
        public void onFirstFrameSent() {
            StoreStreamRtcConnection.this.listenerSubject.notify(StoreStreamRtcConnection$RtcConnectionListener$onFirstFrameSent$1.INSTANCE);
        }

        @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
        public void onMediaSessionIdReceived() {
            StoreStreamRtcConnection.this.dispatcher.schedule(new StoreStreamRtcConnection$RtcConnectionListener$onMediaSessionIdReceived$1(this));
        }

        @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
        public void onQualityUpdate(RtcConnection.Quality quality) {
            Intrinsics3.checkNotNullParameter(quality, "quality");
            StoreStreamRtcConnection.this.dispatcher.schedule(new StoreStreamRtcConnection$RtcConnectionListener$onQualityUpdate$1(this, quality));
        }

        @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
        public void onStateChange(RtcConnection.StateChange stateChange) {
            Intrinsics3.checkNotNullParameter(stateChange, "stateChange");
            StoreStreamRtcConnection.this.recordBreadcrumb("store state change: " + stateChange);
            if (Intrinsics3.areEqual(stateChange.state, RtcConnection.State.f.a)) {
                StoreStreamRtcConnection.this.listenerSubject.notify(StoreStreamRtcConnection$RtcConnectionListener$onStateChange$1.INSTANCE);
            }
            StoreStreamRtcConnection.this.dispatcher.schedule(new StoreStreamRtcConnection$RtcConnectionListener$onStateChange$2(this, stateChange));
        }

        @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
        public void onVideoMetadata(VideoMetadata metadata) {
            Intrinsics3.checkNotNullParameter(metadata, "metadata");
            StoreStreamRtcConnection.this.dispatcher.schedule(new StoreStreamRtcConnection$RtcConnectionListener$onVideoMetadata$1(this, metadata));
        }

        @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
        public void onVideoStream(long userId, Integer streamId, int audioSsrc, int videoSsrc, int rtxSsrc) {
            StoreStreamRtcConnection.this.dispatcher.schedule(new StoreStreamRtcConnection$RtcConnectionListener$onVideoStream$1(this, userId, streamId));
        }
    }

    /* JADX INFO: compiled from: StoreStreamRtcConnection.kt */
    public static final /* data */ class State {
        private final RtcConnection.Quality connectionQuality;
        private final String mediaSessionId;
        private final RtcConnection rtcConnection;
        private final RtcConnection.State rtcConnectionState;

        public State(RtcConnection.State state, RtcConnection.Quality quality, String str, RtcConnection rtcConnection) {
            Intrinsics3.checkNotNullParameter(state, "rtcConnectionState");
            this.rtcConnectionState = state;
            this.connectionQuality = quality;
            this.mediaSessionId = str;
            this.rtcConnection = rtcConnection;
        }

        public static /* synthetic */ State copy$default(State state, RtcConnection.State state2, RtcConnection.Quality quality, String str, RtcConnection rtcConnection, int i, Object obj) {
            if ((i & 1) != 0) {
                state2 = state.rtcConnectionState;
            }
            if ((i & 2) != 0) {
                quality = state.connectionQuality;
            }
            if ((i & 4) != 0) {
                str = state.mediaSessionId;
            }
            if ((i & 8) != 0) {
                rtcConnection = state.rtcConnection;
            }
            return state.copy(state2, quality, str, rtcConnection);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final RtcConnection.State getRtcConnectionState() {
            return this.rtcConnectionState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final RtcConnection.Quality getConnectionQuality() {
            return this.connectionQuality;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMediaSessionId() {
            return this.mediaSessionId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final RtcConnection getRtcConnection() {
            return this.rtcConnection;
        }

        public final State copy(RtcConnection.State rtcConnectionState, RtcConnection.Quality connectionQuality, String mediaSessionId, RtcConnection rtcConnection) {
            Intrinsics3.checkNotNullParameter(rtcConnectionState, "rtcConnectionState");
            return new State(rtcConnectionState, connectionQuality, mediaSessionId, rtcConnection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics3.areEqual(this.rtcConnectionState, state.rtcConnectionState) && Intrinsics3.areEqual(this.connectionQuality, state.connectionQuality) && Intrinsics3.areEqual(this.mediaSessionId, state.mediaSessionId) && Intrinsics3.areEqual(this.rtcConnection, state.rtcConnection);
        }

        public final RtcConnection.Quality getConnectionQuality() {
            return this.connectionQuality;
        }

        public final String getMediaSessionId() {
            return this.mediaSessionId;
        }

        public final RtcConnection getRtcConnection() {
            return this.rtcConnection;
        }

        public final RtcConnection.State getRtcConnectionState() {
            return this.rtcConnectionState;
        }

        public int hashCode() {
            RtcConnection.State state = this.rtcConnectionState;
            int iHashCode = (state != null ? state.hashCode() : 0) * 31;
            RtcConnection.Quality quality = this.connectionQuality;
            int iHashCode2 = (iHashCode + (quality != null ? quality.hashCode() : 0)) * 31;
            String str = this.mediaSessionId;
            int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            RtcConnection rtcConnection = this.rtcConnection;
            return iHashCode3 + (rtcConnection != null ? rtcConnection.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("State(rtcConnectionState=");
            sbU.append(this.rtcConnectionState);
            sbU.append(", connectionQuality=");
            sbU.append(this.connectionQuality);
            sbU.append(", mediaSessionId=");
            sbU.append(this.mediaSessionId);
            sbU.append(", rtcConnection=");
            sbU.append(this.rtcConnection);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStreamRtcConnection$createRtcConnection$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStreamRtcConnection.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Listener, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            Intrinsics3.checkNotNullParameter(listener, "it");
            listener.onConnecting();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStreamRtcConnection$observeConnectionQuality$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStreamRtcConnection.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<RtcConnection.Quality> {
        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RtcConnection.Quality invoke() {
            return StoreStreamRtcConnection.this.getState().getConnectionQuality();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStreamRtcConnection$observeRtcConnection$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStreamRtcConnection.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<RtcConnection> {
        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RtcConnection invoke() {
            return StoreStreamRtcConnection.this.getState().getRtcConnection();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStreamRtcConnection$observeStreamVolume$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStreamRtcConnection.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Float> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Float invoke() {
            return Float.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final float invoke2() {
            return StoreStreamRtcConnection.this.getStreamVolume();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStreamRtcConnection$updateStreamVolume$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStreamRtcConnection.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ float $volume;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(float f) {
            super(0);
            this.$volume = f;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreStreamRtcConnection.this.streamVolume = this.$volume;
            Long l = StoreStreamRtcConnection.this.streamOwner;
            if (l != null) {
                long jLongValue = l.longValue();
                RtcConnection rtcConnection = StoreStreamRtcConnection.this.rtcConnection;
                if (rtcConnection != null) {
                    rtcConnection.v(jLongValue, this.$volume);
                }
            }
            StoreStreamRtcConnection.this.markChanged();
        }
    }

    public /* synthetic */ StoreStreamRtcConnection(StoreMediaEngine storeMediaEngine, StoreUser storeUser, StoreStream storeStream, Dispatcher dispatcher, Clock clock, StoreAnalytics storeAnalytics, StoreRtcConnection storeRtcConnection, ObservationDeck observationDeck, Logger logger, DebugPrintable3 debugPrintable3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeMediaEngine, storeUser, storeStream, dispatcher, clock, storeAnalytics, storeRtcConnection, (i & 128) != 0 ? ObservationDeck4.get() : observationDeck, (i & 256) != 0 ? AppLog.g : logger, (i & 512) != 0 ? SystemLogUtils.INSTANCE.getDebugPrintables$app_productionGoogleRelease() : debugPrintable3);
    }

    @Store3
    private final RtcConnection createRtcConnection(long userId, Long guildId, long channelId, String sessionId, String rtcServerId, long senderId, String streamKey) {
        destroyRtcConnection();
        RtcConnection.Metadata rtcConnectionMetadata = this.storeRtcConnection.getRtcConnectionMetadata();
        String str = null;
        Long l = rtcConnectionMetadata != null ? rtcConnectionMetadata.channelId : null;
        if (l != null && l.longValue() == channelId) {
            str = rtcConnectionMetadata.mediaSessionId;
        }
        String str2 = str;
        this.listenerSubject.notify(AnonymousClass1.INSTANCE);
        MediaEngine mediaEngine = this.mediaEngineStore.getMediaEngine();
        Logger logger = this.logger;
        Clock clock = this.clock;
        RtcConnection.d.b bVar = new RtcConnection.d.b(senderId);
        NetworkMonitor networkMonitor = this.networkMonitor;
        if (networkMonitor == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("networkMonitor");
        }
        RtcConnection rtcConnection = new RtcConnection(guildId, channelId, sessionId, true, rtcServerId, userId, mediaEngine, logger, clock, bVar, networkMonitor, null, null, str2, false, this.loggingTag, streamKey, 6144);
        rtcConnection.c(new RtcConnectionListener());
        return rtcConnection;
    }

    @Store3
    private final void destroyRtcConnection() {
        if (this.rtcConnection != null) {
            recordBreadcrumb("destroying stream rtc connection");
            updateRtcConnection(null);
            this.state = State.copy$default(this.state, null, null, null, null, 9, null);
            markChanged();
        }
    }

    @Store3
    private final void handleMediaSessionIdReceived() {
        RtcConnection rtcConnection = this.rtcConnection;
        this.state = State.copy$default(this.state, null, null, rtcConnection != null ? rtcConnection.mediaSessionId : null, null, 11, null);
        markChanged();
    }

    @Store3
    private final void handleQualityUpdate(RtcConnection.Quality quality) {
        this.state = State.copy$default(this.state, null, quality, null, null, 13, null);
        markChanged();
    }

    @Store3
    private final void handleVideoStreamEndedAnalyticsEvent(Map<String, Object> properties) {
        this.analyticsStore.trackVideoStreamEnded(properties);
    }

    private final void loge(String msg, Throwable e, Map<String, String> metadata) {
        this.logger.e(this.loggingTag, msg, e, metadata);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loge$default(StoreStreamRtcConnection storeStreamRtcConnection, String str, Throwable th, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            map = null;
        }
        storeStreamRtcConnection.loge(str, th, map);
    }

    private final void logi(String msg, Throwable e) {
        this.logger.i(this.loggingTag, msg, e);
    }

    public static /* synthetic */ void logi$default(StoreStreamRtcConnection storeStreamRtcConnection, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        storeStreamRtcConnection.logi(str, th);
    }

    private final void logw(String msg) {
        Logger.w$default(this.logger, this.loggingTag, msg, null, 4, null);
    }

    private final void recordBreadcrumb(String message) {
        this.logger.recordBreadcrumb(message, this.loggingTag);
    }

    @Store3
    private final void updateRtcConnection(RtcConnection rtcConnection) {
        RtcConnection rtcConnection2 = this.rtcConnection;
        if (rtcConnection2 != null) {
            rtcConnection2.e();
        }
        this.rtcConnection = rtcConnection;
        this.state = State.copy$default(this.state, null, null, null, rtcConnection, 7, null);
        markChanged();
    }

    @Override // com.discord.utilities.debug.DebugPrintable
    public void debugPrint(DebugPrintable2 dp) {
        Intrinsics3.checkNotNullParameter(dp, "dp");
        dp.appendKeyValue("sessionId", this.sessionId);
        dp.appendKeyValue("streamOwner", this.streamOwner);
        dp.appendKeyValue("streamVolume", Float.valueOf(this.streamVolume));
        dp.appendKeyValue("state", this.state);
        dp.appendKeyValue("rtcConnection", (DebugPrintable) this.rtcConnection);
    }

    public final void finalize() {
        this.dpc.remove(this.debugDisplayId);
    }

    public final ListenerCollection<Listener> getListeners() {
        return this.listeners;
    }

    public final State getState() {
        return this.state;
    }

    public final float getStreamVolume() {
        return this.streamVolume;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.sessionId = payload.getSessionId();
    }

    @Store3
    public final void handleStreamCreate(ModelApplicationStream3 streamCreate) {
        Long lValueOf;
        Intrinsics3.checkNotNullParameter(streamCreate, "streamCreate");
        ModelApplicationStream modelApplicationStreamDecodeStreamKey = ModelApplicationStream.INSTANCE.decodeStreamKey(streamCreate.getStreamKey());
        long id2 = this.userStore.getMe().getId();
        String str = this.sessionId;
        if (str != null) {
            RtcConnection rtcConnection = this.rtcConnection;
            if (rtcConnection != null && rtcConnection.channelId == modelApplicationStreamDecodeStreamKey.getChannelId()) {
                RtcConnection rtcConnection2 = this.rtcConnection;
                if (Intrinsics3.areEqual(rtcConnection2 != null ? rtcConnection2.sessionId : null, str)) {
                    return;
                }
            }
            if (modelApplicationStreamDecodeStreamKey instanceof ModelApplicationStream.GuildStream) {
                lValueOf = Long.valueOf(((ModelApplicationStream.GuildStream) modelApplicationStreamDecodeStreamKey).getGuildId());
            } else {
                if (!(modelApplicationStreamDecodeStreamKey instanceof ModelApplicationStream.CallStream)) {
                    throw new NoWhenBranchMatchedException();
                }
                lValueOf = null;
            }
            long channelId = modelApplicationStreamDecodeStreamKey.getChannelId();
            String rtcServerId = streamCreate.getRtcServerId();
            Intrinsics3.checkNotNull(rtcServerId);
            updateRtcConnection(createRtcConnection(id2, lValueOf, channelId, str, rtcServerId, modelApplicationStreamDecodeStreamKey.getOwnerId(), streamCreate.getStreamKey()));
            this.streamOwner = Long.valueOf(modelApplicationStreamDecodeStreamKey.getOwnerId());
        }
    }

    @Store3
    public final void handleStreamDelete() {
        RtcConnection rtcConnection = this.rtcConnection;
        if (rtcConnection != null) {
            rtcConnection.t(null, null);
        }
        destroyRtcConnection();
        this.streamOwner = null;
    }

    @Store3
    public final void handleStreamRtcConnectionStateChange(RtcConnection.State state) {
        Long l;
        Intrinsics3.checkNotNullParameter(state, "state");
        if (Intrinsics3.areEqual(state, RtcConnection.State.f.a) && (l = this.streamOwner) != null) {
            long jLongValue = l.longValue();
            RtcConnection rtcConnection = this.rtcConnection;
            if (rtcConnection != null) {
                rtcConnection.v(jLongValue, this.streamVolume);
            }
        }
        this.state = State.copy$default(this.state, state, null, null, null, 12, null);
        markChanged();
    }

    @Store3
    public final void handleStreamServerUpdate(ModelApplicationStream7 streamServerUpdate) {
        Intrinsics3.checkNotNullParameter(streamServerUpdate, "streamServerUpdate");
        Objects.requireNonNull(App.INSTANCE);
        SSLSocketFactory sSLSocketFactoryCreateSocketFactory$default = App.IS_LOCAL ? null : SecureSocketsLayerUtils.createSocketFactory$default(null, 1, null);
        StringBuilder sbU = outline.U("Voice stream update, connect to server w/ endpoint: ");
        sbU.append(streamServerUpdate.getEndpoint());
        recordBreadcrumb(sbU.toString());
        RtcConnection rtcConnection = this.rtcConnection;
        if (rtcConnection == null) {
            loge$default(this, "handleStreamServerUpdate() rtcConnection is null.", null, null, 6, null);
        } else {
            rtcConnection.s(new w(rtcConnection, streamServerUpdate.getEndpoint(), streamServerUpdate.getToken(), sSLSocketFactoryCreateSocketFactory$default));
        }
    }

    public final void init(NetworkMonitor networkMonitor) {
        Intrinsics3.checkNotNullParameter(networkMonitor, "networkMonitor");
        this.networkMonitor = networkMonitor;
    }

    public final Observable<RtcConnection.Quality> observeConnectionQuality() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<RtcConnection> observeRtcConnection() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Float> observeStreamVolume() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final void updateFocusedParticipant(Long focusedParticipant) {
        MediaSinkWantsManager mediaSinkWantsManager;
        RtcConnection rtcConnection = this.rtcConnection;
        if (rtcConnection == null || (mediaSinkWantsManager = rtcConnection.localMediaSinkWantsManager) == null) {
            return;
        }
        mediaSinkWantsManager.b(new MediaSinkWantsManager5(mediaSinkWantsManager, focusedParticipant));
    }

    public final void updateStreamVolume(float volume) {
        this.dispatcher.schedule(new AnonymousClass1(volume));
    }

    public StoreStreamRtcConnection(StoreMediaEngine storeMediaEngine, StoreUser storeUser, StoreStream storeStream, Dispatcher dispatcher, Clock clock, StoreAnalytics storeAnalytics, StoreRtcConnection storeRtcConnection, ObservationDeck observationDeck, Logger logger, DebugPrintable3 debugPrintable3) {
        Intrinsics3.checkNotNullParameter(storeMediaEngine, "mediaEngineStore");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(storeStream, "storeStream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "analyticsStore");
        Intrinsics3.checkNotNullParameter(storeRtcConnection, "storeRtcConnection");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(debugPrintable3, "dpc");
        this.mediaEngineStore = storeMediaEngine;
        this.userStore = storeUser;
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.analyticsStore = storeAnalytics;
        this.storeRtcConnection = storeRtcConnection;
        this.observationDeck = observationDeck;
        this.logger = logger;
        this.dpc = debugPrintable3;
        ListenerCollection2<Listener> listenerCollection2 = new ListenerCollection2<>();
        this.listenerSubject = listenerCollection2;
        this.listeners = listenerCollection2;
        this.state = new State(new RtcConnection.State.d(false), null, null, this.rtcConnection);
        this.streamVolume = 300.0f;
        StringBuilder sbU = outline.U("StoreStreamRtcConnection ");
        int i = instanceCounter + 1;
        instanceCounter = i;
        sbU.append(i);
        String string = sbU.toString();
        this.loggingTag = string;
        this.debugDisplayId = debugPrintable3.add(this, string);
    }
}
