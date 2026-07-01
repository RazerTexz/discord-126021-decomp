package com.discord.widgets.settings.profile;

import androidx.core.app.NotificationCompat;
import com.discord.api.user.UserProfile;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.MeUser$Companion;
import com.discord.utilities.channel.GuildChannelsInfo;
import d0.z.d.m;
import rx.functions.Func3;

/* JADX INFO: compiled from: EditUserOrGuildMemberProfileViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsUserProfileViewModel$Companion$observeStoreState$2$1<T1, T2, T3, R> implements Func3<UserProfile, GuildMember, GuildChannelsInfo, SettingsUserProfileViewModel$StoreState> {
    public final /* synthetic */ Guild $guild;
    public final /* synthetic */ MeUser $meUser;

    public SettingsUserProfileViewModel$Companion$observeStoreState$2$1(MeUser meUser, Guild guild) {
        this.$meUser = meUser;
        this.$guild = guild;
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ SettingsUserProfileViewModel$StoreState call(UserProfile userProfile, GuildMember guildMember, GuildChannelsInfo guildChannelsInfo) {
        return call2(userProfile, guildMember, guildChannelsInfo);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final SettingsUserProfileViewModel$StoreState call2(UserProfile userProfile, GuildMember guildMember, GuildChannelsInfo guildChannelsInfo) {
        MeUser$Companion meUser$Companion = MeUser.Companion;
        MeUser meUser = this.$meUser;
        m.checkNotNullExpressionValue(meUser, "meUser");
        MeUser meUserMerge = meUser$Companion.merge(meUser, userProfile.getUser());
        Guild guild = this.$guild;
        m.checkNotNullExpressionValue(userProfile, "userProfile");
        m.checkNotNullExpressionValue(guildChannelsInfo, "guildChannelsInfo");
        return new SettingsUserProfileViewModel$StoreState(meUserMerge, guild, userProfile, guildMember, guildChannelsInfo);
    }
}
