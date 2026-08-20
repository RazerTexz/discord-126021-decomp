package p007b.p008a.p009a;

import com.discord.models.user.User;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.v */
/* JADX INFO: compiled from: WidgetUrgentMessageDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0845v extends AbstractC12240o implements Function1<C0847x.c, Unit> {
    public final /* synthetic */ C0847x this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0845v(C0847x c0847x) {
        super(1);
        this.this$0 = c0847x;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(C0847x.c cVar) {
        C0847x.c cVar2 = cVar;
        C12238m.checkNotNullParameter(cVar2, "storeState");
        C0847x c0847x = this.this$0;
        Objects.requireNonNull(c0847x);
        User user = cVar2.f451a;
        C0847x.d viewState = c0847x.getViewState();
        c0847x.updateViewState(new C0847x.d(Integer.valueOf(user.getFlags()), viewState == null ? false : viewState.f453b));
        return Unit.f27425a;
    }
}
