package p007b.p452o.p453a.p465p;

import android.graphics.ImageFormat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.LinkedBlockingQueue;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.p455n.p461t.C5170a;
import p007b.p452o.p453a.p455n.p461t.EnumC5171b;
import p007b.p452o.p453a.p473x.C5236b;

/* JADX INFO: renamed from: b.o.a.p.c */
/* JADX INFO: compiled from: FrameManager.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC5190c<T> {

    /* JADX INFO: renamed from: a */
    public static final C5103b f14058a = new C5103b(AbstractC5190c.class.getSimpleName());

    /* JADX INFO: renamed from: b */
    public final int f14059b;

    /* JADX INFO: renamed from: c */
    public int f14060c = -1;

    /* JADX INFO: renamed from: d */
    public C5236b f14061d = null;

    /* JADX INFO: renamed from: e */
    public int f14062e = -1;

    /* JADX INFO: renamed from: f */
    public final Class<T> f14063f;

    /* JADX INFO: renamed from: g */
    public LinkedBlockingQueue<C5189b> f14064g;

    /* JADX INFO: renamed from: h */
    public C5170a f14065h;

    public AbstractC5190c(int i, @NonNull Class<T> cls) {
        this.f14059b = i;
        this.f14063f = cls;
        this.f14064g = new LinkedBlockingQueue<>(i);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C5189b m7385a(@NonNull T t, long j) {
        if (!m7386b()) {
            throw new IllegalStateException("Can't call getFrame() after releasing or before setUp.");
        }
        C5189b c5189bPoll = this.f14064g.poll();
        if (c5189bPoll == null) {
            f14058a.m7159a(1, "getFrame for time:", Long.valueOf(j), "NOT AVAILABLE.");
            mo7380c(t, false);
            return null;
        }
        f14058a.m7159a(0, "getFrame for time:", Long.valueOf(j), "RECYCLING.");
        C5170a c5170a = this.f14065h;
        EnumC5171b enumC5171b = EnumC5171b.SENSOR;
        c5170a.m7358c(enumC5171b, EnumC5171b.OUTPUT, 2);
        this.f14065h.m7358c(enumC5171b, EnumC5171b.VIEW, 2);
        c5189bPoll.f14055c = t;
        c5189bPoll.f14056d = j;
        c5189bPoll.f14057e = j;
        return c5189bPoll;
    }

    /* JADX INFO: renamed from: b */
    public boolean m7386b() {
        return this.f14061d != null;
    }

    /* JADX INFO: renamed from: c */
    public abstract void mo7380c(@NonNull T t, boolean z2);

    /* JADX INFO: renamed from: d */
    public void mo7381d() {
        if (!m7386b()) {
            f14058a.m7159a(2, "release called twice. Ignoring.");
            return;
        }
        f14058a.m7159a(1, "release: Clearing the frame and buffer queue.");
        this.f14064g.clear();
        this.f14060c = -1;
        this.f14061d = null;
        this.f14062e = -1;
        this.f14065h = null;
    }

    /* JADX INFO: renamed from: e */
    public void mo7382e(int i, @NonNull C5236b c5236b, @NonNull C5170a c5170a) {
        this.f14061d = c5236b;
        this.f14062e = i;
        this.f14060c = (int) Math.ceil(((double) ((c5236b.f14252k * c5236b.f14251j) * ImageFormat.getBitsPerPixel(i))) / 8.0d);
        for (int i2 = 0; i2 < this.f14059b; i2++) {
            this.f14064g.offer(new C5189b(this));
        }
        this.f14065h = c5170a;
    }
}
