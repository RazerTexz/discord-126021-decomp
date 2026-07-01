package com.discord.utilities;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import d0.Tuples;
import d0.z.d.Intrinsics3;
import kotlin.Tuples2;

/* JADX INFO: renamed from: com.discord.utilities.PermissionOverwriteUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: PermissionOverwriteUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PermissionOverwriteUtils {
    public static final boolean allows(PermissionOverwrite permissionOverwrite, long j) {
        Intrinsics3.checkNotNullParameter(permissionOverwrite, "$this$allows");
        return (j & permissionOverwrite.getAllow()) != 0;
    }

    public static final Tuples2<Long, Long> computeAllowDenyUpdateBits(PermissionOverwrite permissionOverwrite, long j, boolean z2) {
        long allow = permissionOverwrite != null ? permissionOverwrite.getAllow() : 0L;
        long deny = permissionOverwrite != null ? permissionOverwrite.getDeny() : 0L;
        return z2 ? Tuples.to(Long.valueOf(allow | j), Long.valueOf((~j) & deny)) : Tuples.to(Long.valueOf(allow & (~j)), Long.valueOf(j | deny));
    }

    public static final boolean denies(PermissionOverwrite permissionOverwrite, long j) {
        Intrinsics3.checkNotNullParameter(permissionOverwrite, "$this$denies");
        return (j & permissionOverwrite.getDeny()) != 0;
    }

    public static final boolean deniesAccessTo(PermissionOverwrite permissionOverwrite, Channel channel) {
        Intrinsics3.checkNotNullParameter(permissionOverwrite, "$this$deniesAccessTo");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return denies(permissionOverwrite, Permission.VIEW_CHANNEL) || (ChannelUtils.w(channel) && denies(permissionOverwrite, Permission.CONNECT));
    }

    public static final boolean grantsAccessTo(PermissionOverwrite permissionOverwrite, Channel channel) {
        Intrinsics3.checkNotNullParameter(permissionOverwrite, "$this$grantsAccessTo");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return !deniesAccessTo(permissionOverwrite, channel) && ((ChannelUtils.u(channel) && allows(permissionOverwrite, Permission.VIEW_CHANNEL)) || (ChannelUtils.w(channel) && allows(permissionOverwrite, Permission.CONNECT)));
    }
}
