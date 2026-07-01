package b.a.y.j0;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.calls.StageCallSpeakerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StageCallSpeakerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i extends d0.z.d.o implements Function1<Integer, Unit> {
    public final /* synthetic */ StageCallSpeakerView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(StageCallSpeakerView stageCallSpeakerView) {
        super(1);
        this.this$0 = stageCallSpeakerView;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Integer num) {
        Integer num2 = num;
        StageCallSpeakerView stageCallSpeakerView = this.this$0;
        d0.z.d.m.checkNotNullExpressionValue(num2, ModelAuditLogEntry.CHANGE_KEY_COLOR);
        stageCallSpeakerView.setCardBackgroundColor(num2.intValue());
        return Unit.a;
    }
}
