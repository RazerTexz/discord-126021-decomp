package com.discord.widgets.guilds.profile;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGuildProfiles$GuildProfileData;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.GuildChannelsInfo;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import rx.functions.Func9;

/* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheetViewModel$Companion$observeStores$3<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Func9<Guild, StoreGuildProfiles$GuildProfileData, Boolean, MeUser, GuildMember, List<? extends Long>, List<Emoji>, Boolean, GuildChannelsInfo, WidgetGuildProfileSheetViewModel$StoreState> {
    public static final WidgetGuildProfileSheetViewModel$Companion$observeStores$3 INSTANCE = new WidgetGuildProfileSheetViewModel$Companion$observeStores$3();

    @Override // rx.functions.Func9
    public /* bridge */ /* synthetic */ WidgetGuildProfileSheetViewModel$StoreState call(Guild guild, StoreGuildProfiles$GuildProfileData storeGuildProfiles$GuildProfileData, Boolean bool, MeUser meUser, GuildMember guildMember, List<? extends Long> list, List<Emoji> list2, Boolean bool2, GuildChannelsInfo guildChannelsInfo) {
        return call2(guild, storeGuildProfiles$GuildProfileData, bool, meUser, guildMember, (List<Long>) list, list2, bool2, guildChannelsInfo);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGuildProfileSheetViewModel$StoreState call2(Guild guild, StoreGuildProfiles$GuildProfileData storeGuildProfiles$GuildProfileData, Boolean bool, MeUser meUser, GuildMember guildMember, List<Long> list, List<Emoji> list2, Boolean bool2, GuildChannelsInfo guildChannelsInfo) {
        m.checkNotNullExpressionValue(guildChannelsInfo, "guildChannelsInfo");
        m.checkNotNullExpressionValue(meUser, "me");
        m.checkNotNullExpressionValue(list, "restrictedGuildIds");
        boolean isDeveloperMode = StoreStream.Companion.getUserSettings().getIsDeveloperMode();
        List<Emoji> listEmptyList = list2 != null ? list2 : n.emptyList();
        m.checkNotNullExpressionValue(bool2, "isLurking");
        boolean zBooleanValue = bool2.booleanValue();
        m.checkNotNullExpressionValue(bool, "isUnread");
        return new WidgetGuildProfileSheetViewModel$StoreState(guild, storeGuildProfiles$GuildProfileData, guildChannelsInfo, meUser, guildMember, list, isDeveloperMode, listEmptyList, zBooleanValue, bool.booleanValue());
    }
}
