package b.a.a;

import b.a.a.WidgetUrgentMessageDialogViewModel3;
import com.discord.utilities.error.Error;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.subjects.PublishSubject;

/* JADX INFO: renamed from: b.a.a.z, reason: use source file name */
/* JADX INFO: compiled from: WidgetUrgentMessageDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUrgentMessageDialogViewModel5 extends Lambda implements Function1<Error, Unit> {
    public final /* synthetic */ WidgetUrgentMessageDialogViewModel3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUrgentMessageDialogViewModel5(WidgetUrgentMessageDialogViewModel3 widgetUrgentMessageDialogViewModel3) {
        super(1);
        this.this$0 = widgetUrgentMessageDialogViewModel3;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Error error) {
        Intrinsics3.checkNotNullParameter(error, "it");
        PublishSubject<WidgetUrgentMessageDialogViewModel3.b> publishSubject = this.this$0.k;
        publishSubject.k.onNext(WidgetUrgentMessageDialogViewModel3.b.C0014b.a);
        return Unit.a;
    }
}
