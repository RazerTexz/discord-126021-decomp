package b.a.y.j0;

import android.graphics.Point;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import rx.Observable;

/* JADX INFO: renamed from: b.a.y.j0.a, reason: use source file name */
/* JADX INFO: compiled from: AppVideoStreamRenderer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppVideoStreamRenderer2<T, R> implements Func1<Unit, Observable<? extends Point>> {
    public final /* synthetic */ RxRendererEvents j;

    public AppVideoStreamRenderer2(RxRendererEvents rxRendererEvents) {
        this.j = rxRendererEvents;
    }

    @Override // j0.k.Func1
    public Observable<? extends Point> call(Unit unit) {
        Observable<R> observableL = this.j.j.P(50L, TimeUnit.MILLISECONDS).G(RxRendererEvents2.j).L();
        Intrinsics3.checkNotNullExpressionValue(observableL, "frameResolutionSubject\n …  .onBackpressureLatest()");
        return observableL;
    }
}
