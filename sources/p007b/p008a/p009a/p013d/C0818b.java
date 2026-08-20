package p007b.p008a.p009a.p013d;

import com.discord.C5419R;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.d.b */
/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0818b extends AbstractC12240o implements Function1<C0822f.c, Unit> {
    public final /* synthetic */ C0822f this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0818b(C0822f c0822f) {
        super(1);
        this.this$0 = c0822f;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(C0822f.c cVar) {
        C0822f.c cVar2 = cVar;
        C12238m.checkNotNullParameter(cVar2, "storeState");
        C0822f c0822f = this.this$0;
        Objects.requireNonNull(c0822f);
        User user = cVar2.f335a;
        if (user == null) {
            c0822f.f330k.f27650k.onNext(new C0822f.b.a(C5419R.string.default_failure_to_perform_action_message));
        } else {
            int type = ModelUserRelationship.getType(cVar2.f336b);
            boolean z2 = type != 2;
            boolean z3 = type == 2;
            boolean z4 = type == 1;
            GuildMember guildMember = cVar2.f337c;
            c0822f.updateViewState(new C0822f.d.a(user, guildMember != null ? guildMember.getNick() : null, z2, z3, z4));
        }
        return Unit.f27425a;
    }
}
