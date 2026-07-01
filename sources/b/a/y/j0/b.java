package b.a.y.j0;

import android.graphics.Point;
import com.discord.views.calls.AppVideoStreamRenderer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AppVideoStreamRenderer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends d0.z.d.o implements Function1<Point, Unit> {
    public final /* synthetic */ AppVideoStreamRenderer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(AppVideoStreamRenderer appVideoStreamRenderer) {
        super(1);
        this.this$0 = appVideoStreamRenderer;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Point point) {
        Point point2 = point;
        d0.z.d.m.checkNotNullParameter(point2, "resolution");
        this.this$0.currentFrameResolutionSubject.onNext(point2);
        return Unit.a;
    }
}
