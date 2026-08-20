package com.discord.rtcconnection;

import android.content.Intent;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import co.discord.media_engine.InboundRtpAudio;
import co.discord.media_engine.OutboundRtpAudio;
import co.discord.media_engine.Stats;
import co.discord.media_engine.VoiceQuality;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.rtcconnection.mediaengine.ThumbnailEmitter;
import com.discord.utilities.debug.DebugPrintBuilder;
import com.discord.utilities.debug.DebugPrintable;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.networking.Backoff;
import com.discord.utilities.networking.NetworkMonitor;
import com.discord.utilities.time.Clock;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p041q.C1189a0;
import p007b.p008a.p041q.C1191b0;
import p007b.p008a.p041q.C1196e;
import p007b.p008a.p041q.C1200g;
import p007b.p008a.p041q.C1201g0;
import p007b.p008a.p041q.C1203h0;
import p007b.p008a.p041q.C1206j;
import p007b.p008a.p041q.C1258p;
import p007b.p008a.p041q.C1259q;
import p007b.p008a.p041q.C1260r;
import p007b.p008a.p041q.C1266x;
import p007b.p008a.p041q.C1268z;
import p007b.p008a.p041q.ExecutorServiceC1192c;
import p007b.p008a.p041q.RunnableC1199f0;
import p007b.p008a.p041q.p046n0.C1245a;
import p007b.p008a.p041q.p047o0.C1255d;
import p007b.p008a.p041q.p047o0.C1256e;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p508a0.C11210a;
import p507d0.p579g0.C12102s;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RtcConnection implements DebugPrintable, MediaSinkWantsManager.InterfaceC5602a {

    /* JADX INFO: renamed from: j */
    public static int f18757j;

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    public int pingBadCount;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    public final C1256e videoQuality;

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
    public final C1203h0 socketListener;

    /* JADX INFO: renamed from: N, reason: from kotlin metadata */
    public final C1191b0 mediaEngineConnectionListener;

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
    public final AbstractC5618d rtcConnectionType;

    /* JADX INFO: renamed from: Y, reason: from kotlin metadata */
    public final Map<Long, Boolean> mutedUsers;

    /* JADX INFO: renamed from: Z, reason: from kotlin metadata */
    public final Map<Long, Float> userVolumes;

    /* JADX INFO: renamed from: a0, reason: from kotlin metadata */
    public final String parentMediaSessionId;

    /* JADX INFO: renamed from: b0, reason: from kotlin metadata */
    public final boolean enableMediaSinkWants;

    /* JADX INFO: renamed from: c0, reason: from kotlin metadata */
    public final String loggingTagPrefix;

    /* JADX INFO: renamed from: d0, reason: from kotlin metadata */
    public final String streamKey;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final String loggingTag;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final String id;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final CopyOnWriteArrayList<InterfaceC5617c> listeners;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public C1255d rtcStatsCollector;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public boolean sentVideo;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public final Backoff reconnectBackoff;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public MediaEngineConnection.TransportInfo transportInfo;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public StateChange connectionStateChange;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public BehaviorSubject<StateChange> connectionStateSubject;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public boolean destroyed;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public List<Long> pings;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    public C1245a socket;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    public MediaEngineConnection mediaEngineConnection;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    public String hostname;

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    public Integer port;

    /* JADX INFO: compiled from: RtcConnection.kt */
    public enum AnalyticsEvent {
        VOICE_CONNECTION_SUCCESS,
        VOICE_CONNECTION_FAILURE,
        VOICE_DISCONNECT,
        VIDEO_STREAM_ENDED,
        MEDIA_SESSION_JOINED
    }

    /* JADX INFO: compiled from: RtcConnection.kt */
    public static final /* data */ class Metadata {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public final String rtcConnectionId;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final String mediaSessionId;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public final Long channelId;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        public final Long guildId;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        public final String streamKey;

        public Metadata(String str, String str2, Long l, Long l2, String str3) {
            C12238m.checkNotNullParameter(str, "rtcConnectionId");
            this.rtcConnectionId = str;
            this.mediaSessionId = str2;
            this.channelId = l;
            this.guildId = l2;
            this.streamKey = str3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Metadata)) {
                return false;
            }
            Metadata metadata = (Metadata) other;
            return C12238m.areEqual(this.rtcConnectionId, metadata.rtcConnectionId) && C12238m.areEqual(this.mediaSessionId, metadata.mediaSessionId) && C12238m.areEqual(this.channelId, metadata.channelId) && C12238m.areEqual(this.guildId, metadata.guildId) && C12238m.areEqual(this.streamKey, metadata.streamKey);
        }

        public int hashCode() {
            String str = this.rtcConnectionId;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.mediaSessionId;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Long l = this.channelId;
            int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
            Long l2 = this.guildId;
            int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
            String str3 = this.streamKey;
            return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Metadata(rtcConnectionId=");
            sbM833U.append(this.rtcConnectionId);
            sbM833U.append(", mediaSessionId=");
            sbM833U.append(this.mediaSessionId);
            sbM833U.append(", channelId=");
            sbM833U.append(this.channelId);
            sbM833U.append(", guildId=");
            sbM833U.append(this.guildId);
            sbM833U.append(", streamKey=");
            return C1643a.m822J(sbM833U, this.streamKey, ")");
        }
    }

    /* JADX INFO: compiled from: RtcConnection.kt */
    public enum Quality {
        UNKNOWN,
        BAD,
        AVERAGE,
        FINE;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: renamed from: com.discord.rtcconnection.RtcConnection$Quality$a, reason: from kotlin metadata */
        /* JADX INFO: compiled from: RtcConnection.kt */
        public static final class Companion {
            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }
    }

    /* JADX INFO: compiled from: RtcConnection.kt */
    public static abstract class State {

        /* JADX INFO: renamed from: com.discord.rtcconnection.RtcConnection$State$a */
        /* JADX INFO: compiled from: RtcConnection.kt */
        public static final class C5607a extends State {

            /* JADX INFO: renamed from: a */
            public static final C5607a f18809a = new C5607a();

            public C5607a() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.discord.rtcconnection.RtcConnection$State$b */
        /* JADX INFO: compiled from: RtcConnection.kt */
        public static final class C5608b extends State {

            /* JADX INFO: renamed from: a */
            public static final C5608b f18810a = new C5608b();

            public C5608b() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.discord.rtcconnection.RtcConnection$State$c */
        /* JADX INFO: compiled from: RtcConnection.kt */
        public static final class C5609c extends State {

            /* JADX INFO: renamed from: a */
            public static final C5609c f18811a = new C5609c();

            public C5609c() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.discord.rtcconnection.RtcConnection$State$d */
        /* JADX INFO: compiled from: RtcConnection.kt */
        public static final class C5610d extends State {

            /* JADX INFO: renamed from: a */
            public final boolean f18812a;

            public C5610d(boolean z2) {
                super(null);
                this.f18812a = z2;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof C5610d) && this.f18812a == ((C5610d) obj).f18812a;
                }
                return true;
            }

            public int hashCode() {
                boolean z2 = this.f18812a;
                if (z2) {
                    return 1;
                }
                return z2 ? 1 : 0;
            }

            @Override // com.discord.rtcconnection.RtcConnection.State
            public String toString() {
                return C1643a.m827O(C1643a.m833U("Disconnected(willReconnect="), this.f18812a, ")");
            }
        }

        /* JADX INFO: renamed from: com.discord.rtcconnection.RtcConnection$State$e */
        /* JADX INFO: compiled from: RtcConnection.kt */
        public static final class C5611e extends State {

            /* JADX INFO: renamed from: a */
            public static final C5611e f18813a = new C5611e();

            public C5611e() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.discord.rtcconnection.RtcConnection$State$f */
        /* JADX INFO: compiled from: RtcConnection.kt */
        public static final class C5612f extends State {

            /* JADX INFO: renamed from: a */
            public static final C5612f f18814a = new C5612f();

            public C5612f() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.discord.rtcconnection.RtcConnection$State$g */
        /* JADX INFO: compiled from: RtcConnection.kt */
        public static final class C5613g extends State {

            /* JADX INFO: renamed from: a */
            public static final C5613g f18815a = new C5613g();

            public C5613g() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.discord.rtcconnection.RtcConnection$State$h */
        /* JADX INFO: compiled from: RtcConnection.kt */
        public static final class C5614h extends State {

            /* JADX INFO: renamed from: a */
            public static final C5614h f18816a = new C5614h();

            public C5614h() {
                super(null);
            }
        }

        public State() {
        }

        public String toString() {
            if (this instanceof C5610d) {
                return super.toString();
            }
            String simpleName = getClass().getSimpleName();
            C12238m.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            return simpleName;
        }

        public State(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: compiled from: RtcConnection.kt */
    public static final /* data */ class StateChange {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public final State state;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final Metadata metadata;

        public StateChange(State state, Metadata metadata) {
            C12238m.checkNotNullParameter(state, "state");
            this.state = state;
            this.metadata = metadata;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StateChange)) {
                return false;
            }
            StateChange stateChange = (StateChange) other;
            return C12238m.areEqual(this.state, stateChange.state) && C12238m.areEqual(this.metadata, stateChange.metadata);
        }

        public int hashCode() {
            State state = this.state;
            int iHashCode = (state != null ? state.hashCode() : 0) * 31;
            Metadata metadata = this.metadata;
            return iHashCode + (metadata != null ? metadata.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StateChange(state=");
            sbM833U.append(this.state);
            sbM833U.append(", metadata=");
            sbM833U.append(this.metadata);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.rtcconnection.RtcConnection$b */
    /* JADX INFO: compiled from: RtcConnection.kt */
    public static abstract class AbstractC5616b implements InterfaceC5617c {
        @Override // com.discord.rtcconnection.RtcConnection.InterfaceC5617c
        public void onAnalyticsEvent(AnalyticsEvent analyticsEvent, Map<String, Object> map) {
            C12238m.checkNotNullParameter(analyticsEvent, "event");
            C12238m.checkNotNullParameter(map, "properties");
        }

        @Override // com.discord.rtcconnection.RtcConnection.InterfaceC5617c
        public void onFatalClose() {
        }

        public void onFirstFrameReceived(long j) {
        }

        public void onFirstFrameSent() {
        }

        @Override // com.discord.rtcconnection.RtcConnection.InterfaceC5617c
        public void onMediaEngineConnectionConnected(RtcConnection rtcConnection) {
            C12238m.checkNotNullParameter(rtcConnection, "connection");
        }

        @Override // com.discord.rtcconnection.RtcConnection.InterfaceC5617c
        public void onMediaSessionIdReceived() {
        }

        @Override // com.discord.rtcconnection.RtcConnection.InterfaceC5617c
        public void onQualityUpdate(Quality quality) {
            C12238m.checkNotNullParameter(quality, "quality");
        }

        @Override // com.discord.rtcconnection.RtcConnection.InterfaceC5617c
        public void onSpeaking(long j, boolean z2) {
        }

        @Override // com.discord.rtcconnection.RtcConnection.InterfaceC5617c
        public abstract void onStateChange(StateChange stateChange);

        @Override // com.discord.rtcconnection.RtcConnection.InterfaceC5617c
        public void onUserCreated(RtcConnection rtcConnection, long j) {
            C12238m.checkNotNullParameter(rtcConnection, "connection");
        }

        @Override // com.discord.rtcconnection.RtcConnection.InterfaceC5617c
        public void onVideoMetadata(VideoMetadata videoMetadata) {
            C12238m.checkNotNullParameter(videoMetadata, "metadata");
        }

        @Override // com.discord.rtcconnection.RtcConnection.InterfaceC5617c
        public void onVideoStream(long j, Integer num, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: renamed from: com.discord.rtcconnection.RtcConnection$c */
    /* JADX INFO: compiled from: RtcConnection.kt */
    public interface InterfaceC5617c {
        void onAnalyticsEvent(AnalyticsEvent analyticsEvent, Map<String, Object> map);

        void onFatalClose();

        void onMediaEngineConnectionConnected(RtcConnection rtcConnection);

        void onMediaSessionIdReceived();

        void onQualityUpdate(Quality quality);

        void onSpeaking(long j, boolean z2);

        void onStateChange(StateChange stateChange);

        void onUserCreated(RtcConnection rtcConnection, long j);

        void onVideoMetadata(VideoMetadata videoMetadata);

        void onVideoStream(long j, Integer num, int i, int i2, int i3);
    }

    /* JADX INFO: renamed from: com.discord.rtcconnection.RtcConnection$d */
    /* JADX INFO: compiled from: RtcConnection.kt */
    public static abstract class AbstractC5618d {

        /* JADX INFO: renamed from: com.discord.rtcconnection.RtcConnection$d$a */
        /* JADX INFO: compiled from: RtcConnection.kt */
        public static final class a extends AbstractC5618d {

            /* JADX INFO: renamed from: a */
            public static final a f18819a = new a();

            public a() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.discord.rtcconnection.RtcConnection$d$b */
        /* JADX INFO: compiled from: RtcConnection.kt */
        public static final class b extends AbstractC5618d {

            /* JADX INFO: renamed from: a */
            public final long f18820a;

            public b(long j) {
                super(null);
                this.f18820a = j;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof b) && this.f18820a == ((b) obj).f18820a;
                }
                return true;
            }

            public int hashCode() {
                return C0002b.m3a(this.f18820a);
            }

            public String toString() {
                return C1643a.m815C(C1643a.m833U("Stream(senderId="), this.f18820a, ")");
            }
        }

        public AbstractC5618d(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: com.discord.rtcconnection.RtcConnection$e */
    /* JADX INFO: compiled from: RtcConnection.kt */
    public static final class C5619e extends AbstractC12240o implements Function0<Unit> {
        public C5619e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            RtcConnection.this.m8465f("Force Close");
            return Unit.f27425a;
        }
    }

    public RtcConnection(Long l, long j, String str, boolean z2, String str2, long j2, MediaEngine mediaEngine, Logger logger, Clock clock, AbstractC5618d abstractC5618d, NetworkMonitor networkMonitor, Map map, Map map2, String str3, boolean z3, String str4, String str5, int i) {
        MediaSinkWantsManager mediaSinkWantsManager;
        Subscription subscriptionM11096V;
        AbstractC5618d abstractC5618d2 = (i & 512) != 0 ? AbstractC5618d.a.f18819a : abstractC5618d;
        Map linkedHashMap = (i & 2048) != 0 ? new LinkedHashMap() : map;
        LinkedHashMap linkedHashMap2 = (i & 4096) != 0 ? new LinkedHashMap() : null;
        String str6 = (i & 8192) != 0 ? null : str3;
        boolean z4 = (i & 16384) != 0 ? false : z3;
        String str7 = (i & 65536) != 0 ? null : str5;
        C12238m.checkNotNullParameter(str, "sessionId");
        C12238m.checkNotNullParameter(str2, "rtcServerId");
        C12238m.checkNotNullParameter(mediaEngine, "mediaEngine");
        C12238m.checkNotNullParameter(logger, "logger");
        C12238m.checkNotNullParameter(clock, "clock");
        C12238m.checkNotNullParameter(abstractC5618d2, "rtcConnectionType");
        boolean z5 = z4;
        C12238m.checkNotNullParameter(networkMonitor, "networkMonitor");
        C12238m.checkNotNullParameter(linkedHashMap, "mutedUsers");
        C12238m.checkNotNullParameter(linkedHashMap2, "userVolumes");
        C12238m.checkNotNullParameter(str4, "loggingTagPrefix");
        this.guildId = l;
        this.channelId = j;
        this.sessionId = str;
        this.isVideoEnabled = z2;
        this.rtcServerId = str2;
        this.userId = j2;
        this.mediaEngine = mediaEngine;
        this.logger = logger;
        this.clock = clock;
        this.rtcConnectionType = abstractC5618d2;
        this.mutedUsers = linkedHashMap;
        this.userVolumes = linkedHashMap2;
        this.parentMediaSessionId = str6;
        this.enableMediaSinkWants = z5;
        this.loggingTagPrefix = str4;
        this.streamKey = str7;
        StringBuilder sbM836X = C1643a.m836X(str4, "->RtcConnection ");
        int i2 = f18757j + 1;
        f18757j = i2;
        sbM836X.append(i2);
        this.loggingTag = sbM836X.toString();
        String string = UUID.randomUUID().toString();
        C12238m.checkNotNullExpressionValue(string, "UUID.randomUUID().toString()");
        this.id = string;
        CopyOnWriteArrayList<InterfaceC5617c> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.listeners = copyOnWriteArrayList;
        this.reconnectBackoff = new Backoff(1000L, 10000L, 0, false, null, 28, null);
        StateChange stateChange = new StateChange(new State.C5610d(false), null);
        this.connectionStateChange = stateChange;
        this.connectionStateSubject = BehaviorSubject.m11130l0(stateChange);
        this.pings = new ArrayList();
        C1256e c1256e = new C1256e(logger, clock);
        c1256e.f1821f.add(new C1266x(this));
        this.videoQuality = c1256e;
        if (z5) {
            subscriptionM11096V = null;
            mediaSinkWantsManager = new MediaSinkWantsManager(j2, mediaEngine.mo323c(), new C1196e(null, 1), logger, this);
        } else {
            mediaSinkWantsManager = null;
            subscriptionM11096V = null;
        }
        this.localMediaSinkWantsManager = mediaSinkWantsManager;
        if (z5) {
            C12238m.checkNotNull(mediaSinkWantsManager);
            Observable<Map<String, EncodeQuality>> observableM11112r = mediaSinkWantsManager.f18747f.m11112r();
            C12238m.checkNotNullExpressionValue(observableM11112r, "mediaSinkWantsSubject.distinctUntilChanged()");
            subscriptionM11096V = Observable.m11076j(observableM11112r, this.connectionStateSubject, C1268z.f1874j).m11096V(new C1201g0(new C1189a0(this)));
        }
        this.localMediaSinkWantsSubscription = subscriptionM11096V;
        m8475r("Created RtcConnection. GuildID: " + l + " ChannelID: " + j);
        networkMonitor.observeIsConnected().m11093S(1).m11097W(new C1258p(this), new C1259q(this));
        copyOnWriteArrayList.add(new C1260r(this));
        this.socketListener = new C1203h0(this);
        this.mediaEngineConnectionListener = new C1191b0(this);
    }

    /* JADX INFO: renamed from: j */
    public static void m8459j(RtcConnection rtcConnection, boolean z2, String str, Throwable th, boolean z3, int i) {
        if ((i & 4) != 0) {
            th = null;
        }
        if ((i & 8) != 0) {
            z3 = true;
        }
        if (z3) {
            m8460o(rtcConnection, str, th, null, 4);
        } else {
            rtcConnection.logger.mo8366i(rtcConnection.loggingTag, str, th);
        }
        C1255d c1255d = rtcConnection.rtcStatsCollector;
        if (c1255d != null) {
            c1255d.m351a();
        }
        rtcConnection.rtcStatsCollector = null;
        MediaEngineConnection mediaEngineConnection = rtcConnection.mediaEngineConnection;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.destroy();
        }
        rtcConnection.mediaEngineConnection = null;
        rtcConnection.sentVideo = false;
        rtcConnection.reconnectBackoff.cancel();
        rtcConnection.m8478u(new State.C5610d(z2));
        if (z2) {
            rtcConnection.m8474q();
            return;
        }
        Iterator<T> it = rtcConnection.listeners.iterator();
        while (it.hasNext()) {
            ((InterfaceC5617c) it.next()).onFatalClose();
        }
        rtcConnection.m8465f(str);
    }

    /* JADX INFO: renamed from: o */
    public static void m8460o(RtcConnection rtcConnection, String str, Throwable th, Map map, int i) {
        if ((i & 2) != 0) {
            th = null;
        }
        int i2 = i & 4;
        rtcConnection.logger.mo8363e(rtcConnection.loggingTag, str, th, null);
    }

    @Override // com.discord.rtcconnection.MediaSinkWantsManager.InterfaceC5602a
    /* JADX INFO: renamed from: a */
    public void mo8458a(long userId, long audioSsrc, long videoSSRC, VideoMetadata metadata) {
        m8463d(userId, audioSsrc, videoSSRC, metadata);
    }

    /* JADX INFO: renamed from: b */
    public final Map<String, Object> m8461b(Map<String, Object> map) {
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

    /* JADX INFO: renamed from: c */
    public final void m8462c(InterfaceC5617c listener) {
        C12238m.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    /* JADX INFO: renamed from: d */
    public final void m8463d(long userId, long audioSsrc, long videoSsrc, VideoMetadata metadata) {
        MediaEngineConnection mediaEngineConnection = this.mediaEngineConnection;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.mo313s(userId, (int) audioSsrc, Integer.valueOf((int) videoSsrc), m8466g(userId), m8467h(userId));
        }
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((InterfaceC5617c) it.next()).onUserCreated(this, userId);
        }
        if (metadata != null) {
            Iterator<T> it2 = this.listeners.iterator();
            while (it2.hasNext()) {
                ((InterfaceC5617c) it2.next()).onVideoMetadata(metadata);
            }
        }
    }

    @Override // com.discord.utilities.debug.DebugPrintable
    public void debugPrint(DebugPrintBuilder dp) {
        C12238m.checkNotNullParameter(dp, "dp");
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

    /* JADX INFO: renamed from: e */
    public final void m8464e() {
        m8476s(new C5619e());
    }

    /* JADX INFO: renamed from: f */
    public final void m8465f(String reason) {
        this.reconnectBackoff.cancel();
        C1245a c1245a = this.socket;
        if (c1245a != null) {
            c1245a.f1780q.clear();
            c1245a.m339c();
        }
        this.socket = null;
        C1256e c1256e = this.videoQuality;
        synchronized (c1256e) {
            c1256e.f1830o.stop();
            c1256e.f1823h = Long.valueOf(c1256e.f1832q.currentTimeMillis());
        }
        if (!(this.connectionStateChange.state instanceof State.C5610d)) {
            m8472n(false, reason);
            AbstractC5618d abstractC5618d = this.rtcConnectionType;
            if (abstractC5618d instanceof AbstractC5618d.b) {
                Map<String, Object> mapM354c = this.videoQuality.m354c(String.valueOf(((AbstractC5618d.b) abstractC5618d).f18820a));
                if (mapM354c != null) {
                    m8470l(((AbstractC5618d.b) this.rtcConnectionType).f18820a, mapM354c);
                }
                if (this.sentVideo) {
                    m8471m(this.userId, this.videoQuality.m355d());
                }
            }
        }
        MediaSinkWantsManager mediaSinkWantsManager = this.localMediaSinkWantsManager;
        if (mediaSinkWantsManager != null) {
            mediaSinkWantsManager.m8454b(new C1200g(mediaSinkWantsManager));
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
        m8478u(new State.C5610d(false));
        m8475r("Destroy internal RTC connection: " + reason);
        this.listeners.clear();
        this.sentVideo = false;
        this.destroyed = true;
    }

    /* JADX INFO: renamed from: g */
    public final boolean m8466g(long userId) {
        Boolean bool = this.mutedUsers.get(Long.valueOf(userId));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* JADX INFO: renamed from: h */
    public final float m8467h(long userId) {
        Float f = this.userVolumes.get(Long.valueOf(userId));
        if (f != null) {
            return f.floatValue();
        }
        return 1.0f;
    }

    /* JADX INFO: renamed from: i */
    public final Metadata m8468i() {
        return new Metadata(this.id, this.mediaSessionId, Long.valueOf(this.channelId), this.guildId, this.streamKey);
    }

    /* JADX INFO: renamed from: k */
    public final void m8469k(long senderId, Map<String, ? extends Object> properties) {
        HashMap map = new HashMap();
        Long l = this.guildId;
        if (l != null) {
            l.longValue();
            map.put(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, this.guildId);
        }
        map.put(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(this.channelId));
        map.put("sender_user_id", Long.valueOf(senderId));
        map.putAll(properties);
        m8473p(AnalyticsEvent.VIDEO_STREAM_ENDED, map);
    }

    /* JADX INFO: renamed from: l */
    public final void m8470l(long senderId, Map<String, ? extends Object> properties) {
        if (properties != null) {
            m8469k(senderId, C12136h0.plus(properties, C12134g0.mapOf(C12116o.m10073to("participant_type", "receiver"))));
        }
    }

    /* JADX INFO: renamed from: m */
    public final void m8471m(long senderId, Map<String, ? extends Object> properties) {
        if (properties != null) {
            m8469k(senderId, C12136h0.plus(properties, C12134g0.mapOf(C12116o.m10073to("participant_type", this.rtcConnectionType instanceof AbstractC5618d.b ? "streamer" : NotificationCompat.MessagingStyle.Message.KEY_SENDER))));
        }
    }

    /* JADX INFO: renamed from: n */
    public final void m8472n(boolean willReconnect, String reason) {
        List<String> list;
        String str;
        Stats stats;
        VoiceQuality voiceQuality;
        Map<String, Object> mapMutableMapOf = C12136h0.mutableMapOf(C12116o.m10073to("ping_bad_count", Integer.valueOf(this.pingBadCount)), C12116o.m10073to("connect_count", Integer.valueOf(this.connectCount)), C12116o.m10073to("channel_count", 1));
        m8461b(mapMutableMapOf);
        mapMutableMapOf.put("reconnect", Boolean.valueOf(willReconnect));
        if (reason != null) {
            mapMutableMapOf.put(ModelAuditLogEntry.CHANGE_KEY_REASON, reason);
        }
        double dAverageOfLong = C12163u.averageOfLong(this.pings);
        if (!Double.isNaN(dAverageOfLong)) {
            mapMutableMapOf.put("ping_average", Integer.valueOf(C11210a.roundToInt(dAverageOfLong)));
        }
        String str2 = this.mediaSessionId;
        if (str2 != null) {
            mapMutableMapOf.put("media_session_id", str2);
        }
        C1255d c1255d = this.rtcStatsCollector;
        if (c1255d != null && (stats = (Stats) C12163u.lastOrNull(c1255d.f1807a)) != null) {
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
            C1255d c1255d2 = this.rtcStatsCollector;
            if (c1255d2 != null && (voiceQuality = c1255d2.f1812f) != null) {
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
        MediaEngineConnection.TransportInfo transportInfo = this.transportInfo;
        MediaEngineConnection.TransportInfo.Protocol protocol = transportInfo != null ? transportInfo.protocol : null;
        if (protocol != null) {
            int iOrdinal = protocol.ordinal();
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
        m8473p(AnalyticsEvent.VOICE_DISCONNECT, mapMutableMapOf);
        if (this.rtcConnectionType instanceof AbstractC5618d.a) {
            C1256e c1256e = this.videoQuality;
            synchronized (c1256e) {
                list = C12163u.toList(c1256e.f1828m.keySet());
            }
            for (String str3 : list) {
                Long longOrNull = C12102s.toLongOrNull(str3);
                if (longOrNull != null) {
                    m8470l(longOrNull.longValue(), this.videoQuality.m354c(str3));
                }
            }
            if (this.sentVideo) {
                m8471m(this.userId, this.videoQuality.m355d());
            }
        }
    }

    /* JADX INFO: renamed from: p */
    public final void m8473p(AnalyticsEvent event, Map<String, Object> properties) {
        String str;
        properties.put("rtc_connection_id", this.id);
        AbstractC5618d abstractC5618d = this.rtcConnectionType;
        if (C12238m.areEqual(abstractC5618d, AbstractC5618d.a.f18819a)) {
            str = "default";
        } else {
            if (!(abstractC5618d instanceof AbstractC5618d.b)) {
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
            ((InterfaceC5617c) it.next()).onAnalyticsEvent(event, properties);
        }
    }

    /* JADX INFO: renamed from: q */
    public final void m8474q() {
        this.logger.recordBreadcrumb("reconnect", this.loggingTag);
        if (this.connected) {
            this.connectStartTime = Long.valueOf(this.clock.currentTimeMillis());
        }
        this.connectCount++;
        C1245a c1245a = this.socket;
        if (c1245a != null) {
            c1245a.m339c();
            c1245a.m340d();
        }
    }

    /* JADX INFO: renamed from: r */
    public final void m8475r(String message) {
        this.logger.recordBreadcrumb(message, this.loggingTag);
    }

    @AnyThread
    /* JADX INFO: renamed from: s */
    public final void m8476s(Function0<Unit> action) {
        ExecutorServiceC1192c executorServiceC1192cMo323c = this.mediaEngine.mo323c();
        Object runnableC1199f0 = action;
        if (action != null) {
            runnableC1199f0 = new RunnableC1199f0(action);
        }
        executorServiceC1192cMo323c.f1609l.execute((Runnable) runnableC1199f0);
    }

    /* JADX INFO: renamed from: t */
    public final void m8477t(Intent intent, ThumbnailEmitter thumbnailEmitter) {
        if (this.rtcConnectionType instanceof AbstractC5618d.b) {
            m8475r("Setting screenshare " + intent + ' ' + this.mediaEngineConnection);
            MediaEngineConnection mediaEngineConnection = this.mediaEngineConnection;
            if (mediaEngineConnection == null) {
                Log.e("RtcConnection", "MediaEngine not connected for setScreenshare.");
            } else if (intent != null) {
                mediaEngineConnection.mo295a(intent, thumbnailEmitter);
            } else {
                mediaEngineConnection.mo302h();
            }
        }
    }

    /* JADX INFO: renamed from: u */
    public final void m8478u(State state) {
        if (!C12238m.areEqual(this.connectionStateChange.state, state)) {
            StateChange stateChange = new StateChange(state, m8468i());
            this.connectionStateChange = stateChange;
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((InterfaceC5617c) it.next()).onStateChange(stateChange);
            }
        }
    }

    /* JADX INFO: renamed from: v */
    public final void m8479v(long userId, float volume) {
        this.userVolumes.put(Long.valueOf(userId), Float.valueOf(volume));
        MediaEngineConnection mediaEngineConnection = this.mediaEngineConnection;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.mo299e(userId, volume);
        }
    }

    /* JADX INFO: renamed from: w */
    public final void m8480w(Long userId) {
        MediaSinkWantsManager mediaSinkWantsManager = this.localMediaSinkWantsManager;
        if (mediaSinkWantsManager != null) {
            mediaSinkWantsManager.m8454b(new C1206j(mediaSinkWantsManager, userId));
        }
    }
}
