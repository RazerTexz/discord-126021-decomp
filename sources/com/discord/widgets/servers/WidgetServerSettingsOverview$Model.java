package com.discord.widgets.servers;

import com.discord.api.channel.Channel;
import com.discord.api.guild.preview.GuildPreview;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGuildProfiles$GuildProfileData;
import com.discord.utilities.permissions.PermissionUtils;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview$Model {
    public static final WidgetServerSettingsOverview$Model$Companion Companion = new WidgetServerSettingsOverview$Model$Companion(null);
    private final Channel afkChannelModel;
    private final Integer approximateMemberCount;
    private final boolean canManage;
    private final Guild guild;
    private final boolean isAboveNotifyAllSize;
    private final boolean isOwner;
    private final Channel systemChannelModel;

    public WidgetServerSettingsOverview$Model(Guild guild, MeUser meUser, Channel channel, Channel channel2, Long l, StoreGuildProfiles$GuildProfileData storeGuildProfiles$GuildProfileData) {
        GuildPreview data;
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(meUser, "me");
        this.guild = guild;
        this.afkChannelModel = channel;
        this.systemChannelModel = channel2;
        boolean zIsOwner = guild.isOwner(meUser.getId());
        this.isOwner = zIsOwner;
        boolean z2 = false;
        this.canManage = zIsOwner || PermissionUtils.canAndIsElevated(32L, l, meUser.getMfaEnabled(), guild.getMfaLevel());
        Integer approximateMemberCount = (storeGuildProfiles$GuildProfileData == null || (data = storeGuildProfiles$GuildProfileData.getData()) == null) ? null : data.getApproximateMemberCount();
        this.approximateMemberCount = approximateMemberCount;
        if (approximateMemberCount != null && approximateMemberCount.intValue() > 2500) {
            z2 = true;
        }
        this.isAboveNotifyAllSize = z2;
    }

    public final Channel getAfkChannelModel() {
        return this.afkChannelModel;
    }

    public final boolean getCanManage() {
        return this.canManage;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final Channel getSystemChannelModel() {
        return this.systemChannelModel;
    }

    /* JADX INFO: renamed from: isAboveNotifyAllSize, reason: from getter */
    public final boolean getIsAboveNotifyAllSize() {
        return this.isAboveNotifyAllSize;
    }

    /* JADX INFO: renamed from: isOwner, reason: from getter */
    public final boolean getIsOwner() {
        return this.isOwner;
    }
}
