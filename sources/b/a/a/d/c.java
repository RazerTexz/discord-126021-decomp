package b.a.a.d;

import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import java.util.Map;

/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c<T, R> implements j0.k.b<Map<Long, ? extends GuildMember>, GuildMember> {
    public final /* synthetic */ d j;

    public c(d dVar, Channel channel) {
        this.j = dVar;
    }

    @Override // j0.k.b
    public GuildMember call(Map<Long, ? extends GuildMember> map) {
        return map.get(Long.valueOf(this.j.k));
    }
}
