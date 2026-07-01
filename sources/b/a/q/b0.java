package b.a.q;

import co.discord.media_engine.MediaType;
import co.discord.media_engine.StreamParameters;
import co.discord.media_engine.VoiceQuality;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.rtcconnection.KrispOveruseDetector$Status;
import com.discord.rtcconnection.MediaSinkWantsManager;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.RtcConnection$AnalyticsEvent;
import com.discord.rtcconnection.RtcConnection$State;
import com.discord.rtcconnection.RtcConnection$State$e;
import com.discord.rtcconnection.RtcConnection$State$f;
import com.discord.rtcconnection.RtcConnection$State$g;
import com.discord.rtcconnection.RtcConnection$State$h;
import com.discord.rtcconnection.RtcConnection$StateChange;
import com.discord.rtcconnection.RtcConnection$c;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$ConnectionState;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$FailedConnectionException;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$TransportInfo;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$d;
import com.discord.rtcconnection.socket.io.Payloads$Protocol;
import com.discord.rtcconnection.socket.io.Payloads$Protocol$CodecInfo;
import com.discord.rtcconnection.socket.io.Payloads$Protocol$ProtocolInfo;
import com.discord.rtcconnection.socket.io.Payloads$ResolutionType;
import com.discord.rtcconnection.socket.io.Payloads$Speaking;
import com.discord.rtcconnection.socket.io.Payloads$Stream;
import com.discord.rtcconnection.socket.io.Payloads$Stream$MaxResolution;
import com.discord.rtcconnection.socket.io.Payloads$Video;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import org.webrtc.MediaStreamTrack;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b0 implements MediaEngineConnection$d {
    public final /* synthetic */ RtcConnection a;

    public b0(RtcConnection rtcConnection) {
        this.a = rtcConnection;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onConnected(MediaEngineConnection mediaEngineConnection, MediaEngineConnection$TransportInfo mediaEngineConnection$TransportInfo, List<b.a.q.m0.a> list) {
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection, "connection");
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection$TransportInfo, "transportInfo");
        d0.z.d.m.checkNotNullParameter(list, "supportedVideoCodecs");
        RtcConnection rtcConnection = this.a;
        rtcConnection.reconnectBackoff.succeed();
        rtcConnection.transportInfo = mediaEngineConnection$TransportInfo;
        MediaEngineConnection mediaEngineConnection2 = rtcConnection.mediaEngineConnection;
        if (mediaEngineConnection2 != null) {
            b.a.q.o0.d dVar = new b.a.q.o0.d(1000L, rtcConnection.logger, mediaEngineConnection2, new VoiceQuality(), rtcConnection.videoQuality, new KrispOveruseDetector(mediaEngineConnection2), 0, 64);
            dVar.a.clear();
            Subscription subscription = dVar.f279b;
            if (subscription != null && !subscription.isUnsubscribed()) {
                dVar.a();
            }
            dVar.f279b = Observable.E(0L, dVar.c, TimeUnit.MILLISECONDS).W(new b.a.q.o0.b(dVar), new b.a.q.o0.c(dVar));
            rtcConnection.rtcStatsCollector = dVar;
            rtcConnection.sentVideo = false;
        }
        if (mediaEngineConnection$TransportInfo.protocol.ordinal() != 0) {
            StringBuilder sbU = b.d.b.a.a.U("Unsupported protocol: ");
            sbU.append(mediaEngineConnection$TransportInfo.protocol);
            sbU.append('.');
            RtcConnection.j(rtcConnection, true, sbU.toString(), null, false, 12);
        } else {
            rtcConnection.logger.recordBreadcrumb("Sending UDP info to RTC server.", rtcConnection.loggingTag);
            b.a.q.n0.a aVar = rtcConnection.socket;
            if (aVar == null) {
                RtcConnection.o(rtcConnection, "onEngineConnectionConnected() socket was null.", null, null, 6);
                return;
            }
            String str = mediaEngineConnection$TransportInfo.address;
            int i = mediaEngineConnection$TransportInfo.port;
            d0.z.d.m.checkNotNullParameter("udp", "protocol");
            d0.z.d.m.checkNotNullParameter(str, "address");
            d0.z.d.m.checkNotNullParameter("xsalsa20_poly1305", "mode");
            d0.z.d.m.checkNotNullParameter(list, "codecs");
            aVar.H.a();
            Payloads$Protocol$ProtocolInfo payloads$Protocol$ProtocolInfo = new Payloads$Protocol$ProtocolInfo(str, i, "xsalsa20_poly1305");
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
            for (b.a.q.m0.a aVar2 : list) {
                arrayList.add(new Payloads$Protocol$CodecInfo(aVar2.a, aVar2.f266b, aVar2.c, aVar2.d, aVar2.e));
            }
            aVar.n(1, new Payloads$Protocol("udp", payloads$Protocol$ProtocolInfo, arrayList));
        }
        Iterator<T> it = rtcConnection.listeners.iterator();
        while (it.hasNext()) {
            ((RtcConnection$c) it.next()).onMediaEngineConnectionConnected(rtcConnection);
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onConnectionStateChange(MediaEngineConnection mediaEngineConnection, MediaEngineConnection$ConnectionState mediaEngineConnection$ConnectionState) {
        RtcConnection$State rtcConnection$State;
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection, "connection");
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection$ConnectionState, "connectionState");
        RtcConnection rtcConnection = this.a;
        RtcConnection$StateChange rtcConnection$StateChange = rtcConnection.connectionStateChange;
        rtcConnection.r("Connection state change: " + mediaEngineConnection$ConnectionState);
        int iOrdinal = mediaEngineConnection$ConnectionState.ordinal();
        if (iOrdinal == 0) {
            rtcConnection$State = RtcConnection$State$h.a;
        } else if (iOrdinal == 1) {
            rtcConnection$State = RtcConnection$State$g.a;
        } else if (iOrdinal == 2) {
            rtcConnection$State = RtcConnection$State$f.a;
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            rtcConnection$State = RtcConnection$State$e.a;
        }
        rtcConnection.u(rtcConnection$State);
        if (rtcConnection$StateChange.state == RtcConnection$State$g.a && rtcConnection.connectionStateChange.state == RtcConnection$State$h.a) {
            rtcConnection.q();
        }
        if (rtcConnection.connectionStateChange.state == RtcConnection$State$f.a) {
            rtcConnection.connectCompletedTime = Long.valueOf(rtcConnection.clock.currentTimeMillis());
            rtcConnection.connected = true;
            Map<String, Object> mapMutableMapOf = d0.t.h0.mutableMapOf(d0.o.to("connect_count", Integer.valueOf(rtcConnection.connectCount)));
            Long l = rtcConnection.connectStartTime;
            Long l2 = rtcConnection.connectCompletedTime;
            Long lValueOf = (l2 == null || l == null) ? null : Long.valueOf(l2.longValue() - l.longValue());
            if (lValueOf != null) {
                mapMutableMapOf.put("connect_time", Long.valueOf(lValueOf.longValue()));
            }
            rtcConnection.b(mapMutableMapOf);
            rtcConnection.p(RtcConnection$AnalyticsEvent.VOICE_CONNECTION_SUCCESS, mapMutableMapOf);
            MediaSinkWantsManager mediaSinkWantsManager = rtcConnection.localMediaSinkWantsManager;
            if (mediaSinkWantsManager != null) {
                mediaSinkWantsManager.b(new i(mediaSinkWantsManager, rtcConnection.mediaEngineConnection));
            }
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onDestroy(MediaEngineConnection mediaEngineConnection) {
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection, "connection");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onError(MediaEngineConnection mediaEngineConnection, MediaEngineConnection$FailedConnectionException mediaEngineConnection$FailedConnectionException) {
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection, "connection");
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection$FailedConnectionException, "exception");
        RtcConnection rtcConnection = this.a;
        Objects.requireNonNull(rtcConnection);
        String str = "connection error: " + mediaEngineConnection$FailedConnectionException.getType();
        int iOrdinal = mediaEngineConnection$FailedConnectionException.getType().ordinal();
        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2) {
            StringBuilder sbX = b.d.b.a.a.X(str, " -- ");
            sbX.append(mediaEngineConnection$FailedConnectionException.getMessage());
            rtcConnection.r(sbX.toString());
        } else {
            RtcConnection$AnalyticsEvent rtcConnection$AnalyticsEvent = RtcConnection$AnalyticsEvent.VOICE_CONNECTION_FAILURE;
            Map<String, Object> mapMutableMapOf = d0.t.h0.mutableMapOf(d0.o.to("connect_count", Integer.valueOf(rtcConnection.connectCount)));
            rtcConnection.b(mapMutableMapOf);
            rtcConnection.p(rtcConnection$AnalyticsEvent, mapMutableMapOf);
        }
        RtcConnection.j(rtcConnection, true, str, mediaEngineConnection$FailedConnectionException, false, 8);
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onKrispStatus(MediaEngineConnection mediaEngineConnection, KrispOveruseDetector$Status krispOveruseDetector$Status) {
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection, "connection");
        d0.z.d.m.checkNotNullParameter(krispOveruseDetector$Status, "status");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onLocalMute(long j, boolean z2) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onLocalVideoOffScreen(long j, boolean z2) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onSpeaking(long j, int i, boolean z2) {
        b.a.q.n0.a aVar;
        RtcConnection rtcConnection = this.a;
        if (j == rtcConnection.userId && (aVar = rtcConnection.socket) != null) {
            aVar.H.a();
            aVar.n(5, new Payloads$Speaking(i, Integer.valueOf(z2 ? 1 : 0), 0, null, 8, null));
        }
        Iterator<T> it = rtcConnection.listeners.iterator();
        while (it.hasNext()) {
            ((RtcConnection$c) it.next()).onSpeaking(j, z2);
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onTargetBitrate(int i) {
        b.a.q.o0.e eVar = this.a.videoQuality;
        synchronized (eVar) {
            eVar.l.k = i;
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onTargetFrameRate(int i) {
        b.a.q.o0.e eVar = this.a.videoQuality;
        synchronized (eVar) {
            eVar.l.l = i;
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onVideo(long j, Integer num, int i, int i2, int i3, StreamParameters[] streamParametersArr) {
        d0.z.d.m.checkNotNullParameter(streamParametersArr, "streams");
        RtcConnection rtcConnection = this.a;
        List<StreamParameters> listAsList = d0.t.j.asList(streamParametersArr);
        if (j == rtcConnection.userId) {
            b.a.q.n0.a aVar = rtcConnection.socket;
            if (aVar == null) {
                RtcConnection.o(rtcConnection, "sendVideo() socket was null.", null, null, 6);
            } else {
                rtcConnection.videoSsrc = i2;
                if (i2 != 0) {
                    rtcConnection.sentVideo = true;
                }
                ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listAsList, 10));
                for (StreamParameters streamParameters : listAsList) {
                    String str = streamParameters.getType() == MediaType.Audio ? MediaStreamTrack.AUDIO_TRACK_KIND : MediaStreamTrack.VIDEO_TRACK_KIND;
                    String rid = streamParameters.getRid();
                    Integer numValueOf = Integer.valueOf(streamParameters.getSsrc());
                    Integer numValueOf2 = Integer.valueOf(streamParameters.getRtxSsrc());
                    Boolean boolValueOf = Boolean.valueOf(streamParameters.getActive());
                    Integer numValueOf3 = Integer.valueOf(streamParameters.getMaxBitrate());
                    Integer numValueOf4 = Integer.valueOf(streamParameters.getQuality());
                    j0 j0Var = f.a;
                    Integer numValueOf5 = Integer.valueOf(j0Var.f260b.c);
                    Payloads$ResolutionType payloads$ResolutionType = Payloads$ResolutionType.Fixed;
                    b bVar = j0Var.f260b;
                    arrayList.add(new Payloads$Stream(str, rid, numValueOf5, numValueOf4, numValueOf, numValueOf2, new Payloads$Stream$MaxResolution(payloads$ResolutionType, bVar.a, bVar.f256b), boolValueOf, numValueOf3));
                }
                d0.z.d.m.checkNotNullParameter(arrayList, "streams");
                aVar.H.a();
                aVar.n(12, new Payloads$Video(i, i2, i3, null, arrayList));
            }
            MediaSinkWantsManager mediaSinkWantsManager = rtcConnection.localMediaSinkWantsManager;
            if (mediaSinkWantsManager != null) {
                mediaSinkWantsManager.b(new k(mediaSinkWantsManager, i2 != 0));
            }
        }
        Iterator<T> it = rtcConnection.listeners.iterator();
        while (it.hasNext()) {
            ((RtcConnection$c) it.next()).onVideoStream(j, num, i, i2, i3);
        }
    }
}
