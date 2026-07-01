package com.discord.widgets.servers.community;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Func5;

/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunityViewModel$Companion$observeStoreState$1$1<T1, T2, T3, T4, T5, R> implements Func5<MeUser, Long, Map<Long, ? extends GuildRole>, Channel, Channel, WidgetServerSettingsEnableCommunityViewModel$StoreState$Valid> {
    public final /* synthetic */ Guild $guild;

    public WidgetServerSettingsEnableCommunityViewModel$Companion$observeStoreState$1$1(Guild guild) {
        this.$guild = guild;
    }

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ WidgetServerSettingsEnableCommunityViewModel$StoreState$Valid call(MeUser meUser, Long l, Map<Long, ? extends GuildRole> map, Channel channel, Channel channel2) {
        return call2(meUser, l, (Map<Long, GuildRole>) map, channel, channel2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsEnableCommunityViewModel$StoreState$Valid call2(MeUser meUser, Long l, Map<Long, GuildRole> map, Channel channel, Channel channel2) {
        Guild guild = this.$guild;
        m.checkNotNullExpressionValue(meUser, "me");
        return new WidgetServerSettingsEnableCommunityViewModel$StoreState$Valid(guild, meUser, l, map, channel, channel2);
    }
}
