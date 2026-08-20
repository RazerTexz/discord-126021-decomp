package p007b.p008a.p062y.p063j0;

import android.graphics.Point;
import p637j0.p641k.InterfaceC12589b;

/* JADX INFO: renamed from: b.a.y.j0.f */
/* JADX INFO: compiled from: RxRendererEvents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1343f<T, R> implements InterfaceC12589b<C1342e.a, Point> {

    /* JADX INFO: renamed from: j */
    public static final C1343f f2034j = new C1343f();

    @Override // p637j0.p641k.InterfaceC12589b
    public Point call(C1342e.a aVar) {
        C1342e.a aVar2 = aVar;
        if (aVar2 == null) {
            return null;
        }
        int i = aVar2.f2033c;
        return (i == -180 || i == 0 || i == 180) ? new Point(aVar2.f2031a, aVar2.f2032b) : new Point(aVar2.f2032b, aVar2.f2031a);
    }
}
