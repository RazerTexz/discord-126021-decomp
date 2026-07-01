package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGlobalSearchGuildsModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsModel$Item$Companion {
    private WidgetGlobalSearchGuildsModel$Item$Companion() {
    }

    public final WidgetGlobalSearchGuildsModel$Item createDirectMessage$app_productionGoogleRelease(Channel channel, int mentionCount) {
        m.checkNotNullParameter(channel, "channel");
        return new WidgetGlobalSearchGuildsModel$Item(2, channel.getId(), channel, null, mentionCount, false, false, false, 0, 488, null);
    }

    public final WidgetGlobalSearchGuildsModel$Item createDivider$app_productionGoogleRelease() {
        return new WidgetGlobalSearchGuildsModel$Item(1, 1L, null, null, 0, false, false, false, 0, 508, null);
    }

    public final WidgetGlobalSearchGuildsModel$Item createGuild$app_productionGoogleRelease(Guild guild, int mentionCount, boolean hasUnread, boolean isSelected, boolean connectedToVoice) {
        m.checkNotNullParameter(guild, "guild");
        return new WidgetGlobalSearchGuildsModel$Item(3, guild.getId(), null, guild, mentionCount, hasUnread, isSelected, connectedToVoice, 0, 260, null);
    }

    public /* synthetic */ WidgetGlobalSearchGuildsModel$Item$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
