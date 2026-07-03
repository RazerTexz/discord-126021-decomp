package p007b.p008a.p009a.p013d;

import com.discord.C5419R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p009a.p013d.C0822f;
import p507d0.p592z.p594d.AbstractC12240o;
import p658rx.subjects.PublishSubject;

/* JADX INFO: renamed from: b.a.a.d.g */
/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0823g extends AbstractC12240o implements Function1<Void, Unit> {
    public final /* synthetic */ C0822f this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0823g(C0822f c0822f) {
        super(1);
        this.this$0 = c0822f;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Void r3) {
        PublishSubject<C0822f.b> publishSubject = this.this$0.f330k;
        publishSubject.f27650k.onNext(new C0822f.b.C13207b(C5419R.string.user_has_been_blocked));
        return Unit.f27425a;
    }
}
