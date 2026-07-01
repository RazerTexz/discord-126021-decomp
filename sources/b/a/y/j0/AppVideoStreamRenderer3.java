package b.a.y.j0;

import android.graphics.Point;
import com.discord.views.calls.AppVideoStreamRenderer;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.y.j0.b, reason: use source file name */
/* JADX INFO: compiled from: AppVideoStreamRenderer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppVideoStreamRenderer3 extends Lambda implements Function1<Point, Unit> {
    public final /* synthetic */ AppVideoStreamRenderer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppVideoStreamRenderer3(AppVideoStreamRenderer appVideoStreamRenderer) {
        super(1);
        this.this$0 = appVideoStreamRenderer;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Point point) {
        Point point2 = point;
        Intrinsics3.checkNotNullParameter(point2, "resolution");
        this.this$0.currentFrameResolutionSubject.onNext(point2);
        return Unit.a;
    }
}
