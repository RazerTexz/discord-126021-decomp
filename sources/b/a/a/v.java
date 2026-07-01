package b.a.a;

import com.discord.models.user.User;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUrgentMessageDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class v extends d0.z.d.o implements Function1<x$c, Unit> {
    public final /* synthetic */ x this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(x xVar) {
        super(1);
        this.this$0 = xVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(x$c x_c) {
        x$c x_c2 = x_c;
        d0.z.d.m.checkNotNullParameter(x_c2, "storeState");
        x xVar = this.this$0;
        Objects.requireNonNull(xVar);
        User user = x_c2.a;
        x$d viewState = xVar.getViewState();
        xVar.updateViewState(new x$d(Integer.valueOf(user.getFlags()), viewState == null ? false : viewState.f50b));
        return Unit.a;
    }
}
