package com.discord.utilities.channel.permissions;

import com.discord.api.permission.PermissionOverwrite$Type;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ChannelPermissionsAddMemberUtils$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        PermissionOverwrite$Type.values();
        int[] iArr = new int[2];
        $EnumSwitchMapping$0 = iArr;
        iArr[PermissionOverwrite$Type.ROLE.ordinal()] = 1;
        iArr[PermissionOverwrite$Type.MEMBER.ordinal()] = 2;
    }
}
