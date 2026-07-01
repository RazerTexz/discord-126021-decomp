package com.discord.widgets.channels.list;

import android.content.Context;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.permissions.PermissionUtils;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelsListItemChannelActions$Model {
    public static final WidgetChannelsListItemChannelActions$Model$Companion Companion = new WidgetChannelsListItemChannelActions$Model$Companion(null);
    private final boolean canCreateInstantInvite;
    private final boolean canManageChannel;
    private final Channel channel;
    private final Guild guild;
    private final boolean isDeveloper;
    private final boolean isMuted;
    private final Long permissions;

    public WidgetChannelsListItemChannelActions$Model(Channel channel, Guild guild, Long l, boolean z2) {
        m.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.guild = guild;
        this.permissions = l;
        this.isMuted = z2;
        this.isDeveloper = StoreStream.Companion.getUserSettings().getIsDeveloperMode();
        this.canManageChannel = PermissionUtils.can(16L, l) || ChannelUtils.z(channel);
        this.canCreateInstantInvite = PermissionUtils.can(1L, l);
    }

    public static /* synthetic */ WidgetChannelsListItemChannelActions$Model copy$default(WidgetChannelsListItemChannelActions$Model widgetChannelsListItemChannelActions$Model, Channel channel, Guild guild, Long l, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = widgetChannelsListItemChannelActions$Model.channel;
        }
        if ((i & 2) != 0) {
            guild = widgetChannelsListItemChannelActions$Model.guild;
        }
        if ((i & 4) != 0) {
            l = widgetChannelsListItemChannelActions$Model.permissions;
        }
        if ((i & 8) != 0) {
            z2 = widgetChannelsListItemChannelActions$Model.isMuted;
        }
        return widgetChannelsListItemChannelActions$Model.copy(channel, guild, l, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getPermissions() {
        return this.permissions;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsMuted() {
        return this.isMuted;
    }

    public final WidgetChannelsListItemChannelActions$Model copy(Channel channel, Guild guild, Long permissions, boolean isMuted) {
        m.checkNotNullParameter(channel, "channel");
        return new WidgetChannelsListItemChannelActions$Model(channel, guild, permissions, isMuted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelsListItemChannelActions$Model)) {
            return false;
        }
        WidgetChannelsListItemChannelActions$Model widgetChannelsListItemChannelActions$Model = (WidgetChannelsListItemChannelActions$Model) other;
        return m.areEqual(this.channel, widgetChannelsListItemChannelActions$Model.channel) && m.areEqual(this.guild, widgetChannelsListItemChannelActions$Model.guild) && m.areEqual(this.permissions, widgetChannelsListItemChannelActions$Model.permissions) && this.isMuted == widgetChannelsListItemChannelActions$Model.isMuted;
    }

    public final boolean getCanCreateInstantInvite() {
        return this.canCreateInstantInvite;
    }

    public final boolean getCanManageChannel() {
        return this.canManageChannel;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final CharSequence getMuteChannelText(Context context, Channel channel) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(channel, "channel");
        if (this.isMuted && ChannelUtils.k(channel)) {
            return b.h(context, 2131896588, new Object[0], null, 4);
        }
        if (this.isMuted || !ChannelUtils.k(channel)) {
            return this.isMuted ? b.h(context, 2131896590, new Object[0], null, 4) : b.h(context, 2131893140, new Object[0], null, 4);
        }
        return b.h(context, 2131893138, new Object[0], null, 4);
    }

    public final int getMuteIconResId(Context context) {
        m.checkNotNullParameter(context, "context");
        return DrawableCompat.getThemedDrawableRes$default(context, this.isMuted ? 2130969476 : 2130969475, 0, 2, (Object) null);
    }

    public final Long getPermissions() {
        return this.permissions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Guild guild = this.guild;
        int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
        Long l = this.permissions;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        boolean z2 = this.isMuted;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode3 + r1;
    }

    /* JADX INFO: renamed from: isDeveloper, reason: from getter */
    public final boolean getIsDeveloper() {
        return this.isDeveloper;
    }

    public final boolean isMuted() {
        return this.isMuted;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(channel=");
        sbU.append(this.channel);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", permissions=");
        sbU.append(this.permissions);
        sbU.append(", isMuted=");
        return a.O(sbU, this.isMuted, ")");
    }
}
