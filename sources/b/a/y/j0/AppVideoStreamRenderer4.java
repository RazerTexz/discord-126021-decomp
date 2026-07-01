package b.a.y.j0;

import com.discord.views.calls.AppVideoStreamRenderer;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: renamed from: b.a.y.j0.c, reason: use source file name */
/* JADX INFO: compiled from: AppVideoStreamRenderer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppVideoStreamRenderer4 extends Lambda implements Function1<Subscription, Unit> {
    public final /* synthetic */ AppVideoStreamRenderer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppVideoStreamRenderer4(AppVideoStreamRenderer appVideoStreamRenderer) {
        super(1);
        this.this$0 = appVideoStreamRenderer;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Subscription subscription) {
        Subscription subscription2 = subscription;
        Intrinsics3.checkNotNullParameter(subscription2, "it");
        this.this$0.updateRendererSizeSubscription = subscription2;
        return Unit.a;
    }
}
