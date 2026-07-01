package com.discord.widgets.servers.member_verification;

import androidx.core.app.NotificationCompat;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGuildMemberVerificationForm$MemberVerificationFormData;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Func6;

/* JADX INFO: compiled from: WidgetMemberVerificationViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMemberVerificationViewModel$Companion$observeStores$1<T1, T2, T3, T4, T5, T6, R> implements Func6<MeUser, Guild, StoreGuildMemberVerificationForm$MemberVerificationFormData, Map<Long, ? extends String>, Map<Long, ? extends GuildRole>, Boolean, WidgetMemberVerificationViewModel$StoreState> {
    public final /* synthetic */ Guild $inviteGuild;

    public WidgetMemberVerificationViewModel$Companion$observeStores$1(Guild guild) {
        this.$inviteGuild = guild;
    }

    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ WidgetMemberVerificationViewModel$StoreState call(MeUser meUser, Guild guild, StoreGuildMemberVerificationForm$MemberVerificationFormData storeGuildMemberVerificationForm$MemberVerificationFormData, Map<Long, ? extends String> map, Map<Long, ? extends GuildRole> map2, Boolean bool) {
        return call2(meUser, guild, storeGuildMemberVerificationForm$MemberVerificationFormData, (Map<Long, String>) map, (Map<Long, GuildRole>) map2, bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetMemberVerificationViewModel$StoreState call2(MeUser meUser, Guild guild, StoreGuildMemberVerificationForm$MemberVerificationFormData storeGuildMemberVerificationForm$MemberVerificationFormData, Map<Long, String> map, Map<Long, GuildRole> map2, Boolean bool) {
        m.checkNotNullExpressionValue(meUser, "me");
        if (guild == null) {
            guild = this.$inviteGuild;
        }
        m.checkNotNullExpressionValue(map, "channels");
        m.checkNotNullExpressionValue(map2, "roles");
        m.checkNotNullExpressionValue(bool, "allowAnimatedEmojis");
        return new WidgetMemberVerificationViewModel$StoreState(meUser, guild, storeGuildMemberVerificationForm$MemberVerificationFormData, map, map2, bool.booleanValue());
    }
}
