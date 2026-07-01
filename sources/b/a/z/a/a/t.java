package b.a.z.a.a;

import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class t implements j0.k.b {
    public final /* synthetic */ Channel j;

    public /* synthetic */ t(Channel channel) {
        this.j = channel;
    }

    @Override // j0.k.b
    public final Object call(Object obj) {
        Channel channel = this.j;
        GuildRole guildRole = (GuildRole) obj;
        if (channel.v() == null) {
            return Boolean.TRUE;
        }
        for (int i = 0; i < channel.v().size(); i++) {
            if (channel.v().get(i).e() == guildRole.getId()) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
