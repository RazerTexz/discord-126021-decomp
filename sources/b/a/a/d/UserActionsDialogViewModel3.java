package b.a.a.d;

import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreGuilds;
import d0.t.SetsJVM;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import rx.Observable;

/* JADX INFO: renamed from: b.a.a.d.d, reason: use source file name */
/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserActionsDialogViewModel3<T, R> implements Func1<Channel, Observable<? extends GuildMember>> {
    public final /* synthetic */ StoreGuilds j;
    public final /* synthetic */ long k;

    public UserActionsDialogViewModel3(StoreGuilds storeGuilds, long j) {
        this.j = storeGuilds;
        this.k = j;
    }

    @Override // j0.k.Func1
    public Observable<? extends GuildMember> call(Channel channel) {
        Channel channel2 = channel;
        return channel2 != null ? this.j.observeComputed(channel2.getGuildId(), SetsJVM.setOf(Long.valueOf(this.k))).G(new UserActionsDialogViewModel2(this, channel2)) : new ScalarSynchronousObservable(null);
    }
}
