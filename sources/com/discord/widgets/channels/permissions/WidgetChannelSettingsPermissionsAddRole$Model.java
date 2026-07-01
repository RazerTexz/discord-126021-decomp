package com.discord.widgets.channels.permissions;

import b.a.d.n;
import b.a.z.a.a.q;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.channels.SimpleRolesAdapter$RoleItem;
import java.util.List;
import rx.Observable;

/* JADX INFO: loaded from: classes2.dex */
public class WidgetChannelSettingsPermissionsAddRole$Model {
    private final boolean canManage;
    private final Channel channel;
    private final List<SimpleRolesAdapter$RoleItem> roleItems;

    private WidgetChannelSettingsPermissionsAddRole$Model(MeUser meUser, Guild guild, Channel channel, Long l, List<SimpleRolesAdapter$RoleItem> list) {
        this.channel = channel;
        this.roleItems = list;
        boolean mfaEnabled = meUser.getMfaEnabled();
        this.canManage = guild.getOwnerId() == meUser.getId() || PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, l, mfaEnabled, guild.getMfaLevel()) || PermissionUtils.canAndIsElevated(8L, l, mfaEnabled, guild.getMfaLevel());
    }

    public static /* synthetic */ boolean access$000(WidgetChannelSettingsPermissionsAddRole$Model widgetChannelSettingsPermissionsAddRole$Model) {
        return widgetChannelSettingsPermissionsAddRole$Model.canManage;
    }

    public static /* synthetic */ List access$100(WidgetChannelSettingsPermissionsAddRole$Model widgetChannelSettingsPermissionsAddRole$Model) {
        return widgetChannelSettingsPermissionsAddRole$Model.roleItems;
    }

    public static /* synthetic */ Channel access$200(WidgetChannelSettingsPermissionsAddRole$Model widgetChannelSettingsPermissionsAddRole$Model) {
        return widgetChannelSettingsPermissionsAddRole$Model.channel;
    }

    public static Observable<WidgetChannelSettingsPermissionsAddRole$Model> get(long j) {
        return StoreStream.getChannels().observeChannel(j).Y(new q(j)).k(n.j);
    }

    private static boolean isValid(Guild guild, Channel channel) {
        return (channel == null || guild == null) ? false : true;
    }

    public static /* synthetic */ WidgetChannelSettingsPermissionsAddRole$Model lambda$null$2(Channel channel, Guild guild, MeUser meUser, Long l, List list) {
        if (isValid(guild, channel)) {
            return new WidgetChannelSettingsPermissionsAddRole$Model(meUser, guild, channel, l, list);
        }
        return null;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof WidgetChannelSettingsPermissionsAddRole$Model;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WidgetChannelSettingsPermissionsAddRole$Model)) {
            return false;
        }
        WidgetChannelSettingsPermissionsAddRole$Model widgetChannelSettingsPermissionsAddRole$Model = (WidgetChannelSettingsPermissionsAddRole$Model) obj;
        if (!widgetChannelSettingsPermissionsAddRole$Model.canEqual(this) || this.canManage != widgetChannelSettingsPermissionsAddRole$Model.canManage) {
            return false;
        }
        Channel channel = this.channel;
        Channel channel2 = widgetChannelSettingsPermissionsAddRole$Model.channel;
        if (channel != null ? !channel.equals(channel2) : channel2 != null) {
            return false;
        }
        List<SimpleRolesAdapter$RoleItem> list = this.roleItems;
        List<SimpleRolesAdapter$RoleItem> list2 = widgetChannelSettingsPermissionsAddRole$Model.roleItems;
        return list != null ? list.equals(list2) : list2 == null;
    }

    public int hashCode() {
        int i = this.canManage ? 79 : 97;
        Channel channel = this.channel;
        int iHashCode = ((i + 59) * 59) + (channel == null ? 43 : channel.hashCode());
        List<SimpleRolesAdapter$RoleItem> list = this.roleItems;
        return (iHashCode * 59) + (list != null ? list.hashCode() : 43);
    }

    public String toString() {
        StringBuilder sbU = a.U("WidgetChannelSettingsPermissionsAddRole.Model(channel=");
        sbU.append(this.channel);
        sbU.append(", roleItems=");
        sbU.append(this.roleItems);
        sbU.append(", canManage=");
        return a.O(sbU, this.canManage, ")");
    }
}
