package b.a.a.d;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g extends o implements Function1<Void, Unit> {
    public final /* synthetic */ f this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar) {
        super(1);
        this.this$0 = fVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Void r3) {
        PublishSubject<f$b> publishSubject = this.this$0.k;
        publishSubject.k.onNext(new f$b$b(2131896767));
        return Unit.a;
    }
}
