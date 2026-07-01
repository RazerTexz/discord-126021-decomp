package b.a.z.a.a;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import rx.Observable;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class q implements j0.k.b {
    public final /* synthetic */ long j;

    public /* synthetic */ q(long j) {
        this.j = j;
    }

    @Override // j0.k.b
    public final Object call(Object obj) {
        Channel channel = (Channel) obj;
        return channel == null ? new j0.l.e.k(null) : Observable.h(StoreStream.getGuilds().observeGuild(channel.getGuildId()), StoreStream.getUsers().observeMe(), StoreStream.getPermissions().observePermissionsForChannel(this.j), StoreStream.getGuilds().observeSortedRoles(channel.getGuildId()).Y(new s(channel)), new r(channel));
    }
}
