package b.f.l.a;

import b.f.l.a.MultiPointerGestureDetector;

/* JADX INFO: renamed from: b.f.l.a.b, reason: use source file name */
/* JADX INFO: compiled from: TransformGestureDetector.java */
/* JADX INFO: loaded from: classes3.dex */
public class TransformGestureDetector implements MultiPointerGestureDetector.a {
    public final MultiPointerGestureDetector a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f648b = null;

    /* JADX INFO: renamed from: b.f.l.a.b$a */
    /* JADX INFO: compiled from: TransformGestureDetector.java */
    public interface a {
        void b(TransformGestureDetector transformGestureDetector);

        void c(TransformGestureDetector transformGestureDetector);
    }

    public TransformGestureDetector(MultiPointerGestureDetector multiPointerGestureDetector) {
        this.a = multiPointerGestureDetector;
        multiPointerGestureDetector.h = this;
    }

    public final float a(float[] fArr, int i) {
        float f = 0.0f;
        for (int i2 = 0; i2 < i; i2++) {
            f += fArr[i2];
        }
        if (i > 0) {
            return f / i;
        }
        return 0.0f;
    }

    public float b() {
        MultiPointerGestureDetector multiPointerGestureDetector = this.a;
        return a(multiPointerGestureDetector.d, multiPointerGestureDetector.f647b);
    }

    public float c() {
        MultiPointerGestureDetector multiPointerGestureDetector = this.a;
        return a(multiPointerGestureDetector.e, multiPointerGestureDetector.f647b);
    }

    public void d() {
        MultiPointerGestureDetector multiPointerGestureDetector = this.a;
        if (multiPointerGestureDetector.a) {
            multiPointerGestureDetector.c();
            for (int i = 0; i < 2; i++) {
                multiPointerGestureDetector.d[i] = multiPointerGestureDetector.f[i];
                multiPointerGestureDetector.e[i] = multiPointerGestureDetector.g[i];
            }
            multiPointerGestureDetector.b();
        }
    }
}
