package com.discord.widgets.guilds.profile;

import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import d0.t.m;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChangeGuildIdentityViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeGuildIdentityViewModel$Companion$observeStoreState$1<T, R> implements b<MeUser, Observable<? extends GuildMember>> {
    public final /* synthetic */ long $guildId;

    public WidgetChangeGuildIdentityViewModel$Companion$observeStoreState$1(long j) {
        this.$guildId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends GuildMember> call(MeUser meUser) {
        return call2(meUser);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends GuildMember> call2(MeUser meUser) {
        return StoreStream.Companion.getGuilds().observeComputed(this.$guildId, m.listOf(Long.valueOf(meUser.getId()))).G(new WidgetChangeGuildIdentityViewModel$Companion$observeStoreState$1$1(meUser));
    }
}
