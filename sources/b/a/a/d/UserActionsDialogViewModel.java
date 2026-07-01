package b.a.a.d;

import b.a.a.d.UserActionsDialogViewModel5;
import com.discord.R;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.a.d.b, reason: use source file name */
/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserActionsDialogViewModel extends Lambda implements Function1<UserActionsDialogViewModel5.c, Unit> {
    public final /* synthetic */ UserActionsDialogViewModel5 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserActionsDialogViewModel(UserActionsDialogViewModel5 userActionsDialogViewModel5) {
        super(1);
        this.this$0 = userActionsDialogViewModel5;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(UserActionsDialogViewModel5.c cVar) {
        UserActionsDialogViewModel5.c cVar2 = cVar;
        Intrinsics3.checkNotNullParameter(cVar2, "storeState");
        UserActionsDialogViewModel5 userActionsDialogViewModel5 = this.this$0;
        Objects.requireNonNull(userActionsDialogViewModel5);
        User user = cVar2.a;
        if (user == null) {
            userActionsDialogViewModel5.k.k.onNext(new UserActionsDialogViewModel5.b.a(R.string.default_failure_to_perform_action_message));
        } else {
            int type = ModelUserRelationship.getType(cVar2.f46b);
            boolean z2 = type != 2;
            boolean z3 = type == 2;
            boolean z4 = type == 1;
            GuildMember guildMember = cVar2.c;
            userActionsDialogViewModel5.updateViewState(new UserActionsDialogViewModel5.d.a(user, guildMember != null ? guildMember.getNick() : null, z2, z3, z4));
        }
        return Unit.a;
    }
}
