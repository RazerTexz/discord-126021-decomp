package b.a.y.j0;

import android.graphics.Point;
import b.a.y.j0.RxRendererEvents;
import j0.k.Func1;

/* JADX INFO: renamed from: b.a.y.j0.f, reason: use source file name */
/* JADX INFO: compiled from: RxRendererEvents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RxRendererEvents2<T, R> implements Func1<RxRendererEvents.a, Point> {
    public static final RxRendererEvents2 j = new RxRendererEvents2();

    @Override // j0.k.Func1
    public Point call(RxRendererEvents.a aVar) {
        RxRendererEvents.a aVar2 = aVar;
        if (aVar2 == null) {
            return null;
        }
        int i = aVar2.c;
        return (i == -180 || i == 0 || i == 180) ? new Point(aVar2.a, aVar2.f312b) : new Point(aVar2.f312b, aVar2.a);
    }
}
