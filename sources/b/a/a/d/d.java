package b.a.a.d;

import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreGuilds;
import d0.t.m0;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d<T, R> implements j0.k.b<Channel, Observable<? extends GuildMember>> {
    public final /* synthetic */ StoreGuilds j;
    public final /* synthetic */ long k;

    public d(StoreGuilds storeGuilds, long j) {
        this.j = storeGuilds;
        this.k = j;
    }

    @Override // j0.k.b
    public Observable<? extends GuildMember> call(Channel channel) {
        Channel channel2 = channel;
        return channel2 != null ? this.j.observeComputed(channel2.getGuildId(), m0.setOf(Long.valueOf(this.k))).G(new c(this, channel2)) : new k(null);
    }
}
