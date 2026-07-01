package b.a.a.d;

import b.a.a.d.UserActionsDialogViewModel5;
import com.discord.R;
import com.discord.utilities.error.Error;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.subjects.PublishSubject;

/* JADX INFO: renamed from: b.a.a.d.h, reason: use source file name */
/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserActionsDialogViewModel7 extends Lambda implements Function1<Error, Unit> {
    public final /* synthetic */ UserActionsDialogViewModel5 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserActionsDialogViewModel7(UserActionsDialogViewModel5 userActionsDialogViewModel5) {
        super(1);
        this.this$0 = userActionsDialogViewModel5;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Error error) {
        Intrinsics3.checkNotNullParameter(error, "it");
        PublishSubject<UserActionsDialogViewModel5.b> publishSubject = this.this$0.k;
        publishSubject.k.onNext(new UserActionsDialogViewModel5.b.a(R.string.default_failure_to_perform_action_message));
        return Unit.a;
    }
}
