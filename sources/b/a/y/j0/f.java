package b.a.y.j0;

import android.graphics.Point;

/* JADX INFO: compiled from: RxRendererEvents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f<T, R> implements j0.k.b<e$a, Point> {
    public static final f j = new f();

    @Override // j0.k.b
    public Point call(e$a e_a) {
        e$a e_a2 = e_a;
        if (e_a2 == null) {
            return null;
        }
        int i = e_a2.c;
        return (i == -180 || i == 0 || i == 180) ? new Point(e_a2.a, e_a2.f312b) : new Point(e_a2.f312b, e_a2.a);
    }
}
