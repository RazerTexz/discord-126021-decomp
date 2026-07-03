package p007b.p008a.p041q;

import co.discord.media_engine.MediaType;
import co.discord.media_engine.StreamParameters;
import co.discord.media_engine.VoiceQuality;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.rtcconnection.MediaSinkWantsManager;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.rtcconnection.socket.p499io.Payloads;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import org.webrtc.MediaStreamTrack;
import p007b.p008a.p041q.p044m0.C1221a;
import p007b.p008a.p041q.p046n0.C1245a;
import p007b.p008a.p041q.p047o0.C1253b;
import p007b.p008a.p041q.p047o0.C1254c;
import p007b.p008a.p041q.p047o0.C1255d;
import p007b.p008a.p041q.p047o0.C1256e;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12139j;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: renamed from: b.a.q.b0 */
/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1191b0 implements MediaEngineConnection.InterfaceC5648d {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ RtcConnection f1606a;

    public C1191b0(RtcConnection rtcConnection) {
        this.f1606a = rtcConnection;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onConnected(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.TransportInfo transportInfo, List<C1221a> list) {
        C12238m.checkNotNullParameter(mediaEngineConnection, "connection");
        C12238m.checkNotNullParameter(transportInfo, "transportInfo");
        C12238m.checkNotNullParameter(list, "supportedVideoCodecs");
        RtcConnection rtcConnection = this.f1606a;
        rtcConnection.reconnectBackoff.succeed();
        rtcConnection.transportInfo = transportInfo;
        MediaEngineConnection mediaEngineConnection2 = rtcConnection.mediaEngineConnection;
        if (mediaEngineConnection2 != null) {
            C1255d c1255d = new C1255d(1000L, rtcConnection.logger, mediaEngineConnection2, new VoiceQuality(), rtcConnection.videoQuality, new KrispOveruseDetector(mediaEngineConnection2), 0, 64);
            c1255d.f1807a.clear();
            Subscription subscription = c1255d.f1808b;
            if (subscription != null && !subscription.isUnsubscribed()) {
                c1255d.m351a();
            }
            c1255d.f1808b = Observable.m11061E(0L, c1255d.f1809c, TimeUnit.MILLISECONDS).m11097W(new C1253b(c1255d), new C1254c(c1255d));
            rtcConnection.rtcStatsCollector = c1255d;
            rtcConnection.sentVideo = false;
        }
        if (transportInfo.protocol.ordinal() != 0) {
            StringBuilder sbM833U = C1643a.m833U("Unsupported protocol: ");
            sbM833U.append(transportInfo.protocol);
            sbM833U.append('.');
            RtcConnection.m8459j(rtcConnection, true, sbM833U.toString(), null, false, 12);
        } else {
            rtcConnection.logger.recordBreadcrumb("Sending UDP info to RTC server.", rtcConnection.loggingTag);
            C1245a c1245a = rtcConnection.socket;
            if (c1245a == null) {
                RtcConnection.m8460o(rtcConnection, "onEngineConnectionConnected() socket was null.", null, null, 6);
                return;
            }
            String str = transportInfo.address;
            int i = transportInfo.port;
            C12238m.checkNotNullParameter("udp", "protocol");
            C12238m.checkNotNullParameter(str, "address");
            C12238m.checkNotNullParameter("xsalsa20_poly1305", "mode");
            C12238m.checkNotNullParameter(list, "codecs");
            c1245a.f1773H.m266a();
            Payloads.Protocol.ProtocolInfo protocolInfo = new Payloads.Protocol.ProtocolInfo(str, i, "xsalsa20_poly1305");
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
            for (C1221a c1221a : list) {
                arrayList.add(new Payloads.Protocol.CodecInfo(c1221a.f1671a, c1221a.f1672b, c1221a.f1673c, c1221a.f1674d, c1221a.f1675e));
            }
            c1245a.m350n(1, new Payloads.Protocol("udp", protocolInfo, arrayList));
        }
        Iterator<T> it = rtcConnection.listeners.iterator();
        while (it.hasNext()) {
            ((RtcConnection.InterfaceC5617c) it.next()).onMediaEngineConnectionConnected(rtcConnection);
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onConnectionStateChange(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.ConnectionState connectionState) {
        RtcConnection.State state;
        C12238m.checkNotNullParameter(mediaEngineConnection, "connection");
        C12238m.checkNotNullParameter(connectionState, "connectionState");
        RtcConnection rtcConnection = this.f1606a;
        RtcConnection.StateChange stateChange = rtcConnection.connectionStateChange;
        rtcConnection.m8475r("Connection state change: " + connectionState);
        int iOrdinal = connectionState.ordinal();
        if (iOrdinal == 0) {
            state = RtcConnection.State.C5614h.f18816a;
        } else if (iOrdinal == 1) {
            state = RtcConnection.State.C5613g.f18815a;
        } else if (iOrdinal == 2) {
            state = RtcConnection.State.C5612f.f18814a;
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            state = RtcConnection.State.C5611e.f18813a;
        }
        rtcConnection.m8478u(state);
        if (stateChange.state == RtcConnection.State.C5613g.f18815a && rtcConnection.connectionStateChange.state == RtcConnection.State.C5614h.f18816a) {
            rtcConnection.m8474q();
        }
        if (rtcConnection.connectionStateChange.state == RtcConnection.State.C5612f.f18814a) {
            rtcConnection.connectCompletedTime = Long.valueOf(rtcConnection.clock.currentTimeMillis());
            rtcConnection.connected = true;
            Map<String, Object> mapMutableMapOf = C12136h0.mutableMapOf(C12116o.m10073to("connect_count", Integer.valueOf(rtcConnection.connectCount)));
            Long l = rtcConnection.connectStartTime;
            Long l2 = rtcConnection.connectCompletedTime;
            Long lValueOf = (l2 == null || l == null) ? null : Long.valueOf(l2.longValue() - l.longValue());
            if (lValueOf != null) {
                mapMutableMapOf.put("connect_time", Long.valueOf(lValueOf.longValue()));
            }
            rtcConnection.m8461b(mapMutableMapOf);
            rtcConnection.m8473p(RtcConnection.AnalyticsEvent.VOICE_CONNECTION_SUCCESS, mapMutableMapOf);
            MediaSinkWantsManager mediaSinkWantsManager = rtcConnection.localMediaSinkWantsManager;
            if (mediaSinkWantsManager != null) {
                mediaSinkWantsManager.m8454b(new C1204i(mediaSinkWantsManager, rtcConnection.mediaEngineConnection));
            }
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onDestroy(MediaEngineConnection mediaEngineConnection) {
        C12238m.checkNotNullParameter(mediaEngineConnection, "connection");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onError(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.FailedConnectionException failedConnectionException) {
        C12238m.checkNotNullParameter(mediaEngineConnection, "connection");
        C12238m.checkNotNullParameter(failedConnectionException, "exception");
        RtcConnection rtcConnection = this.f1606a;
        Objects.requireNonNull(rtcConnection);
        String str = "connection error: " + failedConnectionException.getType();
        int iOrdinal = failedConnectionException.getType().ordinal();
        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2) {
            StringBuilder sbM836X = C1643a.m836X(str, " -- ");
            sbM836X.append(failedConnectionException.getMessage());
            rtcConnection.m8475r(sbM836X.toString());
        } else {
            RtcConnection.AnalyticsEvent analyticsEvent = RtcConnection.AnalyticsEvent.VOICE_CONNECTION_FAILURE;
            Map<String, Object> mapMutableMapOf = C12136h0.mutableMapOf(C12116o.m10073to("connect_count", Integer.valueOf(rtcConnection.connectCount)));
            rtcConnection.m8461b(mapMutableMapOf);
            rtcConnection.m8473p(analyticsEvent, mapMutableMapOf);
        }
        RtcConnection.m8459j(rtcConnection, true, str, failedConnectionException, false, 8);
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onKrispStatus(MediaEngineConnection mediaEngineConnection, KrispOveruseDetector.Status status) {
        C12238m.checkNotNullParameter(mediaEngineConnection, "connection");
        C12238m.checkNotNullParameter(status, "status");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onLocalMute(long j, boolean z2) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onLocalVideoOffScreen(long j, boolean z2) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onSpeaking(long j, int i, boolean z2) {
        C1245a c1245a;
        RtcConnection rtcConnection = this.f1606a;
        if (j == rtcConnection.userId && (c1245a = rtcConnection.socket) != null) {
            c1245a.f1773H.m266a();
            c1245a.m350n(5, new Payloads.Speaking(i, Integer.valueOf(z2 ? 1 : 0), 0, null, 8, null));
        }
        Iterator<T> it = rtcConnection.listeners.iterator();
        while (it.hasNext()) {
            ((RtcConnection.InterfaceC5617c) it.next()).onSpeaking(j, z2);
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onTargetBitrate(int i) {
        C1256e c1256e = this.f1606a.videoQuality;
        synchronized (c1256e) {
            c1256e.f1827l.f1859k = i;
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onTargetFrameRate(int i) {
        C1256e c1256e = this.f1606a.videoQuality;
        synchronized (c1256e) {
            c1256e.f1827l.f1860l = i;
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onVideo(long j, Integer num, int i, int i2, int i3, StreamParameters[] streamParametersArr) {
        C12238m.checkNotNullParameter(streamParametersArr, "streams");
        RtcConnection rtcConnection = this.f1606a;
        List<StreamParameters> listAsList = C12139j.asList(streamParametersArr);
        if (j == rtcConnection.userId) {
            C1245a c1245a = rtcConnection.socket;
            if (c1245a == null) {
                RtcConnection.m8460o(rtcConnection, "sendVideo() socket was null.", null, null, 6);
            } else {
                rtcConnection.videoSsrc = i2;
                if (i2 != 0) {
                    rtcConnection.sentVideo = true;
                }
                ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listAsList, 10));
                for (StreamParameters streamParameters : listAsList) {
                    String str = streamParameters.getType() == MediaType.Audio ? MediaStreamTrack.AUDIO_TRACK_KIND : MediaStreamTrack.VIDEO_TRACK_KIND;
                    String rid = streamParameters.getRid();
                    Integer numValueOf = Integer.valueOf(streamParameters.getSsrc());
                    Integer numValueOf2 = Integer.valueOf(streamParameters.getRtxSsrc());
                    Boolean boolValueOf = Boolean.valueOf(streamParameters.getActive());
                    Integer numValueOf3 = Integer.valueOf(streamParameters.getMaxBitrate());
                    Integer numValueOf4 = Integer.valueOf(streamParameters.getQuality());
                    C1207j0 c1207j0 = C1198f.f1625a;
                    Integer numValueOf5 = Integer.valueOf(c1207j0.f1636b.f1604c);
                    Payloads.ResolutionType resolutionType = Payloads.ResolutionType.Fixed;
                    C1190b c1190b = c1207j0.f1636b;
                    arrayList.add(new Payloads.Stream(str, rid, numValueOf5, numValueOf4, numValueOf, numValueOf2, new Payloads.Stream.MaxResolution(resolutionType, c1190b.f1602a, c1190b.f1603b), boolValueOf, numValueOf3));
                }
                C12238m.checkNotNullParameter(arrayList, "streams");
                c1245a.f1773H.m266a();
                c1245a.m350n(12, new Payloads.Video(i, i2, i3, null, arrayList));
            }
            MediaSinkWantsManager mediaSinkWantsManager = rtcConnection.localMediaSinkWantsManager;
            if (mediaSinkWantsManager != null) {
                mediaSinkWantsManager.m8454b(new C1208k(mediaSinkWantsManager, i2 != 0));
            }
        }
        Iterator<T> it = rtcConnection.listeners.iterator();
        while (it.hasNext()) {
            ((RtcConnection.InterfaceC5617c) it.next()).onVideoStream(j, num, i, i2, i3);
        }
    }
}
