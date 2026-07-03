package p007b.p008a.p009a.p013d;

import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import java.util.Map;
import p637j0.p641k.InterfaceC12589b;

/* JADX INFO: renamed from: b.a.a.d.c */
/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0819c<T, R> implements InterfaceC12589b<Map<Long, ? extends GuildMember>, GuildMember> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C0820d f325j;

    public C0819c(C0820d c0820d, Channel channel) {
        this.f325j = c0820d;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public GuildMember call(Map<Long, ? extends GuildMember> map) {
        return map.get(Long.valueOf(this.f325j.f327k));
    }
}
