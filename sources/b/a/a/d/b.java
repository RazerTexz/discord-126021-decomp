package b.a.a.d;

import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b extends o implements Function1<f$c, Unit> {
    public final /* synthetic */ f this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        super(1);
        this.this$0 = fVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(f$c f_c) {
        f$c f_c2 = f_c;
        m.checkNotNullParameter(f_c2, "storeState");
        f fVar = this.this$0;
        Objects.requireNonNull(fVar);
        User user = f_c2.a;
        if (user == null) {
            fVar.k.k.onNext(new f$b$a(2131888366));
        } else {
            int type = ModelUserRelationship.getType(f_c2.f46b);
            boolean z2 = type != 2;
            boolean z3 = type == 2;
            boolean z4 = type == 1;
            GuildMember guildMember = f_c2.c;
            fVar.updateViewState(new f$d$a(user, guildMember != null ? guildMember.getNick() : null, z2, z3, z4));
        }
        return Unit.a;
    }
}
