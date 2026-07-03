package p007b.p008a.p062y.p063j0;

import com.discord.views.calls.StageCallSpeakerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: renamed from: b.a.y.j0.h */
/* JADX INFO: compiled from: StageCallSpeakerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1345h extends AbstractC12240o implements Function1<Subscription, Unit> {
    public final /* synthetic */ StageCallSpeakerView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1345h(StageCallSpeakerView stageCallSpeakerView) {
        super(1);
        this.this$0 = stageCallSpeakerView;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Subscription subscription) {
        Subscription subscription2 = subscription;
        C12238m.checkNotNullParameter(subscription2, "it");
        this.this$0.com.discord.utilities.analytics.Traits.Payment.Type.SUBSCRIPTION java.lang.String = subscription2;
        return Unit.f27425a;
    }
}
