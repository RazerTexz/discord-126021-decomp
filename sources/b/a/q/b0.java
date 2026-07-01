package b.a.q;

import b.a.q.m0.Codec2;
import b.a.q.n0.RtcControlSocket;
import b.a.q.o0.RtcStatsCollector2;
import b.a.q.o0.RtcStatsCollector3;
import b.a.q.o0.RtcStatsCollector4;
import b.a.q.o0.VideoQuality;
import b.d.b.a.outline;
import co.discord.media_engine.StreamParameters;
import co.discord.media_engine.StreamParameters2;
import co.discord.media_engine.VoiceQuality;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.rtcconnection.MediaSinkWantsManager;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.rtcconnection.socket.io.Payloads;
import d0.Tuples;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t._ArraysJvm;
import d0.z.d.Intrinsics3;
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
public final class b0 implements MediaEngineConnection.d {
    public final /* synthetic */ RtcConnection a;

    public b0(RtcConnection rtcConnection) {
        this.a = rtcConnection;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onConnected(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.TransportInfo transportInfo, List<Codec2> list) {
        Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
        Intrinsics3.checkNotNullParameter(transportInfo, "transportInfo");
        Intrinsics3.checkNotNullParameter(list, "supportedVideoCodecs");
        RtcConnection rtcConnection = this.a;
        rtcConnection.reconnectBackoff.succeed();
        rtcConnection.transportInfo = transportInfo;
        MediaEngineConnection mediaEngineConnection2 = rtcConnection.mediaEngineConnection;
        if (mediaEngineConnection2 != null) {
            RtcStatsCollector4 rtcStatsCollector4 = new RtcStatsCollector4(1000L, rtcConnection.logger, mediaEngineConnection2, new VoiceQuality(), rtcConnection.videoQuality, new KrispOveruseDetector(mediaEngineConnection2), 0, 64);
            rtcStatsCollector4.a.clear();
            Subscription subscription = rtcStatsCollector4.f279b;
            if (subscription != null && !subscription.isUnsubscribed()) {
                rtcStatsCollector4.a();
            }
            rtcStatsCollector4.f279b = Observable.E(0L, rtcStatsCollector4.c, TimeUnit.MILLISECONDS).W(new RtcStatsCollector2(rtcStatsCollector4), new RtcStatsCollector3(rtcStatsCollector4));
            rtcConnection.rtcStatsCollector = rtcStatsCollector4;
            rtcConnection.sentVideo = false;
        }
        if (transportInfo.protocol.ordinal() != 0) {
            StringBuilder sbU = outline.U("Unsupported protocol: ");
            sbU.append(transportInfo.protocol);
            sbU.append('.');
            RtcConnection.j(rtcConnection, true, sbU.toString(), null, false, 12);
        } else {
            rtcConnection.logger.recordBreadcrumb("Sending UDP info to RTC server.", rtcConnection.loggingTag);
            RtcControlSocket rtcControlSocket = rtcConnection.socket;
            if (rtcControlSocket == null) {
                RtcConnection.o(rtcConnection, "onEngineConnectionConnected() socket was null.", null, null, 6);
                return;
            }
            String str = transportInfo.address;
            int i = transportInfo.port;
            Intrinsics3.checkNotNullParameter("udp", "protocol");
            Intrinsics3.checkNotNullParameter(str, "address");
            Intrinsics3.checkNotNullParameter("xsalsa20_poly1305", "mode");
            Intrinsics3.checkNotNullParameter(list, "codecs");
            rtcControlSocket.H.a();
            Payloads.Protocol.ProtocolInfo protocolInfo = new Payloads.Protocol.ProtocolInfo(str, i, "xsalsa20_poly1305");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            for (Codec2 codec2 : list) {
                arrayList.add(new Payloads.Protocol.CodecInfo(codec2.a, codec2.f266b, codec2.c, codec2.d, codec2.e));
            }
            rtcControlSocket.n(1, new Payloads.Protocol("udp", protocolInfo, arrayList));
        }
        Iterator<T> it = rtcConnection.listeners.iterator();
        while (it.hasNext()) {
            ((RtcConnection.c) it.next()).onMediaEngineConnectionConnected(rtcConnection);
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onConnectionStateChange(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.ConnectionState connectionState) {
        RtcConnection.State state;
        Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
        Intrinsics3.checkNotNullParameter(connectionState, "connectionState");
        RtcConnection rtcConnection = this.a;
        RtcConnection.StateChange stateChange = rtcConnection.connectionStateChange;
        rtcConnection.r("Connection state change: " + connectionState);
        int iOrdinal = connectionState.ordinal();
        if (iOrdinal == 0) {
            state = RtcConnection.State.h.a;
        } else if (iOrdinal == 1) {
            state = RtcConnection.State.g.a;
        } else if (iOrdinal == 2) {
            state = RtcConnection.State.f.a;
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            state = RtcConnection.State.e.a;
        }
        rtcConnection.u(state);
        if (stateChange.state == RtcConnection.State.g.a && rtcConnection.connectionStateChange.state == RtcConnection.State.h.a) {
            rtcConnection.q();
        }
        if (rtcConnection.connectionStateChange.state == RtcConnection.State.f.a) {
            rtcConnection.connectCompletedTime = Long.valueOf(rtcConnection.clock.currentTimeMillis());
            rtcConnection.connected = true;
            Map<String, Object> mapMutableMapOf = Maps6.mutableMapOf(Tuples.to("connect_count", Integer.valueOf(rtcConnection.connectCount)));
            Long l = rtcConnection.connectStartTime;
            Long l2 = rtcConnection.connectCompletedTime;
            Long lValueOf = (l2 == null || l == null) ? null : Long.valueOf(l2.longValue() - l.longValue());
            if (lValueOf != null) {
                mapMutableMapOf.put("connect_time", Long.valueOf(lValueOf.longValue()));
            }
            rtcConnection.b(mapMutableMapOf);
            rtcConnection.p(RtcConnection.AnalyticsEvent.VOICE_CONNECTION_SUCCESS, mapMutableMapOf);
            MediaSinkWantsManager mediaSinkWantsManager = rtcConnection.localMediaSinkWantsManager;
            if (mediaSinkWantsManager != null) {
                mediaSinkWantsManager.b(new MediaSinkWantsManager4(mediaSinkWantsManager, rtcConnection.mediaEngineConnection));
            }
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onDestroy(MediaEngineConnection mediaEngineConnection) {
        Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onError(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.FailedConnectionException failedConnectionException) {
        Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
        Intrinsics3.checkNotNullParameter(failedConnectionException, "exception");
        RtcConnection rtcConnection = this.a;
        Objects.requireNonNull(rtcConnection);
        String str = "connection error: " + failedConnectionException.getType();
        int iOrdinal = failedConnectionException.getType().ordinal();
        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2) {
            StringBuilder sbX = outline.X(str, " -- ");
            sbX.append(failedConnectionException.getMessage());
            rtcConnection.r(sbX.toString());
        } else {
            RtcConnection.AnalyticsEvent analyticsEvent = RtcConnection.AnalyticsEvent.VOICE_CONNECTION_FAILURE;
            Map<String, Object> mapMutableMapOf = Maps6.mutableMapOf(Tuples.to("connect_count", Integer.valueOf(rtcConnection.connectCount)));
            rtcConnection.b(mapMutableMapOf);
            rtcConnection.p(analyticsEvent, mapMutableMapOf);
        }
        RtcConnection.j(rtcConnection, true, str, failedConnectionException, false, 8);
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onKrispStatus(MediaEngineConnection mediaEngineConnection, KrispOveruseDetector.Status status) {
        Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
        Intrinsics3.checkNotNullParameter(status, "status");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onLocalMute(long j, boolean z2) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onLocalVideoOffScreen(long j, boolean z2) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onSpeaking(long j, int i, boolean z2) {
        RtcControlSocket rtcControlSocket;
        RtcConnection rtcConnection = this.a;
        if (j == rtcConnection.userId && (rtcControlSocket = rtcConnection.socket) != null) {
            rtcControlSocket.H.a();
            rtcControlSocket.n(5, new Payloads.Speaking(i, Integer.valueOf(z2 ? 1 : 0), 0, null, 8, null));
        }
        Iterator<T> it = rtcConnection.listeners.iterator();
        while (it.hasNext()) {
            ((RtcConnection.c) it.next()).onSpeaking(j, z2);
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onTargetBitrate(int i) {
        VideoQuality videoQuality = this.a.videoQuality;
        synchronized (videoQuality) {
            videoQuality.l.k = i;
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onTargetFrameRate(int i) {
        VideoQuality videoQuality = this.a.videoQuality;
        synchronized (videoQuality) {
            videoQuality.l.l = i;
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onVideo(long j, Integer num, int i, int i2, int i3, StreamParameters[] streamParametersArr) {
        Intrinsics3.checkNotNullParameter(streamParametersArr, "streams");
        RtcConnection rtcConnection = this.a;
        List<StreamParameters> listAsList = _ArraysJvm.asList(streamParametersArr);
        if (j == rtcConnection.userId) {
            RtcControlSocket rtcControlSocket = rtcConnection.socket;
            if (rtcControlSocket == null) {
                RtcConnection.o(rtcConnection, "sendVideo() socket was null.", null, null, 6);
            } else {
                rtcConnection.videoSsrc = i2;
                if (i2 != 0) {
                    rtcConnection.sentVideo = true;
                }
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listAsList, 10));
                for (StreamParameters streamParameters : listAsList) {
                    String str = streamParameters.getType() == StreamParameters2.Audio ? MediaStreamTrack.AUDIO_TRACK_KIND : MediaStreamTrack.VIDEO_TRACK_KIND;
                    String rid = streamParameters.getRid();
                    Integer numValueOf = Integer.valueOf(streamParameters.getSsrc());
                    Integer numValueOf2 = Integer.valueOf(streamParameters.getRtxSsrc());
                    Boolean boolValueOf = Boolean.valueOf(streamParameters.getActive());
                    Integer numValueOf3 = Integer.valueOf(streamParameters.getMaxBitrate());
                    Integer numValueOf4 = Integer.valueOf(streamParameters.getQuality());
                    MediaSinkWantsLadder5 mediaSinkWantsLadder5 = MediaSinkWantsLadder4.a;
                    Integer numValueOf5 = Integer.valueOf(mediaSinkWantsLadder5.f260b.c);
                    Payloads.ResolutionType resolutionType = Payloads.ResolutionType.Fixed;
                    MediaSinkWantsLadder2 mediaSinkWantsLadder2 = mediaSinkWantsLadder5.f260b;
                    arrayList.add(new Payloads.Stream(str, rid, numValueOf5, numValueOf4, numValueOf, numValueOf2, new Payloads.Stream.MaxResolution(resolutionType, mediaSinkWantsLadder2.a, mediaSinkWantsLadder2.f256b), boolValueOf, numValueOf3));
                }
                Intrinsics3.checkNotNullParameter(arrayList, "streams");
                rtcControlSocket.H.a();
                rtcControlSocket.n(12, new Payloads.Video(i, i2, i3, null, arrayList));
            }
            MediaSinkWantsManager mediaSinkWantsManager = rtcConnection.localMediaSinkWantsManager;
            if (mediaSinkWantsManager != null) {
                mediaSinkWantsManager.b(new MediaSinkWantsManager6(mediaSinkWantsManager, i2 != 0));
            }
        }
        Iterator<T> it = rtcConnection.listeners.iterator();
        while (it.hasNext()) {
            ((RtcConnection.c) it.next()).onVideoStream(j, num, i, i2, i3);
        }
    }
}
