package com.discord.rtcconnection;

import b.a.q.MediaEngineExecutorService;
import b.a.q.MediaSinkWantsLadder3;
import b.a.q.MediaSinkWantsManager3;
import b.a.q.MediaSinkWantsManager8;
import b.a.q.m0.Codec2;
import b.d.b.a.outline;
import co.discord.media_engine.StreamParameters;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.utilities.logging.Logger;
import d0.Tuples;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
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
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: MediaSinkWantsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSinkWantsManager implements MediaEngineConnection.d {
    public final Map<Long, Long> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Long, List<b>> f2771b;
    public final Set<Long> c;
    public MediaEngineConnection d;
    public Long e;
    public final BehaviorSubject<Map<String, MediaSinkWantsManager9>> f;
    public Map<String, ? extends MediaSinkWantsManager9> g;
    public final long h;
    public final MediaEngineExecutorService i;
    public final MediaSinkWantsLadder3 j;
    public final Logger k;
    public final a l;

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

            public final VideoQualityMode a(Integer num) {
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

    /* JADX INFO: compiled from: MediaSinkWantsManager.kt */
    public interface a {
        void a(long j, long j2, long j3, VideoMetadata videoMetadata);
    }

    /* JADX INFO: compiled from: MediaSinkWantsManager.kt */
    public static final class b {
        public final MediaSinkWantsManager9 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f2772b;
        public final VideoMetadata c;

        public b(MediaSinkWantsManager9 mediaSinkWantsManager9, long j, VideoMetadata videoMetadata) {
            Intrinsics3.checkNotNullParameter(mediaSinkWantsManager9, "encodeQuality");
            this.a = mediaSinkWantsManager9;
            this.f2772b = j;
            this.c = videoMetadata;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics3.areEqual(this.a, bVar.a) && this.f2772b == bVar.f2772b && Intrinsics3.areEqual(this.c, bVar.c);
        }

        public int hashCode() {
            MediaSinkWantsManager9 mediaSinkWantsManager9 = this.a;
            int iA = (a0.a.a.b.a(this.f2772b) + ((mediaSinkWantsManager9 != null ? mediaSinkWantsManager9.hashCode() : 0) * 31)) * 31;
            VideoMetadata videoMetadata = this.c;
            return iA + (videoMetadata != null ? videoMetadata.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("VideoStreamDescriptor(encodeQuality=");
            sbU.append(this.a);
            sbU.append(", ssrc=");
            sbU.append(this.f2772b);
            sbU.append(", metadata=");
            sbU.append(this.c);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: MediaSinkWantsManager.kt */
    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Long $ssrc;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Long l, long j) {
            super(0);
            this.$ssrc = l;
            this.$userId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (this.$ssrc != null) {
                MediaSinkWantsManager.this.a.put(Long.valueOf(this.$userId), this.$ssrc);
            } else {
                MediaSinkWantsManager.this.a.remove(Long.valueOf(this.$userId));
            }
            MediaSinkWantsManager.e(MediaSinkWantsManager.this, null, 1);
            return Unit.a;
        }
    }

    public MediaSinkWantsManager(long j, MediaEngineExecutorService mediaEngineExecutorService, MediaSinkWantsLadder3 mediaSinkWantsLadder3, Logger logger, a aVar) {
        Intrinsics3.checkNotNullParameter(mediaEngineExecutorService, "mediaEngineThreadExecutor");
        Intrinsics3.checkNotNullParameter(mediaSinkWantsLadder3, "ladder");
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(aVar, "listener");
        this.h = j;
        this.i = mediaEngineExecutorService;
        this.j = mediaSinkWantsLadder3;
        this.k = logger;
        this.l = aVar;
        this.a = new LinkedHashMap();
        this.f2771b = new LinkedHashMap();
        new LinkedHashMap();
        this.c = new LinkedHashSet();
        this.f = BehaviorSubject.l0(MapsJVM.mapOf(Tuples.to("any", MediaSinkWantsManager9.Hundred)));
        this.g = Maps6.emptyMap();
    }

    public static /* synthetic */ void e(MediaSinkWantsManager mediaSinkWantsManager, List list, int i) {
        mediaSinkWantsManager.d((i & 1) != 0 ? Collections2.emptyList() : null);
    }

    public final void a(String str) {
        Logger.w$default(this.k, "MediaSinkWantsManager", str, null, 4, null);
    }

    public final Future<?> b(Function0<Unit> function0) {
        MediaEngineExecutorService mediaEngineExecutorService = this.i;
        return mediaEngineExecutorService.l.submit(new MediaSinkWantsManager8(function0));
    }

    public final Future<?> c(long j, Long l) {
        return b(new c(l, j));
    }

    /* JADX WARN: Code duplicated, block: B:147:0x0173 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:148:0x0167 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:19:0x003d  */
    /* JADX WARN: Code duplicated, block: B:80:0x014a  */
    /* JADX WARN: Code duplicated, block: B:82:0x0151  */
    /* JADX WARN: Code duplicated, block: B:85:0x015b  */
    public final void d(List<String> list) {
        int i;
        MediaSinkWantsLadder3.c cVarPrevious;
        MediaSinkWantsManager9 mediaSinkWantsManager9;
        long j;
        MediaSinkWantsManager9 mediaSinkWantsManager10;
        MediaEngineConnection mediaEngineConnection = this.d;
        if (mediaEngineConnection != null) {
            MediaSinkWantsLadder3 mediaSinkWantsLadder3 = this.j;
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
                            Collections2.throwCountOverflow();
                        }
                    }
                }
            } else {
                i = 0;
            }
            Objects.requireNonNull(mediaSinkWantsLadder3);
            if (i < 0) {
                mediaSinkWantsManager9 = MediaSinkWantsManager9.Hundred;
            } else {
                List<MediaSinkWantsLadder3.c> list2 = mediaSinkWantsLadder3.d;
                ListIterator<MediaSinkWantsLadder3.c> listIterator = list2.listIterator(list2.size());
                do {
                    if (!listIterator.hasPrevious()) {
                        cVarPrevious = null;
                        break;
                    }
                    cVarPrevious = listIterator.previous();
                } while (!(cVarPrevious.f259b * i <= mediaSinkWantsLadder3.f257b));
                MediaSinkWantsLadder3.c cVar = cVarPrevious;
                if (cVar == null) {
                    cVar = (MediaSinkWantsLadder3.c) _Collections.first((List) mediaSinkWantsLadder3.d);
                }
                mediaSinkWantsManager9 = cVar.c;
            }
            Map<String, MediaSinkWantsManager9> mapMutableMapOf = Maps6.mutableMapOf(Tuples.to("any", mediaSinkWantsManager9));
            Iterator<Map.Entry<Long, List<b>>> it2 = this.f2771b.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<Long, List<b>> next = it2.next();
                long jLongValue = next.getKey().longValue();
                List<b> value = next.getValue();
                b bVar = (b) _Collections.firstOrNull((List) value);
                if (bVar != null) {
                    Long l = this.e;
                    if (l != null) {
                        long j2 = this.h;
                        if (l != null && l.longValue() == j2) {
                            if (value.size() > 1) {
                                for (b bVar2 : value) {
                                    if (bVar2.a == MediaSinkWantsManager9.Hundred) {
                                        mapMutableMapOf.put(String.valueOf(bVar2.f2772b), MediaSinkWantsManager9.Zero);
                                    } else {
                                        bVar = bVar2;
                                    }
                                }
                            }
                        } else if (value.size() > i2) {
                            Long l2 = this.e;
                            if (l2 != null && jLongValue == l2.longValue()) {
                                for (b bVar3 : value) {
                                    MediaSinkWantsManager9 mediaSinkWantsManager11 = bVar3.a;
                                    MediaSinkWantsManager9 mediaSinkWantsManager12 = MediaSinkWantsManager9.Hundred;
                                    if (mediaSinkWantsManager11 == mediaSinkWantsManager12) {
                                        mapMutableMapOf.put(String.valueOf(bVar3.f2772b), mediaSinkWantsManager12);
                                        bVar = bVar3;
                                    } else {
                                        mapMutableMapOf.put(String.valueOf(bVar3.f2772b), MediaSinkWantsManager9.Zero);
                                    }
                                }
                            } else {
                                for (b bVar4 : value) {
                                    if (bVar4.a == MediaSinkWantsManager9.Hundred) {
                                        mapMutableMapOf.put(String.valueOf(bVar4.f2772b), MediaSinkWantsManager9.Zero);
                                    } else {
                                        bVar = bVar4;
                                    }
                                }
                            }
                        } else {
                            Long l3 = this.e;
                            if (l3 != null && jLongValue == l3.longValue() && mediaSinkWantsManager9 != (mediaSinkWantsManager10 = MediaSinkWantsManager9.Hundred)) {
                                mapMutableMapOf.put(String.valueOf(bVar.f2772b), mediaSinkWantsManager10);
                            }
                        }
                    } else if (value.size() > 1) {
                        while (r3.hasNext()) {
                            if (bVar2.a == MediaSinkWantsManager9.Hundred) {
                                mapMutableMapOf.put(String.valueOf(bVar2.f2772b), MediaSinkWantsManager9.Zero);
                            } else {
                                bVar = bVar2;
                            }
                        }
                    }
                    if (mediaEngineConnection.g(jLongValue) || mediaEngineConnection.p(jLongValue)) {
                        Iterator<b> it3 = value.iterator();
                        while (it3.hasNext()) {
                            mapMutableMapOf.put(String.valueOf(it3.next().f2772b), MediaSinkWantsManager9.Zero);
                        }
                    }
                    if (list.contains(String.valueOf(jLongValue))) {
                        Long l4 = this.a.get(Long.valueOf(jLongValue));
                        if (l4 != null) {
                            j = jLongValue;
                            this.l.a(jLongValue, l4.longValue(), bVar.f2772b, bVar.c);
                        } else {
                            j = jLongValue;
                            a("Missing audioSsrc for user " + j + ", can't update video ssrc!");
                        }
                    } else {
                        j = jLongValue;
                    }
                    MediaSinkWantsManager9 mediaSinkWantsManager13 = this.g.get(String.valueOf(bVar.f2772b));
                    MediaSinkWantsManager9 mediaSinkWantsManager14 = MediaSinkWantsManager9.Zero;
                    if (mediaSinkWantsManager13 == mediaSinkWantsManager14 && mapMutableMapOf.get(String.valueOf(bVar.f2772b)) != mediaSinkWantsManager14) {
                        mediaEngineConnection.i(j, false);
                    }
                    if (mediaSinkWantsManager13 != mediaSinkWantsManager14 && mapMutableMapOf.get(String.valueOf(bVar.f2772b)) == mediaSinkWantsManager14) {
                        mediaEngineConnection.i(j, true);
                    }
                    it2 = it2;
                }
                i2 = 1;
            }
            for (Map.Entry<Long, Long> entry : this.a.entrySet()) {
                long jLongValue2 = entry.getKey().longValue();
                long jLongValue3 = entry.getValue().longValue();
                if (mediaEngineConnection.u(jLongValue2)) {
                    mapMutableMapOf.put(String.valueOf(jLongValue3), MediaSinkWantsManager9.Zero);
                }
            }
            this.g = mapMutableMapOf;
            this.f.onNext(mapMutableMapOf);
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onConnected(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.TransportInfo transportInfo, List<Codec2> list) {
        Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
        Intrinsics3.checkNotNullParameter(transportInfo, "transportInfo");
        Intrinsics3.checkNotNullParameter(list, "supportedVideoCodecs");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onConnectionStateChange(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.ConnectionState connectionState) {
        Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
        Intrinsics3.checkNotNullParameter(connectionState, "connectionState");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onDestroy(MediaEngineConnection mediaEngineConnection) {
        Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onError(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.FailedConnectionException failedConnectionException) {
        Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
        Intrinsics3.checkNotNullParameter(failedConnectionException, "exception");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onKrispStatus(MediaEngineConnection mediaEngineConnection, KrispOveruseDetector.Status status) {
        Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
        Intrinsics3.checkNotNullParameter(status, "status");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onLocalMute(long j, boolean z2) {
        b(new MediaSinkWantsManager3(this));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onLocalVideoOffScreen(long j, boolean z2) {
        b(new MediaSinkWantsManager3(this));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onSpeaking(long j, int i, boolean z2) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onTargetBitrate(int i) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onTargetFrameRate(int i) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onVideo(long j, Integer num, int i, int i2, int i3, StreamParameters[] streamParametersArr) {
        Intrinsics3.checkNotNullParameter(streamParametersArr, "streams");
    }
}
