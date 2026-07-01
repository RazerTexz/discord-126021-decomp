package com.discord.widgets.channels.permissions;

import androidx.annotation.Nullable;
import b.a.z.a.a.e;
import b.a.z.a.a.i;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.channels.SimpleMembersAdapter$MemberItem;
import java.util.List;
import java.util.Locale;
import rx.Observable;

/* JADX INFO: loaded from: classes2.dex */
public class WidgetChannelSettingsPermissionsAddMember$Model {
    private final boolean canManage;
    private final Channel channel;
    private final List<SimpleMembersAdapter$MemberItem> memberItems;

    private WidgetChannelSettingsPermissionsAddMember$Model(MeUser meUser, Guild guild, Channel channel, Long l, List<SimpleMembersAdapter$MemberItem> list) {
        this.channel = channel;
        this.memberItems = list;
        boolean mfaEnabled = meUser.getMfaEnabled();
        this.canManage = guild.getOwnerId() == meUser.getId() || PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, l, mfaEnabled, guild.getMfaLevel()) || PermissionUtils.canAndIsElevated(8L, l, mfaEnabled, guild.getMfaLevel());
    }

    public static /* synthetic */ boolean access$000(WidgetChannelSettingsPermissionsAddMember$Model widgetChannelSettingsPermissionsAddMember$Model) {
        return widgetChannelSettingsPermissionsAddMember$Model.canManage;
    }

    public static /* synthetic */ Channel access$100(WidgetChannelSettingsPermissionsAddMember$Model widgetChannelSettingsPermissionsAddMember$Model) {
        return widgetChannelSettingsPermissionsAddMember$Model.channel;
    }

    public static /* synthetic */ List access$200(WidgetChannelSettingsPermissionsAddMember$Model widgetChannelSettingsPermissionsAddMember$Model) {
        return widgetChannelSettingsPermissionsAddMember$Model.memberItems;
    }

    public static Observable<WidgetChannelSettingsPermissionsAddMember$Model> get(long j, long j2, Observable<String> observable) {
        return StoreStream.getChannels().observeChannel(j2).Y(new e(j, j2, observable));
    }

    private static Observable<List<SimpleMembersAdapter$MemberItem>> getMemberItems(long j, @Nullable List<PermissionOverwrite> list, String str) {
        return StoreStream.getGuilds().observeComputed(j).Y(new i(list, str.toLowerCase(Locale.getDefault())));
    }

    private static boolean isValid(MeUser meUser, Guild guild, Channel channel, List<SimpleMembersAdapter$MemberItem> list) {
        return (channel == null || guild == null || meUser == null || list == null) ? false : true;
    }

    public static /* synthetic */ Observable lambda$null$0(long j, Channel channel, String str) {
        return getMemberItems(j, channel.v(), str);
    }

    public static /* synthetic */ WidgetChannelSettingsPermissionsAddMember$Model lambda$null$1(Channel channel, MeUser meUser, Guild guild, Long l, List list) {
        if (isValid(meUser, guild, channel, list)) {
            return new WidgetChannelSettingsPermissionsAddMember$Model(meUser, guild, channel, l, list);
        }
        return null;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof WidgetChannelSettingsPermissionsAddMember$Model;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WidgetChannelSettingsPermissionsAddMember$Model)) {
            return false;
        }
        WidgetChannelSettingsPermissionsAddMember$Model widgetChannelSettingsPermissionsAddMember$Model = (WidgetChannelSettingsPermissionsAddMember$Model) obj;
        if (!widgetChannelSettingsPermissionsAddMember$Model.canEqual(this) || this.canManage != widgetChannelSettingsPermissionsAddMember$Model.canManage) {
            return false;
        }
        Channel channel = this.channel;
        Channel channel2 = widgetChannelSettingsPermissionsAddMember$Model.channel;
        if (channel != null ? !channel.equals(channel2) : channel2 != null) {
            return false;
        }
        List<SimpleMembersAdapter$MemberItem> list = this.memberItems;
        List<SimpleMembersAdapter$MemberItem> list2 = widgetChannelSettingsPermissionsAddMember$Model.memberItems;
        return list != null ? list.equals(list2) : list2 == null;
    }

    public int hashCode() {
        int i = this.canManage ? 79 : 97;
        Channel channel = this.channel;
        int iHashCode = ((i + 59) * 59) + (channel == null ? 43 : channel.hashCode());
        List<SimpleMembersAdapter$MemberItem> list = this.memberItems;
        return (iHashCode * 59) + (list != null ? list.hashCode() : 43);
    }

    public String toString() {
        StringBuilder sbU = a.U("WidgetChannelSettingsPermissionsAddMember.Model(channel=");
        sbU.append(this.channel);
        sbU.append(", memberItems=");
        sbU.append(this.memberItems);
        sbU.append(", canManage=");
        return a.O(sbU, this.canManage, ")");
    }
}
