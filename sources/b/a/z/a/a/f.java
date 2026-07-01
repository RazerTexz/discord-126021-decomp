package b.a.z.a.a;

import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import java.util.Map;
import rx.functions.Func2;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements Func2 {
    public final /* synthetic */ Map j;

    public /* synthetic */ f(Map map) {
        this.j = map;
    }

    @Override // rx.functions.Func2
    public final Object call(Object obj, Object obj2) {
        Map map = this.j;
        User user = (User) obj;
        User user2 = (User) obj2;
        return Integer.valueOf(GuildMember.compareUserNames(user, user2, (GuildMember) b.d.b.a.a.f(user, map), (GuildMember) b.d.b.a.a.f(user2, map)));
    }
}
