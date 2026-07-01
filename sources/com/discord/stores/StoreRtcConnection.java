package com.discord.stores;

import android.content.Context;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import b.a.q.w;
import b.d.b.a.a;
import co.discord.media_engine.VideoInputDeviceDescription;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.server.VoiceServer;
import com.discord.api.voice.state.VoiceState;
import com.discord.app.App;
import com.discord.app.AppLog;
import com.discord.gateway.io.OutgoingPayload$VoiceStateUpdate;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPayload;
import com.discord.models.experiments.domain.Experiment;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.RtcConnection$AnalyticsEvent;
import com.discord.rtcconnection.RtcConnection$Metadata;
import com.discord.rtcconnection.RtcConnection$Quality;
import com.discord.rtcconnection.RtcConnection$State$d;
import com.discord.rtcconnection.RtcConnection$State$f;
import com.discord.rtcconnection.RtcConnection$StateChange;
import com.discord.rtcconnection.RtcConnection$b;
import com.discord.rtcconnection.VideoMetadata;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.collections.ListenerCollection;
import com.discord.utilities.collections.ListenerCollectionSubject;
import com.discord.utilities.debug.DebugPrintBuilder;
import com.discord.utilities.debug.DebugPrintable;
import com.discord.utilities.debug.DebugPrintableCollection;
import com.discord.utilities.io.NetworkUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.networking.NetworkMonitor;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.ssl.SecureSocketsLayerUtils;
import com.discord.utilities.systemlog.SystemLogUtils;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import d0.t.h0;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreRtcConnection extends RtcConnection$b implements DebugPrintable {
    public static final StoreRtcConnection$Companion Companion = new StoreRtcConnection$Companion(null);
    private static final long SPEAKING_UPDATES_BUFFER_MS = 300;
    private static int instanceCounter;
    private final Clock clock;
    private final Observable<RtcConnection$StateChange> connectionState;
    private final SerializedSubject<RtcConnection$StateChange, RtcConnection$StateChange> connectionStateSubject;
    private Context context;
    private OutgoingPayload$VoiceStateUpdate currentVoiceState;
    private final long debugDisplayId;
    private final Dispatcher dispatcher;
    private final DebugPrintableCollection dpc;
    private boolean hasSelectedVoiceChannel;
    private Long joinedChannelTimestamp;
    private final ListenerCollectionSubject<StoreRtcConnection$Listener> listenerSubject;
    private final ListenerCollection<StoreRtcConnection$Listener> listeners;
    private final Logger logger;
    private final String loggingTag;
    private NetworkMonitor networkMonitor;
    private final Observable<RtcConnection$Quality> quality;
    private final BehaviorSubject<RtcConnection$Quality> qualitySubject;
    private RtcConnection rtcConnection;
    private RtcConnection$Metadata rtcConnectionMetadata;
    private final BehaviorSubject<RtcConnection$Metadata> rtcConnectionMetadataSubject;
    private Channel selectedVoiceChannel;
    private String sessionId;
    private final Observable<List<StoreRtcConnection$SpeakingUserUpdate>> speakingUpdates;
    private final PublishSubject<StoreRtcConnection$SpeakingUserUpdate> speakingUsersSubject;
    private final StoreAnalytics storeAnalytics;
    private final StoreRtcRegion storeRtcRegion;
    private final StoreVoiceStates storeVoiceStates;
    private final StoreStream stream;
    private VoicePropsTracker voicePropsTracker;
    private VoiceServer voiceServer;

    public /* synthetic */ StoreRtcConnection(StoreStream storeStream, Dispatcher dispatcher, Clock clock, StoreRtcRegion storeRtcRegion, StoreAnalytics storeAnalytics, StoreVoiceStates storeVoiceStates, Logger logger, DebugPrintableCollection debugPrintableCollection, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, clock, storeRtcRegion, storeAnalytics, storeVoiceStates, (i & 64) != 0 ? AppLog.g : logger, (i & 128) != 0 ? SystemLogUtils.INSTANCE.getDebugPrintables$app_productionGoogleRelease() : debugPrintableCollection);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreRtcConnection storeRtcConnection) {
        return storeRtcConnection.dispatcher;
    }

    public static final /* synthetic */ StoreAnalytics access$getStoreAnalytics$p(StoreRtcConnection storeRtcConnection) {
        return storeRtcConnection.storeAnalytics;
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreRtcConnection storeRtcConnection) {
        return storeRtcConnection.stream;
    }

    public static final /* synthetic */ VoicePropsTracker access$getVoicePropsTracker$p(StoreRtcConnection storeRtcConnection) {
        return storeRtcConnection.voicePropsTracker;
    }

    public static final /* synthetic */ void access$handleMediaSessionIdReceived(StoreRtcConnection storeRtcConnection) {
        storeRtcConnection.handleMediaSessionIdReceived();
    }

    public static final /* synthetic */ void access$handleSelfDeafened(StoreRtcConnection storeRtcConnection, boolean z2) {
        storeRtcConnection.handleSelfDeafened(z2);
    }

    public static final /* synthetic */ void access$handleSelfMuted(StoreRtcConnection storeRtcConnection, boolean z2) {
        storeRtcConnection.handleSelfMuted(z2);
    }

    public static final /* synthetic */ void access$handleSelfVideo(StoreRtcConnection storeRtcConnection, boolean z2) {
        storeRtcConnection.handleSelfVideo(z2);
    }

    public static final /* synthetic */ void access$handleUsersMuted(StoreRtcConnection storeRtcConnection, Map map) {
        storeRtcConnection.handleUsersMuted(map);
    }

    public static final /* synthetic */ void access$handleUsersOffScreen(StoreRtcConnection storeRtcConnection, Map map) {
        storeRtcConnection.handleUsersOffScreen(map);
    }

    public static final /* synthetic */ void access$handleUsersVolume(StoreRtcConnection storeRtcConnection, Map map) {
        storeRtcConnection.handleUsersVolume(map);
    }

    public static final /* synthetic */ void access$setVoicePropsTracker$p(StoreRtcConnection storeRtcConnection, VoicePropsTracker voicePropsTracker) {
        storeRtcConnection.voicePropsTracker = voicePropsTracker;
    }

    private final void applyVoiceConfiguration(RtcConnection rtcConnection, Long targetUserId) {
        StoreMediaSettings$VoiceConfiguration voiceConfigurationBlocking = this.stream.getMediaSettings().getVoiceConfigurationBlocking();
        for (Map$Entry<Long, Float> map$Entry : voiceConfigurationBlocking.getUserOutputVolumes().entrySet()) {
            long jLongValue = map$Entry.getKey().longValue();
            float fFloatValue = map$Entry.getValue().floatValue();
            if (targetUserId == null || jLongValue == targetUserId.longValue()) {
                rtcConnection.v(jLongValue, fFloatValue);
            }
        }
        for (Map$Entry<Long, Boolean> map$Entry2 : voiceConfigurationBlocking.getMutedUsers().entrySet()) {
            long jLongValue2 = map$Entry2.getKey().longValue();
            boolean zBooleanValue = map$Entry2.getValue().booleanValue();
            if (targetUserId == null || jLongValue2 == targetUserId.longValue()) {
                rtcConnection.mutedUsers.put(Long.valueOf(jLongValue2), Boolean.valueOf(zBooleanValue));
                MediaEngineConnection mediaEngineConnection = rtcConnection.mediaEngineConnection;
                if (mediaEngineConnection != null) {
                    mediaEngineConnection.w(jLongValue2, zBooleanValue);
                }
            }
        }
        for (Map$Entry<Long, Boolean> map$Entry3 : voiceConfigurationBlocking.getOffScreenUsers().entrySet()) {
            long jLongValue3 = map$Entry3.getKey().longValue();
            boolean zBooleanValue2 = map$Entry3.getValue().booleanValue();
            if (targetUserId == null || jLongValue3 == targetUserId.longValue()) {
                MediaEngineConnection mediaEngineConnection2 = rtcConnection.mediaEngineConnection;
                if (mediaEngineConnection2 == null) {
                    Log.e("RtcConnection", "MediaEngine not connected for setLocalVideoOffscreen.");
                } else {
                    mediaEngineConnection2.d(jLongValue3, zBooleanValue2);
                }
            }
        }
    }

    public static /* synthetic */ void applyVoiceConfiguration$default(StoreRtcConnection storeRtcConnection, RtcConnection rtcConnection, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        storeRtcConnection.applyVoiceConfiguration(rtcConnection, l);
    }

    @StoreThread
    private final void checkForVoiceServerUpdate() {
        String strB;
        RtcConnection rtcConnection = this.rtcConnection;
        VoiceServer voiceServer = this.voiceServer;
        if (rtcConnection == null || voiceServer == null) {
            return;
        }
        if (voiceServer.getGuildId() == null || !(!m.areEqual(voiceServer.getGuildId(), rtcConnection.guildId))) {
            if (voiceServer.getChannelId() != null) {
                Long lA = voiceServer.getChannelId();
                long j = rtcConnection.channelId;
                if (lA == null || lA.longValue() != j) {
                    return;
                }
            }
            Objects.requireNonNull(App.Companion);
            SSLSocketFactory sSLSocketFactoryCreateSocketFactory$default = null;
            if (App.access$getIS_LOCAL$cp()) {
                strB = "";
            } else {
                strB = voiceServer.getEndpoint();
                sSLSocketFactoryCreateSocketFactory$default = SecureSocketsLayerUtils.createSocketFactory$default(null, 1, null);
            }
            recordBreadcrumb(a.w("Voice server update, connect to server w/ endpoint: ", strB));
            rtcConnection.s(new w(rtcConnection, strB, voiceServer.getToken(), sSLSocketFactoryCreateSocketFactory$default));
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0031  */
    @StoreThread
    private final void createRtcConnection() {
        Long l;
        long id2 = this.stream.getUsers().getMe().getId();
        String str = this.sessionId;
        Channel channel = this.selectedVoiceChannel;
        if (channel != null) {
            Long lValueOf = Long.valueOf(channel.getGuildId());
            if (lValueOf.longValue() > 0) {
                l = lValueOf;
            } else {
                l = null;
            }
        } else {
            l = null;
        }
        Channel channel2 = this.selectedVoiceChannel;
        Long lValueOf2 = channel2 != null ? Long.valueOf(channel2.getId()) : null;
        MediaEngine mediaEngine = StoreStream.Companion.getMediaEngine().getMediaEngine();
        if (str == null || lValueOf2 == null) {
            return;
        }
        RtcConnection rtcConnection = this.rtcConnection;
        if (m.areEqual(rtcConnection != null ? Long.valueOf(rtcConnection.channelId) : null, lValueOf2)) {
            RtcConnection rtcConnection2 = this.rtcConnection;
            if (m.areEqual(rtcConnection2 != null ? rtcConnection2.sessionId : null, str)) {
                return;
            }
        }
        long jLongValue = l != null ? l.longValue() : 0L;
        this.voicePropsTracker = new VoicePropsTracker(jLongValue, lValueOf2.longValue(), id2, this.storeVoiceStates.get().get(Long.valueOf(jLongValue)));
        Experiment userExperiment = this.stream.getExperiments().getUserExperiment("2021-03_android_media_sink_wants", false);
        boolean z2 = userExperiment != null && userExperiment.getBucket() == 1;
        RtcConnection rtcConnection3 = this.rtcConnection;
        if (rtcConnection3 != null) {
            rtcConnection3.e();
        }
        long jLongValue2 = lValueOf2.longValue();
        String strValueOf = String.valueOf(l != null ? l.longValue() : lValueOf2.longValue());
        Logger logger = this.logger;
        String str2 = this.loggingTag;
        NetworkMonitor networkMonitor = this.networkMonitor;
        if (networkMonitor == null) {
            m.throwUninitializedPropertyAccessException("networkMonitor");
        }
        RtcConnection rtcConnection4 = new RtcConnection(l, jLongValue2, str, true, strValueOf, id2, mediaEngine, logger, ClockFactory.get(), null, networkMonitor, h0.toMutableMap(this.stream.getMediaSettings().getMutedUsers()), null, null, z2, str2, null, 78336);
        rtcConnection4.c(this);
        this.rtcConnection = rtcConnection4;
        this.listenerSubject.notify(StoreRtcConnection$createRtcConnection$1.INSTANCE);
        updateMetadata();
    }

    @StoreThread
    private final void destroyRtcConnection(String reason) {
        RtcConnection rtcConnection = this.rtcConnection;
        if (rtcConnection != null) {
            recordBreadcrumb(a.w("destroying rtc connection: ", reason));
            rtcConnection.e();
            this.rtcConnection = null;
            updateMetadata();
        }
    }

    @StoreThread
    private final void handleMediaSessionIdReceived() {
        AppLog appLog = AppLog.g;
        RtcConnection rtcConnection = this.rtcConnection;
        String str = rtcConnection != null ? rtcConnection.mediaSessionId : null;
        Objects.requireNonNull(appLog);
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        if (str == null) {
            str = "";
        }
        firebaseCrashlytics.setCustomKey("mediaSessionId", str);
        updateMetadata();
    }

    @StoreThread
    private final void handleSelfDeafened(boolean selfDeafened) {
        this.currentVoiceState = OutgoingPayload$VoiceStateUpdate.copy$default(this.currentVoiceState, null, null, false, selfDeafened, false, null, 55, null);
        onVoiceStateUpdated();
    }

    @StoreThread
    private final void handleSelfMuted(boolean selfMuted) {
        this.currentVoiceState = OutgoingPayload$VoiceStateUpdate.copy$default(this.currentVoiceState, null, null, selfMuted, false, false, null, 59, null);
        onVoiceStateUpdated();
    }

    @StoreThread
    private final void handleSelfVideo(boolean selfVideo) {
        this.currentVoiceState = OutgoingPayload$VoiceStateUpdate.copy$default(this.currentVoiceState, null, null, false, false, selfVideo, null, 47, null);
        onVoiceStateUpdated();
    }

    @StoreThread
    private final void handleUsersMuted(Map<Long, Boolean> usersMuted) {
        for (Map$Entry<Long, Boolean> map$Entry : usersMuted.entrySet()) {
            long jLongValue = map$Entry.getKey().longValue();
            boolean zBooleanValue = map$Entry.getValue().booleanValue();
            RtcConnection rtcConnection = this.rtcConnection;
            if (rtcConnection != null) {
                rtcConnection.mutedUsers.put(Long.valueOf(jLongValue), Boolean.valueOf(zBooleanValue));
                MediaEngineConnection mediaEngineConnection = rtcConnection.mediaEngineConnection;
                if (mediaEngineConnection != null) {
                    mediaEngineConnection.w(jLongValue, zBooleanValue);
                }
            }
        }
    }

    @StoreThread
    private final void handleUsersOffScreen(Map<Long, Boolean> usersOffScreen) {
        for (Map$Entry<Long, Boolean> map$Entry : usersOffScreen.entrySet()) {
            long jLongValue = map$Entry.getKey().longValue();
            boolean zBooleanValue = map$Entry.getValue().booleanValue();
            RtcConnection rtcConnection = this.rtcConnection;
            if (rtcConnection != null) {
                MediaEngineConnection mediaEngineConnection = rtcConnection.mediaEngineConnection;
                if (mediaEngineConnection == null) {
                    Log.e("RtcConnection", "MediaEngine not connected for setLocalVideoOffscreen.");
                } else {
                    mediaEngineConnection.d(jLongValue, zBooleanValue);
                }
            }
        }
    }

    @StoreThread
    private final void handleUsersVolume(Map<Long, Float> usersVolume) {
        for (Map$Entry<Long, Float> map$Entry : usersVolume.entrySet()) {
            long jLongValue = map$Entry.getKey().longValue();
            float fFloatValue = map$Entry.getValue().floatValue();
            RtcConnection rtcConnection = this.rtcConnection;
            if (rtcConnection != null) {
                rtcConnection.v(jLongValue, fFloatValue);
            }
        }
    }

    @StoreThread
    private final void logChannelJoin(Channel channel) {
        String str;
        long id2 = this.stream.getUsers().getMe().getId();
        RtcConnection rtcConnection = this.rtcConnection;
        if (rtcConnection == null || (str = rtcConnection.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_ID java.lang.String) == null) {
            return;
        }
        StageInstance stageInstanceForChannel = this.stream.getStageInstances().getStageInstanceForChannel(channel.getId());
        Long lValueOf = stageInstanceForChannel != null ? Long.valueOf(stageInstanceForChannel.getId()) : null;
        GuildScheduledEvent activeEventForChannel = this.stream.getGuildScheduledEvents().getActiveEventForChannel(Long.valueOf(channel.getGuildId()), Long.valueOf(channel.getId()));
        Long lValueOf2 = activeEventForChannel != null ? Long.valueOf(activeEventForChannel.getId()) : null;
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        Map<Long, VoiceState> mapEmptyMap = (Map) a.c(channel, this.stream.getVoiceStates().get());
        if (mapEmptyMap == null) {
            mapEmptyMap = h0.emptyMap();
        }
        Map<Long, VoiceState> map = mapEmptyMap;
        VideoInputDeviceDescription selectedVideoInputDeviceBlocking = this.stream.getMediaEngine().getSelectedVideoInputDevice();
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        Context context = this.context;
        if (context == null) {
            m.throwUninitializedPropertyAccessException("context");
        }
        analyticsTracker.voiceChannelJoin(id2, str, channel, map, selectedVideoInputDeviceBlocking, networkUtils.getNetworkType(context), lValueOf, lValueOf2);
    }

    @StoreThread
    private final void logChannelLeave(Channel channel) {
        String str;
        long id2 = this.stream.getUsers().getMe().getId();
        RtcConnection rtcConnection = this.rtcConnection;
        if (rtcConnection == null || (str = rtcConnection.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_ID java.lang.String) == null) {
            return;
        }
        String str2 = rtcConnection != null ? rtcConnection.mediaSessionId : null;
        StageInstance stageInstanceForChannel = this.stream.getStageInstances().getStageInstanceForChannel(channel.getId());
        Long lValueOf = stageInstanceForChannel != null ? Long.valueOf(stageInstanceForChannel.getId()) : null;
        GuildScheduledEvent activeEventForChannel = this.stream.getGuildScheduledEvents().getActiveEventForChannel(Long.valueOf(channel.getGuildId()), Long.valueOf(channel.getId()));
        Long lValueOf2 = activeEventForChannel != null ? Long.valueOf(activeEventForChannel.getId()) : null;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        VoicePropsTracker voicePropsTracker = this.voicePropsTracker;
        if (voicePropsTracker != null) {
            voicePropsTracker.getProps(linkedHashMap);
        }
        this.voicePropsTracker = null;
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        Map<Long, VoiceState> mapEmptyMap = (Map) a.c(channel, this.stream.getVoiceStates().get());
        if (mapEmptyMap == null) {
            mapEmptyMap = h0.emptyMap();
        }
        Map<Long, VoiceState> map = mapEmptyMap;
        Long l = this.joinedChannelTimestamp;
        analyticsTracker.voiceChannelLeave(id2, str, channel, map, str2, linkedHashMap, l != null ? Long.valueOf(this.clock.currentTimeMillis() - l.longValue()) : null, lValueOf, lValueOf2);
    }

    private final void loge(String msg, Throwable e, Map<String, String> metadata) {
        this.logger.e(this.loggingTag, msg, e, metadata);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loge$default(StoreRtcConnection storeRtcConnection, String str, Throwable th, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            map = null;
        }
        storeRtcConnection.loge(str, th, map);
    }

    private final void logi(String msg, Throwable e) {
        this.logger.i(this.loggingTag, msg, e);
    }

    public static /* synthetic */ void logi$default(StoreRtcConnection storeRtcConnection, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        storeRtcConnection.logi(str, th);
    }

    private final void logw(String msg) {
        Logger.w$default(this.logger, this.loggingTag, msg, null, 4, null);
    }

    @StoreThread
    private final void onVoiceStateUpdated() {
        String preferredRegion;
        if (this.hasSelectedVoiceChannel) {
            StringBuilder sbU = a.U("Voice state update: ");
            sbU.append(this.currentVoiceState);
            recordBreadcrumb(sbU.toString());
        }
        StoreGatewayConnection gatewaySocket = StoreStream.Companion.getGatewaySocket();
        Long guildId = this.currentVoiceState.getGuildId();
        Long channelId = this.currentVoiceState.getChannelId();
        boolean selfMute = this.currentVoiceState.getSelfMute();
        boolean selfDeaf = this.currentVoiceState.getSelfDeaf();
        boolean selfVideo = this.currentVoiceState.getSelfVideo();
        Long channelId2 = this.currentVoiceState.getChannelId();
        if (channelId2 != null) {
            channelId2.longValue();
            preferredRegion = this.storeRtcRegion.getPreferredRegion();
        } else {
            preferredRegion = null;
        }
        gatewaySocket.voiceStateUpdate(guildId, channelId, selfMute, selfDeaf, selfVideo, preferredRegion, this.storeRtcRegion.shouldIncludePreferredRegion(this.currentVoiceState.getGuildId()));
    }

    private final void recordBreadcrumb(String message) {
        this.logger.recordBreadcrumb(message, this.loggingTag);
    }

    @StoreThread
    private final void updateMetadata() {
        RtcConnection rtcConnection = this.rtcConnection;
        RtcConnection$Metadata rtcConnection$MetadataI = rtcConnection != null ? rtcConnection.i() : null;
        this.rtcConnectionMetadata = rtcConnection$MetadataI;
        this.rtcConnectionMetadataSubject.onNext(rtcConnection$MetadataI);
    }

    @Override // com.discord.utilities.debug.DebugPrintable
    public void debugPrint(DebugPrintBuilder dp) {
        m.checkNotNullParameter(dp, "dp");
        dp.appendKeyValue("sessionId", this.sessionId);
        dp.appendKeyValue("rtcConnection", (DebugPrintable) this.rtcConnection);
    }

    public final void finalize() {
        this.dpc.remove(this.debugDisplayId);
    }

    public final long getConnectedGuildId() {
        Long l;
        RtcConnection rtcConnection = this.rtcConnection;
        if (rtcConnection == null || (l = rtcConnection.guildId) == null) {
            return 0L;
        }
        return l.longValue();
    }

    public final Observable<RtcConnection$StateChange> getConnectionState() {
        return this.connectionState;
    }

    public final ListenerCollection<StoreRtcConnection$Listener> getListeners() {
        return this.listeners;
    }

    public final Observable<RtcConnection$Quality> getQuality() {
        return this.quality;
    }

    /* JADX INFO: renamed from: getRtcConnection$app_productionGoogleRelease, reason: from getter */
    public final RtcConnection getRtcConnection() {
        return this.rtcConnection;
    }

    @StoreThread
    public final RtcConnection$Metadata getRtcConnectionMetadata() {
        return this.rtcConnectionMetadata;
    }

    public final Observable<List<StoreRtcConnection$SpeakingUserUpdate>> getSpeakingUpdates() {
        return this.speakingUpdates;
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        this.sessionId = payload.getSessionId();
        RtcConnection rtcConnection = this.rtcConnection;
        if (rtcConnection != null) {
            String sessionId = payload.getSessionId();
            m.checkNotNullExpressionValue(sessionId, "payload.sessionId");
            m.checkNotNullParameter(sessionId, "<set-?>");
            rtcConnection.sessionId = sessionId;
        }
    }

    @StoreThread
    public final void handleConnectionReady(boolean connected) {
        if (connected) {
            Channel channel = this.selectedVoiceChannel;
            handleVoiceChannelSelected(Long.valueOf(channel != null ? channel.getId() : 0L));
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007b  */
    @StoreThread
    public final void handleVoiceChannelSelected(Long channelId) {
        Long l;
        Channel channel = this.selectedVoiceChannel;
        if (!m.areEqual(channelId, channel != null ? Long.valueOf(channel.getId()) : null)) {
            Channel channel2 = this.selectedVoiceChannel;
            if (channel2 != null) {
                logChannelLeave(channel2);
            }
            this.joinedChannelTimestamp = null;
            StringBuilder sb = new StringBuilder();
            sb.append("Channel ID changed, ");
            sb.append(channelId);
            sb.append(" != ");
            Channel channel3 = this.selectedVoiceChannel;
            sb.append(channel3 != null ? Long.valueOf(channel3.getId()) : null);
            destroyRtcConnection(sb.toString());
        }
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = channelId != null ? this.stream.getChannels().findChannelByIdInternal$app_productionGoogleRelease(channelId.longValue()) : null;
        this.selectedVoiceChannel = channelFindChannelByIdInternal$app_productionGoogleRelease;
        OutgoingPayload$VoiceStateUpdate outgoingPayload$VoiceStateUpdate = this.currentVoiceState;
        if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
            Long lValueOf = Long.valueOf(channelFindChannelByIdInternal$app_productionGoogleRelease.getGuildId());
            if (lValueOf.longValue() > 0) {
                l = lValueOf;
            } else {
                l = null;
            }
        } else {
            l = null;
        }
        this.currentVoiceState = OutgoingPayload$VoiceStateUpdate.copy$default(outgoingPayload$VoiceStateUpdate, l, channelFindChannelByIdInternal$app_productionGoogleRelease != null ? Long.valueOf(channelFindChannelByIdInternal$app_productionGoogleRelease.getId()) : null, false, false, false, null, 60, null);
        if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
            this.hasSelectedVoiceChannel = true;
            createRtcConnection();
            this.joinedChannelTimestamp = Long.valueOf(this.clock.currentTimeMillis());
            logChannelJoin(channelFindChannelByIdInternal$app_productionGoogleRelease);
        } else {
            this.voiceServer = null;
        }
        onVoiceStateUpdated();
    }

    @StoreThread
    public final void handleVoiceServerUpdate(VoiceServer voiceServer) {
        m.checkNotNullParameter(voiceServer, "voiceServer");
        recordBreadcrumb("handling voice server update: " + voiceServer);
        this.voiceServer = voiceServer;
        checkForVoiceServerUpdate();
    }

    @StoreThread
    public final void handleVoiceStateUpdate(VoiceState voiceState) {
        m.checkNotNullParameter(voiceState, "voiceState");
        VoicePropsTracker voicePropsTracker = this.voicePropsTracker;
        if (voicePropsTracker != null) {
            voicePropsTracker.handleVoiceStateUpdate(voiceState);
        }
    }

    @StoreThread
    public final void init(Context context, NetworkMonitor networkMonitor) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(networkMonitor, "networkMonitor");
        this.context = context;
        this.networkMonitor = networkMonitor;
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        ObservableExtensionsKt.appSubscribe$default(storeStream$Companion.getMediaSettings().isSelfMuted(), StoreRtcConnection.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreRtcConnection$init$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(storeStream$Companion.getMediaSettings().isSelfDeafened(), StoreRtcConnection.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreRtcConnection$init$2(this), 62, (Object) null);
        Observable<R> observableG = storeStream$Companion.getMediaEngine().getSelectedVideoInputDevice().G(StoreRtcConnection$init$3.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "StoreStream\n        .get…viceDescription != null }");
        ObservableExtensionsKt.appSubscribe$default(observableG, StoreRtcConnection.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreRtcConnection$init$4(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(this.stream.getMediaSettings().getUsersVolume(), StoreRtcConnection.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreRtcConnection$init$5(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(this.stream.getMediaSettings().getUsersMuted(), StoreRtcConnection.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreRtcConnection$init$6(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(this.stream.getMediaSettings().getUsersOffScreen(), StoreRtcConnection.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreRtcConnection$init$7(this), 62, (Object) null);
    }

    public final Observable<RtcConnection$Metadata> observeRtcConnectionMetadata() {
        BehaviorSubject<RtcConnection$Metadata> behaviorSubject = this.rtcConnectionMetadataSubject;
        m.checkNotNullExpressionValue(behaviorSubject, "rtcConnectionMetadataSubject");
        return behaviorSubject;
    }

    @Override // com.discord.rtcconnection.RtcConnection$b, com.discord.rtcconnection.RtcConnection$c
    public void onAnalyticsEvent(RtcConnection$AnalyticsEvent event, Map<String, Object> properties) {
        m.checkNotNullParameter(event, "event");
        m.checkNotNullParameter(properties, "properties");
        int iOrdinal = event.ordinal();
        if (iOrdinal == 0) {
            this.storeAnalytics.trackVoiceConnectionSuccess(properties);
            return;
        }
        if (iOrdinal == 1) {
            this.storeAnalytics.trackVoiceConnectionFailure(properties);
            return;
        }
        if (iOrdinal == 2) {
            this.storeAnalytics.trackVoiceDisconnect(properties);
        } else if (iOrdinal == 3) {
            this.dispatcher.schedule(new StoreRtcConnection$onAnalyticsEvent$1(this, properties));
        } else {
            if (iOrdinal != 4) {
                return;
            }
            this.storeAnalytics.trackMediaSessionJoined(properties);
        }
    }

    @Override // com.discord.rtcconnection.RtcConnection$b, com.discord.rtcconnection.RtcConnection$c
    public void onFatalClose() {
        this.stream.getVoiceChannelSelected().clear();
    }

    @Override // com.discord.rtcconnection.RtcConnection$b
    public void onFirstFrameReceived(long ssrc) {
        this.listenerSubject.notify(new StoreRtcConnection$onFirstFrameReceived$1(ssrc));
    }

    @Override // com.discord.rtcconnection.RtcConnection$b
    public void onFirstFrameSent() {
        this.listenerSubject.notify(StoreRtcConnection$onFirstFrameSent$1.INSTANCE);
    }

    @Override // com.discord.rtcconnection.RtcConnection$b, com.discord.rtcconnection.RtcConnection$c
    public void onMediaEngineConnectionConnected(RtcConnection connection) {
        m.checkNotNullParameter(connection, "connection");
        this.dispatcher.schedule(new StoreRtcConnection$onMediaEngineConnectionConnected$1(this, connection));
    }

    @Override // com.discord.rtcconnection.RtcConnection$b, com.discord.rtcconnection.RtcConnection$c
    public void onMediaSessionIdReceived() {
        this.dispatcher.schedule(new StoreRtcConnection$onMediaSessionIdReceived$1(this));
    }

    @Override // com.discord.rtcconnection.RtcConnection$b, com.discord.rtcconnection.RtcConnection$c
    public void onQualityUpdate(RtcConnection$Quality quality) {
        m.checkNotNullParameter(quality, "quality");
        this.qualitySubject.onNext(quality);
    }

    @Override // com.discord.rtcconnection.RtcConnection$b, com.discord.rtcconnection.RtcConnection$c
    public void onSpeaking(long userId, boolean isSpeaking) {
        PublishSubject<StoreRtcConnection$SpeakingUserUpdate> publishSubject = this.speakingUsersSubject;
        publishSubject.k.onNext(new StoreRtcConnection$SpeakingUserUpdate(userId, isSpeaking));
        this.dispatcher.schedule(new StoreRtcConnection$onSpeaking$1(this, userId, isSpeaking));
    }

    @Override // com.discord.rtcconnection.RtcConnection$b, com.discord.rtcconnection.RtcConnection$c
    public void onStateChange(RtcConnection$StateChange stateChange) {
        m.checkNotNullParameter(stateChange, "stateChange");
        recordBreadcrumb("connection state change: " + stateChange);
        this.connectionStateSubject.k.onNext(stateChange);
        if (m.areEqual(stateChange.state, RtcConnection$State$f.a)) {
            this.listenerSubject.notify(StoreRtcConnection$onStateChange$1.INSTANCE);
        }
    }

    @Override // com.discord.rtcconnection.RtcConnection$b, com.discord.rtcconnection.RtcConnection$c
    public void onUserCreated(RtcConnection connection, long userId) {
        m.checkNotNullParameter(connection, "connection");
        applyVoiceConfiguration(connection, Long.valueOf(userId));
    }

    @Override // com.discord.rtcconnection.RtcConnection$b, com.discord.rtcconnection.RtcConnection$c
    public void onVideoMetadata(VideoMetadata metadata) {
        m.checkNotNullParameter(metadata, "metadata");
        this.dispatcher.schedule(new StoreRtcConnection$onVideoMetadata$1(this, metadata));
    }

    @Override // com.discord.rtcconnection.RtcConnection$b, com.discord.rtcconnection.RtcConnection$c
    public void onVideoStream(long userId, Integer streamId, int audioSsrc, int videoSsrc, int rtxSsrc) {
        this.dispatcher.schedule(new StoreRtcConnection$onVideoStream$1(this, userId, streamId, audioSsrc, videoSsrc, rtxSsrc));
    }

    public StoreRtcConnection(StoreStream storeStream, Dispatcher dispatcher, Clock clock, StoreRtcRegion storeRtcRegion, StoreAnalytics storeAnalytics, StoreVoiceStates storeVoiceStates, Logger logger, DebugPrintableCollection debugPrintableCollection) {
        m.checkNotNullParameter(storeStream, "stream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(storeRtcRegion, "storeRtcRegion");
        m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        m.checkNotNullParameter(storeVoiceStates, "storeVoiceStates");
        m.checkNotNullParameter(logger, "logger");
        m.checkNotNullParameter(debugPrintableCollection, "dpc");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.storeRtcRegion = storeRtcRegion;
        this.storeAnalytics = storeAnalytics;
        this.storeVoiceStates = storeVoiceStates;
        this.logger = logger;
        this.dpc = debugPrintableCollection;
        ListenerCollectionSubject<StoreRtcConnection$Listener> listenerCollectionSubject = new ListenerCollectionSubject<>();
        this.listenerSubject = listenerCollectionSubject;
        this.listeners = listenerCollectionSubject;
        PublishSubject<StoreRtcConnection$SpeakingUserUpdate> publishSubjectK0 = PublishSubject.k0();
        this.speakingUsersSubject = publishSubjectK0;
        BehaviorSubject<RtcConnection$Quality> behaviorSubjectL0 = BehaviorSubject.l0(RtcConnection$Quality.UNKNOWN);
        this.qualitySubject = behaviorSubjectL0;
        this.currentVoiceState = new OutgoingPayload$VoiceStateUpdate(null, null, false, false, false, null, 32, null);
        SerializedSubject<RtcConnection$StateChange, RtcConnection$StateChange> serializedSubject = new SerializedSubject<>(BehaviorSubject.l0(new RtcConnection$StateChange(new RtcConnection$State$d(false), null)));
        this.connectionStateSubject = serializedSubject;
        this.rtcConnectionMetadataSubject = BehaviorSubject.l0(null);
        Observable<RtcConnection$StateChange> observableR = ObservableExtensionsKt.computationLatest(serializedSubject).r();
        m.checkNotNullExpressionValue(observableR, "connectionStateSubject\n …  .distinctUntilChanged()");
        this.connectionState = observableR;
        m.checkNotNullExpressionValue(behaviorSubjectL0, "qualitySubject");
        Observable<RtcConnection$Quality> observableR2 = ObservableExtensionsKt.computationLatest(behaviorSubjectL0).r();
        m.checkNotNullExpressionValue(observableR2, "qualitySubject\n         …  .distinctUntilChanged()");
        this.quality = observableR2;
        Observable<List<StoreRtcConnection$SpeakingUserUpdate>> observableA = publishSubjectK0.a(300L, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableA, "speakingUsersSubject\n   …S, TimeUnit.MILLISECONDS)");
        Observable<List<StoreRtcConnection$SpeakingUserUpdate>> observableR3 = ObservableExtensionsKt.computationLatest(observableA).r();
        m.checkNotNullExpressionValue(observableR3, "speakingUsersSubject\n   …  .distinctUntilChanged()");
        this.speakingUpdates = observableR3;
        StringBuilder sbU = a.U("StoreRtcConnection ");
        int i = instanceCounter + 1;
        instanceCounter = i;
        sbU.append(i);
        String string = sbU.toString();
        this.loggingTag = string;
        this.debugDisplayId = debugPrintableCollection.add(this, string);
    }
}
