package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGuildProfiles$GuildProfileData;
import d0.z.d.m;
import rx.functions.Func5;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview$Model$Companion$get$1$1<T1, T2, T3, T4, T5, R> implements Func5<MeUser, Channel, Channel, Long, StoreGuildProfiles$GuildProfileData, WidgetServerSettingsOverview$Model> {
    public final /* synthetic */ Guild $guild;

    public WidgetServerSettingsOverview$Model$Companion$get$1$1(Guild guild) {
        this.$guild = guild;
    }

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ WidgetServerSettingsOverview$Model call(MeUser meUser, Channel channel, Channel channel2, Long l, StoreGuildProfiles$GuildProfileData storeGuildProfiles$GuildProfileData) {
        return call2(meUser, channel, channel2, l, storeGuildProfiles$GuildProfileData);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsOverview$Model call2(MeUser meUser, Channel channel, Channel channel2, Long l, StoreGuildProfiles$GuildProfileData storeGuildProfiles$GuildProfileData) {
        Guild guild = this.$guild;
        m.checkNotNullExpressionValue(meUser, "me");
        return new WidgetServerSettingsOverview$Model(guild, meUser, channel, channel2, l, storeGuildProfiles$GuildProfileData);
    }
}
