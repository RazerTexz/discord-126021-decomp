package b.a.a.d;

import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import j0.k.Func1;
import java.util.Map;

/* JADX INFO: renamed from: b.a.a.d.c, reason: use source file name */
/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserActionsDialogViewModel2<T, R> implements Func1<Map<Long, ? extends GuildMember>, GuildMember> {
    public final /* synthetic */ UserActionsDialogViewModel3 j;

    public UserActionsDialogViewModel2(UserActionsDialogViewModel3 userActionsDialogViewModel3, Channel channel) {
        this.j = userActionsDialogViewModel3;
    }

    @Override // j0.k.Func1
    public GuildMember call(Map<Long, ? extends GuildMember> map) {
        return map.get(Long.valueOf(this.j.k));
    }
}
