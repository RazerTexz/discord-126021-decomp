package com.discord.utilities;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import d0.o;
import d0.z.d.m;
import kotlin.Pair;

/* JADX INFO: compiled from: PermissionOverwriteUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PermissionOverwriteUtilsKt {
    public static final boolean allows(PermissionOverwrite permissionOverwrite, long j) {
        m.checkNotNullParameter(permissionOverwrite, "$this$allows");
        return (j & permissionOverwrite.getAllow()) != 0;
    }

    public static final Pair<Long, Long> computeAllowDenyUpdateBits(PermissionOverwrite permissionOverwrite, long j, boolean z2) {
        long allow = permissionOverwrite != null ? permissionOverwrite.getAllow() : 0L;
        long deny = permissionOverwrite != null ? permissionOverwrite.getDeny() : 0L;
        return z2 ? o.to(Long.valueOf(allow | j), Long.valueOf((~j) & deny)) : o.to(Long.valueOf(allow & (~j)), Long.valueOf(j | deny));
    }

    public static final boolean denies(PermissionOverwrite permissionOverwrite, long j) {
        m.checkNotNullParameter(permissionOverwrite, "$this$denies");
        return (j & permissionOverwrite.getDeny()) != 0;
    }

    public static final boolean deniesAccessTo(PermissionOverwrite permissionOverwrite, Channel channel) {
        m.checkNotNullParameter(permissionOverwrite, "$this$deniesAccessTo");
        m.checkNotNullParameter(channel, "channel");
        return denies(permissionOverwrite, Permission.VIEW_CHANNEL) || (ChannelUtils.w(channel) && denies(permissionOverwrite, Permission.CONNECT));
    }

    public static final boolean grantsAccessTo(PermissionOverwrite permissionOverwrite, Channel channel) {
        m.checkNotNullParameter(permissionOverwrite, "$this$grantsAccessTo");
        m.checkNotNullParameter(channel, "channel");
        return !deniesAccessTo(permissionOverwrite, channel) && ((ChannelUtils.u(channel) && allows(permissionOverwrite, Permission.VIEW_CHANNEL)) || (ChannelUtils.w(channel) && allows(permissionOverwrite, Permission.CONNECT)));
    }
}
