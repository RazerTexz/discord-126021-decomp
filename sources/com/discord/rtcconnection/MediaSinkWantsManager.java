package com.discord.rtcconnection;

import b.a.q.c;
import b.a.q.e;
import b.a.q.e$c;
import b.a.q.h;
import b.a.q.m0.a;
import co.discord.media_engine.StreamParameters;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$ConnectionState;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$FailedConnectionException;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$TransportInfo;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$d;
import com.discord.utilities.logging.Logger;
import d0.o;
import d0.t.g0;
import d0.t.h0;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Future;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: MediaSinkWantsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSinkWantsManager implements MediaEngineConnection$d {
    public final Map<Long, Long> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Long, List<MediaSinkWantsManager$b>> f2771b;
    public final Set<Long> c;
    public MediaEngineConnection d;
    public Long e;
    public final BehaviorSubject<Map<String, EncodeQuality>> f;
    public Map<String, ? extends EncodeQuality> g;
    public final long h;
    public final c i;
    public final e j;
    public final Logger k;
    public final MediaSinkWantsManager$a l;

    public MediaSinkWantsManager(long j, c cVar, e eVar, Logger logger, MediaSinkWantsManager$a mediaSinkWantsManager$a) {
        m.checkNotNullParameter(cVar, "mediaEngineThreadExecutor");
        m.checkNotNullParameter(eVar, "ladder");
        m.checkNotNullParameter(logger, "logger");
        m.checkNotNullParameter(mediaSinkWantsManager$a, "listener");
        this.h = j;
        this.i = cVar;
        this.j = eVar;
        this.k = logger;
        this.l = mediaSinkWantsManager$a;
        this.a = new LinkedHashMap();
        this.f2771b = new LinkedHashMap();
        new LinkedHashMap();
        this.c = new LinkedHashSet();
        this.f = BehaviorSubject.l0(g0.mapOf(o.to("any", EncodeQuality.Hundred)));
        this.g = h0.emptyMap();
    }

    public static /* synthetic */ void e(MediaSinkWantsManager mediaSinkWantsManager, List list, int i) {
        mediaSinkWantsManager.d((i & 1) != 0 ? n.emptyList() : null);
    }

    public final void a(String str) {
        Logger.w$default(this.k, "MediaSinkWantsManager", str, null, 4, null);
    }

    public final Future<?> b(Function0<Unit> function0) {
        c cVar = this.i;
        return cVar.l.submit(new b.a.q.m(function0));
    }

    public final Future<?> c(long j, Long l) {
        return b(new MediaSinkWantsManager$c(this, l, j));
    }

    /* JADX WARN: Code duplicated, block: B:147:0x0173 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:148:0x0167 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:19:0x003d  */
    /* JADX WARN: Code duplicated, block: B:80:0x014a  */
    /* JADX WARN: Code duplicated, block: B:82:0x0151  */
    /* JADX WARN: Code duplicated, block: B:85:0x015b  */
    public final void d(List<String> list) {
        int i;
        e$c e_cPrevious;
        EncodeQuality encodeQuality;
        long j;
        EncodeQuality encodeQuality2;
        MediaEngineConnection mediaEngineConnection = this.d;
        if (mediaEngineConnection != null) {
            e eVar = this.j;
            int i2 = 1;
            if (mediaEngineConnection != null) {
                Set<Long> set = this.c;
                if ((set instanceof Collection) && set.isEmpty()) {
                    i = 0;
                } else {
                    Iterator<T> it = set.iterator();
                    i = 0;
                    while (it.hasNext()) {
                        if ((!mediaEngineConnection.g(((Number) it.next()).longValue())) && (i = i + 1) < 0) {
                            n.throwCountOverflow();
                        }
                    }
                }
            } else {
                i = 0;
            }
            Objects.requireNonNull(eVar);
            if (i < 0) {
                encodeQuality = EncodeQuality.Hundred;
            } else {
                List<e$c> list2 = eVar.d;
                ListIterator<e$c> listIterator = list2.listIterator(list2.size());
                do {
                    if (!listIterator.hasPrevious()) {
                        e_cPrevious = null;
                        break;
                    }
                    e_cPrevious = listIterator.previous();
                } while (!(e_cPrevious.f259b * i <= eVar.f257b));
                e$c e_c = e_cPrevious;
                if (e_c == null) {
                    e_c = (e$c) u.first((List) eVar.d);
                }
                encodeQuality = e_c.c;
            }
            Map<String, EncodeQuality> mapMutableMapOf = h0.mutableMapOf(o.to("any", encodeQuality));
            Iterator<Map$Entry<Long, List<MediaSinkWantsManager$b>>> it2 = this.f2771b.entrySet().iterator();
            while (it2.hasNext()) {
                Map$Entry<Long, List<MediaSinkWantsManager$b>> next = it2.next();
                long jLongValue = next.getKey().longValue();
                List<MediaSinkWantsManager$b> value = next.getValue();
                MediaSinkWantsManager$b mediaSinkWantsManager$b = (MediaSinkWantsManager$b) u.firstOrNull((List) value);
                if (mediaSinkWantsManager$b != null) {
                    Long l = this.e;
                    if (l != null) {
                        long j2 = this.h;
                        if (l != null && l.longValue() == j2) {
                            if (value.size() > 1) {
                                for (MediaSinkWantsManager$b mediaSinkWantsManager$b2 : value) {
                                    if (mediaSinkWantsManager$b2.a == EncodeQuality.Hundred) {
                                        mapMutableMapOf.put(String.valueOf(mediaSinkWantsManager$b2.f2772b), EncodeQuality.Zero);
                                    } else {
                                        mediaSinkWantsManager$b = mediaSinkWantsManager$b2;
                                    }
                                }
                            }
                        } else if (value.size() > i2) {
                            Long l2 = this.e;
                            if (l2 != null && jLongValue == l2.longValue()) {
                                for (MediaSinkWantsManager$b mediaSinkWantsManager$b3 : value) {
                                    EncodeQuality encodeQuality3 = mediaSinkWantsManager$b3.a;
                                    EncodeQuality encodeQuality4 = EncodeQuality.Hundred;
                                    if (encodeQuality3 == encodeQuality4) {
                                        mapMutableMapOf.put(String.valueOf(mediaSinkWantsManager$b3.f2772b), encodeQuality4);
                                        mediaSinkWantsManager$b = mediaSinkWantsManager$b3;
                                    } else {
                                        mapMutableMapOf.put(String.valueOf(mediaSinkWantsManager$b3.f2772b), EncodeQuality.Zero);
                                    }
                                }
                            } else {
                                for (MediaSinkWantsManager$b mediaSinkWantsManager$b4 : value) {
                                    if (mediaSinkWantsManager$b4.a == EncodeQuality.Hundred) {
                                        mapMutableMapOf.put(String.valueOf(mediaSinkWantsManager$b4.f2772b), EncodeQuality.Zero);
                                    } else {
                                        mediaSinkWantsManager$b = mediaSinkWantsManager$b4;
                                    }
                                }
                            }
                        } else {
                            Long l3 = this.e;
                            if (l3 != null && jLongValue == l3.longValue() && encodeQuality != (encodeQuality2 = EncodeQuality.Hundred)) {
                                mapMutableMapOf.put(String.valueOf(mediaSinkWantsManager$b.f2772b), encodeQuality2);
                            }
                        }
                    } else if (value.size() > 1) {
                        while (r3.hasNext()) {
                            if (mediaSinkWantsManager$b2.a == EncodeQuality.Hundred) {
                                mapMutableMapOf.put(String.valueOf(mediaSinkWantsManager$b2.f2772b), EncodeQuality.Zero);
                            } else {
                                mediaSinkWantsManager$b = mediaSinkWantsManager$b2;
                            }
                        }
                    }
                    if (mediaEngineConnection.g(jLongValue) || mediaEngineConnection.p(jLongValue)) {
                        Iterator<MediaSinkWantsManager$b> it3 = value.iterator();
                        while (it3.hasNext()) {
                            mapMutableMapOf.put(String.valueOf(it3.next().f2772b), EncodeQuality.Zero);
                        }
                    }
                    if (list.contains(String.valueOf(jLongValue))) {
                        Long l4 = this.a.get(Long.valueOf(jLongValue));
                        if (l4 != null) {
                            j = jLongValue;
                            this.l.a(jLongValue, l4.longValue(), mediaSinkWantsManager$b.f2772b, mediaSinkWantsManager$b.c);
                        } else {
                            j = jLongValue;
                            a("Missing audioSsrc for user " + j + ", can't update video ssrc!");
                        }
                    } else {
                        j = jLongValue;
                    }
                    EncodeQuality encodeQuality5 = this.g.get(String.valueOf(mediaSinkWantsManager$b.f2772b));
                    EncodeQuality encodeQuality6 = EncodeQuality.Zero;
                    if (encodeQuality5 == encodeQuality6 && mapMutableMapOf.get(String.valueOf(mediaSinkWantsManager$b.f2772b)) != encodeQuality6) {
                        mediaEngineConnection.i(j, false);
                    }
                    if (encodeQuality5 != encodeQuality6 && mapMutableMapOf.get(String.valueOf(mediaSinkWantsManager$b.f2772b)) == encodeQuality6) {
                        mediaEngineConnection.i(j, true);
                    }
                    it2 = it2;
                }
                i2 = 1;
            }
            for (Map$Entry<Long, Long> map$Entry : this.a.entrySet()) {
                long jLongValue2 = map$Entry.getKey().longValue();
                long jLongValue3 = map$Entry.getValue().longValue();
                if (mediaEngineConnection.u(jLongValue2)) {
                    mapMutableMapOf.put(String.valueOf(jLongValue3), EncodeQuality.Zero);
                }
            }
            this.g = mapMutableMapOf;
            this.f.onNext(mapMutableMapOf);
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onConnected(MediaEngineConnection mediaEngineConnection, MediaEngineConnection$TransportInfo mediaEngineConnection$TransportInfo, List<a> list) {
        m.checkNotNullParameter(mediaEngineConnection, "connection");
        m.checkNotNullParameter(mediaEngineConnection$TransportInfo, "transportInfo");
        m.checkNotNullParameter(list, "supportedVideoCodecs");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onConnectionStateChange(MediaEngineConnection mediaEngineConnection, MediaEngineConnection$ConnectionState mediaEngineConnection$ConnectionState) {
        m.checkNotNullParameter(mediaEngineConnection, "connection");
        m.checkNotNullParameter(mediaEngineConnection$ConnectionState, "connectionState");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onDestroy(MediaEngineConnection mediaEngineConnection) {
        m.checkNotNullParameter(mediaEngineConnection, "connection");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onError(MediaEngineConnection mediaEngineConnection, MediaEngineConnection$FailedConnectionException mediaEngineConnection$FailedConnectionException) {
        m.checkNotNullParameter(mediaEngineConnection, "connection");
        m.checkNotNullParameter(mediaEngineConnection$FailedConnectionException, "exception");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onKrispStatus(MediaEngineConnection mediaEngineConnection, KrispOveruseDetector$Status krispOveruseDetector$Status) {
        m.checkNotNullParameter(mediaEngineConnection, "connection");
        m.checkNotNullParameter(krispOveruseDetector$Status, "status");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onLocalMute(long j, boolean z2) {
        b(new h(this));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onLocalVideoOffScreen(long j, boolean z2) {
        b(new h(this));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onSpeaking(long j, int i, boolean z2) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onTargetBitrate(int i) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onTargetFrameRate(int i) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onVideo(long j, Integer num, int i, int i2, int i3, StreamParameters[] streamParametersArr) {
        m.checkNotNullParameter(streamParametersArr, "streams");
    }
}
