package p007b.p008a.p009a;

import com.discord.api.user.User;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.subjects.PublishSubject;

/* JADX INFO: renamed from: b.a.a.y */
/* JADX INFO: compiled from: WidgetUrgentMessageDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0848y extends AbstractC12240o implements Function1<User, Unit> {
    public final /* synthetic */ C0847x this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0848y(C0847x c0847x) {
        super(1);
        this.this$0 = c0847x;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(User user) {
        C12238m.checkNotNullParameter(user, "it");
        PublishSubject<C0847x.b> publishSubject = this.this$0.f447k;
        publishSubject.f27650k.onNext(C0847x.b.a.f449a);
        return Unit.f27425a;
    }
}
