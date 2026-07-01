package b.a.y.j0;

import android.graphics.Point;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import rx.Observable;

/* JADX INFO: compiled from: AppVideoStreamRenderer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a<T, R> implements j0.k.b<Unit, Observable<? extends Point>> {
    public final /* synthetic */ e j;

    public a(e eVar) {
        this.j = eVar;
    }

    @Override // j0.k.b
    public Observable<? extends Point> call(Unit unit) {
        Observable<R> observableL = this.j.j.P(50L, TimeUnit.MILLISECONDS).G(f.j).L();
        d0.z.d.m.checkNotNullExpressionValue(observableL, "frameResolutionSubject\n …  .onBackpressureLatest()");
        return observableL;
    }
}
