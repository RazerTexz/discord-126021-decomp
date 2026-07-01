package b.i.a.c.a3;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Timeline;
import b.i.a.c.a3.MaskingMediaSource;
import b.i.a.c.a3.MediaSource2;
import b.i.a.c.a3.MediaSourceEventListener;
import b.i.a.c.e3.TransferListener;
import b.i.a.c.f3.Util2;
import b.i.a.c.w2.DrmSessionEventListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.a3.o, reason: use source file name */
/* JADX INFO: compiled from: CompositeMediaSource.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CompositeMediaSource<T> extends BaseMediaSource {
    public final HashMap<T, b<T>> g = new HashMap<>();

    @Nullable
    public Handler h;

    @Nullable
    public TransferListener i;

    /* JADX INFO: renamed from: b.i.a.c.a3.o$a */
    /* JADX INFO: compiled from: CompositeMediaSource.java */
    public final class a implements MediaSourceEventListener, DrmSessionEventListener {
        public final T j;
        public MediaSourceEventListener.a k;
        public DrmSessionEventListener.a l;

        public a(T t) {
            this.k = CompositeMediaSource.this.c.g(0, null, 0L);
            this.l = CompositeMediaSource.this.d.g(0, null);
            this.j = t;
        }

        @Override // b.i.a.c.w2.DrmSessionEventListener
        public void J(int i, @Nullable MediaSource2.a aVar) {
            a(i, aVar);
            this.l.b();
        }

        @Override // b.i.a.c.w2.DrmSessionEventListener
        public void S(int i, @Nullable MediaSource2.a aVar) {
            a(i, aVar);
            this.l.a();
        }

        @Override // b.i.a.c.a3.MediaSourceEventListener
        public void X(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            a(i, aVar);
            this.k.d(loadEventInfo, b(mediaLoadData));
        }

        public final boolean a(int i, @Nullable MediaSource2.a aVar) {
            MediaSource2.a aVarB;
            if (aVar != null) {
                CompositeMediaSource compositeMediaSource = CompositeMediaSource.this;
                T t = this.j;
                MaskingMediaSource maskingMediaSource = (MaskingMediaSource) compositeMediaSource;
                Objects.requireNonNull(maskingMediaSource);
                Object obj = aVar.a;
                Object obj2 = maskingMediaSource.n.n;
                if (obj2 != null && obj2.equals(obj)) {
                    obj = MaskingMediaSource.a.l;
                }
                aVarB = aVar.b(obj);
            } else {
                aVarB = null;
            }
            Objects.requireNonNull(CompositeMediaSource.this);
            MediaSourceEventListener.a aVar2 = this.k;
            if (aVar2.a != i || !Util2.a(aVar2.f807b, aVarB)) {
                this.k = CompositeMediaSource.this.c.g(i, aVarB, 0L);
            }
            DrmSessionEventListener.a aVar3 = this.l;
            if (aVar3.a == i && Util2.a(aVar3.f1156b, aVarB)) {
                return true;
            }
            this.l = new DrmSessionEventListener.a(CompositeMediaSource.this.d.c, i, aVarB);
            return true;
        }

        public final MediaLoadData b(MediaLoadData mediaLoadData) {
            CompositeMediaSource compositeMediaSource = CompositeMediaSource.this;
            long j = mediaLoadData.f;
            Objects.requireNonNull(compositeMediaSource);
            CompositeMediaSource compositeMediaSource2 = CompositeMediaSource.this;
            long j2 = mediaLoadData.g;
            Objects.requireNonNull(compositeMediaSource2);
            return (j == mediaLoadData.f && j2 == mediaLoadData.g) ? mediaLoadData : new MediaLoadData(mediaLoadData.a, mediaLoadData.f834b, mediaLoadData.c, mediaLoadData.d, mediaLoadData.e, j, j2);
        }

        @Override // b.i.a.c.w2.DrmSessionEventListener
        public void c0(int i, @Nullable MediaSource2.a aVar, int i2) {
            a(i, aVar);
            this.l.d(i2);
        }

        @Override // b.i.a.c.w2.DrmSessionEventListener
        public void d0(int i, @Nullable MediaSource2.a aVar) {
            a(i, aVar);
            this.l.f();
        }

        @Override // b.i.a.c.a3.MediaSourceEventListener
        public void g0(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
            a(i, aVar);
            this.k.e(loadEventInfo, b(mediaLoadData), iOException, z2);
        }

        @Override // b.i.a.c.w2.DrmSessionEventListener
        public void i0(int i, @Nullable MediaSource2.a aVar) {
            a(i, aVar);
            this.l.c();
        }

        @Override // b.i.a.c.a3.MediaSourceEventListener
        public void o(int i, @Nullable MediaSource2.a aVar, MediaLoadData mediaLoadData) {
            a(i, aVar);
            this.k.b(b(mediaLoadData));
        }

        @Override // b.i.a.c.a3.MediaSourceEventListener
        public void q(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            a(i, aVar);
            this.k.c(loadEventInfo, b(mediaLoadData));
        }

        @Override // b.i.a.c.w2.DrmSessionEventListener
        public void u(int i, @Nullable MediaSource2.a aVar, Exception exc) {
            a(i, aVar);
            this.l.e(exc);
        }

        @Override // b.i.a.c.a3.MediaSourceEventListener
        public void x(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            a(i, aVar);
            this.k.f(loadEventInfo, b(mediaLoadData));
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.a3.o$b */
    /* JADX INFO: compiled from: CompositeMediaSource.java */
    public static final class b<T> {
        public final MediaSource2 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaSource2.b f831b;
        public final CompositeMediaSource<T>.a c;

        public b(MediaSource2 mediaSource2, MediaSource2.b bVar, CompositeMediaSource<T>.a aVar) {
            this.a = mediaSource2;
            this.f831b = bVar;
            this.c = aVar;
        }
    }

    @Override // b.i.a.c.a3.BaseMediaSource
    @CallSuper
    public void o() {
        for (b<T> bVar : this.g.values()) {
            bVar.a.d(bVar.f831b);
        }
    }

    @Override // b.i.a.c.a3.BaseMediaSource
    @CallSuper
    public void p() {
        for (b<T> bVar : this.g.values()) {
            bVar.a.m(bVar.f831b);
        }
    }

    public final void t(T t, MediaSource2 mediaSource2) {
        final Object obj = null;
        AnimatableValueParser.j(!this.g.containsKey(null));
        MediaSource2.b bVar = new MediaSource2.b() { // from class: b.i.a.c.a3.a
            /* JADX WARN: Code duplicated, block: B:19:0x007e  */
            /* JADX WARN: Code duplicated, block: B:35:0x00da  */
            /* JADX WARN: Code duplicated, block: B:37:? A[RETURN, SYNTHETIC] */
            @Override // b.i.a.c.a3.MediaSource2.b
            public final void a(MediaSource2 mediaSource3, Timeline timeline) {
                long j;
                MaskingMediaSource.a aVar;
                MediaSource2.a aVarB;
                MaskingMediaSource.a aVar2;
                CompositeMediaSource compositeMediaSource = this.a;
                Object obj2 = obj;
                Objects.requireNonNull(compositeMediaSource);
                MaskingMediaSource maskingMediaSource = (MaskingMediaSource) compositeMediaSource;
                if (maskingMediaSource.q) {
                    MaskingMediaSource.a aVar3 = maskingMediaSource.n;
                    maskingMediaSource.n = new MaskingMediaSource.a(timeline, aVar3.m, aVar3.n);
                    MaskingMediaPeriod maskingMediaPeriod = maskingMediaSource.o;
                    if (maskingMediaPeriod != null) {
                        maskingMediaSource.v(maskingMediaPeriod.p);
                    }
                } else {
                    if (!timeline.q()) {
                        timeline.n(0, maskingMediaSource.l);
                        Timeline.c cVar = maskingMediaSource.l;
                        long j2 = cVar.f1045z;
                        Object obj3 = cVar.n;
                        MaskingMediaPeriod maskingMediaPeriod2 = maskingMediaSource.o;
                        if (maskingMediaPeriod2 != null) {
                            long j3 = maskingMediaPeriod2.k;
                            maskingMediaSource.n.h(maskingMediaPeriod2.j.a, maskingMediaSource.m);
                            long j4 = maskingMediaSource.m.n + j3;
                            if (j4 != maskingMediaSource.n.n(0, maskingMediaSource.l).f1045z) {
                                j = j4;
                            } else {
                                j = j2;
                            }
                        } else {
                            j = j2;
                        }
                        Pair<Object, Long> pairJ = timeline.j(maskingMediaSource.l, maskingMediaSource.m, 0, j);
                        Object obj4 = pairJ.first;
                        long jLongValue = ((Long) pairJ.second).longValue();
                        if (maskingMediaSource.r) {
                            MaskingMediaSource.a aVar4 = maskingMediaSource.n;
                            aVar = new MaskingMediaSource.a(timeline, aVar4.m, aVar4.n);
                        } else {
                            aVar = new MaskingMediaSource.a(timeline, obj3, obj4);
                        }
                        maskingMediaSource.n = aVar;
                        MaskingMediaPeriod maskingMediaPeriod3 = maskingMediaSource.o;
                        if (maskingMediaPeriod3 != null) {
                            maskingMediaSource.v(jLongValue);
                            MediaSource2.a aVar5 = maskingMediaPeriod3.j;
                            Object obj5 = aVar5.a;
                            if (maskingMediaSource.n.n != null && obj5.equals(MaskingMediaSource.a.l)) {
                                obj5 = maskingMediaSource.n.n;
                            }
                            aVarB = aVar5.b(obj5);
                        }
                        maskingMediaSource.r = true;
                        maskingMediaSource.q = true;
                        maskingMediaSource.r(maskingMediaSource.n);
                        if (aVarB != null) {
                            MaskingMediaPeriod maskingMediaPeriod4 = maskingMediaSource.o;
                            Objects.requireNonNull(maskingMediaPeriod4);
                            maskingMediaPeriod4.d(aVarB);
                        }
                    }
                    if (maskingMediaSource.r) {
                        MaskingMediaSource.a aVar6 = maskingMediaSource.n;
                        aVar2 = new MaskingMediaSource.a(timeline, aVar6.m, aVar6.n);
                    } else {
                        aVar2 = new MaskingMediaSource.a(timeline, Timeline.c.j, MaskingMediaSource.a.l);
                    }
                    maskingMediaSource.n = aVar2;
                }
                aVarB = null;
                maskingMediaSource.r = true;
                maskingMediaSource.q = true;
                maskingMediaSource.r(maskingMediaSource.n);
                if (aVarB != null) {
                    MaskingMediaPeriod maskingMediaPeriod5 = maskingMediaSource.o;
                    Objects.requireNonNull(maskingMediaPeriod5);
                    maskingMediaPeriod5.d(aVarB);
                }
            }
        };
        a aVar = new a(null);
        this.g.put(null, new b<>(mediaSource2, bVar, aVar));
        Handler handler = this.h;
        Objects.requireNonNull(handler);
        mediaSource2.b(handler, aVar);
        Handler handler2 = this.h;
        Objects.requireNonNull(handler2);
        mediaSource2.f(handler2, aVar);
        mediaSource2.l(bVar, this.i);
        if (!this.f827b.isEmpty()) {
            return;
        }
        mediaSource2.d(bVar);
    }
}
