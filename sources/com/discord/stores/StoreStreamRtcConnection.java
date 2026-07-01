package com.discord.stores;

import androidx.core.app.NotificationCompat;
import b.a.q.j;
import b.a.q.w;
import b.d.b.a.a;
import com.discord.app.App;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelApplicationStream$CallStream;
import com.discord.models.domain.ModelApplicationStream$GuildStream;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.StreamCreateOrUpdate;
import com.discord.models.domain.StreamServerUpdate;
import com.discord.rtcconnection.MediaSinkWantsManager;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.RtcConnection$Metadata;
import com.discord.rtcconnection.RtcConnection$Quality;
import com.discord.rtcconnection.RtcConnection$State;
import com.discord.rtcconnection.RtcConnection$State$d;
import com.discord.rtcconnection.RtcConnection$State$f;
import com.discord.rtcconnection.RtcConnection$d$b;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.collections.ListenerCollection;
import com.discord.utilities.collections.ListenerCollectionSubject;
import com.discord.utilities.debug.DebugPrintBuilder;
import com.discord.utilities.debug.DebugPrintable;
import com.discord.utilities.debug.DebugPrintableCollection;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.networking.NetworkMonitor;
import com.discord.utilities.ssl.SecureSocketsLayerUtils;
import com.discord.utilities.systemlog.SystemLogUtils;
import com.discord.utilities.time.Clock;
import d0.z.d.m;
import java.util.Map;
import java.util.Objects;
import javax.net.ssl.SSLSocketFactory;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreStreamRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStreamRtcConnection extends StoreV2 implements DebugPrintable {
    public static final StoreStreamRtcConnection$Companion Companion = new StoreStreamRtcConnection$Companion(null);
    public static final float MAX_STREAM_VOLUME = 300.0f;
    private static int instanceCounter;
    private final StoreAnalytics analyticsStore;
    private final Clock clock;
    private final long debugDisplayId;
    private final Dispatcher dispatcher;
    private final DebugPrintableCollection dpc;
    private final ListenerCollectionSubject<StoreStreamRtcConnection$Listener> listenerSubject;
    private final ListenerCollection<StoreStreamRtcConnection$Listener> listeners;
    private final Logger logger;
    private final String loggingTag;
    private final StoreMediaEngine mediaEngineStore;
    private NetworkMonitor networkMonitor;
    private final ObservationDeck observationDeck;
    private RtcConnection rtcConnection;
    private String sessionId;
    private StoreStreamRtcConnection$State state;
    private final StoreRtcConnection storeRtcConnection;
    private final StoreStream storeStream;
    private Long streamOwner;
    private float streamVolume;
    private final StoreUser userStore;

    public /* synthetic */ StoreStreamRtcConnection(StoreMediaEngine storeMediaEngine, StoreUser storeUser, StoreStream storeStream, Dispatcher dispatcher, Clock clock, StoreAnalytics storeAnalytics, StoreRtcConnection storeRtcConnection, ObservationDeck observationDeck, Logger logger, DebugPrintableCollection debugPrintableCollection, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeMediaEngine, storeUser, storeStream, dispatcher, clock, storeAnalytics, storeRtcConnection, (i & 128) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 256) != 0 ? AppLog.g : logger, (i & 512) != 0 ? SystemLogUtils.INSTANCE.getDebugPrintables$app_productionGoogleRelease() : debugPrintableCollection);
    }

    public static final /* synthetic */ StoreAnalytics access$getAnalyticsStore$p(StoreStreamRtcConnection storeStreamRtcConnection) {
        return storeStreamRtcConnection.analyticsStore;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreStreamRtcConnection storeStreamRtcConnection) {
        return storeStreamRtcConnection.dispatcher;
    }

    public static final /* synthetic */ ListenerCollectionSubject access$getListenerSubject$p(StoreStreamRtcConnection storeStreamRtcConnection) {
        return storeStreamRtcConnection.listenerSubject;
    }

    public static final /* synthetic */ RtcConnection access$getRtcConnection$p(StoreStreamRtcConnection storeStreamRtcConnection) {
        return storeStreamRtcConnection.rtcConnection;
    }

    public static final /* synthetic */ StoreStream access$getStoreStream$p(StoreStreamRtcConnection storeStreamRtcConnection) {
        return storeStreamRtcConnection.storeStream;
    }

    public static final /* synthetic */ Long access$getStreamOwner$p(StoreStreamRtcConnection storeStreamRtcConnection) {
        return storeStreamRtcConnection.streamOwner;
    }

    public static final /* synthetic */ float access$getStreamVolume$p(StoreStreamRtcConnection storeStreamRtcConnection) {
        return storeStreamRtcConnection.streamVolume;
    }

    public static final /* synthetic */ void access$handleMediaSessionIdReceived(StoreStreamRtcConnection storeStreamRtcConnection) {
        storeStreamRtcConnection.handleMediaSessionIdReceived();
    }

    public static final /* synthetic */ void access$handleQualityUpdate(StoreStreamRtcConnection storeStreamRtcConnection, RtcConnection$Quality rtcConnection$Quality) {
        storeStreamRtcConnection.handleQualityUpdate(rtcConnection$Quality);
    }

    public static final /* synthetic */ void access$handleVideoStreamEndedAnalyticsEvent(StoreStreamRtcConnection storeStreamRtcConnection, Map map) {
        storeStreamRtcConnection.handleVideoStreamEndedAnalyticsEvent(map);
    }

    public static final /* synthetic */ void access$recordBreadcrumb(StoreStreamRtcConnection storeStreamRtcConnection, String str) {
        storeStreamRtcConnection.recordBreadcrumb(str);
    }

    public static final /* synthetic */ void access$setRtcConnection$p(StoreStreamRtcConnection storeStreamRtcConnection, RtcConnection rtcConnection) {
        storeStreamRtcConnection.rtcConnection = rtcConnection;
    }

    public static final /* synthetic */ void access$setStreamOwner$p(StoreStreamRtcConnection storeStreamRtcConnection, Long l) {
        storeStreamRtcConnection.streamOwner = l;
    }

    public static final /* synthetic */ void access$setStreamVolume$p(StoreStreamRtcConnection storeStreamRtcConnection, float f) {
        storeStreamRtcConnection.streamVolume = f;
    }

    @StoreThread
    private final RtcConnection createRtcConnection(long userId, Long guildId, long channelId, String sessionId, String rtcServerId, long senderId, String streamKey) {
        destroyRtcConnection();
        RtcConnection$Metadata rtcConnectionMetadata = this.storeRtcConnection.getRtcConnectionMetadata();
        String str = null;
        Long l = rtcConnectionMetadata != null ? rtcConnectionMetadata.channelId : null;
        if (l != null && l.longValue() == channelId) {
            str = rtcConnectionMetadata.mediaSessionId;
        }
        String str2 = str;
        this.listenerSubject.notify(StoreStreamRtcConnection$createRtcConnection$1.INSTANCE);
        MediaEngine mediaEngine = this.mediaEngineStore.getMediaEngine();
        Logger logger = this.logger;
        Clock clock = this.clock;
        RtcConnection$d$b rtcConnection$d$b = new RtcConnection$d$b(senderId);
        NetworkMonitor networkMonitor = this.networkMonitor;
        if (networkMonitor == null) {
            m.throwUninitializedPropertyAccessException("networkMonitor");
        }
        RtcConnection rtcConnection = new RtcConnection(guildId, channelId, sessionId, true, rtcServerId, userId, mediaEngine, logger, clock, rtcConnection$d$b, networkMonitor, null, null, str2, false, this.loggingTag, streamKey, 6144);
        rtcConnection.c(new StoreStreamRtcConnection$RtcConnectionListener(this));
        return rtcConnection;
    }

    @StoreThread
    private final void destroyRtcConnection() {
        if (this.rtcConnection != null) {
            recordBreadcrumb("destroying stream rtc connection");
            updateRtcConnection(null);
            this.state = StoreStreamRtcConnection$State.copy$default(this.state, null, null, null, null, 9, null);
            markChanged();
        }
    }

    @StoreThread
    private final void handleMediaSessionIdReceived() {
        RtcConnection rtcConnection = this.rtcConnection;
        this.state = StoreStreamRtcConnection$State.copy$default(this.state, null, null, rtcConnection != null ? rtcConnection.mediaSessionId : null, null, 11, null);
        markChanged();
    }

    @StoreThread
    private final void handleQualityUpdate(RtcConnection$Quality quality) {
        this.state = StoreStreamRtcConnection$State.copy$default(this.state, null, quality, null, null, 13, null);
        markChanged();
    }

    @StoreThread
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

    @StoreThread
    private final void updateRtcConnection(RtcConnection rtcConnection) {
        RtcConnection rtcConnection2 = this.rtcConnection;
        if (rtcConnection2 != null) {
            rtcConnection2.e();
        }
        this.rtcConnection = rtcConnection;
        this.state = StoreStreamRtcConnection$State.copy$default(this.state, null, null, null, rtcConnection, 7, null);
        markChanged();
    }

    @Override // com.discord.utilities.debug.DebugPrintable
    public void debugPrint(DebugPrintBuilder dp) {
        m.checkNotNullParameter(dp, "dp");
        dp.appendKeyValue("sessionId", this.sessionId);
        dp.appendKeyValue("streamOwner", this.streamOwner);
        dp.appendKeyValue("streamVolume", Float.valueOf(this.streamVolume));
        dp.appendKeyValue("state", this.state);
        dp.appendKeyValue("rtcConnection", (DebugPrintable) this.rtcConnection);
    }

    public final void finalize() {
        this.dpc.remove(this.debugDisplayId);
    }

    public final ListenerCollection<StoreStreamRtcConnection$Listener> getListeners() {
        return this.listeners;
    }

    public final StoreStreamRtcConnection$State getState() {
        return this.state;
    }

    public final float getStreamVolume() {
        return this.streamVolume;
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        this.sessionId = payload.getSessionId();
    }

    @StoreThread
    public final void handleStreamCreate(StreamCreateOrUpdate streamCreate) {
        Long lValueOf;
        m.checkNotNullParameter(streamCreate, "streamCreate");
        ModelApplicationStream modelApplicationStreamDecodeStreamKey = ModelApplicationStream.Companion.decodeStreamKey(streamCreate.getStreamKey());
        long id2 = this.userStore.getMe().getId();
        String str = this.sessionId;
        if (str != null) {
            RtcConnection rtcConnection = this.rtcConnection;
            if (rtcConnection != null && rtcConnection.channelId == modelApplicationStreamDecodeStreamKey.getChannelId()) {
                RtcConnection rtcConnection2 = this.rtcConnection;
                if (m.areEqual(rtcConnection2 != null ? rtcConnection2.sessionId : null, str)) {
                    return;
                }
            }
            if (modelApplicationStreamDecodeStreamKey instanceof ModelApplicationStream$GuildStream) {
                lValueOf = Long.valueOf(((ModelApplicationStream$GuildStream) modelApplicationStreamDecodeStreamKey).getGuildId());
            } else {
                if (!(modelApplicationStreamDecodeStreamKey instanceof ModelApplicationStream$CallStream)) {
                    throw new NoWhenBranchMatchedException();
                }
                lValueOf = null;
            }
            long channelId = modelApplicationStreamDecodeStreamKey.getChannelId();
            String rtcServerId = streamCreate.getRtcServerId();
            m.checkNotNull(rtcServerId);
            updateRtcConnection(createRtcConnection(id2, lValueOf, channelId, str, rtcServerId, modelApplicationStreamDecodeStreamKey.getOwnerId(), streamCreate.getStreamKey()));
            this.streamOwner = Long.valueOf(modelApplicationStreamDecodeStreamKey.getOwnerId());
        }
    }

    @StoreThread
    public final void handleStreamDelete() {
        RtcConnection rtcConnection = this.rtcConnection;
        if (rtcConnection != null) {
            rtcConnection.t(null, null);
        }
        destroyRtcConnection();
        this.streamOwner = null;
    }

    @StoreThread
    public final void handleStreamRtcConnectionStateChange(RtcConnection$State state) {
        Long l;
        m.checkNotNullParameter(state, "state");
        if (m.areEqual(state, RtcConnection$State$f.a) && (l = this.streamOwner) != null) {
            long jLongValue = l.longValue();
            RtcConnection rtcConnection = this.rtcConnection;
            if (rtcConnection != null) {
                rtcConnection.v(jLongValue, this.streamVolume);
            }
        }
        this.state = StoreStreamRtcConnection$State.copy$default(this.state, state, null, null, null, 12, null);
        markChanged();
    }

    @StoreThread
    public final void handleStreamServerUpdate(StreamServerUpdate streamServerUpdate) {
        m.checkNotNullParameter(streamServerUpdate, "streamServerUpdate");
        Objects.requireNonNull(App.Companion);
        SSLSocketFactory sSLSocketFactoryCreateSocketFactory$default = App.access$getIS_LOCAL$cp() ? null : SecureSocketsLayerUtils.createSocketFactory$default(null, 1, null);
        StringBuilder sbU = a.U("Voice stream update, connect to server w/ endpoint: ");
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
        m.checkNotNullParameter(networkMonitor, "networkMonitor");
        this.networkMonitor = networkMonitor;
    }

    public final Observable<RtcConnection$Quality> observeConnectionQuality() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreStreamRtcConnection$observeConnectionQuality$1(this), 14, null);
    }

    public final Observable<RtcConnection> observeRtcConnection() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreStreamRtcConnection$observeRtcConnection$1(this), 14, null);
    }

    public final Observable<Float> observeStreamVolume() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreStreamRtcConnection$observeStreamVolume$1(this), 14, null);
    }

    public final void updateFocusedParticipant(Long focusedParticipant) {
        MediaSinkWantsManager mediaSinkWantsManager;
        RtcConnection rtcConnection = this.rtcConnection;
        if (rtcConnection == null || (mediaSinkWantsManager = rtcConnection.localMediaSinkWantsManager) == null) {
            return;
        }
        mediaSinkWantsManager.b(new j(mediaSinkWantsManager, focusedParticipant));
    }

    public final void updateStreamVolume(float volume) {
        this.dispatcher.schedule(new StoreStreamRtcConnection$updateStreamVolume$1(this, volume));
    }

    public StoreStreamRtcConnection(StoreMediaEngine storeMediaEngine, StoreUser storeUser, StoreStream storeStream, Dispatcher dispatcher, Clock clock, StoreAnalytics storeAnalytics, StoreRtcConnection storeRtcConnection, ObservationDeck observationDeck, Logger logger, DebugPrintableCollection debugPrintableCollection) {
        m.checkNotNullParameter(storeMediaEngine, "mediaEngineStore");
        m.checkNotNullParameter(storeUser, "userStore");
        m.checkNotNullParameter(storeStream, "storeStream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(storeAnalytics, "analyticsStore");
        m.checkNotNullParameter(storeRtcConnection, "storeRtcConnection");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(logger, "logger");
        m.checkNotNullParameter(debugPrintableCollection, "dpc");
        this.mediaEngineStore = storeMediaEngine;
        this.userStore = storeUser;
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.analyticsStore = storeAnalytics;
        this.storeRtcConnection = storeRtcConnection;
        this.observationDeck = observationDeck;
        this.logger = logger;
        this.dpc = debugPrintableCollection;
        ListenerCollectionSubject<StoreStreamRtcConnection$Listener> listenerCollectionSubject = new ListenerCollectionSubject<>();
        this.listenerSubject = listenerCollectionSubject;
        this.listeners = listenerCollectionSubject;
        this.state = new StoreStreamRtcConnection$State(new RtcConnection$State$d(false), null, null, this.rtcConnection);
        this.streamVolume = 300.0f;
        StringBuilder sbU = a.U("StoreStreamRtcConnection ");
        int i = instanceCounter + 1;
        instanceCounter = i;
        sbU.append(i);
        String string = sbU.toString();
        this.loggingTag = string;
        this.debugDisplayId = debugPrintableCollection.add(this, string);
    }
}
