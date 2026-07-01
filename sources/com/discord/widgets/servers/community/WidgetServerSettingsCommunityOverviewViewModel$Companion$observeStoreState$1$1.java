package com.discord.widgets.servers.community;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import d0.z.d.m;
import rx.functions.Func4;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityOverviewViewModel$Companion$observeStoreState$1$1<T1, T2, T3, T4, R> implements Func4<MeUser, Long, Channel, Channel, WidgetServerSettingsCommunityOverviewViewModel$StoreState$Valid> {
    public final /* synthetic */ Guild $guild;

    public WidgetServerSettingsCommunityOverviewViewModel$Companion$observeStoreState$1$1(Guild guild) {
        this.$guild = guild;
    }

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel$StoreState$Valid call(MeUser meUser, Long l, Channel channel, Channel channel2) {
        return call2(meUser, l, channel, channel2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsCommunityOverviewViewModel$StoreState$Valid call2(MeUser meUser, Long l, Channel channel, Channel channel2) {
        Guild guild = this.$guild;
        m.checkNotNullExpressionValue(meUser, "me");
        return new WidgetServerSettingsCommunityOverviewViewModel$StoreState$Valid(guild, meUser, l, channel, channel2);
    }
}
