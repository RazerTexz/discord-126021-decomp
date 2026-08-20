package p007b.p008a.p041q;

import co.discord.media_engine.MediaType;
import co.discord.media_engine.StreamParameters;
import com.discord.rtcconnection.EncodeQuality;
import com.discord.rtcconnection.MediaSinkWantsManager;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.VideoMetadata;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.rtcconnection.socket.p499io.Payloads;
import com.discord.utilities.logging.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import org.webrtc.MediaStreamTrack;
import p007b.p008a.p041q.p046n0.C1245a;
import p007b.p008a.p041q.p047o0.C1255d;
import p007b.p008a.p041q.p047o0.C1256e;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12160r;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.h0 */
/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1203h0 implements C1245a.d {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ RtcConnection f1628a;

    public C1203h0(RtcConnection rtcConnection) {
        this.f1628a = rtcConnection;
    }

    @Override // p007b.p008a.p041q.p046n0.C1245a.d
    /* JADX INFO: renamed from: a */
    public void mo267a(String str, String str2) {
        C12238m.checkNotNullParameter(str, "audioCodec");
        C12238m.checkNotNullParameter(str2, "videoCodec");
        MediaEngineConnection mediaEngineConnection = this.f1628a.mediaEngineConnection;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.mo312r(str, str2);
        }
    }

    @Override // p007b.p008a.p041q.p046n0.C1245a.d
    /* JADX INFO: renamed from: b */
    public void mo268b(boolean z2, Integer num, String str) {
        long jCurrentTimeMillis;
        RtcConnection rtcConnection = this.f1628a;
        Objects.requireNonNull(rtcConnection);
        rtcConnection.m8475r("Disconnected from RTC server. wasFatal: " + z2 + " -- code: " + num + " -- reason: " + str);
        MediaEngineConnection mediaEngineConnection = rtcConnection.mediaEngineConnection;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.destroy();
        }
        MediaEngineConnection mediaEngineConnection2 = rtcConnection.mediaEngineConnection;
        if (mediaEngineConnection2 != null) {
            mediaEngineConnection2.mo309o(rtcConnection.mediaEngineConnectionListener);
        }
        Long l = rtcConnection.networkLossTime;
        if (l != null) {
            jCurrentTimeMillis = rtcConnection.clock.currentTimeMillis() - l.longValue();
        } else {
            jCurrentTimeMillis = 0;
        }
        boolean z3 = (num == null || num.intValue() != 1000) && !((jCurrentTimeMillis > 30000L ? 1 : (jCurrentTimeMillis == 30000L ? 0 : -1)) > 0);
        if (!(rtcConnection.connectionStateChange.state instanceof RtcConnection.State.C5610d)) {
            rtcConnection.m8472n(z3, str);
            C1255d c1255d = rtcConnection.rtcStatsCollector;
            if (c1255d != null) {
                c1255d.m351a();
            }
            rtcConnection.rtcStatsCollector = null;
            rtcConnection.sentVideo = false;
        }
        rtcConnection.pingBadCount = 0;
        rtcConnection.connectCompletedTime = null;
        MediaSinkWantsManager mediaSinkWantsManager = rtcConnection.localMediaSinkWantsManager;
        if (mediaSinkWantsManager != null) {
            mediaSinkWantsManager.m8454b(new C1200g(mediaSinkWantsManager));
        }
        rtcConnection.m8478u(new RtcConnection.State.C5610d(z3));
        if (z3) {
            Logger.w$default(rtcConnection.logger, rtcConnection.loggingTag, "Disconnect was not clean! Reason: " + str + ", code: " + num + ". Reconnecting in " + (rtcConnection.reconnectBackoff.fail(new C1195d0(rtcConnection)) / ((long) 1000)) + " seconds.", null, 4, null);
        }
    }

    @Override // p007b.p008a.p041q.p046n0.C1245a.d
    /* JADX INFO: renamed from: c */
    public void mo269c(String str, List<Integer> list) {
        C12238m.checkNotNullParameter(str, "mode");
        C12238m.checkNotNullParameter(list, "secretKey");
        MediaEngineConnection mediaEngineConnection = this.f1628a.mediaEngineConnection;
        if (mediaEngineConnection != null) {
            mediaEngineConnection.mo314t(str, C12163u.toIntArray(list));
        }
    }

    @Override // p007b.p008a.p041q.p046n0.C1245a.d
    /* JADX INFO: renamed from: d */
    public void mo270d(String str) {
        C12238m.checkNotNullParameter(str, "mediaSessionId");
        RtcConnection rtcConnection = this.f1628a;
        rtcConnection.mediaSessionId = str;
        Iterator<T> it = rtcConnection.listeners.iterator();
        while (it.hasNext()) {
            ((RtcConnection.InterfaceC5617c) it.next()).onMediaSessionIdReceived();
        }
        rtcConnection.m8473p(RtcConnection.AnalyticsEvent.MEDIA_SESSION_JOINED, new LinkedHashMap());
    }

    /* JADX WARN: Code duplicated, block: B:52:0x014e  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.util.List] */
    @Override // p007b.p008a.p041q.p046n0.C1245a.d
    /* JADX INFO: renamed from: e */
    public void mo271e(long j, int i, int i2, List<Payloads.Stream> list) {
        VideoMetadata videoMetadata;
        Object next;
        Payloads.Stream stream;
        Integer ssrc;
        ?? EmptyList;
        RtcConnection rtcConnection = this.f1628a;
        C1256e c1256e = rtcConnection.videoQuality;
        long j2 = i2;
        synchronized (c1256e) {
            if (j2 != 0) {
                c1256e.f1829n.put(Long.valueOf(j2), Long.valueOf(c1256e.f1832q.currentTimeMillis()));
                Logger.i$default(c1256e.f1831p, "VideoQuality: handleVideoStreamUpdate(userId: " + j + ", videoSsrc: " + j2 + ')', null, 2, null);
            }
        }
        if (j != rtcConnection.userId) {
            if (rtcConnection.localMediaSinkWantsManager != null) {
                if (list != null) {
                    EmptyList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
                    for (Payloads.Stream stream2 : list) {
                        EmptyList.add(stream2.copy((382 & 1) != 0 ? stream2.type : MediaStreamTrack.VIDEO_TRACK_KIND, (382 & 2) != 0 ? stream2.rid : null, (382 & 4) != 0 ? stream2.maxFrameRate : null, (382 & 8) != 0 ? stream2.quality : null, (382 & 16) != 0 ? stream2.ssrc : null, (382 & 32) != 0 ? stream2.rtxSsrc : null, (382 & 64) != 0 ? stream2.maxResolution : null, (382 & 128) != 0 ? stream2.active : Boolean.valueOf(i2 > 0), (382 & 256) != 0 ? stream2.maxBitrate : null));
                    }
                } else {
                    EmptyList = C12147n.emptyList();
                }
                boolean zIsEmpty = EmptyList.isEmpty();
                ?? ListOf = EmptyList;
                if (zIsEmpty) {
                    ListOf = C12145m.listOf(new Payloads.Stream(MediaStreamTrack.VIDEO_TRACK_KIND, "100", null, 100, Integer.valueOf(i2), Integer.valueOf(i2 + 1), null, Boolean.valueOf(i2 > 0), null));
                }
                rtcConnection.localMediaSinkWantsManager.m8455c(j, Long.valueOf(i));
                MediaSinkWantsManager mediaSinkWantsManager = rtcConnection.localMediaSinkWantsManager;
                Objects.requireNonNull(mediaSinkWantsManager);
                C12238m.checkNotNullParameter(ListOf, "ssrcs");
                mediaSinkWantsManager.m8454b(new C1218l(mediaSinkWantsManager, ListOf, j));
                return;
            }
            if (list != null) {
                Iterator it = list.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        stream = (Payloads.Stream) next;
                        ssrc = stream.getSsrc();
                    }
                } while (!((ssrc == null || ssrc.intValue() != i2 || stream.getMaxResolution() == null) ? false : true));
                Payloads.Stream stream3 = (Payloads.Stream) next;
                if (stream3 != null) {
                    Payloads.Stream.MaxResolution maxResolution = stream3.getMaxResolution();
                    C12238m.checkNotNull(maxResolution);
                    videoMetadata = new VideoMetadata(j, maxResolution.getWidth(), stream3.getMaxResolution().getHeight(), stream3.getMaxFrameRate(), stream3.getMaxResolution().getType());
                } else {
                    videoMetadata = null;
                }
            } else {
                videoMetadata = null;
            }
            rtcConnection.m8463d(j, i, j2, videoMetadata);
        }
    }

    @Override // p007b.p008a.p041q.p046n0.C1245a.d
    /* JADX INFO: renamed from: f */
    public void mo272f(Map<String, Integer> map) {
        Integer num;
        C12238m.checkNotNullParameter(map, "wants");
        RtcConnection rtcConnection = this.f1628a;
        if (rtcConnection.localMediaSinkWantsManager != null) {
            long j = rtcConnection.videoSsrc;
            int iIntValue = (j == 0 || (num = map.get(String.valueOf(j))) == null) ? 0 : num.intValue();
            Integer num2 = map.get("any");
            int iIntValue2 = num2 != null ? num2.intValue() : 0;
            if (iIntValue <= 0) {
                iIntValue = iIntValue2 > 0 ? iIntValue2 : 100;
            }
            C1196e.c cVar = null;
            rtcConnection.logger.mo8366i(rtcConnection.loggingTag, "remote MediaSinkWants: " + map + ", decided on encode quality " + iIntValue, null);
            EncodeQuality[] encodeQualityArrValues = EncodeQuality.values();
            for (int i = 10; i >= 0; i--) {
                EncodeQuality encodeQuality = encodeQualityArrValues[i];
                if (encodeQuality.getValue() <= iIntValue) {
                    C1196e c1196e = rtcConnection.localMediaSinkWantsManager.f18751j;
                    C1207j0 c1207j0 = c1196e.f1617e;
                    C12238m.checkNotNullParameter(encodeQuality, "wantValue");
                    List<C1196e.c> list = c1196e.f1616d;
                    ListIterator<C1196e.c> listIterator = list.listIterator(list.size());
                    while (listIterator.hasPrevious()) {
                        C1196e.c cVarPrevious = listIterator.previous();
                        if (encodeQuality.compareTo(cVarPrevious.f1624c) >= 0) {
                            cVar = cVarPrevious;
                            break;
                        }
                    }
                    C1196e.c cVar2 = cVar;
                    if (cVar2 == null) {
                        cVar2 = (C1196e.c) C12163u.first((List) c1196e.f1616d);
                    }
                    C1244n c1244n = cVar2.f1622a;
                    int iMax = Math.max((int) (((double) c1207j0.f1637c.f1599a) * c1244n.f1760c), c1207j0.f1638d);
                    int iMax2 = Math.max((int) (((double) c1207j0.f1637c.f1600b) * c1244n.f1760c), c1207j0.f1638d);
                    MediaEngineConnection mediaEngineConnection = rtcConnection.mediaEngineConnection;
                    if (mediaEngineConnection != null) {
                        mediaEngineConnection.mo307m(new MediaEngineConnection.C5646b(iMax, iMax2, c1244n.f1758a, c1244n.f1759b, c1244n.f1761d, c1244n.f1762e));
                        return;
                    }
                    return;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
    }

    @Override // p007b.p008a.p041q.p046n0.C1245a.d
    /* JADX INFO: renamed from: g */
    public void mo273g(long j) {
        RtcConnection.Quality quality;
        RtcConnection rtcConnection = this.f1628a;
        rtcConnection.pings.add(Long.valueOf(j));
        if (rtcConnection.pings.size() > 5) {
            C12160r.removeFirst(rtcConnection.pings);
        }
        if (j > 500) {
            rtcConnection.pingBadCount++;
        }
        double d = j;
        Objects.requireNonNull(RtcConnection.Quality.INSTANCE);
        if (Double.isNaN(d)) {
            quality = RtcConnection.Quality.UNKNOWN;
        } else if (d < 250) {
            quality = RtcConnection.Quality.FINE;
        } else {
            quality = d < ((double) 500) ? RtcConnection.Quality.AVERAGE : RtcConnection.Quality.BAD;
        }
        Iterator<T> it = rtcConnection.listeners.iterator();
        while (it.hasNext()) {
            ((RtcConnection.InterfaceC5617c) it.next()).onQualityUpdate(quality);
        }
    }

    @Override // p007b.p008a.p041q.p046n0.C1245a.d
    /* JADX INFO: renamed from: h */
    public void mo274h() {
    }

    @Override // p007b.p008a.p041q.p046n0.C1245a.d
    /* JADX INFO: renamed from: i */
    public void mo275i() {
        RtcConnection rtcConnection = this.f1628a;
        rtcConnection.reconnectBackoff.cancel();
        rtcConnection.logger.recordBreadcrumb("Connected to RTC server.", rtcConnection.loggingTag);
        C1245a c1245a = rtcConnection.socket;
        if (c1245a == null) {
            RtcConnection.m8460o(rtcConnection, "onSocketConnect() socket was null.", null, null, 6);
            return;
        }
        List listListOf = C12145m.listOf(new Payloads.Stream(MediaStreamTrack.VIDEO_TRACK_KIND, "100", null, 100, null, null, null, null, null));
        String str = rtcConnection.rtcServerId;
        long j = rtcConnection.userId;
        String str2 = rtcConnection.sessionId;
        boolean z2 = rtcConnection.isVideoEnabled;
        C12238m.checkNotNullParameter(str, "serverId");
        C12238m.checkNotNullParameter(str2, "sessionId");
        C12238m.checkNotNullParameter(listListOf, "streams");
        c1245a.f1773H.m266a();
        c1245a.f1783t = str;
        c1245a.f1784u = str2;
        c1245a.f1767B = C1245a.c.IDENTIFYING;
        c1245a.m350n(0, new Payloads.Identify(str, j, str2, c1245a.f1770E, z2, listListOf));
        rtcConnection.m8478u(RtcConnection.State.C5607a.f18809a);
    }

    @Override // p007b.p008a.p041q.p046n0.C1245a.d
    /* JADX INFO: renamed from: j */
    public void mo276j(long j) {
        Map<String, Object> mapM354c;
        RtcConnection rtcConnection = this.f1628a;
        if ((rtcConnection.rtcConnectionType instanceof RtcConnection.AbstractC5618d.a) && (mapM354c = rtcConnection.videoQuality.m354c(String.valueOf(j))) != null) {
            rtcConnection.m8470l(j, mapM354c);
        }
        MediaSinkWantsManager mediaSinkWantsManager = rtcConnection.localMediaSinkWantsManager;
        if (mediaSinkWantsManager != null) {
            mediaSinkWantsManager.m8455c(j, null);
        }
        MediaSinkWantsManager mediaSinkWantsManager2 = rtcConnection.localMediaSinkWantsManager;
        if (mediaSinkWantsManager2 != null) {
            List listEmptyList = C12147n.emptyList();
            C12238m.checkNotNullParameter(listEmptyList, "ssrcs");
            mediaSinkWantsManager2.m8454b(new C1218l(mediaSinkWantsManager2, listEmptyList, j));
        }
    }

    @Override // p007b.p008a.p041q.p046n0.C1245a.d
    /* JADX INFO: renamed from: k */
    public void mo277k(int i, int i2, String str, List<Payloads.Stream> list) {
        MediaEngineConnection.Type type;
        C12238m.checkNotNullParameter(str, "ip");
        C12238m.checkNotNullParameter(list, "streams");
        RtcConnection rtcConnection = this.f1628a;
        Objects.requireNonNull(rtcConnection);
        rtcConnection.m8475r("Discovered dedicated UDP server on port " + i);
        rtcConnection.m8478u(RtcConnection.State.C5613g.f18815a);
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
        for (Iterator it = list.iterator(); it.hasNext(); it = it) {
            Payloads.Stream stream = (Payloads.Stream) it.next();
            MediaType mediaType = MediaStreamTrack.VIDEO_TRACK_KIND.equals(stream.getType()) ? MediaType.Video : MediaType.Audio;
            String rid = stream.getRid();
            if (rid == null) {
                rid = "";
            }
            String str2 = rid;
            Integer ssrc = stream.getSsrc();
            int iIntValue = ssrc != null ? ssrc.intValue() : 0;
            Integer rtxSsrc = stream.getRtxSsrc();
            int iIntValue2 = rtxSsrc != null ? rtxSsrc.intValue() : 0;
            Boolean active = stream.getActive();
            boolean zBooleanValue = active != null ? active.booleanValue() : false;
            Integer maxBitrate = stream.getMaxBitrate();
            int iIntValue3 = maxBitrate != null ? maxBitrate.intValue() : 0;
            Integer quality = stream.getQuality();
            arrayList.add(new StreamParameters(mediaType, str2, iIntValue, iIntValue2, zBooleanValue, iIntValue3, quality != null ? quality.intValue() : 100, 0));
        }
        boolean zIsEmpty = arrayList.isEmpty();
        List listListOf = arrayList;
        if (zIsEmpty) {
            listListOf = C12145m.listOf(new StreamParameters(MediaType.Video, "100", i2 + 1, i2 + 2, false, 0, 100, 0));
        }
        MediaEngine mediaEngine = rtcConnection.mediaEngine;
        long j = rtcConnection.userId;
        MediaEngine.C5640a c5640a = new MediaEngine.C5640a(i2, str, i, listListOf);
        RtcConnection.AbstractC5618d abstractC5618d = rtcConnection.rtcConnectionType;
        if (C12238m.areEqual(abstractC5618d, RtcConnection.AbstractC5618d.a.f18819a)) {
            type = MediaEngineConnection.Type.DEFAULT;
        } else {
            if (!(abstractC5618d instanceof RtcConnection.AbstractC5618d.b)) {
                throw new NoWhenBranchMatchedException();
            }
            type = MediaEngineConnection.Type.STREAM;
        }
        MediaEngineConnection mediaEngineConnectionMo327g = mediaEngine.mo327g(j, c5640a, type, new C1197e0(rtcConnection));
        if (mediaEngineConnectionMo327g == null) {
            RtcConnection.m8460o(rtcConnection, "onSocketHello(): connect() return null.", null, null, 6);
        } else {
            mediaEngineConnectionMo327g.mo306l(rtcConnection.mediaEngineConnectionListener);
            rtcConnection.mediaEngineConnection = mediaEngineConnectionMo327g;
        }
    }

    @Override // p007b.p008a.p041q.p046n0.C1245a.d
    public void onConnecting() {
        RtcConnection rtcConnection = this.f1628a;
        rtcConnection.reconnectBackoff.cancel();
        StringBuilder sb = new StringBuilder();
        sb.append("Connecting to RTC server ");
        C1245a c1245a = rtcConnection.socket;
        sb.append(c1245a != null ? c1245a.f1769D : null);
        rtcConnection.m8475r(sb.toString());
        rtcConnection.m8478u(RtcConnection.State.C5609c.f18811a);
    }

    @Override // p007b.p008a.p041q.p046n0.C1245a.d
    public void onSpeaking(long j, int i, boolean z2) {
        RtcConnection rtcConnection = this.f1628a;
        if (j != rtcConnection.userId) {
            MediaEngineConnection mediaEngineConnection = rtcConnection.mediaEngineConnection;
            if (mediaEngineConnection != null) {
                mediaEngineConnection.mo313s(j, i, null, rtcConnection.m8466g(j), rtcConnection.m8467h(j));
            }
            MediaSinkWantsManager mediaSinkWantsManager = rtcConnection.localMediaSinkWantsManager;
            if (mediaSinkWantsManager != null) {
                mediaSinkWantsManager.m8455c(j, Long.valueOf(i));
            }
            Iterator<T> it = rtcConnection.listeners.iterator();
            while (it.hasNext()) {
                ((RtcConnection.InterfaceC5617c) it.next()).onUserCreated(rtcConnection, j);
            }
        }
    }
}
