package com.discord.widgets.servers.member_verification;

import androidx.core.app.NotificationCompat;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.guild.Guild;
import rx.functions.Func2;

/* JADX INFO: compiled from: MemberVerificationSuccessViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationSuccessViewModel$Companion$observeStores$1<T1, T2, R> implements Func2<GuildJoinRequest, Guild, MemberVerificationSuccessViewModel$StoreState> {
    public static final MemberVerificationSuccessViewModel$Companion$observeStores$1 INSTANCE = new MemberVerificationSuccessViewModel$Companion$observeStores$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ MemberVerificationSuccessViewModel$StoreState call(GuildJoinRequest guildJoinRequest, Guild guild) {
        return call2(guildJoinRequest, guild);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final MemberVerificationSuccessViewModel$StoreState call2(GuildJoinRequest guildJoinRequest, Guild guild) {
        return new MemberVerificationSuccessViewModel$StoreState(guildJoinRequest != null ? guildJoinRequest.getLastSeen() : null, guild != null ? guild.getName() : null);
    }
}
