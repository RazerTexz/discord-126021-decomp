package b.o.a.p;

import android.graphics.ImageFormat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: FrameManager.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c<T> {
    public static final b.o.a.b a = new b.o.a.b(c.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1946b;
    public int c = -1;
    public b.o.a.x.b d = null;
    public int e = -1;
    public final Class<T> f;
    public LinkedBlockingQueue<b> g;
    public b.o.a.n.t.a h;

    public c(int i, @NonNull Class<T> cls) {
        this.f1946b = i;
        this.f = cls;
        this.g = new LinkedBlockingQueue<>(i);
    }

    @Nullable
    public b a(@NonNull T t, long j) {
        if (!b()) {
            throw new IllegalStateException("Can't call getFrame() after releasing or before setUp.");
        }
        b bVarPoll = this.g.poll();
        if (bVarPoll == null) {
            a.a(1, "getFrame for time:", Long.valueOf(j), "NOT AVAILABLE.");
            c(t, false);
            return null;
        }
        a.a(0, "getFrame for time:", Long.valueOf(j), "RECYCLING.");
        b.o.a.n.t.a aVar = this.h;
        b.o.a.n.t.b bVar = b.o.a.n.t.b.SENSOR;
        aVar.c(bVar, b.o.a.n.t.b.OUTPUT, 2);
        this.h.c(bVar, b.o.a.n.t.b.VIEW, 2);
        bVarPoll.c = t;
        bVarPoll.d = j;
        bVarPoll.e = j;
        return bVarPoll;
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

    public void e(int i, @NonNull b.o.a.x.b bVar, @NonNull b.o.a.n.t.a aVar) {
        this.d = bVar;
        this.e = i;
        this.c = (int) Math.ceil(((double) ((bVar.k * bVar.j) * ImageFormat.getBitsPerPixel(i))) / 8.0d);
        for (int i2 = 0; i2 < this.f1946b; i2++) {
            this.g.offer(new b(this));
        }
        this.h = aVar;
    }
}
