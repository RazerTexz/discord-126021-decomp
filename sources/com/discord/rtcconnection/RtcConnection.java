package com.discord.rtcconnection;

import android.content.Intent;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.exifinterface.media.ExifInterface;
import b.a.q.a0;
import b.a.q.b0;
import b.a.q.c;
import b.a.q.f0;
import b.a.q.g;
import b.a.q.g0;
import b.a.q.h0;
import b.a.q.j;
import b.a.q.n0.a;
import b.a.q.o0.d;
import b.a.q.o0.e;
import b.a.q.p;
import b.a.q.q;
import b.a.q.r;
import b.a.q.x;
import b.a.q.z;
import co.discord.media_engine.InboundRtpAudio;
import co.discord.media_engine.OutboundRtpAudio;
import co.discord.media_engine.Stats;
import co.discord.media_engine.VoiceQuality;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$TransportInfo;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$TransportInfo$Protocol;
import com.discord.rtcconnection.mediaengine.ThumbnailEmitter;
import com.discord.utilities.debug.DebugPrintBuilder;
import com.discord.utilities.debug.DebugPrintable;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.networking.Backoff;
import com.discord.utilities.networking.NetworkMonitor;
import com.discord.utilities.time.Clock;
import d0.g0.s;
import d0.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RtcConnection implements DebugPrintable, MediaSinkWantsManager$a {
    public static int j;
    public static final RtcConnection$a k = new RtcConnection$a(null);

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    public int pingBadCount;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    public final e videoQuality;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    public Long connectStartTime;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    public Long connectCompletedTime;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    public int connectCount;

    /* JADX INFO: renamed from: F, reason: from kotlin metadata */
    public Subscription mediaEnginePrepareSubscription;

    /* JADX INFO: renamed from: G, reason: from kotlin metadata */
    public Long networkLossTime;

    /* JADX INFO: renamed from: H, reason: from kotlin metadata */
    public final MediaSinkWantsManager localMediaSinkWantsManager;

    /* JADX INFO: renamed from: I, reason: from kotlin metadata */
    public final Subscription localMediaSinkWantsSubscription;

    /* JADX INFO: renamed from: J, reason: from kotlin metadata */
    public boolean connected;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public String mediaSessionId;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public long videoSsrc;

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    public final h0 socketListener;

    /* JADX INFO: renamed from: N, reason: from kotlin metadata */
    public final b0 mediaEngineConnectionListener;

    /* JADX INFO: renamed from: O, reason: from kotlin metadata */
    public final Long guildId;

    /* JADX INFO: renamed from: P, reason: from kotlin metadata */
    public final long channelId;

    /* JADX INFO: renamed from: Q, reason: from kotlin metadata */
    public String sessionId;

    /* JADX INFO: renamed from: R, reason: from kotlin metadata */
    public final boolean isVideoEnabled;

    /* JADX INFO: renamed from: S, reason: from kotlin metadata */
    public final String rtcServerId;

    /* JADX INFO: renamed from: T, reason: from kotlin metadata */
    public final long userId;

    /* JADX INFO: renamed from: U, reason: from kotlin metadata */
    public final MediaEngine mediaEngine;

    /* JADX INFO: renamed from: V, reason: from kotlin metadata */
    public final Logger logger;

    /* JADX INFO: renamed from: W, reason: from kotlin metadata */
    public final Clock clock;

    /* JADX INFO: renamed from: X, reason: from kotlin metadata */
    public final RtcConnection$d rtcConnectionType;

    /* JADX INFO: renamed from: Y, reason: from kotlin metadata */
    public final Map<Long, Boolean> mutedUsers;

    /* JADX INFO: renamed from: Z, reason: from kotlin metadata */
    public final Map<Long, Float> userVolumes;

    /* JADX INFO: renamed from: a0, reason: collision with root package name and from kotlin metadata */
    public final String parentMediaSessionId;

    /* JADX INFO: renamed from: b0, reason: collision with root package name and from kotlin metadata */
    public final boolean enableMediaSinkWants;

    /* JADX INFO: renamed from: c0, reason: collision with root package name and from kotlin metadata */
    public final String loggingTagPrefix;

    /* JADX INFO: renamed from: d0, reason: collision with root package name and from kotlin metadata */
    public final String streamKey;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final String loggingTag;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final String id;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final CopyOnWriteArrayList<RtcConnection$c> listeners;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public d rtcStatsCollector;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public boolean sentVideo;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public final Backoff reconnectBackoff;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public MediaEngineConnection$TransportInfo transportInfo;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    public RtcConnection$StateChange connectionStateChange;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public BehaviorSubject<RtcConnection$StateChange> connectionStateSubject;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public boolean destroyed;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public List<Long> pings;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    public a socket;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    public MediaEngineConnection mediaEngineConnection;

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    public String hostname;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    public Integer port;

    public RtcConnection(Long l, long j2, String str, boolean z2, String str2, long j3, MediaEngine mediaEngine, Logger logger, Clock clock, RtcConnection$d rtcConnection$d, NetworkMonitor networkMonitor, Map map, Map map2, String str3, boolean z3, String str4, String str5, int i) {
        MediaSinkWantsManager mediaSinkWantsManager;
        Subscription subscriptionV;
        RtcConnection$d rtcConnection$d2 = (i & 512) != 0 ? RtcConnection$d$a.a : rtcConnection$d;
        Map linkedHashMap = (i & 2048) != 0 ? new LinkedHashMap() : map;
        LinkedHashMap linkedHashMap2 = (i & 4096) != 0 ? new LinkedHashMap() : null;
        String str6 = (i & 8192) != 0 ? null : str3;
        boolean z4 = (i & 16384) != 0 ? false : z3;
        String str7 = (i & 65536) != 0 ? null : str5;
        m.checkNotNullParameter(str, "sessionId");
        m.checkNotNullParameter(str2, "rtcServerId");
        m.checkNotNullParameter(mediaEngine, "mediaEngine");
        m.checkNotNullParameter(logger, "logger");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(rtcConnection$d2, "rtcConnectionType");
        boolean z5 = z4;
        m.checkNotNullParameter(networkMonitor, "networkMonitor");
        m.checkNotNullParameter(linkedHashMap, "mutedUsers");
        m.checkNotNullParameter(linkedHashMap2, "userVolumes");
        m.checkNotNullParameter(str4, "loggingTagPrefix");
        this.guildId = l;
        this.channelId = j2;
        this.sessionId = str;
        this.isVideoEnabled = z2;
        this.rtcServerId = str2;
        this.userId = j3;
        this.mediaEngine = mediaEngine;
        this.logger = logger;
        this.clock = clock;
        this.rtcConnectionType = rtcConnection$d2;
        this.mutedUsers = linkedHashMap;
        this.userVolumes = linkedHashMap2;
        this.parentMediaSessionId = str6;
        this.enableMediaSinkWants = z5;
        this.loggingTagPrefix = str4;
        this.streamKey = str7;
        StringBuilder sbX = b.d.b.a.a.X(str4, "->RtcConnection ");
        int i2 = j + 1;
        j = i2;
        sbX.append(i2);
        this.loggingTag = sbX.toString();
        String string = UUID.randomUUID().toString();
        m.checkNotNullExpressionValue(string, "UUID.randomUUID().toString()");
        this.id = string;
        CopyOnWriteArrayList<RtcConnection$c> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.listeners = copyOnWriteArrayList;
        this.reconnectBackoff = new Backoff(1000L, 10000L, 0, false, null, 28, null);
        RtcConnection$StateChange rtcConnection$StateChange = new RtcConnection$StateChange(new RtcConnection$State$d(false), null);
        this.connectionStateChange = rtcConnection$StateChange;
        this.connectionStateSubject = BehaviorSubject.l0(rtcConnection$StateChange);
        this.pings = new ArrayList();
        e eVar = new e(logger, clock);
        eVar.f.add(new x(this));
        this.videoQuality = eVar;
        if (z5) {
            subscriptionV = null;
            mediaSinkWantsManager = new MediaSinkWantsManager(j3, mediaEngine.c(), new b.a.q.e(null, 1), logger, this);
        } else {
            mediaSinkWantsManager = null;
            subscriptionV = null;
        }
        this.localMediaSinkWantsManager = mediaSinkWantsManager;
        if (z5) {
            m.checkNotNull(mediaSinkWantsManager);
            Observable<Map<String, EncodeQuality>> observableR = mediaSinkWantsManager.f.r();
            m.checkNotNullExpressionValue(observableR, "mediaSinkWantsSubject.distinctUntilChanged()");
            subscriptionV = Observable.j(observableR, this.connectionStateSubject, z.j).V(new g0(new a0(this)));
        }
        this.localMediaSinkWantsSubscription = subscriptionV;
        r("Created RtcConnection. GuildID: " + l + " ChannelID: " + j2);
        networkMonitor.observeIsConnected().S(1).W(new p(this), new q(this));
        copyOnWriteArrayList.add(new r(this));
        this.socketListener = new h0(this);
        this.mediaEngineConnectionListener = new b0(this);
    }

    public static void j(RtcConnection rtcConnection, boolean z2, String str, Throwable th, boolean z3, int i) {
        if ((i & 4) != 0) {
            th = null;
        }
        if ((i & 8) != 0) {
            z3 = true;
        }
        if (z3) {
            o(rtcConnection, str, th, null, 4);
        } else {
            rtcConnection.logger.i(rtcConnection.loggingTag, str, th);
        }
        d dVar = rtcConnection.rtcStatsCollector;
        if (dVar != null) {
            dVar.a();
        }
        rtcConnection.rtcStatsCollector = null;
        MediaEngineConnection mediaEngineConnection = rtcConnection.mediaEngineConnection;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.destroy();
        }
        rtcConnection.mediaEngineConnection = null;
        rtcConnection.sentVideo = false;
        rtcConnection.reconnectBackoff.cancel();
        rtcConnection.u(new RtcConnection$State$d(z2));
        if (z2) {
            rtcConnection.q();
            return;
        }
        Iterator<T> it = rtcConnection.listeners.iterator();
        while (it.hasNext()) {
            ((RtcConnection$c) it.next()).onFatalClose();
        }
        rtcConnection.f(str);
    }

    public static void o(RtcConnection rtcConnection, String str, Throwable th, Map map, int i) {
        if ((i & 2) != 0) {
            th = null;
        }
        int i2 = i & 4;
        rtcConnection.logger.e(rtcConnection.loggingTag, str, th, null);
    }

    @Override // com.discord.rtcconnection.MediaSinkWantsManager$a
    public void a(long userId, long audioSsrc, long videoSSRC, VideoMetadata metadata) {
        d(userId, audioSsrc, videoSSRC, metadata);
    }

    public final Map<String, Object> b(Map<String, Object> map) {
        String str = this.hostname;
        if (str != null) {
            map.put("hostname", str);
        }
        Integer num = this.port;
        if (num != null) {
            map.put("port", Integer.valueOf(num.intValue()));
        }
        return map;
    }

    public final void c(RtcConnection$c listener) {
        m.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final void d(long userId, long audioSsrc, long videoSsrc, VideoMetadata metadata) {
        MediaEngineConnection mediaEngineConnection = this.mediaEngineConnection;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.s(userId, (int) audioSsrc, Integer.valueOf((int) videoSsrc), g(userId), h(userId));
        }
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((RtcConnection$c) it.next()).onUserCreated(this, userId);
        }
        if (metadata != null) {
            Iterator<T> it2 = this.listeners.iterator();
            while (it2.hasNext()) {
                ((RtcConnection$c) it2.next()).onVideoMetadata(metadata);
            }
        }
    }

    @Override // com.discord.utilities.debug.DebugPrintable
    public void debugPrint(DebugPrintBuilder dp) {
        m.checkNotNullParameter(dp, "dp");
        dp.appendKeyValue(ModelAuditLogEntry.CHANGE_KEY_ID, this.id);
        dp.appendKeyValue("mediaSessionId", this.mediaSessionId);
        dp.appendKeyValue("parentMediaSessionId", this.parentMediaSessionId);
        dp.appendKeyValue("hostname", this.hostname);
        dp.appendKeyValue("channelId", Long.valueOf(this.channelId));
        dp.appendKeyValue("guildId", this.guildId);
        dp.appendKeyValue("streamKey", this.streamKey);
        dp.appendKeyValue("isVideoEnabled", Boolean.valueOf(this.isVideoEnabled));
        dp.appendKeyValue("rtcServerId", this.rtcServerId);
        dp.appendKeyValue("userId", Long.valueOf(this.userId));
        dp.appendKeyValue("rtcConnectionType", this.rtcConnectionType);
        dp.appendKeyValue("enableMediaSinkWants", Boolean.valueOf(this.enableMediaSinkWants));
        dp.appendKeyValue("socket", (DebugPrintable) this.socket);
        dp.appendKeyValue("sentVideo", Boolean.valueOf(this.sentVideo));
    }

    public final void e() {
        s(new RtcConnection$e(this));
    }

    public final void f(String reason) {
        this.reconnectBackoff.cancel();
        a aVar = this.socket;
        if (aVar != null) {
            aVar.q.clear();
            aVar.c();
        }
        this.socket = null;
        e eVar = this.videoQuality;
        synchronized (eVar) {
            eVar.o.stop();
            eVar.h = Long.valueOf(eVar.q.currentTimeMillis());
        }
        if (!(this.connectionStateChange.state instanceof RtcConnection$State$d)) {
            n(false, reason);
            RtcConnection$d rtcConnection$d = this.rtcConnectionType;
            if (rtcConnection$d instanceof RtcConnection$d$b) {
                Map<String, Object> mapC = this.videoQuality.c(String.valueOf(((RtcConnection$d$b) rtcConnection$d).a));
                if (mapC != null) {
                    l(((RtcConnection$d$b) this.rtcConnectionType).a, mapC);
                }
                if (this.sentVideo) {
                    m(this.userId, this.videoQuality.d());
                }
            }
        }
        MediaSinkWantsManager mediaSinkWantsManager = this.localMediaSinkWantsManager;
        if (mediaSinkWantsManager != null) {
            mediaSinkWantsManager.b(new g(mediaSinkWantsManager));
        }
        Subscription subscription = this.localMediaSinkWantsSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Subscription subscription2 = this.mediaEnginePrepareSubscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        this.mediaEnginePrepareSubscription = null;
        MediaEngineConnection mediaEngineConnection = this.mediaEngineConnection;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.destroy();
        }
        this.mediaEngineConnection = null;
        u(new RtcConnection$State$d(false));
        r("Destroy internal RTC connection: " + reason);
        this.listeners.clear();
        this.sentVideo = false;
        this.destroyed = true;
    }

    public final boolean g(long userId) {
        Boolean bool = this.mutedUsers.get(Long.valueOf(userId));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final float h(long userId) {
        Float f = this.userVolumes.get(Long.valueOf(userId));
        if (f != null) {
            return f.floatValue();
        }
        return 1.0f;
    }

    public final RtcConnection$Metadata i() {
        return new RtcConnection$Metadata(this.id, this.mediaSessionId, Long.valueOf(this.channelId), this.guildId, this.streamKey);
    }

    public final void k(long senderId, Map<String, ? extends Object> properties) {
        HashMap map = new HashMap();
        Long l = this.guildId;
        if (l != null) {
            l.longValue();
            map.put(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, this.guildId);
        }
        map.put(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(this.channelId));
        map.put("sender_user_id", Long.valueOf(senderId));
        map.putAll(properties);
        p(RtcConnection$AnalyticsEvent.VIDEO_STREAM_ENDED, map);
    }

    public final void l(long senderId, Map<String, ? extends Object> properties) {
        if (properties != null) {
            k(senderId, d0.t.h0.plus(properties, d0.t.g0.mapOf(o.to("participant_type", "receiver"))));
        }
    }

    public final void m(long senderId, Map<String, ? extends Object> properties) {
        if (properties != null) {
            k(senderId, d0.t.h0.plus(properties, d0.t.g0.mapOf(o.to("participant_type", this.rtcConnectionType instanceof RtcConnection$d$b ? "streamer" : NotificationCompat$MessagingStyle$Message.KEY_SENDER))));
        }
    }

    public final void n(boolean willReconnect, String reason) {
        List<String> list;
        String str;
        Stats stats;
        VoiceQuality voiceQuality;
        Map<String, Object> mapMutableMapOf = d0.t.h0.mutableMapOf(o.to("ping_bad_count", Integer.valueOf(this.pingBadCount)), o.to("connect_count", Integer.valueOf(this.connectCount)), o.to("channel_count", 1));
        b(mapMutableMapOf);
        mapMutableMapOf.put("reconnect", Boolean.valueOf(willReconnect));
        if (reason != null) {
            mapMutableMapOf.put(ModelAuditLogEntry.CHANGE_KEY_REASON, reason);
        }
        double dAverageOfLong = u.averageOfLong(this.pings);
        if (!Double.isNaN(dAverageOfLong)) {
            mapMutableMapOf.put("ping_average", Integer.valueOf(d0.a0.a.roundToInt(dAverageOfLong)));
        }
        String str2 = this.mediaSessionId;
        if (str2 != null) {
            mapMutableMapOf.put("media_session_id", str2);
        }
        d dVar = this.rtcStatsCollector;
        if (dVar != null && (stats = (Stats) u.lastOrNull(dVar.a)) != null) {
            OutboundRtpAudio outboundRtpAudio = stats.getOutboundRtpAudio();
            if (outboundRtpAudio != null) {
                mapMutableMapOf.put("packets_sent", Long.valueOf(outboundRtpAudio.getPacketsSent()));
                mapMutableMapOf.put("packets_sent_lost", Integer.valueOf(outboundRtpAudio.getPacketsLost()));
            }
            long packetsReceived = 0;
            long packetsLost = 0;
            for (InboundRtpAudio inboundRtpAudio : stats.getInboundRtpAudio().values()) {
                packetsLost += inboundRtpAudio.getPacketsLost();
                packetsReceived += inboundRtpAudio.getPacketsReceived();
            }
            mapMutableMapOf.put("packets_received", Long.valueOf(packetsReceived));
            mapMutableMapOf.put("packets_received_lost", Long.valueOf(packetsLost));
            d dVar2 = this.rtcStatsCollector;
            if (dVar2 != null && (voiceQuality = dVar2.f) != null) {
                voiceQuality.getDurationStats(mapMutableMapOf);
                voiceQuality.getMosStats(mapMutableMapOf);
                voiceQuality.getPacketStats(mapMutableMapOf);
                voiceQuality.getBufferStats(mapMutableMapOf);
                voiceQuality.getFrameOpStats(mapMutableMapOf);
            }
        }
        Long l = this.connectCompletedTime;
        Long lValueOf = l != null ? Long.valueOf(this.clock.currentTimeMillis() - l.longValue()) : null;
        if (lValueOf != null) {
            mapMutableMapOf.put("duration", Long.valueOf(lValueOf.longValue()));
        }
        MediaEngineConnection$TransportInfo mediaEngineConnection$TransportInfo = this.transportInfo;
        MediaEngineConnection$TransportInfo$Protocol mediaEngineConnection$TransportInfo$Protocol = mediaEngineConnection$TransportInfo != null ? mediaEngineConnection$TransportInfo.protocol : null;
        if (mediaEngineConnection$TransportInfo$Protocol != null) {
            int iOrdinal = mediaEngineConnection$TransportInfo$Protocol.ordinal();
            if (iOrdinal == 0) {
                str = "udp";
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "tcp";
            }
            mapMutableMapOf.put("protocol", str);
        }
        p(RtcConnection$AnalyticsEvent.VOICE_DISCONNECT, mapMutableMapOf);
        if (this.rtcConnectionType instanceof RtcConnection$d$a) {
            e eVar = this.videoQuality;
            synchronized (eVar) {
                list = u.toList(eVar.m.keySet());
            }
            for (String str3 : list) {
                Long longOrNull = s.toLongOrNull(str3);
                if (longOrNull != null) {
                    l(longOrNull.longValue(), this.videoQuality.c(str3));
                }
            }
            if (this.sentVideo) {
                m(this.userId, this.videoQuality.d());
            }
        }
    }

    public final void p(RtcConnection$AnalyticsEvent event, Map<String, Object> properties) {
        String str;
        properties.put("rtc_connection_id", this.id);
        RtcConnection$d rtcConnection$d = this.rtcConnectionType;
        if (m.areEqual(rtcConnection$d, RtcConnection$d$a.a)) {
            str = "default";
        } else {
            if (!(rtcConnection$d instanceof RtcConnection$d$b)) {
                throw new NoWhenBranchMatchedException();
            }
            str = "stream";
        }
        properties.put("context", str);
        String str2 = this.mediaSessionId;
        if (str2 != null) {
            properties.put("media_session_id", str2);
        }
        String str3 = this.parentMediaSessionId;
        if (str3 != null) {
            properties.put("parent_media_session_id", str3);
        }
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((RtcConnection$c) it.next()).onAnalyticsEvent(event, properties);
        }
    }

    public final void q() {
        this.logger.recordBreadcrumb("reconnect", this.loggingTag);
        if (this.connected) {
            this.connectStartTime = Long.valueOf(this.clock.currentTimeMillis());
        }
        this.connectCount++;
        a aVar = this.socket;
        if (aVar != null) {
            aVar.c();
            aVar.d();
        }
    }

    public final void r(String message) {
        this.logger.recordBreadcrumb(message, this.loggingTag);
    }

    @AnyThread
    public final void s(Function0<Unit> action) {
        c cVarC = this.mediaEngine.c();
        Object f0Var = action;
        if (action != null) {
            f0Var = new f0(action);
        }
        cVarC.l.execute((Runnable) f0Var);
    }

    public final void t(Intent intent, ThumbnailEmitter thumbnailEmitter) {
        if (this.rtcConnectionType instanceof RtcConnection$d$b) {
            r("Setting screenshare " + intent + ' ' + this.mediaEngineConnection);
            MediaEngineConnection mediaEngineConnection = this.mediaEngineConnection;
            if (mediaEngineConnection == null) {
                Log.e("RtcConnection", "MediaEngine not connected for setScreenshare.");
            } else if (intent != null) {
                mediaEngineConnection.a(intent, thumbnailEmitter);
            } else {
                mediaEngineConnection.h();
            }
        }
    }

    public final void u(RtcConnection$State state) {
        if (!m.areEqual(this.connectionStateChange.state, state)) {
            RtcConnection$StateChange rtcConnection$StateChange = new RtcConnection$StateChange(state, i());
            this.connectionStateChange = rtcConnection$StateChange;
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((RtcConnection$c) it.next()).onStateChange(rtcConnection$StateChange);
            }
        }
    }

    public final void v(long userId, float volume) {
        this.userVolumes.put(Long.valueOf(userId), Float.valueOf(volume));
        MediaEngineConnection mediaEngineConnection = this.mediaEngineConnection;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.e(userId, volume);
        }
    }

    public final void w(Long userId) {
        MediaSinkWantsManager mediaSinkWantsManager = this.localMediaSinkWantsManager;
        if (mediaSinkWantsManager != null) {
            mediaSinkWantsManager.b(new j(mediaSinkWantsManager, userId));
        }
    }
}
