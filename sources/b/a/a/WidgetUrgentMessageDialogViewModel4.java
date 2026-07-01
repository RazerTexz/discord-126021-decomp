package b.a.a;

import b.a.a.WidgetUrgentMessageDialogViewModel3;
import com.discord.api.user.User;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.subjects.PublishSubject;

/* JADX INFO: renamed from: b.a.a.y, reason: use source file name */
/* JADX INFO: compiled from: WidgetUrgentMessageDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUrgentMessageDialogViewModel4 extends Lambda implements Function1<User, Unit> {
    public final /* synthetic */ WidgetUrgentMessageDialogViewModel3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUrgentMessageDialogViewModel4(WidgetUrgentMessageDialogViewModel3 widgetUrgentMessageDialogViewModel3) {
        super(1);
        this.this$0 = widgetUrgentMessageDialogViewModel3;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(User user) {
        Intrinsics3.checkNotNullParameter(user, "it");
        PublishSubject<WidgetUrgentMessageDialogViewModel3.b> publishSubject = this.this$0.k;
        publishSubject.k.onNext(WidgetUrgentMessageDialogViewModel3.b.a.a);
        return Unit.a;
    }
}
