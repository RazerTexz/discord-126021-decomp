package b.i.a.c.a3;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Timeline;
import b.i.a.c.a3.MediaSource2;
import b.i.a.c.a3.MediaSourceEventListener;
import b.i.a.c.e3.TransferListener;
import b.i.a.c.w2.DrmSessionEventListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.a3.l, reason: use source file name */
/* JADX INFO: compiled from: BaseMediaSource.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseMediaSource implements MediaSource2 {
    public final ArrayList<MediaSource2.b> a = new ArrayList<>(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<MediaSource2.b> f827b = new HashSet<>(1);
    public final MediaSourceEventListener.a c = new MediaSourceEventListener.a();
    public final DrmSessionEventListener.a d = new DrmSessionEventListener.a();

    @Nullable
    public Looper e;

    @Nullable
    public Timeline f;

    @Override // b.i.a.c.a3.MediaSource2
    public final void a(MediaSource2.b bVar) {
        this.a.remove(bVar);
        if (!this.a.isEmpty()) {
            d(bVar);
            return;
        }
        this.e = null;
        this.f = null;
        this.f827b.clear();
        s();
    }

    @Override // b.i.a.c.a3.MediaSource2
    public final void b(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        MediaSourceEventListener.a aVar = this.c;
        Objects.requireNonNull(aVar);
        aVar.c.add(new MediaSourceEventListener.a.C0027a(handler, mediaSourceEventListener));
    }

    @Override // b.i.a.c.a3.MediaSource2
    public final void c(MediaSourceEventListener mediaSourceEventListener) {
        MediaSourceEventListener.a aVar = this.c;
        for (MediaSourceEventListener.a.C0027a c0027a : aVar.c) {
            if (c0027a.f808b == mediaSourceEventListener) {
                aVar.c.remove(c0027a);
            }
        }
    }

    @Override // b.i.a.c.a3.MediaSource2
    public final void d(MediaSource2.b bVar) {
        boolean z2 = !this.f827b.isEmpty();
        this.f827b.remove(bVar);
        if (z2 && this.f827b.isEmpty()) {
            o();
        }
    }

    @Override // b.i.a.c.a3.MediaSource2
    public final void f(Handler handler, DrmSessionEventListener drmSessionEventListener) {
        DrmSessionEventListener.a aVar = this.d;
        Objects.requireNonNull(aVar);
        aVar.c.add(new DrmSessionEventListener.a.C0031a(handler, drmSessionEventListener));
    }

    @Override // b.i.a.c.a3.MediaSource2
    public final void g(DrmSessionEventListener drmSessionEventListener) {
        DrmSessionEventListener.a aVar = this.d;
        for (DrmSessionEventListener.a.C0031a c0031a : aVar.c) {
            if (c0031a.f1157b == drmSessionEventListener) {
                aVar.c.remove(c0031a);
            }
        }
    }

    @Override // b.i.a.c.a3.MediaSource2
    public /* synthetic */ boolean i() {
        return MediaSource3.b(this);
    }

    @Override // b.i.a.c.a3.MediaSource2
    public /* synthetic */ Timeline k() {
        return MediaSource3.a(this);
    }

    @Override // b.i.a.c.a3.MediaSource2
    public final void l(MediaSource2.b bVar, @Nullable TransferListener transferListener) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.e;
        AnimatableValueParser.j(looper == null || looper == looperMyLooper);
        Timeline timeline = this.f;
        this.a.add(bVar);
        if (this.e == null) {
            this.e = looperMyLooper;
            this.f827b.add(bVar);
            q(transferListener);
        } else if (timeline != null) {
            m(bVar);
            bVar.a(this, timeline);
        }
    }

    @Override // b.i.a.c.a3.MediaSource2
    public final void m(MediaSource2.b bVar) {
        Objects.requireNonNull(this.e);
        boolean zIsEmpty = this.f827b.isEmpty();
        this.f827b.add(bVar);
        if (zIsEmpty) {
            p();
        }
    }

    public void o() {
    }

    public void p() {
    }

    public abstract void q(@Nullable TransferListener transferListener);

    public final void r(Timeline timeline) {
        this.f = timeline;
        Iterator<MediaSource2.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(this, timeline);
        }
    }

    public abstract void s();
}
