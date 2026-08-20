package com.discord.rtcconnection;

import co.discord.media_engine.StreamParameters;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.utilities.logging.Logger;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Future;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p041q.C1196e;
import p007b.p008a.p041q.C1202h;
import p007b.p008a.p041q.ExecutorServiceC1192c;
import p007b.p008a.p041q.RunnableC1220m;
import p007b.p008a.p041q.p044m0.C1221a;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: MediaSinkWantsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSinkWantsManager implements MediaEngineConnection.InterfaceC5648d {

    /* JADX INFO: renamed from: a */
    public final Map<Long, Long> f18742a;

    /* JADX INFO: renamed from: b */
    public final Map<Long, List<C5603b>> f18743b;

    /* JADX INFO: renamed from: c */
    public final Set<Long> f18744c;

    /* JADX INFO: renamed from: d */
    public MediaEngineConnection f18745d;

    /* JADX INFO: renamed from: e */
    public Long f18746e;

    /* JADX INFO: renamed from: f */
    public final BehaviorSubject<Map<String, EncodeQuality>> f18747f;

    /* JADX INFO: renamed from: g */
    public Map<String, ? extends EncodeQuality> f18748g;

    /* JADX INFO: renamed from: h */
    public final long f18749h;

    /* JADX INFO: renamed from: i */
    public final ExecutorServiceC1192c f18750i;

    /* JADX INFO: renamed from: j */
    public final C1196e f18751j;

    /* JADX INFO: renamed from: k */
    public final Logger f18752k;

    /* JADX INFO: renamed from: l */
    public final InterfaceC5602a f18753l;

    /* JADX INFO: compiled from: MediaSinkWantsManager.kt */
    public enum VideoQualityMode {
        AUTO(1),
        FULL(2);


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int numeral;

        /* JADX INFO: renamed from: com.discord.rtcconnection.MediaSinkWantsManager$VideoQualityMode$a, reason: from kotlin metadata */
        /* JADX INFO: compiled from: MediaSinkWantsManager.kt */
        public static final class Companion {
            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }

            /* JADX INFO: renamed from: a */
            public final VideoQualityMode m8457a(Integer num) {
                if (num != null && num.intValue() == 1) {
                    return VideoQualityMode.AUTO;
                }
                return (num != null && num.intValue() == 2) ? VideoQualityMode.FULL : VideoQualityMode.AUTO;
            }
        }

        VideoQualityMode(int i) {
            this.numeral = i;
        }

        public final int getNumeral() {
            return this.numeral;
        }
    }

    /* JADX INFO: renamed from: com.discord.rtcconnection.MediaSinkWantsManager$a */
    /* JADX INFO: compiled from: MediaSinkWantsManager.kt */
    public interface InterfaceC5602a {
        /* JADX INFO: renamed from: a */
        void mo8458a(long j, long j2, long j3, VideoMetadata videoMetadata);
    }

    /* JADX INFO: renamed from: com.discord.rtcconnection.MediaSinkWantsManager$b */
    /* JADX INFO: compiled from: MediaSinkWantsManager.kt */
    public static final class C5603b {

        /* JADX INFO: renamed from: a */
        public final EncodeQuality f18754a;

        /* JADX INFO: renamed from: b */
        public final long f18755b;

        /* JADX INFO: renamed from: c */
        public final VideoMetadata f18756c;

        public C5603b(EncodeQuality encodeQuality, long j, VideoMetadata videoMetadata) {
            C12238m.checkNotNullParameter(encodeQuality, "encodeQuality");
            this.f18754a = encodeQuality;
            this.f18755b = j;
            this.f18756c = videoMetadata;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C5603b)) {
                return false;
            }
            C5603b c5603b = (C5603b) obj;
            return C12238m.areEqual(this.f18754a, c5603b.f18754a) && this.f18755b == c5603b.f18755b && C12238m.areEqual(this.f18756c, c5603b.f18756c);
        }

        public int hashCode() {
            EncodeQuality encodeQuality = this.f18754a;
            int iM3a = (C0002b.m3a(this.f18755b) + ((encodeQuality != null ? encodeQuality.hashCode() : 0) * 31)) * 31;
            VideoMetadata videoMetadata = this.f18756c;
            return iM3a + (videoMetadata != null ? videoMetadata.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("VideoStreamDescriptor(encodeQuality=");
            sbM833U.append(this.f18754a);
            sbM833U.append(", ssrc=");
            sbM833U.append(this.f18755b);
            sbM833U.append(", metadata=");
            sbM833U.append(this.f18756c);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.rtcconnection.MediaSinkWantsManager$c */
    /* JADX INFO: compiled from: MediaSinkWantsManager.kt */
    public static final class C5604c extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ Long $ssrc;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C5604c(Long l, long j) {
            super(0);
            this.$ssrc = l;
            this.$userId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (this.$ssrc != null) {
                MediaSinkWantsManager.this.f18742a.put(Long.valueOf(this.$userId), this.$ssrc);
            } else {
                MediaSinkWantsManager.this.f18742a.remove(Long.valueOf(this.$userId));
            }
            MediaSinkWantsManager.m8452e(MediaSinkWantsManager.this, null, 1);
            return Unit.f27425a;
        }
    }

    public MediaSinkWantsManager(long j, ExecutorServiceC1192c executorServiceC1192c, C1196e c1196e, Logger logger, InterfaceC5602a interfaceC5602a) {
        C12238m.checkNotNullParameter(executorServiceC1192c, "mediaEngineThreadExecutor");
        C12238m.checkNotNullParameter(c1196e, "ladder");
        C12238m.checkNotNullParameter(logger, "logger");
        C12238m.checkNotNullParameter(interfaceC5602a, "listener");
        this.f18749h = j;
        this.f18750i = executorServiceC1192c;
        this.f18751j = c1196e;
        this.f18752k = logger;
        this.f18753l = interfaceC5602a;
        this.f18742a = new LinkedHashMap();
        this.f18743b = new LinkedHashMap();
        new LinkedHashMap();
        this.f18744c = new LinkedHashSet();
        this.f18747f = BehaviorSubject.m11130l0(C12134g0.mapOf(C12116o.m10073to("any", EncodeQuality.Hundred)));
        this.f18748g = C12136h0.emptyMap();
    }

    /* JADX INFO: renamed from: e */
    public static /* synthetic */ void m8452e(MediaSinkWantsManager mediaSinkWantsManager, List list, int i) {
        mediaSinkWantsManager.m8456d((i & 1) != 0 ? C12147n.emptyList() : null);
    }

    /* JADX INFO: renamed from: a */
    public final void m8453a(String str) {
        Logger.w$default(this.f18752k, "MediaSinkWantsManager", str, null, 4, null);
    }

    /* JADX INFO: renamed from: b */
    public final Future<?> m8454b(Function0<Unit> function0) {
        ExecutorServiceC1192c executorServiceC1192c = this.f18750i;
        return executorServiceC1192c.f1609l.submit(new RunnableC1220m(function0));
    }

    /* JADX INFO: renamed from: c */
    public final Future<?> m8455c(long j, Long l) {
        return m8454b(new C5604c(l, j));
    }

    /* JADX WARN: Code duplicated, block: B:147:0x0173 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:148:0x0167 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:19:0x003d  */
    /* JADX WARN: Code duplicated, block: B:80:0x014a  */
    /* JADX WARN: Code duplicated, block: B:82:0x0151  */
    /* JADX WARN: Code duplicated, block: B:85:0x015b  */
    /* JADX INFO: renamed from: d */
    public final void m8456d(List<String> list) {
        int i;
        C1196e.c cVarPrevious;
        EncodeQuality encodeQuality;
        long j;
        EncodeQuality encodeQuality2;
        MediaEngineConnection mediaEngineConnection = this.f18745d;
        if (mediaEngineConnection != null) {
            C1196e c1196e = this.f18751j;
            int i2 = 1;
            if (mediaEngineConnection != null) {
                Set<Long> set = this.f18744c;
                if ((set instanceof Collection) && set.isEmpty()) {
                    i = 0;
                } else {
                    Iterator<T> it = set.iterator();
                    i = 0;
                    while (it.hasNext()) {
                        if ((!mediaEngineConnection.mo301g(((Number) it.next()).longValue())) && (i = i + 1) < 0) {
                            C12147n.throwCountOverflow();
                        }
                    }
                }
            } else {
                i = 0;
            }
            Objects.requireNonNull(c1196e);
            if (i < 0) {
                encodeQuality = EncodeQuality.Hundred;
            } else {
                List<C1196e.c> list2 = c1196e.f1616d;
                ListIterator<C1196e.c> listIterator = list2.listIterator(list2.size());
                do {
                    if (!listIterator.hasPrevious()) {
                        cVarPrevious = null;
                        break;
                    }
                    cVarPrevious = listIterator.previous();
                } while (!(cVarPrevious.f1623b * i <= c1196e.f1614b));
                C1196e.c cVar = cVarPrevious;
                if (cVar == null) {
                    cVar = (C1196e.c) C12163u.first((List) c1196e.f1616d);
                }
                encodeQuality = cVar.f1624c;
            }
            Map<String, EncodeQuality> mapMutableMapOf = C12136h0.mutableMapOf(C12116o.m10073to("any", encodeQuality));
            Iterator<Map.Entry<Long, List<C5603b>>> it2 = this.f18743b.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<Long, List<C5603b>> next = it2.next();
                long jLongValue = next.getKey().longValue();
                List<C5603b> value = next.getValue();
                C5603b c5603b = (C5603b) C12163u.firstOrNull((List) value);
                if (c5603b != null) {
                    Long l = this.f18746e;
                    if (l != null) {
                        long j2 = this.f18749h;
                        if (l != null && l.longValue() == j2) {
                            if (value.size() > 1) {
                                for (C5603b c5603b2 : value) {
                                    if (c5603b2.f18754a == EncodeQuality.Hundred) {
                                        mapMutableMapOf.put(String.valueOf(c5603b2.f18755b), EncodeQuality.Zero);
                                    } else {
                                        c5603b = c5603b2;
                                    }
                                }
                            }
                        } else if (value.size() > i2) {
                            Long l2 = this.f18746e;
                            if (l2 != null && jLongValue == l2.longValue()) {
                                for (C5603b c5603b3 : value) {
                                    EncodeQuality encodeQuality3 = c5603b3.f18754a;
                                    EncodeQuality encodeQuality4 = EncodeQuality.Hundred;
                                    if (encodeQuality3 == encodeQuality4) {
                                        mapMutableMapOf.put(String.valueOf(c5603b3.f18755b), encodeQuality4);
                                        c5603b = c5603b3;
                                    } else {
                                        mapMutableMapOf.put(String.valueOf(c5603b3.f18755b), EncodeQuality.Zero);
                                    }
                                }
                            } else {
                                for (C5603b c5603b4 : value) {
                                    if (c5603b4.f18754a == EncodeQuality.Hundred) {
                                        mapMutableMapOf.put(String.valueOf(c5603b4.f18755b), EncodeQuality.Zero);
                                    } else {
                                        c5603b = c5603b4;
                                    }
                                }
                            }
                        } else {
                            Long l3 = this.f18746e;
                            if (l3 != null && jLongValue == l3.longValue() && encodeQuality != (encodeQuality2 = EncodeQuality.Hundred)) {
                                mapMutableMapOf.put(String.valueOf(c5603b.f18755b), encodeQuality2);
                            }
                        }
                    } else if (value.size() > 1) {
                        while (r3.hasNext()) {
                            if (c5603b2.f18754a == EncodeQuality.Hundred) {
                                mapMutableMapOf.put(String.valueOf(c5603b2.f18755b), EncodeQuality.Zero);
                            } else {
                                c5603b = c5603b2;
                            }
                        }
                    }
                    if (mediaEngineConnection.mo301g(jLongValue) || mediaEngineConnection.mo310p(jLongValue)) {
                        Iterator<C5603b> it3 = value.iterator();
                        while (it3.hasNext()) {
                            mapMutableMapOf.put(String.valueOf(it3.next().f18755b), EncodeQuality.Zero);
                        }
                    }
                    if (list.contains(String.valueOf(jLongValue))) {
                        Long l4 = this.f18742a.get(Long.valueOf(jLongValue));
                        if (l4 != null) {
                            j = jLongValue;
                            this.f18753l.mo8458a(jLongValue, l4.longValue(), c5603b.f18755b, c5603b.f18756c);
                        } else {
                            j = jLongValue;
                            m8453a("Missing audioSsrc for user " + j + ", can't update video ssrc!");
                        }
                    } else {
                        j = jLongValue;
                    }
                    EncodeQuality encodeQuality5 = this.f18748g.get(String.valueOf(c5603b.f18755b));
                    EncodeQuality encodeQuality6 = EncodeQuality.Zero;
                    if (encodeQuality5 == encodeQuality6 && mapMutableMapOf.get(String.valueOf(c5603b.f18755b)) != encodeQuality6) {
                        mediaEngineConnection.mo303i(j, false);
                    }
                    if (encodeQuality5 != encodeQuality6 && mapMutableMapOf.get(String.valueOf(c5603b.f18755b)) == encodeQuality6) {
                        mediaEngineConnection.mo303i(j, true);
                    }
                    it2 = it2;
                }
                i2 = 1;
            }
            for (Map.Entry<Long, Long> entry : this.f18742a.entrySet()) {
                long jLongValue2 = entry.getKey().longValue();
                long jLongValue3 = entry.getValue().longValue();
                if (mediaEngineConnection.mo315u(jLongValue2)) {
                    mapMutableMapOf.put(String.valueOf(jLongValue3), EncodeQuality.Zero);
                }
            }
            this.f18748g = mapMutableMapOf;
            this.f18747f.onNext(mapMutableMapOf);
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onConnected(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.TransportInfo transportInfo, List<C1221a> list) {
        C12238m.checkNotNullParameter(mediaEngineConnection, "connection");
        C12238m.checkNotNullParameter(transportInfo, "transportInfo");
        C12238m.checkNotNullParameter(list, "supportedVideoCodecs");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onConnectionStateChange(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.ConnectionState connectionState) {
        C12238m.checkNotNullParameter(mediaEngineConnection, "connection");
        C12238m.checkNotNullParameter(connectionState, "connectionState");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onDestroy(MediaEngineConnection mediaEngineConnection) {
        C12238m.checkNotNullParameter(mediaEngineConnection, "connection");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onError(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.FailedConnectionException failedConnectionException) {
        C12238m.checkNotNullParameter(mediaEngineConnection, "connection");
        C12238m.checkNotNullParameter(failedConnectionException, "exception");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onKrispStatus(MediaEngineConnection mediaEngineConnection, KrispOveruseDetector.Status status) {
        C12238m.checkNotNullParameter(mediaEngineConnection, "connection");
        C12238m.checkNotNullParameter(status, "status");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onLocalMute(long j, boolean z2) {
        m8454b(new C1202h(this));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onLocalVideoOffScreen(long j, boolean z2) {
        m8454b(new C1202h(this));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onSpeaking(long j, int i, boolean z2) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onTargetBitrate(int i) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onTargetFrameRate(int i) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onVideo(long j, Integer num, int i, int i2, int i3, StreamParameters[] streamParametersArr) {
        C12238m.checkNotNullParameter(streamParametersArr, "streams");
    }
}
