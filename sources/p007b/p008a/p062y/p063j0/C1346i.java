package p007b.p008a.p062y.p063j0;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.calls.StageCallSpeakerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.y.j0.i */
/* JADX INFO: compiled from: StageCallSpeakerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1346i extends AbstractC12240o implements Function1<Integer, Unit> {
    public final /* synthetic */ StageCallSpeakerView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1346i(StageCallSpeakerView stageCallSpeakerView) {
        super(1);
        this.this$0 = stageCallSpeakerView;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Integer num) {
        Integer num2 = num;
        StageCallSpeakerView stageCallSpeakerView = this.this$0;
        C12238m.checkNotNullExpressionValue(num2, ModelAuditLogEntry.CHANGE_KEY_COLOR);
        stageCallSpeakerView.setCardBackgroundColor(num2.intValue());
        return Unit.f27425a;
    }
}
