package b.a.a.d;

import b.a.a.d.UserActionsDialogViewModel5;
import com.discord.R;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.subjects.PublishSubject;

/* JADX INFO: renamed from: b.a.a.d.g, reason: use source file name */
/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserActionsDialogViewModel6 extends Lambda implements Function1<Void, Unit> {
    public final /* synthetic */ UserActionsDialogViewModel5 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserActionsDialogViewModel6(UserActionsDialogViewModel5 userActionsDialogViewModel5) {
        super(1);
        this.this$0 = userActionsDialogViewModel5;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Void r3) {
        PublishSubject<UserActionsDialogViewModel5.b> publishSubject = this.this$0.k;
        publishSubject.k.onNext(new UserActionsDialogViewModel5.b.C0011b(R.string.user_has_been_blocked));
        return Unit.a;
    }
}
