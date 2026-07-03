package com.discord.utilities;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import kotlin.Pair;
import p507d0.C12116o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: PermissionOverwriteUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PermissionOverwriteUtilsKt {
    public static final boolean allows(PermissionOverwrite permissionOverwrite, long j) {
        C12238m.checkNotNullParameter(permissionOverwrite, "$this$allows");
        return (j & permissionOverwrite.getAllow()) != 0;
    }

    public static final Pair<Long, Long> computeAllowDenyUpdateBits(PermissionOverwrite permissionOverwrite, long j, boolean z2) {
        long allow = permissionOverwrite != null ? permissionOverwrite.getAllow() : 0L;
        long deny = permissionOverwrite != null ? permissionOverwrite.getDeny() : 0L;
        return z2 ? C12116o.m10073to(Long.valueOf(allow | j), Long.valueOf((~j) & deny)) : C12116o.m10073to(Long.valueOf(allow & (~j)), Long.valueOf(j | deny));
    }

    public static final boolean denies(PermissionOverwrite permissionOverwrite, long j) {
        C12238m.checkNotNullParameter(permissionOverwrite, "$this$denies");
        return (j & permissionOverwrite.getDeny()) != 0;
    }

    public static final boolean deniesAccessTo(PermissionOverwrite permissionOverwrite, Channel channel) {
        C12238m.checkNotNullParameter(permissionOverwrite, "$this$deniesAccessTo");
        C12238m.checkNotNullParameter(channel, "channel");
        return denies(permissionOverwrite, Permission.VIEW_CHANNEL) || (ChannelUtils.m7699w(channel) && denies(permissionOverwrite, Permission.CONNECT));
    }

    public static final boolean grantsAccessTo(PermissionOverwrite permissionOverwrite, Channel channel) {
        C12238m.checkNotNullParameter(permissionOverwrite, "$this$grantsAccessTo");
        C12238m.checkNotNullParameter(channel, "channel");
        return !deniesAccessTo(permissionOverwrite, channel) && ((ChannelUtils.m7697u(channel) && allows(permissionOverwrite, Permission.VIEW_CHANNEL)) || (ChannelUtils.m7699w(channel) && allows(permissionOverwrite, Permission.CONNECT)));
    }
}
