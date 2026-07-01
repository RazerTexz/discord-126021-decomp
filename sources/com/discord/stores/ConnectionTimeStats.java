package com.discord.stores;

import com.discord.api.voice.state.VoiceState;
import com.discord.app.AppLog;
import com.discord.gateway.GatewaySocket;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPayload;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.time.Clock;
import d0.o;
import d0.t.g0;
import d0.z.d.m;

/* JADX INFO: compiled from: ConnectionTimeStats.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConnectionTimeStats {
    private final ConnectionTimeStats$Stat connectionStreamFirstFrame;
    private final ConnectionTimeStats$Stat connectionVideoFirstFrame;
    private final ConnectionTimeStats$Stat gatewayConnection;
    private final ConnectionTimeStats$Stat gatewayHello;
    private final ConnectionTimeStats$Stat mediaEngineConnection;
    private Long myUserId;
    private final ConnectionTimeStats$Stat streamConnection;
    private final ConnectionTimeStats$Stat streamFirstFrame;
    private final ConnectionTimeStats$Stat streamRequested;
    private final ConnectionTimeStats$Stat videoFirstFrame;
    private final ConnectionTimeStats$Stat voiceConnection;

    public ConnectionTimeStats(Clock clock) {
        m.checkNotNullParameter(clock, "clock");
        ConnectionTimeStats$StatType connectionTimeStats$StatType = ConnectionTimeStats$StatType.VideoFirstFrame;
        if (!m.areEqual(connectionTimeStats$StatType.toString(), "VideoFirstFrame")) {
            Logger.e$default(AppLog.g, "ConnectionTimeStats.StatType has been renamed!", null, g0.mapOf(o.to(ModelAuditLogEntry.CHANGE_KEY_NAME, connectionTimeStats$StatType.toString())), 2, null);
        }
        this.gatewayConnection = new ConnectionTimeStats$Stat(clock, this, ConnectionTimeStats$StatType.GatewayConnection);
        this.gatewayHello = new ConnectionTimeStats$Stat(clock, this, ConnectionTimeStats$StatType.GatewayHello);
        this.voiceConnection = new ConnectionTimeStats$Stat(clock, this, ConnectionTimeStats$StatType.VoiceConnection);
        this.streamRequested = new ConnectionTimeStats$Stat(clock, this, ConnectionTimeStats$StatType.StreamRequested);
        this.streamConnection = new ConnectionTimeStats$Stat(clock, this, ConnectionTimeStats$StatType.StreamConnection);
        this.streamFirstFrame = new ConnectionTimeStats$Stat(clock, this, ConnectionTimeStats$StatType.StreamFirstFrame);
        this.videoFirstFrame = new ConnectionTimeStats$Stat(clock, this, connectionTimeStats$StatType);
        this.mediaEngineConnection = new ConnectionTimeStats$Stat(clock, this, ConnectionTimeStats$StatType.MediaEngineConnection);
        this.connectionVideoFirstFrame = new ConnectionTimeStats$Stat(clock, this, ConnectionTimeStats$StatType.ConnectionVideoFirstFrame);
        this.connectionStreamFirstFrame = new ConnectionTimeStats$Stat(clock, this, ConnectionTimeStats$StatType.ConnectionStreamFirstFrame);
    }

    public static final /* synthetic */ ConnectionTimeStats$Stat access$getConnectionStreamFirstFrame$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.connectionStreamFirstFrame;
    }

    public static final /* synthetic */ ConnectionTimeStats$Stat access$getConnectionVideoFirstFrame$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.connectionVideoFirstFrame;
    }

    public static final /* synthetic */ ConnectionTimeStats$Stat access$getGatewayConnection$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.gatewayConnection;
    }

    public static final /* synthetic */ ConnectionTimeStats$Stat access$getGatewayHello$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.gatewayHello;
    }

    public static final /* synthetic */ ConnectionTimeStats$Stat access$getMediaEngineConnection$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.mediaEngineConnection;
    }

    public static final /* synthetic */ ConnectionTimeStats$Stat access$getStreamConnection$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.streamConnection;
    }

    public static final /* synthetic */ ConnectionTimeStats$Stat access$getStreamFirstFrame$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.streamFirstFrame;
    }

    public static final /* synthetic */ ConnectionTimeStats$Stat access$getStreamRequested$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.streamRequested;
    }

    public static final /* synthetic */ ConnectionTimeStats$Stat access$getVideoFirstFrame$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.videoFirstFrame;
    }

    public static final /* synthetic */ ConnectionTimeStats$Stat access$getVoiceConnection$p(ConnectionTimeStats connectionTimeStats) {
        return connectionTimeStats.voiceConnection;
    }

    public static final /* synthetic */ void access$sendAnalyticsEvent(ConnectionTimeStats connectionTimeStats, ConnectionTimeStats$StatType connectionTimeStats$StatType) {
        connectionTimeStats.sendAnalyticsEvent(connectionTimeStats$StatType);
    }

    private final void clear(boolean onlyCallStats) {
        if (!onlyCallStats) {
            this.gatewayConnection.clear();
            this.gatewayHello.clear();
        }
        this.voiceConnection.clear();
        this.streamRequested.clear();
        this.streamConnection.clear();
        this.streamFirstFrame.clear();
        this.videoFirstFrame.clear();
        this.mediaEngineConnection.clear();
        this.connectionVideoFirstFrame.clear();
        this.connectionStreamFirstFrame.clear();
    }

    public static /* synthetic */ void clear$default(ConnectionTimeStats connectionTimeStats, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        connectionTimeStats.clear(z2);
    }

    private final void sendAnalyticsEvent(ConnectionTimeStats$StatType statType) {
        AnalyticsTracker.INSTANCE.videoEventTimes(statType.toString(), this.gatewayConnection.elapsed(), this.gatewayHello.elapsed(), this.voiceConnection.elapsed(), this.streamRequested.elapsed(), this.streamConnection.elapsed(), this.streamFirstFrame.elapsed(), this.videoFirstFrame.elapsed(), this.mediaEngineConnection.elapsed(), this.connectionVideoFirstFrame.elapsed(), this.connectionStreamFirstFrame.elapsed());
    }

    public final void addListener(GatewaySocket socket) {
        m.checkNotNullParameter(socket, "socket");
        socket.getListeners().add(new ConnectionTimeStats$addListener$1(this));
    }

    public final void handleApplicationStreamUpdate(long userId, Integer streamId) {
        this.streamFirstFrame.start(true);
    }

    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        clear$default(this, false, 1, null);
        this.myUserId = Long.valueOf(payload.getMe().getId());
    }

    public final void handleStreamWatch(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        ConnectionTimeStats$Stat.start$default(this.streamRequested, false, 1, null);
    }

    public final void handleVideoStreamUpdate(long userId, Integer streamId, int audioSsrc, int videoSsrc, int rtxSsrc) {
        if (videoSsrc != 0) {
            this.videoFirstFrame.start(true);
        }
    }

    public final void handleVoiceStateUpdate(VoiceState voiceState) {
        m.checkNotNullParameter(voiceState, "voiceState");
        long userId = voiceState.getUserId();
        Long l = this.myUserId;
        if (l != null && userId == l.longValue() && voiceState.getChannelId() == null) {
            clear(true);
        }
    }

    public final void addListener(StoreRtcConnection rtcConnection) {
        m.checkNotNullParameter(rtcConnection, "rtcConnection");
        rtcConnection.getListeners().add(new ConnectionTimeStats$addListener$2(this));
    }

    public final void addListener(StoreStreamRtcConnection streamRtcConnection) {
        m.checkNotNullParameter(streamRtcConnection, "streamRtcConnection");
        streamRtcConnection.getListeners().add(new ConnectionTimeStats$addListener$3(this));
    }

    public final void addListener(StoreMediaEngine storeMediaEngine) {
        m.checkNotNullParameter(storeMediaEngine, "storeMediaEngine");
        storeMediaEngine.getListeners().add(new ConnectionTimeStats$addListener$4(this));
    }
}
