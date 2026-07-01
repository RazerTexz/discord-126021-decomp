package b.a.a;

import b.a.a.WidgetUrgentMessageDialogViewModel3;
import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.a.v, reason: use source file name */
/* JADX INFO: compiled from: WidgetUrgentMessageDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUrgentMessageDialogViewModel extends Lambda implements Function1<WidgetUrgentMessageDialogViewModel3.c, Unit> {
    public final /* synthetic */ WidgetUrgentMessageDialogViewModel3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUrgentMessageDialogViewModel(WidgetUrgentMessageDialogViewModel3 widgetUrgentMessageDialogViewModel3) {
        super(1);
        this.this$0 = widgetUrgentMessageDialogViewModel3;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(WidgetUrgentMessageDialogViewModel3.c cVar) {
        WidgetUrgentMessageDialogViewModel3.c cVar2 = cVar;
        Intrinsics3.checkNotNullParameter(cVar2, "storeState");
        WidgetUrgentMessageDialogViewModel3 widgetUrgentMessageDialogViewModel3 = this.this$0;
        Objects.requireNonNull(widgetUrgentMessageDialogViewModel3);
        User user = cVar2.a;
        WidgetUrgentMessageDialogViewModel3.d viewState = widgetUrgentMessageDialogViewModel3.getViewState();
        widgetUrgentMessageDialogViewModel3.updateViewState(new WidgetUrgentMessageDialogViewModel3.d(Integer.valueOf(user.getFlags()), viewState == null ? false : viewState.f50b));
        return Unit.a;
    }
}
