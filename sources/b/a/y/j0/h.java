package b.a.y.j0;

import com.discord.views.calls.StageCallSpeakerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: StageCallSpeakerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h extends d0.z.d.o implements Function1<Subscription, Unit> {
    public final /* synthetic */ StageCallSpeakerView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(StageCallSpeakerView stageCallSpeakerView) {
        super(1);
        this.this$0 = stageCallSpeakerView;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Subscription subscription) {
        Subscription subscription2 = subscription;
        d0.z.d.m.checkNotNullParameter(subscription2, "it");
        this.this$0.com.discord.utilities.analytics.Traits$Payment$Type.SUBSCRIPTION java.lang.String = subscription2;
        return Unit.a;
    }
}
