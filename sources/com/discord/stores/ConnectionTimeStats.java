package com.discord.stores;

import b.d.b.a.outline;
import com.discord.api.voice.state.VoiceState;
import com.discord.app.AppLog;
import com.discord.gateway.GatewaySocket;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.StoreMediaEngine;
import com.discord.stores.StoreRtcConnection;
import com.discord.stores.StoreStreamRtcConnection;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.time.Clock;
import d0.Tuples;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ConnectionTimeStats.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConnectionTimeStats {
    private final Stat connectionStreamFirstFrame;
    private final Stat connectionVideoFirstFrame;
    private final Stat gatewayConnection;
    private final Stat gatewayHello;
    private final Stat mediaEngineConnection;
    private Long myUserId;
    private final Stat streamConnection;
    private final Stat streamFirstFrame;
    private final Stat streamRequested;
    private final Stat videoFirstFrame;
    private final Stat voiceConnection;

    /* JADX INFO: compiled from: ConnectionTimeStats.kt */
    public static final class Stat {
        private final Clock clock;
        private Long endTime;
        private final ConnectionTimeStats owner;
        private Long startTime;
        private final StatType type;

        public Stat(Clock clock, ConnectionTimeStats connectionTimeStats, StatType statType) {
            Intrinsics3.checkNotNullParameter(clock, "clock");
            Intrinsics3.checkNotNullParameter(connectionTimeStats, "owner");
            Intrinsics3.checkNotNullParameter(statType, "type");
            this.clock = clock;
            this.owner = connectionTimeStats;
            this.type = statType;
        }

        public static /* synthetic */ void end$default(Stat stat, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = false;
            }
            stat.end(z2);
        }

        public static /* synthetic */ void start$default(Stat stat, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = false;
            }
            stat.start(z2);
        }

        public final void clear() {
            this.startTime = null;
            this.endTime = null;
        }

        public final Long elapsed() {
            Long l = this.startTime;
            Long l2 = this.endTime;
            if (l == null || l2 == null) {
                return null;
            }
            return Long.valueOf(l2.longValue() - l.longValue());
        }

        public final void end(boolean ignoreSubsequentCalls) {
            if (this.endTime != null) {
                if (ignoreSubsequentCalls) {
                    return;
                }
                AppLog appLog = AppLog.g;
                StringBuilder sbU = outline.U("ConnectionTimeStats: \"");
                sbU.append(this.type);
                sbU.append("\" attempting to end while endTime is set!");
                Logger.w$default(appLog, sbU.toString(), null, 2, null);
                return;
            }
            Long l = this.startTime;
            long jCurrentTimeMillis = this.clock.currentTimeMillis();
            if (l == null) {
                AppLog appLog2 = AppLog.g;
                StringBuilder sbU2 = outline.U("ConnectionTimeStats: \"");
                sbU2.append(this.type);
                sbU2.append("\" ended without starting!");
                Logger.w$default(appLog2, sbU2.toString(), null, 2, null);
                return;
            }
            long jLongValue = jCurrentTimeMillis - l.longValue();
            if (jLongValue < 0) {
                AppLog appLog3 = AppLog.g;
                StringBuilder sbU3 = outline.U("ConnectionTimeStats: \"");
                sbU3.append(this.type);
                sbU3.append("\" has a negative time!");
                sbU3.append(_Collections.joinToString$default(Maps6.mapOf(Tuples.to(this.type.toString(), "type"), Tuples.to(String.valueOf(jLongValue), "elapsedMs"), Tuples.to(String.valueOf(l.longValue()), "start"), Tuples.to(String.valueOf(jCurrentTimeMillis), "end")).entrySet(), "\n\t", null, null, 0, null, null, 62, null));
                Logger.w$default(appLog3, sbU3.toString(), null, 2, null);
                return;
            }
            this.endTime = Long.valueOf(jCurrentTimeMillis);
            StringBuilder sbU4 = outline.U("ConnectionTimeStats: \"");
            sbU4.append(this.type);
            sbU4.append("\" took ");
            sbU4.append(jLongValue);
            sbU4.append(" ms (");
            sbU4.append(l);
            sbU4.append(" to ");
            sbU4.append(jCurrentTimeMillis);
            sbU4.append(')');
            AppLog.i(sbU4.toString());
            this.owner.sendAnalyticsEvent(this.type);
        }

        public final void start(boolean ignoreSubsequentCalls) {
            if (this.startTime != null) {
                if (ignoreSubsequentCalls) {
                    return;
                }
                AppLog appLog = AppLog.g;
                StringBuilder sbU = outline.U("ConnectionTimeStats: \"");
                sbU.append(this.type);
                sbU.append("\" attempting to re-start without reset!");
                Logger.w$default(appLog, sbU.toString(), null, 2, null);
                return;
            }
            if (this.endTime != null) {
                AppLog appLog2 = AppLog.g;
                StringBuilder sbU2 = outline.U("ConnectionTimeStats: \"");
                sbU2.append(this.type);
                sbU2.append("\" attempting to re-start while endTime is set!");
                Logger.w$default(appLog2, sbU2.toString(), null, 2, null);
                return;
            }
            long jCurrentTimeMillis = this.clock.currentTimeMillis();
            this.startTime = Long.valueOf(jCurrentTimeMillis);
            StringBuilder sbU3 = outline.U("ConnectionTimeStats: \"");
            sbU3.append(this.type);
            sbU3.append("\" started @ ");
            sbU3.append(jCurrentTimeMillis);
            AppLog.i(sbU3.toString());
        }
    }

    /* JADX INFO: compiled from: ConnectionTimeStats.kt */
    public enum StatType {
        GatewayConnection,
        GatewayHello,
        VoiceConnection,
        StreamRequested,
        StreamConnection,
        MediaEngineConnection,
        StreamFirstFrame,
        VideoFirstFrame,
        ConnectionStreamFirstFrame,
        ConnectionVideoFirstFrame
    }

    public ConnectionTimeStats(Clock clock) {
        Intrinsics3.checkNotNullParameter(clock, "clock");
        StatType statType = StatType.VideoFirstFrame;
        if (!Intrinsics3.areEqual(statType.toString(), "VideoFirstFrame")) {
            Logger.e$default(AppLog.g, "ConnectionTimeStats.StatType has been renamed!", null, MapsJVM.mapOf(Tuples.to(ModelAuditLogEntry.CHANGE_KEY_NAME, statType.toString())), 2, null);
        }
        this.gatewayConnection = new Stat(clock, this, StatType.GatewayConnection);
        this.gatewayHello = new Stat(clock, this, StatType.GatewayHello);
        this.voiceConnection = new Stat(clock, this, StatType.VoiceConnection);
        this.streamRequested = new Stat(clock, this, StatType.StreamRequested);
        this.streamConnection = new Stat(clock, this, StatType.StreamConnection);
        this.streamFirstFrame = new Stat(clock, this, StatType.StreamFirstFrame);
        this.videoFirstFrame = new Stat(clock, this, statType);
        this.mediaEngineConnection = new Stat(clock, this, StatType.MediaEngineConnection);
        this.connectionVideoFirstFrame = new Stat(clock, this, StatType.ConnectionVideoFirstFrame);
        this.connectionStreamFirstFrame = new Stat(clock, this, StatType.ConnectionStreamFirstFrame);
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

    private final void sendAnalyticsEvent(StatType statType) {
        AnalyticsTracker.INSTANCE.videoEventTimes(statType.toString(), this.gatewayConnection.elapsed(), this.gatewayHello.elapsed(), this.voiceConnection.elapsed(), this.streamRequested.elapsed(), this.streamConnection.elapsed(), this.streamFirstFrame.elapsed(), this.videoFirstFrame.elapsed(), this.mediaEngineConnection.elapsed(), this.connectionVideoFirstFrame.elapsed(), this.connectionStreamFirstFrame.elapsed());
    }

    public final void addListener(GatewaySocket socket) {
        Intrinsics3.checkNotNullParameter(socket, "socket");
        socket.getListeners().add(new GatewaySocket.DefaultListener() { // from class: com.discord.stores.ConnectionTimeStats.addListener.1
            @Override // com.discord.gateway.GatewaySocket.DefaultListener, com.discord.gateway.GatewaySocket.Listener
            public void onConnected(GatewaySocket gatewaySocket) {
                Intrinsics3.checkNotNullParameter(gatewaySocket, "gatewaySocket");
                Stat.end$default(ConnectionTimeStats.this.gatewayConnection, false, 1, null);
                Stat.start$default(ConnectionTimeStats.this.gatewayHello, false, 1, null);
            }

            @Override // com.discord.gateway.GatewaySocket.DefaultListener, com.discord.gateway.GatewaySocket.Listener
            public void onConnecting(GatewaySocket gatewaySocket) {
                Intrinsics3.checkNotNullParameter(gatewaySocket, "gatewaySocket");
                Stat.start$default(ConnectionTimeStats.this.gatewayConnection, false, 1, null);
            }

            @Override // com.discord.gateway.GatewaySocket.DefaultListener, com.discord.gateway.GatewaySocket.Listener
            public void onDisconnected(GatewaySocket gatewaySocket) {
                Intrinsics3.checkNotNullParameter(gatewaySocket, "gatewaySocket");
                ConnectionTimeStats.this.gatewayConnection.clear();
                ConnectionTimeStats.this.gatewayHello.clear();
            }

            @Override // com.discord.gateway.GatewaySocket.DefaultListener, com.discord.gateway.GatewaySocket.Listener
            public void onHello(GatewaySocket gatewaySocket) {
                Intrinsics3.checkNotNullParameter(gatewaySocket, "gatewaySocket");
                Stat.end$default(ConnectionTimeStats.this.gatewayHello, false, 1, null);
            }
        });
    }

    public final void handleApplicationStreamUpdate(long userId, Integer streamId) {
        this.streamFirstFrame.start(true);
    }

    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        clear$default(this, false, 1, null);
        this.myUserId = Long.valueOf(payload.getMe().getId());
    }

    public final void handleStreamWatch(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        Stat.start$default(this.streamRequested, false, 1, null);
    }

    public final void handleVideoStreamUpdate(long userId, Integer streamId, int audioSsrc, int videoSsrc, int rtxSsrc) {
        if (videoSsrc != 0) {
            this.videoFirstFrame.start(true);
        }
    }

    public final void handleVoiceStateUpdate(VoiceState voiceState) {
        Intrinsics3.checkNotNullParameter(voiceState, "voiceState");
        long userId = voiceState.getUserId();
        Long l = this.myUserId;
        if (l != null && userId == l.longValue() && voiceState.getChannelId() == null) {
            clear(true);
        }
    }

    public final void addListener(StoreRtcConnection rtcConnection) {
        Intrinsics3.checkNotNullParameter(rtcConnection, "rtcConnection");
        rtcConnection.getListeners().add(new StoreRtcConnection.DefaultListener() { // from class: com.discord.stores.ConnectionTimeStats.addListener.2
            @Override // com.discord.stores.StoreRtcConnection.DefaultListener, com.discord.stores.StoreRtcConnection.Listener
            public void onConnected() {
                Stat.end$default(ConnectionTimeStats.this.voiceConnection, false, 1, null);
            }

            @Override // com.discord.stores.StoreRtcConnection.DefaultListener, com.discord.stores.StoreRtcConnection.Listener
            public void onConnecting() {
                Stat.start$default(ConnectionTimeStats.this.voiceConnection, false, 1, null);
                Stat.start$default(ConnectionTimeStats.this.connectionVideoFirstFrame, false, 1, null);
                Stat.start$default(ConnectionTimeStats.this.connectionStreamFirstFrame, false, 1, null);
            }

            @Override // com.discord.stores.StoreRtcConnection.DefaultListener, com.discord.stores.StoreRtcConnection.Listener
            public void onFirstFrameReceived(long ssrc) {
                Stat.end$default(ConnectionTimeStats.this.videoFirstFrame, false, 1, null);
                Stat.end$default(ConnectionTimeStats.this.connectionVideoFirstFrame, false, 1, null);
            }
        });
    }

    public final void addListener(StoreStreamRtcConnection streamRtcConnection) {
        Intrinsics3.checkNotNullParameter(streamRtcConnection, "streamRtcConnection");
        streamRtcConnection.getListeners().add(new StoreStreamRtcConnection.DefaultListener() { // from class: com.discord.stores.ConnectionTimeStats.addListener.3
            @Override // com.discord.stores.StoreStreamRtcConnection.DefaultListener, com.discord.stores.StoreStreamRtcConnection.Listener
            public void onConnected() {
                Stat.end$default(ConnectionTimeStats.this.streamConnection, false, 1, null);
                ConnectionTimeStats.this.streamFirstFrame.start(true);
            }

            @Override // com.discord.stores.StoreStreamRtcConnection.DefaultListener, com.discord.stores.StoreStreamRtcConnection.Listener
            public void onConnecting() {
                Stat.end$default(ConnectionTimeStats.this.streamRequested, false, 1, null);
                Stat.start$default(ConnectionTimeStats.this.streamConnection, false, 1, null);
            }

            @Override // com.discord.stores.StoreStreamRtcConnection.DefaultListener, com.discord.stores.StoreStreamRtcConnection.Listener
            public void onFirstFrameReceived(long ssrc) {
                Stat.end$default(ConnectionTimeStats.this.streamFirstFrame, false, 1, null);
                Stat.end$default(ConnectionTimeStats.this.connectionStreamFirstFrame, false, 1, null);
            }
        });
    }

    public final void addListener(StoreMediaEngine storeMediaEngine) {
        Intrinsics3.checkNotNullParameter(storeMediaEngine, "storeMediaEngine");
        storeMediaEngine.getListeners().add(new StoreMediaEngine.DefaultListener() { // from class: com.discord.stores.ConnectionTimeStats.addListener.4
            @Override // com.discord.stores.StoreMediaEngine.DefaultListener, com.discord.stores.StoreMediaEngine.Listener
            public void onConnected() {
                ConnectionTimeStats.this.mediaEngineConnection.end(true);
            }

            @Override // com.discord.stores.StoreMediaEngine.DefaultListener, com.discord.stores.StoreMediaEngine.Listener
            public void onConnecting() {
                Stat.start$default(ConnectionTimeStats.this.mediaEngineConnection, false, 1, null);
            }
        });
    }
}
