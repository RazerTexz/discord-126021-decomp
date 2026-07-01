package b.a.a.d;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f$e extends o implements Function1<Void, Unit> {
    public final /* synthetic */ int $successMessageStringRes;
    public final /* synthetic */ f this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f$e(f fVar, int i) {
        super(1);
        this.this$0 = fVar;
        this.$successMessageStringRes = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Void r3) {
        f fVar = this.this$0;
        int i = this.$successMessageStringRes;
        PublishSubject<f$b> publishSubject = fVar.k;
        publishSubject.k.onNext(new f$b$b(i));
        return Unit.a;
    }
}
