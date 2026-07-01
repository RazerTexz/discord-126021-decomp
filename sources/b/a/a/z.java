package b.a.a;

import com.discord.utilities.error.Error;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetUrgentMessageDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class z extends d0.z.d.o implements Function1<Error, Unit> {
    public final /* synthetic */ x this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(x xVar) {
        super(1);
        this.this$0 = xVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Error error) {
        d0.z.d.m.checkNotNullParameter(error, "it");
        PublishSubject<x$b> publishSubject = this.this$0.k;
        publishSubject.k.onNext(x$b$b.a);
        return Unit.a;
    }
}
