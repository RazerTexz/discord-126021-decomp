package b.a.a;

import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetUrgentMessageDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class t$d extends d0.z.d.o implements Function1<x$b, Unit> {
    public final /* synthetic */ t this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t$d(t tVar) {
        super(1);
        this.this$0 = tVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(x$b x_b) {
        x$b x_b2 = x_b;
        d0.z.d.m.checkNotNullParameter(x_b2, "event");
        t tVar = this.this$0;
        KProperty[] kPropertyArr = t.j;
        Objects.requireNonNull(tVar);
        if (d0.z.d.m.areEqual(x_b2, x$b$a.a)) {
            tVar.dismiss();
        } else {
            if (!d0.z.d.m.areEqual(x_b2, x$b$b.a)) {
                throw new NoWhenBranchMatchedException();
            }
            b.a.d.m.g(tVar.getContext(), 2131892203, 0, null, 12);
        }
        return Unit.a;
    }
}
