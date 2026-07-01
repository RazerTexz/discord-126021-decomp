package b.a.y;

import android.text.Editable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: OverlayVoiceSelectorBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class z$b extends d0.z.d.o implements Function1<Editable, Unit> {
    public final /* synthetic */ z this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z$b(z zVar) {
        super(1);
        this.this$0 = zVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Editable editable) {
        Editable editable2 = editable;
        d0.z.d.m.checkNotNullParameter(editable2, "editable");
        this.this$0.B.onNext(editable2.toString());
        return Unit.a;
    }
}
