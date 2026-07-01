package b.a.a.d;

import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import rx.functions.Func3;

/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e<T1, T2, T3, R> implements Func3<User, Integer, GuildMember, f$c> {
    public static final e a = new e();

    @Override // rx.functions.Func3
    public f$c call(User user, Integer num, GuildMember guildMember) {
        return new f$c(user, num, guildMember);
    }
}
