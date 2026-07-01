package b.o.a.p;

import android.graphics.ImageFormat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.o.a.CameraLogger;
import b.o.a.n.t.Angles;
import b.o.a.n.t.Reference2;
import b.o.a.x.Size3;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: renamed from: b.o.a.p.c, reason: use source file name */
/* JADX INFO: compiled from: FrameManager.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class FrameManager<T> {
    public static final CameraLogger a = new CameraLogger(FrameManager.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1946b;
    public int c = -1;
    public Size3 d = null;
    public int e = -1;
    public final Class<T> f;
    public LinkedBlockingQueue<Frame2> g;
    public Angles h;

    public FrameManager(int i, @NonNull Class<T> cls) {
        this.f1946b = i;
        this.f = cls;
        this.g = new LinkedBlockingQueue<>(i);
    }

    @Nullable
    public Frame2 a(@NonNull T t, long j) {
        if (!b()) {
            throw new IllegalStateException("Can't call getFrame() after releasing or before setUp.");
        }
        Frame2 frame2Poll = this.g.poll();
        if (frame2Poll == null) {
            a.a(1, "getFrame for time:", Long.valueOf(j), "NOT AVAILABLE.");
            c(t, false);
            return null;
        }
        a.a(0, "getFrame for time:", Long.valueOf(j), "RECYCLING.");
        Angles angles = this.h;
        Reference2 reference2 = Reference2.SENSOR;
        angles.c(reference2, Reference2.OUTPUT, 2);
        this.h.c(reference2, Reference2.VIEW, 2);
        frame2Poll.c = t;
        frame2Poll.d = j;
        frame2Poll.e = j;
        return frame2Poll;
    }

    public boolean b() {
        return this.d != null;
    }

    public abstract void c(@NonNull T t, boolean z2);

    public void d() {
        if (!b()) {
            a.a(2, "release called twice. Ignoring.");
            return;
        }
        a.a(1, "release: Clearing the frame and buffer queue.");
        this.g.clear();
        this.c = -1;
        this.d = null;
        this.e = -1;
        this.h = null;
    }

    public void e(int i, @NonNull Size3 size3, @NonNull Angles angles) {
        this.d = size3;
        this.e = i;
        this.c = (int) Math.ceil(((double) ((size3.k * size3.j) * ImageFormat.getBitsPerPixel(i))) / 8.0d);
        for (int i2 = 0; i2 < this.f1946b; i2++) {
            this.g.offer(new Frame2(this));
        }
        this.h = angles;
    }
}
