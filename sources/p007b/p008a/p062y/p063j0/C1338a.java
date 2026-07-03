package p007b.p008a.p062y.p063j0;

import android.graphics.Point;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;

/* JADX INFO: renamed from: b.a.y.j0.a */
/* JADX INFO: compiled from: AppVideoStreamRenderer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1338a<T, R> implements InterfaceC12589b<Unit, Observable<? extends Point>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C1342e f2028j;

    public C1338a(C1342e c1342e) {
        this.f2028j = c1342e;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Observable<? extends Point> call(Unit unit) {
        Observable<R> observableM11086L = this.f2028j.f2030j.m11090P(50L, TimeUnit.MILLISECONDS).m11083G(C1343f.f2034j).m11086L();
        C12238m.checkNotNullExpressionValue(observableM11086L, "frameResolutionSubject\n …  .onBackpressureLatest()");
        return observableM11086L;
    }
}
