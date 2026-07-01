package b.f.l.a;

import b.f.d.e.FLog;
import b.f.l.a.TransformGestureDetector;
import b.f.l.b.DefaultZoomableController;

/* JADX INFO: renamed from: b.f.l.a.a, reason: use source file name */
/* JADX INFO: compiled from: MultiPointerGestureDetector.java */
/* JADX INFO: loaded from: classes3.dex */
public class MultiPointerGestureDetector {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f647b;
    public final int[] c = new int[2];
    public final float[] d = new float[2];
    public final float[] e = new float[2];
    public final float[] f = new float[2];
    public final float[] g = new float[2];
    public a h = null;

    /* JADX INFO: renamed from: b.f.l.a.a$a */
    /* JADX INFO: compiled from: MultiPointerGestureDetector.java */
    public interface a {
    }

    public MultiPointerGestureDetector() {
        a();
    }

    public void a() {
        this.a = false;
        this.f647b = 0;
        for (int i = 0; i < 2; i++) {
            this.c[i] = -1;
        }
    }

    public final void b() {
        TransformGestureDetector transformGestureDetector;
        TransformGestureDetector.a aVar;
        if (this.a) {
            return;
        }
        a aVar2 = this.h;
        if (aVar2 != null && (aVar = (transformGestureDetector = (TransformGestureDetector) aVar2).f648b) != null) {
            aVar.c(transformGestureDetector);
        }
        this.a = true;
    }

    public final void c() {
        TransformGestureDetector.a aVar;
        if (this.a) {
            this.a = false;
            a aVar2 = this.h;
            if (aVar2 == null || (aVar = ((TransformGestureDetector) aVar2).f648b) == null) {
                return;
            }
            FLog.i(DefaultZoomableController.class, "onGestureEnd");
        }
    }
}
