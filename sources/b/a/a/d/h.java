package b.a.a.d;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h extends o implements Function1<Error, Unit> {
    public final /* synthetic */ f this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(f fVar) {
        super(1);
        this.this$0 = fVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Error error) {
        m.checkNotNullParameter(error, "it");
        PublishSubject<f$b> publishSubject = this.this$0.k;
        publishSubject.k.onNext(new f$b$a(2131888366));
        return Unit.a;
    }
}
