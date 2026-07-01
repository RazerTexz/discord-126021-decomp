package b.a.a;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FriendRequestDialogs.kt */
/* JADX INFO: loaded from: classes.dex */
public final class l extends d0.z.d.o implements Function1<View, Unit> {
    public final /* synthetic */ Function1 $onConfirm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Function1 function1) {
        super(1);
        this.$onConfirm = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        d0.z.d.m.checkNotNullParameter(view, "<anonymous parameter 0>");
        this.$onConfirm.invoke(2131889455);
        return Unit.a;
    }
}
