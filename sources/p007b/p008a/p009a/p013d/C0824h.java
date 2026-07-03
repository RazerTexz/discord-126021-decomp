package p007b.p008a.p009a.p013d;

import com.discord.C5419R;
import com.discord.utilities.error.Error;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p009a.p013d.C0822f;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.subjects.PublishSubject;

/* JADX INFO: renamed from: b.a.a.d.h */
/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0824h extends AbstractC12240o implements Function1<Error, Unit> {
    public final /* synthetic */ C0822f this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0824h(C0822f c0822f) {
        super(1);
        this.this$0 = c0822f;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Error error) {
        C12238m.checkNotNullParameter(error, "it");
        PublishSubject<C0822f.b> publishSubject = this.this$0.f330k;
        publishSubject.f27650k.onNext(new C0822f.b.a(C5419R.string.default_failure_to_perform_action_message));
        return Unit.f27425a;
    }
}
