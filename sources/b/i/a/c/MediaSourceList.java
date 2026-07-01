package b.i.a.c;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.Nullable;
import b.i.a.c.a3.LoadEventInfo;
import b.i.a.c.a3.MaskingMediaPeriod;
import b.i.a.c.a3.MaskingMediaSource;
import b.i.a.c.a3.MediaLoadData;
import b.i.a.c.a3.MediaPeriod;
import b.i.a.c.a3.MediaSource2;
import b.i.a.c.a3.MediaSourceEventListener;
import b.i.a.c.a3.ShuffleOrder;
import b.i.a.c.e3.TransferListener;
import b.i.a.c.f3.Util2;
import b.i.a.c.s2.AnalyticsCollector;
import b.i.a.c.w2.DrmSessionEventListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

/* JADX INFO: renamed from: b.i.a.c.u1, reason: use source file name */
/* JADX INFO: compiled from: MediaSourceList.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaSourceList {
    public final d d;
    public final MediaSourceEventListener.a e;
    public final DrmSessionEventListener.a f;
    public final HashMap<c, b> g;
    public final Set<c> h;
    public boolean j;

    @Nullable
    public TransferListener k;
    public ShuffleOrder i = new ShuffleOrder.a(0, new Random());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IdentityHashMap<MediaPeriod, c> f1137b = new IdentityHashMap<>();
    public final Map<Object, c> c = new HashMap();
    public final List<c> a = new ArrayList();

    /* JADX INFO: renamed from: b.i.a.c.u1$a */
    /* JADX INFO: compiled from: MediaSourceList.java */
    public final class a implements MediaSourceEventListener, DrmSessionEventListener {
        public final c j;
        public MediaSourceEventListener.a k;
        public DrmSessionEventListener.a l;

        public a(c cVar) {
            this.k = MediaSourceList.this.e;
            this.l = MediaSourceList.this.f;
            this.j = cVar;
        }

        @Override // b.i.a.c.w2.DrmSessionEventListener
        public void J(int i, @Nullable MediaSource2.a aVar) {
            if (a(i, aVar)) {
                this.l.b();
            }
        }

        @Override // b.i.a.c.w2.DrmSessionEventListener
        public void S(int i, @Nullable MediaSource2.a aVar) {
            if (a(i, aVar)) {
                this.l.a();
            }
        }

        @Override // b.i.a.c.a3.MediaSourceEventListener
        public void X(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (a(i, aVar)) {
                this.k.d(loadEventInfo, mediaLoadData);
            }
        }

        public final boolean a(int i, @Nullable MediaSource2.a aVar) {
            MediaSource2.a aVarB = null;
            if (aVar != null) {
                c cVar = this.j;
                for (int i2 = 0; i2 < cVar.c.size(); i2++) {
                    if (cVar.c.get(i2).d == aVar.d) {
                        aVarB = aVar.b(Pair.create(cVar.f1139b, aVar.a));
                        break;
                    }
                }
                if (aVarB == null) {
                    return false;
                }
            }
            int i3 = i + this.j.d;
            MediaSourceEventListener.a aVar2 = this.k;
            if (aVar2.a != i3 || !Util2.a(aVar2.f807b, aVarB)) {
                this.k = MediaSourceList.this.e.g(i3, aVarB, 0L);
            }
            DrmSessionEventListener.a aVar3 = this.l;
            if (aVar3.a == i3 && Util2.a(aVar3.f1156b, aVarB)) {
                return true;
            }
            this.l = MediaSourceList.this.f.g(i3, aVarB);
            return true;
        }

        @Override // b.i.a.c.w2.DrmSessionEventListener
        public void c0(int i, @Nullable MediaSource2.a aVar, int i2) {
            if (a(i, aVar)) {
                this.l.d(i2);
            }
        }

        @Override // b.i.a.c.w2.DrmSessionEventListener
        public void d0(int i, @Nullable MediaSource2.a aVar) {
            if (a(i, aVar)) {
                this.l.f();
            }
        }

        @Override // b.i.a.c.a3.MediaSourceEventListener
        public void g0(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
            if (a(i, aVar)) {
                this.k.e(loadEventInfo, mediaLoadData, iOException, z2);
            }
        }

        @Override // b.i.a.c.w2.DrmSessionEventListener
        public void i0(int i, @Nullable MediaSource2.a aVar) {
            if (a(i, aVar)) {
                this.l.c();
            }
        }

        @Override // b.i.a.c.a3.MediaSourceEventListener
        public void o(int i, @Nullable MediaSource2.a aVar, MediaLoadData mediaLoadData) {
            if (a(i, aVar)) {
                this.k.b(mediaLoadData);
            }
        }

        @Override // b.i.a.c.a3.MediaSourceEventListener
        public void q(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (a(i, aVar)) {
                this.k.c(loadEventInfo, mediaLoadData);
            }
        }

        @Override // b.i.a.c.w2.DrmSessionEventListener
        public void u(int i, @Nullable MediaSource2.a aVar, Exception exc) {
            if (a(i, aVar)) {
                this.l.e(exc);
            }
        }

        @Override // b.i.a.c.a3.MediaSourceEventListener
        public void x(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (a(i, aVar)) {
                this.k.f(loadEventInfo, mediaLoadData);
            }
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.u1$b */
    /* JADX INFO: compiled from: MediaSourceList.java */
    public static final class b {
        public final MediaSource2 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaSource2.b f1138b;
        public final a c;

        public b(MediaSource2 mediaSource2, MediaSource2.b bVar, a aVar) {
            this.a = mediaSource2;
            this.f1138b = bVar;
            this.c = aVar;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.u1$c */
    /* JADX INFO: compiled from: MediaSourceList.java */
    public static final class c implements MediaSourceInfoHolder {
        public final MaskingMediaSource a;
        public int d;
        public boolean e;
        public final List<MediaSource2.a> c = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f1139b = new Object();

        public c(MediaSource2 mediaSource2, boolean z2) {
            this.a = new MaskingMediaSource(mediaSource2, z2);
        }

        @Override // b.i.a.c.MediaSourceInfoHolder
        public Timeline a() {
            return this.a.n;
        }

        @Override // b.i.a.c.MediaSourceInfoHolder
        public Object getUid() {
            return this.f1139b;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.u1$d */
    /* JADX INFO: compiled from: MediaSourceList.java */
    public interface d {
    }

    public MediaSourceList(d dVar, @Nullable AnalyticsCollector analyticsCollector, Handler handler) {
        this.d = dVar;
        MediaSourceEventListener.a aVar = new MediaSourceEventListener.a();
        this.e = aVar;
        DrmSessionEventListener.a aVar2 = new DrmSessionEventListener.a();
        this.f = aVar2;
        this.g = new HashMap<>();
        this.h = new HashSet();
        if (analyticsCollector != null) {
            aVar.c.add(new MediaSourceEventListener.a.C0027a(handler, analyticsCollector));
            aVar2.c.add(new DrmSessionEventListener.a.C0031a(handler, analyticsCollector));
        }
    }

    public Timeline a(int i, List<c> list, ShuffleOrder shuffleOrder) {
        if (!list.isEmpty()) {
            this.i = shuffleOrder;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                c cVar = list.get(i2 - i);
                if (i2 > 0) {
                    c cVar2 = this.a.get(i2 - 1);
                    cVar.d = cVar2.a.n.p() + cVar2.d;
                    cVar.e = false;
                    cVar.c.clear();
                } else {
                    cVar.d = 0;
                    cVar.e = false;
                    cVar.c.clear();
                }
                b(i2, cVar.a.n.p());
                this.a.add(i2, cVar);
                this.c.put(cVar.f1139b, cVar);
                if (this.j) {
                    g(cVar);
                    if (this.f1137b.isEmpty()) {
                        this.h.add(cVar);
                    } else {
                        b bVar = this.g.get(cVar);
                        if (bVar != null) {
                            bVar.a.d(bVar.f1138b);
                        }
                    }
                }
            }
        }
        return c();
    }

    public final void b(int i, int i2) {
        while (i < this.a.size()) {
            this.a.get(i).d += i2;
            i++;
        }
    }

    public Timeline c() {
        if (this.a.isEmpty()) {
            return Timeline.j;
        }
        int iP = 0;
        for (int i = 0; i < this.a.size(); i++) {
            c cVar = this.a.get(i);
            cVar.d = iP;
            iP += cVar.a.n.p();
        }
        return new PlaylistTimeline(this.a, this.i);
    }

    public final void d() {
        Iterator<c> it = this.h.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.c.isEmpty()) {
                b bVar = this.g.get(next);
                if (bVar != null) {
                    bVar.a.d(bVar.f1138b);
                }
                it.remove();
            }
        }
    }

    public int e() {
        return this.a.size();
    }

    public final void f(c cVar) {
        if (cVar.e && cVar.c.isEmpty()) {
            b bVarRemove = this.g.remove(cVar);
            Objects.requireNonNull(bVarRemove);
            bVarRemove.a.a(bVarRemove.f1138b);
            bVarRemove.a.c(bVarRemove.c);
            bVarRemove.a.g(bVarRemove.c);
            this.h.remove(cVar);
        }
    }

    public final void g(c cVar) {
        MaskingMediaSource maskingMediaSource = cVar.a;
        MediaSource2.b bVar = new MediaSource2.b() { // from class: b.i.a.c.n0
            @Override // b.i.a.c.a3.MediaSource2.b
            public final void a(MediaSource2 mediaSource2, Timeline timeline) {
                ((ExoPlayerImplInternal2) this.a.d).q.f(22);
            }
        };
        a aVar = new a(cVar);
        this.g.put(cVar, new b(maskingMediaSource, bVar, aVar));
        Handler handler = new Handler(Util2.o(), null);
        Objects.requireNonNull(maskingMediaSource);
        MediaSourceEventListener.a aVar2 = maskingMediaSource.c;
        Objects.requireNonNull(aVar2);
        aVar2.c.add(new MediaSourceEventListener.a.C0027a(handler, aVar));
        Handler handler2 = new Handler(Util2.o(), null);
        DrmSessionEventListener.a aVar3 = maskingMediaSource.d;
        Objects.requireNonNull(aVar3);
        aVar3.c.add(new DrmSessionEventListener.a.C0031a(handler2, aVar));
        maskingMediaSource.l(bVar, this.k);
    }

    public void h(MediaPeriod mediaPeriod) {
        c cVarRemove = this.f1137b.remove(mediaPeriod);
        Objects.requireNonNull(cVarRemove);
        cVarRemove.a.j(mediaPeriod);
        cVarRemove.c.remove(((MaskingMediaPeriod) mediaPeriod).j);
        if (!this.f1137b.isEmpty()) {
            d();
        }
        f(cVarRemove);
    }

    public final void i(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            c cVarRemove = this.a.remove(i3);
            this.c.remove(cVarRemove.f1139b);
            b(i3, -cVarRemove.a.n.p());
            cVarRemove.e = true;
            if (this.j) {
                f(cVarRemove);
            }
        }
    }
}
