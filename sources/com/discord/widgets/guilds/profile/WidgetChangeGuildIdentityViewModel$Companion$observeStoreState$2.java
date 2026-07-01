package com.discord.widgets.guilds.profile;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.utilities.channel.GuildChannelsInfo;
import d0.z.d.m;
import rx.functions.Func4;

/* JADX INFO: compiled from: WidgetChangeGuildIdentityViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeGuildIdentityViewModel$Companion$observeStoreState$2<T1, T2, T3, T4, R> implements Func4<GuildChannelsInfo, Guild, MeUser, GuildMember, WidgetChangeGuildIdentityViewModel$StoreState> {
    public static final WidgetChangeGuildIdentityViewModel$Companion$observeStoreState$2 INSTANCE = new WidgetChangeGuildIdentityViewModel$Companion$observeStoreState$2();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetChangeGuildIdentityViewModel$StoreState call(GuildChannelsInfo guildChannelsInfo, Guild guild, MeUser meUser, GuildMember guildMember) {
        return call2(guildChannelsInfo, guild, meUser, guildMember);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChangeGuildIdentityViewModel$StoreState call2(GuildChannelsInfo guildChannelsInfo, Guild guild, MeUser meUser, GuildMember guildMember) {
        m.checkNotNullExpressionValue(meUser, "meUser");
        m.checkNotNullExpressionValue(guildChannelsInfo, "guildChannelsInfo");
        return new WidgetChangeGuildIdentityViewModel$StoreState(guild, meUser, guildMember, guildChannelsInfo);
    }
}
