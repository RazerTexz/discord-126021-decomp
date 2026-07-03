package p007b.p008a.p009a.p013d;

import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreGuilds;
import p507d0.p580t.C12146m0;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;

/* JADX INFO: renamed from: b.a.a.d.d */
/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0820d<T, R> implements InterfaceC12589b<Channel, Observable<? extends GuildMember>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ StoreGuilds f326j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ long f327k;

    public C0820d(StoreGuilds storeGuilds, long j) {
        this.f326j = storeGuilds;
        this.f327k = j;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Observable<? extends GuildMember> call(Channel channel) {
        Channel channel2 = channel;
        return channel2 != null ? this.f326j.observeComputed(channel2.getGuildId(), C12146m0.setOf(Long.valueOf(this.f327k))).m11083G(new C0819c(this, channel2)) : new C12721k(null);
    }
}
