package b.a.z.a.a;

import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.widgets.channels.SimpleMembersAdapter$MemberItem;
import java.util.Map;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements j0.k.b {
    public final /* synthetic */ Map j;

    public /* synthetic */ d(Map map) {
        this.j = map;
    }

    @Override // j0.k.b
    public final Object call(Object obj) {
        User user = (User) obj;
        return new SimpleMembersAdapter$MemberItem(user, (GuildMember) b.d.b.a.a.f(user, this.j));
    }
}
